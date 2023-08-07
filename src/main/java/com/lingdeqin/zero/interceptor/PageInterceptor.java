package com.lingdeqin.zero.interceptor;

import com.lingdeqin.zero.dto.PageDto;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.Configuration;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ling
 * 问题： 会使bind标签失效，以后再看
 */
@Component()
@Intercepts(@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class}))
public class PageInterceptor extends BaseInterceptor{

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        StatementHandler statementHandler = getStatementHandler(invocation);
        // 反射工具类
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        if (sqlCommandType.ordinal() != SqlCommandType.SELECT.ordinal()){
            return invocation.proceed();
        }

        BoundSql boundSql = statementHandler.getBoundSql();
        Object parameterObject = boundSql.getParameterObject();
        PageDto pageDto = getPageDto(parameterObject);

        if (pageDto == null)
            return invocation.proceed();

        if (pageDto.getIsCount()) {
            int total = count(invocation, mappedStatement, boundSql);
            pageDto.setTotal(total);
        }

        String sql = boundSql.getSql();
        String limitSql = String.format("select * from (%s) t limit ?,?", sql);

        // 修改sql
        metaObject.setValue("delegate.boundSql.sql", limitSql);
        // 预编译sql
        PreparedStatement ps = (PreparedStatement) invocation.proceed();
        // 获取参数个数
        int parameterCount = ps.getParameterMetaData().getParameterCount();
        // 设置新加的参数
        ps.setInt(parameterCount - 1, (pageDto.getCurrentPage() - 1) * pageDto.getPageSize());
        ps.setInt(parameterCount, pageDto.getPageSize());

        return ps;
    }


    private StatementHandler getStatementHandler(Invocation invocation) {

        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
        Object object = null;
        // 经过多个拦截器时
        while (metaStatementHandler.hasGetter("h")) {
            object = metaStatementHandler.getValue("h.target");
            metaStatementHandler = SystemMetaObject.forObject(object);
        }
        if (object == null) {
            return statementHandler;
        }
        return (StatementHandler) object;
    }


    private PageDto getPageDto(Object parameterObject) {
        if (parameterObject == null) {
            return null;
        }
        PageDto pageDto = null;
        // 只有一个参数PageDto时
        if (parameterObject instanceof PageDto) {
            pageDto = (PageDto) parameterObject;
        }
        // 参数是map时
        else if (parameterObject instanceof Map) {
            Map<String, Object> parameterMap = (Map<String, Object>) parameterObject;
            for (Map.Entry<String, Object> entry : parameterMap.entrySet()) {
                if (entry.getValue() instanceof PageDto) {
                    return (PageDto) entry.getValue();
                }
            }
        }
        return pageDto;
    }


    // 获取总数
    private int count(Invocation invocation, MappedStatement mappedStatement, BoundSql boundSql) {

        Configuration configuration = mappedStatement.getConfiguration();
        String sql = boundSql.getSql();
        String countSql = String.format("select count(*) as total from (%s) t", sql);

        Connection conn = (Connection) invocation.getArgs()[0];
        AtomicInteger total = new AtomicInteger();
        select(countSql, conn, mappedStatement, configuration, boundSql.getParameterMappings(), boundSql.getParameterObject(),
                new QueryCallback() {
                    @Override
                    public void after(ResultSet resultSet) {
                        try {
                            if (resultSet.next()){
                                total.set(resultSet.getInt("total"));
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
        return total.get();
    }

}

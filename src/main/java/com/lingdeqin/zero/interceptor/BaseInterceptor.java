package com.lingdeqin.zero.interceptor;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author ling
 */
public abstract class BaseInterceptor implements Interceptor {

    Boolean select(String sql, Connection connection, MappedStatement mappedStatement, Configuration configuration, List<ParameterMapping> parameterMappingList, Object parameterObject, QueryCallback queryCallback){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            BoundSql boundSql = new BoundSql(configuration, sql, parameterMappingList, parameterObject);
            ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
            parameterHandler.setParameters(ps);
            ResultSet resultSet = ps.executeQuery();
            queryCallback.after(resultSet);
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (ps != null)
                try {
                    ps.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
        }
        return false;
    }

//    @NoArgsConstructor
//    @AllArgsConstructor
//    public class QueryResult{
//        private ResultSet resultSet;
//        void after(AfterCallback afterCallback){
//            afterCallback.after(this.resultSet);
//        }
//    }

    public interface QueryCallback{
        void after(ResultSet resultSet);
    }

}

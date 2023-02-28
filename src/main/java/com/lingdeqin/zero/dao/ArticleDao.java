package com.lingdeqin.zero.dao;

import com.lingdeqin.zero.dto.AritcleDto;
import com.lingdeqin.zero.dto.PageDto;
import com.lingdeqin.zero.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleDao {

    List<Article> list(PageDto pageDto);

    List<AritcleDto> listRoughly(PageDto pageDto);

    Article getById(Integer id);

}

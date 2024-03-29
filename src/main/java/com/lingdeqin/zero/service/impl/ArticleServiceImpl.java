package com.lingdeqin.zero.service.impl;

import com.lingdeqin.zero.dao.ArticleDao;
import com.lingdeqin.zero.dto.AritcleDto;
import com.lingdeqin.zero.dto.PageDto;
import com.lingdeqin.zero.dto.PageResultDto;
import com.lingdeqin.zero.entity.Article;
import com.lingdeqin.zero.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;

    @Override
    public PageResultDto<Article> list(Integer currentPage, Integer pageSize) {
        PageDto pageDto = new PageDto(currentPage, pageSize);
        List<Article> articleList = articleDao.list(pageDto);
        return new PageResultDto<Article>(pageDto, articleList);
    }

    @Override
    public PageResultDto<AritcleDto> listRoughly(Integer currentPage, Integer pageSize) {
        return listRoughly(currentPage, pageSize, null, null);
    }

    @Override
    public PageResultDto<AritcleDto> listRoughly(Integer currentPage, Integer pageSize, String content) {
        return listRoughly(currentPage, pageSize, content, null);
    }

    @Override
    public PageResultDto<AritcleDto> listRoughly(Integer currentPage, Integer pageSize, List<String> tags) {
        return listRoughly(currentPage, pageSize, null, tags);
    }

    @Override
    public PageResultDto<AritcleDto> listRoughly(Integer currentPage, Integer pageSize, String content, List<String> tags) {
        PageDto pageDto = new PageDto(currentPage, pageSize);
        List<AritcleDto> articleList = articleDao.listRoughly(pageDto,content ,tags);
        return new PageResultDto<>(pageDto, articleList);
    }

    @Override
    public Article getById(Integer id) {
        Article article = articleDao.getById(id);
        return article;
    }

}

package com.lingdeqin.zero.service;

import com.lingdeqin.zero.dto.AritcleDto;
import com.lingdeqin.zero.dto.PageResultDto;
import com.lingdeqin.zero.entity.Article;

import java.util.List;

public interface ArticleService {

    PageResultDto<Article> list(Integer currentPage, Integer pageSize);

    PageResultDto<AritcleDto> listRoughly(Integer currentPage, Integer pageSize);

    Article getById(Integer id);

}

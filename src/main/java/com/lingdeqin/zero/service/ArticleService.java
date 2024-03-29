package com.lingdeqin.zero.service;

import com.lingdeqin.zero.dto.AritcleDto;
import com.lingdeqin.zero.dto.PageResultDto;
import com.lingdeqin.zero.entity.Article;
import com.lingdeqin.zero.service.base.BaseEntityService;

import java.util.List;

public interface ArticleService extends BaseEntityService<Article> {

    PageResultDto<AritcleDto> listRoughly(Integer currentPage, Integer pageSize);
    PageResultDto<AritcleDto> listRoughly(Integer currentPage, Integer pageSize, String content);
    PageResultDto<AritcleDto> listRoughly(Integer currentPage, Integer pageSize, List<String> tags);
    PageResultDto<AritcleDto> listRoughly(Integer currentPage, Integer pageSize, String content, List<String> tags);

}

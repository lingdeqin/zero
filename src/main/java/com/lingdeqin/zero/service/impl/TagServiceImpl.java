package com.lingdeqin.zero.service.impl;

import com.lingdeqin.zero.dao.TagDao;
import com.lingdeqin.zero.dto.PageDto;
import com.lingdeqin.zero.dto.PageResultDto;
import com.lingdeqin.zero.dto.TagDto;
import com.lingdeqin.zero.entity.Tag;
import com.lingdeqin.zero.service.TagService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TagServiceImpl implements TagService {

    @Resource
    TagDao tagDao;

    @Override
    public PageResultDto<Tag> list(Integer currentPage, Integer pageSize) {
        PageDto pageDto = new PageDto(currentPage, pageSize);
        List<Tag> articleList = tagDao.list(pageDto);
        return new PageResultDto<Tag>(pageDto, articleList);
    }

    @Override
    public List<TagDto> listArticleNumbers() {
        List<TagDto> tagDtoList = tagDao.listArticleNumbers();
        return tagDtoList;
    }

    @Override
    public Tag getById(Integer id) {
        return tagDao.getById(id);
    }

}

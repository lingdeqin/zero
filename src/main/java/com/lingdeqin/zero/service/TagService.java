package com.lingdeqin.zero.service;

import com.lingdeqin.zero.dto.TagDto;
import com.lingdeqin.zero.entity.Tag;
import com.lingdeqin.zero.service.base.BaseEntityService;

import java.util.List;

/**
 * @author lingdq
 */
public interface TagService extends BaseEntityService<Tag> {

    List<TagDto> listArticleNumbers();

}

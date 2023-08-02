package com.lingdeqin.zero.dao;

import com.lingdeqin.zero.dao.base.BaseDao;
import com.lingdeqin.zero.dto.TagDto;
import com.lingdeqin.zero.entity.Tag;

import java.util.List;

public interface TagDao  extends BaseDao<Tag> {

    List<TagDto> listArticleNumbers();

}

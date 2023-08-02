package com.lingdeqin.zero.dao.base;

import com.lingdeqin.zero.dto.PageDto;

import java.util.List;

public interface BaseDao<T> {
    List<T> list(PageDto pageDto);

    T getById(Integer id);

}

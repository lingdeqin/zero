package com.lingdeqin.zero.service.base;

import com.lingdeqin.zero.dto.PageResultDto;

public interface BaseEntityService<T> {

    T getById(Integer id);

    PageResultDto<T> list(Integer currentPage, Integer pageSize);

}

package com.lingdeqin.zero.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ling
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageDto {

    // 当前页数
    private Integer currentPage = 1;

    // 每页条数
    private Integer pageSize = 10;

    // 总数
    private Integer total;

    // 是否计算总数
    private Boolean isCount = true;

    public PageDto(Integer currentPage, Integer pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }


}

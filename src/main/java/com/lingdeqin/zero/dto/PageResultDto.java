package com.lingdeqin.zero.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ling
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResultDto<T>  {

    private PageDto page;

    private List<T> dataList;

}

package com.lingdeqin.zero.dto;

import com.lingdeqin.zero.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ling
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AritcleDto extends Article {

    private String tag;

}

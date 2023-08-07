package com.lingdeqin.zero.dto;

import com.lingdeqin.zero.entity.Article;
import lombok.*;

/**
 * @author ling
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AritcleDto extends Article {

    private String tags;

}

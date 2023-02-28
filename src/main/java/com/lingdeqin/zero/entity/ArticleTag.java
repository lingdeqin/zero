package com.lingdeqin.zero.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author ling
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleTag {

    private Integer id;

    private Integer articleId;
    
    private Integer tagId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}

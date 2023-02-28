package com.lingdeqin.zero.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    private Integer id;

    private String title;

    private String content;

    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}

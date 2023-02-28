package com.lingdeqin.zero.dto;

import com.lingdeqin.zero.config.ZeroConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ling
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfigDto {

    private String author = ZeroConfig.author;

    private String title = ZeroConfig.title;

    private String desc = ZeroConfig.desc;

    private String copyright = ZeroConfig.copyright;

    private String recordNo = ZeroConfig.recordNo;

    private String github = ZeroConfig.github;

}

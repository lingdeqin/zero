package com.lingdeqin.zero.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "zero")
public class ZeroConfig {

    public static String author;

    public static String title;

    public static String desc;

    public static String copyright;

    public static String recordNo;

    public static String github;

    public static String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        ZeroConfig.author = author;
    }

    public static String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        ZeroConfig.title = title;
    }

    public static String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        ZeroConfig.desc = desc;
    }

    public static String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        ZeroConfig.copyright = copyright;
    }

    public static String getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(String recordNo) {
        ZeroConfig.recordNo = recordNo;
    }

    public static String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        ZeroConfig.github = github;
    }
}

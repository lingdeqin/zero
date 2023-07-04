package com.lingdeqin.zero.controller;

import com.lingdeqin.zero.dto.ConfigDto;
import com.lingdeqin.zero.dto.PageResultDto;
import com.lingdeqin.zero.entity.Article;
import com.lingdeqin.zero.service.ArticleService;
import com.lingdeqin.zero.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/config")
    public ResponseEntity<Result<ConfigDto>> config() {
        return ResponseEntity.ok(Result.ok(new ConfigDto()));
    }

    @GetMapping("/articles")
    public Result<PageResultDto> getArticles(Integer currentPage, Integer pageSize) {
        PageResultDto pageResultDto = articleService.listRoughly(currentPage, pageSize);
        return Result.ok(pageResultDto);
    }

    @GetMapping("/article")
    public Result<Article> getArticle(Integer id) {
        Article article = articleService.getById(id);
        return Result.ok(article);
    }

}

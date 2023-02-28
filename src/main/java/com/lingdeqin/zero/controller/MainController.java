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
    private static Integer num = 0;

    @GetMapping("/config")
    public ResponseEntity<Result<ConfigDto>> config() {
        try {
            log.info("==config==begin=="+num);
            Thread.sleep(4000);
            num += 1;
            log.info("==config==end=="+num);
        }catch (Exception e){
            e.printStackTrace();
        }
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

    @GetMapping("/{config}")
    public ResponseEntity<Result<ConfigDto>> test(@RequestBody String res) {
        log.info("===test===");
        log.info("===test==="+res);
        return ResponseEntity.ok(Result.ok(new ConfigDto()));
    }


}

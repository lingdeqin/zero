package com.lingdeqin.zero.controller;

import com.lingdeqin.zero.dto.AritcleDto;
import com.lingdeqin.zero.dto.ConfigDto;
import com.lingdeqin.zero.dto.PageResultDto;
import com.lingdeqin.zero.dto.TagDto;
import com.lingdeqin.zero.entity.Article;
import com.lingdeqin.zero.service.ArticleService;
import com.lingdeqin.zero.service.TagService;
import com.lingdeqin.zero.vo.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/")
public class MainController {
    @Resource
    private ArticleService articleService;

    @Resource
    private TagService tagService;

    @GetMapping("/config")
    public ResponseEntity<Result<ConfigDto>> config() {
        return ResponseEntity.ok(Result.ok(new ConfigDto()));
    }

    @GetMapping("/articles")
    public Result<PageResultDto> getArticles(Integer currentPage, Integer pageSize) {
        PageResultDto<AritcleDto> pageResultDto = articleService.listRoughly(currentPage, pageSize);
        return Result.ok(pageResultDto);
    }

    @GetMapping("/article")
    public Result<Article> getArticle(Integer id) {
        Article article = articleService.getById(id);
        if (article == null){
            return Result.fail("文章不存在！");
        }
        return Result.ok(article);
    }

    @GetMapping("/tags")
    public Result<List<TagDto>> getTags() {
        List<TagDto> tagDtoList = tagService.listArticleNumbers();
        return Result.ok(tagDtoList);
    }
}

package com.codehows.sbd.controller;

import com.codehows.sbd.domain.Article;
import com.codehows.sbd.dto.AddArticleRequest;
import com.codehows.sbd.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BlogApiController {
    private final BlogService blogService;

    //요청이 옴
    @PostMapping("/api/article")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        //request를 받음. 받아서 save하면 Article형태로 오니까 Article로 받음
        Article savedArticle = blogService.save(request);
        //저장된 블로그 글 정보를 응답 객체에 담아 return
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }
}

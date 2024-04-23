package com.codehows.sbd.controller;

import com.codehows.sbd.domain.Article;
import com.codehows.sbd.dto.AddArticleRequest;
import com.codehows.sbd.dto.ArticleResponse;
import com.codehows.sbd.dto.UpdateArticleRequest;
import com.codehows.sbd.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {
    private final BlogService blogService;

    //요청이 옴
    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request, Principal principal) {
        //request를 받음. 받아서 save하면 Article형태로 오니까 Article로 받음
        Article savedArticle = blogService.save(request, principal.getName());
        //저장된 블로그 글 정보를 응답 객체에 담아 return
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    //블로그 글 목록 조회
    @GetMapping(value = "/api/articles")
    //JSON 형태의 List
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        //findAll()하면 id, title, content이 오는데
        //ArticleResponse는 title, content 밖에 없어서
        //밑에 mapping으로 데이터를 담아줌
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        //응답 body에 넣어서 return
        return ResponseEntity.ok()
                .body(articles);
    }

    //글 상세 조회
    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable Long id) {
        Article article = blogService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }

    //글 삭제
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        blogService.delete(id);

        return ResponseEntity.ok()
                //위에 body와 build의 차이가 뭐지?
                //원래는 헤더, 바디 둘다 작성해야하는데
                //여기는 바디 없으니까 그냥 ok만 보내려고 build해서 보내버림
                .build();
    }

    //글 수정
    @PutMapping("/api/articles/{id}")
    //글 id과 수정할 데이터
    public ResponseEntity<Article> updateArticle(@PathVariable Long id,
                                                 @RequestBody UpdateArticleRequest request) {
        Article updatedArticle = blogService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedArticle);
    }
}

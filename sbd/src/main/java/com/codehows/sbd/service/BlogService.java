package com.codehows.sbd.service;

import com.codehows.sbd.domain.Article;
import com.codehows.sbd.dto.AddArticleRequest;
import com.codehows.sbd.dto.UpdateArticleRequest;
import com.codehows.sbd.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor //필수 인자를 가지고 있는 생성자 생성
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    //title과 content만 있는 dto를 인자로 넣고
    public Article save(AddArticleRequest request, String userName) {
        //리포지토리로 save를 하면 id가 포함되어진다.
        return blogRepository.save(request.toEntity(userName));
    }

    //전체 글 조회
    public List<Article> findAll() {
        return blogRepository.findAll();
        //전체 글 조회는 orElseThrow 왜 안함?
    }

    //글 조회
    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    //글 삭제
    public void delete(long id) {
        Article article = blogRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        authorizeArticleAuthor(article);
        blogRepository.deleteById(id);
    }

    //글 수정
    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        authorizeArticleAuthor(article);
        article.update(request.getTitle(), request.getContent());

        return article;
    }

    //게시글을 작성한 유저인지 확인
    private static void authorizeArticleAuthor(Article article) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        if(!article.getAuthor().equals(userName)) {
            throw new IllegalArgumentException("not authorized");
        }
    }
}

package com.codehows.sbd.service;

import com.codehows.sbd.domain.Article;
import com.codehows.sbd.dto.AddArticleRequest;
import com.codehows.sbd.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor //필수 인자를 가지고 있는 생성자 생성
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    //title과 content만 있는 dto를 인자로 넣고
    public Article save(AddArticleRequest request) {
        //리포지토리로 save를 하면 id가 포함되어진다.
        return blogRepository.save(request.toEntity());
    }
}

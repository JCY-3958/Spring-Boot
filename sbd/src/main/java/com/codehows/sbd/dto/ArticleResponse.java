package com.codehows.sbd.dto;

import com.codehows.sbd.domain.Article;
import lombok.Getter;

@Getter
public class ArticleResponse {
    //id는 왜 필요 없음?
    private final String title;
    private final String content;

    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}

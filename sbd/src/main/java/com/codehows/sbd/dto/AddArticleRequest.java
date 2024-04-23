package com.codehows.sbd.dto;

import com.codehows.sbd.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//데이터를 넘겨주고 받기 위해 사용(id는 자동으로 해주기 때문에 필요 없어서)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {
    private String title;
    private String content;

    //new Article(title, content)와 같은거 밑에가 가독성 더 좋음
    public Article toEntity(String author) {
        return Article.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}

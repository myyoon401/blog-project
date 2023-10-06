package com.app.blog.project.client.data;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BlogSearchReq {
    private String query;
    private String sort;
    private Integer page = 1;
    private Integer size = 10;

    public static BlogSearchReq of (String query, String sort, Integer page, Integer size) {
        return new BlogSearchReq(query, sort, page, size);
    }
}

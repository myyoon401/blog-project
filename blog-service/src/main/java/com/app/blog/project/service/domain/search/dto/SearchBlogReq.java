package com.app.blog.project.service.domain.search.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;


@Getter
@Setter
public class SearchBlogReq {
    private String url;
    @NotNull
    private String keyword;
    private SortType sort = SortType.ACCURACY;
    private SearchSourceType source = SearchSourceType.KAKAO;
    private Integer page = 1;
    private Integer size = 10;

    public String getSearchKeyword() {
        return ObjectUtils.isEmpty(url) ? keyword : url+" "+keyword;
    }
}

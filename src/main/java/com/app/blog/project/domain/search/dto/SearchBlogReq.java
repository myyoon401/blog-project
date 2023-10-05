package com.app.blog.project.domain.search.dto;

import com.app.blog.project.type.SearchSourceType;
import com.app.blog.project.type.SortType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SearchBlogReq {
    private String url;
    @NotNull
    private String keyword;
    private SortType sort;
    private SearchSourceType source;
    private Integer page;
    private Integer size;

    public String getSearchKeyword() {
        return ObjectUtils.isEmpty(url) ? keyword : url+" "+keyword;
    }
}

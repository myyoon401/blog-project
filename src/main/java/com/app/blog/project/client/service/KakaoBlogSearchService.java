package com.app.blog.project.client.service;

import com.app.blog.project.client.KakaoClient;
import com.app.blog.project.client.data.BlogSearchReq;
import com.app.blog.project.client.data.BlogSearchRes;
import com.app.blog.project.client.data.KakaoSearchBlogRes;
import com.app.blog.project.common.utils.JsonUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class KakaoBlogSearchService extends BlogSearchService{

    private final KakaoClient kakaoClient;

    @Override
    public BlogSearchRes search(BlogSearchReq req) {
        KakaoSearchBlogRes res = null;
        try {
            res = JsonUtils.readValue(kakaoClient.searchBlog(req.getQuery(), req.getSort(), req.getPage(), req.getSize()), KakaoSearchBlogRes.class);
        } catch (IOException e) {
            throw new RuntimeException();
        }

        return BlogSearchRes.of(
                BlogSearchRes.Page.of(req.getSize()
                        , req.getPage()
                        , res.getMeta().getTotalPage(req.getSize())
                        ,  res.getMeta().getPageableCount()
                        , !res.getMeta().getIsEnd())
                , res.getDocuments().stream()
                        .map(document -> BlogSearchRes.Data.of(document.getTitle()
                                , document.getContents()
                                , document.getUrl()
                                , document.getBlogname()
                                , document.getThumbnail()
                                , document.getDatetime()))
                        .collect(Collectors.toList())
        );
    }
}

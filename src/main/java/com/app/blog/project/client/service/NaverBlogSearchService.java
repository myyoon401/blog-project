package com.app.blog.project.client.service;

import com.app.blog.project.client.data.BlogSearchReq;
import com.app.blog.project.client.data.BlogSearchRes;
import org.springframework.stereotype.Component;

@Component
public class NaverBlogSearchService extends BlogSearchService{
    @Override
    public BlogSearchRes search(BlogSearchReq req) {
        return null;
    }
}
package com.app.blog.project.service.domain.search.service;


import com.app.blog.project.service.client.common.data.BlogSearchReq;
import com.app.blog.project.service.client.common.data.BlogSearchRes;
import com.app.blog.project.service.client.service.BlogSearchFactory;
import com.app.blog.project.service.common.dto.PageRes;
import com.app.blog.project.service.domain.keyword.service.KeywordService;
import com.app.blog.project.service.domain.search.dto.SearchBlogReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final BlogSearchFactory blogSearchFactory;
    private final KeywordService keywordService;

    public PageRes searchBlog(SearchBlogReq req) {
        BlogSearchRes res = blogSearchFactory.get(req.getSource()).search(
                BlogSearchReq.of(req.getSearchKeyword(), req.getSort(), req.getPage(), req.getSize()));

        keywordService.saveKeyword(req.getKeyword());

        return PageRes.of(res.getData()
                , req.getSize()
                , req.getPage()
                , res.getPage().getTotalPage()
                , res.getPage().getTotalCount()
                , !res.getPage().getHasNext()
        );
    }
}

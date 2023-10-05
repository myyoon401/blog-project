package com.app.blog.project.domain.search.service;

import com.app.blog.project.client.KakaoClient;
import com.app.blog.project.client.data.KakaoSearchBlogRes;
import com.app.blog.project.domain.search.dto.SearchBlogReq;
import com.app.blog.project.entity.SearchKeyword;
import com.app.blog.project.repository.SearchKeywordRepository;
import com.app.blog.project.type.SearchSourceType;
import com.app.blog.project.type.SortType;
import com.app.blog.project.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final KakaoClient kakaoClient;
    private final SearchKeywordRepository keywordRepository;

    public KakaoSearchBlogRes searchBlog(SearchBlogReq req) {
        KakaoSearchBlogRes res = null;
        try {
            res = JsonUtils.readValue(kakaoClient.searchBlog(req.getSearchKeyword(), null, null, null), KakaoSearchBlogRes.class);
        } catch (IOException e) {
            throw new RuntimeException();
        }
        saveKeyword(req.getKeyword());
        return res;
    }

    private void saveKeyword(String keyword) {
        SearchKeyword searchKeyword = keywordRepository.findByKeyword(keyword);
        if(ObjectUtils.isEmpty(searchKeyword)) {
            searchKeyword = SearchKeyword.of(keyword);
        } else {
            searchKeyword.countUp();
        }
        keywordRepository.save(searchKeyword);
    }
}

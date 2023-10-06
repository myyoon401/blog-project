package com.app.blog.project.domain.keyword.service;

import com.app.blog.project.domain.keyword.dto.PopularKeywordRes;
import com.app.blog.project.domain.keyword.dto.RecentKeywordRes;
import com.app.blog.project.domain.search.dto.SearchBlogReq;
import com.app.blog.project.entity.SearchKeyword;
import com.app.blog.project.repository.SearchKeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KeywordService {
    private final SearchKeywordRepository keywordRepository;

    @Transactional(readOnly = true)
    public List<PopularKeywordRes> getPopular() {
        List<SearchKeyword> popularKeywords = keywordRepository.findAllByOrderByCountDesc(PageRequest.of(0, 10));
        List<PopularKeywordRes> res = new ArrayList<>();
        int rank = 1;
        int beforeCount = 0;
        for (SearchKeyword popularKeyword : popularKeywords) {
            if(beforeCount == popularKeyword.getCount()) {
                rank -= 1;
            }
            res.add(PopularKeywordRes.of(rank++, popularKeyword.getKeyword(), popularKeyword.getCount()));
            beforeCount = popularKeyword.getCount();
        }
        return res;
    }

    @Transactional(readOnly = true)
    public List<RecentKeywordRes> getRecent() {
        List<SearchKeyword> popularKeywords = keywordRepository.findAllByOrderByUpdatedAtDesc(PageRequest.of(0, 10));
        List<RecentKeywordRes> res = new ArrayList<>();
        int rank = 1;
        LocalDateTime beforeDateTime = null;
        for (SearchKeyword recentKeyword : popularKeywords) {
            if(!ObjectUtils.isEmpty(beforeDateTime) && beforeDateTime.isEqual(recentKeyword.getUpdatedAt())) {
                rank -= 1;
            }
            res.add(RecentKeywordRes.of(rank++, recentKeyword.getKeyword(), recentKeyword.getUpdatedAt()));
            beforeDateTime = recentKeyword.getUpdatedAt();
        }
        return res;
    }

    @Transactional
    public void saveKeyword(String keyword) {
        SearchKeyword searchKeyword = keywordRepository.findByKeyword(keyword);
        if(ObjectUtils.isEmpty(searchKeyword)) {
            searchKeyword = SearchKeyword.of(keyword);
        } else {
            searchKeyword.countUp();
        }
        keywordRepository.save(searchKeyword);
    }
}

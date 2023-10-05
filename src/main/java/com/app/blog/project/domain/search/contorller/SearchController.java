package com.app.blog.project.domain.search.contorller;

import com.app.blog.project.client.KakaoClient;
import com.app.blog.project.client.data.KakaoSearchBlogRes;
import com.app.blog.project.domain.search.dto.SearchBlogReq;
import com.app.blog.project.domain.search.service.SearchService;
import com.app.blog.project.type.SearchSourceType;
import com.app.blog.project.type.SortType;
import com.app.blog.project.utils.JsonUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "search")
public class SearchController {

    private final SearchService service;

    @GetMapping(value = "blog")
    public ResponseEntity<?> searchBlog(@Valid SearchBlogReq req) {
        return new ResponseEntity<>(service.searchBlog(req), HttpStatus.OK);
    }
}

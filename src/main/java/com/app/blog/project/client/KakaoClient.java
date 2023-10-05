package com.app.blog.project.client;

import com.app.blog.project.client.data.KakaoSearchBlogRes;
//import feign.Headers;
import com.app.blog.project.config.KakaoFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "kakaoClient", url = "${service.kakao.url}", configuration = KakaoFeignConfig.class)
//@Headers("Authorization: KakaoAK ${service.kakao.auth}")
public interface KakaoClient {

    @GetMapping(value = "search/blog", produces = "application/json;charset=UTF-8")
    String searchBlog(
            @RequestParam("query") String query,
            @RequestParam("sort") String sort,
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size
    );
}

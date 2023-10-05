package com.app.blog.project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchKeyword {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(columnDefinition = "int comment 'id'")
    private Long id;

    @Column(columnDefinition = "varchar comment '검색어'")
    private String keyword;

    @Column(columnDefinition = "varchar comment '검색횟수'")
    private Integer count;

    @Column(nullable = false, columnDefinition = "timestamp not null default current_timestamp comment '생성일시'")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "timestamp null on update current_timestamp comment '수정일시'")
    private LocalDateTime updatedAt;

    public SearchKeyword(String keyword) {
        this.keyword = keyword;
        this.count = 1;
        this.createdAt = LocalDateTime.now();
    }

    public static SearchKeyword of(String keyword) {
        return new SearchKeyword(keyword);
    }

    public void countUp() {
        this.count +=1;
    }
}

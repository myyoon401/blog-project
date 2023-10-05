package com.app.base.project.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(columnDefinition = "int comment 'id'")
    private Long id;

    @Column(columnDefinition = "varchar comment '생성일시'")
    private String memo;

    @Column(nullable = false, columnDefinition = "timestamp not null default current_timestamp comment '생성일시'")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "timestamp null on update current_timestamp comment '수정일시'")
    private LocalDateTime updatedAt;
}

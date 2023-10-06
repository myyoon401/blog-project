package com.app.blog.project.common.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SortType {
    ACCURACY("accuracy"),
    RECENCY("recency");

    String value;
}

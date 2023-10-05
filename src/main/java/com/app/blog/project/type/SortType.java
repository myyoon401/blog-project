package com.app.blog.project.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SortType {
    ACCURACY("accuracy"),
    RECENCY("recency");

    String value;
}

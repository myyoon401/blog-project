package com.app.base.project.repository;

import com.app.base.project.entity.Test;
import org.springframework.data.domain.Page;

public interface TestRepositoryCustom {
    Page<Test> findByMemo(String memo);
}

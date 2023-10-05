package com.app.base.project.repository;

import com.app.base.project.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long>, TestRepositoryCustom {
}

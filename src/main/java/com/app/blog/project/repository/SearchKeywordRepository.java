package com.app.blog.project.repository;

import com.app.blog.project.entity.SearchKeyword;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SearchKeywordRepository extends JpaRepository<SearchKeyword, Long> {
    SearchKeyword findByKeyword(String keyword);
    List<SearchKeyword> findAllByOrderByCountDesc(Pageable pageable);
    List<SearchKeyword> findAllByOrderByUpdatedAtDesc(Pageable pageable);
}

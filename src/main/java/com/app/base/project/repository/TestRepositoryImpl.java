package com.app.base.project.repository;

import com.app.base.project.entity.Test;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

//import com.app.base.project.entity

public class TestRepositoryImpl extends QuerydslRepositorySupport implements TestRepositoryCustom {
    public TestRepositoryImpl() {
        super(Test.class);
    }

    @Override
    public Page<Test> findByMemo(String memo) {
        Pageable page = PageRequest.of(0, 10);
//        JPQLQuery<Test> baseQuery = from(todo1);
        return null;
    }

//    @Override
//    public Page<Todo> findByTodoLike(TodoDto.Search searchDto) {
//        Pageable page = PageRequest.of(searchDto.getPage(), searchDto.getPerPage());
//        JPQLQuery<Todo> baseQuery = from(todo1);
//
//        if(searchDto.getTodo() != null) {
//            baseQuery.where(todo1.todo.contains(searchDto.getTodo()));
//        }
//        if(searchDto.getDoneState() != null) {
//            baseQuery.where(todo1.doneStat.eq(searchDto.getDoneState()));
//        }
//        if(searchDto.getOrderCondition() != null) {
//            switch (searchDto.getOrderCondition()) {
//                case "idAsc":
//                    baseQuery.orderBy(todo1.id.asc());
//                    break;
//                case "idDesc":
//                    baseQuery.orderBy(todo1.id.desc());
//                    break;
//                case "todoAsc":
//                    baseQuery.orderBy(todo1.todo.asc());
//                    break;
//                case "todoDesc":
//                    baseQuery.orderBy(todo1.todo.desc());
//                    break;
//                case "createAtAsc":
//                    baseQuery.orderBy(todo1.createdAt.asc());
//                    break;
//                case "createAtDesc":
//                    baseQuery.orderBy(todo1.createdAt.desc());
//                    break;
//                case "updateAtAsc":
//                    baseQuery.orderBy(todo1.updatedAt.asc());
//                    break;
//                case "updateAtDesc":
//                    baseQuery.orderBy(todo1.updatedAt.desc());
//                    break;
//            }
//        }
//
//        List<Todo> todoList = getQuerydsl().applyPagination(page, baseQuery).fetch();
//        return new PageImpl<>(todoList, page, baseQuery.fetchCount());
//    }
}

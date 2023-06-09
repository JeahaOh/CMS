package com.portfolio.cms.webTest.posts.repository;

import com.portfolio.cms.webTest.posts.vo.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT P FROM Posts P ORDER BY P.id DESC")
    List<Posts> findAllDesc();
}

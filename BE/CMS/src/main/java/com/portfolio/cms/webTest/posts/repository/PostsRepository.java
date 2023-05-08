package com.portfolio.cms.webTest.posts.repository;

import com.portfolio.cms.webTest.posts.vo.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}

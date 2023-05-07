package com.portfolio.cms.board.repository;

import com.portfolio.cms.board.vo.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}

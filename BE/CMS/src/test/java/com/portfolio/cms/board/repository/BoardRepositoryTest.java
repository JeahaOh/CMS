package com.portfolio.cms.board.repository;

import com.portfolio.cms.board.dto.BoardDto;
import com.portfolio.cms.board.vo.Board;
import com.portfolio.cms.member.repository.MemberRepository;
import com.portfolio.cms.member.vo.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BoardRepositoryTest {
    
    @Autowired
    BoardRepository boardRepository;
    
    @Autowired
    MemberRepository memberRepository;
    
    @Test
    public void 게시물_등록() {
        boardRepository.deleteAll();
        
        // given
        String title = "title1";
        String content = "content1";
        
        List<Member> memberList = memberRepository.findAll();
        Member member = memberList.get(0);
        
        BoardDto boardDto = new BoardDto(title, content);
        Board board = boardDto.toEntity(member);
        boardRepository.save(board);
        
        // when
        List<Board> boardList = boardRepository.findAll();
        
        // then
        Board boards = boardList.get(0);
        assertThat(boards.getTitle()).isEqualTo(title);
        assertThat(boards.getContent()).isEqualTo(content);
    }
    
    @Test
    public void 게시판_수정() {
    
        boardRepository.deleteAll();
    
        // given
        String title = "title1";
        String content = "content1";
    
        List<Member> memberList = memberRepository.findAll();
        Member member = memberList.get(0);
    
        BoardDto boardDto = new BoardDto(title, content);
        Board board = boardDto.toEntity(member);
        boardRepository.save(board);
        
        //when
        List<Board> boardList2 = boardRepository.findAll();
        
        //then
        Board boards2 = boardList2.get(0);
        assertThat(boards2.getTitle()).isEqualTo(title);
        assertThat(boards2.getContent()).isEqualTo(content);
    }
}
package com.portfolio.cms.board.dto;

import com.portfolio.cms.board.vo.Board;
import com.portfolio.cms.member.vo.Member;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
//import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class BoardDto {
    private Long id;
    //    @NotEmpty
    private String title;
    private String content;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private Long viewCount;
    private String username;
    private List<MultipartFile> multipartFileList;
    
    @Builder
    public BoardDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
    @Builder
    public BoardDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
    
    public Board toEntity(Member member) {
        return Board.builder()
                .member(member)
                .title(title)
                .content(content)
                .build();
    }
}

package com.portfolio.cms.member.vo;

import com.portfolio.cms.board.vo.Board;
import com.portfolio.cms.member.role.Authority;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;
    private String username;
    private String password;
    private String phoneNo;
    private int age;
    
    @Column(name="USER_ROLE")
    @Enumerated(EnumType.STRING)
    private Authority authority;
    
    @OneToMany(mappedBy = "member")
    private List<Board> boards = new ArrayList<>();
    
    @Builder
    public Member(String username, String phoneNo, int age, Authority authority) {
        this.username = username;
        this.phoneNo = phoneNo;
        this.age = age;
        this.authority = authority;
    }
    
}

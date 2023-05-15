package com.portfolio.cms.webTest.member.vo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;
    
    @Column(unique = true)
    private String memberId;
    
    private String pwd;
    
    private String role;
    
    public static Member createUser(String userId, String pwd) {
        return Member.builder()
                .memberNo(null)
                .memberId(userId)
                .pwd(pwd)
                .role("ROLE_USER")
                .build();
    }
}

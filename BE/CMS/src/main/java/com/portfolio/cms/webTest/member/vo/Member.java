package com.portfolio.cms.webTest.member.vo;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

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
    
    public static Member createUser(String userId, String pwd, PasswordEncoder encoder) {
        return Member.builder()
                .memberNo(null)
                .memberId(userId)
                .pwd(encoder.encode(pwd))
                .role("USER")
                .build();
    }
}

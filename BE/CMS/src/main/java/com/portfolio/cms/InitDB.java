package com.portfolio.cms;

import com.portfolio.cms.member.repository.MemberRepository;
import com.portfolio.cms.member.vo.Member;
import com.portfolio.cms.member.role.Authority;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitDB {
    private final InitService initService;
    
    @PostConstruct
    public void init() {
        initService.userDbInit();
    }
    
    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final MemberRepository memberRepository;
        // private final BoardRepository boardRepository;
        
        public void userDbInit() {
            List<Member> memberList = memberRepository.findAll();
            if (memberList.isEmpty()) {
                Member member = Member.builder()
                        .username("ADMIN")
                        .phoneNo("010-1111-2222")
                        .age(0)
                        .authority(Authority.ROLE_ADMIN)
                        .build();
                memberRepository.save(member);
            }
        }
    }
}

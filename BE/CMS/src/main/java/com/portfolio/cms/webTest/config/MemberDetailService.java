package com.portfolio.cms.webTest.config;

import com.portfolio.cms.webTest.member.service.MemberService;
import com.portfolio.cms.webTest.member.vo.Member;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberDetailService implements UserDetailsService {
    private final MemberService memberService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> findOne = memberService.findOne(username);
        Member member = findOne.orElseThrow(() -> new UsernameNotFoundException("member id is not exists!"));
        
        return User.builder()
                .username(member.getMemberId())
                .password(member.getPwd())
                .roles(member.getRole())
                .build();
    }
}

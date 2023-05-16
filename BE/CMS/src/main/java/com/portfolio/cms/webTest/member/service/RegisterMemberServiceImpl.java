package com.portfolio.cms.webTest.member.service;

import com.portfolio.cms.webTest.member.repository.MemberRepository;
import com.portfolio.cms.webTest.member.vo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegisterMemberServiceImpl implements RegisterMemberService {
    private final MemberRepository repository;
    private final PasswordEncoder encoder;
    
    @Override
    public Long join(String userId, String pwd) throws Exception {
        Member member = Member.createUser(userId, pwd, encoder);
        validateDuplicateMember(member);
        repository.save(member);
        
        return member.getMemberNo();
    }
    
    private void validateDuplicateMember(Member member) {
        repository.findByMemberId(member.getMemberId())
                .ifPresent(m -> {
                    throw new IllegalStateException("member id is already exists.");
                });
    }
}

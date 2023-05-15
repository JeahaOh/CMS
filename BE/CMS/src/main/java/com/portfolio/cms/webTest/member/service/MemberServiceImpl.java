package com.portfolio.cms.webTest.member.service;

import com.portfolio.cms.webTest.member.repository.MemberRepository;
import com.portfolio.cms.webTest.member.vo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository repository;
    
    public Optional<Member> findOne(String userId) {
        return repository.findByMemberId(userId);
    }
    
    @Override
    public boolean isValidMember(String userId, String pwd) {
        Optional<Member> member = findOne(userId);
        if (member.isPresent()) {
            return member.get().getPwd().equals(pwd);
        }
        return false;
    }
}

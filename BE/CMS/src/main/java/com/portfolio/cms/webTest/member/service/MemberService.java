package com.portfolio.cms.webTest.member.service;

import com.portfolio.cms.webTest.member.vo.Member;

import java.util.Optional;

public interface MemberService {
    Optional<Member> findOne(String userId);
    boolean isValidMember(String userId, String pwd);
}

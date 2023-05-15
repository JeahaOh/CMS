package com.portfolio.cms.webTest.member.service;

public interface RegisterMemberService {
    Long join(String userId, String pwd) throws Exception;
}

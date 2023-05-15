package com.portfolio.cms.webTest.member.repository;

import com.portfolio.cms.webTest.member.vo.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByMemberId(String userId);
}

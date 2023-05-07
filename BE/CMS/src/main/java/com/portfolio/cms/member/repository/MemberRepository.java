package com.portfolio.cms.member.repository;

import com.portfolio.cms.member.vo.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

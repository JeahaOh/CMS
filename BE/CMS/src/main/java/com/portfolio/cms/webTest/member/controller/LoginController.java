package com.portfolio.cms.webTest.member.controller;

import com.portfolio.cms.webTest.member.dto.MemberLoginDto;
import com.portfolio.cms.webTest.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
@Slf4j
public class LoginController {
    private final MemberService memberService;
    
    @GetMapping("/login")
    public String loginPage() {
        return "mustache/auth/login";
    }
    
//    @PostMapping("/login")
//    public String loginProcess(MemberLoginDto dto) {
//        boolean isValidMember = memberService.isValidMember(dto.getUserId(), dto.getPwd());
//        log.debug("isValidMember : {}", isValidMember);
//        if (isValidMember == false) return "mustache/auth/login";
//        return "redirect:/";
//    }
    
    @PostMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }
    
    @GetMapping("/join")
    public String joinPage() {
        return "mustache/auth/join";
    }
}

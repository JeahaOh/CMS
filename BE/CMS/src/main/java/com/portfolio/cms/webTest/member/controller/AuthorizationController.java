package com.portfolio.cms.webTest.member.controller;

import com.portfolio.cms.webTest.member.dto.MemberJoinDto;
import com.portfolio.cms.webTest.member.service.RegisterMemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthorizationController {
    private final RegisterMemberService registerMemberService;
    

    
    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody MemberJoinDto dto) {
        log.debug("dto : {}", dto);
        try {
            registerMemberService.join(dto.getUserId(), dto.getPwd());
            return ResponseEntity.ok("join success");
        } catch (Exception e) {
            log.error("CUZ : {}, MSG : {}", e.getCause(), e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}

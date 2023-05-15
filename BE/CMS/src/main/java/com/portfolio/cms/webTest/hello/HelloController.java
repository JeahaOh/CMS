package com.portfolio.cms.webTest.hello;

import com.portfolio.cms.webTest.hello.dto.HelloResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
    
    @GetMapping("/status")
    public ResponseEntity<String> serverStatusCheck() {
        return ResponseEntity.ok("ok");
    }
}

package com.portfolio.cms.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping({"", "/"})
    public String list() {
        return "/board/list";
    }
    
    @GetMapping("/write")
    public String write() {
        return "/board/write";
    }
    
    @GetMapping("/update")
    public String update() {
        return "/board/update";
    }

}

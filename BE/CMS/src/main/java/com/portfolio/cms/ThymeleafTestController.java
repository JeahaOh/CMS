package com.portfolio.cms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class ThymeleafTestController {
    @RequestMapping("/test")
    public String test() {
        log.trace("trace log");
        log.debug("debug LOG");
        log.info("info LOG");
        log.warn("warn LOG");
        log.error("error LOG");
        return "main/main";
    }
}

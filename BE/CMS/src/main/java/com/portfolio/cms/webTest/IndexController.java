package com.portfolio.cms.webTest;

import com.portfolio.cms.config.auth.dto.SessionUser;
import com.portfolio.cms.webTest.posts.service.PostsService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
    
    private final PostsService postsService;
    private final HttpSession session;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        
        SessionUser user = (SessionUser) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        
        return "mustache/index";
    }
    
    @GetMapping("/posts/save")
    public String postsSave() {
        return "mustache/posts-save";
    }
    
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable long id, Model model) {
        model.addAttribute("post", postsService.findById(id));
        return "mustache/posts-update";
    }
}

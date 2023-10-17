package org.generation.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/terms-conditions")
    public String terms() {
        return "terms-conditions";
    }
}

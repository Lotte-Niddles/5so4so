package com.needle.FsoFso.common.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

    @GetMapping("/404.do")
    public String showPageNotFound() {
        return "404.tiles";
    }

    @GetMapping("/error.do")
    public String showErrorPage() {
        return "error.tiles";
    }
}

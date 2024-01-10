package org.hammerit.worktimer.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @PostMapping("/admin")
    public String redirectAdminPage() {
        return "admin";
    }

    @GetMapping()
    public String homePage() {
        return "homepage";
    }

    @PostMapping()
    public String redirectHomePage() {
        return "homepage";
    }
}

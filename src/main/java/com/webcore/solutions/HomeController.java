package com.webcore.solutions;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private final ProjectRequestRepository repo;

    public HomeController(ProjectRequestRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("projectRequest", new ProjectRequest());
        model.addAttribute("requests", repo.findTop10ByOrderByCreatedAtDesc());
        return "index";
    }

    @PostMapping("/request")
    public String submit(@Valid ProjectRequest projectRequest, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("requests", repo.findTop10ByOrderByCreatedAtDesc());
            return "index";
        }
        repo.save(projectRequest);
        return "redirect:/";
    }

    @GetMapping("/health")
    public String health(Model model) {
        model.addAttribute("status", "OK");
        return "health";
    }
}
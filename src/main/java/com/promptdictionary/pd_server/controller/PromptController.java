package com.promptdictionary.pd_server.controller;

import com.promptdictionary.pd_server.service.PromptService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prompts")
public class PromptController {

    private final PromptService promptService;

    public PromptController(PromptService promptService) {
        this.promptService = promptService;
    }

    @GetMapping("/trending")
    public Object getTrendingPrompts() {
        return promptService.getTrendingPrompts();
    }
}
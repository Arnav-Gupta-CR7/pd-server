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

    @GetMapping("/autocomplete")
    public Object autocompleteSearch(
            @RequestParam String q
    ) {
        return promptService.autocompleteSearch(q);
    }

    @GetMapping("/search")
    public Object fullPromptSearch(
            @RequestParam String q
    ) {
        return promptService.fullPromptSearch(q);
    }

    @GetMapping("/{id}")
    public Object getPromptById(
            @PathVariable String id
    ) {
        return promptService.getPromptById(id);
    }

    @GetMapping("/category/{slug}")
    public Object getPromptsByCategory(
            @PathVariable String slug
    ) {
        return promptService.getPromptsByCategory(slug);
    }

    @GetMapping("/tag/{tag}")
    public Object getPromptsByTag(
            @PathVariable String tag
    ) {
        return promptService.getPromptsByTag(tag);
    }
}
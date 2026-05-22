package com.promptdictionary.pd_server.service;

import com.promptdictionary.pd_server.repository.PromptRepository;
import org.springframework.stereotype.Service;

@Service
public class PromptService {

    private final PromptRepository promptRepository;

    public PromptService(PromptRepository promptRepository) {
        this.promptRepository = promptRepository;
    }

    public Object getTrendingPrompts() {
        return promptRepository.getTrendingPrompts();
    }

    public Object autocompleteSearch(String query) {
        return promptRepository.autocompleteSearch(query);
    }

    public Object fullPromptSearch(String query) {
        return promptRepository.fullPromptSearch(query);
    }

    public Object getPromptById(String promptId) {
        return promptRepository.getPromptById(promptId);
    }

    public Object getPromptsByCategory(String categorySlug) {
        return promptRepository.getPromptsByCategory(categorySlug);
    }

    public Object getPromptsByTag(String tagName) {
        return promptRepository.getPromptsByTag(tagName);
    }
}

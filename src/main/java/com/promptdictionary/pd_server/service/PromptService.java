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
}

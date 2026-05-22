package com.promptdictionary.pd_server.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PromptRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<?> getTrendingPrompts() {

        String sql = """
            SELECT *
            FROM get_trending_prompts()
        """;

        return entityManager
                .createNativeQuery(sql)
                .getResultList();
    }
}

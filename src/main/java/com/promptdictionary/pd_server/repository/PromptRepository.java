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

    public List<?> autocompleteSearch(String query) {

        String sql = """
            SELECT *
            FROM autocomplete_search(:query)
        """;

        return entityManager
                .createNativeQuery(sql)
                .setParameter("query", query)
                .getResultList();
    }

    public List<?> fullPromptSearch(String query) {

        String sql = """
            SELECT *
            FROM full_prompt_search(:query)
        """;

        return entityManager
                .createNativeQuery(sql)
                .setParameter("query", query)
                .getResultList();
    }

    public List<?> getPromptById(String promptId) {

        String sql = """
            SELECT *
            FROM get_prompt_by_id(CAST(:promptId AS UUID))
        """;

        return entityManager
                .createNativeQuery(sql)
                .setParameter("promptId", promptId)
                .getResultList();
    }

    public List<?> getPromptsByCategory(String categorySlug) {

        String sql = """
            SELECT *
            FROM get_prompts_by_category(:categorySlug)
        """;

        return entityManager
                .createNativeQuery(sql)
                .setParameter("categorySlug", categorySlug)
                .getResultList();
    }

    public List<?> getPromptsByTag(String tagName) {

        String sql = """
            SELECT *
            FROM get_prompts_by_tag(:tagName)
        """;

        return entityManager
                .createNativeQuery(sql)
                .setParameter("tagName", tagName)
                .getResultList();
    }
}

package com.mycompany.oophomework.exercise2;

import java.util.Objects;

/** Exercises 2 and 3 (PDF pp. 30-31): shared, immutable news and event fields. */
public abstract class ContentItem {

    private final String title;
    private final String description;
    private final String language;

    protected ContentItem(String title, String description, String language) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title is required");
        }
        this.title = title.strip();
        this.description = Objects.requireNonNullElse(description, "").strip();
        this.language = Objects.requireNonNullElse(language, "").strip();
    }

    public final String getTitle() {
        return title;
    }

    public final String getDescription() {
        return description;
    }

    public final String getLanguage() {
        return language;
    }
}

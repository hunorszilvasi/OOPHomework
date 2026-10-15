package com.mycompany.oophomework;

import java.util.Objects;
import java.util.Locale;

/** Exercise 2 (PDF p. 30); Exercise 4 (PDF p. 49) adds searchable behavior. */
public final class News extends ContentItem implements Searchable {

    private final String source;
    private final String url;
    private final String author;
    private final String publisher;
    private final String coverImage;

    public News(
            String title,
            String description,
            String source,
            String url,
            String author,
            String publisher,
            String language,
            String coverImage) {
        super(title, description, language);
        this.source = cleanOptional(source);
        this.url = cleanOptional(url);
        this.author = cleanOptional(author);
        this.publisher = cleanOptional(publisher);
        this.coverImage = cleanOptional(coverImage);
    }

    private static String cleanOptional(String value) {
        return Objects.requireNonNullElse(value, "").strip();
    }

    public String getSource() {
        return source;
    }

    public String getUrl() {
        return url;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getCoverImage() {
        return coverImage;
    }

    @Override
    public boolean matches(String text) {
        if (text == null || text.isBlank()) {
            return false;
        }
        String searchText = text.strip().toLowerCase(Locale.ROOT);
        return getTitle().toLowerCase(Locale.ROOT).contains(searchText)
                || getDescription().toLowerCase(Locale.ROOT).contains(searchText);
    }
}

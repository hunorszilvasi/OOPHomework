package com.mycompany.oophomework.exercise4;

import com.mycompany.oophomework.exercise2.News;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/** Exercise 4 (PDF p. 49): supplies news from an injected RSS loader. */
public final class RssContentSource implements ContentSource {

    private final Supplier<List<News>> newsLoader;

    public RssContentSource(Supplier<List<News>> newsLoader) {
        this.newsLoader = Objects.requireNonNull(newsLoader, "newsLoader must not be null");
    }

    @Override
    public List<News> load() {
        return List.copyOf(newsLoader.get());
    }
}

package com.mycompany.oophomework;

import java.util.List;

/** Exercise 4 (PDF p. 49): supplies news without accessing external storage. */
public final class InMemoryContentSource implements ContentSource<News> {

    private final List<News> newsItems;

    public InMemoryContentSource(List<News> newsItems) {
        this.newsItems = List.copyOf(newsItems);
    }

    @Override
    public List<News> load() {
        return newsItems;
    }
}

package com.mycompany.oophomework.exercise1;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/** Exercise 1 (PDF p. 17): loads content through an injected RSS loader. */
public final class RssSource<T> implements ContentSource<T> {

    private final Supplier<List<T>> rssLoader;

    public RssSource(Supplier<List<T>> rssLoader) {
        this.rssLoader = Objects.requireNonNull(rssLoader, "rssLoader must not be null");
    }

    @Override
    public List<T> load() {
        return List.copyOf(rssLoader.get());
    }
}

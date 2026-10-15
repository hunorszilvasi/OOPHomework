package com.mycompany.oophomework;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/** Exercise 1 (PDF p. 17): loads content through an injected database loader. */
public final class DatabaseSource<T> implements ContentSource<T> {

    private final Supplier<List<T>> databaseLoader;

    public DatabaseSource(Supplier<List<T>> databaseLoader) {
        this.databaseLoader = Objects.requireNonNull(databaseLoader, "databaseLoader must not be null");
    }

    @Override
    public List<T> load() {
        return List.copyOf(databaseLoader.get());
    }
}

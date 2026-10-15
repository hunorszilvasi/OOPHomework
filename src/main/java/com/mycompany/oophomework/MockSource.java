package com.mycompany.oophomework;

import java.util.List;

/** Exercise 1 (PDF p. 17): provides sample content without external connections. */
public final class MockSource<T> implements ContentSource<T> {

    private final List<T> items;

    public MockSource(List<T> items) {
        this.items = List.copyOf(items);
    }

    @Override
    public List<T> load() {
        return items;
    }
}

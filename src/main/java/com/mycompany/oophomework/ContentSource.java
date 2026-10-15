package com.mycompany.oophomework;

import java.util.List;

/** Exercise 1 (PDF p. 17) and Exercise 4 (PDF p. 49): replaceable content source. */
public interface ContentSource<T> {

    List<T> load();
}

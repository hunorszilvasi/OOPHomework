package com.mycompany.oophomework.exercise4;

import com.mycompany.oophomework.exercise2.News;
import java.util.List;

/** Exercise 4 (PDF p. 49): loads a list of news items from a source. */
public interface ContentSource {

    List<News> load();
}

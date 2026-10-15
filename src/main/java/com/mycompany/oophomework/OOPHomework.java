/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.oophomework;

import com.mycompany.oophomework.exercise1.ContentSource;
import com.mycompany.oophomework.exercise1.DatabaseSource;
import com.mycompany.oophomework.exercise1.MockSource;
import com.mycompany.oophomework.exercise1.RssSource;
import java.util.List;

/**
 * Exercise 1 (PDF p. 17): demonstrates interchangeable content sources.
 */
public class OOPHomework {

    public static void main(String[] args) {
        ContentSource<String> source = new RssSource<>(
                () -> List.of("RSS item one", "RSS item two"));
        printItems(source);

        source = new DatabaseSource<>(
                () -> List.of("Database item"));
        printItems(source);

        source = new MockSource<>(
                List.of("Mock item for an offline run"));
        printItems(source);
    }

    private static void printItems(ContentSource<String> source) {
        source.load().forEach(System.out::println);
    }
}

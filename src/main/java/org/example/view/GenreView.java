package org.example.view;

import org.example.model.Genre;

import java.util.List;

public class GenreView {
    public void afficheGenres(List<Genre> genres) {
        System.out.println("\n Liste des Genres:");
        for (Genre genre : genres) {
            System.out.println("ID: " + genre.getId() +
                    ", type: " + genre.getType());
        }
        System.out.println("\n");
    }
}

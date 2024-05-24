package org.example.view;

import org.example.model.Film;

import java.util.List;

public class FilmView {

    public void afficheFilms(List<Film> films) {
        System.out.println("\n Liste:");
        for (Film film : films) {
            System.out.println("ID: " + film.getId() +
                    ", Titre: " + film.getTitre() +
                    "\n Description: " + film.getDescription() +
                    " \n Affiche: " + film.getAffiche() +
                    " \n Genre: " + (film.getGenre() != null ? film.getGenre().getType() : "N/A"));
            System.out.println("\n");
        }
        System.out.println("\n");
    }

    public void affiche1Film(Film film) {
        System.out.println("ID: " + film.getId() +
                ", Titre: " + film.getTitre() +
                "\n Description: " + film.getDescription() +
                " \n Affiche: " + film.getAffiche() +
                " \n Genre: " + (film.getGenre() != null ? film.getGenre().getType() : "N/A"));
    }
}

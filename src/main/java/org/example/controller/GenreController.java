package org.example.controller;

import org.example.model.Film;
import org.example.model.FilmDAO;
import org.example.model.Genre;
import org.example.model.GenreDAO;
import org.example.view.FilmView;
import org.example.view.GenreView;

import java.util.List;

public class GenreController {

    private GenreView viewGenre;
    private GenreDAO genreDAO;

    public GenreController(){
        this.viewGenre = new GenreView();;
        this.genreDAO = new GenreDAO();
    }

    public void afficherGenres(){
        List<Genre> genres = GenreDAO.getGenres();
        viewGenre.afficheGenres(genres);
    }
}

package org.example.controller;

import org.example.model.*;
import org.example.view.FilmView;

import java.util.List;

public class FilmController {



        private FilmView viewFilm;
        private FilmDAO filmDAO;
        private GenreDAO genreDAO;
        private RealDAO realDAO;

        public FilmController(){
            this.viewFilm = new FilmView();
            this.filmDAO = new FilmDAO();
            this.genreDAO = new GenreDAO();
            this.realDAO = new RealDAO();
        }

    public void ajouterFilm(String titre, String description, String affiche, Genre genre, Real real) {
        if (genre != null) {
            Film film = new Film(titre, description, affiche, genre, real);
            filmDAO.ajouterFilm(film);
        } else {
            System.out.println("Genre cannot be null.");
        }
    }


    public void deleteFilm(int id){
            filmDAO.deleteFilm(id);
        }

    public void updateFilm(int id, String titre, String description, String affiche, Genre genre, Real real) {
        Film existingFilm = filmDAO.getFilmById(id);

        if (existingFilm != null) {
            existingFilm.setTitre(titre);
            existingFilm.setDescription(description);
            existingFilm.setAffiche(affiche);
            existingFilm.setGenre(genre);
            existingFilm.setReal(real);

            filmDAO.updateFilm(existingFilm);
            System.out.println("Film updated successfully!");
        } else {
            System.out.println("Film with ID " + id + " not found.");
        }
    }


    public void afficherFilms(){
            List<Film> films = filmDAO.getFilms();
            viewFilm.afficheFilms(films);
    }

    public void affiche1Film(int id){
        Film film = filmDAO.getFilmById(id);
        if (film != null) {
            viewFilm.affiche1Film(film);
        } else {
            System.out.println("Film not found with ID: " + id);
        }
    }

    public void afficherFilmsParGenre(int genreId) {
        Genre genre = genreDAO.getGenreById(genreId);
        if (genre != null) {
            List<Film> films = filmDAO.getFilmsByGenre(genre);
            System.out.println("\n Liste des films de genre: "+ genre.getType());
            if (films != null && !films.isEmpty()) {
                viewFilm.afficheFilms(films);
            } else {
                System.out.println("No films found for genre: " + genre.getType());
            }
        } else {
            System.out.println("Genre with ID " + genreId + " not found.");
        }
    }

    public void afficherFilmsParReal(int realId) {
        Real real = realDAO.getRealById(realId);
        if (real != null) {
            List<Film> films = filmDAO.getFilmsByReal(real);
            System.out.println("\n Liste des films réalisés par: "+ real.getPrenom() + " " + real.getNom());
            if (films != null && !films.isEmpty()) {
                viewFilm.afficheFilms(films);
            } else {
                System.out.println("No films found for real: " + real.getPrenom() + " " + real.getNom());
            }
        } else {
            System.out.println("Real with ID " + realId + " not found.");
        }
    }

}


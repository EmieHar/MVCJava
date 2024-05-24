package org.example;

import org.example.controller.ActorController;

import org.example.controller.FilmController;
import org.example.controller.GenreController;
import org.example.controller.RealController;
import org.example.model.Actor;
import org.example.model.Film;
import org.example.model.Genre;
import org.example.model.GenreDAO;

import java.util.List;

public class ActMVC {

    public static void main(String[] args){
        ActorController ac = new ActorController();

//       ac.ajouterActor(new Actor("Joli", "Angelina", "photo2.jpeg",4));
//        ac.ajouterActor(new Actor("Pit", "Brad", "photo3.jpeg",5));
        //ac.ajouterActor(new Actor("Pattinson", "Robert", "photo.jpeg"));
        //ac.deleteActor(18);

        //ac.afficherActors();

        //ac.affiche1Actor(1);
//        ac.affiche1Actor(2);
//        ac.affiche1Actor(5);

//        int actorIdToDelete = 6; // ID de l'acteur à supprimer
//        ac.suppr1Actor(actorIdToDelete);

        //ac.ajouterActor(new Actor("mémé", "orties", "photo3.jpeg"));

//        ac.afficherActors();
//
//        ac.deleteActor(6);
//
//        ac.afficherActors();

        //ac.updateActor(15, "Doudou", "Kivin", "mignon.png");



    GenreController g = new GenreController();
    g.afficherGenres();

    RealController r = new RealController();
    r.afficherReals();

    FilmController mv = new FilmController();

    mv.afficherFilmsParReal(1);
    //mv.updateFilm( 1,"Twilight1-Fascination", "De la daube en barre","affiche.png", 10);



//        int genreId = 10;
//        int genreId2 = 1;
        // Obtenez l'objet Genre associé à l'ID du genre que vous voulez
//        genre = genreDAO.getGenreById(genreId);
//        Genre genre2 = genreDAO.getGenreById(genreId2);
        // Créez un nouveau film en utilisant l'objet Genre obtenu

        //mv.ajouterFilm("Furiosa", "De l'action","afficheFilm.png",genre2);
//        mv.ajouterFilm("Twilight2-Tentation", "Ils ont reussi a faire pire","affiche2.png",genre);
//        mv.ajouterFilm("Twilight3-Hesitation", "mais ils persistent!", "affiche3.png",genre);

        // Modifier un film existant
//        int filmIdToUpdate = 4; // ID du film à mettre à jour
//        mv.updateFilm(filmIdToUpdate, "Twilight3-Revelation", "non mais serieux?! encore un! ils s'obstinent!", "affiche4.png",genre);

//        mv.affiche1Film(1);
//        mv.afficherFilms();
//        mv.afficherFilmsParGenre(10);
//
//        FilmController mv2 = new FilmController();
//        GenreDAO genreDAO2 = new GenreDAO();
//
//        // Obtenez l'objet Genre associé à l'ID du genre que vous voulez
//        int genreId = 10; // ID du genre que vous voulez
//        Genre genre2 = genreDAO2.getGenreById(genreId); // Assurez-vous que genreDAO est initialisé
//
//        if (genre2 != null) {
//
//            // Afficher tous les films
//            mv.afficherFilms();
//
//            // Afficher tous les films d'un genre donné
//            mv.afficherFilmsParGenre(genreId);
//        } else {
//            System.out.println("Genre with ID " + genreId + " not found.");
//        }

    }
}

package org.example;

import org.example.controller.ActorController;
import org.example.model.Actor;

public class ActMVC {

    public static void main(String[] args){
        ActorController ac = new ActorController();

//        ac.ajouterActor(new Actor("Joli", "Angelina", "photo2.jpeg",4));
//        ac.ajouterActor(new Actor("Pit", "Brad", "photo3.jpeg",5));
        ac.ajouterActor(new Actor("Stewart", "Kristen", "photo4.jpeg",6));
        ac.deleteActor(18);

        ac.afficherActors();

        ac.affiche1Actor(1);
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

    }
}

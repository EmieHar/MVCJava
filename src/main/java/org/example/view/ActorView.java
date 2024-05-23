package org.example.view;

import org.example.model.Actor;

import java.util.List;

public class ActorView {
    public void afficheActors(List<Actor> actors) {
        System.out.println("\n Liste:");
        for (Actor actor : actors) {
            System.out.println("ID: " + actor.getId() + ", Name: " + actor.getPrenom() + " " + actor.getNom() + ", Photo: " + actor.getPhoto());
        }
        System.out.println("\n");
    }

    public void affiche1Actor(Actor actor) {
        System.out.println("ID: " + actor.getId() + ", Name: " + actor.getPrenom() + " " + actor.getNom() + ", Photo: " + actor.getPhoto() + "\r\n");
    }
}

package org.example.controller;

import org.example.model.Actor;
import org.example.model.ActorDAO;
import org.example.view.ActorView;

import java.util.List;

public class ActorController {
    private ActorView viewActor;
    private ActorDAO actorDAO;

    public ActorController(){
        this.viewActor = new ActorView();
        this.actorDAO = new ActorDAO();
        this.actorDAO.Dbconnect();
    }

    public void ajouterActor(Actor act){
        actorDAO.ajouterActor(act);
    }

    public void deleteActor(int id){
        actorDAO.deleteActor(id);
    }

    public void updateActor(int id, String nom, String prenom, String photo){
        actorDAO.updateActor(id, nom, prenom, photo);
    }

    public void afficherActors(){
        List<Actor> actors = actorDAO.getActeurs();
        viewActor.afficheActors(actors);
    }

    public void affiche1Actor(int id){
        Actor actor = actorDAO.getActorById(id);
        if (actor != null) {
            viewActor.affiche1Actor(actor);
        } else {
            System.out.println("Actor not found with ID: " + id);
        }
    }

}

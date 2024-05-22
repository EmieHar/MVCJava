package org.example.model;

import java.util.List;

public class Actor {

    private int id;
    private String prenom;
    private String nom;
    private String photo;


    public Actor(String name, String firstname, String photo) {
        this.nom = name;
        this.prenom = firstname;
        this.photo = photo;
    }

    public Actor(String name, String firstname, String photo, int id) {
        this.nom = name;
        this.prenom = firstname;
        this.photo = photo;
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String firstname) {
        this.prenom = firstname;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String name) {
        this.nom = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public static List<Actor> afficherActors() {
        ActorDAO actorDAO = new ActorDAO();
        return actorDAO.getActeurs();
    }


    public static Actor getActorById(int actorId){
        ActorDAO actorDAO = new ActorDAO();
        return actorDAO.getActorById(actorId);
    }

    public static void ajouterActor(Actor actor) {
        ActorDAO actorDAO = new ActorDAO();
        actorDAO.ajouterActor(actor);
    }

    public static void deleteActor(int actorId){
        ActorDAO actorDAO = new ActorDAO();
        actorDAO.deleteActor(actorId);
    }

    public static void updateActor(int actorId, String nom, String prenom, String photo){
        ActorDAO actorDAO = new ActorDAO();
        actorDAO.updateActor(actorId, nom, prenom, photo);
    }
}

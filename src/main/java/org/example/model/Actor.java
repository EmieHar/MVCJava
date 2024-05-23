package org.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="acteur")

public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "IdActeur")
    private int id;
    private String prenom;
    private String nom;
    private String photo;

    public Actor() {
    }

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
}

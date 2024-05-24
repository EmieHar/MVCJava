package org.example.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="realisateur")

public class Real {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idReal")
    private int id;
    private String nom;
    private String prenom;

    @OneToMany(mappedBy = "real", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Film> films;

    public Real(){}

    public Real(String nom, String prenom) {
        this.nom = nom;
        this.prenom =prenom;
    }

    public Real(String nom, String prenom, int id) {
        this.nom = nom;
        this.prenom =prenom;
        this.id=id;
    }

        public int getId() {
            return id;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public Set<Film> getFilms() {
            return films;
        }

        public void setFilms(Set<Film> films) {
            this.films = films;
        }

    }



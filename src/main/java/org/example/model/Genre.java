package org.example.model;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_genre")
    private int id;
    private String type;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL, orphanRemoval = true)
    //cascade permet de mettre à jour automatiquement les films si un genre est modif
    //orphanRemoval supprimera tout film qui n'aura pas de genre
    //private List<Film> film --> créé une liste donc un film peut y être en double, Set<Film> crée une liste où chaque élément n'apparait qu'un fois
    private Set<Film> films;

    public Genre(){}

    public Genre(String type) {
        this.type = type;
    }

    public Genre(String type, int id) {
        this.type = type;
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

}

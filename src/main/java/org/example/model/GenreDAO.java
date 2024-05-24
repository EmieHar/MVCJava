package org.example.model;

import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class GenreDAO {

    Connection con = null;
    PreparedStatement preparedStatement = null;


    public static List<Genre> getGenres(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Genre";
        return (session.createQuery(hql, Genre.class).getResultList());
    }


    public Genre getGenreById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Genre.class, id);
        }
    }


    public void ajouterGenre(Genre genre) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Commencer une transaction
            transaction = session.beginTransaction();

            // Sauvegarder l'objet acteur
            session.save(genre);
            //autre méthodes pour version plus récentes:
            //session.presist(film);

            // Commettre la transaction
            transaction.commit();

            System.out.println("Genre added successfully!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            System.out.println("Failed to add genre");
        }
    }

    public void deleteGenre(int genreId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Commencer une transaction
            transaction = session.beginTransaction();

            // Récupérer l'acteur par son ID
            Genre genre = session.get(Genre.class, genreId);

            if (genre != null) {
                // Supprimer l'acteur
                session.remove(genre);
                System.out.println("Genre deleted successfully!");
            } else {
                System.out.println("Genre with ID " + genreId + " not found.");
            }

            // Commettre la transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            System.out.println("Failed to delete genre");
        }
    }


    public void updateGenre(Genre genre) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Commencer une transaction
            transaction = session.beginTransaction();

            // Récupérer l'acteur existant par son ID
            Genre existingGenre = session.get(Genre.class, genre.getId());
            if (existingGenre != null) {
                // Mettre à jour les champs de l'acteur existant
                existingGenre.setType(genre.getType());

                // Sauvegarder les modifications
                session.update(existingGenre);
                System.out.println("Genre updated successfully!");
            } else {
                System.out.println("Genre with ID " + genre.getId() + " not found.");
            }

            // Commettre la transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            System.out.println("Failed to update genre");
        }
    }



}

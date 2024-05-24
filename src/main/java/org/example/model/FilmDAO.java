package org.example.model;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class FilmDAO {


        Connection con = null;
        PreparedStatement preparedStatement = null;


        public List<Film> getFilms(){
            Session session = HibernateUtil.getSessionFactory().openSession();
            String hql = "FROM Film";
            return (session.createQuery(hql, Film.class).getResultList());
        }


        public Film getFilmById(int id){
            Session session = HibernateUtil.getSessionFactory().openSession();
            return (session.get(Film.class,id));
        }


        public void ajouterFilm(Film film) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                // Commencer une transaction
                transaction = session.beginTransaction();

                // Sauvegarder l'objet acteur
                session.save(film);
                //autre méthodes pour version plus récentes:
                //session.presist(film);

                // Commettre la transaction
                transaction.commit();

                System.out.println("Film added successfully!");
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
                System.out.println("Failed to add film");
            }
        }

        public void deleteFilm(int filmId) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                // Commencer une transaction
                transaction = session.beginTransaction();

                // Récupérer l'acteur par son ID
                Film film = session.get(Film.class, filmId);

                if (film != null) {
                    // Supprimer l'acteur
                    session.remove(film);
                    System.out.println("Film deleted successfully!");
                } else {
                    System.out.println("Film with ID " + filmId + " not found.");
                }

                // Commettre la transaction
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
                System.out.println("Failed to delete film");
            }
        }


    public void updateFilm(Film film) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(film);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Film> getFilmsByGenre(Genre genre) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Film WHERE genre = :genre";
            return session.createQuery(hql, Film.class)
                    .setParameter("genre", genre)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Film> getFilmsByReal(Real real) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Film WHERE real = :real";
            return session.createQuery(hql, Film.class)
                    .setParameter("real", real)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


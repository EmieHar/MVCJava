package org.example.model;

import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class RealDAO {


        Connection con = null;
        PreparedStatement preparedStatement = null;

        public static List<Real> getReals(){
            Session session = HibernateUtil.getSessionFactory().openSession();
            String hql = "FROM Real";
            return (session.createQuery(hql, Real.class).getResultList());
        }


        public Real getRealById(int id) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                return session.get(Real.class, id);
            }
        }


        public void ajouterReal(Real real) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                // Commencer une transaction
                transaction = session.beginTransaction();

                // Sauvegarder l'objet acteur
                session.save(real);
                //autre méthodes pour version plus récentes:
                //session.presist(film);

                // Commettre la transaction
                transaction.commit();

                System.out.println("Real added successfully!");
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
                System.out.println("Failed to add real");
            }
        }

        public void deleteReal(int realId) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                // Commencer une transaction
                transaction = session.beginTransaction();

                // Récupérer l'acteur par son ID
                Real real = session.get(Real.class, realId);

                if (real != null) {
                    // Supprimer l'acteur
                    session.remove(real);
                    System.out.println("Real deleted successfully!");
                } else {
                    System.out.println("Real with ID " + realId + " not found.");
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


        public void updateReal(Real real) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                // Commencer une transaction
                transaction = session.beginTransaction();

                // Récupérer l'acteur existant par son ID
                Real existingReal = session.get(Real.class, real.getId());
                if (existingReal != null) {
                    // Mettre à jour les champs de l'acteur existant
                    existingReal.setNom(real.getNom());
                    existingReal.setPrenom(real.getPrenom());

                    // Sauvegarder les modifications
                    session.update(existingReal);
                    System.out.println("Real updated successfully!");
                } else {
                    System.out.println("Real with ID " + real.getId() + " not found.");
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



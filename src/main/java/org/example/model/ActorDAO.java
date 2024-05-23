package org.example.model;


import com.mysql.cj.jdbc.MysqlDataSource;
import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ActorDAO {

//    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cinemamvc";
//    private static final String JDBC_USER = "root";
//    private static final String JDBC_PASSWORD = "";

    Connection con = null;
    PreparedStatement preparedStatement = null;

    // Database Connection will use jdbc driver from the mysql connector jar
    public void Dbconnect() {
        try {
            //mis en commentaires car nouveau moyen plus efficace et créant un pull de connection plutôt que des connections uniques à chaque fois
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            // connection to mysql
//            con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            MysqlDataSource ds = new MysqlDataSource();
            ds.setServerName("localhost");
            ds.setPort(3306);
            ds.setDatabaseName("cinemamvc");
            ds.setUser("root");
            ds.setPassword("");

            con = ds.getConnection();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

//    public List<Actor> getActeurs() {
//        List<Actor> acteurs = new ArrayList<>();
//
//        String query = "SELECT * FROM acteur";
//        Statement statement = null;
//        ResultSet rs = null;
//
//        try {
//            if (con == null || con.isClosed()) {
//                Dbconnect();
//            }
//             statement = con.createStatement();
//             rs = statement.executeQuery(query);
//
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("nom");
//                String fname = rs.getString("prenom");
//                String photo = rs.getString("photo");
//                acteurs.add(new Actor(name, fname, photo, id));
//            }
//        } catch (Exception e) {
//            System.out.println("MySQL JDBC driver not found");
//            e.printStackTrace();
//        } finally {
//            try {
//                if (rs != null) rs.close();
//                if (statement != null) statement.close();
//                if (con != null) con.close();
//            } catch (Exception e) {
//                System.out.println("close du finally a échoué");
//                e.printStackTrace();
//            }
//        }
//
//        return acteurs;
//    }

    public List<Actor> getActors(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Actor";
        return (session.createQuery(hql, Actor.class).getResultList());
    }

//    public Actor getActorById(int actorId) {
//        Actor actor = null;
//        ResultSet resultSet = null;
//        String sqlQuery = "SELECT * FROM acteur WHERE id = ?";
//        try {
//            if (con == null || con.isClosed()) {
//                Dbconnect();
//            }
//            preparedStatement = con.prepareStatement(sqlQuery);
//            preparedStatement.setInt(1, actorId);
//
//            resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("nom");
//                String firstname = resultSet.getString("prenom");
//                String photo = resultSet.getString("photo");
//                actor = new Actor(name, firstname, photo, id);
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            try {
//                if (resultSet != null) resultSet.close();
//                if (preparedStatement != null) preparedStatement.close();
//                if (con != null) con.close();
//            } catch (Exception e) {
//                System.out.println("close du finally a échoué");
//                e.printStackTrace();
//            }
//        }
//        return actor;
//    }


    public Actor getActorById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (session.get(Actor.class,id));
    }


//    public void ajouterActor(Actor actor) {
//
//        String sqlInsert = "INSERT INTO acteur (prenom, nom, photo) VALUES(?,?,?)";
//
//        try {
//            if (con == null || con.isClosed()) {
//                Dbconnect();
//            }
//
//            // si plusieurs insert ou action sur bdd, mettre auto commit à false pour que tout se fasse en une fois ou s'il y a un pb que le rollback soit actif
//            con.setAutoCommit(false);
//            preparedStatement = con.prepareStatement(sqlInsert);
//
//                preparedStatement.setString(1, actor.getPrenom());
//                preparedStatement.setString(2, actor.getNom());
//                preparedStatement.setString(3, actor.getPhoto());
//                preparedStatement.executeUpdate();
//                con.commit();
//                System.out.println("Actor added successfully!");
//
//
//        } catch (SQLException e) {
//           try{
//               con.rollback();
//           } catch(SQLException ex){
//               ex.printStackTrace();
//           }
//        } finally {
//            try{
//                if (preparedStatement != null) preparedStatement.close();
//                if (con != null) con.close();
//            } catch (Exception e){
//                System.out.println("close du finally a échoué");
//            }
//        }
//    }

    public void ajouterActor(Actor actor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Commencer une transaction
            transaction = session.beginTransaction();

            // Sauvegarder l'objet acteur
            session.save(actor);

            // Commettre la transaction
            transaction.commit();

            System.out.println("Actor added successfully!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            System.out.println("Failed to add actor");
        }
    }

//    public void deleteActor(int actorId) {
//        Actor actor = getActorById(actorId);
//        if (actor == null) {
//            System.out.println("No actor found with ID " + actorId);
//        }
//
//        String deleteQuery = "DELETE FROM acteur WHERE id = ?";
//
//        try {
//            if (con == null || con.isClosed()) {
//                Dbconnect();
//            }
//
//            try (PreparedStatement deleteStatement = con.prepareStatement(deleteQuery)) {
//                deleteStatement.setInt(1, actorId);
//                int rowsAffected = deleteStatement.executeUpdate();
//                if (rowsAffected > 0) {
//                    System.out.println("Actor with ID " + actorId + " deleted successfully.");
//                } else {
//                    System.out.println("Failed to delete actor with ID " + actorId);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally{
//            try{
//                if (preparedStatement != null) preparedStatement.close();
//                if (con != null) con.close();
//            }catch(Exception e){
//                System.out.println("close du finally a échoué");
//            }
//        }
//
//    }

    public void deleteActor(int actorId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Commencer une transaction
            transaction = session.beginTransaction();

            // Récupérer l'acteur par son ID
            Actor actor = session.get(Actor.class, actorId);

            if (actor != null) {
                // Supprimer l'acteur
                session.remove(actor);
                System.out.println("Actor deleted successfully!");
            } else {
                System.out.println("Actor with ID " + actorId + " not found.");
            }

            // Commettre la transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            System.out.println("Failed to delete actor");
        }
    }


//    public void updateActor(int actorId, String nom, String prenom, String photo) {
//        Actor actor = getActorById(actorId);
//        if (actor == null) {
//            System.out.println("No actor found with ID " + actorId);
//        }
//
//        String updateQuery = "UPDATE acteur  SET nom = ?, prenom = ?, photo = ? WHERE id = ?";
//
//        try {
//            if (con == null || con.isClosed()) {
//                Dbconnect();
//            }
//
//            con.setAutoCommit(false);
//            preparedStatement = con.prepareStatement(updateQuery);
//
//                preparedStatement.setString(1, nom);
//                preparedStatement.setString(2, prenom);
//                preparedStatement.setString(3, photo);
//                preparedStatement.setInt(4, actorId);
//
//                int rowsAffected = preparedStatement.executeUpdate();
//                if (rowsAffected > 0) {
//                    System.out.println("Actor with ID " + actorId + " updated successfully.");
//                } else {
//                    System.out.println("No actor found with ID " + actorId);
//                }
//
//    } catch (SQLException e) {
//        try{
//            con.rollback();
//        } catch(SQLException ex){
//            ex.printStackTrace();
//        }
//    } finally {
//        try{
//            if (preparedStatement != null) preparedStatement.close();
//            if (con != null) con.close();
//        } catch (Exception e){
//            System.out.println("close du finally a échoué");
//        }
//    }
//
//   }

    public void updateActor(Actor actor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Commencer une transaction
            transaction = session.beginTransaction();

            // Récupérer l'acteur existant par son ID
            Actor existingActor = session.get(Actor.class, actor.getId());
            if (existingActor != null) {
                // Mettre à jour les champs de l'acteur existant
                existingActor.setNom(actor.getNom());
                existingActor.setPrenom(actor.getPrenom());
                existingActor.setPhoto(actor.getPhoto());

                // Sauvegarder les modifications
                session.update(existingActor);
                System.out.println("Actor updated successfully!");
            } else {
                System.out.println("Actor with ID " + actor.getId() + " not found.");
            }

            // Commettre la transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            System.out.println("Failed to update actor");
        }
    }
}

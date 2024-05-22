package org.example.model;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ActorDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cinemamvc";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    Connection con = null;
    PreparedStatement preparedStatement = null;

    // Database Connection will use jdbc driver from the mysql connector jar
    public void Dbconnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // connection to mysql
            con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public List<Actor> getActeurs() {
        List<Actor> acteurs = new ArrayList<>();

        String query = "SELECT * FROM acteur";
        try {
            if (con == null || con.isClosed()) {
                Dbconnect();
            }
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("nom");
                String fname = rs.getString("prenom");
                String photo = rs.getString("photo");
                acteurs.add(new Actor(name, fname, photo, id));
            }
        } catch (Exception e) {
            System.out.println("MySQL JDBC driver not found");
            e.printStackTrace();
        }

        return acteurs;
    }

    public Actor getActorById(int actorId) {
        Actor actor = null;
        String sqlQuery = "SELECT * FROM acteur WHERE id = ?";
        try {
            if (con == null || con.isClosed()) {
                Dbconnect();
            }
            preparedStatement = con.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, actorId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("nom");
                String firstname = resultSet.getString("prenom");
                String photo = resultSet.getString("photo");
                actor = new Actor(name, firstname, photo, id);
            }
            return actor;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ajouterActor(Actor actor) {
        System.out.println(actor.getNom());
        String sqlInsert = "INSERT INTO acteur (prenom, nom, photo) VALUES(?,?,?)";

        try {
            if (con == null || con.isClosed()) {
                Dbconnect();
            }

            try (PreparedStatement preparedStatement = con.prepareStatement(sqlInsert)) {
                preparedStatement.setString(1, actor.getPrenom());
                preparedStatement.setString(2, actor.getNom());
                preparedStatement.setString(3, actor.getPhoto());
                preparedStatement.executeUpdate();
                System.out.println("Actor added successfully!");
            }

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteActor(int actorId) {
        Actor actor = getActorById(actorId);
        if (actor == null) {
            System.out.println("No actor found with ID " + actorId);
        }

        String deleteQuery = "DELETE FROM acteur WHERE id = ?";

        try {
            if (con == null || con.isClosed()) {
                Dbconnect();
            }

            try (PreparedStatement deleteStatement = con.prepareStatement(deleteQuery)) {
                deleteStatement.setInt(1, actorId);
                int rowsAffected = deleteStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Actor with ID " + actorId + " deleted successfully.");
                } else {
                    System.out.println("Failed to delete actor with ID " + actorId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateActor(int actorId, String nom, String prenom, String photo) {
        Actor actor = getActorById(actorId);
        if (actor == null) {
            System.out.println("No actor found with ID " + actorId);
        }

        String updateQuery = "UPDATE acteur  SET nom = ?, prenom = ?, photo = ? WHERE id = ?";

        try {
            if (con == null || con.isClosed()) {
                Dbconnect();
            }

            try (PreparedStatement preparedStatement = con.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, nom);
                preparedStatement.setString(2, prenom);
                preparedStatement.setString(3, photo);
                preparedStatement.setInt(4, actorId);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Actor with ID " + actorId + " updated successfully.");
                } else {
                    System.out.println("No actor found with ID " + actorId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}

package covoiturage.bl.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class Connexion {
    private String DBPath = "D:\\";
    private Connection connection = null;
    private Statement statement = null;
 
    public Connexion(String dBPath) {
        DBPath += dBPath;
    }
 
    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + DBPath);
            statement = connection.createStatement();
            System.out.println("Connexion a " + DBPath + " avec succès");
        } catch (ClassNotFoundException notFoundException) {
            notFoundException.printStackTrace();
            System.out.println("Erreur de connecxion");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Erreur de connecxion");
        }
    }
 
    public void close() {
        try {
            connection.close();
            statement.close();
            System.out.println("Férmeture de " + DBPath + " avec succès");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet query(String requet) {
        ResultSet resultat = null;
        try {
            resultat = statement.executeQuery(requet);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur dans la requete : " + requet);
        }
        return resultat;
  
    }
    

    public void addUser(UserDB user) {
   	 try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO User VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setLong(1, user.getID());
            preparedStatement.setString(2, user.getSexe());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getAdressNumber());
            preparedStatement.setString(7, user.getAddressWay());
            preparedStatement.setString(8, user.getAddressCP());
            preparedStatement.setString(9, user.getAddressCity());
            preparedStatement.setString(10, user.getLongitude());
            preparedStatement.setString(11, user.getLatitude());
            preparedStatement.setString(12, user.getPhoneNumber());
     
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

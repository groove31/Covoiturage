package covoiturage.bl.tu;

import covoiturage.bl.model.Connexion;

import covoiturage.bl.model.UserDB;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

public class ConnexionInsert {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
        Connexion connexion = new Connexion("Covoiturage.db");
        connexion.connect();
 
        UserDB user = new UserDB(2,"M","Doe","John","tata@fr.rt","2","4","rue des écoles","31290","Villenouvelle","","",
        		"true","true", "10");
        
        connexion.addUser(user);
        ResultSet resultSet = connexion.query("SELECT * FROM User");
        try {
            while (resultSet.next()) {
                System.out.println("Nom : "+resultSet.getString("lastName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connexion.close();
	}

}

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import covoiturage.bl.model.Connexion;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnexionSelect {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		
      Connexion connexion = new Connexion("Covoiturage.db");
      connexion.connect();
      
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

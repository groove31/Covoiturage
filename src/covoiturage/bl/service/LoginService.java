package covoiturage.bl.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import covoiturage.bl.model.Connexion;
import covoiturage.bl.model.User;

public class LoginService {

	public LoginService() {
		// TODO Auto-generated constructor stub
	}

	
	public User findUser(String email, String pwd1) {
		User user = new User();
		boolean resultatExiste = false;
		//		Map<String, String> erreurs = new HashMap<String,String>();
		Connexion connexion = new Connexion("Covoiturage.db");
		connexion.connect();
		String sql = "SELECT * FROM User where lower(email) = '"+ email.toLowerCase() + "'" +
				" and password = '" + pwd1 + "'";
		ResultSet resultSet = connexion.query(sql);
		
		if (resultSet == null) {
			return null;
		} 
		
		try {
			if (resultSet.next()) {
				resultatExiste = true;
                try {
                       user.setLastName(resultSet.getString(Constantes.FIELD_LASTNAME));
                       user.setEmail(resultSet.getString(Constantes.FIELD_EMAIL));
                       user.setFirstName(resultSet.getString(Constantes.FIELD_FIRSTNAME));
                       user.setAdressNumber(resultSet.getString(Constantes.FIELD_ADDRESSNUMBER));
                       user.setAddressWay(resultSet.getString(Constantes.FIELD_ADDRESSWAY));
                       user.setAddressCP(resultSet.getString(Constantes.FIELD_ADDRESSCP));
                       user.setAddressCity(resultSet.getString(Constantes.FIELD_ADDRESSCITY));
                       user.setPhoneNumber(resultSet.getString(Constantes.FIELD_PHONENUMBER));
                       user.setSexe(resultSet.getString(Constantes.FIELD_SEXE));
                       user.setIsConducteur(resultSet.getString(Constantes.FIELD_ISCONDUCTEUR));
                       user.setIsSmoker(resultSet.getString(Constantes.FIELD_ISSMOKER));
                       user.setArea(resultSet.getString(Constantes.FIELD_AREA));
                       user.setLatitude(resultSet.getString(Constantes.FIELD_LATITUDE));
                       user.setLongitude(resultSet.getString(Constantes.FIELD_LONGITUDE));
                } catch (SQLException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
                }
				
				connexion.close();
			}
		} catch (SQLException e) {
			resultatExiste = false;

		}
		if (resultatExiste) {
			return user;
		} else {
			return null;
		}
	}
}

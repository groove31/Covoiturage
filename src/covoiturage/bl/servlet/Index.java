package covoiturage.bl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.parser.ParserBasicInformation;

import covoiturage.bl.model.Connexion;
import covoiturage.bl.model.UserDB;
import com.google.gson.*;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL="/index.jsp";
	private static final String ADDRESSE_BL = "64 Rue Jean Rostand, 31670 Labège";
	private static List<String> listeAdresses = new ArrayList<String>(); 
	public static final String FIELD_EMAIL = "email";
	public static final String FIELD_PASSWORD = "password";
	public static final String FIELD_PWD1 = "pwd1";
	public static final String FIELD_PWD2 = "pwd2";
	public static final String FIELD_FIRSTNAME = "firstName";
	public static final String FIELD_LASTNAME = "lastName";
	public static final String FIELD_ADRESSNUMBER = "addressNumber";
	public static final String FIELD_ADRESSWAY = "addressWay";
	public static final String FIELD_ADRESSCP = "addressCp";
	public static final String FIELD_ADRESSCITY = "addressCity";
	public static final String FIELD_LONGITUDE = "longitude";
	public static final String FIELD_LATITUDE = "latitude";
	public static final String FIELD_PHONENUMBER = "phoneNumber";
	public static final String FIELD_SEXE = "sexe";
	public static final String FIELD_ISCONDUCTEUR = "isConducteur";
	public static final String FIELD_ISSMOKER = "isSmoker";
	public static final String FIELD_AREA = "area";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Index() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("ADDRESSE_BL", ADDRESSE_BL);

//		listeAdresses.add("\"Place François Mitterrand, 31750 Escalquens, France\"");
//		listeAdresses.add("\"48, rue des Fontanelles, 31320 Castanet-Tolosan, France\"");
//		listeAdresses.add("\"29 Avenue de Toulouse, 31320 Castanet-Tolosan\"");
//		listeAdresses.add("\"8 Allée de l'Appel du 18 juin 1940, 31130 Balma, France\"");

//		request.setAttribute("conducteurs", listeAdresses);

		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String latitude = request.getParameter(FIELD_LATITUDE);
		String longitude = request.getParameter(FIELD_LONGITUDE);
		String area = request.getParameter(FIELD_AREA);
		ArrayList<UserDB> listeUserDB = new ArrayList<UserDB>();
		UserDB userDB;

		// recuperer la liste des conducteurs
		boolean resultatExiste = false;
		Connexion connexion = new Connexion("Covoiturage.db");
		connexion.connect();

		ResultSet resultSet = connexion.query("SELECT * FROM User where isConducteur != ''");
		// si resultSet est vide ou null, alors resultatExiste = false
		// si resultSet n'est pas vide, alors resultatExite = true

		if (resultSet == null) {
			resultatExiste = false;
			connexion.close();
		} 

		try {
			while (resultSet.next()) {
				resultatExiste = true;
				userDB = new UserDB(0,
						resultSet.getString(FIELD_EMAIL),
						resultSet.getString(FIELD_LASTNAME),
						resultSet.getString(FIELD_FIRSTNAME),
						resultSet.getString(FIELD_ADRESSNUMBER),
						resultSet.getString(FIELD_ADRESSWAY),
						resultSet.getString(FIELD_ADRESSCP),
						resultSet.getString(FIELD_ADRESSCITY),
						resultSet.getString(FIELD_LONGITUDE),
						resultSet.getString(FIELD_LATITUDE),
						resultSet.getString(FIELD_SEXE),
						resultSet.getString(FIELD_PHONENUMBER),
						resultSet.getString(FIELD_ISCONDUCTEUR),
						resultSet.getString(FIELD_ISSMOKER),
						resultSet.getString(FIELD_AREA),
						resultSet.getString(FIELD_PASSWORD)
						);
				System.out.println(userDB.getLastName());
				double lat = tryParseDouble(userDB.getLatitude());
				double lng = tryParseDouble(userDB.getLongitude());
				if( (lat > 0) && (lng > 0 ) ) {
					if( distance(lat, tryParseDouble(latitude), lng,tryParseDouble(longitude)) <= (tryParseDouble(area)*1000) ) {
						listeUserDB.add(userDB);
					} else {
						System.out.println(distance(lat, tryParseDouble(latitude), lng,tryParseDouble(longitude)));
						System.out.println("> " + (tryParseDouble(area)*1000));
					}
				}
			}
		} catch (SQLException e) {
			//			resultatExiste = false;

		} finally {
			if (connexion != null) {
				connexion.close();
			}
		}



		// pour chaque conducteur, calculer la distance ( getDistanceLatLng() ) entre   (latitude / longitude) et (user.latitude / user.longitude)
		// revoyer la liste des UserDB pour lesquels getDistanceLatLng() <= area

		Gson gson = new Gson();
		String json = new Gson().toJson(listeUserDB);
		System.out.println(json);

		response.reset();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.setStatus(HttpServletResponse.SC_OK);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		//		doGet(request, response);
	}

	private double tryParseDouble(String str) {
		double retVal;
		try {
			retVal = Double.parseDouble( str);
		} catch (NumberFormatException nfe) {
			retVal = 0; // or null if that is your preference
		}
		return retVal;
	}

	/*
	 * Calculate distance between two points in latitude and longitude taking
	 * into account height difference. If you are not interested in height
	 * difference pass 0.0. Uses Haversine method as its base.
	 * 
	 * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
	 * el2 End altitude in meters
	 * @returns Distance in Meters
	 */
	private static double distance(double lat1, double lat2, double lon1,
			double lon2) {

		final int R = 6371; // Radius of the earth

		Double latDistance = Math.toRadians(lat2 - lat1);
		Double lonDistance = Math.toRadians(lon2 - lon1);
		Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
				+ Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
				* Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c * 1000; // convert to meters

		distance = Math.pow(distance, 2);

		return Math.sqrt(distance);
	}


}

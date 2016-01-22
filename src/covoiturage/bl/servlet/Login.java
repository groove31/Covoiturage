package covoiturage.bl.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import covoiturage.bl.model.Connexion;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL="/WEB-INF/login.jsp";
	public static String VIEW_PAGES_URL_LIST="/ListDriver";
	public static final String FIELD_EMAIL = "email";
	public static final String FIELD_PWD1 = "pwd1";
	public static final String FIELD_LONGITUDE = "longitude";
	public static final String FIELD_LATITUDE = "latitude";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter(FIELD_EMAIL);
		String pwd1 = request.getParameter(FIELD_PWD1);
		
		String longitude = "";
		String latitude = "";
		String actionMessage = "";
		boolean resultatExiste = false;
		//		Map<String, String> erreurs = new HashMap<String,String>();
		Connexion connexion = new Connexion("Covoiturage.db");
		connexion.connect();
		String sql = "SELECT * FROM User where lower(email) = '"+ email.toLowerCase() + "'" +
				" and password = '" + pwd1 + "'";
		ResultSet resultSet = connexion.query(sql);
		// si resultSet est vide ou null, alors resultatExiste = false
		// si resultSet n'est pas vide, alors resultatExite = true
		
		if (resultSet == null) {
			resultatExiste = false;
			connexion.close();
			actionMessage = "Une erreur de BDD est survenue.";
			request.setAttribute("actionMessage", actionMessage);
			this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include(request, response);
		} 
		
		try {
			if (resultSet.next()) {
				resultatExiste = true;
				// Récupération de la longitude et de la latitude de la personne connectée
				longitude = resultSet.getString(FIELD_LONGITUDE);
				latitude = resultSet.getString(FIELD_LATITUDE);
				connexion.close();
			}
		} catch (SQLException e) {
			resultatExiste = false;

		}
		if (resultatExiste) {
			actionMessage = "Utilisateur accepté.";
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			
			session.setAttribute("longitude", longitude);
			session.setAttribute("latitude", latitude);
			
			request.setAttribute("actionMessage", actionMessage);
			//this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include(request, response);
			//getServletContext().getRequestDispatcher(VIEW_PAGES_URL_LIST).forward(request, response);
			response.sendRedirect("ListDriver");
			
		} else {
			actionMessage = "Utilisateur ou mot de passe incorrect.";
			request.setAttribute("actionMessage", actionMessage);
			request.setAttribute(FIELD_EMAIL, email);
			request.setAttribute(FIELD_PWD1, "");
			this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include(request, response);
		}
	}

}

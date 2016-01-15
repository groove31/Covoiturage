package covoiturage.bl.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import covoiturage.bl.model.Connexion;

/**
 * Servlet implementation class listDriver
 */
@WebServlet("/ListDriver")
public class ListDriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL="/WEB-INF/listDriver.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListDriver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String email = request.getParameter(FIELD_EMAIL);
		//String pwd1 = request.getParameter(FIELD_PWD1);
		
		String actionMessage = "";
		boolean resultatExiste = false;
		//		Map<String, String> erreurs = new HashMap<String,String>();
		Connexion connexion = new Connexion("Covoiturage.db");
		connexion.connect();
		String sql = "SELECT * FROM User  ";
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
				connexion.close();
			}
		} catch (SQLException e) {
			resultatExiste = false;

		}
		if (resultatExiste) {
			actionMessage = "Utilisateur accepté.";
			request.setAttribute("actionMessage", actionMessage);
			//this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include(request, response);
			getServletContext().getRequestDispatcher("/googlemaps.html").forward(request, response);
			
		} else {
			actionMessage = "Utilisateur ou mot de passe incorrect.";
			request.setAttribute("actionMessage", actionMessage);
			//request.setAttribute(FIELD_EMAIL, email);
			//request.setAttribute(FIELD_PWD1, "");
			this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include(request, response);
		}
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

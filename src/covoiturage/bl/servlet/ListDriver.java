package covoiturage.bl.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import covoiturage.bl.model.Connexion;
import covoiturage.bl.model.UserDB;
import covoiturage.bl.service.Constantes;

/**
 * Servlet implementation class listDriver
 */
@WebServlet("/ListDriver")
public class ListDriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL="/WEB-INF/listDriver.jsp";
	public static String VIEW_PAGES_URL_REGISTER="/WEB-INF/register.jsp";
	public static final String ATT_USERS = "users";
	public static final HashMap<String, UserDB> usersHashMap = new HashMap<String, UserDB>();
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
		//String email = request.getParameter(Constantes.FIELD_EMAIL);
		//String pwd1 = request.getParameter(Constantes.FIELD_PWD1);	
		request.setAttribute("ADDRESSE_BL", Constantes.ADDRESSE_BL);
			
		String actionMessage = "";
		boolean resultatExiste = false;
		Map<String, String> erreurs = new HashMap<String,String>();
				
		Connexion connexion = new Connexion("Covoiturage.db");
		connexion.connect();
		
		String sql = "SELECT * FROM User Order by ID ";
		
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
			HttpSession session = request.getSession();            
	         Map<String, UserDB> users = (HashMap<String, UserDB>) session.getAttribute( ATT_USERS );
	         
	          /* Si aucune map n'existe, alors initialisation d'une nouvelle map */
	           if ( users == null ) {
	            	users = usersHashMap;
	            }
	            
			while (resultSet.next()) {
				UserDB newUser=null;
				newUser=new UserDB(resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getString(5),
						resultSet.getString(6),
						resultSet.getString(7),
						resultSet.getString(8),
						resultSet.getString(9),
						resultSet.getString(10),
						resultSet.getString(11),
						resultSet.getString(12),
						resultSet.getString(13),
						resultSet.getString(14),
						resultSet.getString(15),
						resultSet.getString(16));
		          /* Puis ajout de l'utilisateur dans la map */
		          users.put( newUser.getEmail(), newUser );
			}
            /* Et enfin (ré)enregistrement de la map en session */
            session.setAttribute( ATT_USERS, users );

            String latitude, longitude;
            latitude = (String) session.getAttribute( Constantes.FIELD_LATITUDE );
            longitude = (String) session.getAttribute( Constantes.FIELD_LONGITUDE );
                  
			resultatExiste = true;
			connexion.close();
			
		} catch (SQLException e) {
			resultatExiste = false;
			e.printStackTrace();

		}

		
		System.out.println("On passe dans le doget de ListDriver");
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		String email;
		System.out.println("Passage ici");
		email = request.getParameter(Constantes.FIELD_EMAIL);
		System.out.println(email);
		request.setAttribute(Constantes.FIELD_EMAIL, email);		
		System.out.println("On passe par l�");
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL_REGISTER).forward(request, response);
	}

}

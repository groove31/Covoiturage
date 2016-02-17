package covoiturage.bl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import covoiturage.bl.model.Connexion;
import covoiturage.bl.model.UserDB;
import covoiturage.bl.service.Constantes;

/**
 * Servlet implementation class ListJson
 */
@WebServlet("/ListJson")
public class ListJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL="/WEB-INF/listDriver.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListJson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String email = request.getParameter(FIELD_EMAIL);
		//String pwd1 = request.getParameter(FIELD_PWD1);
		
		String actionMessage = "";
		ArrayList<UserDB> listeUserDB = new ArrayList<UserDB>();
		
		Connexion connexion = new Connexion("Covoiturage.db");
		connexion.connect();
		
		String sql = "SELECT * FROM User Order by ID ";
		
		ResultSet resultSet = connexion.query(sql);
		// si resultSet est vide ou null, alors resultatExiste = false
		// si resultSet n'est pas vide, alors resultatExite = true

		if (resultSet == null) {
			connexion.close();
			actionMessage = "Une erreur de BDD est survenue.";
			request.setAttribute("actionMessage", actionMessage);
			this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include(request, response);
		} 

		try {
			/* régles métier
			 * isConducteur= 1 => est conducteur, = 0 => n'est pas conducteur
			 * isSmoker= 1 => est fumeur, = 0 => n'est pas fumeur
			 * sexe= 1 => Homme ; = 2 est femme
			 */
			String s_isConducteur ="";
			String s_isSmoker="";
			String s_sexe ="";
			
			while (resultSet.next()) {
				UserDB newUser=null;

				s_sexe= (resultSet.getString(11).equals("1")) ? "H" : "F";
				s_isConducteur = (resultSet.getString(13).equals("0")) ? "N":"O";
				s_isSmoker= (resultSet.getString(14).equals("0")) ? "N" : "O";
				
				newUser = new UserDB(resultSet.getInt(1),
						resultSet.getString(Constantes.FIELD_EMAIL),
						resultSet.getString(Constantes.FIELD_LASTNAME),
						resultSet.getString(Constantes.FIELD_FIRSTNAME),
						resultSet.getString(Constantes.FIELD_ADDRESSNUMBER),
						resultSet.getString(Constantes.FIELD_ADDRESSWAY),
						resultSet.getString(Constantes.FIELD_ADDRESSCP),
						resultSet.getString(Constantes.FIELD_ADDRESSCITY),
						resultSet.getString(Constantes.FIELD_LONGITUDE),
						resultSet.getString(Constantes.FIELD_LATITUDE),
						resultSet.getString(s_sexe),
						resultSet.getString(Constantes.FIELD_PHONENUMBER),
						resultSet.getString(s_isConducteur),
						resultSet.getString(s_isSmoker),
						resultSet.getString(Constantes.FIELD_AREA),
						""
						);
		          /* Puis ajout de l'utilisateur dans la liste */
				listeUserDB.add(newUser);
			}
           connexion.close();
           Gson gson = new Gson();
	   		String json = new Gson().toJson(listeUserDB);
	   		System.out.println(json);
	
	   		response.reset();
	   		response.setContentType("application/json");
//	   		response.setCharacterEncoding("UTF-8");
	   		response.setStatus(HttpServletResponse.SC_OK);
	   		PrintWriter out = response.getWriter();
	   		out.print(json);
//	   		out.print("[{\"lastName\":\"OLLIER\",\"firstName\":\"Julien\"}]");
	   		out.flush();
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
		
		//this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

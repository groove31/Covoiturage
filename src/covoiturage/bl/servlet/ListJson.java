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

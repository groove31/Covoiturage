package covoiturage.bl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import covoiturage.bl.model.Connexion;
import covoiturage.bl.model.UserDB;
import covoiturage.bl.service.Constantes;

/**
 * Servlet implementation class RegisterAndroid
 */
@WebServlet("/RegisterAndroid")
public class RegisterAndroid extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	public boolean modeCreation = true;
	
	UserDB newUser = new UserDB(5,Constantes.FIELD_LASTNAME,Constantes.FIELD_FIRSTNAME, 
			Constantes.FIELD_EMAIL, Constantes.FIELD_ADDRESSNUMBER, Constantes.FIELD_ADDRESSWAY,
			Constantes.FIELD_ADDRESSCP, Constantes.FIELD_ADDRESSCITY,Constantes.FIELD_LONGITUDE, Constantes.FIELD_LATITUDE,
			Constantes.FIELD_PHONENUMBER,Constantes.FIELD_SEXE, Constantes.FIELD_ISCONDUCTEUR, Constantes.FIELD_ISSMOKER, Constantes.FIELD_AREA, Constantes.FIELD_PWD1 );
		
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAndroid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter(Constantes.FIELD_EMAIL);
		String pwd1 = request.getParameter(Constantes.FIELD_PWD1);
		String lastName = request.getParameter(Constantes.FIELD_LASTNAME);
		String firstName = request.getParameter(Constantes.FIELD_FIRSTNAME);
		String addressNumber = request.getParameter(Constantes.FIELD_ADDRESSNUMBER);
		String addressWay = request.getParameter(Constantes.FIELD_ADDRESSWAY);
		String addressCP = request.getParameter(Constantes.FIELD_ADDRESSCP);
		String addressCity = request.getParameter(Constantes.FIELD_ADDRESSCITY);
		String longitude = request.getParameter(Constantes.FIELD_LONGITUDE);
		String latitude = request.getParameter(Constantes.FIELD_LATITUDE);
		String phoneNumber = request.getParameter(Constantes.FIELD_PHONENUMBER);
		String sexe = request.getParameter(Constantes.FIELD_SEXE);
		String isConducteur = request.getParameter(Constantes.FIELD_ISCONDUCTEUR);
		String isSmoker = request.getParameter(Constantes.FIELD_ISSMOKER);
		String area = request.getParameter(Constantes.FIELD_AREA);
		
		newUser.setEmail(email);
		newUser.setLastName(lastName);
		 
			 
		//On vérifie si le login existe déjà dans la base
		boolean resultatExiste = false;
		//		Map<String, String> erreurs = new HashMap<String,String>();
		Connexion connexion = new Connexion("Covoiturage.db");
		connexion.connect();

		ResultSet resultSet = connexion.query("SELECT * FROM User where lower(email) = '"+ email.toLowerCase() + "'");
		// si resultSet est vide ou null, alors resultatExiste = false
		// si resultSet n'est pas vide, alors resultatExite = true
			
		//Initialisation de la réponse
		response.reset();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		if (resultSet == null) {
			resultatExiste = false;
			connexion.close();
			
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			PrintWriter out = response.getWriter();
			out.print("Connexion impossible à la base");
			out.flush();
			out.close();
		} else {
				
			try {
				if (resultSet.next()) {
					resultatExiste = true;
				}
			} catch (SQLException e) {
				resultatExiste = false;
			}
					
			//Si l'utilisateur n'existe pas 
			if (!resultatExiste) {
				//**********************************************************************
				//** On le créé dans le cas où on est rentré en création sur la fiche **
				//**********************************************************************
				if (modeCreation){
					//Partie d'insertion d'un nouvel utilisateur
												
					connexion.close();
					connexion.connect();
							
					UserDB newUser = new UserDB(0,email,lastName,firstName, 
							addressNumber, addressWay, addressCP,
							addressCity,longitude, latitude,sexe,phoneNumber, isConducteur, isSmoker, area, pwd1 );
							
					connexion.addUser(newUser);
							
					connexion.close();
					
					response.setStatus(HttpServletResponse.SC_OK);
					PrintWriter out = response.getWriter();
					out.print("Utilisateur créé");
					out.flush();
					out.close();
				}
				//**********************************************************************
				//***        On doit voir ce qu'on fait au niveau de l'email         ***
				//**********************************************************************
				else {
							
					//TODO il faut gérer la modification de l'email initial !!!!!!
				}
			} else {
				//************************************************************************************** 
				//*** Le user existe  et nous ne sommes pas en mode Création donc on modifie la fiche **
				//**************************************************************************************
				if ((!modeCreation)) {
					// Partie de mise à jour d'un user 
					connexion.close();
					
					connexion.connect();
					UserDB newUser = new UserDB(0,email,lastName,firstName, 
							addressNumber, addressWay, addressCP,addressCity,longitude, latitude,
							sexe,phoneNumber, isConducteur, isSmoker, area, pwd1 );
					
					connexion.MajUser(newUser);
							
					connexion.close();
					response.setStatus(HttpServletResponse.SC_OK);
					PrintWriter out = response.getWriter();
					out.print("Mise à jour utilisateur effectué");
					out.flush();
					out.close();
							
				}
				//*******************************************************************************
				//*** Le user existe et nous sommes en création : illogique on ne fait rien   ***
				//*******************************************************************************
				else
				{
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					PrintWriter out = response.getWriter();
					out.print("Création d'un user existant !!!");
					out.flush();
					out.close();
				}
					
			}
		}
	} 	

}

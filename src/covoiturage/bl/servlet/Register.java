package covoiturage.bl.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL="/WEB-INF/register.jsp";
	
	public static final String FIELD_EMAIL = "email";
	public static final String FIELD_PWD1 = "pwd1";
	public static final String FIELD_PWD2 = "pwd2";
	public static final String FIELD_FIRSTNAME = "firstName";
	public static final String FIELD_LASTNAME = "lastName";
	public static final String FIELD_ADRESSNUMBER = "adressNumber";
	public static final String FIELD_ADRESSWAY = "adressWay";
	public static final String FIELD_ADRESSCP = "adressCp";
	public static final String FIELD_ADRESSCITY = "adressCity";
	public static final String FIELD_LONGITUDE = "longitude";
	public static final String FIELD_LATITUDE = "latitude";
	public static final String FIELD_PHONENUMBER = "phoneNumber";
	public static final String FIELD_SEXE = "sexe";
	public static final String FIELD_ISCONDUCTEUR = "isConducteur";
	public static final String FIELD_ISSMOKER = "isSmoker";
	public static final String FIELD_AREA = "area";
	
	
	UserDB newUser = new UserDB(5,FIELD_LASTNAME,FIELD_FIRSTNAME, 
			FIELD_EMAIL, FIELD_ADRESSNUMBER, FIELD_ADRESSWAY,
			FIELD_ADRESSCP, FIELD_ADRESSCITY,FIELD_LONGITUDE, FIELD_LATITUDE,
			FIELD_PHONENUMBER,FIELD_SEXE, FIELD_ISCONDUCTEUR, FIELD_ISSMOKER, FIELD_AREA );
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("errorStatus", true);
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter(FIELD_EMAIL);
		String pwd1 = request.getParameter(FIELD_PWD1);
		String pwd2 = request.getParameter(FIELD_PWD2);
		String lastName = request.getParameter(FIELD_LASTNAME);
		String firstName = request.getParameter(FIELD_FIRSTNAME);
		String adressNumber = request.getParameter(FIELD_ADRESSNUMBER);
		String adressWay = request.getParameter(FIELD_ADRESSWAY);
		String adressCP = request.getParameter(FIELD_ADRESSCP);
		String adressCity = request.getParameter(FIELD_ADRESSCITY);
		String phoneNumber = request.getParameter(FIELD_PHONENUMBER);
		String sexe = request.getParameter(FIELD_SEXE);
	//	String isConducteur = request.getParameter(FIELD_ISCONDUCTEUR); en attente d'utilisation
		String isConducteur = "cond";
		String isSmoker = request.getParameter(FIELD_ISSMOKER);
		String area = request.getParameter(FIELD_AREA);
		
		
		newUser.setEmail(email);
		newUser.setLastName(lastName);
		String errMsg = null;
		String actionMessage = "";
		Map<String, String> erreurs = new HashMap<String,String>();
		Map<String, String> form = new HashMap<String, String>();
		
		errMsg = validateEmail(email);
		if(errMsg!=null){
			erreurs.put(FIELD_EMAIL, errMsg);
		} else {
			errMsg = validateNewPass(pwd1, pwd2);
			if(errMsg!=null){
				erreurs.put(FIELD_PWD1, errMsg);
			} else {
				errMsg = validateName(lastName);
				if(errMsg!=null){
					erreurs.put(FIELD_LASTNAME, errMsg);
				}
			}
		}
				
		if(errMsg==null){
			 form.put(FIELD_EMAIL, email);
			 actionMessage = "Succès de l'inscription";
			 request.setAttribute("errorStatus", false);
		} else {
			actionMessage = "Echec de l'inscription";
			request.setAttribute("errorStatus", true);
		}
		
		
		//On vérifie si le login existe déjà dans la base
		boolean resultatExiste = false;
		//		Map<String, String> erreurs = new HashMap<String,String>();
		Connexion connexion = new Connexion("Covoiturage.db");
		connexion.connect();

		ResultSet resultSet = connexion.query("SELECT * FROM User where lower(email) = '"+ email.toLowerCase() + "'");
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
			actionMessage = "Utilisateur déjà existant";
			request.setAttribute("form", form);
			request.setAttribute("erreurs", erreurs);
			request.setAttribute("actionMessage", actionMessage);
			request.setAttribute("newUser", newUser);
			this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include(request, response);
			
		} else {
			actionMessage = "Création de l'utilisateur";
			request.setAttribute("actionMessage", actionMessage);
			String sql = "INSERT INTO User " +
					"(email, lastName, fisrtName, addressNumber, addressWay, addressCP,addressCity,phonenUmber, sexe, isConducteur, isSmoker,area) " +
					" VALUES ( '" + email.toLowerCase() + "', " +
					" '" + lastName + "', " +
					" '" + firstName + "', " +
					" '" + adressNumber + "', " +
					" '" + adressWay + "', " +
					" '" + adressCP + "', " +
					" '" + adressCity + "', " +
					" '" + phoneNumber + "', " +
					" '" + sexe +  "', " +
					" '" + isConducteur + "', " +
					" '" + isSmoker + "', " +
					" '" + area + "');"; 

			System.out.println("Test");
			System.out.println(sql);
			
			connexion.query(sql);
			System.out.println("Insert passé");		
			this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include(request, response);
		}
	
	}
	
	private String validateEmail(String email ) {
		if ( email != null && email.trim().length() != 0 ) {
			if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
				return ("Veuillez saisir une adresse mail valide");
			}
		} else {
			return ("L'adresse mail est	obligatoire");
		}
		return null;
	}
	
	private String validateName(String name)
	{ 
		if (name != null && name.trim().length() != 0) {
			return null;
		} else {
			return "Veuillez saisir un nom";
		}
	}
	
	private String validateNewPass(String pass1, String pass2) {
        StringBuilder retVal = new StringBuilder();

        if(pass1.length() < 1 || pass2.length() < 1 )retVal.append("Mot de passe vide <br>");

        if (pass1 != null && pass2 != null) {

            if (pass1.equals(pass2)) {
                //logger.info(pass1 + " = " + pass2);

                pass1 = pass2;
                boolean hasUppercase = !pass1.equals(pass1.toLowerCase());
                boolean hasLowercase = !pass1.equals(pass1.toUpperCase());
                boolean hasNumber = pass1.matches(".*\\d.*");
                boolean noSpecialChar = pass1.matches("[a-zA-Z0-9 ]*");

                if (pass1.length() < 8) {
                    //logger.info(pass1 + " is length < 11");
                    retVal.append("Le mot de passe est trop court. Il doit contenir 8 caractï¿½res <br>");
                    return ("Le mot de passe est trop court. Il doit contenir 8 caractï¿½res");
                }

                if (!hasUppercase) {
                    //logger.info(pass1 + " <-- needs uppercase");
                    retVal.append("Le mot de passe doit contenir une majuscule <br>");
                    return ("Le mot de passe doit contenir une majuscule");
                }

                if (!hasLowercase) {
                    //logger.info(pass1 + " <-- needs lowercase");
                    retVal.append("Le mot de passe doit contenir des minuscules <br>");
                    return ("Le mot de passe doit contenir des minuscules");
                }

                if (!hasNumber) {
                    //logger.info(pass1 + "<-- needs a number");
                    retVal.append("Le mot de passe doit contenir un nombre <br>");
                    return ("Le mot de passe doit contenir un nombre");
                }

            }else{
                //logger.info(pass1 + " != " + pass2);
                retVal.append("Mots de passe diffï¿½rents <br>");
                return ("Mots de passe diffï¿½rents");
            }
        }else{
            //logger.info("Passwords = null");
            retVal.append("Mots de passe non renseignï¿½s <br>");
            return ("Mots de passe non renseignï¿½s");
        }
        

        return null;

    }
}

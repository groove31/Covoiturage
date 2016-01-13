package covoiturage.bl.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import covoiturage.bl.model.User;

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
	public static final String FIELD_ADRESSCP = "adressCP";
	public static final String FIELD_ADRESSCITY = "adressCity";
	public static final String FIELD_LONGITUDE = "longitude";
	public static final String FIELD_LATITUDE = "latitude";
	public static final String FIELD_PHONENUMBER = "phoneNumber";
	public static final String FIELD_SEXE = "sexe";
	
	
	User newUser = new User(5,FIELD_LASTNAME,FIELD_FIRSTNAME, 
			FIELD_EMAIL, FIELD_ADRESSNUMBER, FIELD_ADRESSWAY,
			FIELD_ADRESSCP, FIELD_ADRESSCITY,FIELD_LONGITUDE, FIELD_LATITUDE,
			FIELD_PHONENUMBER,FIELD_SEXE );
	
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
		//doGet(request, response);
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
		
		
		
		newUser.setEmail(email);
		newUser.setLastName(lastName);
		String errMsg = null;
		String actionMessage = "";
		Map<String, String> erreurs = new HashMap<String,String>();
		Map<String, String> form = new HashMap<String, String>();
		
		//PrintWriter out = response.getWriter();
		
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
			 actionMessage = "Succ�s de l'inscription";
			 request.setAttribute("errorStatus", false);
		} else {
			actionMessage = "Echec de l'inscription";
			request.setAttribute("errorStatus", true);
		}
		/*
		HttpSession sessionScope = request.getSession();
		Map<String, User> users = (HashMap<String, User>)sessionScope.getAttribute( "users");
		users.put( newUser.getEmail(), newUser);
		sessionScope.setAttribute("users", users);
		*/
		
		//out.println("<HTML>\n<BODY>\n" + "<h1>Connexion OK</h1>" + "</BODY></HTML>");
		request.setAttribute("form", form);
		request.setAttribute("erreurs", erreurs);
		request.setAttribute("actionMessage", actionMessage);
		request.setAttribute("newUser", newUser);
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include(request, response);
		
		
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
                    retVal.append("Le mot de passe est trop court. Il doit contenir 8 caract�res <br>");
                    return ("Le mot de passe est trop court. Il doit contenir 8 caract�res");
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
                retVal.append("Mots de passe diff�rents <br>");
                return ("Mots de passe diff�rents");
            }
        }else{
            //logger.info("Passwords = null");
            retVal.append("Mots de passe non renseign�s <br>");
            return ("Mots de passe non renseign�s");
        }
        

        return null;

    }
}

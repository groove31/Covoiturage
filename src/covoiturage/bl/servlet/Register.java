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
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL="/WEB-INF/register.jsp";
	public static String VIEW_PAGES_URL_MODIF="/WEB-INF/listDriver.jsp";
	public static String VIEW_PAGES_URL_CREATION="/Login";
	
	
	
	
	public boolean modeCreation = true;
	
	UserDB newUser = new UserDB(5,Constantes.FIELD_LASTNAME,Constantes.FIELD_FIRSTNAME, 
			Constantes.FIELD_EMAIL, Constantes.FIELD_ADDRESSNUMBER, Constantes.FIELD_ADDRESSWAY,
			Constantes.FIELD_ADDRESSCP, Constantes.FIELD_ADDRESSCITY,Constantes.FIELD_LONGITUDE, Constantes.FIELD_LATITUDE,
			Constantes.FIELD_PHONENUMBER,Constantes.FIELD_SEXE, Constantes.FIELD_ISCONDUCTEUR, Constantes.FIELD_ISSMOKER, Constantes.FIELD_AREA, Constantes.FIELD_PWD1 );
	
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
		
		String email = "";
		
		Map<String, String> form = new HashMap<String, String>();
		HttpSession session = request.getSession();
		email = (String) session.getAttribute(Constantes.FIELD_EMAIL);
		//email = request.getParameter(Constantes.FIELD_EMAIL);
		
		System.out.println("Email : " + email);
		if (email!=null) {
			//On est en inscription et non en modification
			modeCreation = false;
			String actionMessage = "";
			String actionMessageValidation = "";
			String lastName="";
			
			boolean resultatExiste = false;
			//		Map<String, String> erreurs = new HashMap<String,String>();
			      
			Connexion connexion = new Connexion("Covoiturage.db");
			connexion.connect();
			
			String sql = "SELECT * FROM User WHERE lower(email) = '"+ email.toLowerCase() + "'" ;
			System.out.println("Requete : " + sql);		
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
				lastName = resultSet.getString(Constantes.FIELD_LASTNAME);
				System.out.println("lastName1 : " + lastName);
				if (resultSet.next()) {
					resultatExiste = true;
					lastName = resultSet.getString(Constantes.FIELD_LASTNAME);
					form.put(Constantes.FIELD_EMAIL, email);
					form.put(Constantes.FIELD_LASTNAME, resultSet.getString(Constantes.FIELD_LASTNAME));
					form.put(Constantes.FIELD_FIRSTNAME, resultSet.getString(Constantes.FIELD_FIRSTNAME));
					form.put(Constantes.FIELD_ADDRESSNUMBER, resultSet.getString(Constantes.FIELD_ADDRESSNUMBER));
					form.put(Constantes.FIELD_ADDRESSWAY, resultSet.getString(Constantes.FIELD_ADDRESSWAY));
					form.put(Constantes.FIELD_ADDRESSCP, resultSet.getString(Constantes.FIELD_ADDRESSCP));
					form.put(Constantes.FIELD_ADDRESSCITY, resultSet.getString(Constantes.FIELD_ADDRESSCITY));
					form.put(Constantes.FIELD_PHONENUMBER, resultSet.getString(Constantes.FIELD_PHONENUMBER));
					form.put(Constantes.FIELD_SEXE, resultSet.getString(Constantes.FIELD_SEXE));
					form.put(Constantes.FIELD_ISCONDUCTEUR, resultSet.getString(Constantes.FIELD_ISCONDUCTEUR));
					form.put(Constantes.FIELD_ISSMOKER, resultSet.getString(Constantes.FIELD_ISSMOKER));
					form.put(Constantes.FIELD_AREA, resultSet.getString(Constantes.FIELD_AREA));
					form.put("pwd1", resultSet.getString("password"));
					form.put("pwd2", resultSet.getString("password"));
					connexion.close();
					request.setAttribute("form",  form);
				}
			} catch (SQLException e) {
				resultatExiste = false;
			}
			
		} else {
			modeCreation = true;
		}

		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter(Constantes.FIELD_EMAIL);
		String pwd1 = request.getParameter(Constantes.FIELD_PWD1);
		String pwd2 = request.getParameter(Constantes.FIELD_PWD2);
		String lastName = request.getParameter(Constantes.FIELD_LASTNAME);
		String firstName = request.getParameter(Constantes.FIELD_FIRSTNAME);
		String addressNumber = request.getParameter(Constantes.FIELD_ADDRESSNUMBER);
		String addressWay = request.getParameter(Constantes.FIELD_ADDRESSWAY);
		String addressCp = request.getParameter(Constantes.FIELD_ADDRESSCP);
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
		
		System.out.println("Mode création dans Do Post : " + modeCreation); 
		
		
		String errMsg = null;
		String errMsgTempo = null;
		String actionMessage = "";
		String actionMessageValidation = "";
		Map<String, String> erreurs = new HashMap<String,String>();
		Map<String, String> form = new HashMap<String, String>();
		
		/**
		 * Vérification si la saisie est OK
		 */
		errMsg = validateEmail(email);
		if(errMsg!=null){
			errMsgTempo = errMsg;
			erreurs.put(Constantes.FIELD_EMAIL, errMsg);
		} 
		
		errMsg = validateNewPass(pwd1, pwd2);
		if(errMsg!=null){
			errMsgTempo = errMsg;
			erreurs.put(Constantes.FIELD_PWD1, errMsg);
		}
		
		errMsg = validateName(lastName);
		if(errMsg!=null){
			erreurs.put(Constantes.FIELD_LASTNAME, errMsg);
		}
		if (errMsgTempo!=null){
			errMsg = errMsgTempo;
		}
		
		
		//Reinit des valeurs a renvoyer à la vue en cas de probl�mes
		 form.put(Constantes.FIELD_EMAIL, email);
		 form.put(Constantes.FIELD_LASTNAME, lastName);
		 form.put(Constantes.FIELD_FIRSTNAME, firstName);
		 form.put(Constantes.FIELD_ADDRESSNUMBER, addressNumber);
		 form.put(Constantes.FIELD_ADDRESSWAY, addressWay);
		 form.put(Constantes.FIELD_ADDRESSCP, addressCp);
		 form.put(Constantes.FIELD_ADDRESSCITY, addressCity);
		 form.put(Constantes.FIELD_PHONENUMBER, phoneNumber);
		 form.put(Constantes.FIELD_SEXE, sexe);
		 form.put(Constantes.FIELD_PWD1, pwd1);
		 form.put(Constantes.FIELD_PWD2, pwd1);
		 form.put(Constantes.FIELD_ISSMOKER, isSmoker);
		 form.put(Constantes.FIELD_ISCONDUCTEUR, isConducteur);
		 form.put(Constantes.FIELD_AREA, area);
		 
		 
		 //Si pas d'erreur ci dessus
		 if(errMsg==null){
			 actionMessageValidation = "Succès de l'inscription";
			 request.setAttribute("errorStatus", false);
			 
			 
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
					}
				} catch (SQLException e) {
					resultatExiste = false;

				}
				
				//Si l'utilisateur n'existe pas 
				if (!resultatExiste) {
					//On le créé dans le cas où on est rentré en création sur la fiche
					if (modeCreation){
						//Partie d'insertion d'un nouvel utilisateur
						actionMessageValidation = "Création de l'utilisateur effectuée";
						request.setAttribute("actionMessage", actionMessage);
						
						connexion.close();
						connexion.connect();
						
						UserDB newUser = new UserDB(0,email,lastName,firstName, 
								addressNumber, addressWay, addressCp,
								addressCity,longitude, latitude,sexe,phoneNumber, isConducteur, isSmoker, area, pwd1 );
						
						connexion.addUser(newUser);
						
						connexion.close();
						this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL_CREATION).forward(request, response);
					} 
					//On doit voir ce qu'on fait au niveau de l'email
					else {
						
						//TODO il faut gérer la modification de l'email initial !!!!!!
					}
				} else {
					//Le user existe  et nous ne sommes pas en mode Création donc on modifie la fiche
					if ((!modeCreation)) {
						// Partie de mise à jour d'un user 
						actionMessageValidation = "Mise à jour de l'utilisateur effectuée";
						connexion.close();
						
						connexion.connect();
						UserDB newUser = new UserDB(0,email,lastName,firstName, 
								addressNumber, addressWay, addressCp,addressCity,longitude, latitude,
								sexe,phoneNumber, isConducteur, isSmoker, area, pwd1 );
						
						connexion.MajUser(newUser);
						
						connexion.close();
						System.out.println("Update passé");
						request.setAttribute("form", form);
						request.setAttribute("actionMessage", actionMessage);
						request.setAttribute("actionMessageValidation", actionMessageValidation);
						request.setAttribute("ADDRESSE_BL", Constantes.ADDRESSE_BL);
						this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL_MODIF).forward(request, response);
						
					} 
					//Le user existe et nous sommes en création : illogique on ne fait rien 
					else
					{
						erreurs.put(Constantes.FIELD_EMAIL, "Email déjà existant");
						actionMessage = "Enregistrement impossible : utilisateur déjà existant";
						request.setAttribute("errorStatus", true);
						request.setAttribute("form", form);
						request.setAttribute("erreurs", erreurs);
						request.setAttribute("actionMessage", actionMessage);
						request.setAttribute("actionMessageValidation", actionMessageValidation);

						this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include(request, response);
					}
				
				}
		} else {
			actionMessage = "Echec de l'enregistrement";
			request.setAttribute("errorStatus", true);
			request.setAttribute("form", form);
			request.setAttribute("erreurs", erreurs);
			request.setAttribute("actionMessage", actionMessage);
			request.setAttribute("actionMessageValidation", actionMessageValidation);

			this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include(request, response);
		}
	
	}
	
	/*
	 * Partie de vérification des saisies
	 */
	private String validateEmail(String email ) {
		if ( email != null && email.trim().length() != 0 ) {
			if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
				return ("Veuillez saisir une adresse mail valide");
			}
		} else {
			return ("L'adresse mail est obligatoire");
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
        System.out.println("pwd1 = " + pass1 + " pwd2 = " + pass2);
        if(pass1.length() < 1 || pass2.length() < 1 ){
        	retVal.append("Mot de passe vide <br>");
        }

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
                    retVal.append("Le mot de passe est trop court. Il doit contenir 8 caractères <br>");
                    return ("Le mot de passe est trop court. Il doit contenir 8 caractères");
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
                retVal.append("Mots de passe différents <br>");
                return ("Mots de passe différents");
            }
        }else{
            //logger.info("Passwords = null");
            retVal.append("Mots de passe non renseignés <br>");
            return ("Mots de passe non renseignés");
        }
        

        return null;

    }
}

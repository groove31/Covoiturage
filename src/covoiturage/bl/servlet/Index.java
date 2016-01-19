package covoiturage.bl.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		listeAdresses.add("\"Place François Mitterrand, 31750 Escalquens, France\"");
		listeAdresses.add("\"48, rue des Fontanelles, 31320 Castanet-Tolosan, France\"");
		listeAdresses.add("\"29 Avenue de Toulouse, 31320 Castanet-Tolosan\"");
		listeAdresses.add("\"8 Allée de l'Appel du 18 juin 1940, 31130 Balma, France\"");
		
		request.setAttribute("conducteurs", listeAdresses);
		
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String longitude = request.getParameter(FIELD_LONGITUDE);
		String latitude = request.getParameter(FIELD_LATITUDE);
		String area = request.getParameter(FIELD_AREA);
		doGet(request, response);
	}

}

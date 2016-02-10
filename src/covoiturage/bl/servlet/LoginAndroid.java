package covoiturage.bl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import covoiturage.bl.model.User;
import covoiturage.bl.service.Constantes;
import covoiturage.bl.service.LoginService;

/**
 * Servlet implementation class LoginAndroid
 */
@WebServlet("/LoginAndroid")
public class LoginAndroid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAndroid() {
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
		
		LoginService loginService = new LoginService();
		User user = loginService.findUser(email, pwd1);
		
		if ( user == null) {
			response.reset();
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			PrintWriter out = response.getWriter();
			out.print("Utilisateur ou mot de passe incorrect.");
			out.flush();
			out.close();
		} else {
			Gson gson = new Gson();
			String json = new Gson().toJson(user);

			response.reset();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.setStatus(HttpServletResponse.SC_OK);
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
		}
	}

}

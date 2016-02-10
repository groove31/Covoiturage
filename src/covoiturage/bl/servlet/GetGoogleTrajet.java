package covoiturage.bl.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class GetGoogleTrajet
 */
@WebServlet("/GetGoogleTrajet")
public class GetGoogleTrajet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetGoogleTrajet() {
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
		// TODO Auto-generated method stub
		String resp = request.getParameter("response");
		
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		JSONArray step = new JSONArray();
		try {
			step = new JSONObject(resp).getJSONArray("routes").getJSONObject(0).getJSONArray("legs")
			        .getJSONObject(0).getJSONArray("steps");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        for (int i = 0; i < step.length(); i++) {
            HashMap<String,Object> row = new HashMap<String,Object>();
            try {
				row.put("lat", step.getJSONObject(i).getJSONObject("end_location").getDouble("lat"));
				row.put("lng", step.getJSONObject(i).getJSONObject("end_location").getDouble("lng"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//            row.put("start",new LatLng(Double.parseDouble(step.getJSONObject(i).getJSONObject("start_location").getString("lat")), Double.parseDouble(step.getJSONObject(i).getJSONObject("start_location").getString("lng"))));
//            row.put("end",  new LatLng(Double.parseDouble(step.getJSONObject(i).getJSONObject("start_location").getString("lat")), Double.parseDouble(step.getJSONObject(i).getJSONObject("start_location").getString("lng"))));
            list.add(row);

        }
        
        
		
		
		
//		System.out.println(objArray);
//		Gson gson = new Gson();
//		JsonParser parser = new JsonParser();
//		JsonObject o = parser.parse(objArray).getAsJsonObject();
////   		String json = new Gson().fromJson(objArray);
//   		String[] test = gson.fromJson(objArray, String[].class);
   		
		
//		doGet(request, response);
	}

}

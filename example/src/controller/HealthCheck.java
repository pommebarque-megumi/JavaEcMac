package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Health;

@WebServlet("/HealthCheck")//ここの"/"はlocalhost8080:exampleまで表している
public class HealthCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/HealthApp.jsp");//ここの"/"はlocalhost8080:example/WebContentまで表している
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double height = Double.parseDouble(request.getParameter("height"));
		double weight = Double.parseDouble(request.getParameter("weight"));

		Health health= new Health(height,weight);
		double bmi = weight/((height/100.0)*(height/100.0));
		health.setBmi(bmi);
		String bodyShape=":w"
				+ "";
		if(bmi < 18.5) {
			bodyShape+="痩せ型";
		}else if(bmi < 25) {
			bodyShape+="普通";
		}else {
			bodyShape+="肥満";
		}
		health.setBodyShape(bodyShape);
		request.setAttribute("healthResult", health);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/HealthAppResult.jsp");
		rd.forward(request, response);
	}

}

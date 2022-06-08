package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		User user = new User(name,pass);
		if((user.getPass()!=null)&&(user.getPass().equals("1234"))) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser",user);
		}else {
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/loginResult.jsp");
		rd.forward(request, response);
	}

}

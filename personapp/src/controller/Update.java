package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PersonDAO;
import model.Person;

@WebServlet("/Update")
public class Update extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s_id = request.getParameter("id");
		if(s_id==null) {
			response.sendRedirect("/personapp/Read");
		}else {
			PersonDAO dao = new PersonDAO();
			Person person = dao.findOne(Integer.parseInt(s_id));
			request.setAttribute("person",person);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/update.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		Person person = new Person(id,name,age);
		PersonDAO dao = new PersonDAO();
		dao.updateOne(person);
		response.sendRedirect("/personapp/Read");
	}

}

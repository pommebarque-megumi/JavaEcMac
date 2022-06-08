package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TodoDAO;
import model.Todo;

@WebServlet("/Update")
public class Update extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s_id = request.getParameter("id");
		if(s_id == null) {
			response.sendRedirect("/todoapp/Read");
			return;
		}
		TodoDAO dao = new TodoDAO();
		Todo updateTodo = dao.findOne(Integer.parseInt(s_id));
		request.setAttribute("todo",updateTodo );
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/update.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		int importance = Integer.parseInt(request.getParameter("importance"));
		Todo todo = new Todo(id,title,importance);
		TodoDAO dao =new TodoDAO();
		dao.updateOne(todo);
		response.sendRedirect("/todoapp/Read");
	}

}

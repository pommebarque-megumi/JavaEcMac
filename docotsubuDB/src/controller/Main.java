package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DocotsubuDAO;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DocotsubuDAO dao = new DocotsubuDAO();
		List<User> userList=dao.findAll();
		request.setAttribute("list", userList);
		HttpSession session=request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		if(loginUser==null) {
			response.sendRedirect("/docotsubuDB/");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/main.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String comment = request.getParameter("comment");

		if((comment != null) && (comment.length() != 0)) {
			HttpSession session = request.getSession();
			User loginUser = (User)session.getAttribute("loginUser");
			loginUser.setComment(comment);
			DocotsubuDAO dao = new DocotsubuDAO();
			dao.insertOne(loginUser);
		}else {
			String errorMsg="つぶやきが入力されていません";
			request.setAttribute("errorMsg", errorMsg);
		}
		doGet(request,response);
	}

}

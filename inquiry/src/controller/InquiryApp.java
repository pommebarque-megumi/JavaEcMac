package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Inquiry;

@WebServlet("/inquiryapp")//URLの調整
public class InquiryApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath="/WEB-INF/view/inquiryForm.jsp";
		String clic=request.getParameter("clic");
		if(clic!=null) {
			forwardPath="/WEB-INF/view/inquirySend.jsp";
			HttpSession session = request.getSession();
			session.invalidate();
		}
			RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
			rd.forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		Inquiry newInquiry = new Inquiry(name,email,message);
		HttpSession session = request.getSession();
		session.setAttribute("inquiry",newInquiry);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/confirmation.jsp");
		rd.forward(request, response);
	}

}

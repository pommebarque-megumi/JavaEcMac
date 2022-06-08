package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import model.Member;
@WebServlet("/Create")
public class Create extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/create.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String position = request.getParameter("position");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phoneNo = request.getParameter("phoneNo");
		String affiliation = request.getParameter("affiliation");
		String reading = request.getParameter("reading");
		Member member = new Member(position,name,address,phoneNo,affiliation,reading);
		MemberDAO dao = new MemberDAO();
		dao.insertOne(member);
		response.sendRedirect("/committee_member/Read");
	}

}

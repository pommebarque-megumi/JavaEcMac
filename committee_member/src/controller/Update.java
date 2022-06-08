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

@WebServlet("/Update")
public class Update extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s_id = request.getParameter("id");
		if(s_id == null) {
			response.sendRedirect("/committee_member/Read");
			return;
		}
			MemberDAO dao = new MemberDAO();
			Member member = dao.findOne(Integer.parseInt(s_id));
			request.setAttribute("member", member);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/update.jsp");
			rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String position = request.getParameter("position");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phoneNo = request.getParameter("phoneNo");
		String affiliation = request.getParameter("affiliation");
		String reading = request.getParameter("reading");
		Member member = new Member(id,position,name,address,phoneNo,affiliation,reading);
		MemberDAO dao = new MemberDAO();
		dao.updateOne(member);
		response.sendRedirect("/committee_member/Read");
	}

}

package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SiteEVLogic;
import model.SiteEv;

@WebServlet("/MinatoIndex")
public class MinatoIndex extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = this.getServletContext();
		SiteEv siteEv = (SiteEv)application.getAttribute("siteEv");

		if(siteEv==null) {
			siteEv = new SiteEv();
		}
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		SiteEVLogic siteEVLogic = new SiteEVLogic();
		if(action != null&&action.equals("like")) {
			siteEVLogic.like(siteEv);
		}else if(action !=null && action.equals("dislike")) {
			siteEVLogic.dislike(siteEv);
		}
		application.setAttribute("siteEv", siteEv);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/minatoIndex.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

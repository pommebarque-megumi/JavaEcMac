package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Slime;

@WebServlet("/SlimeApp")
public class SlimeApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Slime slime=new Slime("ぽよよん",100);
		List<Slime> slimeList=new ArrayList<>();
		slimeList.add(new Slime("ぽよよん",100));
		slimeList.add(new Slime("ぷっちん",90));
		slimeList.add(new Slime("ぷるるん",80));
		slimeList.add(new Slime("ぽよぽよ",110));
		request.setAttribute("slimeKey",slimeList);//ArrayListごとkeepしておける
		RequestDispatcher rd =request.getRequestDispatcher("/WEB-INF/view/result.jsp");
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

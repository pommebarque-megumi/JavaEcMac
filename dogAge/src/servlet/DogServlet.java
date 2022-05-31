package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DogServlet")
public class DogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String s_age=request.getParameter("age");
		int age= Integer.parseInt(s_age);

		String errorMsg="";
		if(name==null || name.length()==0) {
			errorMsg+="名前を入力してください";
		}
		if(s_age==null || s_age.length()==0) {
			errorMsg+="年齢を選択してください";
		}

		String msg = name+"("+s_age+"歳)"+"は人間に換算すると"+age*7+"歳です。";
		if(errorMsg.length()!=0) {
			msg=errorMsg;
		}

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");/*("<meta charset='UTF-8'>"でもOK)*/
		out.println("<title>換算結果</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>"+msg+"</p>");
		out.println("<a href='http://localhost:8080/dogAge/index.jsp'>戻る</a>");
		out.println("</body>");
		out.println("</body>");
		out.println("</html>");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}

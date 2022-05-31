<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "model.*"%>
    <%User user =(User)session.getAttribute("RegisterUser");
    String id=(user==null)?"":user.getId();//UserインスタンスがnullかどうかによってString idに代入する値を決めている三項演算子
    String pass=(user==null)?"":user.getPass();
    String name=(user==null)?"":user.getName();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
<form action="/sessionLesson/RegisterUser" method="post">
	ログインID<input type="text" name="id" value="<%=id%>"><br>
	パスワード<input type="password" name="pass" value="<%=pass%>"><br>
	名前<input type="text" name="name" value="<%=name%>"><br>
	<input type="submit" value="確認">
</form>
</body>
</html>
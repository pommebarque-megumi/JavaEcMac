<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
   <% User registerUser = (User)session.getAttribute("RegisterUser"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
<P>下記のユーザーを登録します</P>
<p>ログインID:<%=registerUser.getId() %><br>
ログインパスワード:<%=registerUser.getPass() %><br>
名前:<%=registerUser.getName() %><br>
</p>
<a href="/sessionLesson/RegisterUser">戻る</a>
<a href="/sessionLesson/RegisterUser?action=done">登録</a>
</body>
</html>
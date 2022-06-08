<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規Todo作成画面</title>
</head>
<body>
<form action="/todoapp/Create" method="post">
Title：<input type="text" name="title"><br>
重要度：<select name="importance">
<%for(int i=1 ; i<=5 ; i++){ %>
<option><%=i%></option>
<%} %>
</select><br>
<button type="submit" >登録</button>
</form>
</body>
</html>
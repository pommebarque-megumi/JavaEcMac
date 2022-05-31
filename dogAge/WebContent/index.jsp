<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>犬の年齢を調べるアプリ</title>
</head>
<body>
<form action="/dogAge/DogServlet"  method="post">
犬の名前：<input type="text" name="name"><br>
犬の年齢：<select name="age">
						<%for(int i=0 ; i<=20 ; i++){%>
							<option value="<%=i %>"><%=i %>歳</option>
						<%}%></select>
<input type="submit" value="送信">
</form>
</body>
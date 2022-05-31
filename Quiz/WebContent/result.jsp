<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String ans = request.getParameter("answer");
    String path = "smile.png";
	String msg="正解！";
    if(!ans.equals("634")){
    	path="cry.png";
    	msg="残念...。正解は634mだよ";
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スカイツリーの高さクイズ</title>
<link rel="stylesheet"  href="/Quiz/css/main.css">
</head>
<body>
<div id="container">
	<div id="boxA">
	<p><%= msg %></p>
	<a href="/Quiz/index.html">もう1度やってみよう！</a>
	</div>
	<div id="boxB">
	<div class="imgBox">
		<img src="/Quiz/images/<%= path %>" alt="face">
		</div>
	</div>
</div>
</body>
</html>
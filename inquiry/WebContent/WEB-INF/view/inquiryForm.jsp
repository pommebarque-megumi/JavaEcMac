<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
    <%
    Inquiry inquiry = (Inquiry)session.getAttribute("inquiry");
    String name = (inquiry==null)?"":inquiry.getName();
    String email = (inquiry==null)?"":inquiry.getEmail();
    String message = (inquiry==null)?"":inquiry.getMessage();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
<link rel="styleSheet" href="/inquiry/css/main.css">
<title>お問い合わせフォーム</title>
</head>
<body>
<div class="container">
<h1>お問い合わせフォーム</h1>
<p>お問い合わせ内容を入力してください</p>
<form action="/inquiry/inquiryapp" method="post">
<table>
<tr><th>お名前</th><td><input type="text" name="name" value="<%=name%>"></td></tr>
<tr><th>メールアドレス</th><td><input type="email" name="email" value="<%=email%>"></td></tr>
<tr><th>お問い合わせ内容</th><td><textarea name="message"><%=message%></textarea></td></tr>
</table>
<button type="submit">確認</button>
</form>
</div>
</body>
</html>
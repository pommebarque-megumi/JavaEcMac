<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
    <%
    Inquiry inquiry = (Inquiry)session.getAttribute("inquiry");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
<link rel="styleSheet" href="/inquiry/css/main.css">
<title>送信内容確認画面</title>
</head>
<body>
<div class="container">
<h1>お問い合わせ内容</h1>
<p>以下の内容でよろしいですか？</p>
<table>
<tr><th>お名前</th><td><%=inquiry.getName() %></td></tr>
<tr><th>メールアドレス</th><td><%=inquiry.getEmail() %></td></tr>
<tr><th>お問い合わせ内容</th><td><%=inquiry.getMessage() %></td></tr>
</table>
<div class="btBox">
<a href="/inquiry/inquiryapp">戻る</a>
<a href="/inquiry/inquiryapp?clic=send">送信</a>
</div>
</div>
</body>
</html>
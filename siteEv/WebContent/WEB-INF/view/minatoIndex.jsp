<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
    <%
    SiteEv siteEv = (SiteEv) application.getAttribute("siteEv");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>湊くんのページ</title>
</head>
<body>
<h1>湊くんのページへようこそ</h1>
<h2>湊くんとは！？</h2>
<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,dolor sit amet, consectetur adipisicing elit,orem ipsum dolor sit amet, consectetur adipisicing elit,dolor sit amet, consectetur adipisicing elit,</p>
<p><a href="/siteEv/MinatoIndex?action=like">いいね</a>:<%=siteEv.getLike() %>人</p>
<p><a href="/siteEv/MinatoIndex?action=dislike">よくないね</a>:<%=siteEv.getDislike() %>人</p>
</body>
</html>
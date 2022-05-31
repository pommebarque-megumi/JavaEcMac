<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.Slime,java.util.*"%>
    <%
    List<Slime> slimeList= (List<Slime>)request.getAttribute("slimeKey");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Slime</title>
</head>
<body>
<%for(Slime slime : slimeList){%>
<p><%=slime.getName() %>が現れた！(<%=slime.getHp( ) %>)</p>
<%} %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
    <%
    Todo todo = (Todo) request.getAttribute("todo");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo更新画面</title>
</head>
<body>
<form action="/todoapp/Update" method="post">
Todo：<input type="text" name="title" value="<%=todo.getTitle()%>">
重要度：<select>
<%for(int i = 1 ; i <= 5 ; i++){ %>
<%if(i==todo.getImportance()){ %>
<option selected><%= i %></option>
<%}else{ %>
<option><%= i %></option>
<%} %>
<%} %>
</select>
<input type="hidden" value="<%=todo.getId()%>">
<button type="submit">更新</button>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.* , java.util.*"%>
    <%
    List<Todo> todoList = (List<Todo>) request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todoリスト</title>
</head>
<body>
<a href="/todoapp/Create">新規</a>
<%if((todoList != null) && (todoList.size() > 0)){ %>
<%for(Todo todo : todoList){ %>
<%String star = todo.getStar(); %>
<p>●<%=todo.getTitle() %>: <%=star %></p>
<a href="/todoapp/Update?id=<%= todo.getId()%>">更新</a>
<a href="/todoapp/Delete?id=<%= todo.getId()%>" onclick="return confirm <%=todo.getId()%>を削除してもよろしいですか？">削除</a>
<%} %>
<%}else{ %>
<p>Todoはまだありません</p>
<%} %>
</body>
</html>
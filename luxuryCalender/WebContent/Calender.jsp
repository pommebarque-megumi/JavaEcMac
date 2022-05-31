<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LUXURY CALENDER</title>
</head>
<body>
<% Calendar cal = Calendar.getInstance();%>
<p>表示したい西暦を選んでください</p>
<select name="year">
		<%for(int i=1900 ; i<=2400 ; i++){%>
		<option value="<%=i%>年"><%= i%>年</option>
		<%}%>
	</select>
<p>表示したい月を選んでください</p>
<select name="month">
		<%for(int i=1 ; i<=12 ; i++){%>
		<option value="<%=i%>月"><%= i%>月</option>
		<%}%>
	</select>
</body>
</html>
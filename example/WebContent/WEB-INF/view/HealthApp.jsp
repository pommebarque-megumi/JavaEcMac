<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ健康診断</title>
</head>
<body>
<p>身長と体重を入力してください</p>
<form action="/example/HealthCheck" method="post"><!-- ここの"/"はlocalhost8080:まで表している -->
身長：
<select name="height"><%for (int i=100 ; i<250 ; i++) {%><option><%=i%></option><%} %></select>cm<br>
体重：
<select name="weight"><%for (int i=30 ; i<200 ; i++) {%><option><%=i%></option><%} %></select>kg<br>
<input type="submit" value="診断">
</form>
</body>
</html>
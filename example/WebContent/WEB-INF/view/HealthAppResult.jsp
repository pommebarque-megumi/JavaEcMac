<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.Health"%>
    <%Health health = (Health)  request.getAttribute("healthResult"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ健康診断結果</title>
</head>
<body>
<h1>スッキリ健康診断結果</h1>
<p>身長：<%= health.getHeight()%></p>
<p>体重：<%= health.getWeight()%></p>
<p>BMI：<%= Math.round(health.getBmi())%></p>
<p>体型：<%= health.getBodyShape()%></p>
<a href="/example/HealthCheck">戻る</a><!-- この"/"はlocalhost8080:まで -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="java.util.*,java.text.*" %>
<% String[] luckArray = {"超スッキリ","スッキリ","最悪"};
		Random rnd = new Random();
		int index = rnd.nextInt(3);
		String luck = luckArray[index];
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
		String today = sdf.format(date);
%>
<!-- 実行後も残るcommentソースにも表示される -->
<%--実行後は消えるcomment --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fortune</title>
</head>
<body>
<% for(int i=0 ; i<3 ; i++){ %>
<p><%=today%>の運勢は[<%=luck %>]です</p>
<%}%>
</body>
</html>
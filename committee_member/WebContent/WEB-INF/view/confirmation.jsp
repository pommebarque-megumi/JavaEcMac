<%@page import="com.sun.source.tree.MemberSelectTree"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
 <% Member member = (Member) request.getAttribute("member"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認ページ</title>
</head>
<body>
<p>以下の情報で登録しました</p>
<table>
<tr>
<th>役職</th><td>：<%=member.getPosition() %></td>
</tr>
<tr>
<th>名前</th><td>：<%=member.getName()%></td>
</tr>
<tr>
<th>名前(なまえ)</th><td>：<%=member.getReading()%></td>
</tr>
<tr>
<th>住所</th><td>：<%=member.getAddress()%></td>
</tr>
<tr>
<th>電話番号</th><td>：<%=member.getPhoneNo()%></td>
</tr>
<tr>
<th>所属団体</th><td>：<%=member.getAffiliation()%></td>
</tr>
</table>
<a href="/committee_member/" >一覧へ戻る</a><br>
</body>
</html>
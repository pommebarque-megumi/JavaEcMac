<%@page import="com.sun.source.tree.MemberSelectTree"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
 <% Member member = (Member) request.getAttribute("member"); %>
 <%
 String[] positions = {"なし","会長","副会長","会計","書記","監事","レクレーション","補導連絡会","文化部","体育部","広報","青少年協力員"};
 String[] affiliations = {"なし","地区協","PTA","解放委員会"};
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録内容更新ページ</title>
</head>
<body>
<p>更新する情報を入力してください</p>
<form action="/committee_member/Update" method="post">
<table>
<tr>
<th>役職</th><td>：<select name="position">
<%for(int i =0 ; i<positions.length ; i++){ %>
<%if(member.getPosition() != null && member.getPosition().equals(positions[i])){ %>
<option selected><%=positions[i] %></option>
<%} else {%>
	<option><%=positions[i] %></option>
	<%} %>
	<%} %>
				</select></td></tr>
<tr>
<th>名前</th><td>：<input type="text"  name="name"  value="<%=member.getName()%>"></td>
</tr>
<tr>
<th>名前(なまえ)</th><td>：<input type="text" name="reading" value="<%=member.getReading()%>"></td>
</tr>
<tr>
<th>住所</th><td>：<input type="text" name="address" value="<%=member.getAddress()%>"></td>
</tr>
<tr>
<th>電話番号</th><td>：<input type="text" name="phoneNo" value="<%=member.getPhoneNo()%>"></td>
</tr>
<tr>
<th>所属団体</th><td>：<select name="affiliation">
<%for(int i=0 ; i < affiliations.length ; i++){ %>
<%if(member.getAffiliation().equals(affiliations[i])){ %>
	<option selected><%=affiliations[i] %></option>
<%}else{ %>
	<option><%=affiliations[i] %></option>
<%} %>
<%} %>
						</select></td>
</tr>
</table>
<input type="hidden" name="id" value="<%=member.getId() %>">
<button type="submit" >更新</button><br>
</form>
</body>
</html>
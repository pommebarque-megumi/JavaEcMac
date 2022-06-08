<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
    <%
    List<Member> membersList = (List<Member>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>健全育成委員一覧</title>
</head>
<body>
<a href="/committee_member/Create">新しいメンバーを追加する</a>
<%if((membersList!=null)&&(membersList.size()>0)){ %>
<table border="1">
<tr>
<th></th><th>役職</th><th>名前</th><th>住所</th><th>電話</th><th>所属団体</th><th></th>
</tr>
<%for(int i=0; i<membersList.size();i++){ %>
<tr>
<td><%=i+1 %></td>
<%if((membersList.get(i).getPosition()!=null)&&((membersList.get(i).getPosition()).length()>0)){ %>
<td><%=(membersList.get(i)).getPosition() %></td>
<%}else{ %>
<td></td>
<%} %>
<td><%=(membersList.get(i)).getName() %></td>
<td><%=(membersList.get(i)).getAddress() %></td>
<td><%=(membersList.get(i)).getPhoneNo() %></td>
<%if((membersList.get(i).getAffiliation()!=null)&&((membersList.get(i).getAffiliation()).length()>0)){ %>
<td><%=(membersList.get(i)).getAffiliation() %></td>
<%}else{ %>
<td></td>
<%} %>
<td>
<a href="/committee_member/Update?id=<%=(membersList.get(i)).getId() %>">更新</a>
<a href="/committee_member/Delete?id=<%=(membersList.get(i)).getId() %>" onclick="return confirm('name=<%=membersList.get(i).getName()%>を削除してよろしいですか？');">削除</a>
</td>
</tr>
<%} %>
</table>
<%} %>
</body>
</html>
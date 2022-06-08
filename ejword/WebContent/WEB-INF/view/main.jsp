<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
    <%List<Word> list = (List<Word>) request.getAttribute("list");
    String searchWord = (String) request.getAttribute("searchWord");
   searchWord = (searchWord == null) ? "":searchWord;
    String mode = (String) request.getAttribute("mode");
	mode = (mode == null) ? "":mode;
	Integer total = (Integer) request.getAttribute("total");
	Integer limit = (Integer) request.getAttribute("limit");
	Integer pageNo = (Integer) request.getAttribute("pageNo");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>英和翻訳アプリ</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<style>
 form{
 text-align:left;
 margin:20px auto;
 }
 input,select{
 margin-right:5px;
 }
 .pager{
text-align:left;
 }
 </style>
</head>
<body>
<div class="container">
<form action="/ejword/main" method="get" class="form-inline">
<input type="text" name="searchWord"  value="<%=searchWord%>" class="form-control" placeholder="検索語を入力" required>
<select name="mode" class="form-control">
<option value="startsWith" <%=mode.equals("startsWith")?"selected":"" %>>で始まる</option>
<option value="contains" <%=mode.equals("contains")?"selected":"" %>>を含む</option>
<option value="endsWith" <%=mode.equals("endsWith")?"selected":"" %>>で終わる</option>
<option value="match" <%=mode.equals("match")?"selected":"" %>>と一致する</option>
</select>
<button type="submit" class="btn btn-primary">検索</button>
</form>
<%if(list != null && list.size()>0){ %>
	<%if(total < limit){ %>
	<p>全<%=total %>件</p>
	<%}else{ %>
	<p>全<%=total %>件中 <%=((pageNo-1)*limit)+1 %>〜<%=Math.min((pageNo*limit),total) %>件を表示</p>
	<ul class="pager">
		<%if(pageNo > 1){ %>
		<li><a href="/ejword/main?searchWord=<%=searchWord%>&mode=<%=mode%>&page=<%=pageNo-1 %>">前へ</a></li>
		<%} %>
		<%if(pageNo*limit < total){ %>
		<li><a href="/ejword/main?searchWord=<%=searchWord%>&mode=<%=mode%>&page=<%=pageNo+1 %>">次へ</a></li>
		<%} %>
	</ul>
	<%} %>
<table class="table table-borderd table-striped">
<%for(Word word : list) {%>
<tr><th><%=word.getTitle() %></th>
<td><%=word.getBody() %></td></tr>
<%} %>
</table>
<%} %>
</div>
</body>
</html>
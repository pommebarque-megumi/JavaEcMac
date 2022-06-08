<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規委員登録ページ</title>
</head>
<body>
<p>追加するメンバーの情報を入力してください</p>
<form action="/committee_member/Create" method="post">
<table>
<tr>
<th>役職</th><td>：<select name="position">
	<option>なし</option>
	<option>会長</option>
	<option>副会長</option>
	<option>会計</option>
	<option>書記</option>
	<option>監事</option>
	<option>レクレーション</option>
	<option>補導連絡会</option>
	<option>文化部</option>
	<option>青少年協力員</option>
	<option>広報</option>
	<option>体育部</option>
				</select></td></tr>
<tr>
<th>名前</th><td>：<input type="text"  name="name"></td>
</tr>
<tr>
<th>名前(なまえ)</th><td>：<input type="text" name="reading"></td>
</tr>
<tr>
<th>住所</th><td>：<input type="text" name="address"></td>
</tr>
<tr>
<th>電話番号</th><td>：<input type="text" name="phoneNo"></td>
</tr>
<tr>
<th>所属団体</th><td>：<select name="affiliation">
	<option>所属なし</option>
	<option>地区協</option>
	<option>PTA</option>
	<option>解放委員会</option>
						</select></td>
</tr>
</table>
<button type="submit" >追加</button><br>
</form>
</body>
</html>
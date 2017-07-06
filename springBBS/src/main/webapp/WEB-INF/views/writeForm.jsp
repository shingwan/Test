<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix ="form" uri = "" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr width="700"  size ="2" color = "orange"/>
		<h2 font-size = "5">作成ページ</h2>
		<hr width="700"  size ="4" color = "orange"/>
		<table width="800" cellpadding="0" cellspacing="0" border="1">
			<form:form commandName="BVO" action="writeOK" method="post">
				<tr>
					<td width = "100">作成者</td>
					<td><form:input path="bName" size="20"/></td>
				</tr>
				<tr>
					<td width = "100">題名</td>
					<td><form:input path="bSubject" size="50"/></td>
				</tr>
				<tr>
					<td width = "100">内容</td>
					<td width ="300"><form:textarea path="bContent" cols="100" rows="8"/></td>
				</tr>
				<tr>
					<td colspan="10" align = "center"><input type="submit" value="登録"></td>
				</tr>
			</form:form>
		</table>

	</div>
</body>
</html>
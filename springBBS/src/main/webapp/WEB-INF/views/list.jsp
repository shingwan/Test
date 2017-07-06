<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align = "center">
	<h2>リスト</h2>
	<hr width = "1400" color = "red">

	<table border ="1" cellpadding = "0" cellspacing = "0" width = "500">

			<tr>
				<td>番号</td>
				<td>題名</td>
				<td>作成者</td>
				<td>日付</td>
				<td>紹介数</td>
			</tr>
			<c:forEach items = "${list}"  var = "vo">

			<tr>
				<td>${vo.bNo}</td>
				<td>${vo.bSubject}</td>
				<td>${vo.bName}</td>
				<td>${vo.bDate}</td>
				<td>${vo.bHit}</td>

			</tr>
			</c:forEach>

			<tr>
				<td colspan ="5"><a href = "writeForm">write</a></td>
			</tr>
	</table>

</div>
</body>
</html>
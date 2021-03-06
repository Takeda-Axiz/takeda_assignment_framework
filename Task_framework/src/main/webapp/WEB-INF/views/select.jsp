<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<p>
		検索したいデータ情報を入力してください<br> ※全て空白の場合は全検索を行います
	</p>

	<c:if test="${not empty errmsg}">
		<p class="error">${fn:escapeXml(errmsg)}</p>
	</c:if>

	<form:form action="list" modelAttribute="SelectForm" method="get">
		<fieldset>
			<div>
				<label>ID</label>
				<form:input path="idVal" value="${fn:escapeXml(param.id)}" />
			</div>
			<div>
				<label>名前</label>
				<form:input path="nameVal" value="${fn:escapeXml(param.name)}" />
			</div>
			<div>
				<label>TEL</label>
				<form:input path="telVal" value="${fn:escapeXml(param.tel)}" />
			</div>
		</fieldset>
		<input type="submit" value="検索" />
	</form:form>
	<div>
		<a href="menu">メニューに戻る</a>
	</div>
</body>
</html>

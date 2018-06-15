<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除確認画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<p>このデータでよろしいですか？</p>

	<form:form action="delete" modelAttribute="DeleteForm" method="post">
		<fieldset>
			<div>
				<label>ID</label>
				<form:input path="idVal" value="${fn:escapeXml(deleteUser.userId)}"
					readonly="true" />
			</div>
			<div>
				<label>名前</label>
				<form:input path="" value="${fn:escapeXml(deleteUser.userName)}"
					readonly="true" />
			</div>
			<div>
				<label>TEL</label>
				<form:input path="" value="${fn:escapeXml(deleteUser.telephone)}"
					readonly="true" />
			</div>
		</fieldset>
		<div>
			<input type="submit" name="button" value="削除"> <input
				type="submit" name="button" value="戻る"
				onclick="location.href='delete'; return false;">
		</div>
	</form:form>
	<div>
		<a href="menu">メニューに戻る</a>
	</div>
</body>
</html>

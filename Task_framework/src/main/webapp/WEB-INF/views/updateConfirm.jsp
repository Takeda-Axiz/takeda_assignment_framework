<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新内容確認画面</title>
<link href="css/commons.css" rel="stylesheet">
<style>
.col {
	float: left;
}

.col-clear {
	clear: both;
}

#arrow {
	margin-top: 60px;
}
</style>
</head>
<body>
	<p>これでよろしいですか？</p>

	<c:if test="${not empty errmsg}">
		<p class="error">${fn:escapeXml(errmsg)}</p>
	</c:if>

	<form:form action="update" modelAttribute="UpdateForm" method="post">
		<fieldset>
			<div>
				<label>ID</label>
				<form:input path="idVal" value="${fn:escapeXml(beforeUser.userId)}"
					readonly="true" />
			</div>
		</fieldset>

		<fieldset class="col">
			<legend>変更前</legend>
			<div>
				<label>名前</label>
				<form:input path="nameVal" value="${fn:escapeXml(beforeUser.userName)}"
					disabled="true" />
			</div>
			<div>
				<label>TEL</label>
				<form:input path="telVal"
					value="${fn:escapeXml(beforeUser.telephone)}" disabled="true" />
			</div>
			<div>
				<label>PASS</label>
				<form:password path="passVal"
					value="${fn:escapeXml(beforeUser.password)}" disabled="true" />
			</div>
		</fieldset>

		<div id="arrow" class="col">⇒</div>

		<fieldset class="col label-110">
			<legend>変更後</legend>
			<div>
				<label>名前</label>
				<form:input path="" value="${fn:escapeXml(afterUser.userName)}"
					readonly="true" />
			</div>
			<div>
				<label>TEL</label>
				<form:input path="" value="${fn:escapeXml(afterUser.telephone)}"
					readonly="true" />
			</div>
			<div>
				<label>PASS(再入力)</label>
				<form:password path="rePassVal" value="${fn:escapeXml(rePass)}" />
			</div>
		</fieldset>

		<div class="col-clear">
			<input type="submit" name="button" value="更新"> <input
				type="submit" name="button" value="戻る"
				onclick="location.href='updateInput'; return false;">
		</div>
	</form:form>
	<div>
		<a href="menu">メニューに戻る</a>
	</div>
</body>
</html>

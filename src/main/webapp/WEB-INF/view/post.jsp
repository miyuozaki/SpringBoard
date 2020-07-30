<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>GOGO</title>
		<!-- パスを合わせないと外部ファイル読み込まないよ -->
		<link href="${pageContext.request.contextPath}/resources/css/post.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath}/resources/js/postValidation.js"></script>
	</head>
	<body>
		<!-- エラーメッセージやタイトルメッセージ -->
		<h1>${message}</h1>
		<form:form modelAttribute="postform" >
			<label>名前</label><br>
			<form:input path="name"/><br>
			<label>本文</label><br>
			<form:textarea path="content" cols="50" rows="5"/><br>
			<input type="submit" value="投稿">
		</form:form>
	</body>
</html>
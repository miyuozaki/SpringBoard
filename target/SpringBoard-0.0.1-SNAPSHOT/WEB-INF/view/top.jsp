<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>OK GO</title>
	</head>
	<body>
		<!-- エラーメッセージやタイトルメッセージ -->
		<h1>${message}</h1>
		<!-- 投稿 -->
		<c:forEach items = "${posts}" var = "post">
			<c:out value="{post.id}"></c:out>
			<c:out value="{post.name}"></c:out>
			<c:out value="{post.content}"></c:out>
		</c:forEach>
		<!-- コメント -->
		<c:forEach items = "${comments}" var = "comment">
		<c:out value="{comment.id}"></c:out>
		<c:out value="{comment.name}"></c:out>
		<c:out value="{comment.comment}"></c:out>
		</c:forEach>
	</body>
</html>
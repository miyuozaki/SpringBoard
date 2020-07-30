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
		<a href="post">新規投稿</a><br><br>
		<c:forEach items = "${posts}" var = "post">
			<c:out value="${post.id}"></c:out>
			<c:out value="${post.name}"></c:out><br>
			<c:out value="${post.content}"></c:out>
			<!-- 投稿削除処理 -->
			<form:form modelAttribute="deleteform">
				<!-- hiddenで投稿のidを取得(form:inputではなくinput，pathではなくname) -->
				<input type="hidden" name="id" value="${post.id}">
				<input type="submit" name="delete" value="削除"/>
			</form:form><br>
		</c:forEach>
		<!-- コメント -->
		<c:forEach items = "${comments}" var = "comment">
		<c:out value="${comment.id}"></c:out>
		<c:out value="${comment.name}"></c:out><br>
		<c:out value="${comment.comment}"></c:out><br>
		</c:forEach>
	</body>
</html>
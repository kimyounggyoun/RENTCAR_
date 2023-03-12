<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' media='screen'
	href='${ctx}/css/03_02_memberInsert.css'>
</head>
<body>
	<div div align="center">
		<%@ include file="b_top.jsp"%>
		<form action="${ctx}/memberInsert.do" method="post" style="height: 650px;">
			<div class="logInsertBox">
				<div class="logInsertTitle">Required Input</div>
				<div class="logInsertBoxRows">
					<div class="logInsertQ_2">ID</div>
					<div class="logInsertA_2">
						<input class="logInsA" type="text" name="id">
					</div>
					<div class="logInsertQ_1">E-mail</div>
					<div class="logInsertA_1">
						<input class="logInsA" type="text" name="email">
					</div>
				</div>
				<div class="logInsertBoxRows">
					<div class="logInsertQ_2">PW</div>
					<div class="logInsertA_2">
						<input class="logInsA" type="password" name="pw1">
					</div>
					<div class="logInsertQ_1">Tel.</div>
					<div class="logInsertA_1">
						<input class="logInsA" type="text" name="tel">
					</div>
				</div>
				<div class="logInsertTitle">Non-Required Input</div>
				<div class="logInsertBoxRows">
					<div class="logInsertQ_2">Job</div>
					<div class="logInsertA_2">
						<input class="logInsA" type="text" name="job">
					</div>
					<div class="logInsertQ_2">Hobby</div>
					<div class="logInsertA_2">
						<input class="logInsA" type="text" name="hobby">
					</div>
					<div class="logInsertQ_2">Age</div>
					<div class="logInsertA_2">
						<input class="logInsA" type="text" name="age">
					</div>
				</div>
				<div class="logInsertBoxRows_2">
					<div class="logInsertQ_3">Info</div>
					<div class="logInsertA_3">
						<textarea class="logInsertTextarea" name="info" cols="30"
							rows="10"></textarea>
					</div>
				</div>
				<div class="logInsertbot">
					<input class="logInsertFinBtn" type="submit" value="회원가입">
				</div>
				<div class="logInsertTitle">Welcome to CAR World</div>
			</div>
		</form>
		<%@ include file="b_bottom.jsp"%>
	</div>
</body>
</html>
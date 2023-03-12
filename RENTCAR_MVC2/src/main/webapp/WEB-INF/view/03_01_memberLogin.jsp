<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div div align="center">
		<%@ include file="b_top.jsp"%>
		<form action="${ctx}/memberLogin.do" method="post">
			<div style="height: 300px; margin: 50px 0 50px 0;" align="center">
				<table>
					<tr>
						<td align="center">아이디</td>
						<td><input type="text" name="loginId" /></td>
					</tr>
					<tr>
						<td align="center">패스워드</td>
						<td><input type="password" name="loginPw" /></td>
					</tr>
				</table>
				<div>
					<div style="margin: 20px 0 0 0;" align="center">
						<input type="submit" value="로그인" />
					</div>
					<div style="margin: 10px 0 0 0; color: rgb(83, 98, 231);">
						<c:if test="${loginNull ne null }">${loginNull}</c:if>
						<c:if test="${idNull ne null }">${idNull}</c:if>
						<c:if test="${pwNull ne null }">${pwNull}</c:if>
					</div>
				</div>
			</div>
		</form>
		<%@ include file="b_bottom.jsp"%>
	</div>
</body>
</html>
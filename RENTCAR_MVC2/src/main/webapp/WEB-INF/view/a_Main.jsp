<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>

<link rel="stylesheet" type="text/css"
	href="${ctx}/css/a_main_style.css">
<script
	src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
</head>
<body>
	<div align="center">
		<div class="box">
			<div class="top"><jsp:include page="b_top.jsp" /></div>
			<div class="main"><jsp:include page="b_center.jsp" /></div>
			<div class="bottom"><jsp:include page="b_bottom.jsp" /></div>
		</div>
	</div>
</body>
</html>
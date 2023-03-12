<%@page import="kr.basic.model.RentcarBean"%>
<%@page import="kr.basic.model.RentcarDAO"%>
<%@page import="java.util.ArrayList"%>

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

	<div align="center">
		<%@ include file="b_top.jsp"%>
		<div>
			<form action="${ctx}/carCategoryList.do" method="post">
				<select name="category" style="width: 100px; margin: 23px 0 0 0;">
					<option value="0">모든 차량</option>
					<option value="1">소형 차량</option>
					<option value="2">중형 차량</option>
					<option value="3">대형 차량</option>
				</select> <input type="submit" value="검색" />
			</form>
		</div>
		<table style="text-align: center;">
			<tr style="width: 100%; height: 80px;">
				<td style="width: 450px;">사진</td>
				<td style="width: 100px;">종류</td>
				<td style="width: 100px;">분류</td>
				<td style="width: 100px;">일 대여료</td>
				<td style="width: 200px;"></td>
			</tr>
			<c:forEach var="vo" items="${list}">
				<tr style="width: 1000px; height: 150px;">
					<td style="width: 450px;"><img src="${ctx}/img/${vo.img}"
						style="height: 140px;"></td>
					<td style="width: 100px;"><a
						href="${ctx}/carReserveInfo.do?no=${vo.no}">${vo.name}</a></td>
					<td style="width: 100px;"><c:if test="${vo.category == 1}">소형</c:if>
						<c:if test="${vo.category == 2}">중형</c:if> <c:if
							test="${vo.category == 3}">대형</c:if></td>
					<td style="width: 100px;">${vo.price}원</td>
					<td style="width: 200px;">${vo.info}</td>
				</tr>
			</c:forEach>
		</table>
		<%@ include file="b_bottom.jsp"%>
	</div>

</body>

</html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>carReserveResult</title>
<link rel='stylesheet' type='text/css' media='screen'
	href="${ctx}/css/05_03_carReserveResult_style.css">

</head>

<body>
	<div align="center">
		<%@ include file="b_top.jsp"%>

		<div class="resResultBox" align="center">
			<div class="resResultTopBox">예약 정보 확인</div>
			<div class="resResultListBox">
				<c:forEach var="vo" items="${resultList}" varStatus="status">
					<div class="resResultListRows">
						<div class="resResBox1">
							<div class="rrImgbox">
								<img src="${ctx}/img/${vo.no}.jpg" width="100%">
							</div>
							<div class="rrNameBox">${vo.carname }</div>
							<div class="rrNameBox">렌트 금액 : ${vo.rtprice } 원</div>
						</div>
						<div class="resResBox2">
							기본정보
							<div class="resResBoxRows">
								<div class="rrBox">대여시작일</div>
								<div class="rrBox">${vo.rday }</div>
							</div>
							<div class="resResBoxRows">
								<div class="rrBox">대여기간[일]</div>
								<div class="rrBox">${vo.dday }</div>
							</div>
							<div class="resResBoxRows">
								<div class="rrBox">기본금액[원]</div>
								<div class="rrBox">${vo.price }</div>
							</div>
							<div class="resResBoxRows">
								<div class="rrBox">수량[대]</div>
								<div class="rrBox">${vo.qty }</div>
							</div>
						</div>
						<div class="resResBox2">
							추가정보
							<div class="resResBoxRows">
								<div class="rrBox">보험</div>
								<div class="rrBox">
									<c:if test="${vo.usein == 0}">미적용</c:if>
									<c:if test="${vo.usein == 1}">적용</c:if>
								</div>
							</div>
							<div class="resResBoxRows">
								<div class="rrBox">Wifi</div>
								<div class="rrBox">
									<c:if test="${vo.usewifi == 0}">미적용</c:if>
									<c:if test="${vo.usewifi == 1}">적용</c:if>
								</div>
							</div>
							<div class="resResBoxRows">
								<div class="rrBox">베이비시트</div>
								<div class="rrBox">
									<c:if test="${vo.useseat == 0}">미적용</c:if>
									<c:if test="${vo.useseat == 1}">적용</c:if>
								</div>
							</div>
							<div class="resResBoxRows">
								<div class="rrBox">네비게이션</div>
								<div class="rrBox">
									<c:if test="${vo.usenavi == 0}">미적용</c:if>
									<c:if test="${vo.usenavi == 1}">적용</c:if>
								</div>
							</div>
						</div>
						<div class="deleteBox">
							<input type="button" value="예약 취소"
								onclick="location.href='${ctx}/carReserveResultDel.do?idx=${vo.reserve_seq}'">
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<%@ include file="b_bottom.jsp"%>
	</div>


</body>
</html>
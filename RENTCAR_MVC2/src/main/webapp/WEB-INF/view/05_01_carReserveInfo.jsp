<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>carReserveInfo</title>
<link rel='stylesheet' type='text/css' media='screen'
	href='${ctx}/css/05_01_carReserveInfo_style.css'>

</head>

<body>
	<div align="center">
		<%@ include file="b_top.jsp"%>
		<div class="resBox" align="center">
			<div class="resTopBox">차량 정보 확인</div>
			<div class="resMainBox">
				<div class="optionImg">
					<img src="${ctx}/img/${oneCarInfo.img}" style="width: 100%;">
				</div>
				<form action="${ctx}/carOptionSelect.do?carName=${oneCarInfo.name}"
					method="post">
					<div class="optionView">
						<div class="optionRows">
							<div class="optionColumns">차량이름</div>
							<div class="optionColumns">${oneCarInfo.name}</div>
						</div>
						<div class="optionRows">
							<c:if test="${er ne null }">
								<div class="optionColumns" style="color: rgb(83, 98, 231);">최대
									렌트 수는 3대 입니다.</div>
							</c:if>
							<c:if test="${er eq null }">
								<div class="optionColumns">차량수량</div>
								<div class="optionColumns">
									<select class="optionCnt" name="qty">
										<c:forEach var="i" begin="1" end="${limit }">
											<option align="center" value="${i}">
												<c:out value="${i}" />
											</option>
										</c:forEach>
									</select>
								</div>
							</c:if>
						</div>
						<div class="optionRows">
							<div class="optionColumns">차량분류</div>
							<div class="optionColumns">
								<c:if test="${oneCarInfo.category == 1}">소형</c:if>
								<c:if test="${oneCarInfo.category == 2}">중형</c:if>
								<c:if test="${oneCarInfo.category == 3}">대형</c:if>
							</div>
						</div>
						<div class="optionRows">
							<div class="optionColumns">기본금액</div>
							<div class="optionColumns">${oneCarInfo.price}</div>
						</div>
						<div class="optionRows">
							<div class="optionColumns">제조회사</div>
							<div class="optionColumns">${oneCarInfo.company}</div>
						</div>
						<div class="optionRows">
							<c:if test="${er eq null }">
								<input class="optionSel" type="submit" value="옵션선택하기">
							</c:if>
							<c:if test="${er ne null }">
								<input class="optionSel"
									onclick="location.href='${ctx}/carAllList.do'" type="button"
									value="다른차량보기">
							</c:if>
						</div>
					</div>
				</form>
			</div>
			<div class="resBotBox">${oneCarInfo.info}</div>
		</div>
		<%@ include file="b_bottom.jsp"%>
	</div>
</body>
</html>
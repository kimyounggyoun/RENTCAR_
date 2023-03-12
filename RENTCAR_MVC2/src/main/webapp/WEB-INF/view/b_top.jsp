<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>렌트카</title>
<link rel='stylesheet' type='text/css' media='screen'
	href='${ctx}/css/b_top_style.css'>
<script
	src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
<body>
	<div class="box top">
		<div class="box2">
			<div class="t_banner" onclick="location.href='${ctx}/main.do'">
				<img src="${ctx}/img/rent_logo2.png">
			</div>
			<div class="t_login">
				<c:if test="${log eq null}">
					<div class="loginId">GUEST</div>
					<div class="loginBtnBox">
						<button class="loginBtn"
							onclick="location.href='${ctx}/memberLogin.do'">로그인</button>
						<button class="loginBtn"
							onclick="location.href='${ctx}/memberInsert.do'">회원가입</button>
					</div>
				</c:if>
				<c:if test="${log ne null}">
					<div class="loginId">${log}</div>
					<div class="loginBtnBox">
						<button class="loginBtn"
							onclick="location.href='${ctx}/memberLogout.do'">로그아웃</button>
						<button class="loginBtn"
							onclick="location.href='${ctx}/memberUpdate.do'">정보수정</button>
					</div>
				</c:if>
			</div>
		</div>
		<div class="box3">
			<div class="tap" onclick="location.href='${ctx}/carCategoryList.do'">예약하기</div>
			<div class="tap"
				onclick="location.href='${ctx}/carReserveResultView.do'">예약확인</div>
			<div class="tap" onclick="location.href='${ctx}/boarder.do'">게시판</div>
			<div class="tap" onclick="location.href='${ctx}/event.do'">이벤트</div>
			<div class="tap" onclick="location.href='${ctx}/ServiceCenter.do'">고객센터</div>
		</div>
	</div>
</body>

</html>


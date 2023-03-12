<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>carOptionSelect</title>
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
				<form
					action="${ctx}/carReserveSelect.do?qty=${qty}&carName=${oneCarInfo.name}"
					method="post">
					<div class="optionView">
						<div class="optionRows">
							<div class="optionColumns">대여일</div>
							<div class="optionColumns">
								<input class="optionCnt" type="date" id="date" name="rday">
							</div>
						</div>
						<div class="optionRows">
							<div class="optionColumns">대여기간</div>
							<div class="optionColumns">
								<select class="optionCnt" name="dday">
									<option align="center" value="1">1 일</option>
									<option align="center" value="2">2 일</option>
									<option align="center" value="3">3 일</option>
									<option align="center" value="4">4 일</option>
									<option align="center" value="5">5 일</option>
									<option align="center" value="6">6 일</option>
									<option align="center" value="7">7 일</option>
								</select>
							</div>
						</div>
						<div class="optionRows">
							<div class="optionColumns">보험</div>
							<div class="optionColumns">
								<select class="optionCnt" name="usein">
									<option align="center" value="0">미적용</option>
									<option align="center" value="1">적용(1일 1만원)</option>
								</select>
							</div>
						</div>
						<div class="optionRows">
							<div class="optionColumns">Wifi</div>
							<div class="optionColumns">
								<select class="optionCnt" name="usewifi">
									<option align="center" value="0">미적용</option>
									<option align="center" value="1">적용(1일 1만원)</option>
								</select>
							</div>
						</div>
						<div class="optionRows">
							<div class="optionColumns">네비게이션</div>
							<div class="optionColumns">
								<select class="optionCnt" name="usenavi">
									<option align="center" value="1">적용(무료)</option>
									<option align="center" value="0">미적용</option>
								</select>
							</div>
						</div>
						<div class="optionRows">
							<div class="optionColumns">베이비시트</div>
							<div class="optionColumns">
								<select class="optionCnt" name="useseat">
									<option align="center" value="0">미적용</option>
									<option align="center" value="1">적용(1일 1만원)</option>
								</select>
							</div>
						</div>
						<div class="optionRows">
							<input class="optionSel" type="submit" value="차량예약하기">
						</div>
					</div>
				</form>
			</div>
			<div class="resBotBox">${oneCarInfo.info}</div>
		</div>
		<%@ include file="b_bottom.jsp"%>
	</div>

	<script>
		/* var now_utc = Date.now()
		var timeOff = new Date().getTimezoneOffset() * 60000;
		var today = new Date(now_utc - timeOff).toISOString().split("T")[0];
		document.getElementById("date").setAttribute("min", today); */
		
		var today = new Date().toISOString().substring(0, 10);
		document.getElementById("date").setAttribute("min", today);
		document.getElementById("date").value = today
	</script>


	<!-- --- codeMemo ---
	Date.now()는 현재 날짜를 밀리 초로 반환
	 Date.now() 반환 값 [ex) 1652259978452]
	
	toISOString은 UTC기준으로 시간을 문자열로 바꿔서 반환 
	
	getTimezoneOffset()을 이용해 UTC기준 시간과 여기 시간의 차이 계산 
	getTimezoneOffset()은 UTC 시간과 차이를 분 단위 반환
					   => 60,000을 곱해서 밀리초 단위로 변경
						
	new Date(now_utc-timeOff).toISOString()			
	=> now_utc-timeOff를 통해 이곳 기준 시간 값 가져오기
	toISOString을 통해 시간을 문자열 변경
	 
	toISOString() => [ex)'2022-05-11T18:09:38.134Z' ] 반환
	여기서 "T" 를 기준으로 split => '2022-05-11'
	
	today에 저장 후 input 태그에서 ( min or max ) 값으로 today값을 줌
	today ( 이전 or 이후 ) 선택이 되지않음 -->

</body>
</html>
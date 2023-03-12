package kr.basic.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.basic.model.CarReserveBean;
import kr.basic.model.CarReserveDAO;

public class D_carReserveResultViewController implements _Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("log");

		// 비로그인 => 로그인페이지 이동
		if (userId == null) {
			String ctx = request.getContextPath();
			return "redirect:" + ctx + "/memberLogin.do";
		}

		ArrayList<CarReserveBean> resultList = CarReserveDAO.getInstance().userReserveList(userId);
		request.setAttribute("resultList", resultList);

		return "06_01_carReserveView";
	}
}

// <c:forEach items="${resultList}" start="0" end="${resultList.size() } step="1" varStatus = "status" >
// <img src="${ctx}/img/${resultList.get(status.index).rday}.jpg" width="100%">
package kr.basic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.basic.model.CarReserveDAO;
import kr.basic.model.RentcarBean;
import kr.basic.model.RentcarDAO;

public class C_carOptionSelectController implements _Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("-- C_carOptionSelectController --");

		////
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("log");
		String ctx = request.getContextPath();
		// 비로그인 => 로그인페이지 이동
		if (userId == null) {
			return "redirect:" + ctx + "/memberLogin.do";
		}
		////

		String carName = request.getParameter("carName");
		RentcarBean oneCarInfo = RentcarDAO.getInstance().oneCarInfo(carName);

		int qty = Integer.parseInt(request.getParameter("qty"));

		System.out.println("carName : " + carName);
		System.out.println("qty : " + qty);

//		int limit = CarReserveDAO.getInstance().limit(qty, userId, carName);
//		if (limit >= 4) {
//			System.out.println("limit check : " + limit + " / no : " + oneCarInfo.getNo());
//			return "redirect:" + ctx + "/carReserveInfo.do?no=" + oneCarInfo.getNo() + "&er=1";
//		}

		request.setAttribute("oneCarInfo", oneCarInfo);
		request.setAttribute("qty", qty);

		return "05_02_carOptionSelect";
	}
}
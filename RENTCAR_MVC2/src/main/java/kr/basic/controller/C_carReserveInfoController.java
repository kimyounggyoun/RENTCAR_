package kr.basic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.basic.model.CarReserveDAO;
import kr.basic.model.RentcarBean;
import kr.basic.model.RentcarDAO;

public class C_carReserveInfoController implements _Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("-- C_carReserveInfoController --");

		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("log");
		System.out.println("log : " + session.getAttribute("log") + "/ userId : " + userId);
		String ctx = request.getContextPath();

		if (userId == null) {
			return "redirect:" + ctx + "/memberLogin.do";
			// 비로그인 => 로그인페이지 이동
		}

		int no = Integer.parseInt(request.getParameter("no"));
		RentcarBean oneCarInfo = RentcarDAO.getInstance().oneCarInfo(no);
		request.setAttribute("oneCarInfo", oneCarInfo);

		int limit = CarReserveDAO.getInstance().limit(userId, oneCarInfo.getName());
		if (limit >= 3) {
			System.out.println("limit check : " + limit + " / no : " + oneCarInfo.getNo());
			request.setAttribute("er", 1);
		} else {
			limit = 3 - limit;
			request.setAttribute("limit", limit);
		}

		return "05_01_carReserveInfo";

	}
}
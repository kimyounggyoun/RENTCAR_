package kr.basic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.CarReserveDAO;

public class D_carReserveResultDelController implements _Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("-- D_carReserveResultDelController --");
		
		int num = Integer.parseInt(request.getParameter("idx"));
		CarReserveDAO.getInstance().deleteReserveList(num);

		System.out.println("num : " + num);
		
		String ctx = request.getContextPath();

		return "redirect:" + ctx + "/carReserveResultView.do";
	}
}
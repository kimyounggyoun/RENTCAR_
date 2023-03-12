package kr.basic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.basic.model.CarReserveBean;
import kr.basic.model.CarReserveDAO;
import kr.basic.model.RentcarBean;
import kr.basic.model.RentcarDAO;

public class C_carReserveSelectController implements _Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String carName = request.getParameter("carName");
		RentcarBean carData = RentcarDAO.getInstance().oneCarInfo(carName);
		int carIdx = carData.getNo();

		HttpSession session = request.getSession(); // 필요
		String userId = (String) session.getAttribute("log");
		int qty = Integer.parseInt(request.getParameter("qty"));

		String rday = request.getParameter("rday");
		int dday = Integer.parseInt(request.getParameter("dday"));
		int usein = Integer.parseInt(request.getParameter("usein"));
		int usewifi = Integer.parseInt(request.getParameter("usewifi"));
		int usenavi = Integer.parseInt(request.getParameter("usenavi"));
		int useseat = Integer.parseInt(request.getParameter("useseat"));
		String carname = carName;
		int price = carData.getPrice();
		int rtprice = CarReserveDAO.getInstance().rentAllPrice(dday, price, usewifi + usein + useseat, qty);

		//
		System.out.println("carName : " + carName + "/ carIdx : " + carIdx + "/ userId : " + userId);
		System.out.println("qty : " + qty + "/ rday : " + rday + "/ dday : " + dday + "/ usein : " + usein
				+ "/ usewifi : " + usewifi + "/ usenavi : " + usenavi + "/ useseat : " + useseat + "/ carname : "
				+ carname + "/ price : " + price + "/ rtprice : " + rtprice);
		//
		
		CarReserveBean reserveData = new CarReserveBean(0, carIdx, userId, qty, dday, rday, usein, usewifi, usenavi,
				useseat, carname, price, rtprice);
		CarReserveDAO.getInstance().addReserveList(reserveData);

		request.setAttribute("reserveData", reserveData);

		return "05_03_carReserveResult";
	}
}
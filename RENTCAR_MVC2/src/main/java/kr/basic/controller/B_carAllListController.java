package kr.basic.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.RentcarBean;
import kr.basic.model.RentcarDAO;

public class B_carAllListController implements _Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<RentcarBean> list = RentcarDAO.getInstance().carList();

		request.setAttribute("list", list);
//		HttpSession session = request.getSession();
//		session.setAttribute("list", list);
//		System.out.print(list);

		return "04_02_carAllList";
	}
}

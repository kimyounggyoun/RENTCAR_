package kr.basic.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.RentcarBean;
import kr.basic.model.RentcarDAO;

public class B_carCategoryListController implements _Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int selCategory = 0;
		
		if (request.getParameter("category") != null) {
			selCategory = Integer.parseInt(request.getParameter("category"));
		}
		
		ArrayList<RentcarBean> list;
		if (selCategory == 0) {
			list = RentcarDAO.getInstance().carList();
		} else {
			list = RentcarDAO.getInstance().categoriList(selCategory);
		}

		request.setAttribute("list", list);

		return "04_02_carCategoryList";
	}
}
package kr.basic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class A_memberLogoutController implements _Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("log");
		String ctx = request.getContextPath();
		response.sendRedirect(ctx + "/main.do");
		return null;
	}

}
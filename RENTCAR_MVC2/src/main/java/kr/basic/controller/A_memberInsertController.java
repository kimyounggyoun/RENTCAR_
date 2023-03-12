package kr.basic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.basic.model.MemberDAO;

public class A_memberInsertController implements _Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("-- A_memberInsertController --");

		
		if (request.getParameter("id") == null) {
			System.out.println("id : null");
			request.setAttribute("idNull", "로그인을 해주세요");
			return "03_02_memberInsert";
		}
		
		String ctx = request.getContextPath();
		return "03_02_memberInsert";


	}
}

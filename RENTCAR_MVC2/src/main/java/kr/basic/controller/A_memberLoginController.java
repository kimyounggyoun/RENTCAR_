package kr.basic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.basic.model.MemberDAO;

public class A_memberLoginController implements _Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("-- A_memberLoginController --");
		String ctx = request.getContextPath();
		String id = request.getParameter("loginId");
		String pw = request.getParameter("loginPw");

		if (request.getParameter("loginId") == null) {
			System.out.println("loginId : null");
			request.setAttribute("loginNull", "로그인을 해주세요");
			return "03_01_memberLogin";
		}

		String dbPw = MemberDAO.getInstance().checkMemberId(id); // 아이디체크 & 비밀번호리턴
		if (dbPw == null) {
			System.out.println("loginId : notTheFind");
			request.setAttribute("idNull", "아이디를 찾을 수 없습니다");
			return "03_01_memberLogin";
		}

		if (dbPw.equals(pw) == false) {
			System.out.println("loginPw : notTheSame");
			request.setAttribute("pwNull", "비밀번호가 일치하지 않습니다");
			return "03_01_memberLogin";
		}

		System.out.print("loginId : " + id + "/ loginPw : " + pw + "/ dbpw : " + dbPw);

		HttpSession session = request.getSession(); // 필요
		session.setAttribute("log", id);
		return "redirect:" + ctx + "/main.do";

	}
}

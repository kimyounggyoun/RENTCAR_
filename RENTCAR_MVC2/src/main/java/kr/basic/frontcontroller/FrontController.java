package kr.basic.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.controller._Controller;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8"); // 글자
		String url = request.getRequestURI(); // 프로젝트 + 파일경로
		String ctx = request.getContextPath(); // 프로젝트 Path

		String command = url.substring(ctx.length()); // uri - ctx
		_Controller controller = null;
		String nextPage = null;

		HandlerMapping mapping = new HandlerMapping();
		controller = mapping.getController(command);
		nextPage = controller.requestHandler(request, response);

		if (nextPage != null) { // ??
			if (nextPage.indexOf("redirect:") != -1) {
				response.sendRedirect(nextPage.split(":")[1]);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(ViewResolver.makeView(nextPage));
				rd.forward(request, response);
			}
		}
	}
}

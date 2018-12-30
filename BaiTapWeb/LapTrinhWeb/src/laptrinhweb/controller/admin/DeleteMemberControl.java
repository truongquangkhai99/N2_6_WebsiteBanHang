package laptrinhweb.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laptrinhweb.service.MemberService;
import laptrinhweb.service.impl.MemberServiceImpl;

@WebServlet(urlPatterns = "/admin/member/delete")
public class DeleteMemberControl extends HttpServlet {
	private MemberService memberService = new MemberServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		memberService.delete(Integer.valueOf(req.getParameter("id")));
		resp.sendRedirect(req.getContextPath() + "/admin/member/list");
	}
}

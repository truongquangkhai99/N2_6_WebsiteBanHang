package laptrinhweb.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laptrinhweb.model.Member;
import laptrinhweb.service.MemberService;
import laptrinhweb.service.impl.MemberServiceImpl;
@WebServlet(urlPatterns="/admin/member/list")
public class ListMemberControl extends HttpServlet {
	private MemberService memberService = new MemberServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Member> member = memberService.getAll();
		req.setAttribute("listMember", member);
		req.getRequestDispatcher("/view/admin/listMember.jsp").forward(req, resp);;
	}
}

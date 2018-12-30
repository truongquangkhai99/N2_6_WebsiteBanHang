package laptrinhweb.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laptrinhweb.model.Member;
import laptrinhweb.service.MemberService;
import laptrinhweb.service.impl.MemberServiceImpl;

@WebServlet(urlPatterns = "/admin/member/edit")
public class EditMemberControl extends HttpServlet {
	private MemberService memberService = new MemberServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member member = memberService.getById(Integer.valueOf(req.getParameter("id")));
		req.setAttribute("member", member);
		req.getRequestDispatcher("/view/admin/editMember.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username, password, nlpassword, hoTen, gmail, phone;
		int id;
		id = Integer.parseInt(req.getParameter("id"));
		username = req.getParameter("username");
		password = req.getParameter("password");
		nlpassword = req.getParameter("nlpassword");
		hoTen = req.getParameter("hoTen");
		gmail = req.getParameter("gmail");
		phone = req.getParameter("phone");
		Member member;
		if (!password.equals(nlpassword)) {
			req.setAttribute("err", 2);
			this.doGet(req, resp);
		} else {
			member = memberService.getById(id);
			member.setUsername(username);
			member.setPasswrod(password);
			member.setHoTen(hoTen);
			member.setPhone(phone);
			member.setGmail(gmail);
			memberService.edit(member);
			req.setAttribute("err", 0);
			resp.sendRedirect(req.getContextPath()+"/admin/member/list");
		}
	}
}

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

@WebServlet(urlPatterns = "/admin/member/add")
public class AddMemberControl extends HttpServlet {
	private MemberService memberService = new MemberServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/view/admin/addMember.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username, password, nlpassword, hoTen, gmail, phone;
		username = req.getParameter("username");
		password = req.getParameter("password");
		nlpassword = req.getParameter("nlpassword");
		hoTen = req.getParameter("hoTen");
		gmail = req.getParameter("gmail");
		phone = req.getParameter("phone");

		Member member = memberService.getByUsername(username);
		if (member != null) {
			req.setAttribute("err", 1);
			this.doGet(req, resp);
		} else if (!password.equals(nlpassword)) {
			req.setAttribute("err", 2);
			this.doGet(req, resp);
		} else {
			member = new Member(username, password, hoTen, gmail, phone);
			memberService.add(member);
			req.setAttribute("err", 0);
			this.doGet(req, resp);
		}
	}
}

package laptrinhweb.controller.shop;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laptrinhweb.model.Member;
import laptrinhweb.service.MemberService;
import laptrinhweb.service.impl.MemberServiceImpl;

@WebServlet(urlPatterns = "/dang-ky")
public class DangKyControl extends HttpServlet {
	private MemberService memberService = new MemberServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/shop/dangky.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String nlpassword = req.getParameter("nlpassword");
		String name = req.getParameter("name");
		String gmail = req.getParameter("gmail");
		String phone = req.getParameter("phone");
		if(memberService.getByUsername(username)==null){
			if(password.equals(nlpassword)){
				Member member = new Member(username, password, name, gmail, phone);
				memberService.add(member);
				req.setAttribute("err", 0);//dang ky thanh cong
				this.doGet(req, resp);
			}else{
				req.setAttribute("err", 1);//nhap sai mk
				this.doGet(req, resp);
			}
		}else{
			req.setAttribute("err", 2);//trung ten dang nhap
			this.doGet(req, resp);
		}
		
	}
}

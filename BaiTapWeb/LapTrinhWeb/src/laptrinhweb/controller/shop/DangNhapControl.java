package laptrinhweb.controller.shop;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import laptrinhweb.model.Member;
import laptrinhweb.service.MemberService;
import laptrinhweb.service.impl.MemberServiceImpl;

@WebServlet(urlPatterns = "/dang-nhap")
public class DangNhapControl extends HttpServlet {
	private MemberService memberS = new MemberServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/shop/login.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if(memberS.checkLogin(username, password)){
			Member member = memberS.getByUsername(username);
			HttpSession session = req.getSession();
			System.out.println(member.getRole());
			System.out.println(member.getHoTen());
			session.setAttribute("member", member);
			if(member.getRole()==1){
				resp.sendRedirect(req.getContextPath()+"/admin/home");
			}else if(member.getRole()==0){
				resp.sendRedirect(req.getContextPath()+"/home-shop");
			}
		}else{
			req.setAttribute("err", 1);//nhap sai username hoac password
			this.doGet(req, resp);
		}
		
	}
}

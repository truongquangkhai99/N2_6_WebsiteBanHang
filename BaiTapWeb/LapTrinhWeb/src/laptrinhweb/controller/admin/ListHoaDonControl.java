package laptrinhweb.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laptrinhweb.service.OrderService;
import laptrinhweb.service.impl.OrderServiceImpl;
@WebServlet(urlPatterns="/admin/hoa-don/list")
public class ListHoaDonControl extends HttpServlet{
	private OrderService orderService = new OrderServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("list", orderService.getAll());
		req.getRequestDispatcher("/view/admin/listHoaDon.jsp").forward(req, resp);
	}
}

package laptrinhweb.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laptrinhweb.model.CartItem;
import laptrinhweb.model.Order;
import laptrinhweb.service.OrderService;
import laptrinhweb.service.impl.OrderServiceImpl;
@WebServlet(urlPatterns="/admin/hoa-don/chi-tiet")
public class ChiTietHoaDonControl extends HttpServlet{
	private OrderService orderService = new OrderServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double tong = 0;
		for(CartItem cartItem: orderService.getById(Integer.parseInt(req.getParameter("id"))).getListCartItem()){
			tong+= cartItem.getQuantity()*cartItem.getProduct().getChiTietSP().getGia();
		}
		int t = (int) tong;
		req.setAttribute("order", orderService.getById(Integer.parseInt(req.getParameter("id"))));
		req.setAttribute("tong", t);
		req.getRequestDispatcher("/view/admin/chiTietHoaDon.jsp").forward(req, resp);
	}
}

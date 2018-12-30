package laptrinhweb.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laptrinhweb.dao.impl.OrderDAOImpl;
@WebServlet(urlPatterns="/admin/thong-ke/so-luong-hoa-don")
public class ThongKeSoLuongHoDon extends HttpServlet{
	private OrderDAOImpl orderDAO = new OrderDAOImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("t1", orderDAO.getByDate(1));
		req.setAttribute("t2", orderDAO.getByDate(2));
		req.setAttribute("t3", orderDAO.getByDate(3));
		req.setAttribute("t4", orderDAO.getByDate(4));
		req.setAttribute("t5", orderDAO.getByDate(5));
		req.setAttribute("t6", orderDAO.getByDate(6));
		req.setAttribute("t7", orderDAO.getByDate(7));
		req.setAttribute("t8", orderDAO.getByDate(8));
		req.setAttribute("t9", orderDAO.getByDate(9));
		req.setAttribute("t10", orderDAO.getByDate(10));
		req.setAttribute("t11", orderDAO.getByDate(11));
		req.setAttribute("t12", orderDAO.getByDate(12));
		req.getRequestDispatcher("/view/admin/thongKeHoaDon.jsp").forward(req, resp);
	}
}

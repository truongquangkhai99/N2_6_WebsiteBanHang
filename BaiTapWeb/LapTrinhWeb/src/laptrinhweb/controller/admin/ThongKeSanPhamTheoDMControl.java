package laptrinhweb.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laptrinhweb.dao.impl.ProductDAOImpl;
@WebServlet(urlPatterns="/admin/thong-ke/danh-muc-sp")
public class ThongKeSanPhamTheoDMControl extends HttpServlet{
	private ProductDAOImpl productDAO = new ProductDAOImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("SM", productDAO.getByDanhMuc(1).size());
		req.setAttribute("TL", productDAO.getByDanhMuc(2).size());
		req.setAttribute("LT", productDAO.getByDanhMuc(3).size());
		req.setAttribute("PK", productDAO.getByDanhMuc(4).size());
		req.getRequestDispatcher("/view/admin/thongKeSanPhamTheoDM.jsp").forward(req, resp);
	}
}

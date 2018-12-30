package laptrinhweb.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laptrinhweb.dao.ProductDAO;
import laptrinhweb.dao.impl.ProductDAOImpl;
@WebServlet(urlPatterns="/admin/product/laptop")
public class ListLaptopControl extends HttpServlet{
	private ProductDAO productDAO = new ProductDAOImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("list", productDAO.getByDanhMuc(3));
		req.getRequestDispatcher("/view/admin/listLaptop.jsp").forward(req, resp);
	}
}

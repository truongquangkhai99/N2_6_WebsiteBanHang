	package laptrinhweb.controller.shop;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laptrinhweb.service.ProductService;
import laptrinhweb.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns ="/home-shop")
public class HomeshopControl extends HttpServlet {
	private ProductService productS = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/shop/homeshop.jsp");
		req.setAttribute("listSM", productS.getByDanhMuc(1));
		req.setAttribute("listT", productS.getByDanhMuc(2));
		req.setAttribute("listLT", productS.getByDanhMuc(3));
		req.setAttribute("listPK", productS.getByDanhMuc(4));
		requestDispatcher.forward(req, resp);
	}
}

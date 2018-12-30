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

@WebServlet(urlPatterns = "/chi-tiet")
public class ChiTietControl extends HttpServlet {
	ProductService productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("pro", productService.getById(Integer.parseInt(req.getParameter("id"))));
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/shop/chitiet.jsp");
		requestDispatcher.forward(req, resp);
	}
}

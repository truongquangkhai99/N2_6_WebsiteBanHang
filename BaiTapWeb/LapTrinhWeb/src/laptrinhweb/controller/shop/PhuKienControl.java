package laptrinhweb.controller.shop;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import laptrinhweb.model.Product;
import laptrinhweb.service.ProductService;
import laptrinhweb.service.impl.ProductServiceImpl;
@WebServlet(urlPatterns="/phukien")
public class PhuKienControl extends HttpServlet{
	ProductService productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> list = productService.getByDanhMuc(4);
		Gson gson = new Gson();
		req.setAttribute("list", gson.toJson(list));
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/shop/phukien.jsp");
		requestDispatcher.forward(req, resp);
	}
}

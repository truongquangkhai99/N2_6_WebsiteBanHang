package laptrinhweb.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laptrinhweb.model.Product;
import laptrinhweb.service.ProductService;
import laptrinhweb.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = "/admin/product/smartphone")
public class ListSmartphoneControl extends HttpServlet {
	private ProductService prductServices = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("list", prductServices.getByDanhMuc(1));
		req.getRequestDispatcher("/view/admin/listSmartphone.jsp").forward(req, resp);
	}
}

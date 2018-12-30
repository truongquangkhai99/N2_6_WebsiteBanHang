package laptrinhweb.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laptrinhweb.service.ProductService;
import laptrinhweb.service.impl.ProductServiceImpl;
@WebServlet(urlPatterns="/admin/product/delete")
public class DeleteProductControl extends HttpServlet{
	private ProductService prductServices = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		prductServices.delete(Integer.parseInt(req.getParameter("id")));
		resp.sendRedirect(req.getContextPath()+"/admin/product/list");
	}
}

package laptrinhweb.controller.shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import laptrinhweb.dao.ProductDAO;
import laptrinhweb.dao.impl.ProductDAOImpl;
import laptrinhweb.model.CartItem;
import laptrinhweb.model.Product;

@WebServlet(urlPatterns="/add-cart")
public class AddToCartControl extends HttpServlet {
	private ProductDAO productDao = new ProductDAOImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idProduct = req.getParameter("idP");
		Product product = productDao.getById(Integer.parseInt(idProduct));
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("carts");
		if (obj == null) {
			CartItem cartItem = new CartItem();
			cartItem.setProduct(productDao.getById(Integer.parseInt(idProduct)));
			cartItem.setQuantity(1);
			List<CartItem> carts = new ArrayList<CartItem>();
			carts.add(cartItem);
			int soLuong = 0;
			for(CartItem item : carts){
				soLuong += item.getQuantity();
			}
			session.setAttribute("soLuong", soLuong);
			session.setAttribute("carts", carts);
		} else {
			List<CartItem> carts = (List<CartItem>) obj;
			// kiem tra xem product xem da co trong cart chua, neu co thi tang so luong,
			// chua co thi tao moi cartItem.
			boolean checkProduct = true;// gia su chua co product
			for (CartItem cartItem : carts) {
				if (cartItem.getProduct().getIdP() == Integer.parseInt(idProduct)) {
					cartItem.setQuantity(cartItem.getQuantity() + 1);
					checkProduct = false;// da co product trong carts
					break;
				}
			}
			if (checkProduct) {
				CartItem cartItem = new CartItem();
				cartItem.setProduct(productDao.getById(Integer.parseInt(idProduct)));
				cartItem.setQuantity(1);
				carts.add(cartItem);
			}
			int soLuong = 0;
			for(CartItem cartItem : carts){
				soLuong += cartItem.getQuantity();
			}
			session.setAttribute("carts", carts);
			session.setAttribute("soLuong", soLuong);
//			PrintWriter out = resp.getWriter();
//			Gson gson = new Gson();
//			out.println(gson.toJson(carts.size()));
//			out.flush();
//			out.close();
		}
		resp.sendRedirect(req.getContextPath() + "/gio-hang");
	}
}

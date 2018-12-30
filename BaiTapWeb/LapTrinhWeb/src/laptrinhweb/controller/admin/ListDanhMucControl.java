package laptrinhweb.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laptrinhweb.dao.DanhMucDAO;
import laptrinhweb.dao.impl.DanhMucDAOImpl;
@WebServlet(urlPatterns="/admin/danhmuc/list")
public class ListDanhMucControl extends HttpServlet{
	private DanhMucDAO danhMucDAO = new DanhMucDAOImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("list", danhMucDAO.getAll());
		req.getRequestDispatcher("/view/admin/listDanhMuc.jsp").forward(req, resp);
		
	}
}

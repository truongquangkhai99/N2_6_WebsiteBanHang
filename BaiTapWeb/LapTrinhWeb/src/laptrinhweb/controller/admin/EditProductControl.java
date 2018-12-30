package laptrinhweb.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import laptrinhweb.dao.DanhMucDAO;
import laptrinhweb.dao.impl.DanhMucDAOImpl;
import laptrinhweb.model.ChiTietSP;
import laptrinhweb.model.Member;
import laptrinhweb.model.Product;
import laptrinhweb.service.ProductService;
import laptrinhweb.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = "/admin/product/edit")
public class EditProductControl extends HttpServlet {
	private ProductService prductServices = new ProductServiceImpl();
	private DanhMucDAO danhMucDAO = new DanhMucDAOImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = prductServices.getById(Integer.valueOf(req.getParameter("id")));
		req.setAttribute("pro", product);
		req.getRequestDispatcher("/view/admin/editProduct.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ChiTietSP chiTietSP = new ChiTietSP();
		Product product = new Product();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		diskFileItemFactory
				.setRepository(new File("C:\\Users\\LuongChinh\\eclipse-workspace\\LapTrinhWeb\\WebContent\\META-INF"));

		ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
		try {
			List<FileItem> fileItems = fileUpload.parseRequest(req);
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {
					if (fileItem.getFieldName().equals("newImg")) {
						if (!fileItem.getName().equals(product.getImg()) && fileItem.getName().length() != 0) {
							File file = new File(
									"C:\\Users\\LuongChinh\\eclipse-workspace\\LapTrinhWeb\\WebContent\\static\\images\\"
											+ fileItem.getName());
							fileItem.write(file);

							product.setImg(fileItem.getName());
						}
					}
				} else {
					if (fileItem.getFieldName().equals("idP")) {
						product = prductServices.getById(Integer.parseInt(fileItem.getString()));
					}
					if (fileItem.getFieldName().equals("nameProduct")) {
						product.setTenP(fileItem.getString());
					}
					if (fileItem.getFieldName().equals("gia")) {
						chiTietSP.setGia(Integer.parseInt(fileItem.getString()));
					}
					if (fileItem.getFieldName().equals("hang")) {
						chiTietSP.setHangSX(fileItem.getString());
					}
					if (fileItem.getFieldName().equals("mau")) {
						chiTietSP.setMau(fileItem.getString());
					}
					if (fileItem.getFieldName().equals("nam")) {
						chiTietSP.setNamSX(Integer.parseInt(fileItem.getString()));
					}
					if (fileItem.getFieldName().equals("danhMuc")) {
						product.setDanhMuc(danhMucDAO.getById(Integer.parseInt(fileItem.getString())));
					}
					product.setChiTietSP(chiTietSP);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		prductServices.edit(product);
		if (product.getDanhMuc().getId() == 1) {
			resp.sendRedirect(req.getContextPath() + "/admin/product/smartphone");
		} else if (product.getDanhMuc().getId() == 2) {
			resp.sendRedirect(req.getContextPath() + "/admin/product/tablet");
		} else if (product.getDanhMuc().getId() == 3) {
			resp.sendRedirect(req.getContextPath() + "/admin/product/laptop");
		} else if (product.getDanhMuc().getId() == 4) {
			resp.sendRedirect(req.getContextPath() + "/admin/product/phukien");
		}
	}
}

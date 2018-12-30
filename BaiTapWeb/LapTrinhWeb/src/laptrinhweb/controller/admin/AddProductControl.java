package laptrinhweb.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

import laptrinhweb.dao.impl.DanhMucDAOImpl;
import laptrinhweb.model.ChiTietSP;
import laptrinhweb.model.DanhMuc;
import laptrinhweb.model.Product;
import laptrinhweb.service.ProductService;
import laptrinhweb.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = "/admin/product/add")
public class AddProductControl extends HttpServlet {
	private ProductService prductServices = new ProductServiceImpl();
	private DanhMucDAOImpl danhMucDao = new DanhMucDAOImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/view/admin/addProduct.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = new Product();
		ChiTietSP chiTietSP = new ChiTietSP();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		diskFileItemFactory
				.setRepository(new File("C:\\Users\\LuongChinh\\eclipse-workspace\\LapTrinhWeb\\WebContent\\META-INF"));

		ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
		try {
			List<FileItem> fileItems = fileUpload.parseRequest(req);
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {
					if (fileItem.getFieldName().equals("img")) {
						File file = new File(
								"C:\\Users\\LuongChinh\\eclipse-workspace\\LapTrinhWeb\\WebContent\\static\\images\\"
										+ fileItem.getName());
						fileItem.write(file);
						product.setImg(fileItem.getName());
					}
				} else {
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
						product.setDanhMuc(danhMucDao.getById(Integer.parseInt(fileItem.getString())));
					}
					product.setChiTietSP(chiTietSP);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		prductServices.add(product);
		resp.sendRedirect(req.getContextPath() + "/admin/product/list");
	}
}

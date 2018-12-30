package laptrinhweb.service.impl;

import java.util.List;

import laptrinhweb.dao.BinhLuanDAO;
import laptrinhweb.dao.ProductDAO;
import laptrinhweb.dao.impl.BinhLuanDAOImpl;
import laptrinhweb.dao.impl.ProductDAOImpl;
import laptrinhweb.model.Product;
import laptrinhweb.service.ProductService;

public class ProductServiceImpl implements ProductService{
	private ProductDAO productDAO = new ProductDAOImpl();	
	private BinhLuanDAO binhLuanDAO = new BinhLuanDAOImpl();
	
	@Override
	public void add(Product product) {
		productDAO.add(product);
	}

	@Override
	public void edit(Product product) {
		productDAO.edit(product);
	}

	@Override
	public void delete(int idP) {
		productDAO.delete(idP);
	}

	@Override
	public Product getById(int idP) {
		Product product = productDAO.getById(idP);
		product.setDsBinhLuan(binhLuanDAO.getByIdProduct(idP));
		return product;
	}

	@Override
	public List<Product> getAll() {
		List<Product> list = productDAO.getAll();
		for(Product product : list){
			product.setDsBinhLuan(binhLuanDAO.getByIdProduct(product.getIdP()));
		}
		return list;
	}

	@Override
	public List<Product> getByDanhMuc(int idDM) {
		return productDAO.getByDanhMuc(idDM);
	}

}

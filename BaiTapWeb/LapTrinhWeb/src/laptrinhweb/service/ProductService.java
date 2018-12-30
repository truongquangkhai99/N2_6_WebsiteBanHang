package laptrinhweb.service;

import java.util.List;

import laptrinhweb.model.Product;

public interface ProductService {
	
	void add(Product product);

	void edit(Product product);

	void delete(int idP);

	Product getById(int idP);

	List<Product> getByDanhMuc(int idDM);
	
	List<Product> getAll();
}

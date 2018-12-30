package laptrinhweb.dao;

import java.util.List;

import laptrinhweb.model.Product;

public interface ProductDAO {
	void add(Product product);

	void edit(Product product);

	void delete(int idP);

	Product getById(int idP);

	List<Product> getAll();

	List<Product> getByDanhMuc(int idDm);
}

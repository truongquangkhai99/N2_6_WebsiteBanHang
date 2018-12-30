package laptrinhweb.dao;

import java.util.List;

import laptrinhweb.model.Order;

public interface OrderDAO {
	void add(Order order);

	void edit(Order order);

	void delete(int idOrder);

	Order getById(int idOrder);
	
	List<Order> getByIdMember(int idMember);

	List<Order> getAll();
	
	int getByDate(int x);
}

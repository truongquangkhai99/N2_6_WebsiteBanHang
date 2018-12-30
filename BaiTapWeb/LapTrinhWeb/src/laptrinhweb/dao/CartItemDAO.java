package laptrinhweb.dao;

import java.util.List;

import laptrinhweb.model.CartItem;

public interface CartItemDAO {
	void add(CartItem cartItem);

	void edit(CartItem cartItem);

	void delete(int idCartItem);

	void deleteByIdOrder(int idOrder);

	CartItem getById(int idCartItem);

	List<CartItem> getByIdOrder(int idOrder);

	List<CartItem> getAll();
}

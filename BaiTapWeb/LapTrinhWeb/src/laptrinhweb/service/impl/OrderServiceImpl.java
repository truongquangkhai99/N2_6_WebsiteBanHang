package laptrinhweb.service.impl;

import java.util.List;

import laptrinhweb.dao.impl.CartItemDAOImpl;
import laptrinhweb.dao.impl.MemberDAOImpl;
import laptrinhweb.dao.impl.OrderDAOImpl;
import laptrinhweb.dao.impl.ProductDAOImpl;
import laptrinhweb.model.CartItem;
import laptrinhweb.model.Order;
import laptrinhweb.service.OrderService;

public class OrderServiceImpl implements OrderService{
	private ProductDAOImpl productDAO = new ProductDAOImpl();
	private CartItemDAOImpl cartItemDAO = new CartItemDAOImpl();
	private OrderDAOImpl orderDAO = new OrderDAOImpl();
	private MemberDAOImpl memberDAO = new MemberDAOImpl();
	@Override
	public void add(Order order) {
		orderDAO.add(order);
		System.out.println(order.getIdOrder());
		for (CartItem cartItem : order.getListCartItem()) {
			cartItem.setOrder(order);
			cartItemDAO.add(cartItem);
		}
	}

	@Override
	public void edit(Order order) {
		orderDAO.edit(order);
		cartItemDAO.deleteByIdOrder(order.getIdOrder());
		for(CartItem cartItem : order.getListCartItem()){
			cartItem.setOrder(order);
			cartItemDAO.add(cartItem);
		}
	}

	@Override
	public void delete(int idOrder) {
		cartItemDAO.deleteByIdOrder(idOrder);
		orderDAO.delete(idOrder);
	}

	@Override
	public Order getById(int idOrder) {
		Order order = orderDAO.getById(idOrder);
		order.setMember(memberDAO.getById(order.getMember().getId()));
		order.setListCartItem(cartItemDAO.getByIdOrder(idOrder));
		return order;
	}

	@Override
	public List<Order> getAll() {
		List<Order> list = orderDAO.getAll();
		for(Order order: list){
			order.setMember(memberDAO.getById(order.getMember().getId()));
			order.setListCartItem(cartItemDAO.getByIdOrder(order.getIdOrder()));
		}
		return list;
	}

}

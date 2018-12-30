package laptrinhweb.model;

import java.util.Date;
import java.util.List;

public class Order {
	private int idOrder;
	private Member member;
	private String date;
	private List<CartItem> listCartItem;

	public int getIdOrder() {
		return idOrder;
	}
	
	
	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	

	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public List<CartItem> getListCartItem() {
		return listCartItem;
	}

	public void setListCartItem(List<CartItem> listCartItem) {
		this.listCartItem = listCartItem;
	}

}

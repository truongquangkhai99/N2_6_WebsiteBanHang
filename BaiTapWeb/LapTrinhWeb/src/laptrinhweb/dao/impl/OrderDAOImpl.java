package laptrinhweb.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import laptrinhweb.dao.OrderDAO;
import laptrinhweb.model.Member;
import laptrinhweb.model.Order;

public class OrderDAOImpl extends RootDAO implements OrderDAO{
	private PreparedStatement ppst;
	private ResultSet rs;
	@Override
	public void add(Order order) {
		String sql = "INSERT INTO `order` (`idMember`, `dateMua`) VALUES(?,?);";
		try {
			ppst = getJDBCConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ppst.setInt(1, order.getMember().getId());
			ppst.setDate(2, new Date(format.parse(order.getDate()).getTime()));
			ppst.executeUpdate();
			rs = ppst.getGeneratedKeys();
			while(rs.next()){
				order.setIdOrder(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
			
	}

	@Override
	public void edit(Order order) {
		String sql ="UPDATE `order` SET `idMember` = ?, `dateMua` =? WHERE `idOrder` = ?;";
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			ppst.setInt(1, order.getMember().getId());
			java.util.Date date = format.parse(order.getDate());
			ppst.setDate(2, new Date(date.getTime()));
			ppst.setInt(3, order.getIdOrder());
			ppst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int idOrder) {
		String sql = "DELETE FROM `order` WHERE idOrder = ?;";
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			ppst.setInt(1, idOrder);
			ppst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Order getById(int idOrder) {
		String sql = "SELECT * FROM `order` WHERE idOrder = ?;";
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			ppst.setInt(1, idOrder);
			rs = ppst.executeQuery();
			while(rs.next()){
				Order order = new Order();
				order.setIdOrder(idOrder);
				Member member = new Member();
				member.setId(rs.getInt("idMember"));
				order.setMember(member);
				order.setDate(format.format(rs.getDate("dateMua")));
				return order;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Order> getByIdMember(int idMember) {
		List<Order> list = new ArrayList<>();
		String sql = "SELECT * FROM `order` WHERE idMember = ?;";
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			ppst.setInt(1, idMember);
			rs = ppst.executeQuery();
			while(rs.next()){
				Order order = new Order();
				order.setIdOrder(rs.getInt("idOrder"));
				Member member = new Member();
				member.setId(rs.getInt("idMember"));
				order.setMember(member);
				order.setDate(format.format(rs.getDate("dateMua")));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Order> getAll() {
		List<Order> list = new ArrayList<>();
		String sql = "SELECT * FROM `order`;";
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			rs = ppst.executeQuery();
			while(rs.next()){
				Order order = new Order();
				order.setIdOrder(rs.getInt("idOrder"));
				Member member = new Member();
				member.setId(rs.getInt("idMember"));
				order.setMember(member);
				order.setDate(format.format(rs.getDate("dateMua")));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public int getByDate(int x) {
		String sql = "SELECT COUNT(*) AS count FROM `order` WHERE  dateMua BETWEEN ? AND ?;";
		int giaTri = 0;
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			ppst.setString(1, "2018-"+x+"-1");
			if(x==12){
				ppst.setString(2, "2018-"+x+"-31");
			}else{
				x = x+1;
				ppst.setString(2, "2018-"+x+"-1");
			}
			rs = ppst.executeQuery();
			while(rs.next()){
				giaTri = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return giaTri;
	}
}

package laptrinhweb.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import laptrinhweb.dao.MemberDAO;
import laptrinhweb.model.Member;

public class MemberDAOImpl extends RootDAO implements MemberDAO{
	private PreparedStatement ppst;
	private ResultSet rs;
	@Override
	public void add(Member member) {
		String sql = "INSERT INTO member(username, password, hoTen, gmail, phone, role) VALUES(?,?,?,?,?,?);";
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			ppst.setString(1, member.getUsername());
			ppst.setString(2, member.getPasswrod());
			ppst.setString(3, member.getHoTen());
			ppst.setString(4, member.getGmail());
			ppst.setString(5, member.getPhone());
			ppst.setInt(6, member.getRole());
			ppst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Member member) {
		String sql = "UPDATE member SET username = ?, password = ?, hoTen = ?, gmail = ?, phone = ?, role =? WHERE idM = ?;";
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			ppst.setString(1, member.getUsername());
			ppst.setString(2, member.getPasswrod());
			ppst.setString(3, member.getHoTen());
			ppst.setString(4, member.getGmail());
			ppst.setString(5, member.getPhone());
			ppst.setInt(6, member.getRole());
			ppst.setInt(7, member.getId());
			ppst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int idM) {
		String sql = "DELETE FROM member WHERE idM = ?";
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			ppst.setInt(1, idM);
			ppst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Member getById(int idM) {
		String sql = "SELECT * FROM member WHERE idM = ?";
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			ppst.setInt(1, idM);
			rs = ppst.executeQuery();
			while(rs.next()){
				Member member = new Member();
				member.setId(rs.getInt("idM"));
				member.setUsername(rs.getString("username"));
				member.setPasswrod(rs.getString("password"));
				member.setHoTen(rs.getString("hoTen"));
				member.setGmail(rs.getString("gmail"));
				member.setPhone(rs.getString("phone"));
				member.setRole(rs.getInt("role"));
				return member;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Member> getAll() {
		List<Member> list = new ArrayList<Member>();
		String sql = "SELECT * FROM member;";
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			rs = ppst.executeQuery();
			while(rs.next()){
				Member member = new Member();
				member.setId(rs.getInt("idM"));
				member.setUsername(rs.getString("username"));
				member.setPasswrod(rs.getString("password"));
				member.setHoTen(rs.getString("hoTen"));
				member.setGmail(rs.getString("gmail"));
				member.setPhone(rs.getString("phone"));
				member.setRole(rs.getInt("role"));
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
}

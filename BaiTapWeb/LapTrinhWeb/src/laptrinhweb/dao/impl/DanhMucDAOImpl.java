package laptrinhweb.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import laptrinhweb.dao.DanhMucDAO;
import laptrinhweb.model.DanhMuc;

public class DanhMucDAOImpl extends RootDAO implements DanhMucDAO {
	private PreparedStatement ppst;
	private ResultSet rs;
	@Override
	public void add(DanhMuc danhMuc) {
		String sql = "INSERT INTO danhmuc(tenDM) VALUES(?);";
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			ppst.setString(1, danhMuc.getTenDanhMuc());
			ppst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(DanhMuc danhMuc) {
		String sql = "UPDATE danhmuc SET tenDM = ? WHERE idDM = ?;";
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			ppst.setString(1, danhMuc.getTenDanhMuc());
			ppst.setInt(2, danhMuc.getId());
			ppst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int idDm) {
		String sql = "DELETE FROM danhmuc WHERE idDM = ?;";
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			ppst.setInt(1, idDm);
			ppst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public DanhMuc getById(int idDm) {
		String sql = "SELECT * FROM danhmuc WHERE idDM =?";
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			ppst.setInt(1, idDm);
			rs= ppst.executeQuery();
			while(rs.next()){
				DanhMuc danhMuc = new DanhMuc();
				danhMuc.setId(rs.getInt("idDM"));
				danhMuc.setTenDanhMuc(rs.getString("tenDM"));
				return danhMuc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<DanhMuc> getAll() {
		String sql = "SELECT * FROM danhmuc;";
		List<DanhMuc> list = new ArrayList<DanhMuc>();
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			rs= ppst.executeQuery();
			while(rs.next()){
				DanhMuc danhMuc = new DanhMuc();
				danhMuc.setId(rs.getInt("idDM"));
				danhMuc.setTenDanhMuc(rs.getString("tenDM"));
				list.add(danhMuc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public DanhMuc getByName(String name) {
		String sql = "SELECT * FROM danhmuc WHERE tenDM LIKE ?";
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			ppst.setString(1, "%"+name+"%");
			rs= ppst.executeQuery();
			while(rs.next()){
				DanhMuc danhMuc = new DanhMuc();
				danhMuc.setId(rs.getInt("idDM"));
				danhMuc.setTenDanhMuc(rs.getString("tenDM"));
				return danhMuc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

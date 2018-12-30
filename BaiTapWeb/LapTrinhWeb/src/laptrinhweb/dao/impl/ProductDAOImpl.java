package laptrinhweb.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import laptrinhweb.dao.ProductDAO;
import laptrinhweb.model.ChiTietSP;
import laptrinhweb.model.Product;

public class ProductDAOImpl extends RootDAO implements ProductDAO {
	private PreparedStatement ppst;
	private ResultSet rs;
	private DanhMucDAOImpl danhMuc = new DanhMucDAOImpl();

	@Override
	public void add(Product product) {
		String sql = "INSERT INTO product(tenP,hang,nam,mau,gia,`like`,img,idDanhMuc) VALUES(?,?,?,?,?,?,?,?);";
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			ppst.setString(1, product.getTenP());
			ppst.setString(2, product.getChiTietSP().getHangSX());
			ppst.setInt(3, product.getChiTietSP().getNamSX());
			ppst.setString(4, product.getChiTietSP().getMau());
			ppst.setInt(5, product.getChiTietSP().getGia());
			ppst.setInt(6, product.getLike());
			ppst.setString(7, product.getImg());
			ppst.setInt(8, product.getDanhMuc().getId());
			ppst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Product product) {
		String sql = "UPDATE product SET tenP = ?, hang = ?, nam = ?, mau = ?, gia = ?, `like` = ?, img = ?, idDanhMuc = ? WHERE idP = ?;";
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			ppst.setString(1, product.getTenP());
			ppst.setString(2, product.getChiTietSP().getHangSX());
			ppst.setInt(3, product.getChiTietSP().getNamSX());
			ppst.setString(4, product.getChiTietSP().getMau());
			ppst.setInt(5, product.getChiTietSP().getGia());
			ppst.setInt(6, product.getLike());
			ppst.setString(7, product.getImg());
			ppst.setInt(8, product.getDanhMuc().getId());
			ppst.setInt(9, product.getIdP());
			ppst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int idP) {
		String sql = "DELETE FROM product WHERE idP = ?;";
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			ppst.setInt(1, idP);
			ppst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Product getById(int idP) {
		String sql = "SELECT * FROM product WHERE idP = ?;";
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			ppst.setInt(1, idP);
			rs = ppst.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				ChiTietSP chiTietSP = new ChiTietSP();
				product.setIdP(idP);
				product.setTenP(rs.getString("tenP"));
				product.setImg(rs.getString("img"));
				chiTietSP.setHangSX(rs.getString("hang"));
				chiTietSP.setNamSX(rs.getInt("nam"));
				chiTietSP.setMau(rs.getString("mau"));
				chiTietSP.setGia(rs.getInt("gia"));
				product.setChiTietSP(chiTietSP);
				product.setLike(rs.getInt("like"));
				product.setDanhMuc(danhMuc.getById(rs.getInt("idDanhMuc")));
				return product;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getAll() {
		List<Product> list = new ArrayList<Product>();
		String sql = "SELECT * FROM product;";
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			rs = ppst.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				ChiTietSP chiTietSP = new ChiTietSP();
				product.setIdP(rs.getInt("idP"));
				product.setTenP(rs.getString("tenP"));
				product.setImg(rs.getString("img"));
				chiTietSP.setHangSX(rs.getString("hang"));
				chiTietSP.setNamSX(rs.getInt("nam"));
				chiTietSP.setMau(rs.getString("mau"));
				chiTietSP.setGia(rs.getInt("gia"));
				product.setChiTietSP(chiTietSP);
				product.setLike(rs.getInt("like"));
				product.setDanhMuc(danhMuc.getById(rs.getInt("idDanhMuc")));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Product> getByDanhMuc(int idDm) {
		List<Product> list = new ArrayList<Product>();
		String sql = "SELECT * FROM product WHERE idDanhMuc = ?;";
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			ppst.setInt(1, idDm);
			rs = ppst.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				ChiTietSP chiTietSP = new ChiTietSP();
				product.setIdP(rs.getInt("idP"));
				product.setTenP(rs.getString("tenP"));
				product.setImg(rs.getString("img"));
				chiTietSP.setHangSX(rs.getString("hang"));
				chiTietSP.setNamSX(rs.getInt("nam"));
				chiTietSP.setMau(rs.getString("mau"));
				chiTietSP.setGia(rs.getInt("gia"));
				product.setChiTietSP(chiTietSP);
				product.setLike(rs.getInt("like"));
				product.setDanhMuc(danhMuc.getById(rs.getInt("idDanhMuc")));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}



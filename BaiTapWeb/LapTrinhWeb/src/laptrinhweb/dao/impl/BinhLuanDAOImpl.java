package laptrinhweb.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import laptrinhweb.dao.BinhLuanDAO;
import laptrinhweb.model.BinhLuanP;

public class BinhLuanDAOImpl extends RootDAO implements BinhLuanDAO {
	private PreparedStatement ppst;
	private ResultSet rs;
	@Override
	public void add(BinhLuanP binhLuanP) {
		String sql = "INSERT INTO binhluan(idM, idP, content) VALUES(?,?,?);";
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			ppst.setInt(1, binhLuanP.getIdMember());
			ppst.setInt(2, binhLuanP.getIdProduct());
			ppst.setString(3, binhLuanP.getContent());
			ppst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(BinhLuanP binhLuanP) {
		String sql = "UPDATE binhluan SET idM = ?, idP = ?, content = ? WHERE idBL = ?;";
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			ppst.setInt(1, binhLuanP.getIdMember());
			ppst.setInt(2, binhLuanP.getIdProduct());
			ppst.setString(3, binhLuanP.getContent());
			ppst.setInt(4, binhLuanP.getId());
			ppst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int idPL) {
		String sql = "DELETE FROM binhluan WHERE idPL = ?;";
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			ppst.setInt(1, idPL);
			ppst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<BinhLuanP> getByIdProduct(int idP) {
		List<BinhLuanP> list = new ArrayList<BinhLuanP>();
		String sql = "SELECT * FROM binhluan WHERE idP = ?;";
		try {
			ppst = getJDBCConnection().prepareStatement(sql);
			ppst.setInt(1, idP);
			rs = ppst.executeQuery();
			while(rs.next()){
				BinhLuanP binhLuanP = new BinhLuanP();
				binhLuanP.setId(rs.getInt("idPL"));
				binhLuanP.setIdMember(rs.getInt("idM"));
				binhLuanP.setIdProduct(rs.getInt("idP"));
				binhLuanP.setContent(rs.getString("content"));
				list.add(binhLuanP);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}

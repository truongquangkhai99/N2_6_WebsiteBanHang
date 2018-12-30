package laptrinhweb.dao;

import java.util.List;

import laptrinhweb.model.BinhLuanP;

public interface BinhLuanDAO {
	void add(BinhLuanP binhLuanP);

	void edit(BinhLuanP binhLuanP);

	void delete(int idPL);

	List<BinhLuanP> getByIdProduct(int idP);

}

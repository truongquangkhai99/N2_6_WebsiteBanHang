package laptrinhweb.service.impl;

import java.util.List;

import laptrinhweb.dao.BinhLuanDAO;
import laptrinhweb.dao.impl.BinhLuanDAOImpl;
import laptrinhweb.model.BinhLuanP;
import laptrinhweb.service.BinhLuanService;

public class BinhLuanServiceImpl implements BinhLuanService{
	private BinhLuanDAO binhLuanDAO = new BinhLuanDAOImpl();
	@Override
	public void add(BinhLuanP binhLuanP) {
		binhLuanDAO.add(binhLuanP);
	}

	@Override
	public void edit(BinhLuanP binhLuanP) {
		binhLuanDAO.edit(binhLuanP);
	}

	@Override
	public void delete(int idPL) {
		binhLuanDAO.delete(idPL);
	}

	@Override
	public List<BinhLuanP> getByIdProduct(int idP) {
		return binhLuanDAO.getByIdProduct(idP);
	}

	


}

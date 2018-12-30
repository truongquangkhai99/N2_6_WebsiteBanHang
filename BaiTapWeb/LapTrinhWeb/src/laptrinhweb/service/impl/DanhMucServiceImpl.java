package laptrinhweb.service.impl;

import java.util.List;

import laptrinhweb.dao.DanhMucDAO;
import laptrinhweb.dao.ProductDAO;
import laptrinhweb.dao.impl.DanhMucDAOImpl;
import laptrinhweb.dao.impl.ProductDAOImpl;
import laptrinhweb.model.DanhMuc;
import laptrinhweb.service.DanhMucService;

public class DanhMucServiceImpl implements DanhMucService{
	private DanhMucDAO danhMucDAO = new DanhMucDAOImpl();
	private ProductDAO productDAO = new ProductDAOImpl();
	@Override
	public void add(DanhMuc danhMuc) {
		danhMucDAO.add(danhMuc);
	}

	@Override
	public void edit(DanhMuc danhMuc) {
		danhMucDAO.edit(danhMuc);
	}

	@Override
	public void delete(int idDm) {
		danhMucDAO.delete(idDm);
	}

	@Override
	public DanhMuc getById(int idDm) {
		DanhMuc danhMuc = danhMucDAO.getById(idDm);
		danhMuc.setDsSanPham(productDAO.getByDanhMuc(idDm));
		return danhMuc;
	}

	@Override
	public DanhMuc getByName(String name) {
		DanhMuc danhMuc = danhMucDAO.getByName(name);
		danhMuc.setDsSanPham(productDAO.getByDanhMuc(danhMuc.getId()));
		return danhMuc;
	}

	@Override
	public List<DanhMuc> getAll() {
		List<DanhMuc> list = danhMucDAO.getAll();
		for(DanhMuc danhMuc: list){
			danhMuc.setDsSanPham(productDAO.getByDanhMuc(danhMuc.getId()));
		}
		return list;
	}

}

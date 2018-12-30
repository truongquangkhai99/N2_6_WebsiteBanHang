package laptrinhweb.service;

import java.util.List;

import laptrinhweb.model.DanhMuc;

public interface DanhMucService {
	void add(DanhMuc danhMuc);

	void edit(DanhMuc danhMuc);

	void delete(int idDm);

	DanhMuc getById(int idDm);

	DanhMuc getByName(String name);

	List<DanhMuc> getAll();
}

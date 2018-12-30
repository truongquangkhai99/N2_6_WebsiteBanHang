package laptrinhweb.model;

import java.util.List;

public class DanhMuc {
	private int id;
	private String tenDanhMuc;
	private List<Product> dsSanPham;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	public List<Product> getDsSanPham() {
		return dsSanPham;
	}

	public void setDsSanPham(List<Product> dsSanPham) {
		this.dsSanPham = dsSanPham;
	}

}

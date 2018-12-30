package laptrinhweb.model;

import java.util.List;

public class Product {
	private int idP;
	private DanhMuc danhMuc;
	private String tenP;
	private String img;
	private ChiTietSP chiTietSP;
	private int like;
	private List<BinhLuanP> dsBinhLuan;

	public int getIdP() {
		return idP;
	}

	public void setIdP(int idP) {
		this.idP = idP;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public DanhMuc getDanhMuc() {
		return danhMuc;
	}

	public void setDanhMuc(DanhMuc danhMuc) {
		this.danhMuc = danhMuc;
	}

	public String getTenP() {
		return tenP;
	}

	public void setTenP(String tenP) {
		this.tenP = tenP;
	}

	public ChiTietSP getChiTietSP() {
		return chiTietSP;
	}

	public void setChiTietSP(ChiTietSP chiTietSP) {
		this.chiTietSP = chiTietSP;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public List<BinhLuanP> getDsBinhLuan() {
		return dsBinhLuan;
	}

	public void setDsBinhLuan(List<BinhLuanP> dsBinhLuan) {
		this.dsBinhLuan = dsBinhLuan;
	}

}

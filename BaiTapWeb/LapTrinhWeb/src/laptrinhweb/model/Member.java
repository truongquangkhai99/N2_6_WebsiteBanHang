package laptrinhweb.model;

public class Member {
	private int id;
	private String username;
	private String passwrod;
	private String hoTen;
	private String gmail;
	private String phone;
	private int role;
	
	public Member() {
	}
	
	public Member(int id, String username, String passwrod, String hoTen, String gmail, String phone, int role) {
		this.id = id;
		this.username = username;
		this.passwrod = passwrod;
		this.hoTen = hoTen;
		this.gmail = gmail;
		this.phone = phone;
		this.role = role;
	}

	public Member(String username, String passwrod, String hoTen, String gmail, String phone) {
		this.username = username;
		this.passwrod = passwrod;
		this.hoTen = hoTen;
		this.gmail = gmail;
		this.phone = phone;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswrod() {
		return passwrod;
	}

	public void setPasswrod(String passwrod) {
		this.passwrod = passwrod;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}

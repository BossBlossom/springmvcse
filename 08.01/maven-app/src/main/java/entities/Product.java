package entities;

public class Product 
{
	private String masp;
	private String tensp;
	private Integer gia;
	private String hinh;
	private String madm;
	public Product() {	
	}
	public Product(String masp)
	{
		this.masp = masp;
	}
	public Product(String masp, String tensp, Integer gia, String hinh, String madm)
	{
		this.masp = masp;
		this.tensp = tensp;
		this.gia = gia;
		this.hinh = hinh;
		this.madm = madm;
	}
	public String getMasp() {
		return this.masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}
	public String getTensp() {
		return this.tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public Integer getGia() {
		return this.gia;
	}
	public void setGia(Integer gia) {
		this.gia = gia;
	}
	public String getHinh() {
		return this.hinh;
	}
	public void setHinh(String hinh) {
		this.hinh = hinh;
	}
	public String getMadm() {
		return madm;
	}
	public void setMadm(String madm) {
		this.madm = madm;
	}
	
}

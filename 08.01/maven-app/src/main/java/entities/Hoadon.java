package entities;

public class Hoadon 
{
	private int mahd;
	private String ngaydh;
	public Hoadon(int mahd)
	{
		this.mahd = mahd;
	}
	public Hoadon(int mahd, String ngaydh)
	{
		this.mahd = mahd;
		this.ngaydh = ngaydh;
	}
	public int getMahd() {
		return this.mahd;
	}
	public void setMahd(int mahd) {
		this.mahd = mahd;
	}
	public String getNgaydh() {
		return this.ngaydh;
	}
	public void setNgaydh(String ngaydh) {
		this.ngaydh = ngaydh;
	}
	
}

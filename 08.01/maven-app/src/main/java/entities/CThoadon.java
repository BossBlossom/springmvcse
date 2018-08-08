package entities;

public class CThoadon 
{
	private int mahd;
	private String masp;
	private int soluong;
	
	public CThoadon() {
	}
	public CThoadon(int mahd, String masp, int soluong)
	{
		this.mahd = mahd;
		this.masp = masp;
		this.soluong = soluong;
	}
	public int getMahd() {
		return this.mahd;
	}
	public void setMahd(int mahd) {
		this.mahd = mahd;
	}
	public String getMasp() {
		return this.masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}
	public int getSoluong() {
		return this.soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
}

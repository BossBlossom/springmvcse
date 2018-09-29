package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import controller.MyConnect;
import entities.Hoadon;

public class HoadonModel 
{
	Hoadon hoadon;
	public HoadonModel(Hoadon hoadon)
	{
		this.hoadon = hoadon;
	}
	public int insertHoadon()
	{
		int kq=0;
		Connection cn = new MyConnect().getcn();
		if(cn==null)
			return 0;
		try
		{
			String sql="insert into hoadon value(null,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, hoadon.getNgaydh());
			kq = ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	public int getNewestIdHoadon()
	{
		Connection cn = new MyConnect().getcn();
		int MaxID=0;
		if(cn==null)
			return 0;
		try
		{
			String sql = "select MAX(MAHD) from hoadon";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				MaxID = rs.getInt(1);
			}
			ps.close();
			cn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return MaxID;
	}
}

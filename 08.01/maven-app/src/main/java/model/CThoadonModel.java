package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import controller.MyConnect;
import entities.CThoadon;

public class CThoadonModel 
{
	CThoadon cthd;
	public CThoadonModel(CThoadon cthd) {
		this.cthd = cthd;
	}
	public int insertCThoadon()
	{
		int kq=0;
		Connection cn = new MyConnect().getcn();
		if(cn==null)
			return 0;
		try
		{
			String sql="insert into cthoadon values(?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, cthd.getMasp());
			ps.setInt(2, cthd.getMahd());
			ps.setInt(3, cthd.getSoluong());
			kq = ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
}

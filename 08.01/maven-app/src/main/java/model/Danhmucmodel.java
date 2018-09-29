package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import controller.MyConnect;
import entities.Danhmuc;

public class Danhmucmodel
{
	Danhmuc dm;

	public Danhmucmodel() {
	}
	public Danhmucmodel(Danhmuc dm) {
		this.dm = dm;
	}
	public ArrayList<Danhmuc> getList()
	{
		ArrayList<Danhmuc> list = new ArrayList<>();
		Connection cn = new MyConnect().getcn();
		if(cn==null)
			return null;
		try
		{
			String sql = "select * from danhmuc";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Danhmuc temp = new Danhmuc(rs.getString(1), rs.getString(2));
				list.add(temp);
			}
			ps.close();
			cn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}

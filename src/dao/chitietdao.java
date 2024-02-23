package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;


import bean.xacnhanbean;

public class chitietdao {
	public int Them (String Mafood, long soluongmua, long MaHoaDon) throws Exception{
		
		//b1 ket noi vao csdl
				ketnoidao kn = new ketnoidao();
				kn.ketnoi();
				
				String sql = "insert into chitiethoadon(mafood, soluongmua,mahoadon,damua) values(?,?,?,?) ";
				
				PreparedStatement cmd = kn.cn.prepareStatement(sql);
			
				cmd.setString(1, Mafood);
				cmd.setLong(2, soluongmua);
				cmd.setLong(3, MaHoaDon);
				cmd.setBoolean(4, false);
				
				int kq=cmd.executeUpdate();

		
				cmd.close();
				kn.cn.close();
				return kq;
	}
	public int CapNhat(long machitietHD) throws Exception{
		//b1 ket noi vao csdl
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		//b2 tao cau lenh sql
		String sql = "update chitiethoadon set damua = 1 where machitiethd = ?";
		//b3 tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		
		cmd.setLong(1, machitietHD);
		
		int kq=cmd.executeUpdate();

		cmd.close();
		kn.cn.close();
		return kq;
	}
	public ArrayList<xacnhanbean> gethoadonchuaxacnhan() throws Exception{
		ArrayList<xacnhanbean> ds= new ArrayList<xacnhanbean>();	
		//b1 ket noi vao csdl
				ketnoidao kn = new ketnoidao();
				kn.ketnoi();
				//b2 tao cau lenh sql
				String sql = "select * from Vxacnhan";
				//b3 tao cau lenh
				PreparedStatement cmd = kn.cn.prepareStatement(sql);
				//b4 thuc hien cau lenh
				ResultSet rs = cmd.executeQuery();
				//b5 duyet rs de luu vao ds
				while(rs.next()) {
					long makh = rs.getLong("makh"); /// chu trong ngoac phai giong vs trong sql
					String hoten=rs.getString("hoten"); 
					String tenfood=rs.getString("tenfood"); 
					long gia=rs.getLong("gia"); 
					Date ngaymua =rs.getDate("ngaymua"); 
					long soluongmua = rs.getLong("soluongmua") ;
					boolean damua =rs.getBoolean("damua");
					long thanhtien = rs.getLong("thanhtien"); 
					long machitiethd = rs.getLong("machitiethd");
					ds.add(new xacnhanbean(makh, hoten, tenfood, gia, ngaymua, soluongmua, damua, thanhtien, machitiethd));
				}

				//b6 Ä‘Ã³ng rs vÃ  ket noi
				rs.close();
				kn.cn.close();
		return ds;
	}
	
}

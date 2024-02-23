package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loaibean;

public class loaidao {
	public ArrayList<loaibean> getloai() throws Exception{
		ArrayList<loaibean> ds = new ArrayList<loaibean>();
		
		//b1 ket noi vao csdl
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		//b2 tao cau lenh sql
		String sql = "select * from loai";
		//b3 tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//b4 thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		//b5 duyet rs de luu vao ds
		while(rs.next()) {
			String maloai = rs.getString("maloai");
			String tenloai = rs.getString("tenloai");
			ds.add(new loaibean(maloai, tenloai));
		}
		//b6 đóng rs và ket noi
		rs.close();
		kn.cn.close();
		return ds;
	}
	public int themloai(String maloai, String tenloai)	throws Exception{
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "Insert into loai(maloai, tenloai) values (?, ?)";
				//b3 tao cau lenh
				PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		cmd.setString(2, tenloai);
		int kq = cmd.executeUpdate();
		cmd.close(); kn.cn.close();
		return kq;
	}
	
	public int Xoa(String maloai) throws Exception{
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "delete from loai where maloai = ?";
				//b3 tao cau lenh
				PreparedStatement cmd = kn.cn.prepareStatement(sql);
				//Truyen 4 tham so vao cau lenh sql
				cmd.setString(1, maloai);
				int kq = cmd.executeUpdate();			
				cmd.close();kn.cn.close();
				return kq;
		
	}
	
	public int CapNhap(String maloai, String tenloaimoi) throws Exception{
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "update loai\r\n" + 
				"set tenloai = ?\r\n" + 
				"where maloai = ?";
			//b3 tao cau lenh
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			//Truyen 4 tham so vao cau lenh sql
			cmd.setString(1, tenloaimoi);
			cmd.setString(2, maloai);
			int kq = cmd.executeUpdate();
			cmd.close();kn.cn.close();
			return kq;
		
	}
}

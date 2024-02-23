package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.foodbean;

public class fooddao {
	public ArrayList<foodbean> getfood() throws Exception{
		ArrayList<foodbean> ds = new ArrayList<foodbean>();
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select * from food";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String mafood = rs.getString("mafood");
			String tenfood = rs.getString("tenfood");
			String chitiet = rs.getString("chitiet");
			long gia = rs.getLong("gia");
			long soluong = rs.getLong("soluong");
			String anh = rs.getString("anh");
			String maloai = rs.getString("maloai");
			ds.add(new foodbean(mafood, tenfood, gia, soluong, anh, maloai, chitiet));
		}

	
		rs.close();
		kn.cn.close();
		return ds;
	}
	public int themfood(String mafood, String tenfood,long soluong, long gia, String maloai, String chitiet, String anh)	throws Exception{
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "insert into food(mafood, tenfood, soluong,gia ,maloai, chitiet, anh) \r\n"
				+ "	values(?,?,?,?,?,?,?)";
				//b3 tao cau lenh
				PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, mafood);
		cmd.setString(2, tenfood);
		cmd.setLong(3, soluong);
		cmd.setLong(4, gia);
		cmd.setString(5, maloai);
		cmd.setString(6, chitiet);
		cmd.setString(7, anh);
		int kq = cmd.executeUpdate();
		cmd.close(); kn.cn.close();
		return kq;
	}
	
	public int Xoafood(String mafood) throws Exception{
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "delete from food where mafood = ?";
				//b3 tao cau lenh
				PreparedStatement cmd = kn.cn.prepareStatement(sql);
				//Truyen 4 tham so vao cau lenh sql
				cmd.setString(1, mafood);
				int kq = cmd.executeUpdate();			
				cmd.close();kn.cn.close();
				return kq;
		
	}
	
	public int CapNhapfood(String mafood, String tenfoodmoi, long soluongmoi, long giamoi, String maloai, String chitietmoi, String anhmoi) throws Exception{
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "update food \r\n"
				+ "set tenfood = ?, soluong =?, gia =?, maloai = ?, chitiet = ?, anh =? \r\n"
				+ "where mafood = ? ";
			//b3 tao cau lenh
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			//Truyen 4 tham so vao cau lenh sql
			cmd.setString(1, tenfoodmoi);
			cmd.setLong(2, giamoi);
			cmd.setLong(3, giamoi);
			cmd.setString(4,maloai);
			cmd.setString(5, chitietmoi);
			cmd.setString(6, anhmoi);
			cmd.setString(7, mafood);
			int kq = cmd.executeUpdate();
			cmd.close();kn.cn.close();
			return kq;
		
	}
}

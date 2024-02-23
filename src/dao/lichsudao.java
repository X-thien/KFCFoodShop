package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.lichsubean;

public class lichsudao {
	public ArrayList<lichsubean> getlichsu() throws Exception{
		ArrayList<lichsubean> ds = new ArrayList<lichsubean>();
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select * from Vhdon";
				//b3 tao cau lenh
				PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// b4 thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		//b5 duyet rs de luu vao ds
		while(rs.next()) {
			String mafood = rs.getString("mafood");
			String tenfood =rs.getString("tenfood");
			long soluongmua = rs.getLong("soluongmua");
			Date ngaymua = rs.getDate("ngaymua");
			long gia = rs.getLong("gia");
			Boolean damua = rs.getBoolean("damua");
			long thanhtien = rs.getLong("thanhtien");
			long makh = rs.getLong("makh");
			ds.add(new lichsubean(mafood, tenfood, soluongmua, ngaymua, gia, damua, thanhtien, makh));
		}
		rs.close(); kn.cn.close();

		return ds;
	}
}

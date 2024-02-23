package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.khachhangbean;

public class khachhangdao {
	public khachhangbean ktdn(String tendn, String pass)
			throws Exception{
				ketnoidao kn = new ketnoidao();
				kn.ketnoi();
				String sql = "Select * from khachhang where tendn = ? and pass = ?";
						//b3 tao cau lenh
						PreparedStatement cmd = kn.cn.prepareStatement(sql);
						cmd.setString(1, tendn);
						cmd.setString(2, pass);
				// b4 thuc hien cau lenh
				ResultSet rs = cmd.executeQuery();
				khachhangbean kh = null;
				if(rs.next()) {
					long makh = rs.getLong("makh");
					String hoten = rs.getString("hoten");
					String diachi = rs.getString("diachi");
					String sodt = rs.getString("sodt");
					String eamail = rs.getString("email");
					String tendn1 = rs.getString("tendn");
					String pass1 = rs.getString("pass");
					kh = new khachhangbean(makh, hoten, diachi, sodt, eamail,tendn1, pass1);
				}
				return kh;
			}
}

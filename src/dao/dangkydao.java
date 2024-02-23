package dao;

import java.sql.PreparedStatement;

public class dangkydao {
	public int themkh(String hoten, String diachi, String sodt, String email, String tendn, String pass)
			throws Exception{
				ketnoidao kn = new ketnoidao();
				kn.ketnoi();
				String sql = "Insert into khachhang (hoten, diachi, sodt, email, tendn, pass) values (?, ?, ?, ?, ?, ?)";
						//b3 tao cau lenh
				PreparedStatement cmd = kn.cn.prepareStatement(sql);
				cmd.setString(1, hoten);
				cmd.setString(2, diachi);
				cmd.setString(3, sodt);
				cmd.setString(4, email);
				cmd.setString(5, tendn);
				cmd.setString(6, pass);
				
				// Doi ngay until sang chuoi theo dinh dang
				
				int kq = cmd.executeUpdate();
				cmd.close(); kn.cn.close();
				return kq;
			}
}

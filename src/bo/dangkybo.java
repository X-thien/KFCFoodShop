package bo;

import dao.dangkydao;

public class dangkybo {
	
	dangkydao khdao = new dangkydao();
	public int themds(String hoten, String diachi, String sodt, String email, String tendn, String pass)
			throws Exception{
			return khdao.themkh(hoten, diachi, sodt, email, tendn, pass);
		}
}

package bo;

import java.util.ArrayList;

import bean.xacnhanbean;
import dao.chitietdao;

public class chitietbo {
	chitietdao ctiet = new chitietdao();
	public int Them (String Mafood, long soluongmua, Long MaHoaDon) throws Exception{
		return ctiet.Them(Mafood, soluongmua, MaHoaDon);
	}
	public int CapNhat(long machitietHD) throws Exception{
		return ctiet.CapNhat(machitietHD);
	}
	public ArrayList<xacnhanbean> gethoadonchuaxacnhan() throws Exception{
		return ctiet.gethoadonchuaxacnhan();
	}
}

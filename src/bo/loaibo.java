package bo;

import java.util.ArrayList;

import bean.loaibean;
import dao.loaidao;

public class loaibo {
	loaidao ldao = new loaidao();
	ArrayList<loaibean> ds;
	public ArrayList<loaibean> getloai() throws Exception{
		ds= ldao.getloai();
		return ds;
	}
	public String tim(String maloai)throws Exception{
		for(loaibean l: ds) {
			if(l.getMaloai().equals(maloai))
				return l.getTenloai();
		}
		return null;
	}
	public int themloai(String maloai, String tenloai)	throws Exception{
		for(loaibean l: ds) {
			if(l.getMaloai().equals(maloai))
				return 0;
		}
		return ldao.themloai(maloai, tenloai);
	}
	
	public int CapNhap(String mafood, String tenfoodmoi) throws Exception{
		return ldao.CapNhap(mafood, tenfoodmoi);
	}
	public int Xoa(String mafood) throws Exception{
		return ldao.Xoa(mafood);
	}
}

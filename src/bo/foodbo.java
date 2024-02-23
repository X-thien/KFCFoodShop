package bo;

import java.util.ArrayList;

import bean.foodbean;
import dao.fooddao;


public class foodbo {
	fooddao fdao = new fooddao();
	ArrayList<foodbean> ds;
	
	public ArrayList<foodbean> getfood() throws Exception {
			ds =  fdao.getfood();
			return ds;
	}
	
	public ArrayList<foodbean> getTimMa(String maloai) throws Exception {
		
		ArrayList<foodbean> result = new ArrayList<foodbean>();
		for (int i = 0; i < ds.size(); i++) {
				if (ds.get(i).getMaloai().equals(maloai)) {
						result.add(ds.get(i));
				}
		}
		return result;
	}

	public ArrayList<foodbean> getTimKey(String key) throws Exception {
 
	ArrayList<foodbean> result = new ArrayList<foodbean>();
	for (int i = 0; i < ds.size(); i++) {
			if (ds.get(i).getTenfood().toLowerCase().trim().contains(key.trim().toLowerCase())) {
					result.add(ds.get(i));
			}
	}
	return result;
	}
	public int themfood(String mafood, String tenfood,long soluong, long gia, String maloai, String chitiet, String anh)	throws Exception{
		for(foodbean l: ds) {
			if(l.getMafood().equals(mafood))
				return 0;
		}
		return fdao.themfood(mafood, tenfood, soluong, gia, maloai, chitiet, anh);
	}
	
	public int CapNhapfood(String mafood, String tenfoodmoi, long soluongmoi, long giamoi, String maloai, String chitietmoi, String anhmoi) throws Exception{
		return fdao.CapNhapfood(mafood, tenfoodmoi, soluongmoi, giamoi, maloai, chitietmoi, anhmoi);
	}
	public int Xoafood(String mafood) throws Exception{
		return fdao.Xoafood(mafood);
	}

	
}

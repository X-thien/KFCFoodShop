package bo;

import java.util.ArrayList;

import bean.giohangbean;


public class giohangbo {
	public ArrayList<giohangbean> ds = new ArrayList<giohangbean>();
	public void ThemHang(String mafood, String tenfood, String chitiet, long gia, long soluongmua) {
		//kiem tra xem hang da co trong ds chua
		//neu co thi tang so luong
		for(giohangbean h: ds)
			if(h.getMafood().equals(mafood)) {
				h.setSoluongmua(h.getSoluongmua()+soluongmua);
				return;
			}
		
		giohangbean h = new giohangbean(mafood, tenfood, chitiet, gia, soluongmua);
		ds.add(h);
	}
	
	//xoa hang ra khoi danh sach
	public void XoaHang(String mafood) {
		for(giohangbean h: ds) {
			if(h.getMafood().equals(mafood)) {
				ds.remove(h);
				return;
			}
		}
	}
	//Sua lai so luon
	public void Sua(String mafood, long soluongmoi) {
		int n = ds.size();
		for(int i=0; i<n; i++) {
			giohangbean h = ds.get(i);
			if(h.getMafood().equals(mafood)) {
				h.setSoluongmua(soluongmoi); // sua so luong
				ds.set(i, h); //luu lai vao ds
				return;
			}
		}
	}
	// tinh tong tien
	public long TongTien() {
		long s = 0;
		for(giohangbean h: ds) {
			s = s + h.getThanhtien();
			
		}
		return s;
	}
}

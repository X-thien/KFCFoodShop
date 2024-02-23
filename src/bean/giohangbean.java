package bean;

public class giohangbean {
	private String mafood;
	private String tenfood;
	private String chitiet;

	private long gia;
	private long soluongmua;
	private long thanhtien;
	public giohangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public giohangbean(String mafood, String tenfood, String chitiet, long gia, long soluongmua) {
		super();
		this.mafood = mafood;
		this.tenfood = tenfood;
		this.chitiet = chitiet;

		this.gia = gia;
		this.soluongmua = soluongmua;
		this.thanhtien = soluongmua * gia;
	}
	public String getMafood() {
		return mafood;
	}
	public void setMafood(String mafood) {
		this.mafood = mafood;
	}
	public String getTenfood() {
		return tenfood;
	}
	public void setTenfood(String tenfood) {
		this.tenfood = tenfood;
	}
	public String getChitiet() {
		return chitiet;
	}
	public void setChitiet(String chitiet) {
		this.chitiet = chitiet;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(long soluongmua) {
		this.soluongmua = soluongmua;
	}
	public long getThanhtien() {
		return soluongmua*gia;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	
}

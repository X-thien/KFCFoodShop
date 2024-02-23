package bean;

public class foodbean {
	private String mafood;
	private String tenfood;
	private long gia;
	private long soluong;
	private String anh;
	private String maloai;
	private String chitiet;
	public foodbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public foodbean(String mafood, String tenfood, long gia, long soluong, String anh, String maloai, String chitiet) {
		super();
		this.mafood = mafood;
		this.tenfood = tenfood;
		this.gia = gia;
		this.soluong = soluong;
		this.anh = anh;
		this.maloai = maloai;
		this.chitiet = chitiet;
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
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getSoluong() {
		return soluong;
	}
	public void setSoluong(long soluong) {
		this.soluong = soluong;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	public String getChitiet() {
		return chitiet;
	}
	public void setChitiet(String chitiet) {
		this.chitiet = chitiet;
	}
	
}

package bean;

import java.util.Date;

public class lichsubean {
	private String mafood;
	private String tenfood;
	private long soluongmua;
	private Date ngaymua;
	private long gia;
	private Boolean damua;
	private long thanhtien;
	private long makh;
	public lichsubean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public lichsubean(String mafood, String tenfood, long soluongmua, Date ngaymua, long gia, Boolean damua,
			long thanhtien, long makh) {
		super();
		this.mafood = mafood;
		this.tenfood = tenfood;
		this.soluongmua = soluongmua;
		this.ngaymua = ngaymua;
		this.gia = gia;
		this.damua = damua;
		this.thanhtien = thanhtien;
		this.makh = makh;
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
	public long getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(long soluongmua) {
		this.soluongmua = soluongmua;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public Boolean getDamua() {
		return damua;
	}
	public void setDamua(Boolean damua) {
		this.damua = damua;
	}
	public long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public long getMakh() {
		return makh;
	}
	public void setMakh(long makh) {
		this.makh = makh;
	}
	
	
}

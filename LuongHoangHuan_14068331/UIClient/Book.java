package UIClient;

import java.io.Serializable;
import java.util.Comparator;

public class Book implements Serializable {
	private int masach, maloai;
	private String tensach, tacgia, gia;
	
	public Book(int masach, int maloai, String tensach, String tacgia, String gia){
		this.masach = masach;
		this.maloai = maloai;
		this.tensach = tensach;
		this.tacgia = tacgia;
		this.gia = gia;
	}
	public Book() {
		
	}
	
	public int getMasach() {
		return masach;
	}
	public void setMasach(int masach) {
		this.masach = masach;
	}
	public int getMaloai() {
		return maloai;
	}
	public void setMaloai(int maloai) {
		this.maloai = maloai;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public String getTacgia() {
		return tacgia;
	}
	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}
	public String getGia() {
		return gia;
	}
	public void setGia(String gia) {
		this.gia = gia;
	}
	public static Comparator<Book> getBookNameComparator() {
		return BookNameComparator;
	}
	public static void setBookNameComparator(Comparator<Book> bookNameComparator) {
		BookNameComparator = bookNameComparator;
	}
	public String toString() {
		return masach + ", " + maloai + ", " + tensach + ", " + tacgia + "; " + gia;
	}

	public static Comparator<Book> BookNameComparator = new Comparator<Book>() {
		public int compare(Book b1, Book b2) {
			return b1.getTensach().compareTo(b2.getTensach());
		}
	};
}

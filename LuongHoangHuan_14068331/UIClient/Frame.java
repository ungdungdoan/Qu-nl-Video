package UIClient;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

//import db.Sach;

public class Frame extends JFrame{
	private JTable table;
	private DefaultTableModel tableModel;
	private JPanel pn1, pn2, pn3;
	private JLabel lbTimkiem,lbTrangthai;
	private JTextField tfTimkiem;
	private JButton btnTimkiem;
	private JScrollPane scrollpane;
	private List<Book> dulieuTK = new ArrayList<Book>();
	private int loaiTK = 0;
	private String[] header = {"Ma loai", "Ma sach", "Ten sach", "Tac gia", "Gia"};
	
	public Frame(){
		setTitle("Giao dien khach hang");
		setSize(600,500);
		pn1 = new JPanel();
		pn1.setLayout(new GridLayout(1,2));
		
		lbTimkiem = new JLabel("Tim kiem: ");
		tfTimkiem = new JTextField(30);
		
		pn1.add(lbTimkiem);
		pn1.add(tfTimkiem);
		
		this.add(pn1, BorderLayout.NORTH);
		
		lbTrangthai = new JLabel();
		TrangthaiTK(0, "", "");
		pn1.add(lbTrangthai, BorderLayout.EAST);
		
		pn2 = new JPanel();
		pn2.setSize(600,800);
		
		//String[] header = {"Ma loai", "Ma sach", "Ten sach", "Tac gia", "Gia"};
		table = new JTable();
		
		pn2.add(scrollpane = new JScrollPane(table));
		
		scrollpane.setBorder(BorderFactory.createTitledBorder("Danh sach loai sach"));
		this.add(pn2);
		LoadData();
	}
	public void LoadData(){
		Vector header = new Vector();
		header.add("Ma Loai");
		header.add("Ma Sach");
		header.add("Ten Sach");
		header.add("Tac Gia");
		header.add("Gia");
		tableModel = new DefaultTableModel(header, 0);
//		List<Book> list = getBookDB();
//		for(int i=0; i<list.size(); i++){
//			Book book = (Book)list.get(i);
//			Vector row = new Vector();
//			row.add(book.getMaloai());
//			row.add(book.getMasach());
//			row.add(book.getTensach());
//			row.add(book.getTacgia());
//			row.add(book.getGia());
//			tableModel.addRow(row);
//		}
		table.setModel(tableModel);
	}
	public List<Book> getBookDB(){
		List<Book> list = new ArrayList<Book>();
		ConnectDB c = new ConnectDB();
		try {
			c = new ConnectDB();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = c.getConnect();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM Sach");
			while(rs.next()){
				list.add(new Book(rs.getInt("maSach"), rs.getInt("maLoai"), rs.getString("tenSach"),rs.getString("tacGia"),rs.getString("gia")));
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}
	private List<Book> Search(int loaiTK) {
		int size = getBookDB().size();
		dulieuTK.clear();
		String timtxt = tfTimkiem.getText().trim().toLowerCase();
		if (timtxt.length() == 0) {
			TrangthaiTK(0, "", "");
			return this.getBookDB();
		}
		String loaitxt = "";
		for (int i = 0; i < size; i++) {
			Book b = getBookDB().get(i);
			String txt = "";
			if (loaiTK == 0) {
				txt = b.getTensach();
				loaitxt = "cuon sach co ten phu hop voi";
			} else if (loaiTK == 1) {
				txt = b.getTacgia();
				loaitxt = "cuon sach co tac gia phu hop voi";
			}
			txt = txt.trim().toLowerCase();
			if (txt.indexOf(timtxt) >= 0) {
				dulieuTK.add(b);
			}
		}
		TrangthaiTK(dulieuTK.size(), loaiTK + timtxt + "\".", timtxt);
		return dulieuTK;
	}
	public void CapnhatDL() {
		Collections.sort(getBookDB(), Book.BookNameComparator);
		if (dulieuTK.size() > 0) {
			CapnhatBang(Search(loaiTK));
		} else {
			CapnhatBang(this.getBookDB());
		}
	}
	public void CapnhatBang(List<Book> list) {
		tableModel = new DefaultTableModel(header,0);
		for(int i=0; i<list.size(); i++){
			Book book = (Book)list.get(i);
			Vector row = new Vector();
			row.add(book.getMaloai());
			row.add(book.getMasach());
			row.add(book.getTensach());
			row.add(book.getTacgia());
			row.add(book.getGia());
			tableModel.addRow(row);
		}
		table.setModel(tableModel);
	}
	
	public void TrangthaiTK(int dem, String trangthai, String timtxt) {
		if (timtxt.length() == 0) {
			lbTrangthai.setText("Nhap vao thong tin tim kiem !");
		} else if (dem > 0 && timtxt.length() > 0) {
			lbTrangthai.setText("Tim thay" + dem + trangthai);
		} else if (dem == 0 && timtxt.length() > 0) {
			lbTrangthai.setText("Khong tim thay" + trangthai);
		}
	}
}

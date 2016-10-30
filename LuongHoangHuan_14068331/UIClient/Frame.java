package UIClient;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

public class Frame extends JFrame implements ActionListener,KeyListener{
	private JTable table;
	private DefaultTableModel tableModel;
	private JPanel pn1, pn2, pn3;
	private JLabel lbTimkiem,lbTrangthai;
	private JTextField tfTimkiem;
	private JButton btnTimkiem;
	private JScrollPane scrollpane;
	private List<Book> dulieuTK = new ArrayList<Book>();
	private int loaiTK = 0;
	private List<Book> list = getBookDB();
	private String[] header = {"Ma sach", "Ma loai", "Ten sach", "Tac gia", "Gia"};
	private JButton btn;
	private String[] titleItem = header;
	
	public Frame(){
		setTitle("Giao dien khach hang");
		setSize(600,500);
		pn1 = new JPanel();
		pn1.setLayout(new GridLayout(1,2));
		
		lbTimkiem = new JLabel("                      Tim kiem: ");
		tfTimkiem = new JTextField(30);
		tfTimkiem.addKeyListener(this);
		pn1.add(lbTimkiem);
		pn1.add(tfTimkiem);
		
		this.add(pn1, BorderLayout.NORTH);
		
		lbTrangthai = new JLabel();
		pn1.add(lbTrangthai, BorderLayout.EAST);
		pn2 = new JPanel();
		pn2.setSize(600,800);
		
		table = new JTable();
		TrangthaiTK(0, "", "");
		
		pn2.add(scrollpane = new JScrollPane(table));
		
		scrollpane.setBorder(BorderFactory.createTitledBorder("Danh sach loai sach"));
		this.add(pn2);
		CapnhatBang(list);
	}
	
	public void LoadData(){
		Vector header = new Vector();
		header.add("Ma Sach");
		header.add("Ma Loai");
		header.add("Ten Sach");
		header.add("Tac Gia");
		header.add("Gia");
		tableModel = new DefaultTableModel(header, 0);
		
		
		for(int i=0; i<list.size(); i++){
			Book book = (Book)list.get(i);
			Vector row = new Vector();
			row.add(book.getMasach());
			row.add(book.getMaloai());
			row.add(book.getTensach());		
			row.add(book.getTacgia());
			row.add(book.getGia());
			tableModel.addRow(row);
		}
		
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
				list.add(new Book(rs.getInt("maSach"), rs.getInt("maLoai"), rs.getString("tenSach"),rs.getString("tacGia"),rs.getFloat("gia")));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	public List<Book> Search() {
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
			txt = b.getTensach();
			txt = txt.trim().toLowerCase();
			if (txt.indexOf(timtxt) >= 0) {
				dulieuTK.add(b);
			}
		}
		TrangthaiTK(dulieuTK.size(),timtxt + "\".", timtxt);
		return dulieuTK;
	}
	
	public void CapnhatDL() {
		Collections.sort(getBookDB(), Book.BookNameComparator);
		if (Search().size() > 0) {
			CapnhatBang(Search());
		} else {
			CapnhatBang(this.getBookDB());
		}
	}
	
	public void CapnhatBang(List<Book> list) {
		tableModel = new DefaultTableModel(header,0);
		Vector row = new Vector();
		for(int i=0; i<list.size(); i++){
			Book book = (Book)list.get(i);
			row = new Vector();
			row.add(book.getMaloai());
			row.add(book.getMasach());
			row.add(book.getTensach());
			row.add(book.getTacgia());
			row.add(book.getGia());
			tableModel.addRow(row);
		}
		table.setModel(tableModel);
	}
	
	private String[][] convertData(ArrayList<Book> list) {
		int size = list.size();
		String data[][] = new String[size][titleItem.length];
		for (int i = 0; i < size; i++) {
			Book person = list.get(i);
			data[i][0] = person.getMasach()+"";
			data[i][1] = person.getMaloai()+"";
			data[i][2] = person.getTensach();
			data[i][3] = person.getTacgia();
			data[i][3] = person.getGia()+"";
		}
		return data;
	}
	
	private void updateTable(ArrayList<Book> list) {
		String data[][] = convertData(list);
		DefaultTableModel tableModel = new DefaultTableModel(data, titleItem) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(tableModel);
	}
	
	public void TrangthaiTK(int dem, String trangthai, String timtxt) {
		if (timtxt.length() == 0) {
			lbTrangthai.setText("Nhap vao thong tin tim kiem !");
		} else if (dem > 0 && timtxt.length() > 0) {
			lbTrangthai.setText("Tim thay " + dem +" "+ trangthai);
		} else if (dem == 0 && timtxt.length() > 0) {
			lbTrangthai.setText("Khong tim thay " + trangthai);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		CapnhatBang(Search());
		
	}
}

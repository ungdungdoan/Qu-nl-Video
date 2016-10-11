package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.OutputStream;
import java.lang.reflect.Field;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

//import db.Database;
//import db.DbUtils;
//import entity.LopHoc;
//import helper.LopHocHelper;

public class Frm extends JFrame implements ActionListener{
	private JTextField txtMaThe;
	private JTextField txtMaTT;
	private JTextField txtMaKH;
	private JTextField txtMaSach;
	private JTextField txtNgayTra;
	private JTextField txtNgayThue;
	private JTextField txtGiaThue;
	private JTextField txtTim;
	private DefaultTableModel dataModel;
	private JTable table;
	private JButton btnXemDSSV;

	public Frm() {
		setTitle("Danh Sach The Thu Vien");
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Box b, b1, b2, b3, b4, b5, b6, b7, b8;
		add(b = Box.createVerticalBox()); 
		b.add(Box.createVerticalStrut(10)); 
		b.add(b1 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); 
		b.add(b2 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); 
		b.add(b3 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); 
		b.add(b4 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); 
		b.add(b5 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10));
		b.add(b6 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10));
		b.add(b7 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); 
		b.add(b8 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); 

		JLabel lblTieuDe, lblMaThe, lblMaThuThu, lblMaKH,lblMaSach,lblNgayThue,lblNgayTra,lblGiaThue,lblTim;
		b1.add(Box.createHorizontalStrut(400)); 
		b1.add(lblTieuDe = new JLabel("DANH SACH THE THU VIEN",JLabel.CENTER));
		lblTieuDe.setFont(new Font("Arial",Font.BOLD,20));
		JLabel lblViTri; b1.add(Box.createHorizontalStrut(220)); 
		b1.add(lblMaThe = new JLabel("Ma The")); b1.add(txtMaThe = new JTextField());
		JLabel lblBang;
		b2.add(Box.createHorizontalStrut(30)); 
		b2.add(lblMaSach = new JLabel("Ma Sach: ", JLabel.RIGHT)); b2.add(txtMaSach = new JTextField());
		b2.add(Box.createHorizontalStrut(30)); 
		b2.add(lblMaKH = new JLabel("Ma Khach Hang: ", JLabel.RIGHT)); b2.add(txtMaKH = new JTextField());
		b2.add(Box.createHorizontalStrut(30)); 
		b2.add(lblMaThuThu = new JLabel("Ma Thu Thu: ", JLabel.RIGHT)); b2.add(txtMaTT = new JTextField());
		
     	b3.add(Box.createHorizontalStrut(30)); 
		b3.add(lblNgayThue = new JLabel("Ngay Thue: ", JLabel.RIGHT)); b3.add(txtNgayThue = new JTextField());
		b3.add(Box.createHorizontalStrut(30)); 
		b3.add(lblNgayTra = new JLabel("Ngay Tra: ", JLabel.RIGHT)); b3.add(txtNgayTra = new JTextField());
		
		b4.add(lblGiaThue = new JLabel("Gia Thue: ", JLabel.RIGHT)); b4.add(txtGiaThue = new JTextField());
		
		b5.add(lblTim = new JLabel("Tim kiem: ", JLabel.RIGHT)); b5.add(txtTim = new JTextField());
		
		lblNgayThue.setPreferredSize(lblMaKH.getPreferredSize());
		lblNgayTra.setPreferredSize(lblMaKH.getPreferredSize());
		lblMaSach.setPreferredSize(lblMaKH.getPreferredSize());
		lblMaThuThu.setPreferredSize(lblMaKH.getPreferredSize());
		lblGiaThue.setPreferredSize(lblMaKH.getPreferredSize());
			
		b6.add(Box.createHorizontalStrut(70));
		b6.add(Box.createHorizontalStrut(70));

		String[] headers = {"Ma The Thu Vien","Ma Sach", "Ma Thu Thu", "Ma Khach Hang","Ngay Tra","Ngay Thue","Gia Tien"};
		dataModel = new DefaultTableModel(headers , 0);
		JScrollPane scroll;
		b7.add(scroll = new JScrollPane(table = new JTable(dataModel)));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh Sach The Thu Vien"));

		b8.add(Box.createHorizontalStrut(600));
		b8.add(btnXemDSSV = new JButton("Xem The Thu Vien"));
		btnXemDSSV.setForeground(Color.red);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

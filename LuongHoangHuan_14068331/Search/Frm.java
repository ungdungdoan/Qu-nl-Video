package ui;

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
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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

import com.google.gson.Gson;

import Json.Writer;
import db.Database;
import db.DbUtils;
import entity.TheThuVien;
import helper.ThuVienHelper;

public class Frm extends JFrame implements ActionListener{

	private JButton btnDau;
	private JButton btnTruoc;
	private JButton btnSau;
	private JButton btnCuoi;
	private JButton btnThem;
	private JButton btnLuu;
	private JButton btnSua;
	private JButton btnXoa;
	private JLabel lblMauTin;
	private DefaultTableModel dataModel;
	private JTable table;
	private JButton btnTK;
	private ThuVienHelper lopHocHelper;
	private int tongSoMauTin;
	private int mauTinHienHanh;
	private JTextField txtMaSach;
	private JTextField txtMaThe;
	private JTextField txtGiaTien;
	private JTextField txtMaTT;
	private JTextField txtMaKH;
	private JTextField txtNgayTra;
	private JTextField txtNgayThue;
	private JTextField txtTK;
	private JLabel lblTieuDe;
	private JButton btnIn;
	

	
	
	
	public Frm() {
		setTitle("THONG TIN THE THU VIEN");
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Box b, b1, b2, b3, b4, b5, b6, b7;
		add(b = Box.createVerticalBox()); 
		b.add(Box.createVerticalStrut(10)); 
		b.add(b1 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); 
		b.add(b2 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); 
		b.add(b3 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); 
		b.add(b4 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); 
		b.add(b5 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); 
		b.add(b6 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); 
		b.add(b7 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(10)); 

		JLabel  lblMaLop, lblTenLop, lblGVCN;
		b1.add(Box.createHorizontalStrut(320));
		b1.add(lblTieuDe = new JLabel("THONG TIN THE THU VIEN", JLabel.CENTER));
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 26));
		JLabel lblMaSach;
		b1.add(Box.createHorizontalStrut(220)); 
		JLabel lblMaThe;
		b1.add(lblMaThe = new JLabel("Ma The", JLabel.CENTER));
		b1.add(txtMaThe = new JTextField());
		b2.add(lblMaSach = new JLabel("Ma Sach: ", JLabel.RIGHT)); b2.add(txtMaSach = new JTextField());
		JLabel lblGiaTien;
		b2.add(lblGiaTien = new JLabel("Gia Tien: ", JLabel.RIGHT)); b2.add(txtGiaTien = new JTextField());
		JLabel lblMaTT;
		b3.add(lblMaTT = new JLabel("Ma Thu Thu: ", JLabel.RIGHT)); b3.add(txtMaTT = new JTextField());
		JLabel lblMaKH;
		b3.add(lblMaKH = new JLabel("Ma Khach Hang: ", JLabel.RIGHT)); b3.add(txtMaKH = new JTextField());
		JLabel lblNgayThue;
		b4.add(lblNgayThue = new JLabel("Ngay Thue: ", JLabel.RIGHT)); b4.add(txtNgayThue = new JTextField());
		JLabel lblNgayTra;
		b4.add(lblNgayTra = new JLabel("Ngay Tra: ", JLabel.RIGHT)); b4.add(txtNgayTra = new JTextField());

		lblMaSach.setPreferredSize(lblMaKH.getPreferredSize());
		lblNgayThue.setPreferredSize(lblMaKH.getPreferredSize());
		lblNgayTra.setPreferredSize(lblMaKH.getPreferredSize());
		lblMaTT.setPreferredSize(lblMaKH.getPreferredSize());
		lblGiaTien.setPreferredSize(lblMaKH.getPreferredSize());

		b5.add(Box.createHorizontalStrut(70));
		b5.add(btnDau = new JButton(new ImageIcon("hinh/first.jpg")));
		b5.add(btnTruoc = new JButton(new ImageIcon("hinh/pri.jpg")));
		b5.add(lblMauTin = new JLabel());
		b5.add(btnSau = new JButton(new ImageIcon("hinh/next.jpg")));
		b5.add(btnCuoi = new JButton(new ImageIcon("hinh/last.jpg")));
		b5.add(Box.createHorizontalStrut(70));
		b5.add(btnThem = new JButton("Them"));
		b5.add(btnLuu= new JButton("Luu"));
		btnSua = new JButton("Sua");
		b5.add(btnSua = new JButton("Sua"));
		b5.add(btnXoa = new JButton("Xoa"));

		String[] headers = {"MA THE", "MA SACH", "NGAY THUE","NGAY TRA","MA THU THU","GIA THUE","MA KHACH HANG"};
		dataModel = new DefaultTableModel(headers , 0);
		JScrollPane scroll;
		b6.add(scroll = new JScrollPane(table = new JTable(dataModel)));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh Sach The"));

		b7.add(Box.createHorizontalStrut(600));
		b7.add(btnIn = new JButton("IN RA JSON"));
		b7.add(btnTK = new JButton("TIM KIEM THE"));
		b7.add(Box.createHorizontalStrut(10));
		b7.add(txtTK = new JTextField());
		btnTK.setForeground(Color.red);
txtTK.setEditable(false);
		moKhoaTextfields(false);
		moKhoaControls(true);
		btnLuu.setEnabled(false);

		try{
		}catch(Exception ex){
			System.out.println("ERROR");
			ex.printStackTrace();
		}
		
		lopHocHelper = new ThuVienHelper();
		table.setRowHeight(25);
		for(TheThuVien lh : lopHocHelper.getAll()){
			Object[] rowData = {lh.getMaThe(),lh.getMaSach(),lh.getNgayThue(),lh.getNgayTra(),
					lh.getMaTT(),lh.getGiaThue(),lh.getMaKH()};
			dataModel.addRow(rowData);
		}
		
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				if(row >= 0){
					mauTinHienHanh = row;
					capNhatThongTinMauTin(mauTinHienHanh);
				}
			}
		});
		mauTinHienHanh = -1;
		tongSoMauTin = table.getRowCount();
		if(tongSoMauTin > 0){
			mauTinHienHanh = 0; 
			capNhatThongTinMauTin(mauTinHienHanh);
		}

		btnDau.addActionListener(this);
		btnTruoc.addActionListener(this);
		btnSau.addActionListener(this);
		btnCuoi.addActionListener(this);
		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnIn.addActionListener(this);
		btnTK.addActionListener(this);
		
		

	}

	private void capNhatThongTinMauTin(int n) {
		table.setRowSelectionInterval(n, n);
		lblMauTin.setText(mauTinHienHanh + 1 + "/" + tongSoMauTin);
		napLopHocVaoTextfields();
	}

	private void moKhoaControls(boolean b) {
		btnDau.setEnabled(b);
		btnTruoc.setEnabled(b);
		btnSau.setEnabled(b);
		btnCuoi.setEnabled(b);
		btnThem.setEnabled(b);
		btnLuu.setEnabled(b);
		btnSua.setEnabled(b);
		btnXoa.setEnabled(b);
		btnTK.setEnabled(b);
	}

	private void moKhoaTextfields(boolean b) {
		txtMaSach.setEditable(b);
		txtMaKH.setEditable(b);
		txtMaTT.setEditable(b);
		txtMaThe.setEditable(b);
		txtNgayThue.setEditable(b);
		txtNgayTra.setEditable(b);
		txtGiaTien.setEditable(b);
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnTK)){
			txtTK.setEditable(true);
			String s=txtTK.getText();
			if(!s.equalsIgnoreCase("")){
				TheThuVien x=null;
				for(TheThuVien tv : lopHocHelper.getAll())
				{
					if(tv.getMaThe() == Integer.parseInt(txtTK.getText())){
					x=tv;
					}
				}
				if(x==null)
					JOptionPane.showMessageDialog(null,
						    "Dont exist",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				else
				{
					JOptionPane.showMessageDialog(null,
						    "Ma The:"+x.getMaThe()+"\nMa Sach:"+x.getMaSach()
						    +"\nNgay Thue:"+x.getNgayThue()+"---Ngay Tra:"+x.getNgayTra()
						    +"\nMa Thu Thu:"+x.getMaTT()+"\nMa Khach Hang:" +x.getMaKH()
						    +"\nGia Thue:"+x.getGiaThue()
						    ,
						    "Thong Tin",
						    JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}else
		if(o.equals(btnThem)){
			if(btnThem.getText().equalsIgnoreCase("Them")){
				moKhoaTextfields(true);
				moKhoaControls(false);
				btnLuu.setEnabled(true);
				btnThem.setEnabled(true);
				xoaRongTextfields();
				btnThem.setText("Huy");
			}else if(btnThem.getText().equalsIgnoreCase("Huy")){
				moKhoaTextfields(false);
				moKhoaControls(true);
				btnLuu.setEnabled(false);
				btnThem.setText("Them");
				napLopHocVaoTextfields();
			}
		}else if(o.equals(btnSua)){
			if(btnSua.getText().equalsIgnoreCase("Sua")){
				moKhoaTextfields(true);
				moKhoaControls(false);
				txtMaThe.setEditable(false);
				btnLuu.setEnabled(true);
				btnSua.setEnabled(true);
				btnSua.setText("Huy");
			}else if(btnSua.getText().equalsIgnoreCase("Huy")){
				moKhoaTextfields(false);
				moKhoaControls(true);
				btnLuu.setEnabled(false);
				btnSua.setText("Sua");
				napLopHocVaoTextfields();
			}
		} 
		else if(o.equals(btnLuu)){
			if(btnThem.getText().equalsIgnoreCase("Huy")){
//lay ngay
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
				java.util.Date date = null;
				try {
					date = sdf1.parse(txtNgayThue.getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Date nThue = new Date(date.getTime());
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-mm-dd");
				try {
					date = sdf1.parse(txtNgayTra.getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Date nTra = new Date(date.getTime());
//lay ngay
				
				TheThuVien lh = new TheThuVien(Integer.parseInt(txtMaThe.getText()),Integer.parseInt(txtMaSach.getText()),nThue, nTra, Integer.parseInt(txtMaTT.getText()),Integer.parseInt(txtMaKH.getText()),Float.parseFloat(txtGiaTien.getText()));
				if(lh.create())
				{
					Object[] rowData = {txtMaThe.getText(), txtMaSach.getText(), txtNgayThue.getText(),txtNgayTra.getText(),txtMaTT.getText(),txtGiaTien.getText(),txtMaKH.getText()};
					dataModel.addRow(rowData);
					moKhoaTextfields(false);
					moKhoaControls(true);
					btnLuu.setEnabled(false);
					btnThem.setText("Them");
					tongSoMauTin ++;
					mauTinHienHanh = tongSoMauTin - 1;
					capNhatThongTinMauTin(mauTinHienHanh);
				}
				else
				{
					txtMaSach.requestFocus();
				}
					}else if(btnSua.getText().equalsIgnoreCase("Huy")){
				int row = table.getSelectedRow();
				if(row >= 0){
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
					java.util.Date date = null;
					try {
						date = sdf1.parse(txtNgayThue.getText());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Date nThue = new Date(date.getTime());
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-mm-dd");
					try {
						date = sdf1.parse(txtNgayTra.getText());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Date nTra = new Date(date.getTime());
					TheThuVien lh = new TheThuVien(Integer.parseInt(txtMaThe.getText()),Integer.parseInt(txtMaSach.getText()),nThue, nTra, Integer.parseInt(txtMaTT.getText()),Integer.parseInt(txtMaKH.getText()),Float.parseFloat(txtGiaTien.getText()));
					if(lh.update()){
						table.setValueAt(lh.getMaSach(), row, 1);
						table.setValueAt(lh.getNgayThue(), row, 2);
						table.setValueAt(lh.getNgayTra(), row, 3);
						table.setValueAt(lh.getMaTT(), row, 4);
						table.setValueAt(lh.getGiaThue(), row, 5);
						table.setValueAt(lh.getMaKH(), row, 6);
						moKhoaTextfields(false);
						moKhoaControls(true);
						btnLuu.setEnabled(false);
						btnSua.setText("Sua");
					}
						else
						{
							txtTK.setText("Fail");
							txtMaSach.requestFocus();
						}
				}
			}
		}else if(o.equals(btnXoa)){
			int row = table.getSelectedRow();
			if(row >= 0){
				int maThe = (int) table.getValueAt(row, 0);
				TheThuVien lh = new TheThuVien(Integer.parseInt(txtMaThe.getText()));
				if(lh.detele()){
					dataModel.removeRow(row);
					xoaRongTextfields();
					tongSoMauTin --;
					if(tongSoMauTin != 0){
						if(row == tongSoMauTin)
							mauTinHienHanh = 0;
						else
							mauTinHienHanh = row;
						capNhatThongTinMauTin(mauTinHienHanh);
					}else
						lblMauTin.setText("");
				}
			}
		}else if(o.equals(btnIn)){
			Writer.writeList(lopHocHelper.getAll());
			txtTK.setText("DONE");
		}
		else
			if(tongSoMauTin > 0){ 
			if(o.equals(btnDau))
				mauTinHienHanh = 0;
			else if(o.equals(btnCuoi))
				mauTinHienHanh = tongSoMauTin - 1;
			else if(o.equals(btnSau) && mauTinHienHanh < tongSoMauTin - 1)
				mauTinHienHanh ++;
			else if(o.equals(btnTruoc) && mauTinHienHanh > 0)
				mauTinHienHanh --;
			capNhatThongTinMauTin(mauTinHienHanh);
		}
	}






	private void napLopHocVaoTextfields() {
		int row = table.getSelectedRow();
		if(row >= 0){
			txtMaThe.setText(table.getValueAt(row, 0)+ "");
			txtMaSach.setText( table.getValueAt(row, 1)+ "");
			txtNgayThue.setText( table.getValueAt(row, 2)+ "");
			txtNgayTra.setText( table.getValueAt(row, 3)+ "");
			txtMaTT.setText(table.getValueAt(row, 4)+ "");
			txtGiaTien.setText( table.getValueAt(row, 5)+ "");
			txtMaKH.setText( table.getValueAt(row, 6)+ "");
		}
	}
 
	private void xoaRongTextfields() {
		txtGiaTien.setText("");
		txtMaKH.setText("");
		txtMaSach.setText("");
		txtMaThe.setText("");
		txtMaTT.setText("");
		txtNgayThue.setText("");
		txtNgayTra.setText("");
		txtMaThe.requestFocus();
	}
	
	
	

}

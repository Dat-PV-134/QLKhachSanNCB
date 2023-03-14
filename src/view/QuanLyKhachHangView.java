package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.KhachHangController;
import dao.KhachHangDao;
import model.KhachHang;

public class QuanLyKhachHangView extends JFrame{
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable tableKhachHang;
	private JRadioButton rdbDaDat;
	private JRadioButton rdbTrong;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnTim;
	private JButton btnThm;
	private DefaultTableModel defaultTableModel;
	private String[][] data;
	private String[] collumName = { "Mã KH", "Tên khách hàng", "Giới tính", "Ngày sinh", "Số điện thoại" };
	private KhachHangDao khachHangDao;
	private KhachHangController khachHangController;
	
	
	public QuanLyKhachHangView() {
		khachHangDao = new KhachHangDao();
		defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		khachHangController = new KhachHangController(this);
		this.Unit();
	}
	
	public void Unit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Thông tin khách hàng");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(330, 23, 300, 36);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(208, 208, 208)));
		panel.setBounds(54, 110, 242, 460);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMaNV = new JLabel("Mã KH");
		lblMaNV.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblMaNV.setBounds(12, 25, 60, 20);
		panel.add(lblMaNV);
		
		textField = new JTextField();
		textField.setBackground(new Color(233, 250, 247));
		textField.setBounds(85, 25, 145, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		btnThm = new JButton("Thêm");
		btnThm.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnThm.setBounds(22, 350, 80, 30);
		btnThm.setBackground(new Color(240, 216, 216));
		btnThm.setBorderPainted(false);
		btnThm.setFocusPainted(false);
		btnThm.setContentAreaFilled(false);
		btnThm.setOpaque(true);
		btnThm.setMargin(new Insets(10, 10, 10, 10));
		panel.add(btnThm);
		
		btnTim = new JButton("Tìm kiếm");
		btnTim.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnTim.setBounds(137, 400, 80, 30);
		btnTim.setBackground(new Color(240, 216, 216));
		btnTim.setBorderPainted(false);
		btnTim.setFocusPainted(false);
		btnTim.setContentAreaFilled(false);
		btnTim.setOpaque(true);
		btnTim.setMargin(new Insets(10, 10, 10, 10));
		panel.add(btnTim);
		
		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnSua.setBounds(137, 350, 80, 30);
		btnSua.setBackground(new Color(240, 216, 216));
		btnSua.setBorderPainted(false);
		btnSua.setFocusPainted(false);
		btnSua.setContentAreaFilled(false);
		btnSua.setOpaque(true);
		btnSua.setMargin(new Insets(10, 10, 10, 10));
		panel.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnXoa.setBounds(22, 400, 80, 30);
		btnXoa.setBackground(new Color(240, 216, 216));
		btnXoa.setBorderPainted(false);
		btnXoa.setFocusPainted(false);
		btnXoa.setContentAreaFilled(false);
		btnXoa.setOpaque(true);
		btnXoa.setMargin(new Insets(10, 10, 10, 10));
		panel.add(btnXoa);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Giới tính");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(12, 105, 60, 20);
		panel.add(lblNewLabel_1_1_1);
		
		ButtonGroup buttonGroupGT = new ButtonGroup();
		
		rdbTrong = new JRadioButton("Nam");
		rdbTrong.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbTrong.setBounds(90, 105, 70, 21);
		rdbTrong.setBackground(Color.WHITE);
		buttonGroupGT.add(rdbTrong);
		panel.add(rdbTrong);
		
		rdbDaDat = new JRadioButton("Nữ");
		rdbDaDat.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbDaDat.setBackground(Color.WHITE);
		rdbDaDat.setBounds(162, 105, 70, 21);
		buttonGroupGT.add(rdbDaDat);
		panel.add(rdbDaDat);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(233, 250, 247));
		textField_1.setBounds(85, 65, 145, 19);
		panel.add(textField_1);
		
		JLabel lblMaNV_1 = new JLabel("Tên KH");
		lblMaNV_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblMaNV_1.setBounds(12, 65, 60, 20);
		panel.add(lblMaNV_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(233, 250, 247));
		textField_2.setBounds(85, 145, 145, 19);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(233, 250, 247));
		textField_3.setBounds(85, 185, 145, 19);
		panel.add(textField_3);
		
		JLabel lblMaNV_1_1 = new JLabel("CCCD");
		lblMaNV_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblMaNV_1_1.setBounds(12, 185, 60, 20);
		panel.add(lblMaNV_1_1);
		
		JLabel lblNgySinh = new JLabel("Ngày sinh");
		lblNgySinh.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNgySinh.setBounds(12, 145, 60, 20);
		panel.add(lblNgySinh);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(233, 250, 247));
		textField_4.setBounds(85, 225, 145, 19);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(233, 250, 247));
		textField_5.setBounds(85, 265, 145, 19);
		panel.add(textField_5);
		
		JLabel lblMaNV_1_2 = new JLabel("SĐT");
		lblMaNV_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblMaNV_1_2.setBounds(12, 265, 60, 20);
		panel.add(lblMaNV_1_2);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblaCh.setBounds(12, 225, 60, 20);
		panel.add(lblaCh);
		
		tableKhachHang = new JTable();
		tableKhachHang.setBorder(new LineBorder(new Color(208, 208, 208)));
		tableKhachHang.setForeground(new Color(0, 0, 0));
		tableKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tableKhachHang.setRowHeight(25);
		
		JScrollPane scrollPane = new JScrollPane(tableKhachHang);
		scrollPane.setBounds(350, 110, 585, 460);
		scrollPane.getViewport().setBackground(Color.WHITE);
		contentPane.add(scrollPane);
		
		JButton btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setBounds(430, 606, 90, 35);
		btnQuayLai.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnQuayLai.setBackground(new Color(225, 232, 230));
		btnQuayLai.setBorderPainted(false);
		btnQuayLai.setFocusPainted(false);
		btnQuayLai.setContentAreaFilled(false);
		btnQuayLai.setOpaque(true);
		btnQuayLai.setMargin(new Insets(10, 10, 10, 10));
		btnQuayLai.addActionListener(khachHangController);
		contentPane.add(btnQuayLai);
		
		
		ArrayList<KhachHang> dsKhachHang = khachHangDao.SelectAll();
		HienThiData(dsKhachHang);
		
		btnThm.addActionListener(khachHangController);
		btnSua.addActionListener(khachHangController);
		btnXoa.addActionListener(khachHangController);
		btnTim.addActionListener(khachHangController);
		tableKhachHang.addMouseListener(khachHangController);
		
		this.setVisible(true);
	}
	
	public String getReverseDate(String date) {
		String[] temp = date.split("/");
		return temp[2] + "-" + temp[1] + "-" + temp[0];
	}
	
	public void HienThiData(ArrayList<KhachHang> dskh) {
		int size = dskh.size();
		int index = 0;
		String makh = "";
		data = new String[size][7];
		for(KhachHang kh : dskh) {
			if(kh.getMaKH() < 10) {
				makh = "KH0" + kh.getMaKH(); 
			} else {
				makh = "KH" + kh.getMaKH(); 
			}
			data[index][0] = makh;
			data[index][1] = kh.getTenKH();
			data[index][2] = kh.getGioiTinh();
			data[index][3] = getDateFormatted(kh.getNgaySinh());
			data[index][4] = kh.getCCCD();
			data[index][5] = kh.getDiaChi();
			data[index][6] = kh.getSDT();
			index++;
		}
		
		defaultTableModel.setDataVector(data, collumName);
		tableKhachHang.setModel(defaultTableModel);
		
	}
	
	private String getDateFormatted(String str) {
		String[] tempNgay = str.split("-");
		String ngayThangNam = tempNgay[2] + "/" + tempNgay[1] +"/" + tempNgay[0];
		return ngayThangNam;
	}
	
	public void ThemKhachHang() {
		if(CheckData() == false) {
			JOptionPane.showMessageDialog(this, "Bạn phải nhập đầy đủ thông tin", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		
		String gioiTinh = "";
		if(rdbTrong.isSelected()) {
			gioiTinh = "Nam";
		} else {
			gioiTinh = "Nữ";
		}
		KhachHang kh = new KhachHang(0, textField_1.getText().trim(), gioiTinh, textField_3.getText(), textField_4.getText(), textField_5.getText(), getReverseDate(textField_2.getText().trim()));
		int kq = 0;
		kq = khachHangDao.insertOrUpdate(kh);
		if(kq > 0) {
			JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			ArrayList<KhachHang> dsKhachHang = khachHangDao.SelectAll();
			HienThiData(dsKhachHang);
			return;
		} else {
			JOptionPane.showMessageDialog(this, "Thêm khách hàng không thành công!, Vui lòng kiểm tra lại kết nối và dữ liệu", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

		}
	}
	
	public void LayDong() {
		int row = tableKhachHang.getSelectedRow();
		String m = data[row][0];
		int maKH = Integer.parseInt(m.substring(2, m.length()));
		KhachHang kh = khachHangDao.SelectKhachHangByID(maKH);
		textField.setText(m);
		textField_1.setText(kh.getTenKH());
		if(kh.getGioiTinh().equals("Nam")) {
			rdbTrong.setSelected(true);
			
		} else {
			rdbDaDat.setSelected(true);
			
		}
		textField_2.setText(getDateFormatted(kh.getNgaySinh()));
		textField_3.setText(kh.getCCCD());
		textField_4.setText(kh.getDiaChi());
		textField_5.setText(kh.getSDT());
	}
	
	public void Sua() {
		if(CheckData() == false) {
			JOptionPane.showMessageDialog(this, "Bạn phải nhập đầy đủ thông tin", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		String m = textField.getText();
		int maKH = 0 ;
		try {
			maKH = Integer.parseInt(m.substring(2, m.length()));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Mã khách hàng sai", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		String gioiTinh = "";
		if(rdbTrong.isSelected() == true) {
			gioiTinh = "Nam";
			
		} 
		if(rdbDaDat.isSelected() == true) {
			System.out.println(2);
			gioiTinh = "Nữ";
		}
		System.out.println(gioiTinh);
		KhachHang kh = new KhachHang(maKH, textField_1.getText().trim(), gioiTinh, textField_3.getText(), textField_4.getText(), textField_5.getText(), getReverseDate(textField_2.getText().trim()));
		System.out.println(kh);
		int kq = 0;
		kq = khachHangDao.UpdateKhachHang(kh);
		if(kq > 0) {
			JOptionPane.showMessageDialog(this, "Sửa hàng thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			ArrayList<KhachHang> dsKhachHang = khachHangDao.SelectAll();
			HienThiData(dsKhachHang);
			return;
		} else {
			JOptionPane.showMessageDialog(this, "Sửa hàng không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

		}
	}
	
	public void Xoa() {
		if(CheckData() == false) {
			JOptionPane.showMessageDialog(this, "Bạn phải nhập đầy đủ thông tin", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		String m = textField.getText();
		int maKH = 0 ;
		try {
			maKH = Integer.parseInt(m.substring(2, m.length()));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Mã khách hàng sai", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		int kq1 = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa khách hàng có mã " + m + " không?", "Thông báo", JOptionPane.YES_NO_OPTION);
		if(kq1 == JOptionPane.YES_OPTION) {
			int kq = 0;
			kq = khachHangDao.DeleteKhachHang(maKH);
			if(kq > 0) {
				JOptionPane.showMessageDialog(this, "Xóa khách hàng thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				ArrayList<KhachHang> dsKhachHang = khachHangDao.SelectAll();
				HienThiData(dsKhachHang);
				Clear();
				return;
			} else {
				JOptionPane.showMessageDialog(this, "Xoa khách hàng không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

			}
		}
		
	}
	
	public void Clear() {
		textField.setText("");
		textField_1.setText("");
		rdbTrong.setSelected(true);
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
	}
	
	public boolean CheckData() {
		if(textField_1.getText().equals("") || textField_2.getText().equals("") || textField_3.getText().equals("") || textField_4.getText().equals("") || textField_5.getText().equals("")) {
			return false;
		} else if(rdbDaDat.isSelected() == false && rdbTrong.isSelected() == false) {
			return false;
		}
		return true;
		
	}

	public void TimKiem() {
		// TODO Auto-generated method stub
		ArrayList<KhachHang> dskh = khachHangDao.timKiemTheoTen(textField_1.getText().toString());
		int n = dskh.size();
		data = new String[n][6];
		int index = 0;
		for(KhachHang x : dskh) {
			data[index][0] = x.getMaKH() + "";
			data[index][1] = x.getTenKH();
			data[index][2] = x.getNgaySinh();
			data[index][3] = x.getNgaySinh();
			data[index][4] = x.getGioiTinh();
			data[index][5] = x.getSDT();
			index++;
		}
		
		defaultTableModel.setDataVector(data, collumName);
		tableKhachHang.setModel(defaultTableModel);
		HienThiData(dskh);
		
	}
	

}

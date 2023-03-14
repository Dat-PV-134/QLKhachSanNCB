package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseListener;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.swing.Action;
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

import com.microsoft.sqlserver.jdbc.StringUtils;


import controller.NhanVienController;
import dao.NhanVienDao;
import model.NhanVien;

import controller.NhanVienController;

public class NhanVienView extends JFrame {
	ArrayList<NhanVien> dsnv;
	String [][] data;

	private JPanel contentPane;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTextField txtLuong;
	private ButtonGroup rdbGioiTinh;
	private ButtonGroup rdbCaLam;
	private ButtonGroup rdbTinhTrang;
	private JTextField txtNghi;
	private JRadioButton rdbNam;
	private JRadioButton rdbNu;
	private JRadioButton rdbSang;
	private JRadioButton rdbToi;
	private JRadioButton rdbCoMat;
	private JRadioButton rdbVang;
	private JTable tableHoaDon;
	private JScrollPane scrollPane;
	DefaultTableModel defaultTableModel;
	
	String[] collumName = {
		"Mã NV", "Tên NV", "Ca làm", "Lương", "Số ngày nghỉ", "Tình trạng"
	};
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVienView frame = new NhanVienView();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NhanVienView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		Action action = new NhanVienController(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Quản lý nhân viên");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(374, 23, 204, 36);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(208, 208, 208)));
		panel.setBounds(54, 110, 242, 460);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMaNV = new JLabel("Mã NV");
		lblMaNV.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblMaNV.setBounds(12, 20, 60, 20);
		panel.add(lblMaNV);
		
		txtMa = new JTextField();
		txtMa.setBackground(new Color(233, 250, 247));
		txtMa.setBounds(85, 20, 145, 19);
		panel.add(txtMa);
		txtMa.setColumns(10);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(action);
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnThem.setBounds(22, 369, 80, 30);
		btnThem.setBackground(new Color(240, 216, 216));
		btnThem.setBorderPainted(false);
		btnThem.setFocusPainted(false);
		btnThem.setContentAreaFilled(false);
		btnThem.setOpaque(true);
		btnThem.setMargin(new Insets(10, 10, 10, 10));
		panel.add(btnThem);
		
		JButton btnTim = new JButton("Tìm kiếm");
		btnTim.addActionListener(action);
		btnTim.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnTim.setBounds(137, 420, 80, 30);
		btnTim.setBackground(new Color(240, 216, 216));
		btnTim.setBorderPainted(false);
		btnTim.setFocusPainted(false);
		btnTim.setContentAreaFilled(false);
		btnTim.setOpaque(true);
		btnTim.setMargin(new Insets(10, 10, 10, 10));
		panel.add(btnTim);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(action);
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnSua.setBounds(137, 369, 80, 30);
		btnSua.setBackground(new Color(240, 216, 216));
		btnSua.setBorderPainted(false);
		btnSua.setFocusPainted(false);
		btnSua.setContentAreaFilled(false);
		btnSua.setOpaque(true);
		btnSua.setMargin(new Insets(10, 10, 10, 10));
		panel.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(action);
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnXoa.setBounds(22, 420, 80, 30);
		btnXoa.setBackground(new Color(240, 216, 216));
		btnXoa.setBorderPainted(false);
		btnXoa.setFocusPainted(false);
		btnXoa.setContentAreaFilled(false);
		btnXoa.setOpaque(true);
		btnXoa.setMargin(new Insets(10, 10, 10, 10));
		panel.add(btnXoa);
		
		JLabel lblTnNv = new JLabel("Tên NV");
		lblTnNv.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblTnNv.setBounds(12, 55, 60, 20);
		panel.add(lblTnNv);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBackground(new Color(233, 250, 247));
		txtTen.setBounds(85, 55, 145, 19);
		panel.add(txtTen);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Giới tính");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(12, 95, 60, 20);
		panel.add(lblNewLabel_1_1_1);
		
		rdbNam = new JRadioButton("Nam");
		rdbNam.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbNam.setBounds(90, 95, 70, 21);
		rdbNam.setBackground(Color.WHITE);
		panel.add(rdbNam);
		
		rdbNu = new JRadioButton("Nữ");
		rdbNu.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbNu.setBackground(Color.WHITE);
		rdbNu.setBounds(162, 95, 70, 21);
		panel.add(rdbNu);
		
		rdbGioiTinh = new ButtonGroup();
		rdbGioiTinh.add(rdbNam);
		rdbGioiTinh.add(rdbNu);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBackground(new Color(233, 250, 247));
		txtDiaChi.setBounds(85, 135, 145, 19);
		panel.add(txtDiaChi);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblaCh.setBounds(12, 135, 60, 20);
		panel.add(lblaCh);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBackground(new Color(233, 250, 247));
		txtSDT.setBounds(85, 170, 145, 19);
		panel.add(txtSDT);
		
		tableHoaDon = new JTable();
		tableHoaDon.setBorder(new LineBorder(new Color(208, 208, 208)));
		tableHoaDon.setForeground(new Color(0, 0, 0));
		tableHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		tableHoaDon.setModel(defaultTableModel);
		MouseListener mouseListener = new NhanVienController(this);
		tableHoaDon.addMouseListener(mouseListener);
		
		tableHoaDon.setRowHeight(25);
		
		scrollPane = new JScrollPane(tableHoaDon);
		scrollPane.setBounds(350, 110, 585, 375);
		scrollPane.getViewport().setBackground(Color.WHITE);
		
		JLabel lblaCh_1 = new JLabel("SĐT");
		lblaCh_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblaCh_1.setBounds(12, 170, 60, 20);
		panel.add(lblaCh_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Ca làm");
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1.setBounds(12, 210, 60, 20);
		panel.add(lblNewLabel_1_1_1_1);
		
		rdbSang = new JRadioButton("Sáng");
		rdbSang.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbSang.setBackground(Color.WHITE);
		rdbSang.setBounds(90, 210, 70, 21);
		panel.add(rdbSang);
		
		rdbToi = new JRadioButton("Tối");
		rdbToi.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbToi.setBackground(Color.WHITE);
		rdbToi.setBounds(162, 210, 70, 21);
		panel.add(rdbToi);
		
		rdbCaLam = new ButtonGroup();
		rdbCaLam.add(rdbToi);
		rdbCaLam.add(rdbSang);
		
		JLabel lblLng = new JLabel("Lương");
		lblLng.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblLng.setBounds(12, 250, 60, 20);
		panel.add(lblLng);
		
		txtLuong = new JTextField();
		txtLuong.setColumns(10);
		txtLuong.setBackground(new Color(233, 250, 247));
		txtLuong.setBounds(85, 250, 145, 19);
		panel.add(txtLuong);
		
		JLabel lblaCh_1_1 = new JLabel("Nghỉ");
		lblaCh_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblaCh_1_1.setBounds(12, 285, 60, 20);
		panel.add(lblaCh_1_1);
		
		txtNghi = new JTextField();
		txtNghi.setColumns(10);
		txtNghi.setBackground(new Color(233, 250, 247));
		txtNghi.setBounds(85, 285, 145, 19);
		panel.add(txtNghi);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Tình trạng");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1.setBounds(12, 325, 60, 20);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		rdbCoMat = new JRadioButton("Có mặt");
		rdbCoMat.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbCoMat.setBackground(Color.WHITE);
		rdbCoMat.setBounds(90, 325, 70, 21);
		panel.add(rdbCoMat);
		
		rdbVang = new JRadioButton("Vắng");
		rdbVang.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbVang.setBackground(Color.WHITE);
		rdbVang.setBounds(162, 325, 70, 21);
		panel.add(rdbVang);
		
		rdbTinhTrang = new ButtonGroup();
		rdbTinhTrang.add(rdbVang);
		rdbTinhTrang.add(rdbCoMat);
		
		HienThiData();
		
		
		JButton btnThongKe = new JButton("Thống kê lương");
		btnThongKe.setBounds(605, 516, 100, 35);
		btnThongKe.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnThongKe.setBackground(new Color(146, 255, 146));
		btnThongKe.setBorderPainted(false);
		btnThongKe.setFocusPainted(false);
		btnThongKe.setContentAreaFilled(false);
		btnThongKe.setOpaque(true);
		btnThongKe.setMargin(new Insets(10, 10, 10, 10));
		btnThongKe.addActionListener(action);
		contentPane.add(btnThongKe);
		
		JButton btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setBounds(430, 606, 90, 35);
		btnQuayLai.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnQuayLai.setBackground(new Color(225, 232, 230));
		btnQuayLai.setBorderPainted(false);
		btnQuayLai.setFocusPainted(false);
		btnQuayLai.setContentAreaFilled(false);
		btnQuayLai.setOpaque(true);
		btnQuayLai.addActionListener(action);
		btnQuayLai.setMargin(new Insets(10, 10, 10, 10));
		contentPane.add(btnQuayLai);	
	}
	
	private String getNormalMonney(String str) {
		String money = "";
		if (str.charAt(str.length()-1) == 'đ' || str.contains(",")) {
			String moneyNoComma = str.substring(0, str.length()-1).replace(",", "");
			Double roomMoney = Double.parseDouble(moneyNoComma);
			money = roomMoney.toString();
		} else {
			money = str;
		}
		return money;
	}
	
	private String getFormattedMoney(Double money) {
		return String.format("%, .0f", money);
	}
	
	public void HienThiData() {
		dsnv = NhanVienDao.getInstance().SelectAll();
		int n = dsnv.size();
		data = new String[n][6];
		int index = 0;
		for(NhanVien x : dsnv) {
			data[index][0] = x.getMaNV();
			data[index][1] = x.getTenNV();
			data[index][2] = x.getCaLam();
			data[index][3] = getFormattedMoney(x.getLuong()) + "đ";
			data[index][4] = x.getSoNgayNghi() + "";
			data[index][5] = x.getTinhTrang() + "";
			index++;
		}
		
		defaultTableModel.setDataVector(data, collumName);
		tableHoaDon.setModel(defaultTableModel);
		
		this.add(scrollPane);
		
	}
	public void ThemNhanVien() {
		if(checkNull()) {
			JOptionPane.showMessageDialog(rootPane, "Bạn không được để trống các trường");
			return;
		};
		if(checkMaNV()) {
			JOptionPane.showMessageDialog(rootPane, "Mã nhân viên đã tồn tại");
			return;
		}
		
		
		NhanVien nv = new NhanVien(txtMa.getText().trim(), txtTen.getText().trim(), (String)(rdbGioiTinh.getSelection() == rdbNam.getModel() ? "Nam" : "Nữ").toString() ,txtDiaChi.getText(), txtSDT.getText().trim(), (String)(rdbCaLam.getSelection() == rdbSang.getModel() ? "Sáng" : "Tối"), Double.parseDouble(getNormalMonney(txtLuong.getText().trim())), Integer.parseInt(txtNghi.getText().trim()) ,(String)(rdbTinhTrang.getSelection() == rdbCoMat.getModel() ? "Có mặt" : "Vắng"));
		if(NhanVienDao.getInstance().insert(nv) != 0) {
			JOptionPane.showMessageDialog(rootPane, "Thêm sinh viên thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(rootPane, "Thêm sinh viên không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

		}
		HienThiData();
	}
	public void XoaNhanVien() {
		// TODO Auto-generated method stub
		if(txtMa.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn 1 nhân viên", "Thông báo" , JOptionPane.INFORMATION_MESSAGE);	
			return;
		}
		if(checkMaNV() == false) {
			JOptionPane.showMessageDialog(rootPane, "Mã nhân viên không tồn tại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		NhanVien nv = NhanVienDao.getInstance().SelectedByID(txtMa.getText().trim());
		
		
		
		if(nv != null) {
			int result = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc muốn xóa sinh viên có mã "+ nv.getMaNV() + " không?",
					"Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(result == JOptionPane.YES_OPTION) {
				NhanVienDao.getInstance().delete(nv);
				JOptionPane.showMessageDialog(rootPane, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);	
				HienThiData();
			}
		} else {
			JOptionPane.showMessageDialog(rootPane, "Xóa không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	public void SuaNhanVien() {
		if(checkMaNV() == false) {
			JOptionPane.showMessageDialog(rootPane, "Mã nhân viên không tồn tại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		NhanVien nv = new NhanVien(txtMa.getText().trim(), txtTen.getText().trim(), (String)(rdbGioiTinh.getSelection() == rdbNam.getModel() ? "Nam" : "Nữ").toString() ,txtDiaChi.getText(), txtSDT.getText().trim(), (String)(rdbCaLam.getSelection() == rdbSang.getModel() ? "Sáng" : "Tối"), Double.parseDouble(getNormalMonney(getNormalMonney(txtLuong.getText().trim()))), Integer.parseInt(txtNghi.getText().trim()) ,(String)(rdbTinhTrang.getSelection() == rdbCoMat.getModel() ? "Có mặt" : "Vắng"));
//		NhanVien nv = NhanVienDAO.getInstance().SelectedByID(txtMa.getText());
//		nv.setDiaChi(txtDiaChi.getText());
//		nv.setTeNNV(txtTen.getText());
//		nv.setSDT(txtSDT.getText());
		
		
		if(nv != null) {
			int result = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc muốn sửa sinh viên có mã "+ nv.getMaNV() + " không?",
					"Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(result == JOptionPane.YES_OPTION) {
				NhanVienDao.getInstance().update(nv);
				JOptionPane.showMessageDialog(rootPane, "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);	
				HienThiData();
			}
		} else {
			JOptionPane.showMessageDialog(rootPane, "Sửa không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void kichTable() {
		int r = tableHoaDon.getSelectedRow();
		String maNV = data[r][0];
		NhanVien nv = NhanVienDao.getInstance().SelectedByID(maNV);
		txtMa.setText(maNV);
		txtTen.setText(nv.getTenNV());
		txtDiaChi.setText(nv.getDiaChi());
		txtLuong.setText(getFormattedMoney(nv.getLuong()) + "đ");
		txtNghi.setText(nv.getSoNgayNghi()+ "");
		txtSDT.setText(nv.getSDT());
		if(nv.getGioiTinh().equals("Nam")) {
			rdbNam.setSelected(true);
		} else {
			rdbNu.setSelected(true);
		}
		if(nv.getCaLam().equals("Sáng")) {
			rdbSang.setSelected(true);
		} else {
			rdbToi.setSelected(true);
		}
		if(nv.getTinhTrang().equals("Vắng")) {
			rdbVang.setSelected(true);
		} else {
			rdbCoMat.setSelected(true);
		}
	}
	
	public boolean checkMaNV() {
		String txt_ma = txtMa.getText();
		for(NhanVien x : dsnv) if(x.getMaNV().equals(txt_ma)) return true;
		return false;
	}
	
	public boolean checkNull() {
		if(txtMa.getText().trim().isEmpty() || txtTen.getText().isEmpty() || txtDiaChi.getText().isEmpty()||txtLuong.getText().isEmpty() 
				||txtNghi.getText().isEmpty() || txtSDT.getText().isEmpty() || rdbGioiTinh.getSelection() == null || rdbCaLam.getSelection() == null || rdbTinhTrang.getSelection() == null) 
			return true;
		
		return false;
	}
	
	public void xoaForm() {
		// TODO Auto-generated method stub
		
	}

	public void timNhanVien() {
		// TODO Auto-generated method stub
		dsnv = NhanVienDao.getInstance().timKiemTheoMaHoacTen(txtTen.getText().trim());
		int n = dsnv.size();
		data = new String[n][6];
		int index = 0;
		for(NhanVien x : dsnv) {
			data[index][0] = x.getMaNV();
			data[index][1] = x.getTenNV();
			data[index][2] = x.getCaLam();
			data[index][3] = getFormattedMoney(x.getLuong()) + "đ";
			data[index][4] = x.getSoNgayNghi() + "";
			data[index][5] = x.getTinhTrang() + "";
			index++;
		}
		
		defaultTableModel.setDataVector(data, collumName);
		tableHoaDon.setModel(defaultTableModel);
		
		this.add(scrollPane);
	}

	
	

	

}

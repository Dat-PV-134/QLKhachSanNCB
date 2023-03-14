package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QuanLyHoaDonController;
import dao.HoaDonDao;
import dao.KhachHangDao;
import dao.PhongDao;
import model.HoaDon;
import model.KhachHang;
import model.Phong;


public class QuanLyHoaDonView extends JFrame{
	private static QuanLyHoaDonView view = null;
	
	public static QuanLyHoaDonView getInstance() {
		if (view == null) view = new QuanLyHoaDonView();
		return view;
	}
	
	public static void refresh() {
		if (view != null) {
			view.dispose();
			view = null;
		}
		view = new QuanLyHoaDonView();
		view.setVisible(true);
		view.setLocationRelativeTo(null);
	}
	
	public static void hienThiDataFromOtherFrame() {
		view.loadHienThiData();
	}

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JButton btnInHoaDon;
	private JButton btnThm;
	private JButton btnTim;
	private JButton btnXem;
	private JTable tableHoaDon;
	private JScrollPane scrollPane;
	private JButton btnQuayLai;
	private String[] collums = {"Mã HĐ", "Mã KH", "Số Phòng", "Tổng số giờ", "Thành tiền", "Ghi chú"};
	private String[][] data;
	private HoaDonDao hoaDonDao;
	private KhachHangDao khachHangDao;
	private PhongDao phongDao;
	private DefaultTableModel defaultTableModel;
	private DateTimeFormatter dateTimeFormatter;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyHoaDonView frame = new QuanLyHoaDonView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} 
	
	public QuanLyHoaDonView() {
		defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		hoaDonDao = new HoaDonDao();
		khachHangDao = new KhachHangDao();
		phongDao = new PhongDao();
		this.Unit();
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
	
	public void Unit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản lý hóa đơn");
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
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(233, 250, 247));
		textField_1.setColumns(10);
		textField_1.setBounds(85, 35, 145, 19);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(233, 250, 247));
		textField_2.setColumns(10);
		textField_2.setBounds(85, 80, 145, 19);
		panel.add(textField_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mã KH");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(12, 80, 60, 20);
		panel.add(lblNewLabel_1_2);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(233, 250, 247));
		textField_3.setColumns(10);
		textField_3.setBounds(85, 125, 145, 19);
		panel.add(textField_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Tên KH");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(12, 125, 60, 20);
		panel.add(lblNewLabel_1_3);
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(233, 250, 247));
		textField_4.setColumns(10);
		textField_4.setBounds(85, 170, 145, 19);
		panel.add(textField_4);
		
		JLabel lblNewLabel_1_4 = new JLabel("Ngày đặt");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(12, 170, 60, 20);
		panel.add(lblNewLabel_1_4);
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(233, 250, 247));
		textField_5.setColumns(10);
		textField_5.setBounds(85, 215, 145, 19);
		panel.add(textField_5);
		
		JLabel lblNewLabel_1_5 = new JLabel("Ngày trả");
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_5.setBounds(12, 215, 60, 20);
		panel.add(lblNewLabel_1_5);
		
		textField_6 = new JTextField();
		textField_6.setBackground(new Color(233, 250, 247));
		textField_6.setColumns(10);
		textField_6.setBounds(85, 260, 145, 19);
		panel.add(textField_6);
		
		JLabel lblNewLabel_1_6 = new JLabel("Ghi chú");
		lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_6.setBounds(12, 260, 60, 20);
		panel.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số phòng");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(12, 35, 60, 20);
		panel.add(lblNewLabel_1_1);
		
		btnThm = new JButton("Thêm");
		btnThm.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnThm.setBounds(25, 360, 80, 30);
		btnThm.setBackground(new Color(240, 216, 216));
		btnThm.setBorderPainted(false);
		btnThm.setFocusPainted(false);
		btnThm.setContentAreaFilled(false);
		btnThm.setOpaque(true);
		btnThm.setMargin(new Insets(10, 10, 10, 10));
		panel.add(btnThm);
		
		btnTim = new JButton("Tìm kiếm");
		btnTim.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnTim.setBounds(145, 360, 80, 30);
		btnTim.setBackground(new Color(240, 216, 216));
		btnTim.setBorderPainted(false);
		btnTim.setFocusPainted(false);
		btnTim.setContentAreaFilled(false);
		btnTim.setOpaque(true);
		btnTim.setMargin(new Insets(10, 10, 10, 10));
		panel.add(btnTim);
		
		btnXem = new JButton("Lấy thông tin từ số phòng");
		btnXem.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnXem.setBounds(25, 410, 200, 30);
		btnXem.setBackground(new Color(146, 255, 146));
		btnXem.setBorderPainted(false);
		btnXem.setFocusPainted(false);
		btnXem.setContentAreaFilled(false);
		btnXem.setOpaque(true);
		btnXem.setMargin(new Insets(10, 10, 10, 10));
		panel.add(btnXem);
		
		tableHoaDon = new JTable();
		tableHoaDon.setBorder(new LineBorder(new Color(208, 208, 208)));
		tableHoaDon.setForeground(new Color(0, 0, 0));
		tableHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		defaultTableModel.setDataVector(null,collums);
		tableHoaDon.setModel(defaultTableModel);
		tableHoaDon.setRowHeight(25);
		
		
		scrollPane = new JScrollPane(tableHoaDon);
		scrollPane.setBounds(350, 110, 585, 375);
		scrollPane.getViewport().setBackground(Color.WHITE);
		contentPane.add(scrollPane);
		
		btnInHoaDon = new JButton("In hóa đơn");
		btnInHoaDon.setBounds(605, 516, 100, 35);
		btnInHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnInHoaDon.setBackground(new Color(146, 255, 146));
		btnInHoaDon.setBorderPainted(false);
		btnInHoaDon.setFocusPainted(false);
		btnInHoaDon.setContentAreaFilled(false);
		btnInHoaDon.setOpaque(true);
		btnInHoaDon.setMargin(new Insets(10, 10, 10, 10));
		contentPane.add(btnInHoaDon);
		ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
		dshd = hoaDonDao.SelectAllHoaDon();
		HienThiData(dshd);
		btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setBounds(430, 606, 90, 35);
		btnQuayLai.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnQuayLai.setBackground(new Color(225, 232, 230));
		btnQuayLai.setBorderPainted(false);
		btnQuayLai.setFocusPainted(false);
		btnQuayLai.setContentAreaFilled(false);
		btnQuayLai.setOpaque(true);
		btnQuayLai.setMargin(new Insets(10, 10, 10, 10));
		contentPane.add(btnQuayLai);
		
		
		QuanLyHoaDonController quanLyHoaDonController = new QuanLyHoaDonController(this);
		btnXem.addActionListener(quanLyHoaDonController);
		btnThm.addActionListener(quanLyHoaDonController);
		btnTim.addActionListener(quanLyHoaDonController);
		btnInHoaDon.addActionListener(quanLyHoaDonController);
		btnQuayLai.addActionListener(quanLyHoaDonController);
	}
	
	
	public void HienThiData(ArrayList<HoaDon> dshd) {
		int n = dshd.size();
		data = new String[n][6];
		int index = 0;
		for(HoaDon hd : dshd) {
			Phong p = phongDao.SelectPhongByID(hd.getSoPhong());
			
			KhachHang kh = khachHangDao.SelectKhachHangByID(hd.getMaKH());
			String soHD;
			String maKH;
			if(hd.getSoHD() < 10) {
				soHD = "HD0" + hd.getSoHD();
			} else {
				soHD = "HD" + hd.getSoHD();
			}
			if(kh.getMaKH() < 10) {
				maKH = "KH0" + kh.getMaKH();
			} else {
				maKH = "KH" + kh.getMaKH();
			}
			LocalDateTime ngayDat = LocalDateTime.parse(hd.getNgayDat().substring(0, hd.getNgayDat().length()-5), dateTimeFormatter);
			LocalDateTime ngayTra = LocalDateTime.parse(hd.getNgayTra().substring(0, hd.getNgayTra().length()-5), dateTimeFormatter);
			long chechLech = Duration.between(ngayDat, ngayTra).toMinutes();
			double gio = (double) Math.round((chechLech / 60) * 100) /100;
			double thanhTien = gio * p.getGiaPhong();
			data[index][0] = soHD;
			data[index][1] = maKH;
			data[index][2] = p.getSoPhong();
			data[index][3] = (int)gio + "";
			data[index][4] = getFormattedMoney(thanhTien) + "đ";
			data[index][5] = hd.getGhiChu();
			index++;
		}
		defaultTableModel.setDataVector(data, collums);
		tableHoaDon.setModel(defaultTableModel);
		this.add(scrollPane);
	}
	
	public void loadHienThiData() {
		ArrayList<HoaDon> dshd = new ArrayList<>();
		dshd = hoaDonDao.SelectAllHoaDon();
		int n = dshd.size();
		data = new String[n][6];
		int index = 0;
		for(HoaDon hd : dshd) {
			Phong p = phongDao.SelectPhongByID(hd.getSoPhong());
			
			KhachHang kh = khachHangDao.SelectKhachHangByID(hd.getMaKH());
			String soHD;
			String maKH;
			if(hd.getSoHD() < 10) {
				soHD = "HD0" + hd.getSoHD();
			} else {
				soHD = "HD" + hd.getSoHD();
			}
			if(kh.getMaKH() < 10) {
				maKH = "KH0" + kh.getMaKH();
			} else {
				maKH = "KH" + kh.getMaKH();
			}
			LocalDateTime ngayDat = LocalDateTime.parse(hd.getNgayDat().substring(0, hd.getNgayDat().length()-5), dateTimeFormatter);
			LocalDateTime ngayTra = LocalDateTime.parse(hd.getNgayTra().substring(0, hd.getNgayTra().length()-5), dateTimeFormatter);
			long chechLech = Duration.between(ngayDat, ngayTra).toMinutes();
			double gio = (double) Math.round((chechLech / 60) * 100) /100;
			double thanhTien = gio * p.getGiaPhong();
			data[index][0] = soHD;
			data[index][1] = maKH;
			data[index][2] = p.getSoPhong();
			data[index][3] = (int)gio + "";
			data[index][4] = getFormattedMoney(thanhTien) + "đ";
			data[index][5] = hd.getGhiChu();
			index++;
		}
		defaultTableModel.setDataVector(data, collums);
		tableHoaDon.setModel(defaultTableModel);
		this.add(scrollPane);
	}
	
	public void Xem(QuanLyHoaDonView quanLyHoaDonView) {
		String soPhong = "";
		soPhong = textField_1.getText();
		if(soPhong.equals("")) {
			JOptionPane.showMessageDialog(quanLyHoaDonView, "Bạn phải nhập số phòng!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;

		}
		Phong phong = phongDao.SelectPhongByID(soPhong);
		if(phong == null) {
			JOptionPane.showMessageDialog(quanLyHoaDonView, "Phòng chưa đặt hoặc không đúng!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		} else {
			
			KhachHang kh = khachHangDao.SelectKhachHangByID(phong.getMaKH());
			if(kh != null) {
				String maKH;
				if(kh.getMaKH() < 10) {
					maKH = "KH0" + kh.getMaKH();
				} else {
					maKH = "KH" + kh.getMaKH();
				}
				textField_2.setText(maKH);
				textField_3.setText(kh.getTenKH());
				textField_4.setText(phong.getNgayDat().substring(0, phong.getNgayDat().length()-5));
				try {
					String timeTemp = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Calendar.getInstance().getTime());
					textField_5.setText(timeTemp);
				} catch (Exception e) {
					// TODO: handle exception
				}
			} else {
				JOptionPane.showMessageDialog(quanLyHoaDonView, "Phòng chưa được đặt!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
		}
		
	}
	
	private String getDatimeFormat(String str) {
		String[] temp = str.split(" ");
		String ngay = temp[0];
		String[] tempNgay = ngay.split("-");
		
		String ngayThangNam = tempNgay[2] + "/" + tempNgay[1] +"/" + tempNgay[0];
		String thoiDiem = temp[1].substring(0, 5);
		return thoiDiem + " - " + ngayThangNam;
	}
	
	public void ThemHoaDon(QuanLyHoaDonView quanLyHoaDonView) {
		String ngayTra = "";
		ngayTra = textField_5.getText();
		
		String soPhong = "";
		soPhong = textField_1.getText();
		if(soPhong.equals("")) {
			JOptionPane.showMessageDialog(quanLyHoaDonView, "Bạn phải nhập số phòng!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;

		}
		if(ngayTra.equals("")) {
			JOptionPane.showMessageDialog(quanLyHoaDonView, "Bạn phải nhập ngày trả!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		Phong phong = phongDao.SelectPhongByID(soPhong);
		if(phong == null) {
			JOptionPane.showMessageDialog(quanLyHoaDonView, "Phòng chưa đặt hoặc không đúng!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		try {
			LocalDateTime ngayTraTest = LocalDateTime.parse(textField_5.getText(), dateTimeFormatter);
		} catch (DateTimeParseException e) {
			JOptionPane.showMessageDialog(quanLyHoaDonView, "Ngày nhập phải đúng định dạnh yyyy-MM-dd HH:mm", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		KhachHang kh = khachHangDao.SelectKhachHangByID(phong.getMaKH());
		LocalDateTime ngayDat = LocalDateTime.parse(phong.getNgayDat().substring(0, phong.getNgayDat().length()-5), dateTimeFormatter);
		LocalDateTime ngayTra1 = LocalDateTime.parse(textField_5.getText(), dateTimeFormatter);
		long chechLech = Duration.between(ngayDat, ngayTra1).toMinutes();
		double gio = (double) Math.round((chechLech/60) * 100) /100;
		String ghiChu = "";
		ghiChu = textField_6.getText();
		HoaDon hd = new HoaDon(0, soPhong, kh.getMaKH(), phong.getNgayDat() ,textField_5.getText(), gio*phong.getGiaPhong(),ghiChu);
		if(hoaDonDao.InsertHoaDon(hd) != 0) {
			JOptionPane.showMessageDialog(quanLyHoaDonView, "Thêm hóa đơn thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
			dshd = hoaDonDao.SelectAllHoaDon();
			HienThiData(dshd);
		}
		
	}
	
	public void TimKiem() {
		String soHD = "";
//		soHD = textField.getText();
		int sohd= 0;
		if(soHD.length() > 1) {
			try {
				sohd = Integer.parseInt(soHD.substring(2,soHD.length()));
			} catch (NumberFormatException e) {
				
			}
		}
		ArrayList<HoaDon> dshd1 = new ArrayList<HoaDon>();
		dshd1 = hoaDonDao.SelectHoaDonByIDSoPhong(sohd, textField_1.getText().trim());
		if(dshd1.size() > 0) {
			HienThiData(dshd1);
		} else {
			dshd1 = hoaDonDao.SelectAllHoaDon();
			HienThiData(dshd1);
		}
	}
	
	public void InHoaDon(QuanLyHoaDonView quanLyHoaDonView) {
		int r = tableHoaDon.getSelectedRow();
		if(r < 0) {
			JOptionPane.showMessageDialog(quanLyHoaDonView, "Bạn phải chọn 1 hóa đơn!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		} else {
			String[][] duLieuTruyen = {
					{data[r][0], data[r][1], data[r][2], data[r][3], getNormalMonney(data[r][4]), data[r][5]},
			};
			InHoaDonView inHoaDonView = new InHoaDonView(duLieuTruyen);
			inHoaDonView.setLocationRelativeTo(null);
		}
		
	}
	
}

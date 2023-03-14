package view;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.InHoaDonController;
import dao.HoaDonDao;
import dao.KhachHangDao;
import dao.PhongDao;
import model.HoaDon;
import model.KhachHang;
import model.Phong;


public class InHoaDonView  extends JFrame{
	private JPanel contentPane;
	private JLabel lblTenKH;
	private JLabel lblMaKH;
	private JLabel lblNgaySinh;
	private JLabel lblSDT;
	private JTable tableHoaDon;
	private String[][] data;
	private String[] collum = { "Mã HD", "Số phòng", "Ngày đặt", "Ngày trả", "Tổng số giờ", "Thành tiền"};
	private JLabel lblTongThanhToan;
	private JScrollPane scrollPane;
	private KhachHangDao khachHangDao;
	private PhongDao phongDao;
	private HoaDonDao hoaDonDao;
	DefaultTableModel defaultTableModel;
	private JLabel lblTongThue;
	public InHoaDonView(String[][] dt) {
		khachHangDao = new KhachHangDao();
		phongDao = new PhongDao();
		hoaDonDao = new HoaDonDao();
		defaultTableModel = new DefaultTableModel();
		data = dt;
		this.Unit();
	}
	
	public void Unit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Thông tin hóa đơn");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(230, 23, 204, 36);
		contentPane.add(lblNewLabel);
		
		lblTenKH = new JLabel("Tên khách hàng: Nguyễn Văn Quang");
		lblTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTenKH.setBounds(30, 108, 300, 20);
		contentPane.add(lblTenKH);
		
		lblMaKH = new JLabel("Mã KH: K01");
		lblMaKH.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaKH.setBounds(30, 150, 300, 20);
		contentPane.add(lblMaKH);
		
		lblNgaySinh = new JLabel("Ngày sinh: 13/04/2002");
		lblNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNgaySinh.setBounds(460, 108, 175, 20);
		contentPane.add(lblNgaySinh);
		
		lblSDT = new JLabel("SDT: 0967817936");
		lblSDT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSDT.setBounds(460, 150, 175, 20);
		contentPane.add(lblSDT);
		
		tableHoaDon = new JTable();
		tableHoaDon.setBorder(new LineBorder(new Color(208, 208, 208)));
		tableHoaDon.setForeground(new Color(0, 0, 0));
		tableHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		tableHoaDon.setRowHeight(30);
		
		scrollPane = new JScrollPane(tableHoaDon);
		scrollPane.setBounds(20, 230, 650, 53);
		scrollPane.getViewport().setBackground(Color.WHITE);
		contentPane.add(scrollPane);
		
		JButton btnInHoaDon = new JButton("In hóa đơn");
		btnInHoaDon.setBounds(118, 481, 90, 35);
		btnInHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnInHoaDon.setBackground(new Color(146, 255, 146));
		btnInHoaDon.setBorderPainted(false);
		btnInHoaDon.setFocusPainted(false);
		btnInHoaDon.setContentAreaFilled(false);
		btnInHoaDon.setOpaque(true);
		btnInHoaDon.setMargin(new Insets(10, 10, 10, 10));
		contentPane.add(btnInHoaDon);
		
		InHoaDonController inHoaDonController = new InHoaDonController(this);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setBounds(418, 481, 80, 35);
		btnHuy.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnHuy.setBackground(new Color(240, 216, 216));
		btnHuy.setBorderPainted(false);
		btnHuy.setFocusPainted(false);
		btnHuy.setContentAreaFilled(false);
		btnHuy.setOpaque(true);
		btnHuy.setMargin(new Insets(10, 10, 10, 10));
		contentPane.add(btnHuy);
		
		
		lblTongThue = new JLabel("Tổng thanh toán: 2.000.000đ");
		lblTongThue.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTongThue.setBounds(340, 330, 274, 30);
		contentPane.add(lblTongThue);
		
		lblTongThanhToan = new JLabel("Tổng thanh toán: 2.000.000đ");
		lblTongThanhToan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTongThanhToan.setBounds(340, 380, 274, 30);
		contentPane.add(lblTongThanhToan);
		HienThi();
		
		btnHuy.addActionListener(inHoaDonController);
		btnInHoaDon.addActionListener(inHoaDonController);
		
		this.setVisible(true);
	}
	
	public void HienThi() {
		int maKH = Integer.parseInt(data[0][1].substring(2,data[0][1].length()));
		int maHD = Integer.parseInt(data[0][0].substring(2,data[0][0].length()));
		HoaDon hoaDon = hoaDonDao.SelectHoaDonByID(maHD);
		Phong phong = phongDao.SelectPhongByID(data[0][2]);
		KhachHang kh = khachHangDao.SelectKhachHangByID(maKH);
		lblTenKH.setText("Tên khách hàng: " + kh.getTenKH());
		lblNgaySinh.setText("Ngày sinh: " + getNgaySinhFormat(kh.getNgaySinh()));
		lblMaKH.setText("Mã KH: " + data[0][1]);
		lblSDT.setText("SĐT: " + kh.getSDT());
		String[][] data1 = {
				{data[0][0], phong.getSoPhong(), getDatimeFormat(hoaDon.getNgayDat()), getDatimeFormat(hoaDon.getNgayTra()), data[0][3], getFormattedMoney(Double.parseDouble(data[0][4])) + "đ"},
		};
		double thanhTien = Double.parseDouble(data[0][4]);
		double thue = thanhTien * 0.1;
		lblTongThue.setText("Thuế VAT 10%: " + getFormattedMoney(thue) + "đ");
		lblTongThanhToan.setText("Tổng thanh toán: " + getFormattedMoney(thanhTien + thue) + "đ");
		defaultTableModel.setDataVector(data1, collum);
		tableHoaDon.setModel(defaultTableModel);
		this.add(scrollPane);
	}
	
	private String getNgaySinhFormat(String str) {
		String[] tempNgay = str.split("-");
		
		String ngayThangNam = tempNgay[2] + "/" + tempNgay[1] +"/" + tempNgay[0];
		return ngayThangNam;
	}
	
	private String getDatimeFormat(String str) {
		String[] temp = str.split(" ");
		String ngay = temp[0];
		String[] tempNgay = ngay.split("-");
		
		String ngayThangNam = tempNgay[2] + "/" + tempNgay[1] +"/" + tempNgay[0];
		String thoiDiem = temp[1].substring(0, 5);
		return thoiDiem + " - " + ngayThangNam;
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
	
	public void InHoaDon(InHoaDonView inHoaDonView) {
		Phong phong = phongDao.SelectPhongByID(data[0][2]);
		phong.setTinhTrang("Trống");
		phong.setNgayDat("");
		
		phongDao.UpdatePhong(phong);
		int mahd = Integer.parseInt(data[0][0].substring(2,data[0][0].length()));
		hoaDonDao.CapNhatGhiChu(mahd);
			
		this.dispose();
		JOptionPane.showMessageDialog(inHoaDonView, "In thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		QuanLyHoaDonView.hienThiDataFromOtherFrame();
	}
	
	public void Huy() {
		this.dispose();
	}
	
	

}

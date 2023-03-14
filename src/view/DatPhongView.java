package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import controller.DatPhongController;
import dao.KhachHangDao;
import dao.PhongDao;
import model.KhachHang;
import model.Phong;

public class DatPhongView extends JFrame {
	private JPanel contentPane;
	private JLabel lblSoPhong, lblGiaPhong, lblNgayDat;
	
	private DatPhongController datPhongController;
	public JTextField tfTenKH, tfNgaySinh, tfCCCD, tfDiaChi, tfSDT;
	public JRadioButton rdbNam, rdbNu;
	public ButtonGroup bgNamNu;
	
	private Phong phong;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatPhongView frame = new DatPhongView();
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
	public DatPhongView() {
		
	}
	
	public DatPhongView(Phong phong1) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		this.phong = phong1;
		System.out.println(phong.getSoPhong());
		setContentPane(contentPane);
		
		datPhongController = new DatPhongController(this);
		
		JLabel lblNewLabel = new JLabel("Đặt phòng");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(230, 23, 204, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin khách hàng");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(65, 99, 200, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Thông tin phòng");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(461, 99, 174, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tên KH");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(23, 156, 70, 20);
		contentPane.add(lblNewLabel_2);
		
		tfTenKH = new JTextField();
		tfTenKH.setBackground(new Color(233, 250, 247));
		tfTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tfTenKH.setBounds(103, 156, 155, 19);
		contentPane.add(tfTenKH);
		tfTenKH.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ngày sinh");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(23, 195, 70, 20);
		contentPane.add(lblNewLabel_2_1);
		
		tfNgaySinh = new JTextField("dd/mm/yyyy");
		tfNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tfNgaySinh.setColumns(10);
		tfNgaySinh.setBackground(new Color(233, 250, 247));
		tfNgaySinh.setBounds(103, 195, 155, 19);
		contentPane.add(tfNgaySinh);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Giới tính");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(23, 242, 60, 20);
		contentPane.add(lblNewLabel_1_1_1);
		
		rdbNam = new JRadioButton("Nam");
		rdbNam.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbNam.setBounds(101, 242, 70, 21);
		rdbNam.setBackground(Color.WHITE);
		contentPane.add(rdbNam);
		
		rdbNu = new JRadioButton("Nữ");
		rdbNu.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbNu.setBackground(Color.WHITE);
		rdbNu.setBounds(173, 242, 70, 21);
		contentPane.add(rdbNu);
		
		bgNamNu = new ButtonGroup();
		bgNamNu.add(rdbNam);
		bgNamNu.add(rdbNu);		
		bgNamNu.setSelected(rdbNam.getModel(), rootPaneCheckingEnabled);
		
		tfCCCD = new JTextField();
		tfCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tfCCCD.setColumns(10);
		tfCCCD.setBackground(new Color(233, 250, 247));
		tfCCCD.setBounds(103, 292, 155, 19);
		contentPane.add(tfCCCD);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("CCCD");
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2_1_1.setBounds(23, 292, 70, 20);
		contentPane.add(lblNewLabel_2_1_1);
		
		tfDiaChi = new JTextField();
		tfDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tfDiaChi.setColumns(10);
		tfDiaChi.setBackground(new Color(233, 250, 247));
		tfDiaChi.setBounds(103, 338, 155, 19);
		contentPane.add(tfDiaChi);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Địa chỉ");
		lblNewLabel_2_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2_1_1_1.setBounds(23, 338, 70, 20);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		tfSDT = new JTextField();
		tfSDT.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tfSDT.setColumns(10);
		tfSDT.setBackground(new Color(233, 250, 247));
		tfSDT.setBounds(103, 384, 155, 19);
		contentPane.add(tfSDT);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("SĐT");
		lblNewLabel_2_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2_1_1_2.setBounds(23, 384, 70, 20);
		contentPane.add(lblNewLabel_2_1_1_2);
		
		lblSoPhong = new JLabel("Số phòng: 101");
		lblSoPhong.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblSoPhong.setBounds(397, 150, 174, 25);
		contentPane.add(lblSoPhong);
		
		lblGiaPhong = new JLabel("Giá: 120.000đ/ giờ");
		lblGiaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblGiaPhong.setBounds(397, 190, 174, 25);
		contentPane.add(lblGiaPhong);
		
		lblNgayDat = new JLabel("Ngày đặt: 20:00 - 23/02/2023");
		lblNgayDat.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNgayDat.setBounds(397, 232, 174, 25);
		contentPane.add(lblNgayDat);
		
		JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setBounds(168, 500, 90, 35);
		btnXacNhan.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnXacNhan.setBackground(new Color(146, 255, 146));
		btnXacNhan.setBorderPainted(false);
		btnXacNhan.setFocusPainted(false);
		btnXacNhan.setContentAreaFilled(false);
		btnXacNhan.setOpaque(true);
		btnXacNhan.setMargin(new Insets(10, 10, 10, 10));
		contentPane.add(btnXacNhan);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setBounds(418, 500, 80, 35);
		btnHuy.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnHuy.setBackground(new Color(240, 216, 216));
		btnHuy.setBorderPainted(false);
		btnHuy.setFocusPainted(false);
		btnHuy.setContentAreaFilled(false);
		btnHuy.setOpaque(true);
		btnHuy.setMargin(new Insets(10, 10, 10, 10));
		contentPane.add(btnHuy);
				
		tfNgaySinh.addMouseListener(datPhongController);
		btnXacNhan.addActionListener(datPhongController);
		btnHuy.addActionListener(datPhongController);
		hienThiThongTinPhong(phong);
	}
	
	private void hienThiThongTinPhong(Phong phong) {
		System.out.println(phong.toString());
		
		lblSoPhong.setText("Số phòng: " + phong.getSoPhong());
		lblGiaPhong.setText("Giá: " + String.format("%, .0f", phong.getGiaPhong()) + "đ/ giờ");
		
		String timeTemp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		phong.setNgayDat(timeTemp);
		
		String[] temp = phong.getNgayDat().split(" ");
		String ngay = temp[0];
		String[] tempNgay = ngay.split("-");
		
		String ngayThangNam = tempNgay[2] + "/" + tempNgay[1] +"/" + tempNgay[0];
		String thoiDiem = temp[1].substring(0, 5);
		lblNgayDat.setText("Ngày đặt: " + thoiDiem + " - " + ngayThangNam);
	}
	
	public void XacNhan(int res) {
		if (res == 0) {
			JOptionPane.showMessageDialog(this, "Có lỗi, vui lòng kiểm tra lại kết nối hoặc dữ liệu", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}
	
	public void alertInput() {
		JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void alertInput2() {
		JOptionPane.showMessageDialog(this, "Ngày sinh phải có định dạng dd/MM/yyyy", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public String getReverseDate(String date) {
		String[] temp = date.split("/");
		return temp[2] + "-" + temp[1] + "-" + temp[0];
	}
	
	public void updatePhong(KhachHang khachHang, int res) {
		if (res == 0) return;
		int maKhach = KhachHangDao.getInstance().SelectKhachHangByCCCD(khachHang.getCCCD()).getMaKH();
		int result = PhongDao.getInstance().update(phong, maKhach);
		dispose();
		if (result == 0) JOptionPane.showMessageDialog(this, "Có lỗi, đặt phòng không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		else JOptionPane.showMessageDialog(this, "Đặt phòng thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		QuanLyPhong.getInstance().loadBang();
	}
}

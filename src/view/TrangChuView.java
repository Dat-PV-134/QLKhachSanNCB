package view;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.TrangChuController;

public class TrangChuView extends JFrame {
	private static TrangChuView trangChuViewInstance = null;
	
	private JPanel contentPane;
	private ActionListener actionListener;
	public JButton btnQuanLyPhong, btnQuanLyNhanVien, btnThongTinKhachHang, btnQuanLyHoaDon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChuView frame = new TrangChuView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static TrangChuView getInstance() {
		if (trangChuViewInstance == null) {
			trangChuViewInstance = new TrangChuView();
		}
		
		return trangChuViewInstance; 
	}

	/**
	 * Create the frame.
	 */
	private TrangChuView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);

		setContentPane(contentPane);
		
		actionListener = new TrangChuController(this);
		
		JLabel lblNewLabel = new JLabel("NCB hotel management");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 34));
		lblNewLabel.setBounds(244, 74, 500, 50);
		contentPane.add(lblNewLabel);
		
		btnQuanLyPhong = new JButton("Quản lý phòng");
		btnQuanLyPhong.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnQuanLyPhong.setBackground(new Color(233, 250, 247));
		btnQuanLyPhong.setBorderPainted(false);
		btnQuanLyPhong.setBorder(new LineBorder(new Color(208, 208, 208)));
		btnQuanLyPhong.setFocusPainted(false);
		btnQuanLyPhong.setContentAreaFilled(false);
		btnQuanLyPhong.setOpaque(true);
		btnQuanLyPhong.setMargin(new Insets(10, 10, 10, 10));
		btnQuanLyPhong.setBounds(125, 223, 250, 100);
		btnQuanLyPhong.addActionListener(actionListener);
		contentPane.add(btnQuanLyPhong);
		
		btnQuanLyNhanVien = new JButton("Quản lý nhân viên");
		btnQuanLyNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnQuanLyNhanVien.setBackground(new Color(233, 250, 247));
		btnQuanLyNhanVien.setBorderPainted(false);
		btnQuanLyNhanVien.setBorder(new LineBorder(new Color(208, 208, 208)));
		btnQuanLyNhanVien.setFocusPainted(false);
		btnQuanLyNhanVien.setContentAreaFilled(false);
		btnQuanLyNhanVien.setOpaque(true);
		btnQuanLyNhanVien.setMargin(new Insets(10, 10, 10, 10));
		btnQuanLyNhanVien.setBounds(603, 223, 250, 100);
		btnQuanLyNhanVien.addActionListener(actionListener);
		contentPane.add(btnQuanLyNhanVien);
		
		btnThongTinKhachHang = new JButton("Thông tin khách hàng");
		btnThongTinKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnThongTinKhachHang.setBackground(new Color(233, 250, 247));
		btnThongTinKhachHang.setBorderPainted(false);
		btnThongTinKhachHang.setBorder(new LineBorder(new Color(208, 208, 208)));
		btnThongTinKhachHang.setFocusPainted(false);
		btnThongTinKhachHang.setContentAreaFilled(false);
		btnThongTinKhachHang.setOpaque(true);
		btnThongTinKhachHang.setMargin(new Insets(10, 10, 10, 10));
		btnThongTinKhachHang.setBounds(125, 420, 250, 100);
		btnThongTinKhachHang.addActionListener(actionListener);
		contentPane.add(btnThongTinKhachHang);
		
		btnQuanLyHoaDon = new JButton("Quản lý hóa đơn");
		btnQuanLyHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnQuanLyHoaDon.setBackground(new Color(233, 250, 247));
		btnQuanLyHoaDon.setBorderPainted(false);
		btnQuanLyHoaDon.setBorder(new LineBorder(new Color(208, 208, 208)));
		btnQuanLyHoaDon.setFocusPainted(false);
		btnQuanLyHoaDon.setContentAreaFilled(false);
		btnQuanLyHoaDon.setOpaque(true);
		btnQuanLyHoaDon.setMargin(new Insets(10, 10, 10, 10));
		btnQuanLyHoaDon.setBounds(603, 420, 250, 100);
		btnQuanLyHoaDon.addActionListener(actionListener);
		contentPane.add(btnQuanLyHoaDon);	
	}
}

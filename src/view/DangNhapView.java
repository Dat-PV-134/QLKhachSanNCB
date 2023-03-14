package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.DangNhapController;
import controller.NhanVienController;
import dao.TaiKhoanDao;
import model.TaiKhoan;

public class DangNhapView extends JFrame {
	Action action = new DangNhapController(this);
	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JPasswordField txtMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhapView frame = new DangNhapView();
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
	public DangNhapView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		setLocationRelativeTo(null);
		setBackground(Color.white);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("NCB hotel");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(280, 100, 120, 40);
		contentPane.add(lblNewLabel);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBackground(new Color(233, 250, 247));
		txtTaiKhoan.setBounds(211, 215, 262, 35);
		contentPane.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setBackground(new Color(233, 250, 247));
		txtMatKhau.setBounds(211, 310, 262, 35);
		contentPane.add(txtMatKhau);
		txtMatKhau.setColumns(10);
		
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(action);
		btnDangNhap.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnDangNhap.setBackground(new Color(225, 232, 230));
		btnDangNhap.setBorderPainted(false);
		btnDangNhap.setBorder(new LineBorder(new Color(208, 208, 208)));
		btnDangNhap.setFocusPainted(false);
		btnDangNhap.setContentAreaFilled(false);
		btnDangNhap.setOpaque(true);
		btnDangNhap.setMargin(new Insets(10, 10, 10, 10));
		btnDangNhap.setBounds(280, 400, 100, 40);
		contentPane.add(btnDangNhap);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(211, 280, 100, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tài khoản");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(211, 185, 100, 20);
		contentPane.add(lblNewLabel_1_1_1);
	}

	public void dangNhap() {
		// TODO Auto-generated method stub
		if(txtTaiKhoan.getText().isEmpty() || txtMatKhau.getText().isEmpty()) {
			JOptionPane.showMessageDialog(rootPane, "Bạn không được để trống tài khoản mật khẩu", "Thông báo" , JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		ArrayList<TaiKhoan> dstk = TaiKhoanDao.getInstance().SelectAll();
		for(TaiKhoan tk : dstk) {
			if(txtTaiKhoan.getText().compareTo(tk.getTenTK()) == 0 && txtMatKhau.getText().compareTo(tk.getMatKhau()) == 0) {
				//JOptionPane.showMessageDialog(rootPane, "Bạn đã đăng nhập thành công", "Thông báo" , JOptionPane.INFORMATION_MESSAGE);
				JFrame frame = TrangChuView.getInstance();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(rootPane, "Tài khoản và mật khẩu không đúng", "Thông báo" , JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}

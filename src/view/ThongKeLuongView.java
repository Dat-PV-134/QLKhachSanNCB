package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

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
import javax.swing.text.Document;

import controller.ThongKeLuongController;
import dao.NhanVienDao;
import model.NhanVien;

public class ThongKeLuongView extends JFrame {
	
	private ActionListener actionListener;
	ArrayList<NhanVien> dsnv;
	String [][] data;
	String [] collumName =  {
			"Mã NV", "Tên NV", "Ca làm", "Lương", "Số ngày nghỉ", "Thành tiền"
		};
	private JPanel contentPane;
	private DefaultTableModel defaultTableModel;
	private JTable tableThongKeLuong;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKeLuongView frame = new ThongKeLuongView();
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
	public ThongKeLuongView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		actionListener = new ThongKeLuongController(this);

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Bảng thống kê lương");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(184, 24, 300, 36);
		contentPane.add(lblNewLabel);
		
		tableThongKeLuong = new JTable();
		tableThongKeLuong.setBorder(new LineBorder(new Color(208, 208, 208)));
		tableThongKeLuong.setForeground(new Color(0, 0, 0));
		tableThongKeLuong.setFont(new Font("Times New Roman", Font.PLAIN, 12));		
		tableThongKeLuong.setRowHeight(30);
		defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		tableThongKeLuong.setModel(defaultTableModel);
		scrollPane = new JScrollPane(tableThongKeLuong);
		scrollPane.setBounds(0, 90, 700, 360);
		scrollPane.setBorder(new LineBorder(new Color(208, 208, 208)));
		scrollPane.getViewport().setBackground(Color.WHITE);
		contentPane.add(scrollPane);
		
		JButton btnInThongKe = new JButton("In thống kê");
		btnInThongKe.setBounds(148, 499, 90, 35);
		btnInThongKe.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnInThongKe.setBackground(new Color(146, 255, 146));
		btnInThongKe.setBorderPainted(false);
		btnInThongKe.setFocusPainted(false);
		btnInThongKe.setContentAreaFilled(false);
		btnInThongKe.setOpaque(true);
		btnInThongKe.setMargin(new Insets(10, 10, 10, 10));
		btnInThongKe.addActionListener(actionListener);
		contentPane.add(btnInThongKe);
		HienThiData();
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setBounds(431, 499, 80, 35);
		btnHuy.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnHuy.setBackground(new Color(240, 216, 216));
		btnHuy.setBorderPainted(false);
		btnHuy.setFocusPainted(false);
		btnHuy.setContentAreaFilled(false);
		btnHuy.setOpaque(true);
		btnHuy.addActionListener(actionListener);
		btnHuy.setMargin(new Insets(10, 10, 10, 10));
		contentPane.add(btnHuy);
	}
	
	private String getNormalMonney(String str) {
		String money = "";
		if (str.charAt(str.length()-1) == 'đ' || str.contains(",")) {
			String moneyNoComma = str.substring(0, str.length()-1).replace(",", "");
			Double roomMoney = Double.parseDouble(moneyNoComma);
			money = roomMoney.toString();
		}
		return money;
	}
	
	private String getFormattedMoney(Double money) {
		return String.format("%, .0f", money);
	}
	
	public void HienThiData() {
		dsnv = NhanVienDao.getInstance().SelectAll();
		int n = dsnv.size();
		data = new String[n][7];
		int index = 0;
		for(NhanVien x : dsnv) {
			double luong = x.getLuong() - 100000 * x.getSoNgayNghi();
			data[index][0] = x.getMaNV();
			data[index][1] = x.getTenNV();
			data[index][2] = x.getCaLam();
			data[index][3] = getFormattedMoney(x.getLuong()) + "đ";
			data[index][4] = x.getSoNgayNghi() + "";			
			data[index][5] = getFormattedMoney(luong) + "đ";
			index++;
		}
		
		defaultTableModel.setDataVector(data, collumName);
		tableThongKeLuong.setModel(defaultTableModel);
		
		this.add(scrollPane);
		
	}
	
	public void showMessage(String mess) {
		JOptionPane.showMessageDialog(rootPane, mess, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	}
}

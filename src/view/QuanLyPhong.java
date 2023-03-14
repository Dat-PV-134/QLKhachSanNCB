package view;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Closeable;
import java.util.ArrayList;

import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import database.JDBCUtil;
import model.Phong;

public class QuanLyPhong extends JFrame {
	private static QuanLyPhong view = null;
	
	public static QuanLyPhong getInstance() {
		if (view == null) view = new QuanLyPhong();
		return view;
	}
	
	public static void refresh() {
		if (view != null) {
			view.dispose();
			view = null;
		}
		view = new QuanLyPhong();
		view.setVisible(true);
		view.setLocationRelativeTo(null);
	}
	
	private JTable tableHoaDon;
	final String header[] = { "Số phòng", "Giá phòng(vnđ/giờ)", "Tình trạng", "Mã KH", "Thời gian đặt" };
	final DefaultTableModel tb = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {return false;}
	};

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnThem, btnTim, btnSua, btnXoa, btnQuayLai, btnDatPhong;
	private Phong phong = null;
		
	public QuanLyPhong() {
		addControls();
		loadBang();
		addEvents();
	}

	JDBCUtil cn = new JDBCUtil();
	Connection conn = null;
	private JScrollPane scrollPane;

	@SuppressWarnings("unchecked")
	public void addControls() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);

		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Quản lý phòng");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(384, 23, 204, 36);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(208, 208, 208)));
		panel.setBounds(54, 110, 242, 460);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Số phòng");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(12, 80, 60, 20);
		panel.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField.setBackground(new Color(233, 250, 247));
		textField.setBounds(85, 80, 145, 19);
		panel.add(textField);
		textField.setColumns(10);

		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnThem.setBounds(23, 283, 80, 30);
		btnThem.setBackground(new Color(240, 216, 216));
		btnThem.setBorderPainted(false);
		btnThem.setFocusPainted(false);
		btnThem.setContentAreaFilled(false);
		btnThem.setOpaque(true);
		btnThem.setMargin(new Insets(10, 10, 10, 10));
		panel.add(btnThem);

		btnTim = new JButton("Tìm kiếm");
		btnTim.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnTim.setBounds(140, 348, 80, 30);
		btnTim.setBackground(new Color(240, 216, 216));
		btnTim.setBorderPainted(false);
		btnTim.setFocusPainted(false);
		btnTim.setContentAreaFilled(false);
		btnTim.setOpaque(true);
		btnTim.setMargin(new Insets(10, 10, 10, 10));
		panel.add(btnTim);

		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnSua.setBounds(140, 283, 80, 30);
		btnSua.setBackground(new Color(240, 216, 216));
		btnSua.setBorderPainted(false);
		btnSua.setFocusPainted(false);
		btnSua.setContentAreaFilled(false);
		btnSua.setOpaque(true);
		btnSua.setMargin(new Insets(10, 10, 10, 10));
		panel.add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnXoa.setBounds(23, 348, 80, 30);
		btnXoa.setBackground(new Color(240, 216, 216));
		btnXoa.setBorderPainted(false);
		btnXoa.setFocusPainted(false);
		btnXoa.setContentAreaFilled(false);
		btnXoa.setOpaque(true);
		btnXoa.setMargin(new Insets(10, 10, 10, 10));
		panel.add(btnXoa);

		JLabel lblNewLabel_1_1 = new JLabel("Giá");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(12, 128, 60, 20);
		panel.add(lblNewLabel_1_1);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(233, 250, 247));
		textField_1.setBounds(85, 128, 145, 19);
		panel.add(textField_1);

		btnDatPhong = new JButton("Đặt phòng này");
		btnDatPhong.setBounds(71, 401, 100, 35);
		panel.add(btnDatPhong);
		btnDatPhong.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnDatPhong.setBackground(new Color(146, 255, 146));
		btnDatPhong.setBorderPainted(false);
		btnDatPhong.setFocusPainted(false);
		btnDatPhong.setContentAreaFilled(false);
		btnDatPhong.setOpaque(true);
		btnDatPhong.setMargin(new Insets(10, 10, 10, 10));

		tableHoaDon = new JTable();
		tableHoaDon.setBorder(new LineBorder(new Color(208, 208, 208)));
		tableHoaDon.setForeground(new Color(0, 0, 0));
		tableHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tableHoaDon.setModel(tb);
		tableHoaDon.setRowHeight(25);

		scrollPane = new JScrollPane(tableHoaDon);
		scrollPane.setBounds(350, 110, 585, 460);
		scrollPane.getViewport().setBackground(Color.WHITE);
		contentPane.add(scrollPane);

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
	}

	public void loadBang() {
		System.out.println(1);
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		conn = cn.getConnection();
		String sql = "select * from Phong";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Phong p = new Phong(rs.getString("SoPhong"), rs.getDouble("GiaPhong"), rs.getString("TinhTrang"),
						rs.getInt("MaKH"), rs.getString("NgayDat"));
				dsPhong.add(p);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int index = 0;
		int n = dsPhong.size();
		String[][] data = new String[n][5];
		for (Phong p : dsPhong) {
			data[index][0] = p.getSoPhong();
			data[index][1] = String.format("%, .0f", p.getGiaPhong()) + "đ";
			data[index][2] = p.getTinhTrang() + "";
			data[index][3] = p.getMaKH() == 0 ? "" : p.getMaKH() + "";
			data[index][4] = p.getNgayDat() == null ? "" : getNgayDatFormatted(p.getNgayDat());
			index++;
		}
		tb.setDataVector(data, header);
		tableHoaDon.setModel(tb);
		this.add(scrollPane);
		JDBCUtil.closeConnection(conn);
	}
	
	public static void loadBangFromOtherFrame() {
		view.loadBang();
	}
	
	private String getNgayDatFormatted(String s) {
		String[] temp = s.split(" ");
		String ngay = temp[0];
		String[] tempNgay = ngay.split("-");
		
		String ngayThangNam = tempNgay[2] + "/" + tempNgay[1] +"/" + tempNgay[0];
		String thoiDiem = temp[1].substring(0, 5);
		return thoiDiem + " - " + ngayThangNam;
	}

	public void addEvents() {
		tableHoaDon.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (tableHoaDon.getSelectedRow() >= 0) {
					/* String soPhong = tableHoaDon.getValueAt(tableHoaDon.getSelectedRow(), 0).toString();
					Double giaPhong = Double.parseDouble(tableHoaDon.getValueAt(tableHoaDon.getSelectedRow(), 1).toString());
					String tinhTrang = tableHoaDon.getValueAt(tableHoaDon.getSelectedRow(), 2).toString();
					int maKH = Integer.parseInt(tableHoaDon.getValueAt(tableHoaDon.getSelectedRow(), 3).toString());
					String ngayDat = tableHoaDon.getValueAt(tableHoaDon.getSelectedRow(), 4).toString();
					phong = new Phong(soPhong, giaPhong, tinhTrang, maKH, ngayDat); */
					
					textField.setText(tableHoaDon.getValueAt(tableHoaDon.getSelectedRow(), 0) + "");
					textField_1.setText(tableHoaDon.getValueAt(tableHoaDon.getSelectedRow(), 1) + "");
				}

			}
		});

		// thêm
		btnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				xuLyThem();
			}
		});
		// sửa
		btnSua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				xuLySưa();
			}
		});
		// xóa
		btnXoa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				xuLyXoa();
			}
		});

		// tìm kiếm
		btnTim.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				xuLyTimKiem();
			}
		});
		
		btnQuayLai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TrangChuView.getInstance().setVisible(true);
				dispose();
			}
		});
		
		btnDatPhong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				layRaPhongHienTai();
				if (phong == null || phong.getSoPhong().equals("")) return;
				else {
					if (phong.getTinhTrang().equals("Đã đặt")) {
						 JOptionPane.showMessageDialog(rootPane, "Phòng đã có người đặt", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						 return;
					}
					JFrame frame = new DatPhongView(phong);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				}
			}
		});
	}
	
	private void layRaPhongHienTai() {
		conn = cn.getConnection();
		try {
			if (textField.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Bạn cần nhập số phòng để đặt phòng!");
				loadBang();
			} else {
				String sqlTim = "SELECT SoPhong " + "      ,GiaPhong " + "      ,TinhTrang " + "      ,MaKH "
						+ "      ,NgayDat " + "  FROM Phong" + "  where SoPhong = '" + textField.getText().trim() + "'";
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sqlTim);
				boolean res = rs.next();
				if(!res) {
					JOptionPane.showMessageDialog(this, "Không tồn tại phòng này");
					return;
				}
				phong = new Phong(rs.getString("SoPhong"), rs.getDouble("GiaPhong"), rs.getString("TinhTrang"),
							rs.getInt("MaKH"), rs.getString("NgayDat"));
				}
		} catch (Exception e) {

		} finally {
			JDBCUtil.closeConnection(conn);
		}
		
	}

	private void xuLyTimKiem() {
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		conn = cn.getConnection();
		try {
			if (textField.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Bạn cần nhập số phòng để tìm kiếm!");
				loadBang();
			} else {
				String sqlTim = "SELECT SoPhong " + "      ,GiaPhong " + "      ,TinhTrang " + "      ,MaKH "
						+ "      ,NgayDat " + "  FROM Phong" + "  where SoPhong = '" + textField.getText().trim() + "'";
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sqlTim);
				while (rs.next()) {
					Phong p = new Phong(rs.getString("SoPhong"), rs.getDouble("GiaPhong"), rs.getString("TinhTrang"),
							rs.getInt("MaKH"), rs.getString("NgayDat"));
					dsPhong.add(p);
				}
				conn.close();
				if(dsPhong.size() <= 0) {
					JOptionPane.showMessageDialog(this, "Không tồn tại phòng!");
					loadBang();
					
				} else {
					int index = 0;
					int n = dsPhong.size();
					String[][] data = new String[n][5];
					for (Phong p : dsPhong) {
						data[index][0] = p.getSoPhong();
						data[index][1] = String.format("%, .0f", p.getGiaPhong()) + "đ";
						data[index][2] = p.getTinhTrang() + "";
						data[index][3] = p.getMaKH() == 0 ? "" : p.getMaKH() + "";
						data[index][4] = p.getNgayDat() == null ? "" : getNgayDatFormatted(p.getNgayDat());
						index++;
					}
					tb.setDataVector(data, header);
					tableHoaDon.setModel(tb);
					this.add(scrollPane);
				}

			}
		} catch (Exception e) {

		} finally {
			JDBCUtil.closeConnection(conn);
		}
		
	}

	private void xuLyXoa() {
		int kq = 0;
		conn = cn.getConnection();
		if (textField.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Bạn cần nhập số phòng để xóa");
			return;
		}
		try {
			String sqlXoa = "DELETE FROM Phong WHERE SoPhong = '" + textField.getText().trim() + "'";
			Statement st = conn.createStatement();
			int chk = JOptionPane.showConfirmDialog(this, "Xác nhận xóa phòng " + textField.getText().trim(), "Thông báo!",
					JOptionPane.YES_NO_OPTION);
			if (chk == JOptionPane.YES_OPTION) {
				kq = st.executeUpdate(sqlXoa);
				if(kq > 0) {
					loadBang();
					JOptionPane.showMessageDialog(this, "Xóa thành công!");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					
				}
			}
		} catch (Exception e) {

		} finally {
			JDBCUtil.closeConnection(conn);
		}

	}

	// sửa
	private void xuLySưa() {
		conn = cn.getConnection();
		try {
			if (textField.getText().equals("") || textField_1.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Bạn cần nhập đủ dữ liệu");
			} else {
				Statement st = conn.createStatement();
				String money = textField_1.getText().toString();
				if (money.charAt(money.length()-1) == 'đ' || money.contains(",")) {
					String moneyNoComma = money.substring(0, money.length()-1).replace(",", "");
					Double roomMoney = Double.parseDouble(moneyNoComma);
					money = roomMoney.toString();
				}
				String sqlSua = "UPDATE Phong " + "   SET GiaPhong = " + money + " "
						+ "WHERE SoPhong= '"
						+ textField.getText() + "'";
				int kq = 0;
				kq = st.executeUpdate(sqlSua);
				if (kq > 0) {
					loadBang();
					JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
				}
				st.close();
			}
			conn.close();

		} catch (Exception e) {

		} finally {
			JDBCUtil.closeConnection(conn);
		}

	}

	// thêm
	private void xuLyThem() {
		int kq = 0;
		conn = cn.getConnection();
		try {
			if (textField.getText().equals("") || textField_1.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Bạn cần nhập đủ dữ liệu");
			} else {
				StringBuffer sb = new StringBuffer();
				String sql_ma_phong = "Select SoPhong from Phong where SoPhong = '" + textField.getText() + "'";
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql_ma_phong);
				if (rs.next()) {
					sb.append("Mã phòng đã tồn tại!");
				}
				if (sb.length() > 0) {
					JOptionPane.showMessageDialog(this, sb.toString());
				} else {
					String money = textField_1.getText().toString();
					if (money.charAt(money.length()-1) == 'đ' || money.contains(",")) {
						String moneyNoComma = money.substring(0, money.length()-1).replace(",", "");
						Double roomMoney = Double.parseDouble(moneyNoComma);
						money = roomMoney.toString();
					}
					String sqlThem = "Insert into Phong values('" + textField.getText() + "', " + money
							+ " ,N'Trống',NULL ,NULL)";
					kq = st.executeUpdate(sqlThem);
					if (kq > 0) {
						JOptionPane.showMessageDialog(this, "Thêm mới thành công!");
						loadBang();
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");

					}
				}
				st.close();
				rs.close();
			}
			conn.close();

		} catch (Exception e2) {

		} finally {
			JDBCUtil.closeConnection(conn);
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyPhong frame = new QuanLyPhong();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

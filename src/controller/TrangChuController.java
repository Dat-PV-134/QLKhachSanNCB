package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import view.NhanVienView;
import view.QuanLyHoaDonView;
import view.QuanLyKhachHangView;
import view.QuanLyPhong;
import view.TrangChuView;

public class TrangChuController implements ActionListener {
	private TrangChuView view;

	public TrangChuController(TrangChuView view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		
		if (command.equals("Quản lý phòng")) {
			openQuanLyPhong();
		} else if (command.equals("Quản lý nhân viên")) {
			openQuanLyNhanVien();
		} else if (command.equals("Thông tin khách hàng")) {
			openThongTinKhachHang();
		} else if (command.equals("Quản lý hóa đơn")) {
			openQuanLyHoaDon();
		}
	}

	private void openThongTinKhachHang() {
		JFrame frame = new QuanLyKhachHangView();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		view.setVisible(false);
	}

	private void openQuanLyPhong() {
		QuanLyPhong.refresh();
		QuanLyPhong.getInstance().setVisible(true);
		QuanLyPhong.getInstance().setLocationRelativeTo(null);
		view.setVisible(false);
	}

	private void openQuanLyHoaDon() {
		QuanLyHoaDonView.refresh();
		QuanLyHoaDonView.getInstance().setVisible(true);
		QuanLyHoaDonView.getInstance().setLocationRelativeTo(null);
		view.setVisible(false);
	}

	private void openQuanLyNhanVien() {
		JFrame quanLyNhanVienView = new NhanVienView();
		quanLyNhanVienView.setVisible(true);
		quanLyNhanVienView.setLocationRelativeTo(null);
		view.setVisible(false);
	}
}

package controller;

import java.awt.event.*;

import view.QuanLyHoaDonView;
import view.TrangChuView;
public class QuanLyHoaDonController implements ActionListener{

	
	private QuanLyHoaDonView quanLyHoaDonView;
	
	public QuanLyHoaDonController(QuanLyHoaDonView qlhdv) {
		quanLyHoaDonView = qlhdv;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String giaTri = e.getActionCommand();
		if(giaTri.equals("Lấy thông tin từ số phòng")) {
			quanLyHoaDonView.Xem(quanLyHoaDonView);
		}
		
		if(giaTri.equals("Thêm")) {
			quanLyHoaDonView.ThemHoaDon(quanLyHoaDonView);
		}
		
		if(giaTri.equals("Tìm kiếm")) {
			quanLyHoaDonView.TimKiem();
		}
		
		if(giaTri.equals("In hóa đơn")) {
			quanLyHoaDonView.InHoaDon(quanLyHoaDonView);
		}
		
		if(giaTri.equals("Quay lại")) {
			TrangChuView.getInstance().setVisible(true);
			quanLyHoaDonView.dispose();
		}
	}
}

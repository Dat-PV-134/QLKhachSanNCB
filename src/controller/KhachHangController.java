package controller;

import java.awt.event.*;

import view.QuanLyKhachHangView;
import view.TrangChuView;

public class KhachHangController implements ActionListener, MouseListener {
	
	QuanLyKhachHangView quanLyKhachHangView;
	
	public KhachHangController(QuanLyKhachHangView qlkh) {
		this.quanLyKhachHangView = qlkh;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String giaTri = e.getActionCommand();
		
		if(giaTri.equals("Thêm")) {
			quanLyKhachHangView.ThemKhachHang();
		}
		
		if(giaTri.equals("Sửa")) {
			quanLyKhachHangView.Sua();
		}
		
		if(giaTri.equals("Xóa")) {
			quanLyKhachHangView.Xoa();
		}
		if(giaTri.equals("Tìm kiếm")) {
			quanLyKhachHangView.TimKiem();
		}
		if(giaTri.equals("Quay lại")) {
			TrangChuView.getInstance().setVisible(true);
			quanLyKhachHangView.dispose();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		quanLyKhachHangView.LayDong();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

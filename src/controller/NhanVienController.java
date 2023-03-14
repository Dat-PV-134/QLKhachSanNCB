package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.NhanVienView;
import view.ThongKeLuongView;
import view.TrangChuView;



public class NhanVienController implements Action , MouseListener{
	public NhanVienView view;
	
	public NhanVienController(NhanVienView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cm = e.getActionCommand();
		if(cm.equals("Thêm")) {
			this.view.xoaForm();
			this.view.ThemNhanVien();
		}
		if(cm.equals("Xóa")) {
			this.view.xoaForm();
			this.view.XoaNhanVien();
		}
		if(cm.equals("Tìm kiếm")) {
			this.view.xoaForm();
			this.view.timNhanVien();
		}
		if(cm.equals("Sửa")) {
			this.view.xoaForm();
			this.view.SuaNhanVien();
		}
		if (cm.equals("Thống kê lương")) {
			JFrame frame = new ThongKeLuongView();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		}
		if (cm.equals("Quay lại")) {
			System.out.println(" Ok ");
			JFrame frame = TrangChuView.getInstance();
			frame.setVisible(true);
			this.view.dispose();
		}
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		view.kichTable();
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

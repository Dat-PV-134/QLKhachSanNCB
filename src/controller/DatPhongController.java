package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import dao.KhachHangDao;
import model.KhachHang;
import view.DatPhongView;

public class DatPhongController implements ActionListener, MouseListener {
	private DatPhongView view;
	
	public DatPhongController(DatPhongView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		
		if(command.equals("Xác nhận")) {
			String tenKH = view.tfTenKH.getText();
			String ngaySinhTemp = view.tfNgaySinh.getText().trim();
			String gioiTinh = view.bgNamNu.getSelection() == view.rdbNam.getModel() ? "Nam" : "Nữ";
			System.out.println(gioiTinh);
			String CCCD = view.tfCCCD.getText().trim();
			String diaChi = view.tfDiaChi.getText().trim();
			String SDT = view.tfSDT.getText().trim();
			if (tenKH.equals("") || ngaySinhTemp.equals("dd/mm/yyyy") || gioiTinh.equals("") || CCCD.equals("") || diaChi.equals("") || SDT.equals("")) {
				view.alertInput();
				return;
			}
			try {
				String temp = view.getReverseDate(ngaySinhTemp);
				DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate ngaySinhParse = LocalDate.parse(temp, dateTimeFormatter);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(view, "Ngày nhập phải đúng định dạnh dd/MM/yyyy", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				System.out.println(ex.getMessage());
				return;
			}
			String ngaySinh = view.getReverseDate(view.tfNgaySinh.getText().trim());
			KhachHang khachHang = new KhachHang(1, tenKH, gioiTinh, CCCD, diaChi, SDT, ngaySinh);
			int res = KhachHangDao.getInstance().insertOrUpdate(khachHang);
			view.XacNhan(res);
			view.updatePhong(khachHang, res);
		} else if (command.equals("Hủy")) {
			view.dispose();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		view.tfNgaySinh.setText("");
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
		
	}
}

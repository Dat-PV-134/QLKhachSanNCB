package controller;

import java.awt.event.*;

import view.InHoaDonView;

public class InHoaDonController implements ActionListener{
	
	InHoaDonView inHoaDonView;
	
	public InHoaDonController(InHoaDonView in) {
		this.inHoaDonView = in;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String giaTri = e.getActionCommand();
		if(giaTri.equals("Hủy")) {
			inHoaDonView.Huy();
		}
		
		if(giaTri.equals("In hóa đơn")) {
			inHoaDonView.InHoaDon(inHoaDonView);
		}
	}

}

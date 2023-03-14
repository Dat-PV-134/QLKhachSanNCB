package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ThongKeLuongView;

public class ThongKeLuongController implements ActionListener {
	private ThongKeLuongView view;
	
	public ThongKeLuongController(ThongKeLuongView view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		if (command.equals("In thống kê")) {
			view.showMessage("In thành công");
		} else if (command.equals("Hủy")) {
			view.dispose();
		}
	}
}

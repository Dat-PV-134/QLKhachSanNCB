import javax.swing.JFrame;

import view.DangNhapView;

public class App {
	private static JFrame dangNhapView;
	
	public static void main(String[] args) {
		dangNhapView = new DangNhapView();
		dangNhapView.setVisible(true);
	}
}

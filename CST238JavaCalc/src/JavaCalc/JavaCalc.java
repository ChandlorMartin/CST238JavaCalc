package JavaCalc;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;


public class JavaCalc {

	public static void main(String[] args) {
		JFrame myFrame = new JFrame();
		myFrame.setSize(400, 500);
		myFrame.setTitle("Basic Calculator");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myFrame.add(new CalcIF());
		
		myFrame.setVisible(true);
	}

}

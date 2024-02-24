package JavaCalc;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NumberButton extends JButton {
	protected String m_value;
	protected CalcScreen m_screen;
	
	public NumberButton(int value, CalcScreen screen)
	{
		m_value		= Integer.toString(value);
		m_screen	= screen;

		addActionListener(new buttonAction());
		setText(m_value);

		Dimension maxSize = new Dimension(1000, 1000);
		setMaximumSize(maxSize);
	}
	protected class buttonAction implements ActionListener
	{
		public void actionPerformed(ActionEvent e)		//adds the corresponding number to the calculator's textarea
		{	
			if(m_value.equals("0"))		
				m_screen.addDigit("0");
			if(m_value.equals("1"))
				m_screen.addDigit("1");
			if(m_value.equals("2"))
				m_screen.addDigit("2");
			if(m_value.equals("3"))
				m_screen.addDigit("3");
			if(m_value.equals("4"))
				m_screen.addDigit("4");
			if(m_value.equals("5"))
				m_screen.addDigit("5");
			if(m_value.equals("6"))
				m_screen.addDigit("6");
			if(m_value.equals("7"))
				m_screen.addDigit("7");
			if(m_value.equals("8"))
				m_screen.addDigit("8");
			if(m_value.equals("9"))
				m_screen.addDigit("9");
		}		
	}
}

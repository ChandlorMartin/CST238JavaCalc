package JavaCalc;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class OperatorButton extends JButton {
	protected String 		m_value;
	protected CalcScreen	m_screen;
	
	public OperatorButton(String value, CalcScreen screen)
	{
		m_value		= value;
		m_screen	= screen;

		addActionListener(new buttonAction());
		setText(m_value);
		
		Dimension maxSize = new Dimension(1000, 1000);
		setMaximumSize(maxSize);
	}
	
	protected class buttonAction implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			if(m_value.equals("+"))
			{
				m_screen.setSavedValue(m_screen.getValue()); 	//sets the current text as the saved value
				m_screen.setValue(0);							//reset calc value to 0
				m_screen.setLastOp('+');						//set the saved last ip to +
			}
			
			if(m_value.equals("-"))
			{
				m_screen.setSavedValue(m_screen.getValue()); 	//sets the current text as the saved value
				m_screen.setValue(0);							//reset calc value to 0
				m_screen.setLastOp('-');						//set the saved last ip to -
			}
			
			if(m_value.equals("/"))
			{
				m_screen.setSavedValue(m_screen.getValue()); 	//sets the current text as the saved value
				m_screen.setValue(0);							//reset calc value to 0
				m_screen.setLastOp('/');						//set the saved last ip to /
			}
			
			if(m_value.equals("X"))
			{
				m_screen.setSavedValue(m_screen.getValue()); 	//sets the current text as the saved value
				m_screen.setValue(0);							//reset calc value to 0
				m_screen.setLastOp('X');						//set the saved last ip to X
			}
			
			
			if(m_value.equals("."))
			{
				String first = m_screen.getText();				//get current text
				if(!first.contains("."))						//only add decimal if there is no decimal yet
					m_screen.addDigit(".");
			}
			
			if(m_value.equals("+/-"))
			{
				double result = 0 - m_screen.getValue();		//aquires the inverse of the current value
				m_screen.setValue(result);						//reset calc value to 0
			}
			
			
			if(m_value.equals("="))
			{
				
				double	first	= m_screen.getSavedValue();		//gets the first operand as a double;
				double	second	= m_screen.getValue();			//gets the second operand;
				char	op		= m_screen.getLastOp();			//gets the last operand;
				double	result;									//create result variable
				
				switch(op)
				{
				case '+':
					result = first + second;					//adds the values together
					m_screen.setValue(0);						//clear the current calc text
					m_screen.setValue(result); 					//sets the result
					break;
					
				case '-':
					result = first - second;					//subtracts the values
					m_screen.setValue(0);						//clear the current calc text
					m_screen.setValue(result); 					//sets the result
					break;
					
				case '/':
					result = first / second;					//divides the values
					m_screen.setValue(0);						//clear the current calc text
					m_screen.setValue(result); 					//sets the result
					break;
					
				case 'X':
					result = first * second;					//Multiplies the values
					m_screen.setValue(0);						//clear the current calc text
					m_screen.setValue(result); 					//sets the result
					break;
				}
				
			}
		}

	}
}

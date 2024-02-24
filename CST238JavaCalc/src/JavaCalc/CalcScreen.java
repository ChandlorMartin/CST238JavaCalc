package JavaCalc;

import java.awt.Font;
import javax.swing.JTextField;

public class CalcScreen extends JTextField {

	protected boolean m_resetOnPress = false;
	protected double m_savedValue;
	protected char	 m_lastOp;
	
	public CalcScreen(int width)
	{
		super(width);											//creates textfield with width columns
		setFont(new Font(Font.MONOSPACED, Font.PLAIN, 24));		//set text font to monospaced, plain, and size 24 
		setHorizontalAlignment(JTextField.RIGHT);				//allign the text to the right of the textfield
		setEditable(false);										//make it so people can't type into the textfield
		setText("0");											//set text to 0
		m_savedValue = 0;
		m_lastOp = '=';
	}

	public void addDigit(String digit)
	{
		String text;
		
		if (m_resetOnPress)					//sets text to "0" if m_resetOnPress is true,
			text = "0";
		else								//else sets text to getText()
		{
			text = getText();
		}
		
		m_resetOnPress	= false;			//reset m_resetOnPress to false
		digit 			= text+digit;		//get new digit
		
		setText(digit);						//set the text to digit
	}
	
	
	public double getSavedValue()
	{
		return m_savedValue;	//returns m_savedValue
	}
	
	public void setSavedValue(double value)
	{
		m_savedValue = value;	//sets m_savedValue
	}
	
	public char getLastOp()
	{
		return m_lastOp;		//returns m_lastOp
	}
	
	public void setLastOp(char op)
	{
		m_lastOp = op;		//sets m_lastOp
	}
	
	
	
	public double getValue()
	{
		return new Double(getText());	//returns data from getText() casted as a double 
	}
	
	public void setValue(double value)
	{
		if(value != 0)			//set text to string of value if value isn't equal to 0
			setText(""+value);
		else					//else set the text to 0
			setText("0");

	}
	
	public void setReset()
	{
		m_resetOnPress = true;	//set m_resetOnPress to true
	}
	

}

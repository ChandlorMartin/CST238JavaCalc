package JavaCalc;

import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class CalcIF extends JPanel {
	
	protected CalcScreen		m_screen;
	protected JButton 			m_Clear;
	protected JButton 			m_Inverse;
	protected JButton 			m_Divide;
	protected JButton 			m_Multiply;
	protected JButton 			m_Subtract;
	protected JButton 			m_Add;
	protected JButton 			m_Equal;
	protected JButton 			m_Dot;
	protected GridBagLayout 	m_layout;
	protected NumberButton[] 	m_Numbers;
	protected OperatorButton[]	m_Ops;
	protected JMenu				menu;
	protected JMenuBar 			menuBar; 
	protected JMenuItem 		defaultItem;
	protected JMenuItem 		fireItem;
	protected JMenuItem 		waterItem;
	protected JMenuItem 		electricItem;
	protected double 			m_savedValue 	= 0;
	protected char 				m_lastOp 		= '=';
	
	public CalcIF()
	{
		
		menuBar 		= new JMenuBar();
		menu			= new JMenu("Skins");
		defaultItem		= new JMenuItem("Default");
		fireItem		= new JMenuItem("Fuego");
		waterItem 		= new JMenuItem("Aquamarine");
		electricItem	= new JMenuItem("Electric");
		
		defaultItem.addActionListener(new ColorListener());	//adds actionlistener
		fireItem.addActionListener(new ColorListener());	//adds actionlistener
		waterItem.addActionListener(new ColorListener());	//adds actionlistener
		electricItem.addActionListener(new ColorListener());//adds actionlistener
		
		menu.add(defaultItem);								//adds defaultItem to menu
		menu.add(fireItem);									//adds fireItem to menu
		menu.add(waterItem);								//adds waterItem to menu
		menu.add(electricItem);								//adds electricItem to menu
		menuBar.add(menu);									//adds the menu to menuBar
		
		Dimension maxSize = new Dimension(1000, 1000);		//sets the maximum size for the dimensions to 1000 by 1000
		m_screen = new CalcScreen(10);						//makes m_screen = to a new instance of CalcScreen with an argument of 10
	
		m_Clear = new JButton("C");							//makes m_clear = to a new instance of a button with argument "C"
		m_Clear.setMaximumSize(maxSize);					//set the maximum size to maxSize
		m_Clear.addActionListener(new ClearListener());		//adds an actionListener to m_Clear with argument ClearListener
		
		m_Numbers		= new NumberButton[10];				//creates an instance of NumberButton with 1 button in it.
		m_Numbers[0]	= new NumberButton(0,m_screen);		//creates the button with number 0 and puts it on m_screen
		m_Numbers[1]	= new NumberButton(1,m_screen);		//creates the button with number 1 and puts it on m_screen
		m_Numbers[2] 	= new NumberButton(2,m_screen);		//creates the button with number 2 and puts it on m_screen
		m_Numbers[3] 	= new NumberButton(3,m_screen);		//creates the button with number 3 and puts it on m_screen
		m_Numbers[4] 	= new NumberButton(4,m_screen);		//creates the button with number 4 and puts it on m_screen
		m_Numbers[5] 	= new NumberButton(5,m_screen);		//creates the button with number 5 and puts it on m_screen
		m_Numbers[6] 	= new NumberButton(6,m_screen);		//creates the button with number 6 and puts it on m_screen
		m_Numbers[7] 	= new NumberButton(7,m_screen);		//creates the button with number 7 and puts it on m_screen
		m_Numbers[8] 	= new NumberButton(8,m_screen);		//creates the button with number 8 and puts it on m_screen
		m_Numbers[9] 	= new NumberButton(9,m_screen);		//creates the button with number 9 and puts it on m_screen
		
		m_Ops		= new OperatorButton[7];				//create array of OperatorButton
		m_Ops[0]	= new OperatorButton("+/-", m_screen);	//creates the button with string +/- and m_screen
		m_Ops[1]	= new OperatorButton("/", m_screen);	//creates the button with string / and m_screen
		m_Ops[2]	= new OperatorButton("X", m_screen);	//creates the button with string X and m_screen
		m_Ops[3]	= new OperatorButton("-", m_screen);	//creates the button with string - and m_screen
		m_Ops[4]	= new OperatorButton("+", m_screen);	//creates the button with string + and m_screen
		m_Ops[5]	= new OperatorButton("=", m_screen);	//creates the button with string = and m_screen
		m_Ops[6]	= new OperatorButton(".", m_screen);	//creates the button with string . and m_screen
	
		m_layout = new GridBagLayout();						//creates an instance of GridBadLayout
		setLayout(m_layout);								//sets the layout for m_Screen
	
		GridBagConstraints c = new GridBagConstraints();	//creates instance of GridBagConstraints
	
		c.gridx = 0;										//the x coordinate of the leading cell of text area grid
		c.gridy = 0;										//the y coordinate of the leading cell of text area grid
		c.gridwidth = 4;									//makes the grid 4 cells wide
		c.fill = GridBagConstraints.HORIZONTAL;				//stretched the columns horizontally to fit the screen
		add(menuBar, c);									//adds the menuBar at the top of the window
		
		c.gridx = 0; 										//the x coordinate of the leading cell of text area grid
		c.gridy = 1;										//the y coordinate of the leading cell of text area grid
		add(m_screen, c);									//adds m_screen across the the width of the window at y=1
	
		
		c.gridx = 0; 										//set x coordinate of the leading cell of button
		c.gridy = 2;										//set y coordinate of the leading cell of button
		c.gridwidth = 1;									//make grid 1 cell wide
		c.fill = GridBagConstraints.BOTH;					//fill entire grid 
		c.weightx = .5;										//set x weight to 0.5
		c.weighty = .5;										//set y weight to 0.5
		add(m_Clear, c);									//adds button in position 0,2
		
		c.gridx = 1; 										//set x coordinate of the leading cell of button
		c.gridy = 2;										//set y coordinate of the leading cell of button
		add(m_Ops[0], c);									//adds button in position 1,2
		
		c.gridx = 2; 										//set x coordinate of the leading cell of button
		c.gridy = 2;										//set y coordinate of the leading cell of button
		add(m_Ops[1], c);									//adds button in position 2,2
	
		c.gridx = 3; 										//set x coordinate of the leading cell of button
		c.gridy = 2;										//set y coordinate of the leading cell of button
		add(m_Ops[2], c);									//adds button in position 3,2
		
		c.gridx = 0;										//set x coordinate of the leading cell of button
		c.gridy = 3;										//set y coordinate of the leading cell of button
		add(m_Numbers[7], c);								//adds button in position 0,3
		
		c.gridx = 1;										//set x coordinate of the leading cell of button
		c.gridy = 3;										//set y coordinate of the leading cell of button
		add(m_Numbers[8], c);								//adds button in position 1,3
		
		c.gridx = 2;										//set x coordinate of the leading cell of button
		c.gridy = 3;										//set y coordinate of the leading cell of button
		add(m_Numbers[9], c);								//adds button in position 2,3
		
		c.gridx = 3;										//set x coordinate of the leading cell of button
		c.gridy = 3;										//set y coordinate of the leading cell of button
		add(m_Ops[3], c);									//adds button in position 3,3
		
		c.gridx = 0;										//set x coordinate of the leading cell of button
		c.gridy = 4;										//set y coordinate of the leading cell of button
		add(m_Numbers[4], c);								//adds button in position 0,4
		
		c.gridx = 1;										//set x coordinate of the leading cell of button
		c.gridy = 4;										//set y coordinate of the leading cell of button
		add(m_Numbers[5], c);								//adds button in position 1,4
		
		c.gridx = 2;										//set x coordinate of the leading cell of button
		c.gridy = 4;										//set y coordinate of the leading cell of button
		add(m_Numbers[6], c);								//adds button in position 2,4
		
		c.gridx = 3;										//set x coordinate of the leading cell of button
		c.gridy = 4;										//set y coordinate of the leading cell of button
		add(m_Ops[4], c);									//adds button in position 3,4
		
		c.gridx = 0;										//set x coordinate of the leading cell of button
		c.gridy = 5;										//set y coordinate of the leading cell of button
		add(m_Numbers[1], c);								//adds button in position 0,5
		
		c.gridx = 1;										//set x coordinate of the leading cell of button
		c.gridy = 5;										//set y coordinate of the leading cell of button
		add(m_Numbers[2], c);								//adds button in position 1,5
		
		c.gridx = 2;										//set x coordinate of the leading cell of button
		c.gridy = 5;										//set y coordinate of the leading cell of button
		add(m_Numbers[3], c);								//adds button in position 2,5
		
		c.gridx = 3;										//set x coordinate of the leading cell of button
		c.gridy = 5;										//set y coordinate of the leading cell of button
		add(m_Ops[5], c);									//adds button in position 3,5
		
		c.gridx = 0;										//set x coordinate of the leading cell of button
		c.gridy = 6;										//set y coordinate of the leading cell of button
		c.gridwidth = 2;									//set the gridwith to 2 cells for 0 button
		add(m_Numbers[0], c);								//adds button in position 0,6
		
		c.gridx = 2;										//set x coordinate of the leading cell of button
		c.gridy = 6;										//set y coordinate of the leading cell of button
		add(m_Ops[6], c);									//adds button in position 2,6
		
		
		//set default colors
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setForeground(Color.BLACK);
		menu.setBackground(Color.LIGHT_GRAY);
		menu.setForeground(Color.BLACK);		
		defaultItem.setBackground(Color.LIGHT_GRAY);
		defaultItem.setForeground(Color.BLACK);
		fireItem.setBackground(Color.LIGHT_GRAY);
		fireItem.setForeground(Color.BLACK);
		waterItem.setBackground(Color.LIGHT_GRAY);
		waterItem.setForeground(Color.BLACK);
		electricItem.setBackground(Color.LIGHT_GRAY);
		electricItem.setForeground(Color.BLACK);
		m_screen.setBackground(Color.WHITE);
		m_screen.setForeground(Color.BLACK);
		for(int i=0; i<7; i++)
		{	
			m_Ops[i].setBackground(Color.LIGHT_GRAY);
			m_Ops[i].setForeground(Color.BLACK);
		}
		
		for(int a=0; a<=9; a++)
		{
			m_Numbers[a].setBackground(Color.LIGHT_GRAY);
			m_Numbers[a].setForeground(Color.BLACK);
		}
		
		m_Clear.setBackground(Color.LIGHT_GRAY);
		m_Clear.setForeground(Color.BLACK);
	
	}
	
	protected class ColorListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == defaultItem)		//set color options to default
			{
				menuBar.setBackground(Color.LIGHT_GRAY);
				menuBar.setForeground(Color.BLACK);
				menu.setBackground(Color.LIGHT_GRAY);
				menu.setForeground(Color.BLACK);		
				defaultItem.setBackground(Color.LIGHT_GRAY);
				defaultItem.setForeground(Color.BLACK);
				fireItem.setBackground(Color.LIGHT_GRAY);
				fireItem.setForeground(Color.BLACK);
				waterItem.setBackground(Color.LIGHT_GRAY);
				waterItem.setForeground(Color.BLACK);
				electricItem.setBackground(Color.LIGHT_GRAY);
				electricItem.setForeground(Color.BLACK);
				m_screen.setBackground(Color.WHITE);
				m_screen.setForeground(Color.BLACK);
				
				for(int i=0; i<7; i++)
				{	
					m_Ops[i].setBackground(Color.LIGHT_GRAY);
					m_Ops[i].setForeground(Color.BLACK);
				}
				
				for(int a=0; a<=9; a++)
				{
					m_Numbers[a].setBackground(Color.LIGHT_GRAY);
					m_Numbers[a].setForeground(Color.BLACK);
				}
				
				m_Clear.setBackground(Color.LIGHT_GRAY);
				m_Clear.setForeground(Color.BLACK);
			}
			
			if(e.getSource() == fireItem)		//set color options to fire
			{
				menuBar.setBackground(Color.RED);
				menuBar.setForeground(Color.YELLOW);
				menu.setBackground(Color.RED);
				menu.setForeground(Color.YELLOW);		
				defaultItem.setBackground(Color.RED);
				defaultItem.setForeground(Color.YELLOW);
				fireItem.setBackground(Color.RED);
				fireItem.setForeground(Color.YELLOW);
				waterItem.setBackground(Color.RED);
				waterItem.setForeground(Color.YELLOW);
				electricItem.setBackground(Color.RED);
				electricItem.setForeground(Color.YELLOW);
				m_screen.setBackground(Color.PINK);
				m_screen.setForeground(Color.BLACK);
				
				for(int i=0; i<7; i++)
				{	
					m_Ops[i].setBackground(Color.RED);
					m_Ops[i].setForeground(Color.YELLOW);
				}
				
				for(int a=0; a<=9; a++)
				{
					m_Numbers[a].setBackground(Color.RED);
					m_Numbers[a].setForeground(Color.YELLOW);
				}
				
				m_Clear.setBackground(Color.RED);
				m_Clear.setForeground(Color.YELLOW);
			}
			
			if(e.getSource() == waterItem)		//set color options to water
			{
				menuBar.setBackground(Color.BLUE);
				menuBar.setForeground(Color.GREEN);
				menu.setBackground(Color.BLUE);
				menu.setForeground(Color.GREEN);		
				defaultItem.setBackground(Color.BLUE);
				defaultItem.setForeground(Color.GREEN);
				fireItem.setBackground(Color.BLUE);
				fireItem.setForeground(Color.GREEN);
				waterItem.setBackground(Color.BLUE);
				waterItem.setForeground(Color.GREEN);
				electricItem.setBackground(Color.BLUE);
				electricItem.setForeground(Color.GREEN);
				m_screen.setBackground(Color.magenta);
				m_screen.setForeground(Color.BLACK);
				
				for(int i=0; i<7; i++)
				{	
					m_Ops[i].setBackground(Color.BLUE);
					m_Ops[i].setForeground(Color.GREEN);
				}
				
				for(int a=0; a<=9; a++)
				{
					m_Numbers[a].setBackground(Color.BLUE);
					m_Numbers[a].setForeground(Color.GREEN);
				}
				
				m_Clear.setBackground(Color.BLUE);
				m_Clear.setForeground(Color.GREEN);
			}
			
			if(e.getSource() == electricItem)		//set color options to electric
			{
				menuBar.setBackground(Color.YELLOW);
				menuBar.setForeground(Color.BLACK);
				menu.setBackground(Color.YELLOW);
				menu.setForeground(Color.BLACK);		
				defaultItem.setBackground(Color.YELLOW);
				defaultItem.setForeground(Color.BLACK);
				fireItem.setBackground(Color.YELLOW);
				fireItem.setForeground(Color.BLACK);
				waterItem.setBackground(Color.YELLOW);
				waterItem.setForeground(Color.BLACK);
				electricItem.setBackground(Color.YELLOW);
				electricItem.setForeground(Color.BLACK);
				m_screen.setBackground(Color.ORANGE);
				m_screen.setForeground(Color.BLACK);
				
				for(int i=0; i<7; i++)
				{	
					m_Ops[i].setBackground(Color.YELLOW);
					m_Ops[i].setForeground(Color.BLACK);
				}
				
				for(int a=0; a<=9; a++)
				{
					m_Numbers[a].setBackground(Color.YELLOW);
					m_Numbers[a].setForeground(Color.BLACK);
				}
				
				m_Clear.setBackground(Color.YELLOW);
				m_Clear.setForeground(Color.BLACK);
			}
		}
	}
	
	protected class ClearListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			m_screen.setValue(0);	//sets the text in the text area to 0
			m_savedValue	= 0;	//sets the variable, m_savedValue, to 0
			m_lastOp		= '=';	// sets char representing the last operation to "="
		}
	}
	
}
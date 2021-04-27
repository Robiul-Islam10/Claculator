import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;

public class Claculator extends JFrame
{
	private JButton n1,n2,n3,n4,n5,n6,n7,n8,n9,n0;
	private JButton eql,pls,mns,mul,div,ptn,bck,off,clr;
	private JTextField display;
	private JPanel panel;
	private double x=0,y=0,res=0,tmp=0;
	private int flag=0;
	
	public Claculator()
	{
		super("My Calculator");
		this.setSize(385,580);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font myFont = new Font("Cambria", Font.ITALIC + Font.BOLD, 30);
		Font myfnt = new Font("Cambria", Font.ITALIC + Font.BOLD, 12);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.PINK);
		
		panel.add(display = new JTextField());
		display.setBounds(10,20,350,90);
		display.setEditable(false);
		
		panel.add(n1 = new JButton("1"));
		n1.setBounds(10,360,80,80);
		n1.setFont(myFont);
		
		panel.add(n2 = new JButton("2"));
		n2.setBounds(100,360,80,80);
		n2.setFont(myFont);
		
		panel.add(n3 = new JButton("3"));
		n3.setBounds(190,360,80,80);
		n3.setFont(myFont);
		
		panel.add(mns = new JButton("-"));
		mns.setBounds(280,360,80,80);
		mns.setFont(myFont);
		
		panel.add(n4 = new JButton("4"));
		n4.setBounds(10,270,80,80);
		n4.setFont(myFont);
		
		panel.add(n5 = new JButton("5"));
		n5.setBounds(100,270,80,80);
		n5.setFont(myFont);
		
		panel.add(n6 = new JButton("6"));
		n6.setBounds(190,270,80,80);
		n6.setFont(myFont);
		
		panel.add(mul = new JButton("*"));
		mul.setBounds(280,270,80,80);
		mul.setFont(myFont);
		
		panel.add(n7 = new JButton("7"));
		n7.setBounds(10,180,80,80);
		n7.setFont(myFont);
		
		panel.add(n8 = new JButton("8"));
		n8.setBounds(100,180,80,80);
		n8.setFont(myFont);
		
		panel.add(n9 = new JButton("9"));
		n9.setBounds(190,180,80,80);
		n9.setFont(myFont);
		
		panel.add(div = new JButton("/"));
		div.setBounds(280,180,80,80);
		div.setFont(myFont);
		
		panel.add(n0 = new JButton("0"));
		n0.setBounds(10,450,80,80);
		n0.setFont(myFont);
		
		panel.add(pls = new JButton("+"));
		pls.setBounds(280,450,80,80);
		pls.setFont(myFont);
		
		panel.add(eql = new JButton("="));
		eql.setBounds(190,450,80,80);
		eql.setFont(myFont);
		
		panel.add(ptn = new JButton("."));
		ptn.setBounds(100,450,80,80);
		ptn.setFont(myFont);
		
		panel.add(bck = new JButton("DELETE"));
		bck.setBounds(280,120,80,50);
		bck.setFont(myfnt);
		
		panel.add(off = new JButton("OFF"));
		off.setBounds(10,120,170,50);
		off.setFont(myFont);
		
		panel.add(clr = new JButton("CLEAR"));
		clr.setBounds(190,120,80,50);
		clr.setFont(myfnt);
		
		this.add(panel);
		
		n0.addActionListener(new buttonListen());
		n1.addActionListener(new buttonListen());
		n2.addActionListener(new buttonListen());
		n3.addActionListener(new buttonListen());
		n4.addActionListener(new buttonListen());
		n5.addActionListener(new buttonListen());
		n6.addActionListener(new buttonListen());
		n7.addActionListener(new buttonListen());
		n8.addActionListener(new buttonListen());
		n9.addActionListener(new buttonListen());
		pls.addActionListener(new operatorListener());
		mns.addActionListener(new operatorListener());
		mul.addActionListener(new operatorListener());
		div.addActionListener(new operatorListener());
		eql.addActionListener(new operatorListener());
		clr.addActionListener(new buttonListen());
		off.addActionListener(new buttonListen());
		ptn.addActionListener(new buttonListen());
		bck.addActionListener(new buttonListen());

	}

	public class buttonListen implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==n0)
			{
				display.setText(display.getText()+"0");
			}
			if(ae.getSource()==n1)
			{
				display.setText(display.getText()+("1"));
			}
			if(ae.getSource()==n2)
			{
				display.setText(display.getText()+("2"));
			}
			if(ae.getSource()==n3)
			{
				display.setText(display.getText()+("3"));
			}
			if(ae.getSource()==n4)
			{
				display.setText(display.getText()+("4"));
			}
			if(ae.getSource()==n5)
			{
				display.setText(display.getText()+("5"));
			}
			if(ae.getSource()==n6)
			{
				display.setText(display.getText()+("6"));
			}
			if(ae.getSource()==n7)
			{
				display.setText(display.getText()+("7"));
			}
			if(ae.getSource()==n8)
			{
				display.setText(display.getText()+("8"));
			}
			if(ae.getSource()==n9)
			{
				display.setText(display.getText()+("9"));
			}
			if(ae.getSource()==ptn)
			{
				display.setText(display.getText()+("."));
			}
			if(ae.getSource()==off)
			{
				System.exit(0);
			}
			if(ae.getSource()==clr)
			{
				display.setText("");
			}
			if(ae.getSource()==bck)
			{
				String s=display.getText();
				display.setText("");
				for(int i=0;i<s.length()-1;i++)
				{
					display.setText(display.getText()+s.charAt(i));
				}
			}        
		}
	}
	public class operatorListener implements ActionListener
	{
		private String operator= display.getText();
		
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==pls)	
			{
				x=Double.parseDouble(display.getText());
				flag=1;
				display.setText("");
			}			
			if(ae.getSource()==mns)
			{
				x=Double.parseDouble(display.getText());
				flag=2;
				display.setText("");
			}
			if(ae.getSource()==mul)
			{
				x=Double.parseDouble(display.getText());
				flag=3;
				display.setText("");
			}
			if(ae.getSource()==div)
			{
				x=Double.parseDouble(display.getText());
				flag=4;
				display.setText("");
			}
			if(ae.getSource()==eql)
			{
				y=Double.parseDouble(display.getText());
				if(flag == 1)
				{
					res = x+y;
				}
				else if(flag == 2)
				{
					res = x-y;
				}
				else if(flag ==3)
				{
					res = x*y;
				}
				else if(flag == 4)
				{
					res = x/y;
				}
				display.setText(""+res);
			}
		}
	}
}
			
			


import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.lang.Math;
public class CALC extends Applet implements ActionListener
{
	int a;
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
	Button z1,z2,z3,z4,z5,z6,z7,z8,z9,z0;
	TextField tf1,tf2;
	Panel p,p1,p3,p4,p5,p6,p7;
	Font f;	
	GridLayout gy;
	int z=0;
	public void init()
	{
		z1=new Button("1");
		z2=new Button("2");
		z3=new Button("3");
		z4=new Button("4");
		z5=new Button("5");
		z6=new Button("6");
		z7=new Button("7");
		z8=new Button("8");
		z9=new Button("9");
		
		
		
		p=new Panel();
		gy=new GridLayout(6,1);
		p.setLayout(gy);
		f=new Font("verdana",Font.ITALIC,25);
		Font f1=new Font("arial",Font.BOLD,12);
	
		p6=new Panel();
		tf2=new TextField(25);
		tf2.setFont(f1);
		p6.add(tf2);
		
		p1=new Panel();
		tf1=new TextField(30);
		tf1.setFont(f);
		p1.add(tf1);
		

		p3=new Panel();
		b1=new Button("+");
		b2=new Button("-");
		b3=new Button("*");
		b9=new Button("");
		b9.setFont(f);
		b3.setFont(f);
		b2.setFont(f);
		b1.setFont(f);
		z3.setFont(f);
		z2.setFont(f);
		z1.setFont(f);
		p3.add(z1);	
		p3.add(z2);	
		p3.add(z3);	
		p3.add(b1);		
		p3.add(b2);	
		p3.add(b3);	
		//p3.add(b9);
		
		
		p4=new Panel();
		b4=new Button(" / ");
		b5=new Button("%");
		b5.setFont(f);
		b4.setFont(f);
		z4.setFont(f);
		z5.setFont(f);
		z6.setFont(f);
		//p4.add(z4);
		p4.add(z4);
		p4.add(z5);
		p4.add(z6);
		p4.add(b4);
		p4.add(b5);
		
		p5=new Panel();
		b8=new Button("   =   ");
		b8.setFont(f);
		z9.setFont(f);
		z8.setFont(f);
		z7.setFont(f);
		p5.add(z7);
		p5.add(z8);
		p5.add(z9);
		p5.add(b8);
		
		
		p7=new Panel();	
		z0=new Button("   0  ");
		b7=new Button("AC");
		b7.setFont(f);
		z0.setFont(f);
		p7.add(z0);	
		p7.add(b7);	

	


		b1.addActionListener(this);	
		b2.addActionListener(this);	
		b3.addActionListener(this);	
		b4.addActionListener(this);	
		b5.addActionListener(this);	
		b7.addActionListener(this);	
		b8.addActionListener(this);	
		b9.addActionListener(this);	
		
		z1.addActionListener(this);	
		z2.addActionListener(this);	
		z3.addActionListener(this);	
		z4.addActionListener(this);	
		z5.addActionListener(this);	
		z6.addActionListener(this);	
		z7.addActionListener(this);	
		z8.addActionListener(this);	
		z9.addActionListener(this);	
		z0.addActionListener(this);	
		

		p.add(p6);		
		p.add(p1);
		p.add(p3);
		p.add(p4);
		p.add(p5);
		p.add(p7);
		add(p);
 		
		tf2.setText("CALCULATOR");
		tf2.setEditable(false);
		}
	double n1,n2,s;
	//Int n11,n22;
	public void actionPerformed(ActionEvent ae)
	{
		
		repaint();
		try{
		Object bb=ae.getSource();
		if(bb==b1)
		{
		n1=Double.parseDouble(tf1.getText());
		z=1;
		tf2.setText(n1+"+");
		tf1.setText("");
		
		}
		else if(bb==b2)
		{
		n1=Double.parseDouble(tf1.getText());
		z=2;
		tf2.setText(n1+"-");
		tf1.setText("");
		}
		else if(bb==b3)
		{
		n1=Double.parseDouble(tf1.getText());
		z=3;
		tf2.setText(n1+"*");
		tf1.setText("");
		}
		else if(bb==b4)
		{
		n1=Double.parseDouble(tf1.getText());
		z=4;
		tf2.setText(n1+"/");
		tf1.setText("");
		}
		else if(bb==b5)
		{
		n1=Double.parseDouble(tf1.getText());
		z=5;
		tf2.setText(n1+"%");
		tf1.setText("");
		}
		else if(bb==b6)
		{
		n1=Double.parseDouble(tf1.getText());
		z=6;
		tf2.setText(n1+"+");
		tf1.setText("");
		}
		else if(bb==b7)
		{
		tf1.setText("");
		tf2.setText("");
		}
		else if(bb==b9)
		{
		tf1.setText("");
		repaint();
		
		
		
		
			
		}
		else if(bb==b8)
		{
		n2=Double.parseDouble(tf1.getText());
		if(z==1)
		{
		tf2.setText(n1+"+"+n2+"=");
		s=n1+n2;
		tf1.setText(String.valueOf(s));
		}
		else if(z==2)					
		{
		tf2.setText(n1+"-"+n2+"=");
		s=n1-n2;
		tf1.setText(String.valueOf(s));
		}
		else if(z==3)
		{
		tf2.setText(n1+"*"+n2+"=");	
		s=n1*n2;
		tf1.setText(String.valueOf(s));
		}
		else if(z==4)
		{
		tf2.setText(n1+"/"+n2+"=");	
		s=n1/n2;
		tf1.setText(String.valueOf(s));
		}
		else if(z==5)
		{
		tf2.setText(n1+"%"+n2+"=");
		s=n1%n2;
		tf1.setText(String.valueOf(s));
		}//else if(z==6)
		//s=Math.pow(n1,n2);
		}
		else if(bb==z1)
		tf1.setText(tf1.getText()+"1");
		else if(bb==z2)
		tf1.setText(tf1.getText()+"2");
		else if(bb==z3)
		tf1.setText(tf1.getText()+"3");
		else if(bb==z4)
		tf1.setText(tf1.getText()+"4");
		else if(bb==z5)
		tf1.setText(tf1.getText()+"5");
		else if(bb==z6)
		tf1.setText(tf1.getText()+"6");
		else if(bb==z7)
		tf1.setText(tf1.getText()+"7");
		else if(bb==z8)
		tf1.setText(tf1.getText()+"8");
		else if(bb==z9)
		tf1.setText(tf1.getText()+"9");
		else if(bb==z0)
		tf1.setText(tf1.getText()+"0");


		showStatus("Calculator is Working");
		}catch(NumberFormatException ne)
		{
		tf1.setText("Invalid Input");
		}catch(ArithmeticException be)
		{
		tf1.setText("Arithmetic Error");
		}

				
	}

	public void paint(Graphics g)
	{
	g.drawLine(0,300,500,300);
	}
}
/*<applet code="CALC" width=500 height=500>
	</applet>*/					
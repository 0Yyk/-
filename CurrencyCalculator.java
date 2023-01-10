package CurrencyCalculator;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Panel;
import java.util.Currency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Control.Control;
import FileUse.FileUse;
import StandardCalculator.StandardCalculator;

public class CurrencyCalculator extends JFrame implements ActionListener {
	JTextField x;//输入方的金额
	JTextField y;//换算方的金额
	String [] tip= {"美元","英镑","欧元","人民币","日元"};
	JComboBox combox1=new JComboBox(tip);//选择第一种货币
	JComboBox combox2=new JComboBox(tip);//选择第二种货币
	JButton change=new JButton("转换");
	JButton goback=new JButton("返回");
	static File F=new File("data1.txt");
	public CurrencyCalculator(String string) {
		super(string);
		Container c = getContentPane(); // 容器
		c.setLayout(new BorderLayout()); // 容器采用边缘布局，分为五个部分
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		x=new JTextField(10);
		y=new JTextField(10);
		change.setPreferredSize(new Dimension(20,20));//控制按钮大小
		c.add("South",goback);
		p1.add("North",x);
		p1.add("South",combox1);
		p2.add("North",y);
		p2.add("South",combox2);
		c.add("West",p1);
		c.add("East",p2);
		c.add("Center",change);
		change.addActionListener(this);
		goback.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭界面
	}
	public void actionPerformed(ActionEvent e) {
			String Command = e.getActionCommand();
			
		if(Command.equals("转换")) {
			try{
				double sum=0;
				String x1=x.getText();
				String y1=y.getText();
				String currency1=(String)combox1.getSelectedItem();
				String currency2=(String)combox2.getSelectedItem();//返回类型不是String,需要一个强转
				FileWriter fw = new FileWriter(F, true);
			     BufferedWriter bw = new BufferedWriter(fw);
				if(currency1.equals("美元")&&currency2.equals("美元"))
				{
					y.setText(x1+"");
					 fw.write(x1+currency1+"----->"+x1+currency2);
			         fw.write('\n');
			         fw.flush();
			         fw.close();
				}
				else if(currency1.equals("美元")&&currency2.equals("人民币"))
				{
					Double X=Double.parseDouble(x1);
					y.setText(6.89*X+"");
					 fw.write(x1+currency1+"----->"+6.89*X+""+currency2);
			         fw.write('\n');
			         fw.flush();
			         fw.close();
				}
				else if(currency1.equals("美元")&&currency2.equals("英镑"))
				{
					Double X=Double.parseDouble(x1);
					y.setText(0.83*X+"");
					 fw.write(x1+currency1+"----->"+0.83*X+""+currency2);
			         fw.write('\n');
			         fw.flush();
			         fw.close();
				}
				else if(currency1.equals("美元")&&currency2.equals("日元"))
				{
					Double X=Double.parseDouble(x1);
					y.setText(131*X+"");
					 fw.write(x1+currency1+"----->"+131*X+""+currency2);
			         fw.write('\n');
			         fw.flush();
			         fw.close();
				}
				else if(currency1.equals("美元")&&currency2.equals("欧元"))
				{
					Double X=Double.parseDouble(x1);
					y.setText(0.95*X+"");
					 fw.write(x1+currency1+"----->"+0.95*X+""+currency2);
			         fw.write('\n');
			         fw.flush();
			         fw.close();
				}
				else if(currency1.equals("英镑")&&currency2.equals("英镑"))
				{
					y.setText(x1+"");
					 fw.write(x1+currency1+"----->"+x1+currency2);
			         fw.write('\n');
			         fw.flush();
			         fw.close();
				}
				else if(currency1.equals("英镑")&&currency2.equals("欧元"))
				{
					Double X=Double.parseDouble(x1);
					y.setText(1.13*X+"");
					fw.write(x1+currency1+"----->"+1.13*X+""+currency2);
			         fw.write('\n');
			         fw.flush();
			         fw.close();
				}
				else if(currency1.equals("英镑")&&currency2.equals("人民币"))
				{
					Double X=Double.parseDouble(x1);
					y.setText(8.26*X+"");
					fw.write(x1+currency1+"----->"+8.26*X+""+currency2);
			         fw.write('\n');
			         fw.flush();
			         fw.close();
				}
				else if(currency1.equals("英镑")&&currency2.equals("日元"))
				{
					Double X=Double.parseDouble(x1);
					y.setText(157*X+"");
					fw.write(x1+currency1+"----->"+157*X+""+currency2);
			         fw.write('\n');
			         fw.flush();
			         fw.close();
				}
				else if(currency1.equals("英镑")&&currency2.equals("美元"))
				{
					Double X=Double.parseDouble(x1);
					y.setText(1.21*X+"");
					fw.write(x1+currency1+"----->"+1.21*X+""+currency2);
			         fw.write('\n');
			         fw.flush();
			         fw.close();
				}
				else if(currency1.equals("欧元")&&currency2.equals("欧元"))
				{
					
					y.setText(x1+"");
					 fw.write(x1+currency1+"----->"+x1+currency2);
			         fw.write('\n');
			         fw.flush();
			         fw.close();
				}
				else if(currency1.equals("欧元")&&currency2.equals("日元"))
				{
					Double X=Double.parseDouble(x1);
					y.setText(139*X+"");
					fw.write(x1+currency1+"----->"+139*X+""+currency2);
			         fw.write('\n');
			         fw.flush();
			         fw.close();
				}
				else if(currency1.equals("欧元")&&currency2.equals("英镑"))
				{
					Double X=Double.parseDouble(x1);
					y.setText(0.88*X+"");
					fw.write(x1+currency1+"----->"+0.88*X+""+currency2);
			         fw.write('\n');
			         fw.flush();
			         fw.close();
				}
				else if(currency1.equals("欧元")&&currency2.equals("美元"))
				{
					Double X=Double.parseDouble(x1);
					y.setText(1.06*X+"");
					fw.write(x1+currency1+"----->"+1.06*X+""+currency2);
			         fw.write('\n');
			         fw.flush();
			         fw.close();
				}
				else if(currency1.equals("欧元")&&currency2.equals("人民币"))
				{
					Double X=Double.parseDouble(x1);
					y.setText(7.3*X+"");
					fw.write(x1+currency1+"----->"+7.3*X+""+currency2);
			         fw.write('\n');
			         fw.flush();
			         fw.close();
				}
				else if(currency1.equals("人民币")&&currency2.equals("人民币"))
				{
					y.setText(x1+"");
					 fw.write(x1+currency1+"----->"+x1+currency2);
			         fw.write('\n');
			         fw.flush();
			         fw.close();
				}
				else if(currency1.equals("人民币")&&currency2.equals("日元"))
				{
					Double X=Double.parseDouble(x1);
					y.setText(19*X+"");
					fw.write(x1+currency1+"----->"+19*X+""+currency2);
			         fw.write('\n');
			         fw.flush();
			         fw.close();
				}
				else if(currency1.equals("人民币")&&currency2.equals("欧元"))
				{
					Double X=Double.parseDouble(x1);
					y.setText(0.14*X+"");
					fw.write(x1+currency1+"----->"+0.14*X+""+currency2);
			         fw.write('\n');
			         fw.flush();
			         fw.close();
				}
				else if(currency1.equals("人民币")&&currency2.equals("美元"))
				{
					Double X=Double.parseDouble(x1);
					y.setText(0.15*X+"");
					fw.write(x1+currency1+"----->"+0.15*X+""+currency2);
			         fw.write('\n');
			         fw.flush();
			         fw.close();
				}
				else if(currency1.equals("人民币")&&currency2.equals("英镑"))
				{
					Double X=Double.parseDouble(x1);
					y.setText(0.12*X+"");
					fw.write(x1+currency1+"----->"+0.12*X+""+currency2);
			         fw.write('\n');
			         fw.flush();
			         fw.close();
				}
				else if(currency1.equals("日元")&&currency2.equals("日元"))
				{
					y.setText(x1+"");
					 fw.write(x1+currency1+"----->"+x1+currency2);
			         fw.write('\n');
			         fw.flush();
			         fw.close();
				}
				else if(currency1.equals("日元")&&currency2.equals("英镑"))
				{
					Double X=Double.parseDouble(x1);
					y.setText(0.006*X+"");
					fw.write(x1+currency1+"----->"+0.006*X+""+currency2);
			         fw.write('\n');
			         fw.flush();
			         fw.close();
				}else if(currency1.equals("日元")&&currency2.equals("人民币"))
				{
					Double X=Double.parseDouble(x1);
					y.setText(0.05*X+"");
					fw.write(x1+currency1+"----->"+0.05*X+""+currency2);
			         fw.write('\n');
			         fw.flush();
			         fw.close();
				}else if(currency1.equals("日元")&&currency2.equals("欧元"))
				{
					Double X=Double.parseDouble(x1);
					y.setText(0.007*X+"");
					fw.write(x1+currency1+"----->"+0.007*X+""+currency2);
			         fw.write('\n');
			         fw.flush();
			         fw.close();
				}
				else if(currency1.equals("日元")&&currency2.equals("美元"))
				{
					Double X=Double.parseDouble(x1);
					y.setText(0.007*X+"");
					fw.write(x1+currency1+"----->"+0.007*X+""+currency2);
			         fw.write('\n');
			         fw.flush();
			         fw.close();
				}
			}catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}
		else if(Command.equals("返回"))
		{
			 Control();
		}
		
	}
	 void Control() {
		 this.dispose();
		 Control x = new Control("菜单");
			x.setSize(400, 100);
			x.setVisible(true);
		
	}
	public static void main(String[] args ) throws IOException
	{
		FileUse f=new FileUse();
		f.FileUse();
		JFrame x = new CurrencyCalculator("货币转换器");
		x.setSize(550, 100);
		x.setVisible(true);
	}
	
	}


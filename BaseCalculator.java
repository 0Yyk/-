package BaseCalculator;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Control.Control;
import FileUse.FileUse;

public class BaseCalculator extends JFrame implements ActionListener,KeyListener{
	JTextField x;//输入方
	JTextField y;//换算方
	String [] tip= {"二","八","十","十六"};
	JComboBox combox1=new JComboBox(tip);//选择第一种进制
	JComboBox combox2=new JComboBox(tip);//选择第二种进制
	JButton change=new JButton("转换");
	JButton goback=new JButton("返回");
	static File F=new File("data1.txt");
	public BaseCalculator(String title) {
		super(title);
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
		change.addActionListener(this);//注册鼠标监听器
		goback.addActionListener(this);
		goback.addKeyListener(this);//为按钮添加键盘监听器
		change.addKeyListener(this);//为按钮添加键盘监听器
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭界面
	}
	public void Change() throws IOException {
		this.setFocusable(true);
		FileWriter fw = new FileWriter(F, true);
		BufferedWriter bw = new BufferedWriter(fw);
		int count=0;
		try {
			String x1=x.getText();
			String y1=y.getText();
			String base1=(String)combox1.getSelectedItem();
			String base2=(String)combox2.getSelectedItem();//返回类型不是String,需要一个强转
		if(base1.equals("二")&&base2.equals("二"))
		{
			char x[]=x1.toCharArray();
			for(int i=0;i<x.length;i++)//判断输入的是否0或1
			{
				if(x[i]=='0'||x[i]=='1')
					count++;
				else 
					break;
			}
			if(count==x.length)
			{
				y.setText(x1);
				 fw.write(base1+"进制:"+x1+"----->"+base2+"进制:"+x1);
		         fw.write('\n');
		         fw.flush();
		         fw.close();
			}				
			else
			JOptionPane.showMessageDialog(null,"请勿输入0和1以外的数","消息提示",JOptionPane.WARNING_MESSAGE);	//消息对话框	
		}
		else if(base1.equals("二")&&base2.equals("八"))
		{
			char x[]=x1.toCharArray();
			for(int i=0;i<x.length;i++)
			{
				if(x[i]=='0'||x[i]=='1')
					count++;
				else 
					break;
			}
			if(count==x.length)
			{
				String help=Integer.toOctalString(Integer.parseInt(x1, 2));//二进制转换为八进制
				y.setText(help);
				fw.write(base1+"进制:"+x1+"----->"+base2+"进制:"+help);
		         fw.write('\n');
		         fw.flush();
		         fw.close();
			}
			else
			JOptionPane.showMessageDialog(null,"请勿输入0和1以外的数","消息提示",JOptionPane.WARNING_MESSAGE);	//消息对话框
		}
		else if(base1.equals("二")&&base2.equals("十"))
		{
			char x[]=x1.toCharArray();
			for(int i=0;i<x.length;i++)
			{
				if(x[i]=='0'||x[i]=='1')
					count++;
				else 
					break;
			}
			if(count==x.length)
			{
				Integer help=Integer.valueOf(x1,2);//二进制转换为十进制
				y.setText(help+"");
				fw.write(base1+"进制:"+x1+"----->"+base2+"进制:"+help+"");
		         fw.write('\n');
		         fw.flush();
		         fw.close();
			}
			else
			JOptionPane.showMessageDialog(null,"请勿输入0和1以外的数","消息提示",JOptionPane.WARNING_MESSAGE);	//消息对话框
		}
		else if(base1.equals("二")&&base2.equals("十六"))
		{
			char x[]=x1.toCharArray();
			for(int i=0;i<x.length;i++)
			{
				if(x[i]=='0'||x[i]=='1')
					count++;
				else 
					break;
			}
			if(count==x.length)
			{
				String help=Integer.toHexString(Integer.parseInt(x1, 2));//二进制转换为十六进制
				y.setText(help);
				fw.write(base1+"进制:"+x1+"----->"+base2+"进制:"+help);
		         fw.write('\n');
		         fw.flush();
		         fw.close();
			}
			else
			JOptionPane.showMessageDialog(null,"请勿输入0和1以外的数","消息提示",JOptionPane.WARNING_MESSAGE);	//消息对话框
		}
		else if(base1.equals("八")&&base2.equals("八"))
		{
			char x[]=x1.toCharArray();
			for(int i=0;i<x.length;i++)
			{
				if(x[i]=='0'||x[i]=='1'||x[i]=='2'||x[i]=='3'||x[i]=='4'||x[i]=='5'||x[i]=='6'||x[i]=='7')
					count++;
				else 
					break;
			}
			if(count==x.length)
			{
				y.setText(x1);
				fw.write(base1+"进制:"+x1+"----->"+base2+"进制:"+x1);
		         fw.write('\n');
		         fw.flush();
		         fw.close();
			}
			else
			JOptionPane.showMessageDialog(null,"请勿输入0~7以外的数","消息提示",JOptionPane.WARNING_MESSAGE);	//消息对话框
		}
		else if(base1.equals("八")&&base2.equals("二"))
		{
			char x[]=x1.toCharArray();
			for(int i=0;i<x.length;i++)
			{
				if(x[i]=='0'||x[i]=='1'||x[i]=='2'||x[i]=='3'||x[i]=='4'||x[i]=='5'||x[i]=='6'||x[i]=='7')
					count++;
				else 
					break;
			}
			if(count==x.length)
			{
				String help=Integer.toBinaryString(Integer.valueOf(x1, 8));//八进制转换为二进制
				y.setText(help);
				fw.write(base1+"进制:"+x1+"----->"+base2+"进制:"+help);
		         fw.write('\n');
		         fw.flush();
		         fw.close();
			}
			else
			JOptionPane.showMessageDialog(null,"请勿输入0~7以外的数","消息提示",JOptionPane.WARNING_MESSAGE);	//消息对话框
		}
		else if(base1.equals("八")&&base2.equals("十"))
		{
			char x[]=x1.toCharArray();
			for(int i=0;i<x.length;i++)
			{
				if(x[i]=='0'||x[i]=='1'||x[i]=='2'||x[i]=='3'||x[i]=='4'||x[i]=='5'||x[i]=='6'||x[i]=='7')
					count++;
				else 
					break;
			}
			if(count==x.length)
			{
				Integer help=Integer.valueOf(x1,8);//八进制转换为十进制
				y.setText(help+"");
				fw.write(base1+"进制:"+x1+"----->"+base2+"进制:"+help);
		         fw.write('\n');
		         fw.flush();
		         fw.close();
			}
			else
			JOptionPane.showMessageDialog(null,"请勿输入0~7以外的数","消息提示",JOptionPane.WARNING_MESSAGE);	//消息对话框
		}
		else if(base1.equals("八")&&base2.equals("十六"))
		{
			char x[]=x1.toCharArray();
			for(int i=0;i<x.length;i++)
			{
				if(x[i]=='0'||x[i]=='1'||x[i]=='2'||x[i]=='3'||x[i]=='4'||x[i]=='5'||x[i]=='6'||x[i]=='7')
					count++;
				else 
					break;
			}
			if(count==x.length)
			{
				String help=Integer.toHexString(Integer.valueOf(x1, 8));
				y.setText(help);
				fw.write(base1+"进制:"+x1+"----->"+base2+"进制:"+help);
		         fw.write('\n');
		         fw.flush();
		         fw.close();
			}
			else
			JOptionPane.showMessageDialog(null,"请勿输入0~7以外的数","消息提示",JOptionPane.WARNING_MESSAGE);	//消息对话框
		}
		else if(base1.equals("十")&&base2.equals("十"))
		{
			char x[]=x1.toCharArray();
			for(int i=0;i<x.length;i++)
			{
				if(x[i]>='0'&&x[i]<='9')
					count++;
				else 
					break;
			}
			if(count==x.length)
			{
				y.setText(x1);
				fw.write(base1+"进制:"+x1+"----->"+base2+"进制:"+x1);
		         fw.write('\n');
		         fw.flush();
		         fw.close();
			}
			else
			JOptionPane.showMessageDialog(null,"请勿输入0~9以外的数","消息提示",JOptionPane.WARNING_MESSAGE);	//消息对话框
		}
		else if(base1.equals("十")&&base2.equals("二"))
		{
			char x[]=x1.toCharArray();
			for(int i=0;i<x.length;i++)
			{
				if(x[i]>='0'&&x[i]<='9')
					count++;
				else 
					break;
			}
			if(count==x.length)
			{
				Integer X=Integer.valueOf(x1);
				String help =Integer.toBinaryString(X);
				y.setText(help);
				fw.write(base1+"进制:"+x1+"----->"+base2+"进制:"+help);
		         fw.write('\n');
		         fw.flush();
		         fw.close();
			}
			else
			JOptionPane.showMessageDialog(null,"请勿输入0~9以外的数","消息提示",JOptionPane.WARNING_MESSAGE);	//消息对话框
		}
		else if(base1.equals("十")&&base2.equals("八"))
		{
			char x[]=x1.toCharArray();
			for(int i=0;i<x.length;i++)
			{
				if(x[i]>='0'&&x[i]<='9')
					count++;
				else 
					break;
			}
			if(count==x.length)
			{
				Integer X=Integer.valueOf(x1);
				String help =Integer.toOctalString(X);
				y.setText(help);
				fw.write(base1+"进制:"+x1+"----->"+base2+"进制:"+help);
		         fw.write('\n');
		         fw.flush();
		         fw.close();
			}
			else
			JOptionPane.showMessageDialog(null,"请勿输入0~9以外的数","消息提示",JOptionPane.WARNING_MESSAGE);	//消息对话框
		}
		else if(base1.equals("十")&&base2.equals("十六"))
		{
			char x[]=x1.toCharArray();
			for(int i=0;i<x.length;i++)
			{
				if(x[i]>='0'&&x[i]<='9')
					count++;
				else 
					break;
			}
			if(count==x.length)
			{
				Integer X=Integer.valueOf(x1);
				String help =Integer.toHexString(X);
				y.setText(help);
				fw.write(base1+"进制:"+x1+"----->"+base2+"进制:"+help);
		         fw.write('\n');
		         fw.flush();
		         fw.close();
			}
			else
			JOptionPane.showMessageDialog(null,"请勿输入0~9以外的数","消息提示",JOptionPane.WARNING_MESSAGE);	//消息对话框
		}
		else if(base1.equals("十六")&&base2.equals("十六"))
		{
			char x[]=x1.toCharArray();
			for(int i=0;i<x.length;i++)
			{
				if((x[i]>='0'&&x[i]<='9')||(x[i]>='A'&&x[i]<='F'))
					count++;
				else 
					break;
			}
			if(count==x.length)
			{
				y.setText(x1);
				fw.write(base1+"进制:"+x1+"----->"+base2+"进制:"+x1);
		         fw.write('\n');
		         fw.flush();
		         fw.close();
			}
			else
			JOptionPane.showMessageDialog(null,"请勿输入0~9以及A~F以外的数","消息提示",JOptionPane.WARNING_MESSAGE);	//消息对话框
		}
		else if(base1.equals("十六")&&base2.equals("二"))
		{
			char x[]=x1.toCharArray();
			for(int i=0;i<x.length;i++)
			{
				if((x[i]>='0'&&x[i]<='9')||(x[i]>='A'&&x[i]<='F'))
					count++;
				else 
					break;
			}
			if(count==x.length)
			{
				String help=Integer.toBinaryString(Integer.valueOf(x1, 16));
				y.setText(help);
				fw.write(base1+"进制:"+x1+"----->"+base2+"进制:"+help);
		         fw.write('\n');
		         fw.flush();
		         fw.close();
			}
			else
			JOptionPane.showMessageDialog(null,"请勿输入0~9以及A~F以外的数","消息提示",JOptionPane.WARNING_MESSAGE);	//消息对话框
		}
		else if(base1.equals("十六")&&base2.equals("八"))
		{
			char x[]=x1.toCharArray();
			for(int i=0;i<x.length;i++)
			{
				if((x[i]>='0'&&x[i]<='9')||(x[i]>='A'&&x[i]<='F'))
					count++;
				else 
					break;
			}
			if(count==x.length)
			{
				String help=Integer.toOctalString(Integer.valueOf(x1, 16));
				y.setText(help);
				fw.write(base1+"进制:"+x1+"----->"+base2+"进制:"+help);
		         fw.write('\n');
		         fw.flush();
		         fw.close();
			}
			else
			JOptionPane.showMessageDialog(null,"请勿输入0~9以及A~F以外的数","消息提示",JOptionPane.WARNING_MESSAGE);	//消息对话框
		}
		else if(base1.equals("十六")&&base2.equals("十"))
		{
			char x[]=x1.toCharArray();
			for(int i=0;i<x.length;i++)
			{
				if((x[i]>='0'&&x[i]<='9')||(x[i]>='A'&&x[i]<='F'))
					count++;
				else 
					break;
			}
			if(count==x.length)
			{
				Integer help=Integer.valueOf(x1,16);
				y.setText(help+"");
				fw.write(base1+"进制:"+x1+"----->"+base2+"进制:"+help);
		         fw.write('\n');
		         fw.flush();
		         fw.close();
			}
			else
			JOptionPane.showMessageDialog(null,"请勿输入0~9以及A~F以外的数","消息提示",JOptionPane.WARNING_MESSAGE);	//消息对话框
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String [] args) throws IOException
	{
		FileUse f=new FileUse();
		f.FileUse();
		JFrame jf2=new BaseCalculator("进制转换");
		jf2.setSize(450, 100);
		jf2.setVisible(true);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int C=e.getKeyCode();
		if(C==27)
		{
			 this.dispose();
			 Control x = new Control("菜单");
				x.setSize(400, 100);
				x.setVisible(true);	
		}
		else if(C==10)
		{
			try {
				Change();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		this.setFocusable(true);
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String Command = e.getActionCommand();// 获取鼠标点击结果
			if(Command.equals("返回"))
			{
				 this.dispose();
				 Control x = new Control("菜单");
					x.setSize(400, 100);
					x.setVisible(true);
			}
			else if(Command.equals("转换"))
			{
				try {
					Change();//进制转换方法
				}
				catch (Exception ex) {
				ex.printStackTrace();
				}
			}
			
		}
	
}

package Control;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import BaseCalculator.BaseCalculator;
import CurrencyCalculator.CurrencyCalculator;
import StandardCalculator.StandardCalculator;

public class Control extends JFrame implements ActionListener  {
	public static void main(String[] args) {
		Control x = new Control("菜单");
		x.setSize(400, 100);
		x.setVisible(true);
	}
	public  Control(String string) {
		super(string);
		Container c = getContentPane(); // 容器
		c.setLayout(new BorderLayout()); // 容器采用边缘布局，分为五个部分
		
		String[] str = { "标准", "进制转换", "货币转换" ,"复杂"};
		JPanel p = new JPanel(); // 面板
		p.setLayout(new GridLayout(1, 4, 15, 15)); // 1行3 列，水平垂直间隔均为15
		for (int k = 0; k < str.length; k++) // 用一个for循环将按钮添加进面板并注册监听器
		{
			JButton b = new JButton(str[k]);
			p.add(b);
			b.addActionListener(this);// 已经在StandardCalculator类中实现了actionPerformed方法，所以直接使用this
		}
		c.add("Center", p);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String Command =e.getActionCommand();
		try {
			
			if(Command.equals("标准"))
			{
				this.dispose();//关闭选择器界面
				JFrame x = new StandardCalculator("计算器");
				x.setSize(450, 700);
				x.setVisible(true);
			}
			else if(Command.equals("货币转换")) {
				this.dispose();
				JFrame x = new CurrencyCalculator("货币转换器");
				x.setSize(550, 100);
				x.setVisible(true);
			}
			else if(Command.equals("进制转换")) {
				this.dispose();
				JFrame jf2=new BaseCalculator("进制转换");
				jf2.setSize(450, 100);
				jf2.setVisible(true);
			}
			else if(Command.equals("复杂"))
			{
				this.dispose();
			}
		}catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
}

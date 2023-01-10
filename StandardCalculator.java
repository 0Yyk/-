package StandardCalculator;
import javax.swing.*;
import Control.Control;
import FileUse.FileUse;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StandardCalculator extends JFrame implements ActionListener,KeyListener {// 实现ActionListener接口，使得按动鼠标左键时生效
	JTextField x; // 文本框
	String preOperater = ""; // 上一次的运算符
	JLabel lab;//历史记录
	double sum = 0; // 运算结果
	static File F=new File("data1.txt");
	public StandardCalculator(String title) {
		super(title);
		System.out.println(F.getAbsolutePath());
		Container c = getContentPane(); // 容器
		c.setLayout(new BorderLayout()); // 容器采用边缘布局，分为五个部分
		x = new JTextField(50);
		x.setPreferredSize(new Dimension(50, 50));// 调节输入文本框
		c.add("North", x);
		String buttoned[] = { "返回", "sqrt", "C", "退格", "cos", "exp", "tan", "log", "倒数", "pow", "%", "/", "7", "8", "9",
				"*", "4", "5", "6", "+", "1", "2", "3", "-", "+/-", "0", ".", "=" };
		JPanel p = new JPanel(); // 面板
		p.setLayout(new GridLayout(7, 4, 15, 15)); // 7行4列，水平垂直间隔均为15
		for (int k = 0; k < buttoned.length; k++) // 用一个for循环将按钮添加进面板并注册监听器
		{
			JButton b = new JButton(buttoned[k]);
			p.add(b);
			b.addActionListener(this);// 已经在StandardCalculator类中实现了actionPerformed方法，所以直接使用this
			b.addKeyListener(this);//为按钮添加键盘监听器
		}
		c.add("Center", p);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭界面
	}

	public void actionPerformed(ActionEvent e) { // ActionListener接口所携带的方法
		String Command = e.getActionCommand();// 获取鼠标点击结果
		try {
			if (Character.isDigit(Command.charAt(0))) {// 如果按钮事件为数字键
				x.setText(x.getText() + Command); // 添加数字
			}
			else if (Command.equals(".")) { // 如果按钮事件为”.”键
				DecimalFraction();
			}

			else if (Command.equals("+/-")) { // 如果按钮事件为”+/-”键"
				NegativeNumber();
			}

			else if (Command.equals("退格")) { // 如果按钮事件为”退格”键
				Backspace();
			}

			else if (Command.equals("=")) { // 如果按钮事件为"=”键
				Results();
			}

			else if (Command.equals("sqrt")) { // 如果按钮事件为"sqrt"键
				Sqrt();
			}

			else if (Command.equals(" log")) { // 如果按钮事件为"1og”键
				Log();
			}

			else if (Command.equals("cos")) { // 如果按钮事件为"cos”键
				Cos();
			}

			else if (Command.equals("tan")) { // 如果按钮事件为”tan”键
				Tan();
			}

			else if (Command.equals("exp")) { // 如果按钮事件为"exp”键
				Exp();
			}

			else if (Command.equals("倒数")) { // 如果按钮事件为”求倒”键"
				Reciprocal();
			}

			else if (Command.equals("C")) { // 如果按钮事件为"C"键
				clear();
			}
			else if (Command.equals("返回")) { // 如果按钮事件为"返回"键
				Control();
			}
			else {
				doOperation(); // 记录运算符和输入的数字
				x.setText("");
				preOperater = Command;
			}
		} catch (Exception ex) {
			sum = 0;
			x.setText("");
			ex.printStackTrace();
		}
	}
	 void Control() {
		 this.dispose();
		 Control x = new Control("菜单");
			x.setSize(400, 100);
			x.setVisible(true);	
	}
	void DecimalFraction() { // 添加小数点
		String s = x.getText();
		if (s.indexOf(".") == -1)// 返回-1即该数字原先没有小数点
			x.setText(s + ".");
		lab=new JLabel(s+".");
	}

	void NegativeNumber() { // 添加负号
		String s = x.getText();
		if (s.indexOf("-") == -1)
			x.setText("-" + x.getText());
	}

	void Backspace() { // 退格
		String s = x.getText();
		if (s.length() > 0)
			x.setText(s.substring(0, s.length() - 1));
	}

	void Results() throws IOException { // 等号，显示计算结果
		doOperation();
		x.setText("" + sum);
		preOperater = "";
	}

	void Sqrt() { // 求该数的平方根
		double m = Double.parseDouble(x.getText());
		if (m < 0)
			x.setText("负数不能开根号");
		else
			x.setText("" + Math.sqrt(m));
	}

	void Log() { // 求该数的自然对数
		double m = Double.parseDouble(x.getText());
		if (m < 0)
			x.setText("负数不能进行自然对数运算");
		else
			x.setText("" + Math.log(m));
	}

	void Cos() { // 求该数的余弦
		double m = Double.parseDouble(x.getText());
		x.setText("" + Math.cos(m));
	}

	void Tan() {// 求该数的正切
		double m = Double.parseDouble(x.getText());
		x.setText("" + Math.tan(m));
	}

	void Exp() { // 求e的m次幂
		double m = Double.parseDouble(x.getText());
		x.setText("" + Math.exp(m));
	}

	void Reciprocal() { // 求倒数
		if (Double.parseDouble(x.getText()) == 0)
		{
			JOptionPane.showMessageDialog(null,"除数不能为0,请重新输入","消息提示",JOptionPane.WARNING_MESSAGE);	//消息对话框
			clear();
		}
		else {
			x.setText(" " + 1 / (Double.parseDouble(x.getText())));
			preOperater = "";
		}
	}

	void clear() { // 清零
		sum = 0;
		x.setText("");
		preOperater = "";
	}
	// 根据记录的运算符将前面记录的结果sum与文本框中的数据进行运算
	void doOperation() throws IOException {
			double m = Double.parseDouble(x.getText());
			if (preOperater.equals(""))
				sum = m;// 将结果与文本框中的数据按照前一个运算符运算
			if (preOperater.equals("+"))
				sum = sum + m;// 加法运算
			if (preOperater.equals("-"))
				sum = sum - m; // 减法运算
			if (preOperater.equals("*"))
				sum = sum * m; // 乘法运算
			if (preOperater.equals("/"))
			{
				if(m==0.0)
				{
					JOptionPane.showMessageDialog(null,"除数不能为0,请重新输入","消息提示",JOptionPane.WARNING_MESSAGE);	//消息对话框
					clear();
				}		
				else
				sum = sum / m; // 除法运算
			}
				
			if (preOperater.equals("%"))
				sum = sum % m; // 求余
			if (preOperater.equals("pow"))// 求幂
			sum=Math.pow(sum, m);
			if(F.exists())
			{
				 FileWriter fw = new FileWriter(F, true);
			     BufferedWriter bw = new BufferedWriter(fw);
		         fw.write("得数"+sum+"");
		         fw.write('\n');
		         fw.flush();
		         fw.close();
			}
			else
			{
				try{
					F.createNewFile();
				}catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("不存在");
			}
		}			
	
	public static void main(String a[]) throws IOException {
		FileUse f=new FileUse();
		f.FileUse();
		JFrame xJF = new StandardCalculator("计算器");
		xJF.setSize(450, 700);
		xJF.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int C=e.getKeyCode();
			if(C==10||C==61)//在键盘的输入中，Enter的值为10
			{
				try {
					Results();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(C==8) {
				 Backspace();
			}
			else if(C==45||C==109) {
				try {
					doOperation();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // 记录运算符和输入的数字
				x.setText("");
				preOperater = "-";
			}
			else if(C==106) {
				try {
					doOperation();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // 记录运算符和输入的数字
				x.setText("");
				preOperater = "*";
			}
			else if(C==107) {
				try {
					doOperation();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // 记录运算符和输入的数字
				x.setText("");
				preOperater = "+";
			}
			else if(C==111) {
				try {
					doOperation();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // 记录运算符和输入的数字
				x.setText("");
				preOperater = "/";
			}
	}//问题：监听时，只能使用一次，例如输入数字时只能输入个位数,输入数字时没有实现键盘快捷键
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}

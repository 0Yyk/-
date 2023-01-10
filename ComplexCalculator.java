package ComplexCalculator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import CurrencyCalculator.CurrencyCalculator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Control.Control;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import FileUse.FileUse;

public class ComplexCalculator extends JFrame implements ActionListener {
	JTextField x;
	static File F = new File("data1.txt");
	public static void main(String[] args) throws IOException {
		FileUse f = new FileUse();
		f.FileUse();
		JFrame jf = new ComplexCalculator("复杂计算器");
		jf.setSize(550, 100);
		jf.setVisible(true);
	}

	public ComplexCalculator(String title) {
		super(title);
		Container c = getContentPane(); // 容器
		c.setLayout(new BorderLayout()); // 容器采用边缘布局，分为五个部分
		x = new JTextField(50);
		x.setPreferredSize(new Dimension(50, 30));// 调节输入文本框
		c.add("North", x);
		String button[] = { "返回", "计算" };
		JPanel p = new JPanel(); // 面板
		p.setLayout(new GridLayout(1, 2, 10, 10));
		for (int k = 0; k < button.length; k++) // 用一个for循环将按钮添加进面板并注册监听器
		{
			JButton b = new JButton(button[k]);
			p.add(b);
			b.addActionListener(this);// 已经在StandardCalculator类中实现了actionPerformed方法，所以直接使用this
		}
		c.add("Center", p);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public static long Calculate(String express) {
		Queue<Integer> queue = new LinkedList<>();//队列存储
		Stack<Integer> numStack = new Stack<>();//数字栈
		Stack<Character> operateStack = new Stack<>();//操作符栈
		operateStack.push('#');//将#放在栈的顶部,作为结束算式结束符
		int num1, num2;
		char[] chars = express.toCharArray();//数组存放
		for (int i = 0; i < chars.length; i++) {
			if (isDigits(chars[i])) {
				queue.offer(chars[i] - '0');//将数字放入队列中
				if(i<chars.length-1)
				{
					int j = i + 1;
					for (; isDigits(chars[j]); j++) {
						queue.offer(chars[j] - '0');
					}
					i = j - 1;
					numStack.push(toNumber(queue));
				}
				else {
					numStack.push(toNumber(queue));
				}
				
			} else if (isOperate(chars[i])) {
				if (comparePriority(operateStack.peek(),chars[i])) {//比较运算符的优先级，peek查看栈的顶部
					i--;
					Character operate = operateStack.pop();//移除栈顶部对象，并返回    12+2*2+1*6
					if (numStack.size() < 2) {//数字不足
						throw new IllegalArgumentException();
					}
					num1 = numStack.pop();
					num2 = numStack.pop();
					numStack.push(calculate(num1, num2, operate));
				} else {
					operateStack.push(chars[i]);//放入运算符
				}
			} 
			 else if (chars[i] == '(') {
					operateStack.push(chars[i]);
				} else if (chars[i] == ')') {
					Character operate = operateStack.pop();//出栈
					while (operate != '(') {
						num1 = numStack.pop();
						num2 = numStack.pop();
						numStack.push(calculate(num1, num2, operate));
						operate = operateStack.pop();
					}//优先计算括号内的式子
				}
			else {
				throw new IllegalArgumentException();
			}
		}
		Character operate = operateStack.pop();
		while (operate != '#') {
			num1 = numStack.pop();
			num2 = numStack.pop();
			numStack.push(calculate(num1, num2, operate));
			operate = operateStack.pop();
		}
		return numStack.pop();
	}
	private static int calculate(int a, int b, char operate) {
		switch (operate) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			return a / b;
		default:
			throw new IllegalArgumentException();
		}
	}

	private static boolean isDigits(char c) {
		return c >= '0' && c <= '9';
	}

	private static boolean isOperate(char c) {
		return c == '+' || c == '-' || c == '/' || c == '*' || c == '#';
	}

	private static boolean comparePriority(char one, char two) {
		if ((one == '*' || one == '/') && (two == '+' || two == '-')) {
			return true;
		}
		return (one == '+' || one == '-') && two == '#';
	}

	private static int toNumber(Queue<Integer> queue) {//将字符转换成数字
		int res = 0;
		for (; !queue.isEmpty();) {
			res = res * 10 + queue.poll();
		}
		return res;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String Command = e.getActionCommand();
		
		if (Command.equals("返回"))
		{
			this.dispose();
			Control x = new Control("菜单");
			x.setSize(300, 100);
			x.setVisible(true);
		} else if (Command.equals("计算")) {
			try {
				long calculator=Calculate(x.getText());
				x.setText(calculator+"");
				if(F.exists())
				{
					 FileWriter fw = new FileWriter(F, true);
				     BufferedWriter bw = new BufferedWriter(fw);
			         fw.write(calculator+"");
			         fw.write('\n');
			         fw.flush();
			         fw.close();
				}
				else
				{
					try{
						F.createNewFile();
					}catch (Exception e1) {
						e1.printStackTrace();
					}
					System.out.println("不存在");
				}
				
			}catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}

	}

}

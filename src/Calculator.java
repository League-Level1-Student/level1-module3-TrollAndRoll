import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener 
{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField dig1 = new JTextField(10);
	JTextField dig2 = new JTextField(10);
	JButton add = new JButton();
	JButton sub = new JButton();
	JButton mul = new JButton();
	JButton div = new JButton();
	JLabel ans = new JLabel();
	int num1 = 0;
	int num2 = 0;
	
	public static void main(String[] args) 
	{
		new Calculator().CalculatorRunner();
	}
	
	private void CalculatorRunner()
	{
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 100);
		frame.setTitle("Simple Calculator");
		add.setText("add");
		sub.setText("sub");
		mul.setText("mul");
		div.setText("div");
		add.addActionListener(this);
		sub.addActionListener(this);
		mul.addActionListener(this);
		div.addActionListener(this);
		
		frame.add(panel);
		panel.add(dig1);
		panel.add(dig2);
		panel.add(add);
		panel.add(sub);
		panel.add(mul);
		panel.add(div);
		panel.add(ans);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		num1 = Integer.parseInt(dig1.getText());
		num2 = Integer.parseInt(dig2.getText());
		
		if (arg0.getSource() == add)
		{
			add();
		}
		else if(arg0.getSource() == sub)
		{
			subtract();
		}
		else if(arg0.getSource() == div)
		{
			divide();
		}
		else
		{
			multiply();
		}
		
	}
	
	void add()
	{
		int answer = num1 + num2;
		ans.setText("" + answer);
	}
	
	void multiply()
	{
		int answer = num1 * num2;
		ans.setText("" + answer);
	}
	
	void subtract()
	{
		int answer = num1 - num2;
		ans.setText("" + answer);
	}
	
	void divide()
	{
		double answer = (double)num1 / num2;
		ans.setText("" + answer);
	}
}
/*
1. In a Calculator class, create methods for add, multiply, subtract, and divide.

2. Create a CalculatorRunner class to test the above methods.

3. Add a Swing UI to the Calculator (see example below), with 2 fields to input numbers, and buttons for each math operation.
*/
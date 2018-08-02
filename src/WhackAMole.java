import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WhackAMole 
{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	Random randy = new Random();
	
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	JButton b4 = new JButton();
	JButton b5 = new JButton();
	JButton b6 = new JButton();
	JButton b7 = new JButton();
	JButton b8 = new JButton();
	JButton b9 = new JButton();
	
	public static void main(String[] args) 
	{
		new WhackAMole().run();
	}
	
	public void run()
	{
		frame.setVisible(true);
		frame.setTitle("Whack a button for Fame and Glory");
		frame.setSize(300, 500);
	}
	
	void drawButtons(Random randy)
	{
		
	}
}

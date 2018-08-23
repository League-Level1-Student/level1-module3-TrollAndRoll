import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jointheleague.graphical.robot.Robot;

public class WhackAMole implements ActionListener 
{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	Random randy = new Random();
	
	int moles = 0;
	boolean found = true;

	public static void main(String[] args) 
	{
		new WhackAMole().run();
	}

	public void run() 
	{
		frame.setVisible(true);
		frame.setTitle("Whack a button for Fame and Glory");
		frame.setSize(300, 300);
		
		while(moles < 10)
		{
			if(found = true)
			{
				drawButtons(randy.nextInt(9));
				found = false;
			}
			
		}
		
		//endGame(0, 10);
	}

	void drawButtons(int hi) 
	{
		for (int i = 0; i < 9; i++) 
		{
			if(i == hi)
			{
				JButton butter = new JButton("mole!");
				butter.setPreferredSize(new Dimension(100, 40));
				butter.addActionListener(this);
				panel.add(butter);
			}
			
			else
			{
				JButton butt = new JButton();
				butt.setPreferredSize(new Dimension(100, 40));
				butt.addActionListener(this);
				panel.add(butt);
			}
		}
		frame.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		JButton pressed = (JButton) arg0.getSource();
		if(pressed.getText().equals("mole!"))
		{
			speak("You Missed!");
		}
		else
		{
			moles = moles + 1;
			frame.dispose();
			found = true;
		}
		
	}
	
	void speak(String words) 
	{
	     try 
	     {
	          Runtime.getRuntime().exec("say " + words).waitFor();
	     } catch (Exception e) 
	     {
	          e.printStackTrace();
	     }
	}
	
	/*
	private void endGame(Date timeAtStart, int molesWhacked) 
	{
	     Date timeAtEnd = new Date();
	     JOptionPane.showMessageDialog(null, "Your whack rate is "
	          + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
	          + " moles per second.");
	}
	*/
}

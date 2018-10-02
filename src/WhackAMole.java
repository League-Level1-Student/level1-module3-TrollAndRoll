import java.applet.AudioClip;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JApplet;
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
	Date boby = new Date();
	
	int mole = 0;
	int moles = 0;
	int missed = 0;
	boolean found = true;

	public static void main(String[] args) 
	{
		new WhackAMole().run();
	}

	public void run() 
	{
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("Whack a button for Fame and Glory");
		frame.setSize(300, 300);
		
		drawButtons(randy.nextInt(9));
//		while(moles < 10)
//		{
//			if(found == true)
//			{
//				
//				frame.add(panel);
//				found= false;
//			}	
//		}	
		//endGame(0, 10);
	}

	void drawButtons(int hi) 
	{
		if(moles < 10)
		{
			mole++;
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
				JButton butt = new JButton("notmole");
				butt.setPreferredSize(new Dimension(100, 40));
				butt.addActionListener(this);
				panel.add(butt);
			}
		}
		frame.add(panel);
		}
		if(moles > 9)
		{
			frame.dispose();
			endGame(boby, mole);
		}
		if(missed >  4)
		{
			frame.dispose();
			endGame(boby, mole);
			JOptionPane.showMessageDialog(null, "YOu lost neerd!!");
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		JButton pressed = (JButton) arg0.getSource();
		if(pressed.getText().equals("mole!"))
		{
			moles = moles + 1;
			playSound("cow");
			panel.removeAll();
			frame.dispose();
			run();
		}
		else
		{
			System.out.println("You Missed!");
			missed++;
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
	
	
	private void endGame(Date timeAtStart, int molesWhacked) 
	{
	     Date timeAtEnd = new Date();
	     JOptionPane.showMessageDialog(null, "Your whack rate is "
	          + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
	          + " moles per second.");
	}
	
	private void playSound(String fileName) {
	     AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
	     sound.play();
	}
	
}

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TypingTutor implements KeyListener 
{
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	char currentLetter;
	
	public static void main(String[] args) 
	{
		new TypingTutor().run();
	}

	void run()
	{
		frame.setVisible(true);
		frame.setTitle("Type or Die");
		frame.setSize(250, 250);
	
		currentLetter = generateRandomLetter();
		
		label.setFont(label.getFont().deriveFont(28.0f));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setText("" + currentLetter);
		frame.add(label);
		frame.addKeyListener(this);
		
		showTypingSpeed(10);
	}
	
	 private void showTypingSpeed(int numberOfCorrectCharactersTyped) 
	 {
	      Date timeAtEnd = new Date();
	      long gameDuration = timeAtEnd.getTime() - timeAtStart.getTime();
	      long gameInSeconds = (gameDuration / 1000) % 60;
	      double charactersPerSecond = ((double) numberOfCorrectCharactersTyped / (double) gameInSeconds);
	      int charactersPerMinute = (int) (charactersPerSecond * 60);
	      JOptionPane.showMessageDialog(null, "Your typing speed is " + charactersPerMinute + " characters per minute.");
	}
	Date timeAtStart = new Date();

	
	private static char generateRandomLetter() 
	{
		Random r = new Random();
	      return (char) (r.nextInt(26) + 'a');
	}

	@Override
	public void keyPressed(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub
		System.out.println("you typed: " + arg0.getKeyChar());
		if(arg0.getKeyChar() == currentLetter)
		{
			System.out.println("correct");
			frame.setBackground(Color.GREEN);
		}
		else
		{
			frame.setBackground(Color.RED);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub
		currentLetter = generateRandomLetter();
		label.setText("" + currentLetter);
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}
}

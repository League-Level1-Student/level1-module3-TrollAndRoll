import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NastySurprise implements ActionListener 
{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton B1 = new JButton();
	JButton B2 = new JButton();
	
	String spoopy = "https://media.tenor.com/images/086c3e78cdf7db4c41313db469046823/tenor.gif";
	String pupper = "http://www.astro.cornell.edu/~derg/style/85852-puppies-cute-funny-puppy.jpg";
	
	public static void main(String[] args) 
	{	
		new NastySurprise().runner();
	}
	
	void runner()
	{		
		B1.setText("Trick");
		B1.setSize(100, 100);
		B1.addActionListener(this);
		B2.setText("Treat");
		B2.setSize(100, 100);
		B2.addActionListener(this);
		
		panel.add(B1);
		panel.add(B2);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
		
	}
	
	private static void showPictureFromTheInternet(String imageUrl) 
	{
	    try {
	         URL url = new URL(imageUrl);
	         Icon icon = new ImageIcon(url);
	         JLabel imageLabel = new JLabel(icon);
	         JFrame frame = new JFrame();
	         frame.add(imageLabel);
	         frame.setVisible(true);
	         frame.pack();
	    	} 
	    catch (MalformedURLException e) 
	    {
	         e.printStackTrace();
	    }
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		if(arg0.getSource() == B1)
		{
			showPictureFromTheInternet(pupper);
		}
		else 
		{
			showPictureFromTheInternet(spoopy);
		}
	}
}
/*
1. Make a user interface that has 2 buttons. One says “Trick” the other says “Treat”.

2. When the user clicks on the Trick button, show them a picture of a cute puppy.

3. When they click Treat, show them a scary image.

To show the pictures, use the showPictureFromTheInternet() method below.
*/
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class nastySurprise 
{
	
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton B1 = new JButton();
		JButton B2 = new JButton();
		
		B1.setText("Trick");
		B1.setSize(100, 100);
		B2.setText("Treat");
		B2.setSize(100, 100);
		
		panel.add(B1);
		panel.add(B2);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
		
	}
	
	private void showPictureFromTheInternet(String imageUrl) 
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
}
/*
1. Make a user interface that has 2 buttons. One says “Trick” the other says “Treat”.

2. When the user clicks on the Trick button, show them a picture of a cute puppy.

3. When they click Treat, show them a scary image.

To show the pictures, use the showPictureFromTheInternet() method below.
*/
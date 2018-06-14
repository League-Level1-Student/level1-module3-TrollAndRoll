
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2018
 *    Level 1
 */


import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.io.IOException;
public class SimonSays extends KeyAdapter 
{
 
 // Complete steps 1 - 7 before you test
 // 1. Make a JFrame variable 
	JFrame hi = new JFrame();
	
	int i;
	
 	HashMap<Integer,String> images = new HashMap<Integer, String>();
 	private int imageIndex;
 	Date timeAtStart = new Date();
 	private  void makeAlbum() 
 	{
 // 2. add 4 images which match keyboard keys like this: images.put(new Integer(KeyEvent.VK_UP), "image.jpg");
 		images.put(new Integer(KeyEvent.VK_UP), "up.jpg");
 		images.put(new Integer(KeyEvent.VK_DOWN), "down.jpg");
 		images.put(new Integer(KeyEvent.VK_RIGHT), "right.jpeg");
 		images.put(new Integer(KeyEvent.VK_LEFT), "left.png");
 // 3. Tell the user to "Press the matching key when 'Simon says' otherwise press a different key"
 		JOptionPane.showMessageDialog(null, "Press the matching key when 'Simon says' otherwise press a different key");
 // 4. call the method to show an image
 		showImage();
 	}
	public void keyPressed(KeyEvent e) 
	{
    	int keyCode = e.getKeyCode();
    	int tries = 0;
    	// 16. make a points variable to track the score. tell the user their score at the end.
    	int points = 0;
    	//17. if the keyCode matches the imageIndex and "Simon says..."  increase their score
    	if(keyCode == imageIndex && i == 1)
    	{
    		points = points + points;
    		speak("You got it!");
    	}
    	//18.   if the keyCode doesn't match the imageIndex and "Simon didn't say..."  increase their score	
    	if(keyCode != imageIndex && i != 1)
    	{
    		points = points + points;
    		speak("Good job!");
    	}
    	else
    	{
    		speak("No! Bannana Bannana Bannana Bannana Bannanas!");
    	}
    	//19. Use the speak method to tell the user if they were correct or not
    	//13. increment tries by 1
    	tries = tries + 1;
    	//14. if tries is greater than 9 (or however many you want)
    	if(tries > 9)
    	{
    	//15.    	exit the program
    		Date timeAtEnd = new Date();
    		System.out.println((timeAtEnd.getTime()-timeAtStart.getTime())/1000);
    		System.exit(0);
    		
    	}
    	//11. dispose of the frame
    	JOptionPane.showMessageDialog(null, "Your Score: " + points + "/9");
    	hi.dispose();
   	
    	//12. call the method to show an image
    	showImage();
	}
	private void showImage() 
	{
    	//5. initialize your frame to a new JFrame()
		
    	//6. set the frame to visible
		hi.setVisible(true);
		hi.add(getNextRandomImage()); //7. rename to the name of your frame
    	
    	// 8. set the size of the frame 
     	hi.setSize(500, 500);
    	// 9. add a key listener to the frame
     	hi.addKeyListener(this);
     	//10. Use the speak method to either say "Simon says press this key" or "Press this key"
     	i = new Random().nextInt(1);
     	if(i == 1)
     	{
     		speak("Simon says press this key");
     	}
     	else 
     	{
     		speak("Press this key");
     	}
    	//Hint: use the simonSays int and a random number
	}
	private Component getNextRandomImage() 
	{
    	this.imageIndex = new Random().nextInt(4) + 37;
    	return loadImage(images.get(imageIndex));
	}
	private JLabel loadImage(String fileName) 
	{
    	URL imageURL = getClass().getResource(fileName);
    	Icon icon = new ImageIcon(imageURL);
    	return new JLabel(icon);
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
	public static void main(String[] args) throws Exception 
	{
	 new SimonSays().makeAlbum();
	}
}

/* 
* 20. add a timer
* ~~~ where the code starts running ~~~
* timeAtStart = new Date();
*
* ~~~ where the code ends ~~~
* Date timeAtEnd = new Date();
* System.out.println((timeAtEnd.getTime()-timeAtStart.getTime())/1000);
* System.exit(0);
*/



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener
{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	
	JButton spin = new JButton();
	
	String orange = "orange.png";
	String cherry = "cherry.png";
	String lime = "lime.png";
	
	public static void main(String[] args)  
	{
		SlotMachine runner = new SlotMachine();	
		runner.run();
	}
	
	private void run()
	{
		spin.addActionListener(this);
		
		label1.setIcon(loadImage(orange));
		label2.setIcon(loadImage(cherry));
		label3.setIcon(loadImage(lime));
		
		spin.setText("Spin");
		spin.setSize(200, 80);
		
		panel.add(spin);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		
		frame.add(panel);
		frame.setVisible(true);
	}
	
	public static ImageIcon loadImage(String fileName)
	{
		try 
		{
			return new ImageIcon(ImageIO.read(new SlotMachine().getClass().getResourceAsStream(fileName)));
		} catch (IOException e) 
		{
			
			return null;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		int reel1 = new Random().nextInt(3)+1;
		int reel2 = new Random().nextInt(3)+1;
		int reel3 = new Random().nextInt(3)+1;
		
		if(reel1 == 1)
		{
			label1.setIcon(loadImage(orange));
		}
		else if(reel1 == 2)
		{
			label1.setIcon(loadImage(cherry));
		}
		else if (reel1 == 3)
		{
			label1.setIcon(loadImage(lime));
		}
		if(reel2 == 1)
		{
			label2.setIcon(loadImage(orange));
		}
		else if(reel2 == 2)
		{
			label2.setIcon(loadImage(cherry));
		}
		else if (reel2 == 3)
		{
			label2.setIcon(loadImage(lime));
		}
		if(reel3 == 1)
		{
			label3.setIcon(loadImage(orange));
		}
		else if(reel3 == 2)
		{
			label3.setIcon(loadImage(cherry));
		}
		else if (reel3 == 3)
		{
			label3.setIcon(loadImage(lime));
		}
		if(reel1 == reel2 && reel1 == reel3)
		{
			JOptionPane.showMessageDialog(null, "You Win!");
		}
	}
}
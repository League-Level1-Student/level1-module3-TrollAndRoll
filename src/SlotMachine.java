import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SlotMachine 
{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	
	JButton spin = new JButton();
	
	String orange = "orange.jpg";
	String cherry = "cherry.png";
	String lime = "lime.png";
	
	public static void main(String[] args) throws Exception
	{
		SlotMachine runner = new SlotMachine();	
		runner.run();
	}
	
	private void run()
	{
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
}
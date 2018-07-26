import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GetLatestTweet implements ActionListener 
{
	//thing
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField box = new JTextField(10);
	JButton boop = new JButton();
	
	public static void main(String[] args) 
	{
		new GetLatestTweet().run();
	}
	
	void run()
	{
		frame.setVisible(true);
		frame.setSize(250, 100);
		frame.setTitle("The Amazing Tweet Retriever");
		boop.setText("Search The Twitterverse");
		boop.addActionListener(this);
		
		panel.add(box);
		panel.add(boop);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}
}

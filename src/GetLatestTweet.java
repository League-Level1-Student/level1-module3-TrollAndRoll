import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class GetLatestTweet implements ActionListener 
{
	//thing
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField box = new JTextField(10);
	JButton boop = new JButton();
	JLabel label = new JLabel();
	
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
		panel.add(label);
		frame.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		System.out.println("Tweet, Tweet");
		
		String search = box.getText();
		System.out.println(getLatestTweet(search));
		label.setText(getLatestTweet(search));
	}
	
	private String getLatestTweet(String searchingFor)
	{

	      Twitter twitter = new TwitterFactory().getInstance();

	      AccessToken accessToken = new AccessToken(
	            "2453751158-IVD2VGZsvwZiRKxNe3Gs2lMjg30nvSkV1xSuPFf",
	            "vBa5PjKfuMTK1LLBG51nCUI9r5d6Ph5cAHrS73spg6Nvu");

	      twitter.setOAuthConsumer("YqeZdD2hYxOKv4QOkmp0i2djN",
	            "6XUB1r8KXBvd8Pk9HHW3NgphMxHvHWBLAr5TihnckMU0ttyGST");

	      twitter.setOAuthAccessToken(accessToken);

	      Query query = new Query(searchingFor);
	      try 
	      {
	            QueryResult result = twitter.search(query);
	            return result.getTweets().get(0).getText();
	      } catch (Exception e) 
	      {
	            System.err.print(e.getMessage());
	            return "What the heck is that?";
	      }
	}
}

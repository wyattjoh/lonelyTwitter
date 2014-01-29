/**
 * 
 */
package ca.ualberta.cs.lonelytwitter.test;

import java.util.Date;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import ca.ualberta.cs.lonelytwitter.TweetSetModel;

/**
 * @author wyatt
 *
 */
public class TweetSetModelTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	/**
	 * 
	 */
	public TweetSetModelTest() {
		super(LonelyTwitterActivity.class);
	}
	
	public void testAddTweet() {
		String text = "text";
		Date date = new Date();
		NormalTweetModel normal = new NormalTweetModel(text, date);
		
		TweetSetModel tweetSetModel = new TweetSetModel();
		
		tweetSetModel.addTweet(normal);
		
		try {
			tweetSetModel.addTweet(normal);
			fail("should've thrown an exception!");
		} catch (IllegalArgumentException expected) {
			// go team!
		}
	}
	
}

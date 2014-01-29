/**
 * 
 */
package ca.ualberta.cs.lonelytwitter;

import java.util.HashSet;

/**
 * @author wyatt
 *
 */
public class TweetSetModel {
	
	private HashSet<LonelyTweetModel> tweets;
	
	/**
	 * 
	 */
	public TweetSetModel() {
		tweets = new HashSet<LonelyTweetModel>();
	}
	
	public int getCount() {
		return tweets.size();
	}
	
	public void addTweet(LonelyTweetModel tweet) throws IllegalArgumentException {
		if (!tweets.contains(tweet)) {
			tweets.add(tweet);
		}
		else {
			throw new IllegalArgumentException();
		}
	}

}

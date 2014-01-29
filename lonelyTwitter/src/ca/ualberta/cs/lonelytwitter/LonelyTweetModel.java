package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class LonelyTweetModel {
	protected String text;
	protected Date timestamp;
	
	abstract public String getText();
	
	public LonelyTweetModel(String text) {
		super();
		this.text = text;
		timestamp = new Date();
	}
	
	public LonelyTweetModel(String text, Date timestamp) {
		super();
		this.text = text;
		this.timestamp = timestamp;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public abstract Date getTimestamp();
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public boolean equals(Object other) {
		if (other == null || !(other instanceof LonelyTweetModel)) {
			return false;
		}

		LonelyTweetModel otherTweet = (LonelyTweetModel) other;
		
		return timestamp.equals(otherTweet.timestamp) && getText().equals(otherTweet.getText());
	}
}
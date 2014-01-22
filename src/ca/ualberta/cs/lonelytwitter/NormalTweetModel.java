package ca.ualberta.cs.lonelytwitter;

public class NormalTweetModel extends LonelyTweetModel {

	public NormalTweetModel(String text) {
		super(text);
	}
	
	public NormalTweetModel() {
		super();
	}

	@Override
	public void setText(String text) {
		
	}
	
	public String toString() {
		return this.getText() + " -- " + this.getTimestamp().toString();
	}
	
	@Override
	public void setImportant(boolean important) throws Exception {
		if (important) {
			throw new IllegalArgumentException();
		}
		this.important = important;
	}


}

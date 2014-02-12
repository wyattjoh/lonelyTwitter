package ca.ualberta.cs.lonelytwitter.test;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;

/*
 * generate this class with new.. JUnit Test Case
 * set superclass to ActivityInstrumentationTestCase2
 */
@SuppressLint("NewApi")
public class LonelyTwitterActivityUITest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	Instrumentation instrumentation;
	Activity activity;
	EditText textInput;
	
	public LonelyTwitterActivityUITest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		instrumentation = getInstrumentation();
		activity = getActivity();

		textInput = ((EditText) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.body));
	}
	
	public void testAddTweet() throws Throwable {
		runTestOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				makeTweet("Hi there! #test");
			}
		});
	}
	
	public void testVerifyListViewAdapterReceived() throws Throwable {
		runTestOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				String testTweetText = "Hi there! #test";
				
				ArrayAdapter<NormalTweetModel> adapter = ((LonelyTwitterActivity) activity).getAdapter();
				
				int preAddCount = adapter.getCount();
				
				makeTweet(testTweetText);
				
				assertEquals("LonelyTwitterActivity adds a new element", preAddCount + 1, adapter.getCount());
			}
		});
	}
	
	public void testVerifyListViewAdapterReceivedSameType() throws Throwable {
		runTestOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				String testTweetText = "Hi there! #test";
				makeTweet(testTweetText);
				
				ArrayAdapter<NormalTweetModel> adapter = ((LonelyTwitterActivity) activity).getAdapter();
				
				NormalTweetModel normalTweetModel = adapter.getItem(adapter.getCount() - 1);
				
				assertTrue("LonelyTwitterActivity adds a new NormalTweetModel", normalTweetModel instanceof NormalTweetModel);
			}
		});
	}
	
	public void testVerifyListViewAdapterReceivedSameText() throws Throwable {
		runTestOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				String testTweetText = "Hi there! #test";
				makeTweet(testTweetText);
				
				ArrayAdapter<NormalTweetModel> adapter = ((LonelyTwitterActivity) activity).getAdapter();
				
				NormalTweetModel normalTweetModel = adapter.getItem(adapter.getCount() - 1);
				
				assertEquals("LonelyTwitterActivity adds a new tweet to adapter", testTweetText, normalTweetModel.getText());
			}
		});
	}
	
	public void testVerifyEmptiedTextView() throws Throwable {
		runTestOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				String testTweetText = "Hi there! #test";
				makeTweet(testTweetText);
				
				String textInputText = textInput.getText().toString();
				
				assertEquals("LonelyTwitterActivity clears EditText after adding Tweet", textInputText, "");
			}
		});
	}
	
	/*
	 * fills in the input text field and clicks the 'save'
	 * button for the activity under test
	 */
	private void makeTweet(String text) {
		assertNotNull(activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save));
		textInput.setText(text);
		((Button) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save)).performClick();
	}
}

/**
 * 
 */
package ca.ualberta.cs.lonelytwitter.test;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;

/**
 * @author wyatt
 *
 */
@SuppressLint("NewApi")
public class IntentReaderActivityTests extends
		ActivityInstrumentationTestCase2<IntentReaderActivity> {

	/**
	 * @param name
	 */
	public IntentReaderActivityTests() {
		super(IntentReaderActivity.class);
	}
	
	public void testSendText() {
		// Create Intent
		Intent intent = new Intent();
		
		// Get new string
		String text = "hello!";
		
		// Add extra meta to the intent with TEXT_KEY key
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		
		// Set intent
		setActivityIntent(intent);
		
		// Start activity
		IntentReaderActivity activity = getActivity();
		
		// Assert that the activity is actually created
		assertNotNull(activity);
		
		// Check that the text is the correct value
		assertEquals("IntentReaderActivity should get text from intent", text, activity.getText());
	}
	
	public void testDoubleText() {
		// Create Intent
		Intent intent = new Intent();
		
		// Get new string
		String text = "hello!";
		
		// Add extra meta to the intent with TEXT_KEY key
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
		
		// Set intent
		setActivityIntent(intent);
		
		// Start activity
		IntentReaderActivity activity = getActivity();
		
		// Assert that the activity is actually created
		assertNotNull(activity);
		
		// Check that the text is the correct value
		assertEquals("IntentReaderActivity should get text from intent", text + text, activity.getText());
	}
	
	public void testReverseText() {
		// Create Intent
		Intent intent = new Intent();
		
		// Set an empty string
		String text = "hello!";
		String reverse_text = "!olleh";
		
		// Add meta
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.REVERSE);
		
		// Set intent
		setActivityIntent(intent);
		
		// Start the activity
		IntentReaderActivity activity = getActivity();
		
		// Asser thtat the activity is there
		assertNotNull(activity);
		
		assertEquals("IntentReaderActivity should contain the reverse of the string", reverse_text, activity.getText());
	}
	
	public void testDefaultText() {
		// Create Intent
		Intent intent = new Intent();
		
		// Get new string
		String text = "";
		
		// Add extra meta to the intent with TEXT_KEY key
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		
		// Set intent
		setActivityIntent(intent);
		
		// Start activity
		IntentReaderActivity activity = getActivity();
		
		// Assert that the activity is actually created
		assertNotNull(activity);
		
		// Check that the text is the correct value
		assertEquals("IntentReaderActivity should get text from intent", IntentReaderActivity.DEFAULT_TEXT, activity.getText());
	}
	
	public void testDisplayText() {
		// Create Intent
		Intent intent = new Intent();
		
		// Get new string
		String text = "hello!";
		
		// Add extra meta to the intent with TEXT_KEY key
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		
		// Set intent
		setActivityIntent(intent);
		
		// Start activity
		IntentReaderActivity activity = getActivity();
		
		// Assert that the activity is actually created
		assertNotNull(activity);
		
		// Find the text view in the view
		TextView textView = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		
		// Check that the tweet text is the text that we expect
		assertEquals("IntentReaderActivity should contain text from intent", textView.getText(), text);
	}
	
	public void testTextViewVisable() {
		// Create Intent
		Intent intent = new Intent();
		
		// Get new string
		String text = "hello!";
		
		// Add extra meta to the intent with TEXT_KEY key
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		
		// Set intent
		setActivityIntent(intent);
		
		// Start activity
		IntentReaderActivity activity = getActivity();
		
		// Assert that the activity is actually created
		assertNotNull(activity);
		
		// Get the root view controller
		View rootView = activity.getWindow().getDecorView();
		
		// Get the text view to verify
		TextView textView = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		
		// Assert that the view is visable on the root view controller
		ViewAsserts.assertOnScreen(rootView, textView);
	}
	
}

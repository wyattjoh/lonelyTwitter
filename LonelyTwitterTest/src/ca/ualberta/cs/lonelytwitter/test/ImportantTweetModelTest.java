/**
 * 
 */
package ca.ualberta.cs.lonelytwitter.test;

import java.util.Date;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.lonelytwitter.ImportantTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;

/**
 * @author wyatt
 *
 */
public class ImportantTweetModelTest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	/**
	 * @param activityClass
	 */
	public ImportantTweetModelTest() {
		super(LonelyTwitterActivity.class);
	}
	
	public void testImportantEquality() {
		Date date = new Date();
		String text = "test";
		ImportantTweetModel important = new ImportantTweetModel(text, date);
		
		assertEquals("Tweet equals self", important, important);
		assertEquals("Tweet equals self 2", important.equals(important), true);
		
		NormalTweetModel normal = new NormalTweetModel(text, date);
		
		assertEquals("Normal tweet model is not a important tweet", normal.equals(important), false);
		
		assertEquals("important tweet model is not a Normal tweet", important.equals(normal), false);
	}
	
	public void testDate() {
		Date date = new Date();
		String text = "test";
		ImportantTweetModel important = new ImportantTweetModel(text, date);
		assertEquals("Date is date", important.getTimestamp(), date);
	}
	
}

/**
 * 
 */
package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import android.test.ActivityInstrumentationTestCase2;

/**
 * @author wyatt
 *
 */
public class LonelyTweetModelTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	/**
	 * @param name
	 */
	public LonelyTweetModelTest() {
		super(LonelyTwitterActivity.class);
	}
	
	public void testFailure() {
		assertEquals("5 should equal 5", 5, 5);
	}

}

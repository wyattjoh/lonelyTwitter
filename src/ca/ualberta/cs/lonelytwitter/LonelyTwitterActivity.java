package ca.ualberta.cs.lonelytwitter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import com.google.gson.Gson;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	
	private ArrayList<NormalTweetModel> tweetModels;
	private ArrayAdapter<NormalTweetModel> tweetModelAdapter;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				addTweet(text);
				clearBox();
				tweetModelAdapter.notifyDataSetChanged();
			}
		});
		
		Button clearbutton = (Button) findViewById(R.id.clear);
		
		clearbutton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				clearBox();
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		tweetModels = loadJSON();
		tweetModelAdapter = new ArrayAdapter<NormalTweetModel>(this,
				R.layout.list_item, tweetModels);
		oldTweetsList.setAdapter(tweetModelAdapter);
	}
	
	private void addTweet(String tweetBody) {
		NormalTweetModel tweetModel = new NormalTweetModel(tweetBody);
		tweetModels.add(0, tweetModel);
		
		saveJSON();
	}
	
	private void clearBox() {
		bodyText = (EditText) findViewById(R.id.body);
		bodyText.setText("");
	}
	
	private void saveJSON() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			
			NormalTweetModel[] tweetArray = (NormalTweetModel[]) tweetModels.toArray(new NormalTweetModel[0]);
			
			Gson gson = new Gson();
			gson.toJson(tweetArray, osw);
			
			osw.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private ArrayList<NormalTweetModel> loadJSON() {
		ArrayList<NormalTweetModel> tweetArrayList = new ArrayList<NormalTweetModel>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			InputStreamReader isr = new InputStreamReader(fis);
			
			NormalTweetModel[] tweetArray = new Gson().fromJson(isr, NormalTweetModel[].class);
			
			isr.close();
			fis.close();
			
			for(int i = 0; i < tweetArray.length; i++) {
				tweetArrayList.add(tweetArray[i]);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tweetArrayList;
	}
}
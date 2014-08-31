package com.Widget.RandomNumber;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;
import android.widget.Toast;

/*
 * Simple widget gives Random Number
 * 
 * @author Patrick Gorman
 * 
 * @version Not Sure
 * 
 * Not even sure what is going on here.
 */

public class SetRange extends Activity {

	private static final Context context = null;
	EditText setRange;
	private int mAppWidgetId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.range);

		// find EditText
		setRange = (EditText) findViewById(R.id.editText);

		// Creating string for empty edit text check
		
		try {
			// checking input
			final String checkInput = setRange.getText().toString();
			if (checkInput.trim().equals("")) {
				Toast.makeText(getApplicationContext(),
						"Please enter integer for random number generator",
						Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(getApplicationContext(),
						("Your chose range from 1 to " + checkInput),
						Toast.LENGTH_SHORT).show();
				// sendToWidget(chekInput);
				// Get range from edit text then make string then parse into
				// long
				@SuppressWarnings("unused")
				long mRange = Long.parseLong(setRange.getText().toString());
				// // Create Intent
				// Intent intent = new Intent(SetRange.this,
				// WidgetService.class);
				// intent.putExtra("range", mRange);
				// startService(intent);

			}
		} catch (NumberFormatException e) {
			Toast.makeText(getApplicationContext(),
					"Please enter only one integer", Toast.LENGTH_SHORT).show();
		}
		// Declare and setup "Enter" button
		Button enterButton = (Button) findViewById(R.id.setR);
		enterButton.setOnClickListener(new OnClickListener() {

			// Call enterClicked() when pressed

			public void onClick(View v) {
				// Intent intent = new Intent(SetRange.this, WidgetService.class
				// );
				// //String message = setRange.getText().toString();
				// intent.putExtra( checkInput, 0);
				// sendBroadcast(intent);
				sendToWidget();

			}
		});
		
	}	

	// Sets result to send back to calling Activity and finishes

	private void sendToWidget() {

		Toast toast = Toast.makeText(getApplicationContext(),
				"This is sendToWidget", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.TOP, 25, 400);
		toast.show();
		
		Intent editIntent = new Intent();
		
		editIntent.putExtra("key",setRange.getText().toString());//
		setResult(RESULT_OK, editIntent);
//		sendBroadcast(editIntent);
		//setResult("key", editIntent);
		// startActivity(editIntent);
		System.out.println("key");
		
		finish();
		// following dev guide, not sure why it won't play nice
//		Intent intent = getIntent();
//		Bundle extras = intent.getExtras();
//		if (extras != null) {
//		    mAppWidgetId = extras.getInt(
//		            AppWidgetManager.EXTRA_APPWIDGET_ID, 
//		            AppWidgetManager.INVALID_APPWIDGET_ID);
//		  
//		    AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
//			
//			RemoteViews views = new RemoteViews(context.getPackageName(),
//					R.layout.widget_layout);
//					appWidgetManager.updateAppWidget(mAppWidgetId, views);
//					
//					Intent resultValue = new Intent();
//			        resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
//					setResult(RESULT_OK, resultValue);
//					finish();
		    
		}
		
//		Intent editIntent = new Intent(this, WidgetRandom.class);
//
//		editIntent.putExtra("key",setRange.getText().toString());//
//		setResult(RESULT_OK, editIntent);
//		sendBroadcast(editIntent);
//		//setResult("key", editIntent);
//		// startActivity(editIntent);
//		System.out.println("key");
		
	}
	


package com.Widget.RandomNumber;

import java.util.Random;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.TextView;

/*
 * Simple widget gives Random Number
 * 
 * @author Patrick Gorman
 * @version Not Sure
* Needs work!!
 */

@SuppressLint("NewApi")
public class WidgetService extends Service {
	
	private static final String LOG = "com.Widget.RandomNumber";
	private static final String TAG = null;
	private static final int default_key = 100;
	private static final int RESULT_OK = 1;
	private static final int GET_TEXT_REQUEST_CODE = 1;
	
	TextView mUserTextView;

	// Create some random data
	//int number = (new Random().nextInt());

	@Override
	public void onStart(Intent intent, int startId) {
		
		Log.i(LOG, "Called onStart");
		
		AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this
				.getApplicationContext());

		int[] allWidgetIds = intent
				.getIntArrayExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS);

		ComponentName thisWidget = new ComponentName(getApplicationContext(),
				WidgetRandom.class);
		
		int[] allWidgetIds2 = appWidgetManager.getAppWidgetIds(thisWidget);
		
		Log.w(LOG, "From Intent" + String.valueOf(allWidgetIds.length));
		Log.w(LOG, "Direct" + String.valueOf(allWidgetIds2.length));

		for (int widgetId : allWidgetIds) {
			
			
						
		//	 create some random data
		Intent i = new Intent(this, SetRange.class);
			

		int message = i.getIntExtra("key", 100);

	    int number = (new Random().nextInt(message));

			
			
			RemoteViews remoteViews = new RemoteViews(this
					.getApplicationContext().getPackageName(),
					R.layout.widget_layout);
			
			Log.w("WidgetExample", String.valueOf(number));
			
			// Set the text
			remoteViews.setTextViewText(R.id.update,
					"Random # " + String.valueOf(number));
			
			// Register an onClickListener
			Intent clickIntent = new Intent(this.getApplicationContext(),
					WidgetRandom.class);

			clickIntent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
			clickIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS,
					allWidgetIds);

			PendingIntent pendingIntent = PendingIntent.getBroadcast(
					getApplicationContext(), 0, clickIntent,
					PendingIntent.FLAG_UPDATE_CURRENT);
			remoteViews.setOnClickPendingIntent(R.id.update, pendingIntent);
			appWidgetManager.updateAppWidget(widgetId, remoteViews);
						
		}
		stopSelf();
		
	}


	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		Log.i(TAG, "Entered onActivityResult()");

		// TODO - Process the result only if this method received both a
		// RESULT_OK result code and a recognized request code
		// If so, update the Textview showing the user-entered text.
		if (requestCode == GET_TEXT_REQUEST_CODE) {
			if (resultCode == RESULT_OK) { // So this was checking requestCode
											// before
											// obviously, that didnt run code
											// inside
				// this code check for data received from other activities
				// intent
				// if (data == null) {
				// return;
				// }
				// Instead of creating new intent, I used Intent data and it now works.
				// Getting data from edittext input from other activity
				String message = data.getStringExtra("key");
				mUserTextView.setText(message);
				
				System.out.println(mUserTextView);
				

			}

		}
		onActivityResult(requestCode, resultCode, data);
	}

	
	public static int getDefaultKey() {
		return default_key;
	}

	
}



package com.Widget.RandomNumber;

import java.util.Random;

import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

/*
 * Simple widget gives Random Number
 * 
 * @author Patrick Gorman
 * @version Not Sure
* Needs work!!
 */

public class WidgetService extends Service {
	
	private static final String LOG = "com.Widget.RandomNumber";

	static private final int GET_TEXT_REQUEST_CODE = 1;
	private static final int RESULT_OK = 0;
	private static final String TAG = null;
	

	// Create some random data
	//int number = (new Random().nextInt());

	// Create some random data
	//int number = (new Random().nextInt());

	@Override
	public void onStart(Intent intent, int startId) {
		
		Log.i(LOG, "Called");
		
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
						
			// Create some random data
			int number = (new Random().nextInt(100));
			
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
		return null;
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		Log.i(TAG, "Entered onActivityResult()");

		if (requestCode == GET_TEXT_REQUEST_CODE) {
			if (resultCode == RESULT_OK) { 
				
				String message = data.getStringExtra("key");
				Toast.makeText(this, message, Toast.LENGTH_LONG).show();

												
				}
			

		}
		
}

}



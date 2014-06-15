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

/**
 * Simple widget gives Random Number
 * 
 * @author Patrick Gorman
 * @version Not Sure
 */

public class WidgetService extends Service {

	private static final String LOG = "com.Widget.RandomNumber";

	// Create EditText
	// EditText userInput;
	
	@Override
	public void onStart(Intent intent, int startId) {

		Log.i(LOG, "Called");
		
		// find edit text field for interaction
		// userInput = (EditText) findViewById(R.id.userinp);

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
			int number = (new Random().intent(gRange);
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

			// The following will be for either new activity of
			// changing values used for RandomNumber

		}
		stopSelf();

		super.onStart(intent, startId);
	}

	// private EditText findViewById(int userinp) {
	// return userInput;
	// }

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	// Meat for starting service
	protected void onHandleIntent(Intent intent) {

		long gRange = intent.getExtras().getLong("range");

	}
}
package com.Widget.RandomNumber;

import java.util.Random;

import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.EditText;
import android.widget.RemoteViews;

/*
 * Simple widget gives Random Number
 * 
 * @author Patrick Gorman
 * @version Not Sure
 * Needs work!!
 */

public class WidgetService extends Service {

	private static final String LOG = "com.Widget.RandomNumber";
	
	private static final int REQUEST_CODE=1;

	private static final int editText;

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

			
			EditText txt = (EditText) findViewById(editText);

			// Create some random data
			int number = (new Random().nextInt(txt));

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

	private int findViewById(int editText) {
		// TODO Auto-generated method stub
		return editText;
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}

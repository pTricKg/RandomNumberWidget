package com.Widget.RandomNumber;

import android.app.IntentService;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.RemoteViews;

/*
 * Simple widget gives Random Number
 * 
 * @author Patrick Gorman
 * 
 * @version Not Sure
 * 
 * tee hee he
 * 
* Needs work!! need figure this out soon
 */

public class AppWidgetRandom extends AppWidgetProvider {
	
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction() == null) {
			context.startService(new Intent(context, ToggleService.class));
		}else {
			super.onReceive(context, intent);
		}
}
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
	int[] appWidgetIds) {
		
		context.startService(new Intent(context, ToggleService.class));
	}
	
	public static class ToggleService extends IntentService {
		
		public ToggleService() {
			super("AppWidgetRandom$ToggleService");
		}
		
		@Override
		protected void onHandleIntent(Intent intent) {
			ComponentName me = new ComponentName(this, AppWidgetRandom.class);
			AppWidgetManager mgr = AppWidgetManager.getInstance(this);
			mgr.updateAppWidget(me, buildUpdate(this));
		}
		
		private RemoteViews buildUpdate(Context context) {
			RemoteViews updateViews = new
			RemoteViews(context.getPackageName(),R.layout.widget);
			
//			Intent i = new Intent(context, AppWidgetRandom.class);
//			
//			i.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
//		    i.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
//		    
//		    PendingIntent pi=PendingIntent.getBroadcast(context, 0 , i,
//                    PendingIntent.FLAG_UPDATE_CURRENT);
//		    
//		    updateViews.setOnClickPendingIntent(R.id.setR, pi);
						
			return updateViews;
}
	}
}

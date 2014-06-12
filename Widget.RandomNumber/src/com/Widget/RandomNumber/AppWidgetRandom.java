package com.Widget.RandomNumber;

import android.app.IntentService;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

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
			return updateViews;
}
	}
}

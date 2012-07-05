package br.com.fourlinux.widgets;

import java.util.Random;

import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

public class UpdateWidgetService extends Service {
	
	private static final String LOG = "br.com.fourlinux.widgets";

	@Override
	public void onStart(Intent intent, int startId) {
		
		Log.i(LOG, "Chamado");

		AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.getApplicationContext());

		int[] allWidgetIds = intent.getIntArrayExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS);

		ComponentName thisWidget = new ComponentName(getApplicationContext(),MyWidgetProvider.class);
		int[] allWidgetIds2 = appWidgetManager.getAppWidgetIds(thisWidget);
		Log.w(LOG, "Chamada pela Intent" + String.valueOf(allWidgetIds.length));
		Log.w(LOG, "Chamada Direta" + String.valueOf(allWidgetIds2.length));

		for (int widgetId : allWidgetIds) {
			
			// Nœmero aleatorio criado para mudar no click no widget
			int number = (new Random().nextInt(100));

			RemoteViews remoteViews = new RemoteViews(this.getApplicationContext().getPackageName(),R.layout.widget_layout);
			Log.w("Exemplo de Widget", String.valueOf(number));
			
			// Escolha o texto do widget
			remoteViews.setTextViewText(R.id.update,"Nœmero Aleat—rio: " + String.valueOf(number));

			// Resgistrar no Click Listener
			Intent clickIntent = new Intent(this.getApplicationContext(),MyWidgetProvider.class);

			clickIntent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
			clickIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS,allWidgetIds);

			PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, clickIntent,PendingIntent.FLAG_UPDATE_CURRENT);
			remoteViews.setOnClickPendingIntent(R.id.update, pendingIntent);
			appWidgetManager.updateAppWidget(widgetId, remoteViews);
		}
		stopSelf();

		super.onStart(intent, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}

		

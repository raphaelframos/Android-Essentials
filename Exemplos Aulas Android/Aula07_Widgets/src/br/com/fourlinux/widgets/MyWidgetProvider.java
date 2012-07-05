package br.com.fourlinux.widgets;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyWidgetProvider extends AppWidgetProvider {

	private static final String LOG = "br.com.fourlinux.widgets";

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,int[] appWidgetIds) {

		Log.w(LOG, "no onUpdate o método é chamado");
		
		// Pega o Id 
		ComponentName thisWidget = new ComponentName(context,MyWidgetProvider.class);
		int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);

		// Cria a Intent para chamar o serviço
		Intent intent = new Intent(context.getApplicationContext(),UpdateWidgetService.class);
		intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, allWidgetIds);

		// Atualiza o widget pelo serviço
		context.startService(intent);
	}
}
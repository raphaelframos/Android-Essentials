package br.com.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AirPlaneMode extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		if(intent.getAction().equals("android.intent.action.AIRPLANE_MODE"));
		Toast.makeText(context, "Quando voce clicou no AirPlaneMode sua aplicação capturou essa ação", Toast.LENGTH_LONG).show();
		
	}

}

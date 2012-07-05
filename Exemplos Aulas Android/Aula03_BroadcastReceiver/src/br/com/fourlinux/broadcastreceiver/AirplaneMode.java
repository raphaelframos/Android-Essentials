package br.com.fourlinux.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AirplaneMode extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		if(intent.getAction().equals("android.intent.action.AIRPLANE_MODE")){
			Toast.makeText(context, "Quando você clicou no AirPlane Mode sua Aplicação capturou essa ação", Toast.LENGTH_LONG).show();
		}
		
	}

}

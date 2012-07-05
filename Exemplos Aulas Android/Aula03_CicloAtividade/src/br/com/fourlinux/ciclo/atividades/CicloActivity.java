package br.com.fourlinux.ciclo.atividades;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class CicloActivity extends Activity {
	
	
	@Override
	protected void onDestroy() {
		super.onDestroy();

		Log.v("TAG", "onDestroy()");
	}

	@Override
	protected void onPause() {
		super.onPause();

		Log.v("TAG", "onPause()");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.v("TAG", "onResume()");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.v("TAG", "onResume()");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.v("TAG", "onStop()");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.v("TAG", "onRestart()");
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela);
		Log.v("TAG", "onCreate()");
	}
}
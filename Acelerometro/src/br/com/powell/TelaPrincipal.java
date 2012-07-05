package br.com.powell;

import android.app.Activity;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class TelaPrincipal extends Activity implements SensorListener {
	
final String tag = "Teste Acelerômetro";
	
	SensorManager sm = null;
	TextView xViewA = null;
	TextView yViewA = null;
	TextView zViewA = null;
	TextView xViewO = null;
	TextView yViewO = null;
	TextView zViewO = null;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// pega a referencia do SensorManager
		sm = (SensorManager) getSystemService(SENSOR_SERVICE);
		setContentView(R.layout.main);
		xViewA = (TextView) findViewById(R.id.xbox);
		yViewA = (TextView) findViewById(R.id.ybox);
		zViewA = (TextView) findViewById(R.id.zbox);
		xViewO = (TextView) findViewById(R.id.xboxo);
		yViewO = (TextView) findViewById(R.id.yboxo);
		zViewO = (TextView) findViewById(R.id.zboxo);
	}

	
	
	
	

	public void onSensorChanged(int sensor, float[] values) {
		synchronized (this) {
			Log.d(tag, "onSensorChanged: " + sensor + ", x: " + values[0] + ", y: " + values[1] + ", z: " + values[2]);
			if (sensor == SensorManager.SENSOR_ORIENTATION) {
				xViewO.setText("Orientation X: " + values[0]);
				yViewO.setText("Orientation Y: " + values[1]);
				zViewO.setText("Orientation Z: " + values[2]);
			}
			if (sensor == SensorManager.SENSOR_ACCELEROMETER) {
				xViewA.setText("Accel X: " + values[0]);
				yViewA.setText("Accel Y: " + values[1]);
				zViewA.setText("Accel Z: " + values[2]);
			}
		}
	}

	public void onAccuracyChanged(int sensor, int accuracy) {
		Log.d(tag, "onAccuracyChanged: " + sensor + ", accuracy: " + accuracy);
	}

	
	@Override
	protected void onResume() {
		super.onResume();
		// Registrando a classe para iniciar quando o aplicativo for aberto
		sm.registerListener(this, SensorManager.SENSOR_ORIENTATION
				| SensorManager.SENSOR_ACCELEROMETER,
				SensorManager.SENSOR_DELAY_NORMAL);
	}

	
	@Override
	protected void onStop() {
		// e desregistrando na saida do aplicativo
		sm.unregisterListener(this);
		super.onStop();
	}
}
package br.com.fourlinux.preferencias;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaPrincipal extends Activity {
	TextView textView;
	
	Button botao;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		botao = (Button)findViewById(R.id.btnPrefs);
		
		botao.setOnClickListener(new View.OnClickListener() {
			
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});

		Button btnPrefs = (Button) findViewById(R.id.btnPrefs);
		Button btnGetPrefs = (Button) findViewById(R.id.btnGetPreferences);

		textView = (TextView) findViewById(R.id.txtPrefs);

		View.OnClickListener listener = new View.OnClickListener() {

			
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.btnPrefs:
					Intent intent = new Intent(TelaPrincipal.this,PrefsActivity.class);
					startActivity(intent);
					break;

				case R.id.btnGetPreferences:
					displaySharedPreferences();
					break;

				default:
					break;
				}
			}
		};

		btnPrefs.setOnClickListener(listener);
		btnGetPrefs.setOnClickListener(listener);
	}

	private void displaySharedPreferences() {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(TelaPrincipal.this);

		String username = prefs.getString("username", "Default NickName");
		String passw = prefs.getString("password", "Default Password");
		boolean checkBox = prefs.getBoolean("checkBox", false);
		String listPrefs = prefs.getString("listpref", "Default list prefs");

		StringBuilder builder = new StringBuilder();
		builder.append("Username: " + username + "\n");
		builder.append("Password: " + passw + "\n");
		builder.append("Mantenhame Conectado: " + String.valueOf(checkBox) + "\n");
		builder.append("Lista de Preferencias: " + listPrefs);

		textView.setText(builder.toString());
	}
}

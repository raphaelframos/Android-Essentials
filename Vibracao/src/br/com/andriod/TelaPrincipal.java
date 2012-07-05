package br.com.andriod;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TelaPrincipal extends Activity implements OnClickListener {
	/** Called when the activity is first created. */

	//Botões que iremos usar
	Button simples,padronizada,cancelar;
	
	//Objeto do tipo Vibrator
	Vibrator vibrator;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		//Aqui apenas estamos sensibilizando os btões lembrando que implementamos o OnClickListenes na Classe
		simples = (Button) findViewById(R.id.btnSimples);
		simples.setOnClickListener(this);

		padronizada = (Button) findViewById(R.id.btnPadronizada);
		padronizada.setOnClickListener(this);

		cancelar = (Button) findViewById(R.id.btnCancelar);
		cancelar.setOnClickListener(this);
		
		//Aqui nosso objeto pega o Serviço
		vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
	}

	public void onClick(View v) {
		if (v == simples) {
			vibrator.vibrate(500);
		} else if (v == padronizada) {
			long[] pattern = { 0L, 100L, 250L, 1000L, 250L, 500L };
			vibrator.vibrate(pattern, 2);
		} else {
			vibrator.cancel();
		}
	}
}
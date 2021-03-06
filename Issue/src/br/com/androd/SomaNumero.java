package br.com.androd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SomaNumero extends Activity{
	
	private EditText numero1;
	private EditText numero2;
	private Button btnSoma;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soma);
        
        numero1 = (EditText) findViewById(R.id.editText1);
        numero2 = (EditText) findViewById(R.id.editText2);
        btnSoma = (Button) findViewById(R.id.btnSoma);
        
        btnSoma.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				int num1 = Integer.parseInt(numero1.getText().toString());
				int num2 = Integer.parseInt(numero2.getText().toString());
				int soma = somarNumeros(num1, num2);
				Intent data = new Intent();
				data.putExtra("soma", soma);          
				setResult(0, data);
				finish();
			}

			private int somarNumeros(int num1, int num2) {
				return num1 + num2;
			}
		});
       
	}

}

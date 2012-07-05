package br.teste;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TesteActivity extends Activity {
    /** Called when the activity is first created. */
	
	Button botao;
    TextView txtNome;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        
        txtNome = (TextView)findViewById(R.id.txtNome);
        
        botao = (Button)findViewById(R.id.btnAcao);
        
        botao.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),txtNome.getText(), Toast.LENGTH_SHORT).show();
				
			}
		});
        
      
    }
}
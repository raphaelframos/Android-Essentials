package br.com.fourlinux.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrimeiraTela extends Activity {
    /** Called when the activity is first created. */
	//Instanciamos o Botão para ser usado no método inteiro
	Button chamaSegundaTela;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Aqui é apontado na Classe R qual o nome e qual componente iremos usar
        chamaSegundaTela = (Button)findViewById(R.id.btnChamaSegundaTela);
        
        chamaSegundaTela.setOnClickListener(new View.OnClickListener() {
			
			
			public void onClick(View arg0) {
				//Aqui a maneira mais facil de chamar uma Activity/Tela Apontando onde estamos no PrimeiraTela.this e para onde iremos no SegundaTela.class
				startActivity(new Intent(PrimeiraTela.this, SegundaTela.class));
				
			}
		});
    }
}
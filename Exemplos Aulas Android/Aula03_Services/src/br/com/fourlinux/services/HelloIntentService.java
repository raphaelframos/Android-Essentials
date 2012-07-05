package br.com.fourlinux.services;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HelloIntentService extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
      //criando intent
        final Intent helloIntentService = new Intent(this, NossoServico.class);
 
        //botao iniciar
        Button btnStart = (Button) findViewById(R.id.btnStart);
        //listener
        btnStart.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {    
                //start the service
                startService(helloIntentService);
            }
        });
 
        //botao parar
        Button btnStop = (Button) findViewById(R.id.btnStop);
        //listener
        btnStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {            
                //stop the service
                stopService(helloIntentService); 
            }
        });
    }  
}

package br.com.fonte;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;



public class FonteCustomizadaActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView texto;
        
        texto = (TextView)findViewById(R.id.txtHello);
        
        Typeface type = Typeface.createFromAsset(getAssets(), "DroidLogo-Regular.ttf");
        
        texto.setTypeface(type);
    }
}
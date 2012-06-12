package br.com.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class TestesdeMenu extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.menu_de_opcoes, menu);
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	switch(item.getItemId()){
    	case R.id.item_um:
    		Toast.makeText(this, "Item Um", Toast.LENGTH_SHORT).show();
    		return true;
    	case R.id.item_dois:
    		Toast.makeText(this, "Item Dois", Toast.LENGTH_SHORT).show();
    		return true;
    	case R.id.item_tres:
    		Toast.makeText(this, "Item Tres", Toast.LENGTH_SHORT).show();
    		return true;
    	default:
			return super.onOptionsItemSelected(item);
    	}
		
    }
}
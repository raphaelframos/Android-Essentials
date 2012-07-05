package br.com.menus;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class TestesdeMenuActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    public  boolean onCreateOptionsMenu(Menu menu){
    	
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.menu_de_opcoes, menu);
    	return true;
    }
    @Override
    public  boolean onOptionsItemSelected(MenuItem item){
    	switch (item.getItemId()){
    	case R.id.item1:
    		Toast.makeText(this, "Item UM", Toast.LENGTH_SHORT).show();
    		return true;
    	case R.id.item2:
    		Toast.makeText(this, "Item UM", Toast.LENGTH_SHORT).show();
    		return true;
    	case R.id.item3:
    		Toast.makeText(this, "Item UM", Toast.LENGTH_SHORT).show();
    		return true;
    		default:
    			return super.onOptionsItemSelected(item);
    	}
    }
}
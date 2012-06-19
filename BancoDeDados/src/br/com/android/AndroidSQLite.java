package br.com.android;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class AndroidSQLite extends Activity {
    /** Called when the activity is first created. */
	
	private EditText edtNome;
	private EditText edtTelefone;
	private Button btnAdd;
	private DatabaseHandler db;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adiciona);
        
         db = new DatabaseHandler(this);
        
        edtNome = (EditText) findViewById(R.id.editTextNome);
        edtTelefone = (EditText) findViewById(R.id.editTextTel);
        btnAdd = (Button) findViewById(R.id.buttonAdd);
        
        btnAdd.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				capturaDados();
			}

			private void capturaDados() {
				String nome = edtNome.getText().toString();
				String telefone = edtTelefone.getText().toString();
				
				salvaDados(nome, telefone);
				
			}

			private void salvaDados(String nome, String telefone) {
				db.addContact(new Contato(nome, telefone));
			}
		});
        
     
      		

      		// Listando todos os Contatos
      		Log.d("Listar: ", "Listando todos os Contatos..");
      		List<Contato> contacts = db.getAllContacts();

      		// simples for para ir pegando os dados dos contatos enquanto eles exixtirem
      		for (Contato cn : contacts) {
      			String log = "Id: " + cn.getID() + " ,Nome: " + cn.getName()+ " ,Telefone: " + cn.getPhoneNumber();
      			
      			// Mandando os contatos para o Log
      			Log.d("Dados: ", log);
      		}
      	}
      }
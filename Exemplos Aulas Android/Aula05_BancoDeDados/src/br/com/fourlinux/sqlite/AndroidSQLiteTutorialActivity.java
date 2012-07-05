package br.com.fourlinux.sqlite;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AndroidSQLiteTutorialActivity extends Activity {
	/** Called when the activity is first created. */

	EditText nome, telefone;
	Button adicionar, excluir, listar;
	TextView listarDados;
	ListView lista;
	String log;

	// Aqui instanciamos a nossa Classe Responsavel pelos atividades do Banco
	DatabaseHandler db = new DatabaseHandler(this);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		/**
		 * Operações CRUD
		 * */

		nome = (EditText) findViewById(R.id.editText1);
		telefone = (EditText) findViewById(R.id.editText2);

		adicionar = (Button) findViewById(R.id.button1);
		excluir = (Button) findViewById(R.id.button2);
		listar = (Button) findViewById(R.id.button3);

		adicionar.setOnClickListener(new View.OnClickListener() {

			
			public void onClick(View arg0) {

				// Código para adicionar os dados em nosso banco
				db.addContact(new Contato(nome.getText().toString(), telefone
						.getText().toString()));

				Toast.makeText(getApplicationContext(), "Contato Adicionado",
						Toast.LENGTH_SHORT).show();

			}
		});

		listar.setOnClickListener(new View.OnClickListener() {

		
			public void onClick(View v) {

				// Listando todos os Contatos
				Log.d("Listar: ", "Listando todos os Contatos..");

				// Lista Criada para pegar todos os contatos
				List<Contato> contacts = db.getAllContacts();

				// simples for para ir pegando os dados dos contatos enquanto
				// eles existirem
				for (Contato cn : contacts) {
					log = "Nome: " + cn.getName() + ", Tel.: "
							+ cn.getPhoneNumber();
					Log.d("Contato: ", log);

					AlertDialog.Builder dialogo = new AlertDialog.Builder(
							AndroidSQLiteTutorialActivity.this);
					dialogo.setTitle("Listando Contatos");
					dialogo.setMessage(log);
					dialogo.setNeutralButton("OK", null);
					dialogo.show();

				}

			}
		});

	}
}

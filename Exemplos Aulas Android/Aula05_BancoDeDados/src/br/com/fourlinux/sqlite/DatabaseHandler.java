package br.com.fourlinux.sqlite;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	// Variaveis Estaticas
	// Versão do Banco de Dados
	private static final int DATABASE_VERSION = 1;

	// Nome do Banco de Dados
	private static final String DATABASE_NAME = "gerenciadorContatos";

	// Nome da Tabela
	private static final String TABLE_CONTACTS = "contatos";

	// Campos da Tabela
	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "nome";
	private static final String KEY_PH_NO = "telefone";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Criando as Tabelas
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
				+ KEY_PH_NO + " TEXT" + ")";
		db.execSQL(CREATE_CONTACTS_TABLE);
	}

	// Caso for preciso atualizar o Banco
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop em todas as tabelas
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

		// E aqui criando as tabelas novamente
		onCreate(db);
	}

	/**
	 * Aqui as Operações do Banco CRUD(Create, Read, Update, Delete) 
	 */

	// Adicionar um novo contato
	void addContact(Contato contact) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, contact.getName()); // Nome 
		values.put(KEY_PH_NO, contact.getPhoneNumber()); // Telefone

		// Inserindo a Linha
		db.insert(TABLE_CONTACTS, null, values);
		db.close(); // Fechando o Banco
	}

	// Pesquisando um  unico contato
	Contato getContact(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,KEY_NAME, KEY_PH_NO }, KEY_ID + "=?",new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		Contato contact = new Contato(Integer.parseInt(cursor.getString(0)),cursor.getString(1), cursor.getString(2));
		// retorna o contato
		return contact;
	}

	// Listando todos os contatos
	public List<Contato> getAllContacts() {
		
		List<Contato> contactList = new ArrayList<Contato>();
		
		// Query de pesquisa
		String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// Pesquisando em todas as linhas e mostrando o resultado
		if (cursor.moveToFirst()) {
			do {
				Contato contact = new Contato();
				contact.setID(Integer.parseInt(cursor.getString(0)));
				contact.setName(cursor.getString(1));
				contact.setPhoneNumber(cursor.getString(2));
				// Adicionando os contatos a lista
				contactList.add(contact);
			} while (cursor.moveToNext());
		}

		// retornando a lista de contatos
		return contactList;
	}

	
	// atualizando um contato
	public int updateContact(Contato contact) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, contact.getName());
		values.put(KEY_PH_NO, contact.getPhoneNumber());

		// atualizando a linha
		return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?", new String[] { String.valueOf(contact.getID()) });
	}

	
	// Deletar uma linha do banco
	public void deleteContact(Contato contact) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_CONTACTS, KEY_ID + " = ?",new String[] { String.valueOf(contact.getID()) });
		db.close();
	}

	// Obtendo a quantidade de Contatos
	public int getContactsCount() {
		String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// retorna contatos
		return cursor.getCount();
	}

}

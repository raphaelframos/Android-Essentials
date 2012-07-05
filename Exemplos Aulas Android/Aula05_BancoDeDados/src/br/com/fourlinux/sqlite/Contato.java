package br.com.fourlinux.sqlite;

public class Contato {

	// variaveis privadas
	int _id;
	String _nome;
	String _telefone;

	// construtor vazio
	public Contato() {

	}

	// construtor
	public Contato(int id, String nome, String telefone) {
		this._id = id;
		this._nome = nome;
		this._telefone = telefone;
	}

	// construtor
	public Contato(String nome, String telefone) {
		this._nome = nome;
		this._telefone = telefone;
	}
	// getting ID
	public int getID() {
		return this._id;
	}

	// setting id
	public void setID(int id) {
		this._id = id;
	}

	// getting nome
	public String getName() {
		return this._nome;
	}

	// setting nome
	public void setName(String nome) {
		this._nome = nome;
	}

	// getting telefone
	public String getPhoneNumber() {
		return this._telefone;
	}

	// setting telefone
	public void setPhoneNumber(String telefone) {
		this._telefone = telefone;
	}
}

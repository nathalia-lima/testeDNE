package br.edu.dne.model;

public class Estudantes {
	
	private String email;
	private String nome;
	private String dataNascimento;
	private String cpf;
	private String cep;
	private String numero;
	private String genero;
	private String celular;
	private String escolaridade;
	private String nomeCurso;
	private float saldo;
	private String suspender;
	
	public Estudantes(String email, String nome, String dataNascimento, String cpf, String cep, String numero, 
			String genero, String celular, String escolaridade, String nomeCurso, float saldo, String suspender) {
		this.email = email;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.cep = cep;
		this.numero = numero;
		this.genero = genero;
		this.celular = celular;
		this.escolaridade = escolaridade;
		this.nomeCurso = nomeCurso;
		this.saldo = saldo;
		this.suspender = suspender;
	}

	public Estudantes() {
		// TODO Auto-generated constructor stub
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public Estudantes(float saldo) {
		super();
		this.setSaldo(saldo);
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public String getSuspender() {
		return suspender;
	}

	public void setSuspender(String suspender) {
		this.suspender = suspender;
	}
	
}

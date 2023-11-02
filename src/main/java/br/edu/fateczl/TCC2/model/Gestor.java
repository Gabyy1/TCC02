package br.edu.fateczl.TCC2.model;

public class Gestor {

	private String cpf;
	private String nome;
	private String email;
	private String senha;
	private int cargo;
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getCargo() {
		return cargo;
	}
	public void setCargo(int cargo) {
		this.cargo = cargo;
	}
	
	@Override
	public String toString() {
		return "Gestor [cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", cargo=" + cargo
				+ "]";
	}
	
}
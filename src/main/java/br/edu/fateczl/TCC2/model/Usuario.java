package br.edu.fateczl.TCC2.model;

public class Usuario {

	private String email;
	private String senha;
	private String tipo;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "Usuario [email=" + email + ", senha=" + senha + ", tipo=" + tipo + "]";
	}
}
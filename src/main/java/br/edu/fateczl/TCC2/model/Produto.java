package br.edu.fateczl.TCC2.model;

import java.sql.Date;

public class Produto {

		private int codigo;
		private String nome;
		private int quantidade;
		private Date vencimento;
		private String marca;
		private String categoria;
		private String cnpjFornecedor;
		private String nomeFornecedor;
		private Date dataCompra;
		private float valorUnitario;
		private String descricao;
		private float valorTotal;
		private String nivel;
		
		public int getCodigo() {
			return codigo;
		}
		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public int getQuantidade() {
			return quantidade;
		}
		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}
		public Date getVencimento() {
			return vencimento;
		}
		public void setVencimento(Date vencimento) {
			this.vencimento = vencimento;
		}
		public String getMarca() {
			return marca;
		}
		public void setMarca(String marca) {
			this.marca = marca;
		}
		public String getCategoria() {
			return categoria;
		}
		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}
		public String getCnpjFornecedor() {
			return cnpjFornecedor;
		}
		public void setCnpjFornecedor(String cnpjFornecedor) {
			this.cnpjFornecedor = cnpjFornecedor;
		}
		public String getNomeFornecedor() {
			return nomeFornecedor;
		}
		public void setNomeFornecedor(String nomeFornecedor) {
			this.nomeFornecedor = nomeFornecedor;
		}
		public Date getDataCompra() {
			return dataCompra;
		}
		public void setDataCompra(Date dataCompra) {
			this.dataCompra = dataCompra;
		}
		public float getValorUnitario() {
			return valorUnitario;
		}
		public void setValorUnitario(float valorUnitario) {
			this.valorUnitario = valorUnitario;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public float getValorTotal() {
			return valorTotal;
		}
		public void setValorTotal(float valorTotal) {
			this.valorTotal = valorTotal;
		}
		public String getNivel() {
			return nivel;
		}
		public void setNivel(String nivel) {
			this.nivel = nivel;
		}
		@Override
		public String toString() {
			return "Produto [codigo=" + codigo + ", nome=" + nome + ", quantidade=" + quantidade + ", vencimento="
					+ vencimento + ", marca=" + marca + ", categoria=" + categoria + ", cnpjFornecedor="
					+ cnpjFornecedor + ", nomeFornecedor=" + nomeFornecedor + ", dataCompra=" + dataCompra
					+ ", valorUnitario=" + valorUnitario + ", descricao=" + descricao + ", valorTotal=" + valorTotal
					+ ", nivel=" + nivel + "]";
		}

}
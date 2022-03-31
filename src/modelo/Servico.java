package modelo;

import java.io.Serializable;

public class Servico implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private double valor;
	private Usuario funcionario;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Usuario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Usuario funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
	
}

package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class OrdemServico implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;
	private Cliente cliente;
	private Carro carro;
	private String problemas;
	private ArrayList<Servico> servicos;
	private boolean status = true;
	private double valorTotal =0;
	
	
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	public String getProblemas() {
		return problemas;
	}
	public void setProblemas(String problemas) {
		this.problemas = problemas;
	}
	public ArrayList<Servico> getServicos() {
		return servicos;
	}
	public void setServicos(ArrayList<Servico> servicos) {
		this.servicos = servicos;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public double getValorTotal() {
		if(this.servicos!=null){
			for(Servico s:this.servicos){
				valorTotal +=s.getValor();
			}
		}
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}

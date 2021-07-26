package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {
	private Date data;
	private Integer numero;
	private Double valor;
	
	List<Pagamento>lista = new ArrayList<Pagamento>();
	
	
	public Contrato() {
		super();
	}
	public Contrato(Date data, Integer numero, Double valor) {
		super();
		this.data = data;
		this.numero = numero;
		this.valor = valor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public List<Pagamento> getLista() {
		return lista;
	}
	
	public void adicionarPgLista(Pagamento pg) {
		lista.add(pg);
	}
	
	
}

package interfaces;

public interface PagamentoOnline {
	
	public Double taxaMensal(Integer mes, Double valor);
	public Double taxaFixa(Double valor);
	
}

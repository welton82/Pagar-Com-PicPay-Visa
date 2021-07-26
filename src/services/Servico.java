package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contrato;
import entities.Pagamento;
import interfaces.PagamentoOnline;

public class Servico {
	
	PagamentoOnline pagamentoOnline;

	public Servico(PagamentoOnline pagamentoOnline) {
		this.pagamentoOnline = pagamentoOnline;
	}
	
	public void gerarListaDePagamento(Contrato contrato, Integer mes) {
		Double valor = 	contrato.getValor() / mes;
		
		for(int i=1; i<=mes; i++) {
			
			Date data = geraData(i, contrato.getData()) ;
			Double parcial = pagamentoOnline.taxaMensal(i, valor);
			Double total = pagamentoOnline.taxaFixa(parcial);
			
			contrato.getLista().add(new Pagamento(data, total));
			
		}
		
		
	}
	public Date geraData(Integer mes, Date d) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(Calendar.MONTH, mes);
		return calendar.getTime();
		
	}
	
	
}

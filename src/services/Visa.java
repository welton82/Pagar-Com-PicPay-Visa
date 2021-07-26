package services;

import interfaces.PagamentoOnline;

public class Visa implements PagamentoOnline{

	@Override
	public Double taxaMensal(Integer mes, Double valor) {
		// TODO Auto-generated method stub
		return valor * 0.015 * mes + valor;
	}

	@Override
	public Double taxaFixa(Double valor) {
		// TODO Auto-generated method stub
		return valor * 0.03 + valor;
	}

}

package services;

import interfaces.PagamentoOnline;

public class PicPay implements PagamentoOnline{

	@Override
	public Double taxaMensal(Integer mes, Double valor) {
		// TODO Auto-generated method stub
		return valor*0.01 * mes + valor;
	}

	@Override
	public Double taxaFixa(Double valor) {
		// TODO Auto-generated method stub
		return valor * 0.02 + valor;
	}

}

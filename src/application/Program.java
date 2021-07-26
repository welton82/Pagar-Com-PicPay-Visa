package application;

import java.security.Provider.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Contrato;
import entities.Pagamento;
import services.PicPay;
import services.Servico;
import services.Visa;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		Scanner scan = new Scanner(System.in);
		//System.out.println("");
		operacao(scan);
		
	}
	public static int menu(Scanner scan) {
		int op;
		System.out.println("1 - pagar com Pic Pay");
		System.out.println("2 - Pagar com Cartão Visa");
		System.out.print("Informe a operação: ");
		op = scan.nextInt();
		
		
		return op;
	}
	
	public static void operacao(Scanner scan) throws ParseException {
		
		int op = -1;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		while(op != 0) {
			op = menu(scan);
			switch(op) {
			
				case 1:
					System.out.println("======= PAGAR COM PICPAY ==========\n");
					System.out.print("Informe O Numero do Contrato: ");
					Integer numContrato = scan.nextInt();
					System.out.print("Informe o Valor a ser Pago: ");
					Double valor =scan.nextDouble();
					System.out.print("Informe a Data da compra: ");
					String dat = scan.next();
					Date date = sdf.parse(dat);
					System.out.print("Informe a Quantidade de Parcelas deseja Pagar: ");
					Integer qdeMes = scan.nextInt();
					Contrato contrato = new Contrato(date, numContrato, valor);
					
					Servico servico = new Servico(new PicPay());
					servico.gerarListaDePagamento(contrato, qdeMes);
					
					System.out.println("======== GERANDO PARCELAS =========");
					for(Pagamento p:contrato.getLista()) {
						System.out.println("----------------------------");
						System.out.println(p.toString());
						System.out.println("----------------------------");
					}
					System.out.println();
					break;
				case 2:
					
					
					System.out.println("======= PAGAR COM VISA ==========");
					System.out.print("Informe O Numero do Contrato: ");
					numContrato = scan.nextInt();
					System.out.print("Informe o Valor a ser Pago: ");
					valor =scan.nextDouble();
					System.out.print("Informe a Data da compra: ");
					dat = scan.next();
					date = sdf.parse(dat);
					System.out.print("Informe a Quantidade de Parcelas deseja Pagar: ");
					qdeMes = scan.nextInt();
				
					contrato = new Contrato(date, numContrato, valor);
					servico = new Servico(new Visa());
					
					servico.gerarListaDePagamento(contrato, qdeMes);
					
					System.out.println("======== GERANDO PARCELAS =========");
					for(Pagamento p:contrato.getLista()) {
						System.out.println("----------------------------");
						System.out.println(p);
						System.out.println("----------------------------");
					}
					break;
				case 0:
					System.out.println("Obrigado pela Compra!!!!");
					break;
					
			}
			
		}
		
		System.out.println("Você saiu.........");
	}
	
	
}

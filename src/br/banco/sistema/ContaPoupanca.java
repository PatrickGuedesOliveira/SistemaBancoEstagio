package br.banco.sistema;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(String cc, String agencia, String titular, String dtAbertura, double saldo) {
		super(cc, agencia, titular, dtAbertura, saldo);
	}

	public ContaPoupanca(String cc, String agencia, String titular, String dtAbertura, double saldo,
			double saldoEspecial) {
		super(cc, agencia, titular, dtAbertura, saldo, saldoEspecial);
	}

	@Override
	public void saque(double valor) throws Exception {
		if (valor <= 0) {
			throw new Exception("O valor para saque n�o pode ser igual ou menor que zero.");
		}
		if (this.saldoEspecial == null) {
			if (valor > this.getSaldo()) {
				throw new Exception("O valor para saque � maior que o saldo dispon�vel");
			}
		} else {
			if (valor > this.getSaldo() + this.saldoEspecial) {
				throw new Exception("O valor para saque � maior que o saldo dispon�vel");
			}
		}
		this.saldo = this.getSaldo() - valor;
	}

	@Override
	public void deposito(double valor) throws Exception {
		if (valor <= 0) {
			throw new Exception("O valor para dep�sito n�o pode ser igual ou menor que zero.");
		}
		this.saldo = this.getSaldo() + valor;
	}

	@Override
	public void trasnferencia(Conta c, double valor) throws Exception {
		if (valor <= 0) {
			throw new Exception("O valor da transfer�ncia n�o pode ser igual ou menor que zero.");
		}
		if (this.saldoEspecial == null) {
			if ((valor + valor * 0.03) > this.getSaldo()) {
				throw new Exception("O valor da transfer�ncia � maior que o saldo dispon�vel");
			}
		}else{
			if (valor > this.getSaldo() + this.saldoEspecial) {
				throw new Exception("O valor para saque � maior que o saldo dispon�vel");
			}
		}
		
		this.saldo = (this.getSaldo() - valor) - (valor * 0.03);
		c.saldo = c.getSaldo() + valor;
		if (this.saldo < 0) {
			this.saldoEspecial += this.getSaldo();
		}
	}

	public static void rendimento(ContaPoupanca c, String dataRendimento) throws Exception {
		LocalDate dataInicio = LocalDate.parse(c.getDtAbertura(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate dataFinal = LocalDate.parse(dataRendimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		long totalMeses = ChronoUnit.MONTHS.between(dataInicio, dataFinal);

		if (totalMeses < 0) {
			throw new Exception("Data informada deve ser maior que a data de abertura:");
		}

		double rendimento = c.getSaldo() * 0.005 * totalMeses;

		System.out.println("Seu rendimento de: " + totalMeses + " mes(es).");
		System.out.println(rendimento);
	}

}
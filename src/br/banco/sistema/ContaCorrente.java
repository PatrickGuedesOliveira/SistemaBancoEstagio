package br.banco.sistema;

public class ContaCorrente extends Conta {

	public ContaCorrente(String cc, String agencia, String titular, String dtAbertura, double saldo) {
		super(cc, agencia, titular, dtAbertura, saldo);
	}

	public ContaCorrente(String cc, String agencia, String titular, String dtAbertura, double saldo,
			double saldoEspecial) {
		super(cc, agencia, titular, dtAbertura, saldo, saldoEspecial);
	}

	@Override
	public void saque(double valor) throws Exception {
		if (valor <= 0) {
			throw new Exception("O valor para saque não pode ser igual ou menor que zero.");
		}
		if (this.saldoEspecial == null) {
			if (valor > this.getSaldo()) {
				throw new Exception("O valor para saque é maior que o saldo disponível");
			}
		} else {
			if (valor > this.getSaldo() + this.saldoEspecial) {
				throw new Exception("O valor para saque é maior que o saldo disponível");
			}
		}
		this.saldo = this.getSaldo() - valor;
		if (this.saldo < 0) {
			this.saldoEspecial += this.getSaldo();
		}
	}

	@Override
	public void deposito(double valor) throws Exception {
		if (valor <= 0) {
			throw new Exception("O valor para depósito não pode ser igual ou menor que zero.");
		}
		this.saldo = this.getSaldo() + valor;
	}

	@Override
	public void trasnferencia(Conta c, double valor) throws Exception {
		if (valor <= 0) {
			throw new Exception("O valor da transferência não pode ser igual ou menor que zero.");
		}
		if (this.saldoEspecial == null) {
			if ((valor + valor * 0.03) > this.getSaldo()) {
				throw new Exception("O valor da transferência é maior que o saldo disponível");
			}
		}else{
			if (valor > this.getSaldo() + this.saldoEspecial) {
				throw new Exception("O valor para saque é maior que o saldo disponível");
			}
		}
		
		this.saldo = (this.getSaldo() - valor) - (valor * 0.03);
		c.saldo = c.getSaldo() + valor;
		if (this.saldo < 0) {
			this.saldoEspecial += this.getSaldo();
		}
	}
}
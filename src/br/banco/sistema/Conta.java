package br.banco.sistema;

public abstract class Conta {

	protected String cc;
	protected String agencia;
	protected String titular;
	protected String dtAbertura;
	protected double saldo;
	protected Double saldoEspecial;

	public Conta(String cc, String agencia, String titular, String dtAbertura, double saldo) {
		this.cc = cc;
		this.agencia = agencia;
		this.titular = titular;
		this.dtAbertura = dtAbertura;
		this.saldo = saldo;
	}

	public Conta(String cc, String agencia, String titular, String dtAbertura, double saldo, double saldoEspecial) {
		this(cc, agencia, titular, dtAbertura, saldo);
		this.saldoEspecial = saldoEspecial;
	}

	/**
	 * @return the cc
	 */
	public String getCc() {
		return cc;
	}

	/**
	 * @param cc
	 *            the cc to set
	 */
	public void setCc(String cc) {
		this.cc = cc;
	}

	/**
	 * @return the agencia
	 */
	public String getAgencia() {
		return agencia;
	}

	/**
	 * @return the titular
	 */
	public String getTitular() {
		return titular;
	}

	/**
	 * @return the dtAbertura
	 */
	public String getDtAbertura() {
		return dtAbertura;
	}

	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * @return the saldoEspecial
	 */
	public double getSaldoEspecial() {
		return saldoEspecial;
	}

	public abstract void saque(double valor) throws Exception;

	public abstract void deposito(double valor) throws Exception;

	public abstract void trasnferencia(Conta c, double valor) throws Exception;
}
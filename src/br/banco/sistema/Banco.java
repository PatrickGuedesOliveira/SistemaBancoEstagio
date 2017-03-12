package br.banco.sistema;

public class Banco {

	public static void imprimirDeposito(Conta c) {
		System.out.println("#Titular: " + c.getTitular());
		System.out.println("Depósito realizado com sucesso!");
		System.out.println("Seu saldo é de: " + c.getSaldo());
	}
	
	public static void imprimirSaque(Conta c){
		System.out.println("#Titular: " + c.getTitular());
		System.out.println("Saque realizado com sucesso!");
		System.out.println("Seu saldo é de: " + c.getSaldo());
		if(c.getSaldo()<0){
			System.out.println("Seu Cheque especial é de: " + c.getSaldoEspecial());
		}
	}
	
	public static void imprimirTransferencia(Conta deposita, Conta recebe){
		System.out.println("#Titular: " + deposita.getTitular());
		System.out.println("Transferencia para o titular: " + recebe.getTitular());
		System.out.println("Seu saldo é de: " + deposita.getSaldo());
		System.out.println("Transferência realizada com sucesso!");
		if(deposita.getSaldo()<0){
			System.out.println("Seu Cheque especial é de: " + deposita.getSaldoEspecial());
		}
	}

	public static void main(String[] args) {
		
		Conta c1 = new ContaCorrente("1611-x", "6854-0", "Fulano", "09/08/2015", 1500);
		Conta c2 = new ContaCorrente("4587-2", "1312-x", "Siclano", "03/04/2015", 2000);
		Conta c3 = new ContaCorrente("4587-2", "1312-x", "Siclano", "03/04/2015", 2000, 200);

		ContaPoupanca cp1 = new ContaPoupanca("1111-x", "2222-5", "Beltrano", "08/10/2014", 1000);
		ContaPoupanca cp2 = new ContaPoupanca("3333-x", "4444-6", "Maria", "03/03/2015", 1000, 400);

		// Simulações de SAQUE.
		try {
			c1.saque(-250);
			Banco.imprimirSaque(c1);
		} catch (Exception e) {
			System.out.println("Saque não realizado: " + e.getMessage());
		}
		System.out.println("");
		try {
			c1.saque(2000);
			Banco.imprimirSaque(c1);
		} catch (Exception e) {
			System.out.println("Saque não realizado: " + e.getMessage());
		}
		System.out.println("");
		try {
			c2.saque(25);
			Banco.imprimirSaque(c2);
		} catch (Exception e) {
			System.out.println("Saque não realizado: " + e.getMessage());
		}
		System.out.println("");
		try {
			c3.saque(2100);
			Banco.imprimirSaque(c3);
		} catch (Exception e) {
			System.out.println("Saque não realizado: " + e.getMessage());
		}
		System.out.println("");
		try {
			cp1.saque(350);
			Banco.imprimirSaque(cp1);
		} catch (Exception e) {
			System.out.println("Saque não realizado: " + e.getMessage());
		}

		System.out.println("");

		// Simulações de DEPÓSITOS.
		try {
			c1.deposito(10);
			Banco.imprimirDeposito(c1);
		} catch (Exception e) {
			System.out.println("Depósito não realizado: " + e.getMessage());
		}
		System.out.println("");
		try {
			c2.deposito(25);
			Banco.imprimirDeposito(c2);
		} catch (Exception e) {
			System.out.println("Depósito não realizado: " + e.getMessage());
		}
		System.out.println("");
		try {
			c3.deposito(-30);
			Banco.imprimirDeposito(c2);
		} catch (Exception e) {
			System.out.println("Depósito não realizado: " + e.getMessage());
		}
		
		System.out.println("");

		// Simulações de TRANSFERÊNCIAS.
		try {
			c1.trasnferencia(c2, 200);
			Banco.imprimirTransferencia(c1, c2);
		} catch (Exception e) {
			System.out.println("Transferência não realizada: " + e.getMessage());
		}
		System.out.println("");
		try {
			c1.trasnferencia(cp2, 200);
			Banco.imprimirTransferencia(c1, cp2);
		} catch (Exception e) {
			System.out.println("Transferência não realizada: " + e.getMessage());
		}
		System.out.println("");
		try {
			c1.trasnferencia(cp2, -200);
			Banco.imprimirTransferencia(c1, cp2);
		} catch (Exception e) {
			System.out.println("Transferência não realizada: " + e.getMessage());
		}
		System.out.println("");
		try {
			cp2.trasnferencia(c2, 1300);
			Banco.imprimirTransferencia(cp2, c2);
		} catch (Exception e) {
			System.out.println("Transferência não realizada: " + e.getMessage());
		}

		System.out.println("");

		// Simulações de RENDIMENTO POUPANÇA.
		try {
			System.out.println("Titular: " + cp1.getTitular());
			ContaPoupanca.rendimento(cp1, "11/11/2014");
		} catch (Exception e) {
			System.out.println(e.getMessage() + " " + cp1.getDtAbertura());
		}
		System.out.println("");
		try {
			System.out.println("Titular: " + cp1.getTitular());
			ContaPoupanca.rendimento(cp1, "11/11/2016");
		} catch (Exception e) {
			System.out.println(e.getMessage() + " " + cp1.getDtAbertura());
		}
	}

}
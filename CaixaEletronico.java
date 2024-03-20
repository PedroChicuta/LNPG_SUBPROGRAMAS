import java.util.Scanner;
public class CaixaEletronico {
    static double saldo = 1000.00;

	public static class OperacoesSaque{
		static void mostrarSaldoInsuficiente(){
			System.out.println("Saldo insuficiente.");
		}
		static void mostrarValorDoSaque(double valor){
			System.out.println("Saque de R$" + valor + " realizado.");
		}
		static double DefinirValorSaque(){
			System.out.println("Digite o valor do saque:");
			double valor = PegarValor();
			return valor;
		}
		static void sacar(double valor){
			saldo -= valor;
		}
	}
	public static class OperacoesDeposito{
		static void mostrarValorDoDeposito(double valor){
			System.out.println("Depósito de R$" + valor + " realizado.");
		}
		static double DefinirValorDeposito(){
			System.out.println("Digite o valor do depósito:");
			double valor = PegarValor();
			return valor;
		}
		static void depositar(double valor){
			saldo += valor;
		}
	}
	static void saque(){
		double valor = OperacoesSaque.DefinirValorSaque();
        if (valor > saldo) {
        	OperacoesSaque.mostrarSaldoInsuficiente();
        } else {
        	OperacoesSaque.sacar(valor);
        	OperacoesSaque.mostrarValorDoSaque(valor);
        }
	}
	static void deposito(){
		double valor = OperacoesDeposito.DefinirValorDeposito();
        OperacoesDeposito.depositar(valor);
        OperacoesDeposito.mostrarValorDoDeposito(valor);
	}
	static double PegarValor(){
		Scanner scaner = new Scanner(System.in);
		double valor;
		valor = scaner.nextDouble();
		scaner.close();
		return valor;
	}
	static void mostrarMenu(){
		System.out.println("Bem-vindo ao Caixa Eletrônico");
    	System.out.println("Seu saldo atual é: R$" + saldo);
    	System.out.println("Escolha uma opção:");
    	System.out.println("1 - Saque");
    	System.out.println("2 - Depósito");
    	System.out.println("3 - Consultar Saldo");
	}
	static void exibirSaldo(){
		System.out.println("Seu saldo atual é: R$" + saldo);
	}
	static void opcaoInvalida(){
		System.out.println("Opção inválida.");
	}
	static void escolherOperacao(int opcao){
		switch (opcao) {
			case 1:
				saque();
				break;
			case 2:
				deposito();
				break;
			case 3:
				exibirSaldo();
				break;
			default:
				opcaoInvalida();
				break;
		}
	}
	    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	int opcao;
		mostrarMenu();
    	opcao = scanner.nextInt();
		escolherOperacao(opcao);
    	scanner.close();
    }
}



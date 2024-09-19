package ordenacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import dados.Item;

public class ProgramaPrincipal {
	
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int tamanho = 0, tan;
		String tipoArquivo = "";
		Arquivos.criarPasta();

		System.out.println("Qual o tamnho do vetor que deseja ordenar: " + "\n1. 100" + "\n2. 10000");

		tan = scanner.nextInt();
		switch (tan) {
		case 1:
			tamanho = 100;
			tipoArquivo = tipoArquivo100();
			break;

		case 2:
			tamanho = 10000;
			tipoArquivo = tipoArquivo10000();
			break;
		}

		Vetor vetor = new Vetor(tamanho);
		Arquivos.leitor(tipoArquivo, vetor);

		if (tan == 1) {
			menu100(vetor);
		} else if (tan == 2) {
			menu10000(vetor);
		}

	}

	public static void menu100(Vetor vetor) {

		int opcao;

		System.out.println("\n---- ORDENACAO DE DADOS -----\n");
		System.out.println("Selecione o valor do tipo de ordenação desejado: "
				+ "\n1. Seleção Direta"
				+ "\n2. Heapsort"
				+ "\n3. Inserção Direta"
				+ "\n4. Shellsort"
				+ "\n5. Bubblesort"
				+ "\n6. Shakesort"
				+ "\n7. Quicksort");
		
		opcao = scanner.nextInt();

		switch (opcao) {
		case 1:
			vetor.selecaoDireta();
			System.out.println("Num. Comparacoes: \n" + vetor.getComparacoes());
			System.out.println("Num. movimentação: \n" + vetor.getMovimentacoes());
			break;

		case 2:
			vetor.heapSort();
			System.out.println("Num. Comparacoes: \n" + vetor.getComparacoes());
			System.out.println("Num. movimentação: \n" + vetor.getMovimentacoes());
			break;

		case 3:
			vetor.insercao();
			System.out.println("Num. Comparacoes: \n" + vetor.getComparacoes());
			System.out.println("Num. movimentação: \n" + vetor.getMovimentacoes());
			break;

		case 4:
			vetor.shellSort();
			System.out.println("Num. Comparacoes: \n" + vetor.getComparacoes());
			System.out.println("Num. movimentação: \n" + vetor.getMovimentacoes());
			break;

		case 5:
			vetor.bubblesort();
			System.out.println("Num. Comparacoes: \n" + vetor.getComparacoes());
			System.out.println("Num. movimentação: \n" + vetor.getMovimentacoes());
			break;

		case 6:
			vetor.shakerSort();
			System.out.println("Num. Comparacoes: \n" + vetor.getComparacoes());
			System.out.println("Num. movimentação: \n" + vetor.getMovimentacoes());
			break;

		case 7:
			vetor.quicksort();
			System.out.println("Num. Comparacoes: \n" + vetor.getComparacoes());
			System.out.println("Num. movimentação: \n" + vetor.getMovimentacoes());
			break;

		default:
			System.out.println("Opção inválida, tente novamente.");
			break;
		}
	}

	public static void menu10000(Vetor vetor) {

		int opcao;

		System.out.println("\n---- ORDENACAO DE DADOS -----\n");
		System.out.println("Selecione o valor do tipo de ordenação desejado: "
				+ "\n1. Seleção Direta"
				+ "\n2. Heapsort"
				+ "\n3. Inserção Direta"
				+ "\n4. Shellsort"
				+ "\n5. Bubblesort"
				+ "\n6. Shakesort"
				+ "\n7. Quicksort");

		opcao = scanner.nextInt();

		switch (opcao) {
		case 1:
			vetor.selecaoDireta();
			System.out.println("Num. Comparacoes: \n" + vetor.getComparacoes());
			System.out.println("Num. movimentação: \n" + vetor.getMovimentacoes());
			break;

		case 2:
			vetor.heapSort();
			System.out.println("Num. Comparacoes: \n" + vetor.getComparacoes());
			System.out.println("Num. movimentação: \n" + vetor.getMovimentacoes());
			break;

		case 3:
			vetor.insercao();
			System.out.println("Num. Comparacoes: \n" + vetor.getComparacoes());
			System.out.println("Num. movimentação: \n" + vetor.getMovimentacoes());
			break;

		case 4:
			vetor.shakerSort();
			System.out.println("Num. Comparacoes: \n" + vetor.getComparacoes());
			System.out.println("Num. movimentação: \n" + vetor.getMovimentacoes());
			break;

		case 5:
			vetor.bubblesort();
			System.out.println("Num. Comparacoes: \n" + vetor.getComparacoes());
			System.out.println("Num. movimentação: \n" + vetor.getMovimentacoes());
			break;

		case 6:
			vetor.shakerSort();
			System.out.println("Num. Comparacoes: \n" + vetor.getComparacoes());
			System.out.println("Num. movimentação: \n" + vetor.getMovimentacoes());
			break;

		case 7:
			vetor.quicksort();
			System.out.println("Num. Comparacoes: \n" + vetor.getComparacoes());
			System.out.println("Num. movimentação: \n" + vetor.getMovimentacoes());
			break;

		default:
			System.out.println("Opção inválida, tente novamente.");
			break;
		}

	}

	public static String tipoArquivo100() {

		String tipo = "";
		int opcao;

		System.out.println("\n Digite o valor da opção do tipo de arquivo que deseja: " + "\n1. Random"
				+ "\n2. Ordenado" + "\n3. Reverso");

		opcao = scanner.nextInt();

		switch (opcao) {
		case 1:
			tipo = "C:\\TesteArquivo\\texto.txt";
			break;
		case 2:
			tipo = "C:\\TesteArquivo\\texto2.txt";
			break;
		case 3:
			tipo = "C:\\TesteArquivo\\texto3.txt";
			break;
		default:
			System.out.println("Opção inválida, tente novamente!");
			break;
		}

		return (tipo);
	}

	public static String tipoArquivo10000() {

		String tipo = "";
		int opcao;

		System.out.println("\n Digite o valor da opção do tipo de arquivo que deseja: " + "\n1. Random"
				+ "\n2. Ordenado" + "\n3. Reverso");

		opcao = scanner.nextInt();

		switch (opcao) {
		case 1:
			tipo = "C:\\TesteArquivo\\texto4.txt";
			break;
		case 2:
			tipo = "C:\\TesteArquivo\\texto5.txt";
			break;
		case 3:
			tipo = "C:\\TesteArquivo\\texto6.txt";
			break;
		default:
			System.out.println("Opção inválida, tente novamente!");
			break;
		}

		return (tipo);
	}
}

package ordenacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import dados.Item;
//import jdk.jshell.SourceCodeAnalysis;

public class TestarOrdenacao {

	public static void main(String[] args) throws IOException{
		Vetor vetor = new Vetor(100);
		Scanner scan = new Scanner(System.in);
		
		Arquivos.criarPasta();
		
		String path = "C:\\TesteArquivo\\texto.txt";
		String path2 = "C:\\TesteArquivo\\texto2.txt";
		String path3 = "C:\\TesteArquivo\\texto3.txt";
		
		String path4 = "C:\\TesteArquivo\\texto4.txt";
		String path5 = "C:\\TesteArquivo\\texto5.txt";
		String path6 = "C:\\TesteArquivo\\texto6.txt";
		
		
		
		Arquivos.escritorRandom(path);
		Arquivos.escritorOrdenado(path2);
		Arquivos.escritorReverso(path3);
		Arquivos.leitor(path);
		TestarOrdenacao.leitor(path, vetor);
		
		
		vetor.insercaoDireta();
		System.out.println("\nVetor ordenado: \n" + vetor.toString());
		System.out.println("Num. Comparacoes: \n" + vetor.getComparacaoinsert());
		System.out.println("Num. movimentação: \n" + vetor.getMovimentacaoinset());
		
		
		
		
		//vetor.heapSort();
		//System.out.println("Num. Comparacoes: \n" + vetor.contComparacaoHeap() + "\nVetor ordenado: \n" + vetor.toString());
		//Arquivos.escritorReverso(path3);
		//Arquivos.escritorRandom10000(path4);
		//Arquivos.escritorOrdenado10000(path5);
		//Arquivos.escritorReverso10000(path6);
	}
		
		public static void leitor(String path, Vetor vetor) throws IOException {
			BufferedReader buffRead = new BufferedReader(new FileReader(path));
			String linha = buffRead.readLine();
			Integer vetorLocal[] = new Integer[100];
			int i = 0;
			while (true) {
				if (linha != null) {
					vetorLocal[i] = Integer.parseInt(linha);
					vetor.inserirDados(new Item(vetorLocal[i]));
					i++;
					//System.out.println(vetorLocal[i-1]);
				} else {
					break;
				}
				
				linha = buffRead.readLine();
			}
			buffRead.close();
		}
		
		
		
		
		
		
		
		//entrada de dados
		/*for (int i=0; i< 10; i++) {
			System.out.println("Digite um n�mero inteiro: ");
			vetor.inserirDados(new Item(scan.nextInt())) ;
		}
		System.out.println("vetor desordenado\n"+vetor.toString());

//coloque aqui o metodo a ser testado
		vetor.heapSort();

//resultado
		System.out.println("\nvetor ordenado\n"+vetor.toString());*/
	}

	



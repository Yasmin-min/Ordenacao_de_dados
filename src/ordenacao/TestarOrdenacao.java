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
		
		
		
		//Arquivos.escritorRandom(path);
		//Arquivos.escritorOrdenado(path2);
		//Arquivos.escritorReverso(path3);
		//Arquivos.leitor(path);
		Arquivos.leitor(path, vetor);
		
		/*
		vetor.selecaoDireta();
		System.out.println("\nVetor ordenado: \n" + vetor.toString());
		System.out.println("Num. Comparacoes: \n" + vetor.getComparacaoSelecao());
		System.out.println("Num. movimentação: \n" + vetor.getMovimentacaoSelecao());
		*/
		
		
		vetor.bubblesort();  
		System.out.println("\nVetor ordenado: \n" + vetor.toString());
		//System.out.println("Num. Comparacoes: \n" + vetor.getContComparacaoBubble());
		//System.out.println("Num. movimentação: \n" + vetor.getContTrocaBubble());
		
		
		
		
		//vetor.heapSort();
		//System.out.println("Num. Comparacoes: \n" + vetor.contComparacaoHeap() + "\nVetor ordenado: \n" + vetor.toString());
		//Arquivos.escritorReverso(path3);
		//Arquivos.escritorRandom10000(path4);
		//Arquivos.escritorOrdenado10000(path5);
		//Arquivos.escritorReverso10000(path6);
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
	//}

	

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        boolean opcaoValida = false;

        while (!opcaoValida) {
            System.out.println("---- ORDENACAO DE DADOS -----");
            System.out.println("Selecione o valor do tipo de ordenação desejado: "
                    + "\n1. Seleção Direta;"
                    + "\n2. Heapsort;"
                    + "\n3. Inserção Direta;"
                    + "\n4. Shellsort;"
                    + "\n5. Bubblesort;"
                    + "\n6. Shakesort;"
                    + "\n7. Quicksort");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                	String path = tipoArquivo();
                	Vetor vetor = new Vetor(tamanho());
            		//Arquivos.leitor(path, vetor);

                    System.out.println("Selecionou Seleção Direta");
                    opcaoValida = true;
                    break;
                case 2:
                    System.out.println("Selecionou Heapsort");
                    opcaoValida = true;
                    break;
                case 3:
                    System.out.println("Selecionou Inserção Direta");
                    opcaoValida = true;
                    break;
                case 4:
                    System.out.println("Selecionou Shellsort");
                    opcaoValida = true;
                    break;
                case 5:
                    System.out.println("Selecionou Bubblesort");
                    opcaoValida = true;
                    break;
                case 6:
                    System.out.println("Selecionou Shakesort");
                    opcaoValida = true;
                    break;
                case 7:
                    System.out.println("Selecionou Quicksort");
                    opcaoValida = true;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
    
    public String tipoArquivo() {
        Scanner scanner = new Scanner(System.in);
    	String tipo= ""; 
    	int opcao;
    	
    	System.out.println("1. Random;"
    			+"\n2. Ordenado"
    			+"\n3. Reverso"
    			+"\n Digite o valor da opção do tipo de arquivo que deseja: ");
    	
    	opcao = scanner.nextInt();
    	
    	switch (opcao){
    		case 1: 
    			tipo = "path";
    			break;
    		case 2: 
    			tipo = "path2";
    			break;
    		case 3: 
    			tipo = "path3";
    			break; 
    		default: 
    			System.out.println("Opção inválida, tente novamente.");
                break;
    	}
    	
    	return (tipo); 
    }
    
    public int tamanho() {
        Scanner scanner = new Scanner(System.in);
        
    	int opcao, tamanho=0;
    	
    	
    	System.out.print("Escolha a opção do tamanho desejado do vetor: "
    			+"\n1. 100;"
    			+ "\n2. 10.000"
    			+"\n3. Escolher o tamanho");
    	opcao = scanner.nextInt();
    	
    	switch (opcao) { 
    	case 1: 
    		tamanho = 100;
    		break;
    		
    	case 2: 
    		tamanho= 10000;
    		break; 
    		
    	case 3: 
    		System.out.print("Digite o tamanho desejado: ");
    		tamanho = scanner.nextInt();
    		
    	default: 
			System.out.println("Opção inválida, tente novamente.");
            break;
    		
    	}
    	
    	return (tamanho); 
    }
    
    public void criarPasta() {
    	Arquivos.criarPasta();
		
		String path = "C:\\TesteArquivo\\texto.txt";
		String path2 = "C:\\TesteArquivo\\texto2.txt";
		String path3 = "C:\\TesteArquivo\\texto3.txt";
		
		String path4 = "C:\\TesteArquivo\\texto4.txt";
		String path5 = "C:\\TesteArquivo\\texto5.txt";
		String path6 = "C:\\TesteArquivo\\texto6.txt";
		
    }
}

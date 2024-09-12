package ordenacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import dados.Item;

public class ProgramaPrincipal {

	public static void main(String[] args) throws IOException{
		
		criarPastas();
		menu();
		
		Vetor vetor = new Vetor(tamanho());
		Arquivos.leitor(tipoArquivo(), vetor);
		
		
	}
	
	public static void menu() {
        Scanner scanner = new Scanner(System.in);
        Arquivos.criarPasta();
        
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
                	String path = tipoArquivo();                	

                    System.out.println("Selecionou Seleção Direta");
                    break;
                case 2:
                    System.out.println("Selecionou Heapsort");
                    break;
                case 3:
                    System.out.println("Selecionou Inserção Direta");
                    break;
                case 4:
                    System.out.println("Selecionou Shellsort");
                    break;
                case 5:
                    System.out.println("Selecionou Bubblesort");
                    break;
                case 6:
                    System.out.println("Selecionou Shakesort");
                    break;
                case 7:
                    System.out.println("Selecionou Quicksort");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        

        scanner.close();
    }
	
	 public static String tipoArquivo() {
	        Scanner scanner = new Scanner(System.in);
	    	String tipo= ""; 
	    	int opcao;
	    	
	    	System.out.println("\n Digite o valor da opção do tipo de arquivo que deseja: "
	    			+"\n1. Random"
	    			+"\n2. Ordenado"
	    			+"\n3. Reverso" );
	    	
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
	    			System.out.println("Opção inválida, tente novamente!");
	                break;
	    	}
	    	
	    	return (tipo); 
	    }
	    
	    public static int tamanho() {
	        Scanner scanner = new Scanner(System.in);
	        
	    	int opcao, tamanho = 0; 
	   
	    	
	    	
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
	    
	    public static void criarPastas() throws IOException {
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
			
	    }
}

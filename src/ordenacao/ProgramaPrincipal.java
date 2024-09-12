package ordenacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import dados.Item;

public class ProgramaPrincipal {
	
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException{
		
		//Arquivos.criarPasta();
		
		String path = "C:\\TesteArquivo\\texto.txt";
		String path2 = "C:\\TesteArquivo\\texto2.txt";
		String path3 = "C:\\TesteArquivo\\texto3.txt";
		
		String path4 = "C:\\TesteArquivo\\texto4.txt";
		String path5 = "C:\\TesteArquivo\\texto5.txt";
		String path6 = "C:\\TesteArquivo\\texto6.txt";
		
		Arquivos.escritorRandom(path);
		Arquivos.escritorOrdenado(path2);
		Arquivos.escritorReverso(path3);
		
		Arquivos.escritorRandom10000(path4);
		Arquivos.escritorOrdenado10000(path5);
		Arquivos.escritorReverso10000(path6);
		
		Vetor vetor1 = new Vetor(100);
		Vetor vetor2 = new Vetor(10000);
		
		char continuar;
		
		do {
			
			
			if(tamanho(vetor1, vetor2) == 1) {
				
				
			} else { 
				
				Arquivos.leitor10000(tipoArquivo() , vetor2);				
			}
			
			
			
			menu();
			
			
			System.out.println("Deseja fazer outra ordenação? [S/N]");
			continuar = scanner.next().charAt(0);
			continuar = Character.toUpperCase(continuar);
			if(continuar == 'N') {
				System.out.println("Programa finalizando...");
			}
			
		} while (continuar == 'S');
		
		System.out.print("Programa finalizado!");
		
	}
	
	public static void menu() {
        
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
        

    }
	
	public static int  tamanho(Vetor vetor1, Vetor vetor2) throws IOException {
		
		
		System.out.println("Qual o tamnho de vetor você desenha ordenar? "
				+ "\n1. 100"
				+ "\n2. 10000");
		
		int opcao = scanner.nextInt();
		
		switch (opcao) {
		case 1: 
			Arquivos.leitor(tipoArquivo() , vetor1);	
			break;
		case 2: 
			Arquivos.leitor(tipoArquivo10000() , vetor2);	
			break;
		}
		return opcao; 
	}
	
	
	 public static String tipoArquivo() {
	        
	    	String tipo= ""; 
	    	int opcao;
	    	
	    	System.out.println("\n Digite o valor da opção do tipo de arquivo que deseja: "
	    			+"\n1. Random"
	    			+"\n2. Ordenado"
	    			+"\n3. Reverso"  );
	    	
	    	opcao = scanner.nextInt();
	    	
	    	switch (opcao){
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
	        
	    	String tipo= ""; 
	    	int opcao;
	    	
	    	System.out.println("\n Digite o valor da opção do tipo de arquivo que deseja: "
	    			+"\n1. Random"
	    			+"\n2. Ordenado"
	    			+"\n3. Reverso"  );
	    	
	    	opcao = scanner.nextInt();
	    	
	    	switch (opcao){
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

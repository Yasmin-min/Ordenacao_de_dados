package ordenacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import dados.Item;


public class Arquivos {
	
	public static void criarPasta() {
		String caminhoPasta = "C:\\TesteArquivo"; // Substitua pelo caminho e nome da pasta desejada
	    
	    // Criando um objeto File com o caminho especificado
	    File pasta = new File(caminhoPasta);

	    // Verifica se a pasta já existe
	    if (!pasta.exists()) {
	        // Cria a pasta
	        if (pasta.mkdirs()) {
	            System.out.println("Pasta criada com sucesso: " + pasta.getAbsolutePath());
	        } else {
	            System.out.println("Falha ao criar a pasta.");
	        }
	    } else {
	        System.out.println("A pasta já existe.");
	    }
	}
	
	public static void escritorRandom(String path) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		for(int i = 0; i < 100; i++) {
			double num = Math.random() * 500;
			int randomNum = (int)num;
			buffWrite.append(randomNum + "\n");
		}
		buffWrite.close();
	}
	public static void escritorOrdenado(String path2) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path2));
		ArrayList<Integer> numOrdenado = new ArrayList<Integer>();
		for(int i = 0; i < 100; i++) {
			double num = Math.random() * 500;
			Integer num2 = (int)num;
			numOrdenado.add(num2);
		}
		numOrdenado.sort(null);
		for(int i = 0; i < 100; i++) {
		buffWrite.append(numOrdenado.get(i) + "\n");
		}
		buffWrite.close();
	}
	
	public static void escritorReverso(String path3) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path3));
		ArrayList<Integer> numOrdenado = new ArrayList<Integer>();
		for(int i = 0; i < 100; i++) {
			double num = Math.random() * 500;
			Integer num2 = (int)num;
			numOrdenado.add(num2);
		}
		Collections.sort(numOrdenado, Collections.reverseOrder());
		
		for(int i = 0; i < 100; i++) {
		buffWrite.append(numOrdenado.get(i) + "\n");
		}
		buffWrite.close();
	}
	
	public static void escritorRandom10000(String path) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		for(int i = 0; i < 10000; i++) {
			double num = Math.random() * 10000;
			int randomNum = (int)num;
			buffWrite.append(randomNum + "\n");
		}
		buffWrite.close();
	}
	
	public static void escritorOrdenado10000(String path2) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path2));
		ArrayList<Integer> numOrdenado = new ArrayList<Integer>();
		for(int i = 0; i < 10000; i++) {
			double num = Math.random() * 10000;
			Integer num2 = (int)num;
			numOrdenado.add(num2);
		}
		numOrdenado.sort(null);
		for(int i = 0; i < 10000; i++) {
		buffWrite.append(numOrdenado.get(i) + "\n");
		}
		buffWrite.close();
	}
	public static void escritorReverso10000(String path3) throws IOException {
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path3));
		ArrayList<Integer> numOrdenado = new ArrayList<Integer>();
		for(int i = 0; i < 10000; i++) {
			double num = Math.random() * 10000;
			Integer num2 = (int)num;
			numOrdenado.add(num2);
		}
		Collections.sort(numOrdenado, Collections.reverseOrder());
		
		for(int i = 0; i < 10000; i++) {
		buffWrite.append(numOrdenado.get(i) + "\n");
		}
		buffWrite.close();
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
			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();
	}
	public static void leitor10000(String path, Vetor vetor) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = buffRead.readLine();
		Integer vetorLocal[] = new Integer[10000];
		int i = 0;
		while (true) {
			if (linha != null) {
				vetorLocal[i] = Integer.parseInt(linha);
				vetor.inserirDados(new Item(vetorLocal[i]));
				i++;
				//System.out.println(vetorLocal[i-1]);
			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();
	}
	
	
}

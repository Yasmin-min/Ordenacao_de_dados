package pesquisa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import dados.ItemP;

public class Pesquisa {

    public static boolean pesquisaSeq(int x, int numeros[]) {
        for (int i = 0; i < numeros.length; i++)
            if (x == numeros[i])
                return true;
        return false;
    }

    public static boolean pesquisaSeq(String x, String palavras[]) {
        for (int i = 0; i < palavras.length; i++)
            if (x.equalsIgnoreCase(palavras[i]))
                return true;
        return false;
    }

    public static boolean pesquisaSeqMelhorada(int x, int numeros[]) {
        for (int i = 0; i < numeros.length && x <= numeros[i]; i++)
            if (x == numeros[i])
                return true;
        return false;
    }

    public static boolean pesquisaBinaria(int x, int numeros[]) {
        int inicio = 0, fim = numeros.length - 1;
        int meio;
        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            if (x == numeros[meio])
                return true;
            if (x < numeros[meio])
                fim = meio - 1;
            else
                inicio = meio + 1;
        }
        return false;
    }

    
}

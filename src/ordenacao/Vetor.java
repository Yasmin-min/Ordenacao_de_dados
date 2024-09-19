package ordenacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import dados.Item;

public class Vetor {

	private Item[] vetor;
	private int nElem;
	private int comparacoes;
	private int movimentacoes;

	public Vetor(int tamanho) {
		this.vetor = new Item[tamanho];
		this.nElem = 0;
		this.comparacoes = 0;
		this.movimentacoes = 0;
	}

	public int getComparacoes() {
		return comparacoes;
	}

	public int getMovimentacoes() {
		return movimentacoes;
	}

	private void resetContadores() {
		this.comparacoes = 0;
		this.movimentacoes = 0;
	}

	public boolean inserirDados(Item novo) {
		if (this.nElem == this.vetor.length) {
			return false;
		} else {
			this.vetor[this.nElem] = novo;
			this.nElem++;
			return true;
		}
	}

	public void insercao() {
		resetContadores();
		int i, j;
		Item chave;
		for (i = 1; i < this.nElem; i++) {
			chave = this.vetor[i];
			j = i - 1;
			comparacoes++;
			while (j >= 0 && this.vetor[j].getChave() > chave.getChave()) {
				comparacoes++;
				this.vetor[j + 1] = this.vetor[j--];
				movimentacoes++;
			}
			this.vetor[j + 1] = chave;
		}
	}

	public void selecaoDireta() {
		resetContadores();
		int i, j, minimo;
		Item temp;
		for (i = 0; i < this.nElem - 1; i++) {
			minimo = i;
			for (j = i + 1; j < this.nElem; j++) {
				comparacoes++;
				if (this.vetor[j].getChave() < this.vetor[minimo].getChave()) {
					minimo = j;
				}
			}
			temp = this.vetor[minimo];
			this.vetor[minimo] = this.vetor[i];
			this.vetor[i] = temp;
			movimentacoes++;
		}
	}

	public void bubblesort() {
		resetContadores();
		int n, i, j;
		Item temp;
		n = this.nElem - 1;
		do {
			i = 0;
			for (j = 0; j < n; j++) {
				comparacoes++;
				if (this.vetor[j].getChave() > this.vetor[j + 1].getChave()) {
					temp = this.vetor[j];
					this.vetor[j] = this.vetor[j + 1];
					this.vetor[j + 1] = temp;
					movimentacoes++;
					i = j;
				}
			}
			n = i;
		} while (n >= 1);
	}

	public void shakerSort() {
		resetContadores();
		int inicio = 0;
		int fim = this.nElem - 1;
		Item temp;
		boolean trocado = true;
		while (inicio < fim && trocado) {
			trocado = false;
			for (int i = inicio; i < fim; i++) {
				comparacoes++;
				if (this.vetor[i].getChave() > this.vetor[i + 1].getChave()) {
					temp = this.vetor[i];
					this.vetor[i] = this.vetor[i + 1];
					this.vetor[i + 1] = temp;
					movimentacoes++;
					trocado = true;
				}
			}
			fim--;
			if (!trocado)
				break;
			trocado = false;
			for (int i = fim; i > inicio; i--) {
				comparacoes++;
				if (this.vetor[i].getChave() < this.vetor[i - 1].getChave()) {
					temp = this.vetor[i];
					this.vetor[i] = this.vetor[i - 1];
					this.vetor[i - 1] = temp;
					movimentacoes++;
					trocado = true;
				}
			}
			inicio++;
		}
	}

	public void shellSort() {
		resetContadores();
		int i, j, h;
		Item temp;
		h = 1;
		do {
			h = 3 * h + 1;
		} while (h < this.nElem);
		do {
			h = h / 3;
			for (i = h; i < this.nElem; i++) {
				temp = this.vetor[i];
				j = i;
				comparacoes++;
				while (this.vetor[j - h].getChave() > temp.getChave()) {
					comparacoes++;
					this.vetor[j] = this.vetor[j - h];
					movimentacoes++;
					j -= h;
					if (j < h)
						break;
				}
				this.vetor[j] = temp;
			}
		} while (h != 1);
	}

	public void heapSort() {
		resetContadores();
		int dir = nElem - 1;
		int esq = (dir - 1) / 2;
		Item temp;
		while (esq >= 0)
			refazHeap(esq--, this.nElem - 1);
		while (dir > 0) {
			temp = this.vetor[0];
			this.vetor[0] = this.vetor[dir];
			this.vetor[dir--] = temp;
			movimentacoes++;
			refazHeap(0, dir);
		}
	}

	private void refazHeap(int esq, int dir) {
		int i = esq;
		int MaiorFolha = 2 * i + 1;
		Item raiz = this.vetor[i];
		boolean heap = false;
		while ((MaiorFolha <= dir) && (!heap)) {
			if (MaiorFolha < dir) {
				comparacoes++;
				if (this.vetor[MaiorFolha].getChave() < this.vetor[MaiorFolha + 1].getChave()) {
					MaiorFolha++;

				}
			}
			comparacoes++;
			if (raiz.getChave() < this.vetor[MaiorFolha].getChave()) {
				this.vetor[i] = this.vetor[MaiorFolha];
				i = MaiorFolha;
				MaiorFolha = 2 * i + 1;
				movimentacoes++;

			} else
				heap = true;
		}
		this.vetor[i] = raiz;
	}

	public void quicksort() {
		resetContadores();
		ordena(0, this.nElem - 1);
	}

	private void ordena(int esq, int dir) {
		int pivo, i = esq, j = dir;
		Item temp;
		pivo = this.vetor[(i + j) / 2].getChave();
		do {
			comparacoes++;
			while (this.vetor[i].getChave() < pivo) {
				comparacoes++;
				i++;
			}
			comparacoes++;
			while (this.vetor[j].getChave() > pivo) {
				comparacoes++;
				j--;
			}
			if (i <= j) {
				movimentacoes++;
				temp = this.vetor[i];
				this.vetor[i] = this.vetor[j];
				this.vetor[j] = temp;
				i++;
				j--;
			}
		} while (i <= j);
		if (esq < j) {
			ordena(esq, j);
		}
		if (dir > i) {
			ordena(i, dir);
		}
	}

	public String toString() {
		StringBuilder msg = new StringBuilder();
		for (int i = 0; i < this.nElem; i++) {
			msg.append(this.vetor[i].getChave()).append(" ");
		}
		return msg.toString();
	}

	public void lerDadosDeArquivo(String caminho) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(caminho));
		String linha;
		this.nElem = 0;
		while ((linha = br.readLine()) != null) {
			if (this.nElem < this.vetor.length) {
				int chave = Integer.parseInt(linha.trim());
				this.vetor[this.nElem] = new Item(chave);
				this.nElem++;
			}
		}
		br.close();
	}
}
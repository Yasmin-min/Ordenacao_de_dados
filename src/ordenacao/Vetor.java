package ordenacao;

import java.util.Arrays;

import dados.Item;

public class Vetor {

	private Item[] vetor;
	private int nElem;
	private int contComparacaoHeap;
	private int movimentacaoHeap;
	private int contComparacaoBubble;
	private int contTrocaBubble;
	private int comparacaoinsert; 
	private int movimentacaoinset;
	private int movimentacaoSelecao;
	private int ComparacaoSelecao;
	private int movimentacaoshell;
	private int comparacaoshell;
	private int contComparacaoShaker;
	private int contTrocaShaker;
	private static int contComparacaoQuick;
	private static int contTrocaQuick;
	
	public Vetor(int tamanho) {
		this.vetor = new Item[tamanho];
		this.nElem = 0;
	}
	
	public void setnElem(int nElem) {
		this.nElem = nElem;
	}
	public static int getContComparacaoQuick() {
		return contComparacaoQuick;
	}

	public static int getContTrocaQuick() {
		return contTrocaQuick;
	}
	public int getContComparacaoShaker() {
		return contComparacaoShaker;
	}

	public int getContTrocaShaker() {
		return contTrocaShaker;
	}

	public int getContComparacaoBubble() {
		return contComparacaoBubble;
	}

	public int getContTrocaBubble() {
		return contTrocaBubble;
	}

	public int getcontComparacaoHeap() {
		return contComparacaoHeap;
	}
	
	public int getMovimentacaoHeap() {
		return movimentacaoHeap;
	}

	public int getnElem() {
		return nElem;
	}

	public int getComparacaoinsert() {
		return comparacaoinsert;
	}

	public int getMovimentacaoinset() {
		return movimentacaoinset;
	}
	
	public int getMovimentacaoSelecao() {
		return movimentacaoSelecao;
	}

	public int getComparacaoSelecao() {
		return ComparacaoSelecao;
	}
	
	public int getMovimentacaoshell() {
		return movimentacaoshell;
	}

	public int getComparacaoshell() {
		return comparacaoshell;
	}
	
	public String toString() {
		String msg = "";
		for (int i = 0; i < this.nElem; i++) {
			msg += this.vetor[i].getChave() + "\n";
		}
		return msg;
	}

	public boolean inserirDados(Item novo) {
		if (this.nElem == this.vetor.length) { // verifica se est� cheio
			return false;
		} else {
			this.vetor[this.nElem] = novo;
			this.nElem++;
			return true;
		}
	}


	public void selecaoDireta() {
		int i, j, minimo;
		Item temp;
		for (i = 0; i < this.nElem - 1; i++) {
			minimo = i;
			for (j = i + 1; j < this.nElem; j++) {
				ComparacaoSelecao++;
				if (this.vetor[j].getChave() < this.vetor[minimo].getChave()) {
					minimo = j;
					
				}
			}
			temp = this.vetor[minimo];
			this.vetor[minimo] = this.vetor[i];
			this.vetor[i] = temp;
			movimentacaoSelecao++;
		}
	}

	public void bubblesort (){ 
		int n, i, j;
		Item temp;
		n = this.nElem-1;
		do{
			i = 0;
			
			for (j = 0; j < n; j++) {
				contComparacaoBubble++;
				if (this.vetor[j].getChave() > this.vetor[j+1].getChave()){
					temp = this.vetor[j];
					this.vetor[j] = this.vetor[j+1];
					this.vetor[j+1] = temp;
					contTrocaBubble++;
					i = j;
				}
			}
			n = i;
		}while(n >= 1);
	}

	public void heapSort() {
		int dir = nElem - 1;
		int esq = (dir - 1) / 2;
		Item temp;
		
		while (esq >= 0)
			refazHeap(esq--, this.nElem - 1);
		
		while (dir > 0) {
			movimentacaoHeap = getMovimentacaoHeap() + 1;
			temp = this.vetor[0];
			this.vetor[0] = this.vetor[dir];
			this.vetor[dir--] = temp;
			refazHeap(0, dir);
		}
	}

	private void refazHeap(int esq, int dir) {
		int i = esq;
		int MaiorFolha = 2 * i + 1;
		Item raiz = this.vetor[i];
		boolean heap = false;
		while ((MaiorFolha <= dir) && (!heap)) {
			contComparacaoHeap++;
			if (MaiorFolha < dir)
				if (this.vetor[MaiorFolha].getChave() < this.vetor[MaiorFolha + 1].getChave())
					MaiorFolha++;
			if (raiz.getChave() < this.vetor[MaiorFolha].getChave()) {
				this.vetor[i] = this.vetor[MaiorFolha];
				i = MaiorFolha;
				MaiorFolha = 2 * i + 1;
			} else
				heap = true;
		}
		this.vetor[i] = raiz;
	}

	
	public void insercaoDireta() {
		int i, j;
		Item temp;
			for (i=1; i < this.nElem; i++){
			temp = this.vetor[i];
			j = i-1;
			
			while ((j >= 0)&&(this.vetor[j].getChave()>temp.getChave())){
				comparacaoinsert++;
				this.vetor [j+1] = this.vetor[j--];
				movimentacaoinset++; 
			}
			this.vetor [j+1] = temp;
		}
	} 
	
	public void shellSort() {

		int i, j, h;
		Item temp;
		h = 1;
		do {
			h = 3 * h + 1;
		} while (h < this.nElem);
		do {
			h = h / 3;

			for (i = h; i < this.nElem; i++) {
				comparacaoshell++;

				temp = this.vetor[i];
				j = i;
				while (this.vetor[j - h].getChave() > temp.getChave()) {
					this.vetor[j] = this.vetor[j - h];
					
					j -= h;

					movimentacaoshell++;
					comparacaoshell++;
					if (j < h) {
						break;
					}
				}
				this.vetor[j] = temp;
				movimentacaoshell++;

			}
		} while(h !=1);

	}
		public void shakersort() {
		int esq, dir, i, j;
		Item temp;
		esq = 1;
		dir = this.nElem - 1;
		j = dir;
		do {
			for (i = dir; i >= esq; i--) {
				contComparacaoShaker++;
				if (this.vetor[i - 1].getChave() > this.vetor[i].getChave()) {
					temp = this.vetor[i];
					this.vetor[i] = this.vetor[i - 1];
					this.vetor[i - 1] = temp;
					j = i;
					contTrocaShaker++;
				}
			}
			esq = j + 1;
			for (i = esq; i <= dir; i++) {
				contComparacaoShaker++;
				if (this.vetor[i - 1].getChave() > this.vetor[i].getChave()) {
					temp = this.vetor[i];
					this.vetor[i] = this.vetor[i - 1];
					this.vetor[i - 1] = temp;
					j = i;
					contTrocaShaker++;
				}
			}
			dir = j - 1;
		} while (esq <= dir);
	}
	public void quicksort (){
		ordena (0, this.nElem-1);
		}

		private void ordena(int esq, int dir) {
			int pivo, i = esq, j = dir;
			Item temp;
			pivo = this.vetor[(i + j) / 2].getChave();
			contComparacaoQuick++;
			do {
				contComparacaoQuick++;
				while (this.vetor[i].getChave() < pivo) {
					i++;
					contComparacaoQuick++;
				}
				contComparacaoQuick++;
				while (this.vetor[j].getChave() > pivo) {
					j--;
					contComparacaoQuick++;
				}
				contComparacaoQuick++;
				if (i <= j) {
					contComparacaoQuick++;
					temp = this.vetor[i];
					this.vetor[i] = this.vetor[j];
					this.vetor[j] = temp;
					i++;
					j--;
					contTrocaQuick++;
				}
			} while (i <= j);
			contComparacaoQuick++;
			if (esq < j) {
				ordena(esq, j);
			}
			contComparacaoQuick++;
			if (dir > i) {
				ordena(i, dir);
			}
		}
	
}

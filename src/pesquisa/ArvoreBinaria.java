package pesquisa;

import dados.No;

public class ArvoreBinaria {
    private No raiz;
    private int nElem;

    // construtor
    public ArvoreBinaria() {
        this.nElem = 0;
        this.raiz = null;
    }
    // outros métodos

    public boolean pesquisa(int elem) {
        NoInteiro temp;
        temp = pesquisa(elem, this.raiz);
        if (temp != null)
            return true;
        else
            return false;
    }

    private No pesquisa(int elem, No no) {
        No temp;
        temp = no;
        if (temp != null) {
            if (elem < temp.getInfo())
                temp = pesquisa(elem, temp.getEsq());
            else {
                if (elem > temp.getInfo())
                    temp = pesquisa(elem, temp.getDir());
            }
        }
        return temp;
    }

    public boolean insere(int elem) {
        boolean existe;
        existe = pesquisa(elem);
        if (existe)
            return false;
        else {
            this.raiz = insere(elem, this.raiz);
            this.nElem++;
            return true;
        }
    }

    public No insere(int elem, No no) {
        No novoNo;
        if (no == null) {
            novoNo = new No(elem);
            return novoNo;
        } else {
            if (elem < no.getInfo()) {
                no.setEsq(insere(elem, no.getEsq()));
                return no;
            } else {
                no.setDir(insere(elem, no.getDir()));
                return no;
            }
        }
    }

    public boolean remove(int chave) {
        No temp;
        temp = pesquisa(chave, this.raiz);
        if (temp != null) {
            this.raiz = remove(chave, this.raiz);
            this.nElem--;
            return true;
        } else
            return false;
    }

    private No remove(int chave, No no) {
        if (no == null)
            return no;
        else if (chave < no.getInfo())
            no.setEsq(remove(chave, no.getEsq()));
        else if (chave > no.getInfo())
            no.setDir(remove(chave, no.getDir()));
        else if (no.getDir() == null)
            return no.getEsq();
        else if (no.getEsq() == null)
            return no.getDir();
        else
            no.setEsq(arruma(no, no.getEsq()));
        return no;
    }

    private No arruma(No Q, No R) {
        if (R.getDir() != null)
            R.setDir(arruma(Q, R.getDir()));
        else {
            Q.setInfo(R.getInfo());
            R = R.getEsq();
        }
        return R;
    }

    public int[] CamCentral(int[] vetOrdenado) {
        return (this.FazCamCentral(this.raiz, vetOrdenado));
    }

    private int[] FazCamCentral(No arv, int[] vetOrdenado) {
        if (arv != null) {
            vetOrdenado = this.FazCamCentral(arv.getEsq(), vetOrdenado);
            vetOrdenado.inserir(arv.getInfo());
            vetOrdenado = this.FazCamCentral(arv.getDir(), vetOrdenado);
        }
        return vetOrdenado;
    }

    public ArvoreBinaria ArvoreBalanceada(int[] vetOrdenado) {
        ArvoreBinaria temp = new ArvoreBinaria();
        This.Balanceamento(vetOrdenado, temp, 0, vetOrdenado.getnElem() - 1);
        return temp;
    }

    private void Balanceamento(int[] vetOrdenado, Arvore temp, int ini,
            int fim) {
        int meio;
        if (fim >= ini) {
            meio = (ini + fim) / 2;
            temp.insere(vetOrdenado[meio]);
            this.Balanceamento(vetOrdenado, temp, ini, meio - 1);
            this.Balanceamento(vetOrdenado, temp, meio + 1, fim);
        }
    }
}

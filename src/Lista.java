public class Lista {
    private No cabeca;
    private int tamanho;

    public Lista() {
        cabeca = null;
        tamanho = 0;
    }

    public boolean vazia() {
        if (tamanho == 0) return true;
        else return false;
    }

    public int tamanho() {
        return tamanho;
    }

    public int elemento(int pos) {
        No aux = cabeca;
        int cont = 1;
        if (vazia() || pos < 1 || pos > tamanho) return -1;
        while (cont < pos) {
            aux = aux.getProximo();
            cont++;
        }
        return aux.getConteudo();
    }

    public int posicao(int conteudo) {
        No aux = cabeca;
        int cont = 1;
        if (vazia()) return -1;
        while (aux != null) {
            if (aux.getConteudo() == conteudo) {
                return cont;
            } else {
                aux = aux.getProximo();
                cont++;
            }
        }
        return -1;
    }

    public boolean insere(int pos, int conteudo) {
        if (vazia() && pos != 1) return false;
        if (pos == 1) return insereInicioLista(conteudo);
        if (pos == tamanho + 1) return insereFimLista(conteudo);
        else return insereMeioLista(pos, conteudo);
    }

    private boolean insereInicioLista(int conteudo) {
        No novoNo = new No();
        novoNo.setConteudo(conteudo);
        novoNo.setProximo(cabeca);
        cabeca = novoNo;
        tamanho++;
        return true;
    }

    private boolean insereFimLista(int conteudo) {
        No novoNo = new No();
        No aux = cabeca;
        novoNo.setConteudo(conteudo);

        while (aux.getProximo() != null) {
            aux = aux.getProximo();
        }
        novoNo.setProximo(null);
        aux.setProximo(novoNo);
        tamanho++;
        return true;
    }

    private boolean insereMeioLista(int pos, int conteudo) {
        No novoNo = new No();
        No aux = cabeca;
        int cont = 1;
        novoNo.setConteudo(conteudo);

        while (cont < pos - 1 && aux != null) {
            aux = aux.getProximo();
            cont++;
        }
        if (aux == null) return false;

        novoNo.setProximo(aux.getProximo());
        aux.setProximo(novoNo);
        tamanho++;
        return true;
    }

    public int remove(int pos) {
        if (vazia()) return -1;
        if (pos == 1) return removeInicioLista();
        else return removeLista(pos);
    }

    private int removeInicioLista() {
        No aux = cabeca;
        int dado = aux.getConteudo();
        cabeca = aux.getProximo();
        tamanho--;
        aux = null;
        return dado;
    }

    private int removeLista(int pos) {
        No aux = cabeca;
        No auxant = null;
        int cont = 1;

        while (cont<pos-1 && aux!=null){
            auxant=aux;
            aux=auxant.getProximo();
            cont++;
        }
        if (aux==null) return -1;

        int dado = aux.getConteudo();
        auxant.setProximo(aux.getProximo());
        aux=null;
        tamanho--;
        return dado;

    }


}

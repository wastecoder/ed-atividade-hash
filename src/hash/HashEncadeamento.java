package hash;

import java.util.LinkedList;

public class HashEncadeamento {
    private LinkedList<String>[] tabela;
    private final int TAMANHO = 26;
    private int posicoesOcupadas;


    public HashEncadeamento() {
        tabela = new LinkedList[TAMANHO];

        inicializarTabela();
    }

    private void inicializarTabela() {
        for (int i = 0; i < TAMANHO; i++) {
            tabela[i] = new LinkedList<>();
        }
    }


    public void adicionarNome(String nome) {
        if (cheia()) {
            System.out.println(">>> ERRO: Tabela cheia!");
            return;
        }

        int posicao = hashCode(nome);
        tabela[posicao].add(nome);

        posicoesOcupadas++;
        System.out.println(">>> ADICIONADO: nome [" + nome + "] na posicao [" + posicao + "]");
    }

    public boolean contem(String nomeDesejado) {
        int posicao = hashCode(nomeDesejado);

        return tabela[posicao].contains(nomeDesejado);
    }

    public void apagarNome(String nomeDesejado) {
        int posicao = hashCode(nomeDesejado);

        if (tabela[posicao].remove(nomeDesejado)) {
            System.out.println(">>> REMOVENDO: nome [" + nomeDesejado + "] da hash");
        } else {
            System.out.println(">>> ERRO: nome [" + nomeDesejado + "] nao encontrado para remover");
        }
    }


    public void exibir() {
        for (int i = 0; i < TAMANHO; i++) {
            if (!tabela[i].isEmpty()) {
                char letra = (char) (i + 97);
                System.out.println("Posicao [" + letra + "] = " + tabela[i]);
            }
        }
    }

    public boolean cheia() {
        return posicoesOcupadas == TAMANHO;
    }

    private int hashCode(String nome) {
        final int VALOR_DO_A = 97;
        int posicao = nome.toLowerCase().charAt(0);

        return posicao - VALOR_DO_A;
    }
}

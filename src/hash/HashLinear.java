package hash;

import java.util.Arrays;

public class HashLinear {
    private Nome[] tabela; //Da pra remover esse objeto e usar vetor de String
    private final int TAMANHO;
    private int posicoesOcupadas;


    public HashLinear(int TAMANHO) {
        this.TAMANHO = TAMANHO;
        tabela = new Nome[TAMANHO];

        inicializarTabela();
    }

    public void adicionarNome(String nome) {
        if (cheia()) {
            System.out.println(">>> ERRO: Tabela cheia!");
            return;
        }

        int posicao = hashCode(nome);
        if (ocorreuColisao(posicao)) {
            if (tabela[posicao].equals(nome)) {
                System.out.println(">>> ERRO: Item ja armazenado");
                return;
            }

            System.out.println(">>> COLISAO: ocorreu na posicao " + posicao);
            while (posicao < TAMANHO) {
                if (posicao == TAMANHO - 1) posicao = -1; //Volta para o inicio se chegar no final
                posicao++;
                if (!ocorreuColisao(posicao)) {
                    break;
                }
            }
        }

        tabela[posicao] = new Nome(nome);
        posicoesOcupadas++;
        System.out.println(">>> ADICIONADO: nome [" + nome + "] na posicao [" + posicao + "]");
    }

    public int buscarPosicao(String nomeDesejado) {
        int posicao = hashCode(nomeDesejado);

        if (ocorreuColisao(posicao)) {
            if (nomeDesejadoEncontrado(nomeDesejado, posicao)) {
                return posicao;
            }

            int inicioBusca = posicao;
            while (posicao < TAMANHO) {
                if (posicao == TAMANHO - 1) posicao = -1;
                posicao++;

                if (ocorreuColisao(posicao) && nomeDesejadoEncontrado(nomeDesejado, posicao)) return posicao;

                if (posicao == inicioBusca) return -1;
            }
        }

        return -1;
    }

    public boolean contem(String nomeDesejado) {
        return buscarPosicao(nomeDesejado) != -1;
    }

    public void apagarNome(String nomeDesejado) {
        int posicao = buscarPosicao(nomeDesejado);

        if (posicao != -1) {
            tabela[posicao].nome = null;
            posicoesOcupadas--;
            System.out.println(">>> REMOVENDO: nome [" + nomeDesejado + "] da posicao [" + posicao + "]");
        } else {
            System.out.println(">>> ERRO: nome [" + nomeDesejado + "] nao encontrado para remover");
        }
    }



    private void inicializarTabela() {
        Arrays.fill(tabela, new Nome(null));
    }

    public void exibir() {
        for (int i = 0; i < TAMANHO; i++) {
            if (ocorreuColisao(i)) {
                System.out.println("Posicao [" + i + "] = nome [" + tabela[i].nome + "]");
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

    private boolean ocorreuColisao(int posicao) {
        return tabela[posicao].nome != null;
    }

    private boolean nomeDesejadoEncontrado(String nomeDesejado, int posicao) {
        return tabela[posicao].nome.equals(nomeDesejado);
    }
}

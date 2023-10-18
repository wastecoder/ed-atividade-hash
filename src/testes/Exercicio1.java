package testes;

import hash.HashLinear;

public class Exercicio1 {
    public static void main(String[] args) {
        HashLinear tabela = new HashLinear(26);


        System.out.println("|========> ADICIONAR");
        tabela.adicionarNome("Xerox");
        tabela.adicionarNome("Fotocopia");
        tabela.adicionarNome("Carimbo");
        tabela.adicionarNome("Katchanga");


        System.out.println("\n|========> BUSCAR POSICAO");
        System.out.println("[Carimbo] na posicao " + tabela.buscarPosicao("Carimbo"));
        System.out.println("[Facebookson] na posicao " + tabela.buscarPosicao("Facebookson"));


        System.out.println("\n|========> CONTEM");
        System.out.println("[Xerox] esta na lista? " + tabela.contem("Xerox"));
        System.out.println("[Facebookson] esta na lista? " + tabela.contem("Facebookson"));


        System.out.println("\n|========> REMOVER");
        tabela.apagarNome("Xerox");
        tabela.apagarNome("Facebookson");


        System.out.println("\n|========> ESTA CHEIA");
        System.out.println("Esta cheia? " + tabela.cheia());


        System.out.println("\n|========> TODOS NOMES NA TABELA HASH");
        tabela.exibir();
    }
}

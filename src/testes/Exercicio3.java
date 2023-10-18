package testes;

import hash.HashEncadeamento;

public class Exercicio3 {
    public static void main(String[] args) {
        HashEncadeamento tabela = new HashEncadeamento();


        System.out.println("|========> ADICIONAR");
        tabela.adicionarNome("Dora");
        tabela.adicionarNome("Dani");
        tabela.adicionarNome("Mitinho");
        tabela.adicionarNome("Lulinha");
        tabela.adicionarNome("Matheus");
        tabela.adicionarNome("Lulu");


        System.out.println("\n|========> CONTEM");
        System.out.println("[Dora] esta na lista? " + tabela.contem("Dora"));
        System.out.println("[Eduardo] esta na lista? " + tabela.contem("Eduardo"));


        System.out.println("\n|========> REMOVER");
        tabela.apagarNome("Dora");
        tabela.apagarNome("Gugu");


        System.out.println("\n|========> ESTA CHEIA");
        System.out.println("Esta cheia? " + tabela.cheia());


        System.out.println("\n|========> TODOS NOMES NA TABELA HASH");
        tabela.exibir();
    }
}

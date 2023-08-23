package br.com.porto.bancoDados.teste;

import br.com.porto.bancoDados.dao.GerenciadorBancoDados;

public class TesteConexao {
    public static void main(String[] args) {
        if (GerenciadorBancoDados.obterConexao() == null) {
            System.out.printf("Erro em estabelecer a conexão");
        } else {
            System.out.println("Conexão concluída!");
        }


    }
}

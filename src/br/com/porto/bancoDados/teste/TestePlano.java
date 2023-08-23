package br.com.porto.bancoDados.teste;

import br.com.porto.bancoDados.dao.PlanoDao;
import br.com.porto.bancoDados.entity.Plano;

import java.sql.SQLException;
import java.util.Scanner;

public class TestePlano {

    public void menu() {
        System.out.println(
                "  Bem-vindo a nossa SEGURADORA!!\n" +
                        "---------------------------------\n" +
                        "Selecione uma opção:\n" +
                        " 1 - Cadastrar um plano\n" +
                        " 2 - Alterar um plano\n" +
                        " 3 - Excluir um plano\n" +
                        " 4 - Consultar plano pelo ID\n" +
                        "---------------------------------");
    }

    public static Plano preencerDados(Plano plano) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o ID do plano: ");
        plano.setIdPlano(input.nextInt());
        input.nextLine();

        System.out.println("Digite o nome do plano: ");
        plano.setNomePlano(input.nextLine());

        System.out.println("Digite a cobertura do plano: ");
        plano.setCobertura(input.nextLine());

        System.out.println("Digite o prazo de vigência do plano: ");
        plano.setPrazoVigencia(input.nextLine());

        System.out.println("Digite a carência do plano: ");
        plano.setCarencia(input.nextLine());

        System.out.println("Digite o limite da cobertura do plano: ");
        plano.setLimiteCobertura(input.nextDouble());

        System.out.println("Digite o valor do plano: ");
        plano.setValor(input.nextDouble());

        return plano;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcao;

        Plano plano = new Plano();
        PlanoDao planoDao = new PlanoDao();

        TestePlano testePlano = new TestePlano();

        testePlano.menu();
        opcao = input.nextInt();
        switch (opcao) {
            case 1:
                testePlano.preencerDados(plano);
                try {
                    planoDao.inserir(plano);
                    System.out.println("Plano Cadastrado!!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case 2:
                try {
                    testePlano.preencerDados(plano);
                    planoDao.alterar(plano);
                    System.out.println("Plano atualizado!!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case 3:

                try{
                    System.out.println("Digite o id do plano que será excluído: ");
                    int id = input.nextInt();
                    planoDao.excluir(id);
                    System.out.println("Plano excluído!!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case 4:
                try {
                    System.out.println("Digite o id do endereço que será exibido: ");
                    int id = input.nextInt();
                    plano = planoDao.buscarPlano(id);
                    System.out.println(plano.toString());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;


        }
    }
}

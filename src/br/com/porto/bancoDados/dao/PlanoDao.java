package br.com.porto.bancoDados.dao;

import br.com.porto.bancoDados.entity.Plano;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlanoDao {
    private Connection conexao;
    public void inserir(Plano plano) throws SQLException {
        conexao = GerenciadorBancoDados.obterConexao();
        PreparedStatement comandoSql =  null;
        String sql = "insert into plano (idplano, nome, cobertura, prazovigencia, carencia, limitecobertura, " +
                "valor) values(?,?,?,?,?,?,?)";
        comandoSql = conexao.prepareStatement(sql);

        comandoSql.setInt(1, plano.getIdPlano());
        comandoSql.setString(2, plano.getNomePlano());
        comandoSql.setString(3, plano.getCobertura());
        comandoSql.setString(4, plano.getPrazoVigencia());
        comandoSql.setString(5, plano.getCarencia());
        comandoSql.setDouble(6, plano.getLimiteCobertura());
        comandoSql.setDouble(7, plano.getValor());
        comandoSql.executeUpdate();
        conexao.close();
        comandoSql.close();
    }
    public void alterar(Plano plano) throws SQLException {
        conexao = GerenciadorBancoDados.obterConexao();
        PreparedStatement comandoSql = null;
        String sql = "update plano set nome = ?, cobertura = ?, prazovigencia = ?, carencia = ?, limitecobertura = ?, valor = ? " +
                "where idplano = ?";
        comandoSql = conexao.prepareStatement(sql);

        comandoSql.setString(1, plano.getNomePlano());
        comandoSql.setString(2, plano.getCobertura());
        comandoSql.setString(3, plano.getPrazoVigencia());
        comandoSql.setString(4, plano.getCarencia());
        comandoSql.setDouble(5, plano.getLimiteCobertura());
        comandoSql.setDouble(6, plano.getValor());
        comandoSql.setInt(7, plano.getIdPlano());
        comandoSql.executeUpdate();
        conexao.close();
        comandoSql.close();
    }

    public void excluir(int id) throws SQLException {
        conexao = GerenciadorBancoDados.obterConexao();
        PreparedStatement comandoSql = null;
        String sql = "delete from plano where idplano = ?";
        comandoSql = conexao.prepareStatement(sql);
        comandoSql.setInt(1, id);
        comandoSql.executeUpdate();
        conexao.close();
        comandoSql.close();
    }

    public Plano buscarPlano(int id) throws SQLException {
        Plano plano = new Plano();
        PreparedStatement comandoSql = null;
        conexao = GerenciadorBancoDados.obterConexao();
        String sql = "select * from plano where idplano = ?";
        comandoSql = conexao.prepareStatement(sql);
        comandoSql.setInt(1, id);
        ResultSet resultSet = comandoSql.executeQuery();
        if (resultSet.next()) {
            plano.setIdPlano(resultSet.getInt("idplano"));
            plano.setNomePlano(resultSet.getString("nome"));
            plano.setCobertura(resultSet.getString("cobertura"));
            plano.setPrazoVigencia(resultSet.getString("prazovigencia"));
            plano.setCarencia(resultSet.getString("carencia"));
            plano.setLimiteCobertura(resultSet.getDouble("limitecobertura"));
            plano.setValor(resultSet.getDouble("valor"));
        }
        return plano;
    }

}

package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Aluno;
import br.com.fiap.connections.ConexaoFactory;

public class AlunoDAO {
    public Connection minhaConexao;

    public AlunoDAO() throws ClassNotFoundException, SQLException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // adicionar
    public String adicionar(Aluno aluno) throws SQLException {
        var sql = "INSERT INTO T_FIAP_ALUNOS VALUES (?,?,?,?)";

        PreparedStatement stmt = minhaConexao.prepareStatement(sql);

        stmt.setInt(1, aluno.getRm());
        stmt.setString(2, aluno.getNome());
        stmt.setString(3, aluno.getTurma());
        stmt.setDouble(4, aluno.getNota());
        stmt.execute();
        stmt.close();

        return "Cadastrado com sucesso";
    }

    // deletar
    public String deletar(int rm) throws SQLException {
        var sql = "DELETE FROM T_FIAP_ALUNOS WHERE rm = ?";
        PreparedStatement stmt = minhaConexao.prepareStatement(sql);

        stmt.setInt(1, rm);
        stmt.executeUpdate();
        stmt.close();

        return "Deletado com sucesso";
    }

    // atualizar
    public String atualizar(Aluno aluno) throws SQLException {
        var sql = "UPDATE T_FIAP_ALUNOS SET nome = ?, turma = ?, nota = ? WHERE rm = ?";
        PreparedStatement stmt = minhaConexao.prepareStatement(sql);

        stmt.setString(1, aluno.getNome());
        stmt.setString(2, aluno.getTurma());
        stmt.setDouble(3, aluno.getNota());
        stmt.setInt(4, aluno.getRm());
        stmt.executeUpdate();
        stmt.close();

        return "Atualizado com sucesso";
    }

    // selecionar
    public List<Aluno> selecionar() throws SQLException {
        var listaAlunos = new ArrayList<Aluno>();
        var sql = "SELECT * FROM T_FIAP_ALUNOS";
        PreparedStatement stmt = minhaConexao.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {
            Aluno aluno = new Aluno();
            aluno.setRm(rs.getInt(1));
            aluno.setNome(rs.getString(2));
            aluno.setTurma(rs.getString(3));
            aluno.setNota(rs.getDouble(4));

            listaAlunos.add(aluno);
        }

        return listaAlunos;
    }

}

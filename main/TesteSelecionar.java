package br.com.fiap.main;

import br.com.fiap.beans.Aluno;
import br.com.fiap.dao.AlunoDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TesteSelecionar {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AlunoDAO dao = new AlunoDAO();

        List<Aluno> listaAlunos = (ArrayList<Aluno>) dao.selecionar();

        if (listaAlunos != null) {
            for (Aluno aluno : listaAlunos) {
                System.out.println(aluno.getRm());
                System.out.println(aluno.getNome());
                System.out.println(aluno.getTurma());
                System.out.println(aluno.getNota() + "\n");
            }
        }
    }
}

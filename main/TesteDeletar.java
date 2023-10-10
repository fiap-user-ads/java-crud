package br.com.fiap.main;

import br.com.fiap.beans.Aluno;
import br.com.fiap.dao.AlunoDAO;

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class TesteDeletar {
    static int inteiro(String display) {
        return Integer.parseInt(JOptionPane.showInputDialog(display));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Aluno objAluno = new Aluno();
        AlunoDAO dao = new AlunoDAO();

        objAluno.setRm(inteiro("RM"));

        System.out.println(dao.deletar(objAluno.getRm()));
    }
}

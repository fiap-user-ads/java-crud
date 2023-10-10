package br.com.fiap.main;

import br.com.fiap.beans.Aluno;
import br.com.fiap.dao.AlunoDAO;

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class TesteAtualizar {
    static String texto(String display) {
        return JOptionPane.showInputDialog(display);
    }
    static int inteiro(String display) {
        return Integer.parseInt(JOptionPane.showInputDialog(display));
    }
    static double decimal(String display) {
        return Double.parseDouble(JOptionPane.showInputDialog(display));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Aluno objAluno = new Aluno();
        AlunoDAO dao = new AlunoDAO();

        objAluno.setRm(inteiro("RM"));
        objAluno.setNome(texto("Nome"));
        objAluno.setTurma(texto("Turma"));
        objAluno.setNota(decimal("Nota"));

        System.out.println(dao.atualizar(objAluno));
    }
}

package br.com.fiap.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.connections.ConexaoFactory;

public class TesteConnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection c = new ConexaoFactory().conexao();

        System.out.println("Conectado com sucesso!");

        c.close();
    }
}

package Dao;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    public static Connection conectar() throws Exception {
    	
        return DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/postgres", "postgres", "SUA_SENHA");
    }
}
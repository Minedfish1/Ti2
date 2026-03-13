package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Usuario;

public class UsuarioDAO {
    
    public void inserir(Usuario usuario) {
        // 1. O comando SQL com os ? (placeholders)
        String sql = "INSERT INTO usuario (nome, login, senha) VALUES (?, ?, ?)";
        
        // 2. Tenta abrir a conexão e preparar o comando
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // 3. Troca os ? pelos dados que estão dentro do objeto usuario
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            
            // 4. Manda o banco executar
            stmt.executeUpdate();
            
            System.out.println("Usuário salvo com sucesso!");
            
        } catch (Exception e) {
            System.out.println("Erro ao inserir usuário: " + e.getMessage());
        }
    }
}
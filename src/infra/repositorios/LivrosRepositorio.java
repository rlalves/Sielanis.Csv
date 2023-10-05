package infra.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import infra.fabricas.ConexaoFabrica;
import modelo.dominio.Script;
import modelo.entidades.Livro;
import modelo.fabricas.ScriptsFabrica;

public class LivrosRepositorio {
	
	private ConexaoFabrica conexao;
	private ScriptsFabrica scripts;
	
	public LivrosRepositorio()
	{
		this.conexao = new ConexaoFabrica("jdbc:h2:~/livros", "sa", "");
		this.scripts = new ScriptsFabrica();
	}
	
	public void CriaTabelaLivros()
	{
		try (Connection c = this.conexao.ObtemConexao();
	        PreparedStatement preparedStatement = c.prepareStatement(scripts.ObtemScript(Script.criar))) {
			preparedStatement.executeUpdate();
			c.close();
		}
		catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void DestruirTabelaLivros()
	{
		try (Connection c = this.conexao.ObtemConexao();
	        PreparedStatement preparedStatement = c.prepareStatement(scripts.ObtemScript(Script.destruir))) {
			preparedStatement.executeUpdate();
			c.close();
		}
		catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
    public void InsereLivro(String Nome, String Autor, int Paginas) {
    	
        try (Connection c = this.conexao.ObtemConexao();
            PreparedStatement preparedStatement = c.prepareStatement(scripts.ObtemScript(Script.inserir))) {
            preparedStatement.setString(1, Nome);
            preparedStatement.setString(2, Autor);
            preparedStatement.setInt(3, Paginas);
            preparedStatement.executeUpdate();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Livro> ConsultaLivros() {
    	
        List<Livro> usuarios = new ArrayList<>();
        
        try (Connection c = this.conexao.ObtemConexao();
             PreparedStatement preparedStatement = c.prepareStatement(scripts.ObtemScript(Script.consultar))) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("Nome");
                String autor = rs.getString("Autor");
                int paginas = rs.getInt("Paginas");
                usuarios.add(new Livro(nome, autor, paginas));
            }
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return usuarios;
    }
	
}

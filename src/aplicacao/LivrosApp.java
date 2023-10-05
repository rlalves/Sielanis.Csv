package aplicacao;

import infra.repositorios.LivrosRepositorio;
import infra.arquivos.LivrosArquivo;
import modelo.entidades.*;
import java.util.List;

public class LivrosApp {
	
	public LivrosApp() {
		
	}
	
	public void Executar() {
		LivrosRepositorio repositorio = new LivrosRepositorio();
		LivrosArquivo arquivo = new LivrosArquivo();
		
		// Construir tabela
		repositorio.CriaTabelaLivros();
		
		// Obtem lista de livros do csv
		List<Livro> livros = arquivo.ObtemDados();
		
		// Grava no banco de dados
		for(Livro livro: livros) {
			repositorio.InsereLivro(livro.getNome(), livro.getAutor(), livro.getPaginas());
		}
		
		// Le do banco de dados
		livros = repositorio.ConsultaLivros();
		
		// Grava em um csv
		arquivo.GravarDados(livros);
		
		// Destruir tabela
		repositorio.DestruirTabelaLivros();
	}
	
}

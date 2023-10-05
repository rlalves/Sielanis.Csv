package infra.arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidades.*;

public class LivrosArquivo {

	public LivrosArquivo() {
		
	}
	
    String arquivoOrigem = "C:\\Users\\Raazak\\eclipse-workspace\\Sielanis.Csv\\dados\\origem.csv";
    String arquivoDestino = "C:\\Users\\Raazak\\eclipse-workspace\\Sielanis.Csv\\dados\\destino.csv";
	
    public List<Livro> ObtemDados() {
        List<Livro> livros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoOrigem))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                // Dividir a linha em campos usando ',' como delimitador
                String[] campos = linha.split(";");
                
                String nome = campos[0];
                String autor = campos[1];
                int paginas = Integer.parseInt(campos[2]);
                
                livros.add(new Livro(nome, autor, paginas));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return livros;
    }
	
    public void GravarDados(List<Livro> livros) {
     
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivoDestino))) {
        	for (Livro livro : livros) {
        	// Escreva linhas no arquivo CSV
        		writer.println(livro.getNome() + ";" + livro.getAutor() + ";" + livro.getPaginas());
        	}
        
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
	
}

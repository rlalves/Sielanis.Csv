package modelo.fabricas;

import modelo.dominio.Script;

public class ScriptsFabrica {
	
	public String ObtemScript(Script scripts)
	{
	    switch (scripts) {
	    case inserir:
	        return "INSERT INTO Livros (Nome, Autor, Paginas) VALUES (?, ?, ?)";
	    case consultar:
	        return "SELECT * FROM Livros";
	    case criar:
	        return "CREATE TABLE Livros(Nome VARCHAR(255), Autor VARCHAR(255), Paginas INT);";
	    case destruir:
	        return "DROP TABLE Livros;";
	    }
	    return "";
	}
}

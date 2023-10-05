package modelo.entidades;

public class Livro {
	private String _nome;
	private String _autor;
	private int _paginas;
	
	public Livro(String nome, String autor, int paginas) {
		_nome = nome;
		_autor = autor;
		_paginas = paginas;
	}
	
	public void setNome(String nome)
	{
		_nome = nome;
	}
	
	public String getNome()
	{
		return _nome;
	}
	
	public void setAutor(String autor)
	{
		_autor = autor;
	}
	
	public String getAutor()
	{
		return _autor;
	}
	
	public void setPaginas(int paginas)
	{
		_paginas = paginas;
	}
	
	public int getPaginas()
	{
		return _paginas;
	}
}

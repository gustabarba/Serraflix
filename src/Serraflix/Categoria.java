package Serraflix;

public enum Categoria {
	FANTASIA("Fantasia"), TERROR("Terror"), COMEDIA("Com�dia"), DRAMA("Drama"), SUSPENSE("Suspense"), ROMANCE("Romance"), ACAO("A��o"), NOIR("Noir"), CYBERPUNK("Cyberpunk");
	
	private String nome;
	private int contador = 0;
	
	private Categoria(String n){
		this.nome = n;
	}
	
	public String getNomeCategoria() {
		return this.nome;
	}

	public void aumentarContador() {
		this.contador++;
	}

	public void diminuirContador() {
		this.contador--;
	}
	
	public int obterContador() {
		return this.contador;
	}
}

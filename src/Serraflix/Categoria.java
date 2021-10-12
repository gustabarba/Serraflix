package Serraflix;

public enum Categoria {
	FANTASIA("Fantasia"), TERROR("Terror"), COMEDIA("Com�dia"), DRAMA("Drama"), SUSPENSE("Suspense"), ROMANCE("Romance"), ACAO("A��o"), NOIR("Noir"), CYBERPUNK("Cyberpunk");
	
	private String nome;
	
	private Categoria(String n){
		this.nome = n;
	}
	
	public String getNomeCategoria() {
		return this.nome;
	}
}

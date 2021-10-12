package Serraflix;

public enum Categoria {
	FANTASIA("Fantasia"), TERROR("Terror"), COMEDIA("Com�dia"), DRAMA("Drama"), SUSPENSE("Suspense");
	
	private String nome;
	
	private Categoria(String n){
		this.nome = n;
	}
	
	public String getNomeCategoria() {
		return this.nome;
	}
}

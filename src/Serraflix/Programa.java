package Serraflix;

public abstract class Programa implements Classificar{
	protected String nome;
	protected Double pontuacao;
	protected Categoria categoria;
	protected int id;
	private static int controladorid;
	
	//construtor padrão
	public Programa(String nome, Double pontuacao, Categoria categoria) {
		controladorid++;
		this.id = controladorid;
		this.nome = nome;
		try{
			if(this instanceof Filme) {
				Filme.classificar(pontuacao);
			}else if (this instanceof Serie){
				Serie.classificar(pontuacao);
			}
			this.pontuacao = pontuacao;
		}catch (Exception e) {
			this.pontuacao = null;
		}
		this.categoria = categoria;
	}
	
	//construtor para edição
	public Programa(String nome, Double pontuacao, Categoria categoria, int id) {
		this.id = id;
		this.nome = nome;
		this.pontuacao = pontuacao;
		this.categoria = categoria;
	}
	
	//getters e setters
	public double getPontuacao() throws Exception{
		try {
			return pontuacao;
		}catch(Exception e){
			throw new Exception();
		}
	}
	
	@Override
	public String toString() {
		String retorno = "";
		retorno += 
				"\n" + this.nome + "\n\n" + 
				"NOTA: " + (this.pontuacao == null ? "SEM NOTA" : String.format("%.1f", this.pontuacao) + (this instanceof Filme ? "/5" : "/10")) + "\n" +
				"CATEGORIA: " + this.getCategoria().getNomeCategoria() + "\n";
		if(this instanceof Filme) {
			retorno += "DURAÇÃO: " + ((Filme)this).getDuracao() + " MINUTOS";
		}else if(this instanceof Serie){		
			
			retorno += "TEMPORADAS: " + ((Serie)this).getNumeroTemporas() + "\n\n";
			for(Temporada t: ((Serie)this).getTemporadas()) {
				retorno += String.format("%02d", t.getNomeTemporada()) + "ª TEMP: " + String.format("%02d", t.getQuantidadeEpisodios()) + " EPS\n";
			}
			retorno += "\nTOTAL DE EPISÓDIOS: " + ((Serie)this).getTotalEpisodios();
		}
		return retorno;	
	}
	
	public void setPontuacao(Double pontuacao) {
		this.pontuacao = pontuacao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public int getId() {
		return id;
	}
}

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
		this.pontuacao = pontuacao;
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
		if(this instanceof Filme) {
			
			retorno = "\n" + this.nome + " | FILME\n\n"
					 + "NOTA: " + (this.pontuacao == null ? "SEM NOTA" : String.format("%.1f", this.pontuacao) + "/5") + "\n"
					 + "CATEGORIA: " + this.getCategoria().getNomeCategoria() + "\n"
					 + "DURAÇÃO: " + ((Filme)this).getDuracao() + " MINUTOS";
			
		}else {		
			
			retorno = "\n" + this.nome + " | SÉRIE\n\n"
					 + "NOTA: " + (this.pontuacao == null ? "SEM NOTA" : String.format("%.1f", this.pontuacao) + "/10") + "\n"
					 + "CATEGORIA: " + this.getCategoria().getNomeCategoria() + "\n\n"
					 + "TEMPORADAS: " + ((Serie)this).getNumeroTemporas() + "\n\n";
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

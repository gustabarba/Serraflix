package Serraflix;

public class Temporada {
	private int nomeTemporada, quantidadeEpisodios;

	//construtor
	public Temporada(int numeroTemporada, int quantidadeEpisodios) {
		super();
		this.nomeTemporada = numeroTemporada;
		this.quantidadeEpisodios = quantidadeEpisodios;
	}

	//método de adicionar episódios
	public void adicionarEpisodios(int eps) throws Exception{
		if(eps > 0) {
			this.quantidadeEpisodios += eps;
		}else {
			throw new Exception("VOCÊ PRECISA INSERIR UM VALOR POSITIVO DE EPISÓDIOS.");
		}
	}
	
	//método de remover episódios
	public void removerEpisodios(int eps) throws Exception{
		if(eps < this.quantidadeEpisodios) {
			this.quantidadeEpisodios -= eps;
		}else {
			throw new Exception("VOCÊ NÃO PODE REMOVER TODOS OS EPISÓDIOS DE UMA TEMPORADA. PARA QUE ISSO SEJA FEITO, É NECESSÁRIO QUE REMOVA A TEMPORADA INTEIRA.");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//getters e setters
	public int getNomeTemporada() {
		return nomeTemporada;
	}
	public void setNomeTemporada(int numeroTemporada) {
		this.nomeTemporada = numeroTemporada;
	}
	public int getQuantidadeEpisodios() {
		return quantidadeEpisodios;
	}
	public void setQuantidadeEpisodios(int quantidadeEpisodios) {
		this.quantidadeEpisodios = quantidadeEpisodios;
	}
	
	
}

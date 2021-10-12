package Serraflix;

public class Temporada {
	private int nomeTemporada, quantidadeEpisodios;

	//construtor
	public Temporada(int numeroTemporada, int quantidadeEpisodios) {
		super();
		this.nomeTemporada = numeroTemporada;
		this.quantidadeEpisodios = quantidadeEpisodios;
	}

	//m�todo de adicionar epis�dios
	public void adicionarEpisodios(int eps) throws Exception{
		if(eps > 0) {
			this.quantidadeEpisodios += eps;
		}else {
			throw new Exception("VOC� PRECISA INSERIR UM VALOR POSITIVO DE EPIS�DIOS.");
		}
	}
	
	//m�todo de remover epis�dios
	public void removerEpisodios(int eps) throws Exception{
		if(eps < this.quantidadeEpisodios) {
			this.quantidadeEpisodios -= eps;
		}else {
			throw new Exception("VOC� N�O PODE REMOVER TODOS OS EPIS�DIOS DE UMA TEMPORADA. PARA QUE ISSO SEJA FEITO, � NECESS�RIO QUE REMOVA A TEMPORADA INTEIRA.");
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

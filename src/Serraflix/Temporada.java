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
			throw new Exception("Voc� precisa inserir um valor positivo de epis�dios.");
		}
	}
	
	//m�todo de remover epis�dios
	public void removerEpisodios(int eps) throws Exception{
		if(eps < this.quantidadeEpisodios) {
			this.quantidadeEpisodios -= eps;
		}else {
			throw new Exception("Voc� n�o pode remover todos os epis�dios de uma temporada. Para fazer isso, precisa remover ela inteira como objeto.");
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

package Serraflix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Serie extends Programa{
	private ArrayList<Temporada> temporadas = new ArrayList<>();
	
	//construtor com temporadas em massa
	public Serie(String nome, Double pontuacao, Categoria categoria, List<Integer> qtdEps) {
		super(nome, pontuacao, categoria);
		try {
			adicionarTemporadas(qtdEps);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//m�todo de contar total de epis�dios
	public int getTotalEpisodios() {
		int qtdEps = 0;
		for(Temporada t : this.temporadas) {
			qtdEps += t.getQuantidadeEpisodios();
		}
		return qtdEps;
	}
	
/*	
	//m�todo de remover temporadas em massa (por n�mero)
	public void removerTemporadas(List<Integer> numeroDasTemporadas){
		for(Integer n : numeroDasTemporadas) {
			for(Temporada t: this.temporadas) {
				if(t.getNumeroTemporada() == n) {
					this.temporadas.remove(t);
				}
			}
		}
	}
*/
	
	//m�todo de remover temporada
	public void removerTemporada(int nome) throws Exception{
		boolean achou = false;
		Iterator<Temporada> i = this.temporadas.iterator();
		while (i.hasNext()) {
			   Temporada t = i.next(); 
			   if(t.getNomeTemporada() == nome) {
					achou = true;
					i.remove();
				}
		}
		if(achou == false) {
			throw new Exception("Imposs�vel remover: temporada inexistente.");
		}
	}
	
	//m�todo de adicionar temporadas em massa
	public void adicionarTemporadas(List<Integer> qtdEps) throws Exception{
		if(qtdEps.size() > 0) {
			for(int i = 0; i < qtdEps.size(); i++) {
				this.temporadas.add(new Temporada(i + 1, qtdEps.get(i)));
			}
		}else {
			throw new Exception("Erro ao adicionar temporadas para a s�rie \"" + this.nome + "\". Voc� precisa adicionar um n�mero positivo de epis�dios, e s� pode criar uma temporada que ainda n�o exista.");
		}
	}
	
	//obter n�mero de temporadas
	public int getNumeroTemporas(){
		return this.temporadas.size();
	}
	
	//obter temporadas
	public ArrayList<Temporada> getTemporadas(){
		return this.temporadas;
	}
	
	//m�todo de classifica��o
	public void classificar(Double nota) throws ClassificacaoForaDoRangeException{
		if(nota != null) {
			if(nota < 0 || nota > 10) {
				super.pontuacao = null;
				throw new ClassificacaoForaDoRangeException("Erro ao adicionar a classifica��o para a s�rie \"" + this.nome + "\": a nota n�o deve ser menor que zero ou maior que dez.");
			}else {
				super.pontuacao = nota;
			}
		}else {
			super.pontuacao = null;
		}
	}	
	
	@Override
	public String toString() {
		String retorno = "";
		retorno = "\nInforma��es sobre a s�rie \n\n"
				+ "Nome: " + super.nome + "\n"
				 + (super.pontuacao == null ? "" : ("Nota: " + String.format("%.1f", super.pontuacao) + "/10 \n"))
				 + "Categoria: " + this.getCategoria().getNomeCategoria() + "\n"
				 + "Temporadas: " + this.temporadas.size() + "\n"
				 + "Total de epis�dios: " + this.getTotalEpisodios() + "\n\n"
				 		+ "Epis�dios por temporada\n";
		for(Temporada t: this.getTemporadas()) {
			retorno += String.format("\n%02d", t.getNomeTemporada()) + "� temp: " + String.format("%02d", t.getQuantidadeEpisodios()) + " eps";
		}
		return retorno;
	}
}

package Serraflix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Serie extends Programa{
	private ArrayList<Temporada> temporadas = new ArrayList<>();
	
	//construtor padrão
	public Serie(String nome, Double pontuacao, Categoria categoria, List<Integer> qtdEps){
		super(nome, pontuacao, categoria);
		try {
			adicionarTemporadas(qtdEps);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//construtor de edição
	public Serie(String nome, Double pontuacao, Categoria categoria, List<Integer> qtdEps, int id){
		super(nome, pontuacao, categoria, id);
		try {
			adicionarTemporadas(qtdEps);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//método de contar total de episódios
	public int getTotalEpisodios() {
		int qtdEps = 0;
		for(Temporada t : this.temporadas) {
			qtdEps += t.getQuantidadeEpisodios();
		}
		return qtdEps;
	}
	
/*	
	//método de remover temporadas em massa (por número)
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
	
	//método de remover temporada
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
			throw new Exception("Impossível remover: temporada inexistente.");
		}
	}
	
	//método de adicionar temporadas em massa
	public void adicionarTemporadas(List<Integer> qtdEps) throws Exception{
		if(qtdEps.size() > 0) {
			for(int i = 0; i < qtdEps.size(); i++) {
				this.temporadas.add(new Temporada(i + 1, qtdEps.get(i)));
			}
		}else {
			throw new Exception("Erro ao adicionar temporadas para a série \"" + this.nome + "\": você precisa adicionar um número positivo de episódios, e só pode criar uma temporada que ainda não exista.");
		}
	}
	
	//obter número de temporadas
	public int getNumeroTemporas(){
		return this.temporadas.size();
	}
	
	//obter temporadas
	public ArrayList<Temporada> getTemporadas(){
		return this.temporadas;
	}
	
	//método de classificação
	public void classificar(Double nota) throws ClassificacaoForaDoRangeException{
		if(nota != null) {
			if(nota < 0 || nota > 10) {
				super.pontuacao = null;
				throw new ClassificacaoForaDoRangeException("\nErro ao adicionar a classificação: a nota não deve ser menor que zero ou maior que dez.");
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
		retorno = "\n" + super.nome + " | Série\n\n"
				 + (super.pontuacao == null ? "" : ("Nota: " + String.format("%.1f", super.pontuacao) + "/10 \n"))
				 + "Categoria: " + this.getCategoria().getNomeCategoria() + "\n\n"
				 + "Temporadas: " + this.temporadas.size() + "\n\n";
		for(Temporada t: this.getTemporadas()) {
			retorno += String.format("%02d", t.getNomeTemporada()) + "ª temp: " + String.format("%02d", t.getQuantidadeEpisodios()) + " eps\n";
		}
		retorno += "\nTotal de episódios: " + this.getTotalEpisodios();
		return retorno;
	}
}

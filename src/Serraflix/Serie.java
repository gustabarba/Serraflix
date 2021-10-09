package Serraflix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Serie extends Programa{
	private ArrayList<Temporada> temporadas = new ArrayList<>();
	
	//construtor sem temporadas
	public Serie(String nome, Double pontuacao, Categoria categoria) {
		super(nome, pontuacao, categoria);
	}
	
	//construtor com temporadas em massa
	public Serie(String nome, Double pontuacao, Categoria categoria, List<Integer> qtdEps) {
		super(nome, pontuacao, categoria);
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
				this.temporadas.add(new Temporada(i + this.temporadas.size() + 1, qtdEps.get(i)));
			}
		}else {
			throw new Exception("Erro ao adicionar temporadas para a série \"" + this.nome + "\". Você precisa adicionar um número positivo de episódios, e só pode criar uma temporada que ainda não exista.");
		}
	}
	
	//sobrescrição do método de classificação
	@Override
	public void classificar(Double nota) throws ClassificacaoForaDoRangeException{
		if(nota < 0 || nota > 10) {
			throw new ClassificacaoForaDoRangeException("Erro ao adicionar a classificação para a série \"" + this.nome + "\": a nota não deve ser menor que zero ou maior que dez.");
		}else {
			super.pontuacao = nota;
		}
	}	
	
	@Override
	public String toString() {
		return "Nome: " + super.nome + (super.pontuacao == null ? "" : (" | Nota: " + String.format("%.1f", super.pontuacao) + "/10")) + (this.temporadas.size() > 0 ? (" | Temporadas: " + this.temporadas.size() + " | Episódios: " + this.getTotalEpisodios()) : ""); 
	}
}

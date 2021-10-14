package Serraflix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Serie extends Programa{
	private ArrayList<Temporada> temporadas = new ArrayList<>();
	private static int contador = 0;
	
	//construtor padrão
	public Serie(String nome, Double pontuacao, Categoria categoria, List<Integer> qtdEps){
		super(nome, pontuacao, categoria);
		try {
			adicionarTemporadas(qtdEps);
		} catch (Exception e) {
			/*System.out.println(e.getMessage());*/
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
	/*public void removerTemporada(int nome) throws Exception{
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
			throw new Exception("*** IMPOSSÍVEL REMOVER: TEMPORADA INEXISTENTE ***");
		}
	}*/
	
	//método de adicionar temporadas em massa
	public void adicionarTemporadas(List<Integer> qtdEps) throws Exception{
		if(qtdEps.size() > 0) {
			for(int i = 0; i < qtdEps.size(); i++) {
				this.temporadas.add(new Temporada(i + 1, qtdEps.get(i)));
			}
		}else {
			throw new Exception("\n*** NÃO FOI POSSÍVEL ADICIONAR TEMPORADAS PARA A SÉRIE" + (this.nome == null ? "" : (" \"" + this.nome + "\"")) + ". ***");
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
	public static void classificar(Double nota) throws ClassificacaoForaDoRangeException{
		if(nota != null) {
			if(nota < 0 || nota > 10) {
				throw new ClassificacaoForaDoRangeException("\n*** ERRO AO ADICIONAR A PONTUAÇÃO: A NOTA NÃO PODE SER MENOR QUE ZERO OU MAIOR DO QUE DEZ ***");
			}
		}
	}
	
	public static void aumentarContador() {
		contador++;
	}

	public static void diminuirContador() {
		contador--;
	}
	
	public static int obterContador() {
		return contador;
	}
	
}

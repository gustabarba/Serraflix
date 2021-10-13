package Serraflix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Serie extends Programa{
	private ArrayList<Temporada> temporadas = new ArrayList<>();
	
	//construtor padr�o
	public Serie(String nome, Double pontuacao, Categoria categoria, List<Integer> qtdEps){
		super(nome, pontuacao, categoria);
		try {
			adicionarTemporadas(qtdEps);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//construtor de edi��o
	public Serie(String nome, Double pontuacao, Categoria categoria, List<Integer> qtdEps, int id){
		super(nome, pontuacao, categoria, id);
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
			throw new Exception("*** IMPOSS�VEL REMOVER: TEMPORADA INEXISTENTE ***");
		}
	}*/
	
	//m�todo de adicionar temporadas em massa
	public void adicionarTemporadas(List<Integer> qtdEps) throws Exception{
		if(qtdEps.size() > 0) {
			for(int i = 0; i < qtdEps.size(); i++) {
				this.temporadas.add(new Temporada(i + 1, qtdEps.get(i)));
			}
		}else {
			throw new Exception("\n*** ERRO AO ADICIONAR TEMPORADAS PARA A S�RIE" + (this.nome == null ? "" : (" \"" + this.nome + "\"")) + ": VOC� PRECISA ADICIONAR UM N�MERO POSITIVO DE EPIS�DIOS, E S� PODE CRIAR UMA TEMPORADA QUE AINDA N�O EXISTA ***");
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
				throw new ClassificacaoForaDoRangeException("\n*** ERRO AO ADICIONAR A CLASSIFICA��O: A NOTA N�O PODE SER MENOR QUE ZERO OU MAIOR DO QUE DEZ ***");
			}else {
				super.pontuacao = nota;
			}
		}else {
			super.pontuacao = null;
			/*throw new ClassificacaoForaDoRangeException("\n*** AVISO: N�O FOI INFORMADO UM VALOR PARA CLASSIFICA��O ***");*/
		}
	}	
	
	@Override
	public String toString() {
		String retorno = "";
		retorno = "\n" + super.nome + " | S�RIE\n\n"
				 + "NOTA: " + (super.pontuacao == null ? "SEM NOTA" : String.format("%.1f", super.pontuacao) + "/10") + "\n"
				 + "CATEGORIA: " + this.getCategoria().getNomeCategoria() + "\n\n"
				 + "TEMPORADAS: " + this.temporadas.size() + "\n\n";
		for(Temporada t: this.getTemporadas()) {
			retorno += String.format("%02d", t.getNomeTemporada()) + "� TEMP: " + String.format("%02d", t.getQuantidadeEpisodios()) + " EPS\n";
		}
		retorno += "\nTOTAL DE EPIS�DIOS: " + this.getTotalEpisodios();
		return retorno;
	}
}

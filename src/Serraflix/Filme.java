package Serraflix;

public class Filme extends Programa{
	private int duracao;
	
	//construtor
	public Filme(String nome, Double pontuacao, Categoria categoria, int duracao) {
		super(nome, pontuacao, categoria);
		this.duracao = duracao;
	}
	
	@Override
	public String toString() {
		return "\nInformações sobre o filme: \n\n"
				+ "Nome: " + super.nome + "\n"
				 + (super.pontuacao == null ? "" : ("Nota: " + String.format("%.1f", super.pontuacao) + "/10 \n"))
				 + "Categoria: " + this.getCategoria().getNomeCategoria() + "\n"
				 + "Duração: " + this.duracao;
	}
	
	//método de classificação
	public void classificar(Double nota) throws ClassificacaoForaDoRangeException{
		if(nota != null) {
			if(nota < 0 || nota > 5) {
				super.pontuacao = null;
				throw new ClassificacaoForaDoRangeException("Erro ao adicionar a classificação para a série \"" + this.nome + "\": a nota não deve ser menor que zero ou maior que cinco.");
			}else {
				super.pontuacao = nota;
			}
		}else {
			super.pontuacao = null;
		}
	}	
	
	
	
	
	
	
	
	
	
	
	//getter e setter
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
}

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
		return "\nInforma��es sobre o filme: \n\n"
				+ "Nome: " + super.nome + "\n"
				 + (super.pontuacao == null ? "" : ("Nota: " + String.format("%.1f", super.pontuacao) + "/10 \n"))
				 + "Categoria: " + this.getCategoria().getNomeCategoria() + "\n"
				 + "Dura��o: " + this.duracao;
	}
	
	//m�todo de classifica��o
	public void classificar(Double nota) throws ClassificacaoForaDoRangeException{
		if(nota != null) {
			if(nota < 0 || nota > 5) {
				super.pontuacao = null;
				throw new ClassificacaoForaDoRangeException("Erro ao adicionar a classifica��o para a s�rie \"" + this.nome + "\": a nota n�o deve ser menor que zero ou maior que cinco.");
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

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
		return "Nome: " + super.nome + (super.pontuacao == null ? "" : (" | Nota: " + String.format("%.1f", super.pontuacao) + "/5")) + " | Dura��o: " + this.duracao + " minutos" + " | Categoria: " + this.getCategoria().getNomeCategoria();                                   
	}
	
	//m�todo de classifica��o
	public void classificar(Double nota) throws ClassificacaoForaDoRangeException{
		if(nota < 0 || nota > 5) {
			throw new ClassificacaoForaDoRangeException("Erro ao adicionar a classifica��o para o filme \"" + this.nome + "\": a nota n�o deve ser menor que zero ou maior que cinco.");
		}else {
			super.pontuacao = nota;
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

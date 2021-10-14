package Serraflix;

public class Filme extends Programa{
	private Integer duracao;
	
	//construtor padr�o
	public Filme(String nome, Double pontuacao, Categoria categoria, Integer duracao) {
		super(nome, pontuacao, categoria);
		this.duracao = duracao;
	}
	
	//construtor de edi��o
	public Filme(String nome, Double pontuacao, Categoria categoria, int duracao, int id){
		super(nome, pontuacao, categoria, id);
		this.duracao = duracao;
	}
	

	
	//m�todo de classifica��o
	public static void classificar(Double nota) throws ClassificacaoForaDoRangeException{
		if(nota != null) {
			if(nota < 0 || nota > 5) {
				throw new ClassificacaoForaDoRangeException("\n*** ERRO AO ADICIONAR A PONTUA��O: A NOTA DEVE SER MAIOR QUE ZERO E MENOR QUE CINCO ***");
			}
		}
	}	
		
	//getter e setter
	public Integer getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
}

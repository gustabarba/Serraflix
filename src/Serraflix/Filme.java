package Serraflix;

public class Filme extends Programa{
	private Integer duracao;
	
	//construtor padr�o
	public Filme(String nome, Double pontuacao, Categoria categoria, Integer duracao){
		super(nome, pontuacao, categoria);
		this.duracao = duracao;
	}
	
	//construtor de edi��o
	public Filme(String nome, Double pontuacao, Categoria categoria, int duracao, int id){
		super(nome, pontuacao, categoria, id);
		this.duracao = duracao;
	}
	
	@Override
	public String toString() {
		return "\n" + super.nome + " | FILME\n\n"
				 + (super.pontuacao == null ? "" : ("NOTA: " + String.format("%.1f", super.pontuacao) + "/5 \n"))
				 + "CATEGORIA: " + this.getCategoria().getNomeCategoria() + "\n"
				 + "DURA��O: " + this.duracao + " MINUTOS";
	}
	
	//m�todo de classifica��o
	public void classificar(Double nota) throws ClassificacaoForaDoRangeException{
		if(nota != null) {
			if(nota < 0 || nota > 5) {
				super.pontuacao = null;
				throw new ClassificacaoForaDoRangeException("\n*** ERRO AO ADICIONAR A CLASSIFICA��O: A NOTA DEVE SER MAIOR QUE ZERO E MENOR QUE CINCO ***");
			}else {
				super.pontuacao = nota;
			}
		}else {
			super.pontuacao = null;
			throw new ClassificacaoForaDoRangeException("\n*** AVISO: N�O FOI INFORMADO UM VALOR PARA CLASSIFICA��O ***");
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

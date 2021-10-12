package Serraflix;

public class Filme extends Programa{
	private int duracao;
	
	//construtor padrão
	public Filme(String nome, Double pontuacao, Categoria categoria, int duracao){
		super(nome, pontuacao, categoria);
		this.duracao = duracao;
	}
	
	//construtor de edição
	public Filme(String nome, Double pontuacao, Categoria categoria, int duracao, int id){
		super(nome, pontuacao, categoria, id);
		this.duracao = duracao;
	}
	
	@Override
	public String toString() {
		return "\n" + super.nome + " | Filme\n\n"
				 + (super.pontuacao == null ? "" : ("Nota: " + String.format("%.1f", super.pontuacao) + "/5 \n"))
				 + "Categoria: " + this.getCategoria().getNomeCategoria() + "\n"
				 + "Duração: " + this.duracao + " minutos";
	}
	
	//método de classificação
	public void classificar(Double nota) throws ClassificacaoForaDoRangeException{
		if(nota != null) {
			if(nota < 0 || nota > 5) {
				super.pontuacao = null;
				throw new ClassificacaoForaDoRangeException("\nErro ao adicionar a classificação: a nota não deve ser menor que zero ou maior que cinco.");
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

package Serraflix;

public abstract class Programa implements Classificar{
	protected String nome;
	protected Double pontuacao;
	protected Categoria categoria;
	protected int id;
	private static int controladorid;
	
	//construtor padrão
	public Programa(String nome, Double pontuacao, Categoria categoria) {
		controladorid++;
		this.id = controladorid;
		this.nome = nome;
		try {
			classificar(pontuacao);
		} catch (ClassificacaoForaDoRangeException e) {
			/*System.out.println(e.getMessage());*/
		}
		this.categoria = categoria;
	}
	
	//construtor para edição
	public Programa(String nome, Double pontuacao, Categoria categoria, int id) {
		this.id = id;
		this.nome = nome;
		try {
			classificar(pontuacao);
		} catch (ClassificacaoForaDoRangeException e) {
			/*System.out.println(e.getMessage());*/
		}
		this.categoria = categoria;
	}
	
	//getters e setters
	public double getPontuacao() throws Exception{
		try {
			return pontuacao;
		}catch(Exception e){
			throw new Exception();
		}
	}
	public void setPontuacao(Double pontuacao) {
		this.pontuacao = pontuacao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public int getId() {
		return id;
	}
}

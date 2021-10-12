package Serraflix;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	private ArrayList<Programa> programas = new ArrayList<>();
	//construtor vazio
	public Biblioteca() {
		
	}
	
	//método de obter programa por nome
	public ArrayList<Programa> getProgramaPorNome(String nome){
		ArrayList<Programa> resultado = new ArrayList<>();
		String termoPesquisa = nome.toLowerCase();
		termoPesquisa = Normalizer.normalize(termoPesquisa, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		
		for(Programa p: this.programas) {
			String nomeCadastrado = p.nome.toLowerCase();
			nomeCadastrado = Normalizer.normalize(nomeCadastrado, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
			if(nomeCadastrado.contains(termoPesquisa)) {
				resultado.add(p);
			}
		}
		if(resultado.size() > 0) {
			return resultado;
		}else {
			return null;
		}
	}
	
	//método de obter programas por categoria
	public ArrayList<Programa> getProgramasPorCategoria(Categoria categoria){
		ArrayList<Programa> resultado = new ArrayList<>();
		for(Programa p: this.programas) {
			if(p.getCategoria().equals(categoria)) {
				resultado.add(p);
			}
		}
		if(resultado.size() > 0) {
			return resultado;
		}else {
			return null;
		}
	}
	
	//listar programas
	public ArrayList<Programa> listarProgramas(int opcao){
		ArrayList<Programa> programas = new ArrayList<>();
		for(Programa p: this.programas) {
			if((opcao == 1 && p instanceof Filme) || (opcao == 2 && p instanceof Serie) || (opcao == 3)) {
				programas.add(p);
			}
		}
		return programas;
	}
	
	//método de adicionar um programa
	public void addPrograma(Programa programa) {
		this.programas.add(programa);
	}
	
	//método de adicionar programas em massa
	public void addProgramas(List<Programa> programas) {
		this.programas.addAll(programas);
	}
	
	//método de deletar programa por id
	public void deletarProgramaPorId(int id) {
		for(int i = 0; i < this.programas.size(); i++) {
			if(this.programas.get(i).getId() == id) {
				this.programas.remove(i);
				break;
			}
		}
	}
	
}

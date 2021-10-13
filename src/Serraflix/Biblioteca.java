package Serraflix;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Biblioteca{
	private ArrayList<Programa> programas = new ArrayList<>();
	//construtor vazio
	public Biblioteca() {
		
	}
	
	//listar programas por tipo, categoria, e nome
	public ArrayList<Programa> listarProgramas(int opcao, Categoria cat, String nome){
		ArrayList<Programa> programas = new ArrayList<>();
		String termoPesquisa = "";
		if(nome != null) {
			termoPesquisa = Normalizer.normalize(nome, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
		}
		for(Programa p: this.programas) {
			String nomeCadastrado = "";
			if(opcao == 5) {
				nomeCadastrado = Normalizer.normalize(p.nome, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
			}
			if((opcao == 1 && p instanceof Filme) || (opcao == 2 && p instanceof Serie) || (opcao == 3) || (opcao == 4 && p.getCategoria().equals(cat)) || (opcao == 5 && nomeCadastrado.contains(termoPesquisa)) ) {
				programas.add(p);
			}
		}
		Collections.sort(programas, new ordenarProgramasPorNome());
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
	
	//método de deletar programa por indice
	public void deletarProgramaPorIndice(int indice) {
		this.programas.remove(indice);
	}
	
	//método de encontrar índice do programa por id
	public int encontrarIndicePorId(int id) {
		int indice = -1;
		for(int i = 0; i < this.programas.size(); i++) {
			if(this.programas.get(i).getId() == id) {
				indice = i;
				break;
			}
		}
		return indice;
	}
		
	
}
class ordenarProgramasPorNome implements Comparator<Programa>
{
    public int compare(Programa a, Programa b)
    {
        return a.nome.compareTo(b.nome);
    }
}

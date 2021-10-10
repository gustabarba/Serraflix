package Serraflix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
	private ArrayList<Programa> programas = new ArrayList<>();
	static Scanner ler = new Scanner(System.in);
	//construtor vazio
	public Biblioteca() {
		
	}
	
	//método de obter programa por nome
	public Programa getProgramaPorNome(String nome) throws Exception{
		Programa resultado = null;
		for(Programa p: this.programas) {
			if(p.getNome().equals(nome)) {
				resultado = p;
				break;
			}
		}
		if(resultado != null) {
			return resultado;
		}else {
			throw new Exception("O programa não foi encontrado.");
		}
	}
	
	//método de obter programas por categoria
	public ArrayList<Programa> getProgramasPorCategoria(Categoria categoria) throws Exception{
		ArrayList<Programa> resultado = new ArrayList<>();
		for(Programa p: this.programas) {
			if(p.getCategoria().equals(categoria)) {
				resultado.add(p);
			}
		}
		if(resultado.size() > 0) {
			return resultado;
		}else {
			throw new Exception("Nenhum programa encontrado com essa categoria.");
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
	
	//método de deletar programa por nome
	public void deletarProgramaPorNome(String nome) {
		for(int i = 0; i < this.programas.size(); i++) {
			if(this.programas.get(i).getNome() == nome) {
				this.programas.remove(i);
			}
		}
	}
	
}

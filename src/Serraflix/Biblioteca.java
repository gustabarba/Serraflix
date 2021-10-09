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
			throw new Exception("O Programa não foi encontrado.");
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
	
	// método de escolher categoria no console
	public Categoria fluxoEscolherCategoria() {
		Categoria categoriaEscolhida = null;
				
		while(categoriaEscolhida == null) {
			System.out.println();
			
			System.out.println("Digite o número da categoria: \n\n"
					+ "1: fantasia \n"
					+ "2: terror \n"
					+ "3: comédia \n\n");
			
			int numeroCategoria = ler.nextInt();
			
			switch(numeroCategoria) {
			case 1:
				categoriaEscolhida = Categoria.FANTASIA;
				break;
			case 2:
				categoriaEscolhida = Categoria.TERROR;								
				break;
			case 3:
				categoriaEscolhida = Categoria.COMEDIA;
				break;
			default:
				System.out.println();
				
				System.out.println("Opção inválida! \n");
				break;
			}
		}
		
		return categoriaEscolhida;
	}
	
	// método de cadastrar categoria no console
	public void fluxoCadastrarFilme(Programa prog) {
		System.out.println();
		
		System.out.println("Digite o nome do filme: \n");
			
		String nomeDoFilme = ler.nextLine();
		
		System.out.println();
		
		System.out.println("Digite a pontuação de 1 a 5: \n");
		
		Double pontuacaoFilme = ler.nextDouble(); ler.nextLine();
		
		System.out.println();
		
		System.out.println("Digite a duração em minutos: \n");
		
		int duracao = ler.nextInt();
		
		Categoria categoriaFilme = this.fluxoEscolherCategoria();
		
		if(nomeDoFilme != "" && duracao != 0) {
			this.addPrograma(new Filme(nomeDoFilme, pontuacaoFilme, categoriaFilme, duracao));
			try {
				System.out.println(this.getProgramaPorNome("duna").toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("Programa não criado, dados incorretos foram inseridos.");
		}
	}
	
	// método de cadastrar série no console
	public void fluxoCadastrarSerie(Programa prog) {
		System.out.println();
		
		System.out.println("Digite o nome da série: \n");
			
		String nomeDaSerie = ler.nextLine();
		
		System.out.println();
		
		System.out.println("Digite a pontuação de 1 a 10: \n");
		
		Double pontuacaoSerie = ler.nextDouble(); ler.nextLine();
		
		System.out.println();
		
		System.out.println("Quantas temporadas? \n");
		
		int numTemporadas = ler.nextInt();
		
		ArrayList<Integer> qtdEps = new ArrayList<>();
		
		for(int i = 0; i < numTemporadas; i++) {
			
			System.out.println();
			
			System.out.println("Quantos episódios na " + (i + 1) + "º temporada? \n");
			
			qtdEps.add(ler.nextInt());
		}
		
		Categoria categoriaSerie = this.fluxoEscolherCategoria();
		
		if(nomeDaSerie != "" && qtdEps.size() > 0) {
			this.addPrograma(new Serie(nomeDaSerie, pontuacaoSerie, categoriaSerie, qtdEps));
			try {
				System.out.println(this.getProgramaPorNome("friends").toString());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}else {
			System.out.println("Programa não criado, verifique seus dados inseridos.");
		}
	}
}

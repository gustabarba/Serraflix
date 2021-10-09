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
	
	//m�todo de obter programa por nome
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
			throw new Exception("O programa n�o foi encontrado.");
		}
	}
	
	//m�todo de obter programas por categoria
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
	
	//m�todo de adicionar um programa
	public void addPrograma(Programa programa) {
		this.programas.add(programa);
	}
	
	//m�todo de adicionar programas em massa
	public void addProgramas(List<Programa> programas) {
		this.programas.addAll(programas);
	}
	
	// m�todo de escolher categoria no console
	public Categoria fluxoEscolherCategoria(Categoria cat) {
		Categoria categoriaEscolhida = null;
				
		while(categoriaEscolhida == null) {
			System.out.println();
			
			System.out.println("Digite o n�mero da categoria: \n");
			System.out.println("1: fantasia" + (cat != null ? (cat.equals(Categoria.FANTASIA) ? " (atual)" : ""): ""));
			System.out.println("2: com�dia" + (cat != null ? (cat.equals(Categoria.COMEDIA) ? " (atual)" : ""): ""));
			System.out.println("3: terror" + (cat != null ? (cat.equals(Categoria.TERROR) ? " (atual)" : ""): ""));
			
			int numeroCategoria = ler.nextInt();ler.nextLine();
			
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
				
				System.out.println("Op��o inv�lida! \n");
				break;
			}
		}
		
		return categoriaEscolhida;
	}
	
	// m�todo de cadastrar filme no console
	public void fluxoCadastrarFilme(Programa prog) {
		System.out.println();
		
		System.out.println("Nome do filme:");
		
		String nomeDoFilme = "teste";
		
		if(prog != null) {
			System.out.print("\n" + prog.getNome() + " (\"m\" para manter, ou digite um novo nome): ");
			String bufferNomeDoFilme = ler.nextLine();
			if(bufferNomeDoFilme == "m") {
				nomeDoFilme = prog.getNome();
			}else {
				nomeDoFilme = bufferNomeDoFilme;
			}
		}else {
			nomeDoFilme = ler.nextLine();
		}
		
		System.out.println();
		
		Double pontuacaoFilme = null;
		
		if(!(prog == null)) {
			try {
				pontuacaoFilme = prog.getPontuacao();
			} catch (Exception e) {
				
			}
		}
		
		System.out.println("Pontua��o de 1 a 5:");
		
		if(prog != null && pontuacaoFilme != null) {
			System.out.print("\n" + pontuacaoFilme + " (\"M\" para manter, ou digite nova pontua��o): ");
		}
		
		String bufferPontuacao = ler.nextLine();
		
		if(!(bufferPontuacao.isEmpty()) || !(bufferPontuacao == null)) {
			try {
				pontuacaoFilme = Double.valueOf(bufferPontuacao);
			}catch(Exception e) {			
					
			}
		}		
		
		System.out.println();
		
		int duracao = 0;
		
		System.out.println("Digite a dura��o em minutos:");
		
		if(prog != null) {
			duracao = ((Filme) prog).getDuracao();
			System.out.print("\n" + ((Filme) prog).getDuracao() + " (\"M\" para manter, ou digite nova dura��o): ");
		}
		
		String bufferDuracao = ler.nextLine();
		
		if(!(bufferDuracao.isEmpty()) || !(bufferDuracao == null)) {
			try {
				duracao = Integer.valueOf(bufferDuracao);
			}catch(Exception e) {			
					
			}
		}
		
		Categoria categoriaFilme = this.fluxoEscolherCategoria((prog != null ? prog.getCategoria() : null));
		
		if(nomeDoFilme != null && duracao != 0) {
			this.addPrograma(new Filme(nomeDoFilme, pontuacaoFilme, categoriaFilme, duracao));
			try {
				System.out.println(this.getProgramaPorNome("duna").toString());
			} catch (Exception e) {
				
			}
		}else {
			System.out.println("Programa n�o criado, dados incorretos foram inseridos.");
		}
	}
	
	// m�todo de cadastrar s�rie no console
	public void fluxoCadastrarSerie(Programa prog) {
		System.out.println();
		
		System.out.println("Digite o nome da s�rie: \n");
			
		String nomeDaSerie = ler.nextLine();
		
		System.out.println();
		
		System.out.println("Digite a pontua��o de 1 a 10: \n");
		
		Double pontuacaoSerie = ler.nextDouble(); ler.nextLine();
		
		System.out.println();
		
		System.out.println("Quantas temporadas? \n");
		
		int numTemporadas = ler.nextInt();
		
		ArrayList<Integer> qtdEps = new ArrayList<>();
		
		for(int i = 0; i < numTemporadas; i++) {
			
			System.out.println();
			
			System.out.println("Quantos epis�dios na " + (i + 1) + "� temporada? \n");
			
			qtdEps.add(ler.nextInt());
		}
		
		Categoria categoriaSerie = this.fluxoEscolherCategoria((prog != null ? prog.getCategoria() : null));
		
		if(nomeDaSerie != "" && qtdEps.size() > 0) {
			this.addPrograma(new Serie(nomeDaSerie, pontuacaoSerie, categoriaSerie, qtdEps));
			try {
				System.out.println(this.getProgramaPorNome("friends").toString());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}else {
			System.out.println("Programa n�o criado, verifique seus dados inseridos.");
		}
	}
}

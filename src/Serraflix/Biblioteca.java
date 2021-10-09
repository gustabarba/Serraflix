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
	
	// método de escolher categoria no console
	public Categoria fluxoEscolherCategoria(Categoria cat) {
		Categoria categoriaEscolhida = null;
				
		while(categoriaEscolhida == null) {
			System.out.println();
			
			System.out.println("Digite o número da categoria: \n");
			System.out.println("1: fantasia" + (cat != null ? (cat.equals(Categoria.FANTASIA) ? " (atual)" : ""): ""));
			System.out.println("2: terror" + (cat != null ? (cat.equals(Categoria.TERROR) ? " (atual)" : ""): ""));
			System.out.println("3: comédia" + (cat != null ? (cat.equals(Categoria.COMEDIA) ? " (atual)" : ""): "\n"));
			
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
				
				System.out.println("Opção inválida! \n");
				break;
			}
		}
		
		return categoriaEscolhida;
	}
	
	// método de cadastrar filme no console
	public void fluxoCadastrarFilme(Programa prog) {
		System.out.println();
		
		System.out.println("Nome do filme:");
		
		String nomeDoFilme = null;
		
		if(prog != null) {
			System.out.print("\n" + prog.getNome() + " (\"Enter\" para manter, ou digite um novo nome): ");
			String bufferNomeDoFilme = ler.nextLine();
			if(bufferNomeDoFilme.equals("")) {
				nomeDoFilme = prog.getNome();
			}else {
				nomeDoFilme = bufferNomeDoFilme;
			}
		}else {
			nomeDoFilme = ler.nextLine();
		}
		
		System.out.println();
		
		double pontuacaoFilme = 11.;
		
		if(!(prog == null)) {
			try {
				pontuacaoFilme = prog.getPontuacao();
			} catch (Exception e) {
				
			}
		}
		
		System.out.println("Pontuação de 1 a 5:");
		
		if(pontuacaoFilme != 11) {
			System.out.print("\n" + pontuacaoFilme + " (\"Enter\" para manter, ou digite nova pontuação): ");
		}
		
		String bufferPontuacao = ler.nextLine();
		
		if(!(bufferPontuacao.equals(""))) {
			try {
				pontuacaoFilme = Double.valueOf(bufferPontuacao);
			}catch(Exception e) {			
					
			}
		}		
		
		System.out.println();
		
		Integer duracao = null;
		
		System.out.println("Digite a duração em minutos:");
		
		if(prog != null) {
			duracao = ((Filme) prog).getDuracao();
			System.out.print("\n" + ((Filme) prog).getDuracao() + " (\"Enter\" para manter, ou digite nova duração): ");
		}
		
		String bufferDuracao = ler.nextLine();
		
		if(!(bufferDuracao.equals(""))) {
			try {
				duracao = Integer.valueOf(bufferDuracao);
			}catch(Exception e) {			
					
			}
		}
		
		Categoria categoriaFilme = this.fluxoEscolherCategoria((prog != null ? prog.getCategoria() : null));
		
		if(nomeDoFilme != null && duracao != null) {
			if(prog != null) {
				this.deletarProgramaPorNome(prog.getNome());
			}
			this.addPrograma(new Filme(nomeDoFilme, pontuacaoFilme, categoriaFilme, duracao));
			try {
				System.out.println("\n" + this.getProgramaPorNome(nomeDoFilme).toString());
			} catch (Exception e) {
				
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
		
		Categoria categoriaSerie = this.fluxoEscolherCategoria((prog != null ? prog.getCategoria() : null));
		
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

package Serraflix;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Program {
	static Scanner ler = new Scanner(System.in);	
	static Biblioteca catalogoBrasil = new Biblioteca();
	public static void main(String[] args) {
		catalogoBrasil.addProgramas(Arrays.asList(
				new Serie("The Office", 8.9, Categoria.COMEDIA, Arrays.asList(6, 22, 25, 19, 28, 26, 26, 24, 25)),
				new Serie("Hinterland", 9.5, Categoria.TERROR, Arrays.asList(8, 10, 8)),
				new Serie("Cowboy Bebop", 8.9, Categoria.COMEDIA, Arrays.asList(26)),
				new Serie("Breaking Bad", 9.4, Categoria.TERROR, Arrays.asList(7, 13, 13, 13, 16)),
				new Serie("Dr. House", 8.7, Categoria.FANTASIA, Arrays.asList(22, 24, 24, 16, 24, 22, 23, 22)),
				new Filme("Lost In Translation", 3.8, Categoria.COMEDIA, 101),
				new Filme("Eternal Sunshine Of The Spotless Mind", 4.1, Categoria.TERROR, 108),			
				new Filme("Her", 4., Categoria.COMEDIA, 126),			
				new Filme("Cowboy Bebop: The Movie", 3.9, Categoria.FANTASIA, 115)
			));
		

		boolean emOperacao = true;
		
		System.out.println("Bem vindo ao Serraflix! (digite sempre o número da opção desejada)");
		
		while(emOperacao) {	
			System.out.println();
			System.out.println("O que você deseja fazer? \n\n"
					+ "1: criar um programa \n"
					+ "2: editar um programa \n"
					+ "3: remover um programa \n"
					+ "4: exibir dados de um programa \n"
					+ "5: listar vários programas \n\n"
					+ "0: sair \n");			
			int opcaoSelecionada = ler.nextInt(); ler.nextLine();	
			
			
			switch(opcaoSelecionada) {
			case 1:		
				fluxoCriarPrograma();
				break;
			case 2:
				fluxoEditarPrograma();
				break;
			case 3:
				/// remover um programa
				break;
			case 4:
				/// exibir dados de um programa
				break;
			case 5:
				/// listar vários programas
				break;
			case 0:
				emOperacao = false;
				break;
			default:
				System.out.println("Escolha uma opção válida!");
				break;
			}
		}
		System.out.println("\nAté a próxima!");
		
		
		
		///////////// FIM DA MAIN ////////////////
		
		
		
	}
	
	// fluxo de criar programa
	public static void fluxoCriarPrograma() {			
		boolean criando = true;			
		while(criando) {		
			System.out.println();
			System.out.println("Qual tipo de programa você deseja criar? \n\n"
					+ "1: filme \n"
					+ "2: série \n\n"
					+ "0: voltar ao menu anterior \n");
			int filmeOuSerieCriar = ler.nextInt(); ler.nextLine();
			
			switch(filmeOuSerieCriar) {
			case 1:
				fluxoCadastrarEditarFilme(null);
				criando = false;
				break;
			case 2:
				fluxoCadastrarEditarSerie(null);
				criando = false;
				break;
			case 0:
				criando = false;
				break;
			default:
				System.out.println();
				System.out.println("Opção inválida!");
				break;
			}
		}
	}
	
	// fluxo de criar ou editar filme
	public static void fluxoCadastrarEditarFilme(Programa prog) {
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
		
		Categoria categoriaFilme = fluxoEscolherCategoria((prog != null ? prog.getCategoria() : null));
		
		if(nomeDoFilme != null && duracao != null) {
			if(prog != null) {
				catalogoBrasil.deletarProgramaPorNome(prog.getNome());
			}
			catalogoBrasil.addPrograma(new Filme(nomeDoFilme, pontuacaoFilme, categoriaFilme, duracao));
			try {
				System.out.println("\n" + catalogoBrasil.getProgramaPorNome(nomeDoFilme).toString());
			} catch (Exception e) {
				
			}
		}else {
			System.out.println("Programa não criado, dados incorretos foram inseridos.");
		}
	}

	// fluxo de criar ou editar série
	public static void fluxoCadastrarEditarSerie(Programa prog) {
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
		
		Categoria categoriaSerie = fluxoEscolherCategoria((prog != null ? prog.getCategoria() : null));
		
		if(nomeDaSerie != "" && qtdEps.size() > 0) {
			catalogoBrasil.addPrograma(new Serie(nomeDaSerie, pontuacaoSerie, categoriaSerie, qtdEps));
			try {
				System.out.println(catalogoBrasil.getProgramaPorNome(nomeDaSerie).toString());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}else {
			System.out.println("Programa não criado, verifique seus dados inseridos.");
		}
	}
	
	// fluxo de editar programa
	public static void fluxoEditarPrograma(){
		boolean editando = true;
		while(editando) {
			System.out.println();
			System.out.println("Qual tipo de programa você deseja editar? \n\n"
					+ "1: filme \n"
					+ "2: série \n\n"
					+ "0: voltar ao menu anterior \n");
			int filmeOuSerieEditar = ler.nextInt(); ler.nextLine();
			switch(filmeOuSerieEditar) {
			case 1:
				/// editar um filme
				boolean escolhendoFilme = true;
				while(escolhendoFilme) {
					System.out.println("\nQual filme você deseja editar?\n");
					ArrayList<Programa> filmes = catalogoBrasil.listarProgramas(1);
					for(int i = 0; i < filmes.size(); i++) {
						System.out.println((i + 1) + ": " + filmes.get(i).getNome());
					}						
					System.out.println("\n0: voltar ao menu anterior");
					System.out.println();
					int opcaoEditarFilme = ler.nextInt(); ler.nextLine();
					if(opcaoEditarFilme > 0 && opcaoEditarFilme <= filmes.size()) {
						fluxoCadastrarEditarFilme(filmes.get(opcaoEditarFilme - 1));
						escolhendoFilme = false;
						editando = false;
					}else {
						escolhendoFilme = false;
					}
				}				
				/// fim de editar um filme
				break;
			case 2:
				/// editar uma série
				fluxoCadastrarEditarSerie(null);
				editando = false;
				/// fim de editar uma série
				break;
			case 0:
				//voltar
				editando = false;
				break;
				//fim de voltar
			default:
				System.out.println();
				System.out.println("Opção inválida!");
				break;
			}
		}
	}
	
	// fluxo de escolher categoria
	public static Categoria fluxoEscolherCategoria(Categoria cat) {
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
}




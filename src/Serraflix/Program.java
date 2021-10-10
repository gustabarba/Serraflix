package Serraflix;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
					+ "4: exibir informações \n"
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
				fluxoRemoverPrograma();
				break;
			case 4:
				fluxoExibicao();
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
					+ "0: voltar ao menu principal \n");
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
		
		String bufferNomeDoFilme = ler.nextLine();
		
		if(prog != null) {
			System.out.print("\n" + prog.getNome() + " (\"Enter\" para manter, ou digite um novo nome): ");		
			nomeDoFilme = prog.getNome();			
		}
		
		if(!(bufferNomeDoFilme.equals(""))) {
			nomeDoFilme = bufferNomeDoFilme;
		}		
		
		System.out.println();
		
		double pontuacaoFilme = 11.;
		
		if(prog != null) {
			try {
				pontuacaoFilme = prog.getPontuacao();
			} catch (Exception e) {
				
			}
		}
		
		System.out.println("Pontuação de 1 a 5:");
		
		if(pontuacaoFilme != 11.) {
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
			System.out.println("Programa não criado: ele precisa ter pelo menos nome e duração.");
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
					+ "0: voltar ao menu principal \n");
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
	
	// fluxo de remover programa
	public static void fluxoRemoverPrograma() {
		boolean removendo = true;
		while(removendo) {
			System.out.println();
			System.out.println("Como deseja encontrar o programa a ser removido? \n\n"
					+ "1: escolher de uma listagem por tipo \n"
					+ "2: escolher de uma listagem por categoria \n"
					+ "3: escolher da lista com todos os programas \n"
					+ "4: encontrar por nome \n\n"
					+ "0: voltar ao menu principal \n");
			
			int opcaoEncontrar = ler.nextInt(); ler.nextLine();
			
			switch(opcaoEncontrar) {
			case 1:
				try{
					fluxoEfetuarRemocao(fluxoListarPorTipo());
					removendo = false;
				}
				catch(Exception e){
					
				}
				break;
			case 2:
				try{
					fluxoEfetuarRemocao(fluxoListarPorCategoria());
					removendo = false;
				}
				catch(Exception e) {
					
				}
				break;
			case 3:
				try{
					fluxoEfetuarRemocao(fluxoListarTodos());
					removendo = false;
				}
				catch(Exception e) {
					
				}
				break;
			case 4:
				try{
					fluxoEfetuarRemocao(fluxoEncontrarPorNome());
					removendo = false;
				}
				catch(Exception e) {
					
				}
				break;
			case 0:
				removendo = false;
				break;
			default:
				System.out.println("\nOpção inválida!\n");
				break;
			}
		}
	}
	
	//fluxo de efetuar a remoção
	public static void fluxoEfetuarRemocao(Programa prog) throws Exception {
		System.out.println(prog.toString());
		try {
			for (Programa p : catalogoBrasil.listarProgramas(3)) {
				if (prog.equals(prog)) {
					catalogoBrasil.deletarProgramaPorNome(prog.getNome());
					System.out.println("Programa deletado com sucesso!");
					break;
				}
			}
		} catch (Exception e) {
			
		}			
			
	}
	
	//fluxo de listar por tipo
	public static Programa fluxoListarPorTipo() {
		boolean escolhendoTipoAListar = true;
		Programa prog = null;
		while(escolhendoTipoAListar) {
			System.out.println("Qual tipo de programa você deseja listar? \n\n"
					+ "1: filme \n"
					+ "2: série \n\n");
			
			int filmeOuSerieListar = ler.nextInt(); ler.nextLine();
			
			switch(filmeOuSerieListar) {
			case 1:
				System.out.println("\nEscolha um filme da lista: \n\n");
				ArrayList<Programa> listaDeFilmes = catalogoBrasil.listarProgramas(1);
				for(int i = 0; i < listaDeFilmes.size(); i++) {
					System.out.println((i + 1) + ": " + listaDeFilmes.get(i).getNome());
				}
				System.out.println("\n0: voltar ao menu anterior");
				int filmeEscolhidoDaLista = ler.nextInt(); ler.nextLine();
				if(filmeEscolhidoDaLista > 0 && filmeEscolhidoDaLista <= listaDeFilmes.size()) {
					escolhendoTipoAListar = false;
					prog =  listaDeFilmes.get(filmeEscolhidoDaLista - 1);
				}else {
					if(filmeEscolhidoDaLista != 0) {
						System.out.println("\nOpção inválida!\n");
					}
				}
				break;
			case 2:
				System.out.println("\nEscolha uma série da lista: \n\n");
				ArrayList<Programa> listaDeSeries = catalogoBrasil.listarProgramas(2);
				for(int i = 0; i < listaDeSeries.size(); i++) {
					System.out.println((i + 1) + ": " + listaDeSeries.get(i).getNome());
				}
				System.out.println("\n0: voltar ao menu anterior");
				int serieEscolhidaDaLista = ler.nextInt(); ler.nextLine();
				if(serieEscolhidaDaLista > 0 && serieEscolhidaDaLista <= listaDeSeries.size()) {
					escolhendoTipoAListar = false;
					prog = listaDeSeries.get(serieEscolhidaDaLista - 1);
				}else {
					if(serieEscolhidaDaLista != 0) {
						System.out.println("\nOpção inválida!\n");
					}
				}
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		}
		return prog;
	}
	
	//fluxo de listar por categoria
	public static Programa fluxoListarPorCategoria() {
		boolean escolhendoCategoriaAListar = true;
		Programa prog = null;
		while(escolhendoCategoriaAListar) {
			System.out.println("De qual categoria você deseja listar? \n\n"
					+ "1: fantasia \n"
					+ "2: terror \n"
					+ "3: comédia \n\n");
			
			int categoriaEscolhidaAListar = ler.nextInt(); ler.nextLine();
			
			if(categoriaEscolhidaAListar > 0 && categoriaEscolhidaAListar <= 3) {
				try {
					System.out.println("\nEscolha um programa da lista: \n");
					ArrayList<Programa> progsDaCategoria = catalogoBrasil.getProgramasPorCategoria(Categoria.values()[categoriaEscolhidaAListar - 1]);
					for(int i = 0; i < progsDaCategoria.size(); i++) {
						System.out.println((i + 1) + ": " + progsDaCategoria.get(i).getNome());
					}
					System.out.println("\n0: voltar ao menu anterior");
					int progEscolhidoDaLista = ler.nextInt(); ler.nextLine();
					if(progEscolhidoDaLista > 0 && progEscolhidoDaLista <= progsDaCategoria.size()) {
						escolhendoCategoriaAListar = false;
						prog = progsDaCategoria.get(progEscolhidoDaLista - 1);
					}else {
						if(progEscolhidoDaLista != 0) {
							System.out.println("\nOpção inválida!\n");
						}
					}
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}else {
				System.out.println("Escolha uma categoria válida!");
			}
		}
		return prog;
	}
	
	//fluxo de listar todos
	public static Programa fluxoListarTodos() {
		Programa prog = null;
		boolean listando = true;
		while(listando) {
			System.out.println("Listagem com todos os programas:\n");
			ArrayList<Programa> listaDeTodos= catalogoBrasil.listarProgramas(3);
			for(int i = 0; i < listaDeTodos.size(); i++) {
				System.out.println((i + 1) + ": " + listaDeTodos.get(i).getNome());
				}
			System.out.println("\n0: voltar ao menu anterior");
			int programaEscolhidoDaLista = ler.nextInt(); ler.nextLine();
			if(programaEscolhidoDaLista > 0 && programaEscolhidoDaLista <= listaDeTodos.size()) {
				listando = false;
				prog = listaDeTodos.get(programaEscolhidoDaLista - 1);
			}else {
				if(programaEscolhidoDaLista != 0) {
					System.out.println("\nOpção inválida!\n");
				}else {
					listando = false;
					
				}
			}		
		}	
		return prog;
	}	
	
	//fluxo de encontrar por nome
	public static Programa fluxoEncontrarPorNome() {
		Programa prog = null;
		boolean escolhendo = true;
		while(escolhendo) {
			System.out.println("Insira o nome do programa que deseja consultar:\n");
			String nomeDoPrograma = ler.nextLine();
			try {
				prog = catalogoBrasil.getProgramaPorNome(nomeDoPrograma);
				escolhendo = false;
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		return prog;
		
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
	
	//fluxo de exibição
	public static void fluxoExibicao() {
		boolean exibindo = true;
		while(exibindo) {
			System.out.println("Escolha um dos métodos de exibição: \n\n"
					+ "1: listar por tipo\n"
					+ "2: listar por categoria \n"
					+ "3: listar todos os programas \n"
					+ "4: encontrar por nome \n\n"
					+ "0: voltar ao menu principal \n");
			int opcaoEscolhidaExibicao = ler.nextInt(); ler.nextLine();
			switch (opcaoEscolhidaExibicao) {
			case 1:
				try {
					fluxoEfetuaExibicao(fluxoListarPorTipo());
					exibindo = false;
				} catch (Exception e) {
				
				}
				
				break;
			case 2:
				try {
					fluxoEfetuaExibicao(fluxoListarPorCategoria());
					exibindo = false;
				} catch (Exception e) {
					
				}
				break;
			case 3:
				try {
					fluxoEfetuaExibicao(fluxoListarTodos());
					exibindo = false;
				} catch (Exception e) {
					
				}
				break;
			case 4:
				try {
					fluxoEfetuaExibicao(fluxoEncontrarPorNome());
					exibindo = false;
				} catch (Exception e) {
					
				}
	
				break;
			case 0:
				
				exibindo = false;
				break;

			default:
				break;
			}
		}
	}
	
	// fluxo efetuar exibição
	public static void fluxoEfetuaExibicao(Programa prog) throws Exception {
		System.out.println(prog.toString());
		
	}
	
	
}




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
				fluxoCriacao();
				break;
			case 2:
				fluxoEdicao();
				break;
			case 3:
				fluxoRemocao();
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

	public static void fluxoCriacao() {			
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
				criando = !(fluxoEfetuarCriacaoEdicao(null, 1));
				break;
			case 2:
				criando = !(fluxoEfetuarCriacaoEdicao(null, 2));
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
	public static void fluxoEdicao(){
		boolean editando = true;
		while(editando) {
			System.out.println();
			System.out.println("Como deseja encontrar o programa a ser editado? \n\n"
					+ "1: escolher de uma listagem por tipo \n"
					+ "2: escolher de uma listagem por categoria \n"
					+ "3: escolher da lista com todos os programas \n"
					+ "4: encontrar por nome \n\n"
					+ "0: voltar ao menu principal \n");
			
			int opcaoEncontrar = ler.nextInt(); ler.nextLine();
			
			switch(opcaoEncontrar) {
			case 1:
				editando = !(fluxoEfetuarCriacaoEdicao(subfluxoListarPorTipo(), null));
				break;
			case 2:				
				editando = !(fluxoEfetuarCriacaoEdicao(subfluxoListarPorCategoria(), null));
				break;
			case 3:				
				editando = !(fluxoEfetuarCriacaoEdicao(subfluxoListarTodos(), null));
				break;
			case 4:
				editando = !(fluxoEfetuarCriacaoEdicao(subfluxoEncontrarPorNome(), null));
				break;
			case 0:
				editando = false;
				break;
			default:
				System.out.println("\nOpção inválida!\n");
				break;
			}
		}
	}
	
	// fluxo de remover programa
	
	// fluxo de remover programa
	public static void fluxoRemocao() {
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
				removendo = !(fluxoEfetuarRemocao(subfluxoListarPorTipo()));
				break;
			case 2:
				removendo = !(fluxoEfetuarRemocao(subfluxoListarPorCategoria()));
				break;
			case 3:
				removendo = !(fluxoEfetuarRemocao(subfluxoListarTodos()));
				break;
			case 4:
				removendo = !(fluxoEfetuarRemocao(subfluxoEncontrarPorNome()));
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
	
	// fluxo de efetuar remoção
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
				exibindo = !(fluxoEfetuarExibicao(subfluxoListarPorTipo()));
				break;
			case 2:
				exibindo = !(fluxoEfetuarExibicao(subfluxoListarPorCategoria()));
				break;
			case 3:
				exibindo = !(fluxoEfetuarExibicao(subfluxoListarTodos()));
				break;
			case 4:
				exibindo = !(fluxoEfetuarExibicao(subfluxoEncontrarPorNome()));
				break;
			case 0:
				exibindo = false;
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		}
	}
	
	public static boolean fluxoEfetuarCriacaoEdicao(Programa prog, Integer tipo) {	
		boolean efetuado = false;
		if((prog != null) || (prog == null && tipo != null)) {	
			
			if(tipo == null) {
				if(prog instanceof Filme) {
					tipo = 1;
				}else if(prog instanceof Serie) {
					tipo = 2;
				}
				
			}
			
			switch(tipo) {
			case 1:
				System.out.println("Nome do filme:");
				break;
			case 2:
				System.out.println("Nome da série:");
				break;
			}
			
			String nomeDoPrograma = null;
			
			if(prog != null) {
				System.out.print("\n" + prog.getNome() + " (\"Enter\" para manter, ou digite um novo nome): ");		
				nomeDoPrograma = prog.getNome();			
			}
			
			String bufferNomeDoPrograma = ler.nextLine();
			
			if(!(bufferNomeDoPrograma.equals(""))) {
				nomeDoPrograma = bufferNomeDoPrograma;
			}		
			
			double pontuacaoPrograma = 11.;
			
			if(prog != null) {
				try {
					pontuacaoPrograma = prog.getPontuacao();
				} catch (Exception e) {
					
				}
			}
			
			switch(tipo) {
			case 1:
				System.out.println("Pontuação de 1 a 5:");
				break;
			case 2:
				System.out.println("Pontuação de 1 a 10:");
				break;
			}
			
			if(pontuacaoPrograma != 11.) {
				System.out.print("\n" + pontuacaoPrograma + " (\"Enter\" para manter, ou digite nova pontuação): ");
			}
			
			String bufferPontuacao = ler.nextLine();
			
			if(!(bufferPontuacao.equals(""))) {
				try {
					pontuacaoPrograma = Double.valueOf(bufferPontuacao);
				}catch(Exception e) {			
						
				}
			}		
			
			Integer duracao = null;
			
			Integer numTemporadas = null;
			
			ArrayList<Integer> qtdEps = new ArrayList<>();
			
			switch(tipo) {
			case 1:	
				System.out.println("Quantos minutos de duração?");
				
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
				break;
			case 2:
				System.out.println("Quantas temporadas? \n");
				
				if(prog != null) {
					System.out.print("(atual: " + ((Serie)prog).getNumeroTemporas() + ") \"Enter\" para manter, ou digite um novo valor): ");				
				}
				
				String bufferNumTemporadas = ler.nextLine();
				
				if(!(bufferNumTemporadas.equals(""))) {
					try {
						numTemporadas = Integer.valueOf(bufferNumTemporadas);
					}catch(Exception e) {			
							
					}
				}	
				
				if(prog != null && numTemporadas == null) {
					for(Temporada t : ((Serie)prog).getTemporadas()) {
						qtdEps.add(t.getQuantidadeEpisodios());
					}
				}
				
				if(numTemporadas != null) {
					for(int i = 0; i < numTemporadas; i++) {
						
						System.out.println();
						
						System.out.println("Quantos episódios na " + (i + 1) + "º temporada? \n");
						
						qtdEps.add(ler.nextInt());
					}
				}
				break;
			}
			
			Categoria categoriaPrograma = subfluxoEscolherCategoria((prog != null ? prog.getCategoria() : null));
			
			if(nomeDoPrograma != null && (duracao != null || qtdEps.size() > 0)) {
				if(prog != null) {
					catalogoBrasil.deletarProgramaPorNome(prog.getNome());
					System.out.println("Programa editado com sucesso!");	
				}else {
					System.out.println("Programa criado com sucesso!");	
				}
				switch(tipo) {
				case 1:
					catalogoBrasil.addPrograma(new Filme(nomeDoPrograma, pontuacaoPrograma, categoriaPrograma, duracao));
					break;
				case 2:
					catalogoBrasil.addPrograma(new Serie(nomeDoPrograma, pontuacaoPrograma, categoriaPrograma, qtdEps));
					break;
				}		
				efetuado = true;
			}else {
				System.out.println("O programa não foi criado: dados vazios foram inseridos.");
			}
		}
		return efetuado;
	}
	public static boolean fluxoEfetuarRemocao(Programa prog){
		boolean efetuado = false;
		if(prog != null) {
			for (Programa p : catalogoBrasil.listarProgramas(3)) {
				if (p.equals(prog)) {
					catalogoBrasil.deletarProgramaPorNome(prog.getNome());
					System.out.println("Programa deletado com sucesso!");
					efetuado = true;
					break;
				}
			}
		} 		
		return efetuado;
	}
	public static boolean fluxoEfetuarExibicao(Programa prog){
		boolean efetuado = false;
		if(prog != null) {
			System.out.println(prog.toString());
		}
		return efetuado;
	}
	
	public static Programa subfluxoListarPorTipo() {
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
	
	// fluxo de listar por categoria
	public static Programa subfluxoListarPorCategoria() {
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
	
	//fluxo de listar todos
	public static Programa subfluxoListarTodos() {
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
	
	// fluxo de encontrar por nome
	public static Programa subfluxoEncontrarPorNome() {
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
	
	// fluxo de escolher categoria
	public static Categoria subfluxoEscolherCategoria(Categoria cat) {
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
	
	// fluxo de exibição

	
	
}




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
				new Serie("Breaking Bad", 11., Categoria.TERROR, Arrays.asList(7, 13, 13, 13, 16)),
				new Serie("Dr. House", 8.5, Categoria.FANTASIA, Arrays.asList(22, 24, 24, 16, 24, 22, 23, 22)),
				new Filme("Lost In Translation", 3.8, Categoria.COMEDIA, 101),
				new Filme("Eternal Sunshine Of The Spotless Mind", 4.1, Categoria.TERROR, 108),			
				new Filme("Her", 4., Categoria.COMEDIA, 126),			
				new Filme("Cowboy Bebop: The Movie", 3.9, Categoria.FANTASIA, 115),
				new Filme("A Bela Amortecida", 11., Categoria.FANTASIA, 0)
			));
		

		boolean emOperacao = true;
		
		System.out.println("Bem vindo ao Serraflix! (digite sempre o número da opção desejada)");
		
		while(emOperacao) {	
			System.out.println();
			System.out.println("O que você deseja fazer? \n\n"
					+ "1: criar um programa \n"
					+ "2: editar um programa \n"
					+ "3: remover um programa \n"
					+ "4: exibir informações \n\n"
					+ "0: sair \n");			
			
			System.out.print("> ");
			
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
				System.out.print("> (Opção inválida!)\n");
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
			
			System.out.print("> ");
			
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
				System.out.print("> (Opção inválida!)\n");
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
			
			System.out.print("> ");
			
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
				System.out.print("> (Opção inválida!)\n");
				break;
			}
		}
	}
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
			
			System.out.print("> ");
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
				System.out.print("> (Opção inválida!)\n");
				break;
			}
		}
	}
	public static void fluxoExibicao() {
		boolean exibindo = true;
		while(exibindo) {
			System.out.println("\nEscolha um dos métodos de exibição: \n\n"
					+ "1: listar por tipo\n"
					+ "2: listar por categoria \n"
					+ "3: listar todos os programas \n"
					+ "4: encontrar por nome \n\n"
					+ "0: voltar ao menu principal \n");
			System.out.print("> ");
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
				System.out.print("> (Opção inválida!)\n");
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
				System.out.println("\nNome do filme:\n");
				break;
			case 2:
				System.out.println("\nNome da série:\n");
				break;
			}
			
			String nomeDoPrograma = null;
			
			if(prog != null) {
				System.out.print(prog.getNome() + " (Pressione \"Enter\" para manter, ou digite um novo nome) > ");		
				nomeDoPrograma = prog.getNome();			
			}else {
				System.out.print("> ");
			}
			
			String bufferNomeDoPrograma = ler.nextLine();
			
			if(!(bufferNomeDoPrograma.equals(""))) {
				nomeDoPrograma = bufferNomeDoPrograma;
			}		
			
			Double pontuacaoPrograma = null;
			
			if(prog != null) {
				try {
					pontuacaoPrograma = prog.getPontuacao();
				} catch (Exception e) {
					
				}
			}
			
			switch(tipo) {
			case 1:
				System.out.println("\nPontuação de 1 a 5:\n");
				break;
			case 2:
				System.out.println("\nPontuação de 1 a 10:\n");
				break;
			}
			
			if(pontuacaoPrograma != null) {
				System.out.print(pontuacaoPrograma + (prog instanceof Filme ? "/5" : "/10") + " (Pressione \"Enter\" para manter, ou digite nova pontuação) > ");
			}else {
				System.out.print("> ");
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
				System.out.println("\nQuantos minutos de duração?\n");
				
				if(prog != null) {
					duracao = ((Filme) prog).getDuracao();
					System.out.print(((Filme) prog).getDuracao() + " minutos (Pressione \"Enter\" para manter, ou digite nova duração) > ");
				}else {
					System.out.print("> ");
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
				System.out.println("\nQuantas temporadas? \n");
				
				if(prog != null) {
					System.out.print(((Serie)prog).getNumeroTemporas() + " (Pressione \"Enter\" para manter, ou digite um novo valor) > ");				
				}else {
					System.out.print("> ");
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
						
						System.out.println("\nQuantos episódios na " + (i + 1) + "º temporada? \n");
						
						System.out.print("> ");
						
						qtdEps.add(ler.nextInt()); ler.nextLine();
					}
				}
				break;
			}
			
			Categoria categoriaPrograma = subfluxoEscolherCategoria((prog != null ? prog.getCategoria() : null));
			
			if(nomeDoPrograma != null && (duracao != null || qtdEps.size() > 0)) {
				if(prog != null) {
					catalogoBrasil.deletarProgramaPorNome(prog.getNome());
					System.out.println("\nPrograma editado com sucesso!");	
				}else {
					System.out.println("\nPrograma criado com sucesso!");	
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
				System.out.println("\nO programa não foi criado: dados vazios foram inseridos.");
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
			efetuado = true;
		}
		return efetuado;
	}
	public static Programa subfluxoListarPorTipo() {
		boolean escolhendoTipoAListar = true;
		Programa prog = null;
		while(escolhendoTipoAListar) {
			System.out.println("\nQual tipo de programa você deseja listar? \n\n"
					+ "1: filme \n"
					+ "2: série \n\n"
					+ "0: voltar\n");
			
			System.out.print("> ");
			
			int filmeOuSerieListar = ler.nextInt(); ler.nextLine();
			
			switch(filmeOuSerieListar) {
			case 1:
				boolean escolhendoFilmeDaLista = true;
				while(escolhendoFilmeDaLista) {
					ArrayList<Programa> listaDeFilmes = catalogoBrasil.listarProgramas(1);
					if(listaDeFilmes.size() > 0) {
						System.out.println("\nEscolha um filme da lista: \n");
						for(int i = 0; i < listaDeFilmes.size(); i++) {
							System.out.println((i + 1) + ": " + listaDeFilmes.get(i).getNome());
						}
						System.out.println("\n0: voltar\n");
						
						System.out.print("> ");
						
						int filmeEscolhidoDaLista = ler.nextInt(); ler.nextLine();
						if(filmeEscolhidoDaLista > 0 && filmeEscolhidoDaLista <= listaDeFilmes.size()) {
							escolhendoTipoAListar = false;
							escolhendoFilmeDaLista = false;
							prog =  listaDeFilmes.get(filmeEscolhidoDaLista - 1);
						}else {
							if(filmeEscolhidoDaLista == 0) {
								escolhendoFilmeDaLista = false;
							}else {
								System.out.print("> (Opção inválida!)\n");
							}
						}
					}else {
						System.out.print("\nNenhum filme encontrado. (Pressione \"Enter\" para voltar)");	
						
						ler.nextLine();
						
						escolhendoFilmeDaLista = false;
					}										
				}
				break;
			case 2:
				boolean escolhendoSerieDaLista = true;
				while(escolhendoSerieDaLista) {
					ArrayList<Programa> listaDeSeries = catalogoBrasil.listarProgramas(2);
					if(listaDeSeries.size() > 0) {
						System.out.println("\nEscolha uma série da lista: \n");
						for(int i = 0; i < listaDeSeries.size(); i++) {
							System.out.println((i + 1) + ": " + listaDeSeries.get(i).getNome());
						}
						System.out.println("\n0: voltar\n");
						System.out.print("> ");
						int serieEscolhidaDaLista = ler.nextInt(); ler.nextLine();
						if(serieEscolhidaDaLista > 0 && serieEscolhidaDaLista <= listaDeSeries.size()) {
							escolhendoTipoAListar = false;
							escolhendoSerieDaLista = false;
							prog = listaDeSeries.get(serieEscolhidaDaLista - 1);
						}else {
							if(serieEscolhidaDaLista == 0) {
								escolhendoSerieDaLista = false;
							}else {
								System.out.print("> (Opção inválida!)\n");							
							}
						}
					}else {
						System.out.print("\nNenhuma série encontrada. (Pressione \"Enter\" para voltar)");	
						
						ler.nextLine();
						
						escolhendoSerieDaLista = false;
					}
				}
				break;
			case 0:
				escolhendoTipoAListar = false;
				break;
			default:
				System.out.print("> (Opção inválida!)\n");
				break;
			}
		}
		return prog;
	}
	public static Programa subfluxoListarPorCategoria() {
		boolean escolhendoCategoriaAListar = true;
		Programa prog = null;
		while(escolhendoCategoriaAListar) {
			System.out.println("\nDe qual categoria você deseja listar? \n");
			
			for(int i = 0; i < Categoria.values().length; i++) {
				System.out.println((i + 1) + ": " + Categoria.values()[i].getNomeCategoria());
			}
			
			System.out.println("\n0: voltar\n");
			
			System.out.print("> ");
			
			int categoriaEscolhidaAListar = ler.nextInt(); ler.nextLine();
			
			if(categoriaEscolhidaAListar > 0 && categoriaEscolhidaAListar <= Categoria.values().length) {
				
				ArrayList<Programa> progsDaCategoria = catalogoBrasil.getProgramasPorCategoria(Categoria.values()[categoriaEscolhidaAListar - 1]);
				
				if(progsDaCategoria != null) {
						boolean escolhendoProgramaDaLista = true;
						while(escolhendoProgramaDaLista) {
							System.out.println("\nEscolha um programa da lista: \n");
							for(int i = 0; i < progsDaCategoria.size(); i++) {
								System.out.println((i + 1) + ": " + progsDaCategoria.get(i).getNome());
							}
							System.out.println("\n0: voltar\n");
							System.out.print("> ");
							int progEscolhidoDaLista = ler.nextInt(); ler.nextLine();
							if(progEscolhidoDaLista > 0 && progEscolhidoDaLista <= progsDaCategoria.size()) {
								escolhendoCategoriaAListar = false;
								escolhendoProgramaDaLista = false;
								prog = progsDaCategoria.get(progEscolhidoDaLista - 1);
							}else {
								if(progEscolhidoDaLista == 0) {
									escolhendoProgramaDaLista = false;
								}else {
									System.out.print("> (Opção inválida!)\n");
								}
							}
						}	
				}else {
					System.out.print("\nNenhum programa pertence a essa categoria. (Pressione \"Enter\" para voltar)");
					
					ler.nextLine();
				}
			}else {
				if(categoriaEscolhidaAListar == 0) {
					escolhendoCategoriaAListar = false;
				}else {					
					System.out.print("> (Opção inválida!)\n");
				}
			}		
		}
		return prog;
	}
	public static Programa subfluxoListarTodos() {
		Programa prog = null;
		boolean listando = true;
		while(listando) {
			ArrayList<Programa> listaDeTodos= catalogoBrasil.listarProgramas(3);
			if(listaDeTodos.size() > 0) {
				System.out.println("\nEscolha um programa:\n");
				for(int i = 0; i < listaDeTodos.size(); i++) {
					System.out.println((i + 1) + ": " + listaDeTodos.get(i).getNome());
				}
				System.out.println("\n0: voltar\n");
				System.out.print("> ");
				int programaEscolhidoDaLista = ler.nextInt(); ler.nextLine();
				if(programaEscolhidoDaLista > 0 && programaEscolhidoDaLista <= listaDeTodos.size()) {
					listando = false;
					prog = listaDeTodos.get(programaEscolhidoDaLista - 1);
				}else {
					if(programaEscolhidoDaLista == 0) {
						listando = false;
					}else {
						System.out.print("> (Opção inválida!)\n");	
					}
				}		
			}else {
				System.out.print("\nNenhuma programa encontrado. (Pressione \"Enter\" para voltar)");	
				
				ler.nextLine();
				
				listando = false;
			}
			for(int i = 0; i < listaDeTodos.size(); i++) {
				System.out.println((i + 1) + ": " + listaDeTodos.get(i).getNome());
			}
		}	
		return prog;
	}	
	public static Programa subfluxoEncontrarPorNome() {
		Programa prog = null;
		boolean escolhendo = true;
		while(escolhendo) {
			System.out.println("\nInsira o nome do programa que deseja consultar:\n");
			System.out.print("> ");
			String nomeDoPrograma = ler.nextLine();
			try {
				prog = catalogoBrasil.getProgramaPorNome(nomeDoPrograma);
				escolhendo = false;
				
			} catch (Exception e) {
				System.out.println("\n" + e.getMessage());
				System.out.print("\n(Pressione \"Enter\" para procurar de novo, ou digite \"0\" para voltar) > ");
				String tentarDeNovo = ler.nextLine();
				if(tentarDeNovo.equals("0")) {
					escolhendo = false;
				}
			}
			
		}
		return prog;
		
	}
	public static Categoria subfluxoEscolherCategoria(Categoria cat) {
		Categoria categoriaEscolhida = null;
				
		while(categoriaEscolhida == null) {
			
			System.out.println("\nCategoria: \n");
			
			for(int i = 0; i < Categoria.values().length; i++) {
				System.out.println((i + 1) + ": " + Categoria.values()[i].getNomeCategoria() + (cat != null ? (cat.equals(Categoria.values()[i]) ? " (atual)" : ""): ""));
			}
			
			System.out.println();
			
			if(cat != null) {
				categoriaEscolhida = cat;
				System.out.print("(Pressione \"Enter\" para manter, ou escolha uma nova) > ");
			}else {
				System.out.print("> ");
			}
			
			String bufferNumeroCategoria = ler.nextLine();
			
			Integer numeroCategoria = null;
			
			if(!(bufferNumeroCategoria.equals(""))) {
				try {
					numeroCategoria = Integer.valueOf(bufferNumeroCategoria);
				}catch(Exception e) {			
						
				}
			}
			
			if(numeroCategoria != null) {
				if(numeroCategoria > 0 && numeroCategoria <= Categoria.values().length) {
					categoriaEscolhida = Categoria.values()[numeroCategoria - 1];
				}else {
					categoriaEscolhida = null;
					System.out.print("> (Opção inválida!)\n");
				}
			}else {
				if(categoriaEscolhida == null) {
					System.out.println("\nVocê precisa escolher uma categoria!");
				}
			}

		}
		
		return categoriaEscolhida;
	}

}




package Serraflix;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Program {
	static Scanner ler = new Scanner(System.in);	
	static Biblioteca catalogo = new Biblioteca();
	public static void main(String[] args) {
		catalogo.addProgramas(Arrays.asList(
				new Serie("The Office", 8.9, Categoria.COMEDIA, Arrays.asList(6, 22, 25, 19, 28, 26, 26, 24, 25)),
				new Serie("Hinterland", 9.5, Categoria.TERROR, Arrays.asList(8, 10, 8)),
				new Serie("Cowboy Bebop", 8.9, Categoria.COMEDIA, Arrays.asList(26)),
				new Serie("Breaking Bad", 11., Categoria.TERROR, Arrays.asList(7, 13, 13, 13, 16)),
				new Serie("Dr. House", 8.5, Categoria.FANTASIA, Arrays.asList(22, 24, 24, 16, 24, 22, 23, 22)),
				new Serie("House Of Cards", 8.7, Categoria.DRAMA, Arrays.asList(13, 13, 13, 13, 13, 8)),
				new Serie("Lost", 8.3, Categoria.FANTASIA, Arrays.asList(25, 24, 23, 14, 17, 18)),
				new Filme("Lost In Translation", 3.8, Categoria.COMEDIA, 101),
				new Filme("F�til e In�til", 3.4, Categoria.COMEDIA, 101),
				new Filme("Eternal Sunshine Of The Spotless Mind", 4.1, Categoria.TERROR, 108),			
				new Filme("Her", 4., Categoria.COMEDIA, 126),			
				new Filme("Cowboy Bebop: The Movie", 3.9, Categoria.FANTASIA, 115),
				new Filme("Lorem Ipsum", 11., Categoria.FANTASIA, 0)
			));
		

		boolean emOperacao = true;
		
		System.out.println("Bem vindo ao Serraflix!");
		
		while(emOperacao) {	
			System.out.println();
			System.out.println("O que voc� deseja fazer? \n\n"
					+ "1: criar um programa \n"
					+ "2: editar um programa \n"
					+ "3: deletar um programa \n"
					+ "4: exibir informa��es \n\n"
					+ "0: sair \n");			
			
			System.out.print("> ");
			
			String opcaoSelecionada = ler.nextLine();	
			
			
			switch(opcaoSelecionada) {
			case "1":		
				fluxoCriacao();
				break;
			case "2":
				fluxoEdicao();
				break;
			case "3":
				fluxoRemocao();
				break;
			case "4":
				fluxoExibicao();
				break;
			case "0":
				emOperacao = false;
				break;
			default:
				System.out.print("> (Op��o inv�lida!)\n");
				break;
			}
		}
		System.out.println("\nAt� a pr�xima!");
		ler.close();
	}

	/*
	
	///////////// FIM DA MAIN ////////////////
	
	

	
	
	DICA:
	
	Na barra com o n�mero de linhas do Eclipse, minimize os m�todos dos fluxos a seguir,
	clicando na bolinha com um "-", � direita do n�mero da linha onde t� o cabe�alho da fun��o.
	Isso vai te ajudar a entender como elas foram estruturadas.
	
	Obs.: as vezes o Eclipse d� uma bugada e esconde o m�todo todo (inclusive o cabe�alho) :3
	
	EXEMPLO

	108
	109
	110
	111(-)		private static void fluxoQualquer() {
	112	|     		bla
	113	|			bla
	114	|			bla
	115	|			...
	
	
	
		
	
	*/
	
	private static void fluxoCriacao() {
		boolean criando = true;			
		while(criando) {		
			System.out.println();
			System.out.println("Qual tipo de programa voc� deseja criar? \n\n"
					+ "1: filme \n"
					+ "2: s�rie \n\n"
					+ "0: voltar ao menu principal \n");
			
			System.out.print("> ");
			
			String filmeOuSerieCriar = ler.nextLine();
			
			switch(filmeOuSerieCriar) {
			case "1":
				criando = !(fluxoEfetuarCriacaoEdicao(null, 1));
				break;
			case "2":
				criando = !(fluxoEfetuarCriacaoEdicao(null, 2));
				break;
			case "0":
				criando = false;
				break;
			default:
				System.out.print("> (Op��o inv�lida!)\n");
				break;
			}
		}
	}
	private static void fluxoEdicao(){
		boolean editando = true;
		while(editando) {
			System.out.println();
			System.out.println("Como deseja encontrar o programa a ser editado? \n\n"
					+ "1: escolher de uma listagem por tipo \n"
					+ "2: escolher de uma listagem por categoria \n"
					+ "3: escolher da lista com todos os programas \n"
					+ "4: pesquisar por nome \n\n"
					+ "0: voltar ao menu principal \n");
			
			System.out.print("> ");
			
			String opcaoEncontrar = ler.nextLine();
			
			switch(opcaoEncontrar) {
			case "1":
				editando = !(fluxoEfetuarCriacaoEdicao(subfluxoListarPorTipo(), null));
				break;
			case "2":				
				editando = !(fluxoEfetuarCriacaoEdicao(subfluxoListarPorCategoria(), null));
				break;
			case "3":				
				editando = !(fluxoEfetuarCriacaoEdicao(subfluxoListarTodos(), null));
				break;
			case "4":
				editando = !(fluxoEfetuarCriacaoEdicao(subfluxoEncontrarPorNome(), null));
				break;
			case "0":
				editando = false;
				break;
			default:
				System.out.print("> (Op��o inv�lida!)\n");
				break;
			}
		}
	}
	private static void fluxoRemocao() {
		boolean removendo = true;
		while(removendo) {
			System.out.println();
			System.out.println("Como deseja encontrar o programa a ser deletado? \n\n"
					+ "1: escolher de uma listagem por tipo \n"
					+ "2: escolher de uma listagem por categoria \n"
					+ "3: escolher da lista com todos os programas \n"
					+ "4: pesquisar por nome \n\n"
					+ "0: voltar ao menu principal \n");
			
			System.out.print("> ");
			String opcaoEncontrar = ler.nextLine();
			
			switch(opcaoEncontrar) {
			case "1":
				removendo = !(fluxoEfetuarRemocao(subfluxoListarPorTipo()));
				break;
			case "2":
				removendo = !(fluxoEfetuarRemocao(subfluxoListarPorCategoria()));
				break;
			case "3":
				removendo = !(fluxoEfetuarRemocao(subfluxoListarTodos()));
				break;
			case "4":
				removendo = !(fluxoEfetuarRemocao(subfluxoEncontrarPorNome()));
				break;
			case "0":
				removendo = false;
				break;
			default:
				System.out.print("> (Op��o inv�lida!)\n");
				break;
			}
		}
	}
	private static void fluxoExibicao() {
		boolean exibindo = true;
		while(exibindo) {
			System.out.println("\nEscolha um dos m�todos de exibi��o: \n\n"
					+ "1: listar por tipo\n"
					+ "2: listar por categoria \n"
					+ "3: listar todos os programas \n"
					+ "4: pesquisar por nome \n\n"
					+ "0: voltar ao menu principal \n");
			System.out.print("> ");
			String opcaoEscolhidaExibicao = ler.nextLine();
			switch (opcaoEscolhidaExibicao) {
			case "1":
				exibindo = !(fluxoEfetuarExibicao(subfluxoListarPorTipo()));
				break;
			case "2":
				exibindo = !(fluxoEfetuarExibicao(subfluxoListarPorCategoria()));
				break;
			case "3":
				exibindo = !(fluxoEfetuarExibicao(subfluxoListarTodos()));
				break;
			case "4":
				exibindo = !(fluxoEfetuarExibicao(subfluxoEncontrarPorNome()));
				break;
			case "0":
				exibindo = false;
				break;
			default:
				System.out.print("> (Op��o inv�lida!)\n");
				break;
			}
		}
	}
	private static boolean fluxoEfetuarCriacaoEdicao(Programa prog, Integer tipo) {	
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
				System.out.println("\nNome da s�rie:\n");
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
				System.out.println("\nPontua��o de 1 a 5:\n");
				break;
			case 2:
				System.out.println("\nPontua��o de 1 a 10:\n");
				break;
			}
			
			if(pontuacaoPrograma != null) {
				System.out.print(pontuacaoPrograma + (prog instanceof Filme ? "/5" : "/10") + " (Pressione \"Enter\" para manter, ou digite nova pontua��o) > ");
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
				System.out.println("\nQuantos minutos de dura��o?\n");
				
				if(prog != null) {
					duracao = ((Filme) prog).getDuracao();
					System.out.print(((Filme) prog).getDuracao() + " minutos (Pressione \"Enter\" para manter, ou digite nova dura��o) > ");
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
						
						boolean adicionouEps = false;
						
						while(!adicionouEps) {
							System.out.println("\nQuantos epis�dios na " + (i + 1) + "� temporada? \n");
							System.out.print("> ");
							try {
								qtdEps.add(Integer.valueOf(ler.nextLine()));
								adicionouEps = true;
								
							}catch(Exception e) {
								System.out.print("> (Valor inv�lido!)\n");	
							}
						}
							
					}
				}
				break;
			}
			
			Categoria categoriaPrograma = subfluxoEscolherCategoria((prog != null ? prog.getCategoria() : null));
			
			if(nomeDoPrograma != null && (duracao != null || qtdEps.size() > 0)) {
				switch(tipo) {
				case 1:
					Filme previewFilme = new Filme(nomeDoPrograma, pontuacaoPrograma, categoriaPrograma, duracao);
					System.out.println(previewFilme.toString());
					break;
				case 2:
					Serie previewSerie = new Serie(nomeDoPrograma, pontuacaoPrograma, categoriaPrograma, qtdEps);
					System.out.println(previewSerie.toString());
					break;
				}
				if(prog == null) {
					System.out.println("\nVoc� est� prestes a criar " + (tipo == 1 ? "um filme" : "uma s�rie") + " com as informa��es acima. Deseja prosseguir?\n");
				}else {
					System.out.println("\nVoc� est� prestes a editar " + (tipo == 1 ? "o filme" : "a s�rie") + " \"" + prog.nome + "\" com as informa��es acima. Deseja prosseguir?\n");
				}
				System.out.print("(Pressione \"Enter\" para prosseguir, ou digite \"0\" para voltar ao menu de " + (prog == null ? "cria��o" : "edi��o") + ") > ");
				
				String desejaProsseguir = ler.nextLine();
				if(!(desejaProsseguir.equals("0"))) {
					switch(tipo) {
					case 1:
						if(prog != null) {
							catalogo.addPrograma(new Filme(nomeDoPrograma, pontuacaoPrograma, categoriaPrograma, duracao, prog.id));
						}else {
							catalogo.addPrograma(new Filme(nomeDoPrograma, pontuacaoPrograma, categoriaPrograma, duracao));
						}
						break;
					case 2:
						if(prog != null) {
							catalogo.addPrograma(new Serie(nomeDoPrograma, pontuacaoPrograma, categoriaPrograma, qtdEps, prog.id));
						}else {
							catalogo.addPrograma(new Serie(nomeDoPrograma, pontuacaoPrograma, categoriaPrograma, qtdEps));
						}
						break;
					}		
					if(prog != null) {
						catalogo.deletarProgramaPorId(prog.getId());
						System.out.print("\n" + (tipo == 1 ? "Filme editado" : "S�rie editada") + " com sucesso! (Pressione \"Enter\" para voltar ao menu principal)");
						ler.nextLine();
					}else {
						System.out.print("\n" + (tipo == 1 ? "Filme criado" : "S�rie criada") + " com sucesso! (Pressione \"Enter\" para voltar ao menu principal)");
						ler.nextLine();
					}
					efetuado = true;
				}
			}else {
				System.out.print("\nImposs�vel criar o programa: dados vazios foram inseridos. (Pressione \"Enter\" para voltar ao menu de cria��o) ");
				ler.nextLine();
			}
		}
		return efetuado;
	}
	private static boolean fluxoEfetuarRemocao(Programa prog){
		boolean efetuado = false;
		if(prog != null) {
			System.out.println("\nVoc� est� prestes a deletar " + (prog instanceof Filme ? "o filme" : "a s�rie") + " \"" + prog.nome + "\". Deseja prosseguir?");
			System.out.print("\n(Pressione \"Enter\" para deletar o programa selecionado, ou digite \"0\" para voltar) > ");
			String confirmaDeletar = ler.nextLine();
			if(confirmaDeletar.equals("0")) {
				efetuado = false;
			}else {
				for (Programa p : catalogo.listarProgramas(3)) {
					if (p.equals(prog)) {
						catalogo.deletarProgramaPorId(prog.getId());
						System.out.print("\nPrograma deletado com sucesso. (Pressione \"Enter\" para voltar ao menu principal)");
						ler.nextLine();
						efetuado = true;
						break;
					}
				}
			}
		} 		
		return efetuado;
	}
	private static boolean fluxoEfetuarExibicao(Programa prog){
		boolean efetuado = false;
		if(prog != null) {
			System.out.println(prog.toString());
			System.out.print("\n(Pressione \"Enter\" para voltar ao menu principal)");
			ler.nextLine();
			efetuado = true;
		}
		return efetuado;
	}
	private static Programa subfluxoListarPorTipo() {
		boolean escolhendoTipoAListar = true;
		Programa prog = null;
		while(escolhendoTipoAListar) {
			System.out.println("\nQual tipo de programa voc� deseja listar?\n\n"
					+ "1: filme \n"
					+ "2: s�rie \n\n"
					+ "0: voltar\n");
			
			System.out.print("> ");
			
			String filmeOuSerieListar = ler.nextLine();
			
			switch(filmeOuSerieListar) {
			case "1":
				boolean escolhendoFilmeDaLista = true;
				while(escolhendoFilmeDaLista) {
					ArrayList<Programa> listaDeFilmes = catalogo.listarProgramas(1);
					if(listaDeFilmes.size() > 0) {
						System.out.println("\nEscolha um filme da lista: \n");
						for(int i = 0; i < listaDeFilmes.size(); i++) {
							System.out.println((i + 1) + ": " + listaDeFilmes.get(i).getNome());
						}
						System.out.println("\n0: voltar\n");
						
						System.out.print("> ");
						
						int filmeEscolhidoDaLista = -1;				
						
						String bufferFilmeEscolhidoDaLista = ler.nextLine();
						try {
							filmeEscolhidoDaLista = Integer.valueOf(bufferFilmeEscolhidoDaLista);
						}
						catch(Exception e) {
							
						}
						
						if(filmeEscolhidoDaLista > 0 && filmeEscolhidoDaLista <= listaDeFilmes.size()) {
							escolhendoTipoAListar = false;
							escolhendoFilmeDaLista = false;
							prog =  listaDeFilmes.get(filmeEscolhidoDaLista - 1);
						}else {
							if(filmeEscolhidoDaLista == 0) {
								escolhendoFilmeDaLista = false;
							}else {
								System.out.print("> (Op��o inv�lida!)\n");
							}
						}
					}else {
						System.out.print("\nNenhum filme encontrado. (Pressione \"Enter\" para voltar)");	
						
						ler.nextLine();
						
						escolhendoFilmeDaLista = false;
					}										
				}
				break;
			case "2":
				boolean escolhendoSerieDaLista = true;
				while(escolhendoSerieDaLista) {
					ArrayList<Programa> listaDeSeries = catalogo.listarProgramas(2);
					if(listaDeSeries.size() > 0) {
						System.out.println("\nEscolha uma s�rie da lista: \n");
						for(int i = 0; i < listaDeSeries.size(); i++) {
							System.out.println((i + 1) + ": " + listaDeSeries.get(i).getNome());
						}
						System.out.println("\n0: voltar\n");
						System.out.print("> ");
						
						int serieEscolhidaDaLista = -1;						
						
						String bufferSerieEscolhidaDaLista = ler.nextLine();
						try {
							serieEscolhidaDaLista = Integer.valueOf(bufferSerieEscolhidaDaLista);
						}
						catch(Exception e) {
							
						}		
						
						if(serieEscolhidaDaLista > 0 && serieEscolhidaDaLista <= listaDeSeries.size()) {
							escolhendoTipoAListar = false;
							escolhendoSerieDaLista = false;
							prog = listaDeSeries.get(serieEscolhidaDaLista - 1);
						}else {
							if(serieEscolhidaDaLista == 0) {
								escolhendoSerieDaLista = false;
							}else {
								System.out.print("> (Op��o inv�lida!)\n");							
							}
						}
					}else {
						System.out.print("\nNenhuma s�rie encontrada. (Pressione \"Enter\" para voltar)");	
						
						ler.nextLine();
						
						escolhendoSerieDaLista = false;
					}
				}
				break;
			case "0":
				escolhendoTipoAListar = false;
				break;
			default:
				System.out.print("> (Op��o inv�lida!)\n");
				break;
			}
		}
		return prog;
	}
	private static Programa subfluxoListarPorCategoria() {
		boolean escolhendoCategoriaAListar = true;
		Programa prog = null;
		while(escolhendoCategoriaAListar) {
			System.out.println("\nDe qual categoria voc� deseja listar? \n");
			
			for(int i = 0; i < Categoria.values().length; i++) {
				System.out.println((i + 1) + ": " + Categoria.values()[i].getNomeCategoria());
			}
			
			System.out.println("\n0: voltar\n");
			
			System.out.print("> ");
			
			int categoriaEscolhidaAListar = -1;
			
			String bufferCategoriaEscolhidaAListar = ler.nextLine();
			
			try {
				categoriaEscolhidaAListar = Integer.valueOf(bufferCategoriaEscolhidaAListar);
			}
			catch(Exception e) {
				
			}
			
			if(categoriaEscolhidaAListar > 0 && categoriaEscolhidaAListar <= Categoria.values().length) {
				
				ArrayList<Programa> progsDaCategoria = catalogo.getProgramasPorCategoria(Categoria.values()[categoriaEscolhidaAListar - 1]);
				
				if(progsDaCategoria != null) {
						boolean escolhendoProgramaDaLista = true;
						while(escolhendoProgramaDaLista) {
							System.out.println("\nEscolha um programa da lista: \n");
							for(int i = 0; i < progsDaCategoria.size(); i++) {
								System.out.println((i + 1) + ": " + progsDaCategoria.get(i).getNome());
							}
							System.out.println("\n0: voltar\n");
							System.out.print("> ");
							int progEscolhidoDaLista = -1;
							String bufferProgEscolhidoDaLista = ler.nextLine();
							try {
								progEscolhidoDaLista = Integer.valueOf(bufferProgEscolhidoDaLista);
							}
							catch(Exception e) {
								
							}
							if(progEscolhidoDaLista > 0 && progEscolhidoDaLista <= progsDaCategoria.size()) {
								escolhendoCategoriaAListar = false;
								escolhendoProgramaDaLista = false;
								prog = progsDaCategoria.get(progEscolhidoDaLista - 1);
							}else {
								if(progEscolhidoDaLista == 0) {
									escolhendoProgramaDaLista = false;
								}else {
									System.out.print("> (Op��o inv�lida!)\n");
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
					System.out.print("> (Op��o inv�lida!)\n");
				}
			}		
		}
		return prog;
	}
	private static Programa subfluxoListarTodos() {
		Programa prog = null;
		boolean listando = true;
		while(listando) {
			ArrayList<Programa> listaDeTodos= catalogo.listarProgramas(3);
			if(listaDeTodos.size() > 0) {
				System.out.println("\nEscolha um programa:\n");
				for(int i = 0; i < listaDeTodos.size(); i++) {
					System.out.println((i + 1) + ": " + listaDeTodos.get(i).getNome());
				}
				System.out.println("\n0: voltar\n");
				System.out.print("> ");
				
				
				int programaEscolhidoDaLista = -1;
				String bufferProgramaEscolhidoDaLista = ler.nextLine();
				try {
					programaEscolhidoDaLista = Integer.valueOf(bufferProgramaEscolhidoDaLista);
				}
				catch(Exception e) {
					
				}
				
				if(programaEscolhidoDaLista > 0 && programaEscolhidoDaLista <= listaDeTodos.size()) {
					listando = false;
					prog = listaDeTodos.get(programaEscolhidoDaLista - 1);
				}else {
					if(programaEscolhidoDaLista == 0) {
						listando = false;
					}else {
						System.out.print("> (Op��o inv�lida!)\n");	
					}
				}		
			}else {
				System.out.print("\nNenhuma programa encontrado. (Pressione \"Enter\" para voltar)");	
				
				ler.nextLine();
				
				listando = false;
			}
		}	
		return prog;
	}	
	private static Programa subfluxoEncontrarPorNome() {
		Programa prog = null;
		ArrayList<Programa> progs = null;
		boolean procurando = true;
		while(procurando) {
			System.out.println("\nInsira o nome do programa que deseja consultar:\n");
			System.out.print("(Digite sua pesquisa, ou pressione \"Enter\" para voltar) > ");
			String nomeDoPrograma = ler.nextLine();
			progs = catalogo.getProgramaPorNome(nomeDoPrograma);
			if(progs != null && !(nomeDoPrograma.equals(""))) {
				boolean escolhendo = true;
				while(escolhendo) {
					System.out.println("\nExibindo " + progs.size() + " resultado(s) na pesquisa por \"" + nomeDoPrograma + "\":\n");
					for(int i = 0; i < progs.size(); i++) {
						System.out.println((i + 1) + ": " + progs.get(i).getNome());
					}
					System.out.println("\n0: voltar\n");
					System.out.print("> ");
					
					int resultadoSelecionado = -1;
					String bufferResultadoSelecionado = ler.nextLine();
					try {
						resultadoSelecionado = Integer.valueOf(bufferResultadoSelecionado);
					}
					catch(Exception e) {
						
					}
					
					if(resultadoSelecionado > 0 && resultadoSelecionado <= progs.size()) {
						prog = progs.get(resultadoSelecionado - 1);
						escolhendo = false;
						procurando = false;
					}else {
						if(resultadoSelecionado == 0) {
							escolhendo = false;
						}else {
							System.out.print("> (Op��o inv�lida!)\n");
						}
					}
				}
			}else {
				if(nomeDoPrograma.equals("")) {
					procurando = false;
				}else {
					System.out.println("\nNenhum programa encontrado.");
					System.out.print("\n(Pressione \"Enter\" para procurar de novo, ou digite \"0\" para voltar) > ");
					String tentarDeNovo = ler.nextLine();
					if(tentarDeNovo.equals("0")) {
						procurando = false;
					}
				}
			}		
		}
		return prog;	
	}
	private static Categoria subfluxoEscolherCategoria(Categoria cat) {
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
					System.out.print("> (Op��o inv�lida!)\n");
				}
			}else {
				if(categoriaEscolhida == null) {
					System.out.println("\nVoc� precisa escolher uma categoria!");
				}
			}

		}
		
		return categoriaEscolhida;
	}

}




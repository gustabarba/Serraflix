package Serraflix;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Program {
	static Scanner ler = new Scanner(System.in);	
	static Biblioteca catalogo = new Biblioteca();
	public static void main(String[] args) {
		catalogo.addProgramas(Arrays.asList(
				new Serie("The Office", 8.9, Categoria.COMEDIA, Arrays.asList(6, 22, 25, 19, 28, 26, 26, 24, 25)),
				new Serie("Hinterland", 9.5, Categoria.SUSPENSE, Arrays.asList(8, 10, 8)),
				new Serie("Cowboy Bebop", 8.9, Categoria.CYBERPUNK, Arrays.asList(26)),
				new Serie("Breaking Bad", 10., Categoria.SUSPENSE, Arrays.asList(7, 13, 13, 13, 16)),
				new Serie("Dr. House", 8.5, Categoria.DRAMA, Arrays.asList(22, 24, 24, 16, 24, 22, 23, 22)),
				new Serie("House Of Cards", 8.7, Categoria.DRAMA, Arrays.asList(13, 13, 13, 13, 13, 8)),
				new Serie("Lost", 8.3, Categoria.FANTASIA, Arrays.asList(25, 24, 23, 14, 17, 18)),
				new Filme("Lost In Translation", 3.8, Categoria.ROMANCE, 101),
				new Filme("Fútil e Inútil", 3.4, Categoria.COMEDIA, 101),
				new Filme("Eternal Sunshine Of The Spotless Mind", 4.1, Categoria.ROMANCE, 108),			
				new Filme("Her", 4., Categoria.ROMANCE, 126),			
				new Filme("Cowboy Bebop: The Movie", 3.9, Categoria.CYBERPUNK, 115),
				new Filme("Lorem Ipsum", 3., Categoria.FANTASIA, 0)
			));
		

		boolean emOperacao = true;
		
		System.out.println();
		System.out.println("|      SEJA BEM-VINDO(A) AO     |");
		System.out.println("|   *** S E R R A F L I X ***   |");
		System.out.println("|_______________________________|\n\n");
		
		while(emOperacao) {	
			System.out.println();
			System.out.println("|=========================|");
			System.out.println("|O QUE VOCÊ DESEJA FAZER? |");
			System.out.println("|=========================|\n\n");
			System.out.println("__________________________");
			System.out.println("1 ---> CRIAR UM PROGRAMA  |\n"
					+ "2 ---> EDITAR UM PROGRAMA |\n"
					+ "3 ---> DELETAR UM PROGRAMA| \n"
					+ "4 ---> EXIBIR INFORMAÇÕES | \n"
					+ "0 ---> SAIR               |");
			System.out.println("__________________________|\n");
			
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
				System.out.print("*** OPÇÃO INVÁLIDA :( ***\n");
				break;
			}
		}
		System.out.println("\nATÉ A PRÓXIMA 0/ ");
		ler.close();
	}

	/*
	
	///////////// FIM DA MAIN ////////////////
	
	

	
	
	DICA:
	
	Na barra com o número de linhas do Eclipse (ou da sua IDE escolhida), minimize os métodos dos fluxos a seguir,
	clicando na bolinha com um "-", à direita do número da linha onde tá o cabeçalho da função.
	Isso vai te ajudar a entender como elas foram estruturadas.
	
	Obs.: as vezes o Eclipse dá uma bugada e esconde o método todo (inclusive o cabeçalho) :3
	
	EXEMPLO

	108
	109
	110
	111(-)    private static void fluxoQualquer() {
	112 |         bla
	113 |         bla
	114 |         bla
	115 |         ...
	
	
	
		
	
	*/
	
	private static void fluxoCriacao() {
		boolean criando = true;			
		while(criando) {		
					System.out.println();
					System.out.println("| QUAL TIPO DE PROGRAMA VOCÊ DESEJA CRIAR? |");
					System.out.println("|__________________________________________|\n\n)");
					System.out.println("_______________________________");
					System.out.println(
					  "1 ---> FILME                   |\n"
					+ "2 ---> SÉRIE                   |\n"
					+ "0 ---> VOLTAR AO MENU PRINCIPAL|");
					System.out.println("_______________________________|\n");
			
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
				System.out.print("*** OPÇÃO INVÁLIDA :( ***\n");
				break;
			}
		}
	}
	private static void fluxoEdicao(){
		boolean editando = true;
		while(editando) {
			System.out.println("________________________________________________ ");
			System.out.println("|COMO DESEJA ECONTRAR O PROGRAMA A SER EDITADO? |");
			System.out.println("|_______________________________________________|\n\n");
			System.out.println("__________________________________________");
			System.out.println(
					  "1 ---> DE UMA LISTAGEM POR TIPO           |\n"
					+ "2 ---> DE UMA LISTAGEM POR CATEGORIA      |\n"
					+ "3 ---> DE UMA LISTA COM TODOS OS PROGRAMAS| \n"
					+ "4 ---> PELO NOME DO PROGRAMA              | \n"
					+ "0 ---> VOLTAR AO MENU PRINCIPAL           |");
			System.out.println("__________________________________________|\n");
			
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
				System.out.print("*** OPÇÃO INVÁLIDA :( ***\n");
				break;
			}
		}
	}
	private static void fluxoRemocao() {
		boolean removendo = true;
		while(removendo) {
			System.out.println("_________________________________________________ ");
			System.out.println("|COMO DESEJA ECONTRAR O PROGRAMA A SER DELETADO? |");
			System.out.println("|________________________________________________|\n\n");
			System.out.println("__________________________________________");
			System.out.println(
					  "1 ---> DE UMA LISTAGEM POR TIPO           |\n"
					+ "2 ---> DE UMA LISTAGEM POR CATEGORIA      |\n"
					+ "3 ---> DE UMA LISTA COM TODOS OS PROGRAMAS| \n"
					+ "4 ---> PELO NOME DO PROGRAMA              | \n"
					+ "0 ---> VOLTAR AO MENU PRINCIPAL           |");
			System.out.println("__________________________________________|\n");
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
				System.out.print("*** OPÇÃO INVÁLIDA :( ***\n");
				break;
			}
		}
	}
	private static void fluxoExibicao() {
		boolean exibindo = true;
		while(exibindo) {
			System.out.println("_____________________________________ ");
			System.out.println("|ESCOLHA UM DOS MÉTODOS DE EXIBIÇÃO  |");
			System.out.println("|____________________________________|\n\n");
			System.out.println(
					  "_____________________________________");
			System.out.println(
					  "1 ---> LISTAR POR TIPO               |\n"
					+ "2 ---> LISTAR POR CATEGORIA          |\n"
					+ "3 ---> LISTAR TODOS OS PROGRAMAS     | \n"
					+ "4 ---> ENCONTRAR POR NOME            | \n"
					+ "0 ---> VOLTAR AO MENU PRINCIPAL      |");
			System.out.println(
					  "_____________________________________|\n");
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
				System.out.print("*** OPÇÃO INVÁLIDA :( ***\n");
				break;
			}
		}
	}
	private static boolean fluxoEfetuarCriacaoEdicao(Programa prog, Integer tipo) {	
		boolean efetuado = true;
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
				System.out.println("\n* NOME DO FILME:\n");
				break;
			case 2:
				System.out.println("\n* NOME DA SÉRIE:\n");
				break;
			}
			
			String nomeDoPrograma = null;
			
			if(prog != null && prog.nome != null) {
				System.out.print(prog.getNome() + " (PRESSIONE \"E N T E R\" PARA MANTER, OU DIGITE UM NOVO NOME) > ");		
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
				System.out.println("\n* PONTUAÇÃO DE 1 A 5:\n");
				break;
			case 2:
				System.out.println("\n* PONTUAÇÃO DE 1 A 10:\n");
				break;
			}
			
			if(pontuacaoPrograma != null) {
				System.out.print(pontuacaoPrograma + (prog instanceof Filme ? "/5" : "/10") + " (PRESSIONE \"E N T E R\" PARA MANTER, OU DIGITE UMA NOVA PONTUAÇÃO) > ");
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
				System.out.println("\n* QUANTOS MINUTOS DE DURAÇÃO?\n");
				
				if(prog != null && ((Filme)prog).getDuracao() != null) {
					duracao = ((Filme) prog).getDuracao();
					System.out.print(((Filme) prog).getDuracao() + " MINUTOS (PRESSIONE \"E N T E R\" PARA MANTER, OU DIGITE UMA NOVA DURAÇÃO) > ");
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
				System.out.println("\n* QUANTAS TEMPORADAS? \n");
				
				if(prog != null && ((Serie)prog).getNumeroTemporas() > 0) {
					System.out.print(((Serie)prog).getNumeroTemporas() + " (PRESSIONE \"E N T E R\" PARA MANTER, OU DIGITE UM NOVO Nº DE TEMPORADAS) > ");				
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
							System.out.println("\n* QUANTOS EPISÓDIOS NA " + (i + 1) + "º TEMPORADA? \n");
							System.out.print("> ");
							try {
								qtdEps.add(Integer.valueOf(ler.nextLine()));
								adicionouEps = true;
								
							}catch(Exception e) {
								System.out.print("*** VALOR INVÁLIDO :( ***\n");	
							}
						}
							
					}
				}
				break;
			}
			
			Categoria categoriaPrograma = subfluxoEscolherCategoria((prog != null ? (prog.getCategoria()) : (null)), false);
			
			if(nomeDoPrograma != null && (duracao != null || qtdEps.size() > 0)) {
				Programa preview = null;
				
				switch(tipo) {
				case 1:
					preview = new Filme(nomeDoPrograma, pontuacaoPrograma, categoriaPrograma, duracao);
					break;
				case 2:
					preview = new Serie(nomeDoPrograma, pontuacaoPrograma, categoriaPrograma, qtdEps);
					break;
				}
				
				boolean prossegue = false;
				
				String veredito = "";
				
				while(!prossegue) {
					System.out.println(preview.toString());
					if(prog != null && catalogo.encontrarIndicePorId(prog.getId()) != -1) {
						System.out.println("\n* VOCÊ ESTÁ PRESTES A EDITAR " + (tipo == 1 ? "O FILME" : "A SÉRIE") + " \"" + prog.nome + "\" COM AS INFORMAÇÕES ACIMA, DESEJA PROSSEGUIR?\n");
					}else {
						System.out.println("\n* VOCÊ ESTÁ PRESTES A CRIAR " + (tipo == 1 ? "UM FILME" : "UMA SÉRIE") + " COM AS INFORMAÇÕES ACIMA, DESEJA PROSSEGUIR?");
					}
					
					System.out.print("\n(PRESSIONE \"E N T E R\" PARA PROSSEGUIR, DIGITE \"V\" PARA VOLTAR AO MENU DE " + (prog != null && catalogo.encontrarIndicePorId(prog.getId()) != -1? "EDIÇÃO" : "CRIAÇÃO") + ", OU \"0\" PARA VOLTAR AO MENU PRINCIPAL) > ");
					
					veredito = ler.nextLine();
					
					if(!veredito.equals("") && !veredito.toLowerCase().equals("v") && !veredito.equals("0")) {
						System.out.print("*** OPÇÃO INVÁLIDA :( ***\n");
					}else {
						prossegue = true;
					}
					
				}	
				
				if(veredito.equals("")) {
					switch(tipo) {
					case 1:
						if(prog != null && catalogo.encontrarIndicePorId(prog.getId()) != -1) {
							catalogo.addPrograma(new Filme(nomeDoPrograma, pontuacaoPrograma, categoriaPrograma, duracao, prog.id));
						}else {
							catalogo.addPrograma(new Filme(nomeDoPrograma, pontuacaoPrograma, categoriaPrograma, duracao));
						}
						break;
					case 2:
						if(prog != null && catalogo.encontrarIndicePorId(prog.getId()) != -1 ) {
							catalogo.addPrograma(new Serie(nomeDoPrograma, pontuacaoPrograma, categoriaPrograma, qtdEps, prog.id));
						}else {
							catalogo.addPrograma(new Serie(nomeDoPrograma, pontuacaoPrograma, categoriaPrograma, qtdEps));
						}
						break;
					}		
					if(prog != null && catalogo.encontrarIndicePorId(prog.getId()) != -1 ) {
						catalogo.deletarProgramaPorIndice(catalogo.encontrarIndicePorId(prog.getId()));
						System.out.print("\n" + (tipo == 1 ? "* FILME EDITADO" : "SÉRIE EDITADA") + " COM SUCESSO! :) (PRESSIONE \"E N T E R\" PARA VOLTAR AO MENU PRINCIPAL)");
						ler.nextLine();
					}else {
						System.out.print("\n" + (tipo == 1 ? "* FILME CRIADO" : "SÉRIE CRIADA") + " COM SUCESSO! :) (PRESSIONE \"E N T E R\" PARA VOLTAR AO MENU PRINCIPAL)");
						ler.nextLine();
					}
				}else {
					if(veredito.toLowerCase().equals("v")) {
						fluxoEfetuarCriacaoEdicao(preview, null);
					}
				}
			}else {
				System.out.println("rebote");
				Programa rebote = null;
				switch(tipo) {
				case 1:
					rebote = new Filme(nomeDoPrograma, pontuacaoPrograma, categoriaPrograma, duracao);
					break;
				case 2:
					rebote = new Serie(nomeDoPrograma, pontuacaoPrograma, categoriaPrograma, qtdEps);
					break;
				}
				System.out.println("\n*** IMPOSSÍVEL CRIAR O PROGRAMA: UM OU MAIS DADOS ESSENCIAIS FICARAM FALTANDO ***\n");
				System.out.print("(PRESSIONE \"E N T E R\" PARA VOLTAR AO MENU DE CRIAÇÃO, OU DIGITE \"0\" PARA VOLTAR AO MENU PRINCIPAL) > ");
				String tentarDeNovo = ler.nextLine();
				if(!(tentarDeNovo.equals("0"))) {
					fluxoEfetuarCriacaoEdicao(rebote, null);
				}
			}
		}
		return efetuado;
	}
	private static boolean fluxoEfetuarRemocao(Programa prog){
		boolean efetuado = false;
		if(prog != null) {
			System.out.println("\n* VOCÊ ESTÁ PRESTES A DELETAR " + (prog instanceof Filme ? "O FILME" : "A SÉRIE") + " \"" + prog.nome + "\". DESEJA PROSSEGUIR?");
			System.out.print("\n(PRESSIONE \"E N T E R \" PARA DELETAR O PROGRAMA SELECIONADO, OU DIGITE \"0\" PARA VOLTAR) > ");
			String confirmaDeletar = ler.nextLine();
			if(confirmaDeletar.equals("0")) {
				efetuado = false;
			}else {
				for (Programa p : catalogo.listarProgramas(3, null, null)) {
					if (p.equals(prog)) {
						catalogo.deletarProgramaPorIndice(catalogo.encontrarIndicePorId(prog.getId()));
						System.out.print("\n* PROGRAMA DELETADO COM SUCESSO :). (PRESSIONE \"E N T E R\" PARA VOLTAR AO MENU PRINCIPAL)");
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
			System.out.print("\n(PRESSIONE \"E N T E R\" PARA VOLTAR AO MENU PRINCIPAL)");
			ler.nextLine();
			efetuado = true;
		}
		return efetuado;
	}
	private static Programa subfluxoListarPorTipo() {
		boolean escolhendoTipoAListar = true;
		Programa prog = null;
		while(escolhendoTipoAListar) {
			System.out.println(" ____________________________________________");
			System.out.println("| QUAL TIPO DE PROGRAMA VOCÊ DESEJA LISTAR?  |");
			System.out.println("|____________________________________________|\n\n)");
			System.out.println("_______________________________");
			System.out.println(
			  "1 ---> FILME                   |\n"
			+ "2 ---> SÉRIE                   |\n"
			+ "0 ---> VOLTAR AO MENU PRINCIPAL|");
			System.out.println("_______________________________|\n");
			
			System.out.print("> ");
			
			String filmeOuSerieListar = ler.nextLine();
			
			switch(filmeOuSerieListar) {
			case "1":
				boolean escolhendoFilmeDaLista = true;
				while(escolhendoFilmeDaLista) {
					ArrayList<Programa> listaDeFilmes = catalogo.listarProgramas(1, null, null);
					if(listaDeFilmes.size() > 0) {
						System.out.println("\n* ESCOLHA UM FILME DA LISTA: \n");
						for(int i = 0; i < listaDeFilmes.size(); i++) {
							System.out.println((i + 1) + ": " + listaDeFilmes.get(i).getNome());
						}
						System.out.println("\n0: VOLTAR\n");
						
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
								System.out.print("*** OPÇÃO INVÁLIDA :( ***\n");
							}
						}
					}else {
						System.out.print("\n*** NENHUM FILME ENCONTRADO (PRESSIONE \"E N T E R \" PARA VOLTAR) ***");	
						
						ler.nextLine();
						
						escolhendoFilmeDaLista = false;
					}										
				}
				break;
			case "2":
				boolean escolhendoSerieDaLista = true;
				while(escolhendoSerieDaLista) {
					ArrayList<Programa> listaDeSeries = catalogo.listarProgramas(2, null, null);
					if(listaDeSeries.size() > 0) {
						System.out.println("\n* ESCOLHA UM SÉRIE DA LISTA \n");
						for(int i = 0; i < listaDeSeries.size(); i++) {
							System.out.println((i + 1) + ": " + listaDeSeries.get(i).getNome());
						}
						System.out.println("\n0: VOLTAR\n");
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
								System.out.print("*** OPÇÃO INVÁLIDA :( ***\n");							
							}
						}
					}else {
						System.out.print("\n*** NENHUMA SÉRIE ENCONTRADA. (PRESSIONE \"E N T E R\" PARA VOLTAR) ***");	
						
						ler.nextLine();
						
						escolhendoSerieDaLista = false;
					}
				}
				break;
			case "0":
				escolhendoTipoAListar = false;
				break;
			default:
				System.out.print("*** OPÇÃO INVÁLIDA :( ***\n");
				break;
			}
		}
		return prog;
	}
	private static Programa subfluxoListarPorCategoria() {
		boolean escolhendoCategoriaAListar = true;
		Programa prog = null;
		while(escolhendoCategoriaAListar) {
			
			Categoria categoriaEscolhida = subfluxoEscolherCategoria(null, true);
			
			if(categoriaEscolhida != null) {
				
				ArrayList<Programa> progsDaCategoria = catalogo.listarProgramas(4, categoriaEscolhida, null);
				
				if(progsDaCategoria.size() > 0) {
						boolean escolhendoProgramaDaLista = true;
						while(escolhendoProgramaDaLista) {
							System.out.println("\n* ESCOLHA UM PROGRAMA DA LISTA: \n");
							for(int i = 0; i < progsDaCategoria.size(); i++) {
								System.out.println((i + 1) + ": " + progsDaCategoria.get(i).getNome());
							}
							System.out.println("\n0: VOLTAR\n");
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
									System.out.print("*** OPÇÃO INVÁLIDA :( ***\n");
								}
							}
						}	
				}else {
					System.out.print("\n*** NENHUM PROGRAMA PERTENCE A ESSA CATEGORIA. (PRESSIONE \"E N T E R\" PARA VOLTAR) ***");
					
					ler.nextLine();
				}
			}else {			
				escolhendoCategoriaAListar = false;
			}		
		}
		return prog;
	}
	private static Programa subfluxoListarTodos() {
		Programa prog = null;
		boolean listando = true;
		while(listando) {
			ArrayList<Programa> listaDeTodos= catalogo.listarProgramas(3, null, null);
			if(listaDeTodos.size() > 0) {
				System.out.println("\n* ESCOLHA UM PROGRAMA:\n");
				for(int i = 0; i < listaDeTodos.size(); i++) {
					System.out.println((i + 1) + ": " + listaDeTodos.get(i).getNome());
				}
				System.out.println("\n0: VOLTAR\n");
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
						System.out.print("*** OPÇÃO INVÁLIDA :( ***\n");	
					}
				}		
			}else {
				System.out.print("\n*** NENHUM PROGRAMA ENCONTRADO. (PRESSIONE \"E N T E R\" PARA VOLTAR) ***");	
				
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
			System.out.println("\n* INSIRA O NOME DO PROGRAMA QUE DESEJA CONSULTAR:\n");
			System.out.print("(DIGITE SUA PESQUISA, OU PRESSIONE \"E N T E R\" PARA VOLTAR) > ");
			String nomeDoPrograma = ler.nextLine();
			progs = catalogo.listarProgramas(5, null, nomeDoPrograma);
			if(progs.size() > 0 && !(nomeDoPrograma.equals(""))) {
				boolean escolhendo = true;
				while(escolhendo) {
					System.out.println("\n* EXIBINDO " + progs.size() + " RESULTADO(S) NA PESQUISA POR \"" + nomeDoPrograma + "\":\n");
					for(int i = 0; i < progs.size(); i++) {
						System.out.println((i + 1) + ": " + progs.get(i).getNome());
					}
					System.out.println("\n0: VOLTAR\n");
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
							System.out.print(" *** OPÇÃO INVÁLIDA :( ***\n");
						}
					}
				}
			}else {
				if(nomeDoPrograma.equals("")) {
					procurando = false;
				}else {
					System.out.println("\n*** NENHUM PROGRAMA ENCONTARDO :( ***");
					System.out.print("\n(* PRESSIONE \"E N T E R\" PARA PROCURAR DE NOVO, OU DIGITE \"0\" PARA VOLTAR) > ");
					String tentarDeNovo = ler.nextLine();
					if(tentarDeNovo.equals("0")) {
						procurando = false;
					}
				}
			}		
		}
		return prog;	
	}
	private static Categoria subfluxoEscolherCategoria(Categoria cat, boolean deixaSairSemRetornarCategoria) {
		Categoria categoriaEscolhida = null;
				
		boolean escolhendoCategoria = true;
		while(escolhendoCategoria) {
			
			System.out.println("\nESCOLHA UMA CATEGORIA: \n");
			
			for(int i = 0; i < Categoria.values().length; i++) {
				System.out.println((i + 1) + ": " + Categoria.values()[i].getNomeCategoria() + (cat != null ? (cat.equals(Categoria.values()[i]) ? " (ATUAL)" : ""): ""));
			}
			
			if(deixaSairSemRetornarCategoria) {
				System.out.println("\n0: VOLTAR");
			}
			
			
			if(cat != null) {
				categoriaEscolhida = cat;
				System.out.print("(*\nPRESSIONE \"E N T E R\" PARA MANTER, OU ESCOLHA UMA NOVA) > ");
			}else {
				System.out.print("\n> ");
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
					escolhendoCategoria = false;
				}else {
					if(numeroCategoria == 0) {
						escolhendoCategoria = false;
					}else {
						System.out.print("> (*** OPÇÃO INVÁLIDA :( ***)\n");
					}
				}
			}else {
				if(categoriaEscolhida == null && !deixaSairSemRetornarCategoria) {
					System.out.println("\n*** É NECESSÁRIO QUE ESCOLHA UMA CATEGORIA! ***");
				}else {
					escolhendoCategoria = false;
				}
			}

		}
		
		return categoriaEscolhida;
	}

}




package Serraflix;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Biblioteca catalogoBrasil = new Biblioteca();
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
		
		System.out.println("Bem vindo ao Serraflix! (digite sempre o n�mero da op��o desejada)");
		
		while(emOperacao) {
			Scanner ler = new Scanner(System.in);		
			System.out.println();
			System.out.println("O que voc� deseja fazer? \n\n"
					+ "1: criar um programa \n"
					+ "2: editar um programa \n"
					+ "3: remover um programa \n"
					+ "4: exibir dados de um programa \n"
					+ "5: listar v�rios programas \n\n"
					+ "0: sair \n");			
			int opcaoSelecionada = ler.nextInt(); ler.nextLine();	
			
			
			switch(opcaoSelecionada) {
			case 1:				
				///criar um programa				
				boolean criando = true;			
				while(criando) {		
					System.out.println();
					System.out.println("Qual tipo de programa voc� deseja criar? \n\n"
							+ "1: filme \n"
							+ "2: s�rie \n\n"
							+ "0: voltar ao menu anterior \n");
					int filmeOuSerieCriar = ler.nextInt(); ler.nextLine();
					
					switch(filmeOuSerieCriar) {
					case 1:
						/// criar um filme
						catalogoBrasil.fluxoCadastrarFilme(null);
						criando = false;				
						/// fim de criar um filme
						break;
					case 2:
						/// criar uma s�rie
						catalogoBrasil.fluxoCadastrarSerie(null);
						criando = false;
						/// fim de criar uma s�rie
						break;
					case 0:
						//voltar
						criando = false;
						//fim de voltar
						break;
					default:
						System.out.println();
						System.out.println("Op��o inv�lida!");
						break;
					}
				}
				/// fim de criar programa
				break;
			case 2:
				/// editar um programa
				boolean editando = true;
				while(editando) {
					System.out.println();
					System.out.println("Qual tipo de programa voc� deseja editar? \n\n"
							+ "1: filme \n"
							+ "2: s�rie \n\n"
							+ "0: voltar ao menu anterior \n");
					int filmeOuSerieEditar = ler.nextInt(); ler.nextLine();
					
					
					switch(filmeOuSerieEditar) {
					case 1:
						/// editar um filme
						boolean escolhendo = true;
						while(escolhendo) {
							System.out.println("\nQual filme voc� deseja editar?\n");
							ArrayList<Programa> filmes = catalogoBrasil.listarProgramas(1);
							for(int i = 0; i < filmes.size(); i++) {
								System.out.println((i + 1) + ": " + filmes.get(i).getNome());
							}						
							System.out.println("\n0: voltar ao menu anterior");
							System.out.println();
							int opcaoEditarFilme = ler.nextInt();
							if(opcaoEditarFilme > 0 && opcaoEditarFilme <= filmes.size()) {
								catalogoBrasil.fluxoCadastrarFilme(filmes.get(opcaoEditarFilme - 1));
								escolhendo = false;
							}else {
								if(opcaoEditarFilme == 0) {
									escolhendo = false;
								}else{
									System.out.println("\nOp��o inv�lida!");
								}
						}
					}				
						/// fim de editar um filme
						break;
					case 2:
						/// editar uma s�rie
						catalogoBrasil.fluxoCadastrarSerie(null);
						editando = false;
						/// fim de editar uma s�rie
						break;
					case 0:
						//voltar
						editando = false;
						break;
						//fim de voltar
					default:
						System.out.println();
						System.out.println("Op��o inv�lida!");
						break;
					}
				}
				/// fim de editar um programa
			case 3:
				/// remover um programa
				/// fim de remover um programa
			case 4:
				/// exibir dados de um programa
				/// fim de exibir dados de um programa
			case 5:
				/// listar v�rios programas
				/// fim de listar v�rios programas
				break;
			case 0:
				/// encerrar opera��o
				emOperacao = false;
				/// fim de encerrar opera��o
				break;
			default:
				// op��o inv�lida
				System.out.println("Escolha uma op��o v�lida!");
				// fim de op��o inv�lida
				break;
			}
		}
		System.out.println("\nAt� a pr�xima!");
	}
	

}




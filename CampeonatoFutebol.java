package arvore;

import java.util.Scanner;

import dados.Item;


public class CampeonatoFutebol {
	static Scanner scan =new Scanner(System.in);
	public static void main(String[] args) {
		//Arvore que contem pontos e arvore que contem o time
		Arvore arquivocampeonato = new Arvore();
		Arvore arquivotimes = new Arvore();
		int valor;
		Item [] vetor= new Item[10];
		char opcao=0;
		Apresenta();
		do {
			Menu();
			opcao=scan.next().charAt(0);
			switch(opcao) {
				case '1':
					CadastraTime();
				case '2':
					
				case '3':
					
				case '4':
					System.out.println("fim do programa");
					break;
					
				default:
					System.out.println("opção inválida, tente novamente");
			}
			
		}
		while (opcao!='4');
		System.exit(0);
	}
	
	
	public static void Apresenta() {
		System.out.println("Alunos: ");
		System.out.println("- Phellipe Santos Sarmento");
		System.out.println("- Raphael Ferreira de Moraes");
		System.out.println("- Tiago de Lima");
	}
	public static void Menu() {
		System.out.println();
		System.out.println("####################################################");
		System.out.println("##Bem vindo ao prigrama de campeonato de futebol!!##");
		System.out.println("####################################################");
		System.out.println("Escolha uma das opcoes a seguir:");
		System.out.println("1 - Cadastrar time com sua pontuação.");
		System.out.println("2 - Pesquisar o time e sua pontuacao.");
		System.out.println("3 - Excluir time e sua pontuacao");
		System.out.println("4 - Sair do programa.");
		System.out.println("####################################################");
		System.out.println("Digite uma opcao: ");
	}
	
	public static void CadastraTime() {
		String nome;
		int pontu;
		System.out.println("Digite o nome do time");
		nome=scan.next();
		System.out.println("Digite a pontuacao que o time tem no campeonato: ");
		pontu=scan.nextInt();
	}
	
	public static void PesquisaTime() {
		
	}
	
	public static void ExcluiTime() {
		
	}

}

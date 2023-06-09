package arvore;

import java.util.Scanner;

import dados.Item;
import java.util.Random;


public class CampeonatoFutebol {
	static Scanner scan =new Scanner(System.in);
	static Arvore arquivopontuacao = new Arvore();
	static Arvore2 arquivotimes = new Arvore2();
	static Item [] vetor= new Item[10];
	static Random gerador = new Random(50);
	
	public static void main(String[] args) {
		int valor;
		char opcao=0;
		Apresenta();
		do {
			Menu();
			opcao=scan.next().charAt(0);
			switch(opcao) {
				case '1':
					CadastraTime();
				case '2':
					PesquisaTime();
				case '3':
					ExcluiTime();
				case '4':
					MostraOrdenado();
				case '5':
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
		System.out.println("Materia : Estrutura de Dados");
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
		System.out.println("4 - Exibir time da maior pontuação para menor");
		System.out.println("5 - Sair do programa.");
		System.out.println("####################################################");
		System.out.println("Digite uma opcao: ");
	}
	
	public static void CadastraTime() {
		String nome;
		int pontu;
		System.out.println("Digite o nome do time");
		nome=scan.next();
		int numerito = gerador.nextInt();
		System.out.println("Digite a pontuação do time:");
		pontu=scan.nextInt();
		arquivopontuacao.inserir(new Item(pontu));
		arquivotimes.inserir(new Item2(), nome)
		
		
	}
	
	public static void PesquisaTime() {
		if (arquivotimes.eVazia()){
			System.out.println("Árvore está vazia");
		}else{
			
				
			}
		
	}
	
	public static void ExcluiTime() {
		if (arquivotimes.eVazia()){
			System.out.println("Árvore está vazia");
		}else{
			
		}
	}
	
	public static void MostraOrdenado() {
		if (arquivotimes.eVazia()){
			System.out.println("Árvore está vazia");
		}else{
			
		}
	}

}

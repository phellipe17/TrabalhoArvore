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
					MostraPontuordenada();
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
		System.out.println("4 - Exibir pontuaçao para menor");
		System.out.println("5 - Sair do programa.");
		System.out.println("####################################################");
		System.out.println("Digite uma opcao: ");
	}
	
	public static void CadastraTime() {
		String nome;
		int jogadores=0;
		int pontu;
		System.out.println("Digite o nome do time");
		nome=scan.next();
		//int numerito = gerador.nextInt();
		System.out.println("Digite a pontuação do time:");
		pontu=scan.nextInt();
		while(jogadores<11) {
			System.out.println("Digite quantos jogadores tem atualmente no time: ");
			jogadores=scan.nextInt();	
		}
		arquivopontuacao.inserir(new Item(pontu));
		arquivotimes.inserir(new Item2(jogadores,nome), nome);
				
	}
	
	public static void PesquisaTime() {
		String nometime;
		if (arquivotimes.eVazia()){
			System.out.println("Árvore está vazia");
		}else{
			System.out.println("Digite o time a ser procurado na nossa árvore binária:");
			nometime=scan.next();
			if(arquivotimes.pesquisar2(nometime)) {
				System.out.println("O time se encontra na nossa arvore.");
			}else {
				System.out.println("Não foi dessa vez que teremos o seu time na nossa arvore, poxa vida!!");
			}
			}
		
	}
	
	public static void ExcluiTime() {
		String nometime;
		if (arquivotimes.eVazia()){
			System.out.println("Árvore está vazia");
		}else{
			System.out.println("Digite o nome do time que deseja excluir da nossa arvore: ");
			nometime=scan.next();
			if(arquivotimes.remover(nometime)) {
				System.out.println("Time removido da arvore com sucesso!!");
			}else {
				System.out.println("não foi possivel remover pois não encontramos o time em nossa arvore.");
			}
			
		}
	}
	
	public static void MostraPontuordenada() {
		if (arquivopontuacao.eVazia()){
			System.out.println("Árvore está vazia");
		}else{
			if (arquivopontuacao.eVazia()){
				System.out.println("A árvore está vazia");
			}else{
				vetor = arquivopontuacao.CamCentral();
				String msg=" ";
				for (int i=0; i<arquivopontuacao.getQuantNos();i++){
					msg+= vetor[i].getChave()+" ";
				}
				System.out.println("Exibir a árvore: "+ msg);
			}
		}
	}

}

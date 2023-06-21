package arvore;

import java.util.Scanner;

//import dados.Item;

import java.util.Random;


public class CampeonatoFutebol {
	static Scanner scan =new Scanner(System.in);
	static Arvore3 arquivocampeonato = new Arvore3();
	static Arvore2 arquivotimes = new Arvore2();
	static Random gerador = new Random(50);
	
	public static void main(String[] args) {
		//int valor;
		char opcao=0;
		Apresenta();
		do {
			Menu();
			opcao=scan.next().charAt(0);
			switch(opcao) {
				case '1':
					CadastraTimeeCampeonato();
					break;
				case '2':
					PesquisaTime();
					break;
				case '3':
					PesquisaCampeonato();
					break;
				case '4':
					ExcluiTime();
					break;
				case '5':
					ExcluiCampeonato();
					break;
				case '6':
					PontuacaodoTime();
					break;
				case '7':
					MostraAnosCampeonato();
					break;
				case '8':
					ExibeInfoArvore();
					break;
				case '9':
					System.out.println("fim do programa");
					break;
				default:
					System.out.println("opção inválida, tente novamente");
			}
			
		}
		while (opcao!='9');
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
		System.out.println("1 - Cadastrar time e o campeonato.");
		System.out.println("2 - Pesquisar o time.");
		System.out.println("3 - Pesquisa campeonato.");
		System.out.println("4 - Exclui Time");
		System.out.println("5 - Exclui Campeonato");
		System.out.println("6 - Exibe a pontuacao do time que deseja pesquisar.");
		System.out.println("7 - Mostra os anos que ocorreram um campeonato.");
		System.out.println("8 - Exibir informações das arvores.");
		System.out.println("9 - Sair do programa.");
		System.out.println("####################################################");
		System.out.println("Digite uma opcao: ");
	}
	
	public static void CadastraTimeeCampeonato() {
		String nome, nomeCamp;
		int pontua,anu1;
		
		System.out.println("Digite o nome do time");
		nome=scan.next();
		int chave = gerador.nextInt();
		System.out.println("Digite a pontuação do time:");
		pontua=scan.nextInt();
		System.out.println("Ano em que o time foi campeão: ");
		anu1=scan.nextInt();
		System.out.println("Nome do campeonato que ele participou");
		nomeCamp=scan.next();
		if(arquivocampeonato.inserir(new Item3(chave,nomeCamp,anu1))) {
			System.out.println("Foi inserido na árvore de campeonatos corretamente.");
			if(arquivotimes.inserir(new Item2(chave,nome,pontua))) {
				System.out.println("O time foi inserido na árvore de times corretamente.");
			}else {
				System.out.println("Não foi possivel inserir pois já existe em nossa arvore");
			}
		}else {
			System.out.println("Não foi possivel inserir pois já existe em nossa arvore");
		}	
				
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
	
	public static String PesquisaCampeonato() {
		String nomecamp;
		Item3 [] vetor= new Item3[20];
		if (arquivocampeonato.eVazia()){
			System.out.println("Árvore está vazia");
		}else{
			vetor= arquivocampeonato.CamCentral();
			System.out.println("Digite o nome do campeonato");
			nomecamp=scan.next();
			for(int i=0;i<arquivocampeonato.getQuantNos();i++) {
				if(nomecamp == vetor[i].getCampeonato()) {
					return "O campeonato aconteceu e foi no ano de "+vetor[i].getAno();
				}
			}
		}
		return "Não foi encontrado campeonato na nossa arvore";	
	}
	
	public static void ExcluiTime() {
		String nometime;
		if (arquivotimes.eVazia()){
			System.out.println("Árvore está vazia");
		}else{
			Exibetime();
			System.out.println("Digite o nome do time que deseja excluir da nossa arvore: ");
			nometime=scan.next();
			if(arquivotimes.remover(nometime)) {
				System.out.println("Time removido da arvore com sucesso!!");
			}else {
				System.out.println("não foi possivel remover pois não encontramos o time em nossa arvore.");
			}
			
		}
	}
	
	public static void ExcluiCampeonato() {
		int valor;
		String msg="";
		if (arquivocampeonato.eVazia()){
			System.out.println("Arvore está vazia");
		}else {
			Exibecamp();	
			System.out.println("Para esxcluir um campeonato digite um id de algum campeonato: ");
			System.out.println(msg);
			valor = scan.nextInt();
			if (arquivocampeonato.remover(valor)){
				System.out.println("Campeonato apagado com sucesso!");
			}else{
				System.out.println("Remoção não foi efetuada, pois o id não se encontra na nossa arvore");
			}
		}
	}
	
	public static void MostraAnosCampeonato() {
		Item3 [] vetor= new Item3[20];
		String nomechamp;
		if (arquivocampeonato.eVazia()){
			System.out.println("Árvore está vazia");
		}else{
				System.out.println("Digite o nome do campeonato para ser mostrado quais anos ele ocorreu: ");
				nomechamp=scan.next();
				vetor = arquivocampeonato.Pesquisaanocampeonato(nomechamp);
				String msg="";
				for(int i=0;i<arquivocampeonato.getQuantNos();i++) {
					msg+= vetor[i].getAno()+ " ";
				}
				
				System.out.println("Os anos que o campeonato "+nomechamp+" aconteceram foi: ");
				System.out.println(msg);
			}
		
	}
	
	public static void PontuacaodoTime() {
		String nome;
		System.out.println("Digite o nome do time que deseja verificar com quantos pontos ele ganhou no campeonato: ");
		nome=scan.next();
		System.out.println(arquivotimes.pesquisar3(nome));
	}
	
	public static void ExibeInfoArvore() {
		char op=0;
		do {
			System.out.println("1 - Exibir info da arvore de time.");
			System.out.println("2 - Exibir info de arvore de campeonato. ");
			System.out.println("3 - Voltar");
			op=scan.next().charAt(0);
			switch(op) {
			case '1':
				Exibetime();
			case '2':
				Exibecamp();
			case '3':
				System.out.println("voltando...");
			default:
				System.out.println("Opcao invalida!");
			}
			
			
		}while(op!=03);
		
	}
	
	public static void Exibetime() {
		String str1="";
		String str2="";
		String str3="";
		if (arquivotimes.eVazia()){
			System.out.println("A árvore está vazia");
		}else{
			Item2 [] vetor= new Item2[20];
			vetor = arquivotimes.CamCentral();
			for(int i=0;i<arquivotimes.getQuantNos();i++) {
				str1+= vetor[i].getChave() + " | ";
				str2+= vetor[i].getTime() + " | ";
				str3+= vetor[i].getPontuacao() + " | ";
			}
		}
	}
	
	public static void Exibecamp() {
		String str1="";
		String str2="";
		String str3="";
		if (arquivocampeonato.eVazia()){
			System.out.println("A árvore está vazia");
		}else{
			Item3 [] vetor = new Item3[20];
			vetor =arquivocampeonato.CamCentral();
			for(int i=0;i<arquivocampeonato.getQuantNos();i++) {
				str1+= vetor[i].getChave() + " | ";
				str2+= vetor[i].getCampeonato() + " | ";
				str3+= vetor[i].getAno() + " | ";
			}
			
		}
		
		
	}
	

}

package arvore;

import java.util.Scanner;

//import dados.Item;

import java.util.Random;


public class CampeonatoFutebol {
	static Scanner scan =new Scanner(System.in);
	static Arvore3 arquivocampeonato = new Arvore3();
	static Arvore2 arquivotimes = new Arvore2();
	static Random gerador = new Random();
	
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
					System.out.println("op��o inv�lida, tente novamente");
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
		System.out.println("8 - Exibir informa��es das arvores.");
		System.out.println("9 - Sair do programa.");
		System.out.println("####################################################");
		System.out.println("Digite uma opcao: ");
	}
	
	public static void CadastraTimeeCampeonato() {
		String nome, nomeCamp;
		int pontua,anu1;
		
		System.out.println("Digite o nome do time");
		nome=scan.next();
		int chave = gerador.nextInt(50);
		System.out.println("Digite a pontua��o do time:");
		pontua=scan.nextInt();
		System.out.println("Ano em que o time foi campe�o: ");
		anu1=scan.nextInt();
		System.out.println("Nome do campeonato que ele participou");
		nomeCamp=scan.next();
		if(PesquisaParaInserirC(nomeCamp,anu1)) {
			System.out.println("N�o � possivel pois J� foi anotado o campeonato nesse mesmo ano.");
		}
		else {
			if(arquivocampeonato.inserir(new Item3(chave,nomeCamp,anu1))) {
				System.out.println("Foi inserido na �rvore de campeonatos corretamente.");
				if(arquivotimes.inserir(new Item2(chave,nome,pontua))) {
					System.out.println("O time foi inserido na �rvore de times corretamente.");
				}else {
					System.out.println("N�o foi possivel inserir pois j� existe em nossa arvore");
				}
			}else {
				System.out.println("N�o foi possivel inserir pois j� existe em nossa arvore");
			}
		}		
	}
	
	public static void PesquisaTime() {
		String nometime;
		if (arquivotimes.eVazia()){
			System.out.println("�rvore est� vazia");
		}else{
			System.out.println("Digite o time a ser procurado na nossa �rvore bin�ria:");
			nometime=scan.next();
			if(arquivotimes.pesquisar2(nometime)) {
				System.out.println("O time se encontra na nossa arvore.");
			}else {
				System.out.println("N�o foi dessa vez que teremos o seu time na nossa arvore, poxa vida!!");
			}
		}
		
	}
	
	public static void PesquisaCampeonato() {
		if (arquivocampeonato.eVazia()){
			System.out.println("�rvore est� vazia");
		}else{
			String nomecamp;
			Item3 [] vetor= new Item3[20];
			String resposta = "n�o foi Dessa vez que o campeonato desejado esta na nossa arvore.";
			vetor= arquivocampeonato.CamCentral();
			System.out.println("Digite o nome do campeonato");
			nomecamp=scan.next();
			for(int i=0;i<arquivocampeonato.getQuantNos();i++) {
				if(nomecamp.equalsIgnoreCase(vetor[i].getCampeonato())) {
					resposta= "Campeonato esta em nossa arvore";
				}
			}
			System.out.println(resposta);
		}
			
	}
	//pesquisa para checar se j� existe registro de um mesmo campeonato no mesmo ano
	public static boolean PesquisaParaInserirC(String nomezero, int anozero) {
		if (arquivocampeonato.eVazia()){
			System.out.println("�rvore est� vazia");
		}else{
			Item3 [] vetor= new Item3[20];
			vetor= arquivocampeonato.CamCentral();
			for(int i=0;i<arquivocampeonato.getQuantNos();i++) {
				if(nomezero.equalsIgnoreCase(vetor[i].getCampeonato()) && anozero == vetor[i].getAno()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void ExcluiTime() {
		String nometime;
		if (arquivotimes.eVazia()){
			System.out.println("�rvore est� vazia");
		}else{
			Exibetime();
			System.out.println("Digite o nome do time que deseja excluir da nossa arvore: ");
			nometime=scan.next();
			if(arquivotimes.remover(nometime)) {
				System.out.println("Time removido da arvore com sucesso!!");
			}else {
				System.out.println("n�o foi possivel remover pois n�o encontramos o time em nossa arvore.");
			}
			
		}
	}
	
	public static void ExcluiCampeonato() {
		int valor;
		String msg="";
		if (arquivocampeonato.eVazia()){
			System.out.println("Arvore est� vazia");
		}else {
			Exibecamp();	
			System.out.println("Para esxcluir um campeonato digite um id de algum campeonato: ");
			System.out.println(msg);
			valor = scan.nextInt();
			if (arquivocampeonato.remover(valor)){
				System.out.println("Campeonato apagado com sucesso!");
			}else{
				System.out.println("Remo��o n�o foi efetuada, pois o id n�o se encontra na nossa arvore");
			}
		}
	}
	
	public static void MostraAnosCampeonato() {
		Item3 [] vetor= new Item3[20];
		String nomechamp;
		String anos="";
		if (arquivocampeonato.eVazia()){
			System.out.println("�rvore est� vazia");
		}else{
				System.out.println("Digite o nome do campeonato para ser mostrado quais anos ele ocorreu: ");
				nomechamp=scan.next();
				vetor = arquivocampeonato.CamCentral();
				for(int i=0;i<arquivocampeonato.getQuantNos();i++) {
					if(nomechamp.equalsIgnoreCase(vetor[i].getCampeonato())) {
						anos+= vetor[i].getAno() + " ";
					}
				}
				
				System.out.println("Os anos que o campeonato "+nomechamp+" aconteceram foi: "+anos);
			}
		
	}
	
	public static void PontuacaodoTime() {
		String nome;
		System.out.println("Digite o nome do time que deseja verificar com quantos pontos ele ganhou no campeonato: ");
		nome=scan.next();
		if(arquivotimes.eVazia()) {
			System.out.println("A arvore esta vazia.");
		}
		else{
			if(arquivotimes.pesquisar3(nome)!=null) {
				System.out.println("O time "+nome+" ganhou com a pontua��o "+arquivotimes.pesquisar3(nome).getPontuacao());
			}
			else {
				System.out.println("O time n�o se encontra na nossa arovre para te mostrar a pontuacao.");
			}
		}
		

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
				break;
			case '2':
				Exibecamp();
				break;
			case '3':
				System.out.println("voltando...");
				break;
			default:
				System.out.println("Opcao invalida!");
			}
			
			
		}while(op!='3');
		
	}

	public static void Exibetime() {
		if (arquivotimes.eVazia()) {
			System.out.println("A �rvore est� vazia");
		} else {
			Item2[] vetor = arquivotimes.CamCentral();
			System.out.println("Chave | Time | Pontua��o");
			for (int i = 0; i < arquivotimes.getQuantNos(); i++) {
				System.out.println(vetor[i].getChave() + " | " + vetor[i].getTime() + " | " + vetor[i].getPontuacao());
			}
		}
	}


	public static void Exibecamp() {
		if (arquivocampeonato.eVazia()) {
			System.out.println("A �rvore est� vazia");
		} else {
			Item3[] vetor = arquivocampeonato.CamCentral();
			System.out.println("Chave | Campeonato | Ano");
			for (int i = 0; i < arquivocampeonato.getQuantNos(); i++) {
				System.out.println(vetor[i].getChave() + " | " + vetor[i].getCampeonato() + " | " + vetor[i].getAno());
			}
		}
	}
}

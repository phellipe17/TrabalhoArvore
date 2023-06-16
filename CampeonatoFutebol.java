package arvore;

import java.util.Scanner;

import dados.Item;
import java.util.Random;


public class CampeonatoFutebol {
	static Scanner scan =new Scanner(System.in);
	static Arvore3 arquivocampeonato = new Arvore3();
	static Arvore2 arquivotimes = new Arvore2();
	static Item3 [] vetor= new Item3[10];
	static Item2 [] vetor2 = new Item2[10];
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
					CadastraTime();
				case '2':
					PesquisaTime();
				case '3':
					ExcluiTime();
				case '4':
					MostraAnosCampeonato();
				case '5':
					PesquisaCampeonato();
				case '6':
					PontuacaodoTime();
				case '7':
					System.out.println("fim do programa");
					break;
					
				default:
					System.out.println("opção inválida, tente novamente");
			}
			
		}
		while (opcao!='7');
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
		System.out.println("4 - Exibir os anos em que aconteceram campeonatos");
		System.out.println("5 - Verificar se o campeonato que você pensa aconteceu no ano digitado");
		System.out.println("6 - Exibir times com numero de jogadores maior que 15");
		System.out.println("7 - Sair do programa.");
		System.out.println("####################################################");
		System.out.println("Digite uma opcao: ");
	}
	
	public static void CadastraTime() {
		String nome, nomeCamp;
		int pontua,anu1 ;
		
		System.out.println("Digite o nome do time");
		nome=scan.next();
		int chave = gerador.nextInt();
		System.out.println("Digite a pontuação do time:");
		pontua=scan.nextInt();
		System.out.println("Ano em que o time foi campeão: ");
		anu1=scan.nextInt();
		System.out.println("E o nome do campeonato que ele participou");
		nomeCamp=scan.next();
		if(arquivocampeonato.inserir(new Item3(chave,nomeCamp,anu1))) {
			System.out.println("Foi inserido na árvore de campeonatos corretamente.");
		}else {
			System.out.println("Não foi possivel inserir pois já existe ");
		}
		if(arquivotimes.inserir(new Item2(chave,nome,pontua))) {
			System.out.println("O time foi inserido na árvore de times corretamente.");
		}else {
			System.out.println("Nao foi possivel pois a arvore já tem esse time.");
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
	
	public static void PesquisaCampeonato() {
		String nomecamp;
		int ano;
		if (arquivotimes.eVazia()){
			System.out.println("Árvore está vazia");
		}else{
			System.out.println("Digite o nome do campeonato e o ano para ver se ele acontecer: ");
			nomecamp=scan.next();
			System.out.println("Agora o ano: ");
			ano=scan.nextInt();
			if(arquivocampeonato.pesquisar3(ano, nomecamp)) {
				System.out.println("Ocorreu campeonato nesse mesmo ano!!");
			}
			else {
				System.out.println("Esse campeonato não aconteceu no ano desejado, me desculpe.");
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
	
	public static void ExcluiCampeonato() {
		int valor;
		if (arquivocampeonato.eVazia()){
			System.out.println("Arvore está vazia");
		}else {
			System.out.println("Excluir um elemento da"+
					" lista\nDigite um valor:");
			valor = scan.nextInt();
			if (arquivocampeonato.remover(valor)){
				System.out.println("remoção efetuada");
			}else{
				System.out.println("remoção não"+
						" efetuada, valor não encontrado");
			}
		}
	}
	
	public static void MostraAnosCampeonato() {
		if (arquivocampeonato.eVazia()){
			System.out.println("Árvore está vazia");
		}else{
				vetor = arquivocampeonato.CamCentral();
				String msg=" ";
				for (int i=0; i<arquivocampeonato.getQuantNos();i++){
					msg+= vetor[i].getAno()+" ";
				}
				System.out.println("Exibir a árvore: "+ msg);
			}
		
	}
	
//	public static void Mostratimesmesmainicial() {
//		String timero;
//		if (arquivotimes.eVazia()){
//			System.out.println("Árvore está vazia");
//		}else{
//			System.out.println("Digite o nome do time em que é desejado achar os times com a mesma inicial: ");
//			timero=scan.next();
//			vetor2 = arquivotimes.Pesquisatimeinicial(timero);
//			if(vetor2[0]==null) {
//				System.out.println("Não se tem time com mesma inicial.");
//			}
//			else {
//				String msg=" ";
//				for (int i=0; i<arquivotimes.getQuantNos();i++){
//				msg+= vetor2[i].getTime()+" ";
//				}
//				System.out.println("Os times em ordem alfabética que contém a mesma inical: \n"+ msg+"\n");
//			}
//			
//		}
//	}
	
	
//	public static void MostraMaiorMenorpontu() {
//		int z=0;
//		if (arquivopontuacao.eVazia()){
//			System.out.println("Árvore está vazia");
//		}else{
//			vetor = arquivopontuacao.CamCentral();
//			String msg=" ";
//			for (int i=arquivopontuacao.getQuantNos(); i>0;i--){
//				msg+= vetor[z].getChave()+" ";
//				z++;
//			}
//			System.out.println("Maior pontuacao para menor dos times: \n"+ msg+"\n");
//		}
//	}
	
	public static void PontuacaodoTime() {
		String nome;
		System.out.println("Digite o nome do time que deseja verificar com quantos pontos ele ganhou no campeonato: ");
		nome=scan.next();
		
	}

}

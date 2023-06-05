package arvore;

import java.util.Scanner;

import dados.Item;

public class BlocoPrincipalArvore {
	static Scanner scan =new Scanner(System.in);
	public static void main(String[] args) {
		Arvore arvore = new Arvore();
		int valor;
		Item [] vetor= new Item[10];
		char opcao;
		do {
			System.out.println("Escolha uma Op��o:\n" +
					"1. Inserir N� na �rvore\n"+
					"2. Localizar N� na �rvore\n"+
					"3. Excluir N� da �rvore\n" +
					"4. Exibir �rvore ordenada\n" +
					"5. Sair");
			opcao = scan.next().charAt(0);
			switch (opcao){
			case '1':
				System.out.println("Inserir um Valor na �rvore\n"+
						"Digite um valor");
				valor = scan.nextInt();
				if (arvore.inserir(new Item(valor))){
					System.out.println("inser��o efetuada com sucesso");
				}else{
					System.out.println("inser��o n�o efetuada, "+
							"valor j� existe");
				}
				break;
			case '2':
				if (arvore.eVazia()){
					System.out.println("�rvore est� vazia");
				}else{
					System.out.println("Localizar um valor\n"+
							"Digite o valor");
					valor = scan.nextInt();
					if (arvore.pesquisar(valor)){
						System.out.println("o "+valor+" foi"+
								" encontrado");
					}else{
						System.out.println("o valor n�o foi"+
								" encontrado na arvore");
					}
				}
				break;
			case '3':
				if (arvore.eVazia()){
					System.out.println("Arvore est� vazia");
				}else {
					System.out.println("Excluir um elemento da"+
							" lista\nDigite um valor");
					valor = scan.nextInt();
					if (arvore.remover(valor)){
						System.out.println("remo��o efetuada");
					}else{
						System.out.println("remo��o n�o"+
								" efetuada, valor n�o encontrado");
					}
				}
				break;
			case '4':
				if (arvore.eVazia()){
					System.out.println("A �rvore est� vazia");
				}else{
					vetor = arvore.CamCentral();
					String msg=" ";
					for (int i=0; i<arvore.getQuantNos();i++){
						msg+= vetor[i].getChave()+" ";
					}
					System.out.println("Exibir a �rvore: "+ msg);
				}
				break;
			case '5':
				System.out.println("fim do programa");
				break;
			default:
				System.out.println("op��o inv�lida, tente novamente");
			}
		} while (opcao!='5');
		System.exit(0);
	}


}



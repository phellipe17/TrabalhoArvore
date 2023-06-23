package arvore;

//import dados.Item;

public class Arvore2 {
	private NoArv2 raiz;
	private int quantNos;//opcional
	public Arvore2(){
		this.quantNos=0;
		this.raiz = null;
	}
	public boolean eVazia (){
		return (this.raiz == null);
	}
	public NoArv2 getRaiz(){
		return this.raiz;
	}
	public int getQuantNos(){
		return this.quantNos;
	}
	//inserir um novo nó na arvore. Sempre insere em um atributo que seja igual a null
	//necessário pesquisa 2 para checar se o time já existe e pesquisa 1 para ver se o indice já existe
	public boolean inserir (Item2 elem){
		if (pesquisar2(elem.getTime())){
			return false;
		}else{
			this.raiz = inserir(elem, this.raiz);
			this.quantNos++;
			return true;
		}
	}
	public NoArv2 inserir (Item2 elem, NoArv2 no){
		if (no == null){
			NoArv2 novo = new NoArv2(elem);
			return novo;
		}else {
			if (elem.getChave() < no.getInfo().getChave()){
				no.setEsq(inserir(elem, no.getEsq()));
				return no;
			}else{
				no.setDir(inserir(elem, no.getDir()));
				return no;
			}
		}
	}
	//Pesquisa se chave
	public boolean pesquisar (int chave){
		if (pesquisar (chave, this.raiz)!= null){
			return true;
		}else{
			return false;
		}
	}
	private NoArv2 pesquisar (int chave, NoArv2 no){
		if (no != null){
			if (chave < no.getInfo().getChave()){
				no = pesquisar (chave, no.getEsq());
			}else{
				if (chave > no.getInfo().getChave()){
					no = pesquisar (chave, no.getDir());
				}
			}
		}
		return no;
	}
	//Pesquisa se o time já existe
	public boolean pesquisar2(String tim) {
		return pesquisar2(this.raiz, tim);
	}

	private boolean pesquisar2(NoArv2 no, String tim2) {
		if (no == null) {
			return false; // Time não encontrado na árvore
		}

		int comparacao = tim2.compareToIgnoreCase(no.getInfo().getTime());
		if (comparacao == 0) {
			return true; // Encontrou o time na árvore
		} else if (comparacao < 0) {
			return pesquisar2(no.getEsq(), tim2); // Continua a busca na subárvore esquerda
		} else {
			return pesquisar2(no.getDir(), tim2); // Continua a busca na subárvore direita
		}
	}



	//pesquisa o time para falar a pontuacao que ele ganhou o campeonato.
	public Item2 pesquisar3 (String tim){
		Item2 treco;
		try {
			treco = pesquisar3(this.raiz,tim).getInfo();	
				
				
			if ((treco)!= null){
				return treco;
			}else{
				return null;
			}
		}catch(Exception ex) {
			System.out.println("Time não encontrado, tente novamente...");
		}
		
		return null;
	}
	
	private NoArv2 pesquisar3 (NoArv2 no, String tim2){
		if (no != null){
			if(tim2.compareToIgnoreCase(no.getInfo().getTime())<0) {
			
				no = pesquisar3 (no.getEsq(),tim2);
			}else{
				if(tim2.compareToIgnoreCase(no.getInfo().getTime())>0) {
				
					no = pesquisar3 (no.getDir(),tim2);
				}
			}
		}else {
			return null;
		}
		return no;
	}
	
	
	//remove um determinado nó procurando pela chave. O nó pode estar em qualquer
	//posição na árvore
	//imagino que só o ato de pesquisar 2 possa resolver pois trata do nome do time
	public boolean remover(String tim) {
		if (pesquisar2(this.raiz, tim)) {
			this.raiz = remover(this.raiz, tim);
			this.quantNos--;
			return true;
		} else {
			return false;
		}
	}

	private NoArv2 remover(NoArv2 arv, String tim2) {
		if (arv == null) {
			return null;
		}

		int comparacao = tim2.compareToIgnoreCase(arv.getInfo().getTime());
		if (comparacao < 0) {
			arv.setEsq(remover(arv.getEsq(), tim2)); // Continua a busca na subárvore esquerda
		} else if (comparacao > 0) {
			arv.setDir(remover(arv.getDir(), tim2)); // Continua a busca na subárvore direita
		} else {
			// Encontrou o nó a ser removido

			if (arv.getEsq() == null && arv.getDir() == null) {
				// Caso 1: O nó a ser removido é uma folha
				return null;
			} else if (arv.getEsq() == null) {
				// Caso 2: O nó a ser removido possui apenas um filho à direita
				return arv.getDir();
			} else if (arv.getDir() == null) {
				// Caso 2: O nó a ser removido possui apenas um filho à esquerda
				return arv.getEsq();
			} else {
				// Caso 3: O nó a ser removido possui dois filhos
				arv.setEsq(arrumar(arv, arv.getEsq())); // Encontra o maior nó na subárvore esquerda
			}
		}

		return arv;
	}

	private NoArv2 arrumar(NoArv2 arv, NoArv2 maior) {
		if (maior.getDir() != null) {
			maior.setDir(arrumar(arv, maior.getDir())); // Continua a busca pelo maior nó na subárvore direita
		} else {
			arv.setInfo(maior.getInfo()); // Substitui o nó a ser removido pelo maior nó encontrado
			maior = maior.getEsq();
		}

		return maior;
	}


	//caminhamento central
	public Item2 [] CamCentral (){
		int []n= new int[1];
		n[0]=0;
		Item2 [] vet = new Item2[this.quantNos];
		return (FazCamCentral (this.raiz, vet, n));
	}
	private Item2 [] FazCamCentral (NoArv2 arv, Item2 [] vet, int []n){
		if (arv != null) {
			vet = FazCamCentral (arv.getEsq(),vet,n);
			vet[n[0]] = arv.getInfo();
			n[0]++;
			vet = FazCamCentral (arv.getDir(),vet,n);
		}
		return vet;
	}
	//caminhamento pré-fixado - 
	public Item2 [] CamPreFixado (){
		int []n= new int[1];
		n[0]=0;
		Item2 [] vet = new Item2[this.quantNos];
		return (FazCamPreFixado (this.raiz, vet, n));
	}
	private Item2 [] FazCamPreFixado (NoArv2 arv, Item2 [] vet, int []n){
		if (arv != null) {
			vet[n[0]] = arv.getInfo();
			n[0]++;
			vet = FazCamPreFixado (arv.getEsq(), vet,n);
			vet = FazCamPreFixado (arv.getDir(), vet,n);
		}
		return vet;
	}
	//caminhamento pós-fixado - busca os do mais baixo da árvore para cima
	public Item2 [] CamPosFixado (){
		int []n= new int[1];
		n[0]=0;
		Item2 [] vet = new Item2[this.quantNos];
		return (FazCamPosFixado (this.raiz, vet, n));
	}
	private Item2 [] FazCamPosFixado (NoArv2 arv, Item2[] vet, int []n){
		if (arv != null) {
			vet = FazCamPosFixado (arv.getEsq(), vet,n);
			vet = FazCamPosFixado (arv.getDir(), vet,n);
			vet[n[0]] = arv.getInfo();
			n[0]++;
		}
		return vet;
	}
	
	//utilizado copia cam central para colocar em ordem alfabetica os times e mostra apenas os times da arvore que tem a mesma inical
	//do time que foi passado
//	public Item2 [] Pesquisatimeinicial(String tim) {
//		int []n= new int[1];
//		n[0]=0;
//		Item2 [] vet = new Item2[this.quantNos];
//		return (FazPesquisatimeinicial (this.raiz, vet, n,tim));
//	}
//	
//	private Item2[] FazPesquisatimeinicial(NoArv2 arv, Item2[] vet, int []n,String tim2) {
//		if (arv != null) {
//			vet = FazCamCentral (arv.getEsq(),vet,n);
//			if(tim2.charAt(0)==arv.getInfo().getTime().charAt(0)) {
//				vet[n[0]] = arv.getInfo();
//			}
//			n[0]++;
//			vet = FazCamCentral (arv.getDir(),vet,n);
//		}
//		return vet;
//	}
//	
//	//quantos times possuem mais de 15 jogadores no time - Usando pos
//	
//	public Item2 [] PesquisaQuantJog() {
//		int []n= new int[1];
//		n[0]=0;
//		Item2 [] vet = new Item2[this.quantNos];
//		return (FazPesquisaQuantJog (this.raiz, vet, n));
//	}
//	
//	private Item2 [] FazPesquisaQuantJog(NoArv2 arv, Item2[] vet, int []n) {
//		if (arv != null) {
//			vet = FazCamPosFixado (arv.getEsq(), vet,n);
//			vet = FazCamPosFixado (arv.getDir(), vet,n);
//			if(arv.getInfo().getChave()>=15) {
//				vet[n[0]] = arv.getInfo();
//				n[0]++;
//			}
//		}
//		return vet;
//	}
	
	

}

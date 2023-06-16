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
	public boolean pesquisar2 (String tim){
		if (pesquisar2(this.raiz,tim)!= null){
			return true;
		}else{
			return false;
		}
	}
	private NoArv2 pesquisar2 (NoArv2 no, String tim2){
		if (no != null){
			if(tim2.compareToIgnoreCase(no.getInfo().getTime())<0) {
			//if (tim2 !=no.getInfo().getTime()){
				no = pesquisar2 (no.getEsq(),tim2);
			}else{
				if(tim2.compareToIgnoreCase(no.getInfo().getTime())>0) {
				//if (tim2 !=no.getInfo().getTime()){
					no = pesquisar2 (no.getDir(),tim2);
				}
			}
		}
		return no;
	}
	
	
	//pesquisa o time para falar a pontuacao que ele ganhou o campeonato.
	public String pesquisar3 (String tim){
		Item2 treco = pesquisar3(this.raiz,tim).getInfo();
		if ((treco)!= null){
			return "Nome do time: "+ treco.getTime() + "Pontuacao: " + treco.getPontuacao();
		}else{
			return "O time não existe e portanto nao e possivel mostrar pontuacao";
		}
	}
	
	private NoArv2 pesquisar3 (NoArv2 no, String tim2){
		if (no != null){
			if(tim2.compareToIgnoreCase(no.getInfo().getTime())<0) {
			//if (tim2 !=no.getInfo().getTime()){
				no = pesquisar2 (no.getEsq(),tim2);
			}else{
				if(tim2.compareToIgnoreCase(no.getInfo().getTime())>0) {
				//if (tim2 !=no.getInfo().getTime()){
					no = pesquisar2 (no.getDir(),tim2);
				}
			}
		}
		return no;
	}
	
	
	//remove um determinado nó procurando pela chave. O nó pode estar em qualquer
	//posição na árvore
	//imagino que só o ato de pesquisar 2 possa resolver pois trata do nome do time
	public boolean remover (String tim){
		if (pesquisar2(this.raiz,tim) != null){
			this.raiz = remover (this.raiz,tim);
			this.quantNos--;
			return true;
		}
		else {
			return false;
		}
	}
	public NoArv2 remover (NoArv2 arv, String tim2){
		if (tim2 == arv.getInfo().getTime()){
			arv.setEsq(remover (arv.getEsq(),tim2));
		}else{
			if (tim2 == arv.getInfo().getTime()){
				arv.setDir(remover (arv.getDir(),tim2));
			}else{
				if (arv.getDir()== null){
					return arv.getEsq();
				}else{
					if (arv.getEsq() == null){
						return arv.getDir();
					}else{
						arv.setEsq(Arrumar (arv, arv.getEsq()));
					}
				}
			}
		}
		return arv;
	}
	private NoArv2 Arrumar (NoArv2 arv, NoArv2 maior){
		if (maior.getDir() != null){
			maior.setDir(Arrumar (arv, maior.getDir()));
		}
		else{
			arv.setInfo(maior.getInfo());
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
	public Item2 [] Pesquisatimeinicial(String tim) {
		int []n= new int[1];
		n[0]=0;
		Item2 [] vet = new Item2[this.quantNos];
		return (FazPesquisatimeinicial (this.raiz, vet, n,tim));
	}
	
	private Item2[] FazPesquisatimeinicial(NoArv2 arv, Item2[] vet, int []n,String tim2) {
		if (arv != null) {
			vet = FazCamCentral (arv.getEsq(),vet,n);
			if(tim2.charAt(0)==arv.getInfo().getTime().charAt(0)) {
				vet[n[0]] = arv.getInfo();
			}
			n[0]++;
			vet = FazCamCentral (arv.getDir(),vet,n);
		}
		return vet;
	}
	
	//quantos times possuem mais de 15 jogadores no time - Usando pos
	
	public Item2 [] PesquisaQuantJog() {
		int []n= new int[1];
		n[0]=0;
		Item2 [] vet = new Item2[this.quantNos];
		return (FazPesquisaQuantJog (this.raiz, vet, n));
	}
	
	private Item2 [] FazPesquisaQuantJog(NoArv2 arv, Item2[] vet, int []n) {
		if (arv != null) {
			vet = FazCamPosFixado (arv.getEsq(), vet,n);
			vet = FazCamPosFixado (arv.getDir(), vet,n);
			if(arv.getInfo().getChave()>=15) {
				vet[n[0]] = arv.getInfo();
				n[0]++;
			}
		}
		return vet;
	}
	
	

}

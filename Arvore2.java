package arvore;

import dados.Item;

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
	public boolean inserir (Item2 elem, String tim){
		if (pesquisar2(elem.getTime()) && pesquisar(elem.getChave()) ){
			return false;
		}else{
			this.raiz = inserir(elem, this.raiz,tim);
			this.quantNos++;
			return true;
		}
	}
	public NoArv2 inserir (Item2 elem, NoArv2 no, String tim2){
		if (no == null){
			NoArv2 novo = new NoArv2(elem);
			return novo;
		}else {
			if (elem.getChave() < no.getInfo().getChave()){
				no.setEsq(inserir(elem, no.getEsq(),tim2));
				return no;
			}else{
				no.setDir(inserir(elem, no.getDir(),tim2));
				return no;
			}
		}
	}
	//Pesquisa se o indice já existe
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
			if (tim2 !=no.getInfo().getTime()){
				no = pesquisar2 (no.getEsq(),tim2);
			}else{
				if (tim2 !=no.getInfo().getTime()){
					no = pesquisar2 (no.getDir(),tim2);
				}
			}
		}
		return no;
	}
	//para adicionar a comparação no futuro String
//	String str1 = "A";
//	String str2 = "B";
//
//	int comp = str1.compareTo(str2);
//
//	if(comp < 0) {
//	  System.out.println("str1 menor que str2");
//	} else if(comp > 0) {
//	  System.out.println("str1 maior que str2");
//	} else {
//	  System.out.println("str1 e str2 são iguais");
//	}
	
	//remove um determinado nó procurando pela chave. O nó pode estar em qualquer
	//posição na árvore
	//imagino que só o ato de pesquisar 2 possa resolver pois trata do nome do time
	public boolean remover (int chave, String tim){
		if (pesquisar2(this.raiz,tim) != null){
			this.raiz = remover (chave, this.raiz,tim);
			this.quantNos--;
			return true;
		}
		else {
			return false;
		}
	}
	public NoArv2 remover (int chave, NoArv2 arv, String tim2){
		if (chave == arv.getInfo().getChave() && tim2 == arv.getInfo().getTime()){
			arv.setEsq(remover (chave, arv.getEsq(),tim2));
		}else{
			if (chave == arv.getInfo().getChave() && tim2 == arv.getInfo().getTime()){
				arv.setDir(remover (chave, arv.getDir(),tim2));
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
	//caminhamento pré-fixado
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
	//caminhamento pós-fixado
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



}

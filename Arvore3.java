package arvore;

//import dados.Item;

public class Arvore3 {
	private NoArv3 raiz;
	private int quantNos;//opcional
	public Arvore3(){
		this.quantNos=0;
		this.raiz = null;
	}
	
	public boolean eVazia (){
		return (this.raiz == null);
	}
	public NoArv3 getRaiz(){
		return this.raiz;
	}
	public int getQuantNos(){
		return this.quantNos;
	}
	//inserir um novo nó na arvore. Sempre insere em um atributo que seja igual a null
	public boolean inserir (Item3 elem){
		if (pesquisar (elem.getChave())){
			return false;
		}else{
			this.raiz = inserir (elem, this.raiz);
			this.quantNos++;
			return true;
		}
	}
	public NoArv3 inserir (Item3 elem, NoArv3 no){
		if (no == null){
			NoArv3 novo = new NoArv3(elem);
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
	//Pesquisa se um determinado valor está na árvore
	public boolean pesquisar (int chave){
		if (pesquisar (chave, this.raiz)!= null){
			return true;
		}else{
			return false;
		}
	}
	private NoArv3 pesquisar (int chave, NoArv3 no){
		if (no != null){
			if (chave < no.getInfo().getChave() ){
				no = pesquisar (chave, no.getEsq());
			}else{
				if (chave > no.getInfo().getChave()){
					no = pesquisar (chave, no.getDir());
				}
			}
		}
		return no;
	}
	//pesquisa ano
	public boolean pesquisar2 (int chave){
		if (pesquisar2 (chave, this.raiz)!= null){
			return true;
		}else{
			return false;
		}
	}
	private NoArv3 pesquisar2 (int chave, NoArv3 no){
		if (no != null){
			if (chave < no.getInfo().getChave() ){
				no = pesquisar (chave, no.getEsq());
			}else{
				if (chave > no.getInfo().getChave()){
					no = pesquisar (chave, no.getDir());
				}
			}
		}
		return no;
	}
	
	//pesquisa ano e campeonato
	public Item3 [] Pesquisaanocampeonato (String camp){
		int []n= new int[1];
		n[0]=0;
		Item3 [] vet = new Item3[this.quantNos];
		return (FazPesquisaanocampeonato (this.raiz, vet, n,camp));
	}
	private Item3 [] FazPesquisaanocampeonato (NoArv3 arv, Item3 [] vet, int []n,String camp2){
		if (arv != null) {
			vet = FazCamCentral (arv.getEsq(),vet,n);
			if (arv.getInfo().getCampeonato().equalsIgnoreCase(camp2)) {
	            vet[n[0]] = arv.getInfo();
	            n[0]++;
	        }
			vet = FazCamCentral (arv.getDir(),vet,n);
		}
		return vet;
	}
	
	
	
	
	//remove um determinado nó procurando pela chave. O nó pode estar em qualquer
	//posição na árvore
	public boolean remover (int chave){
		if (pesquisar (chave, this.raiz) != null){
			this.raiz = remover (chave, this.raiz);
			this.quantNos--;
			return true;
		}
		else {
			return false;
		}
	}
	public NoArv3 remover (int chave, NoArv3 arv){
		if (chave < arv.getInfo().getChave()){
			arv.setEsq(remover (chave, arv.getEsq()));
		}else{
			if (chave > arv.getInfo().getChave()){
				arv.setDir(remover (chave, arv.getDir()));
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
	private NoArv3 Arrumar (NoArv3 arv, NoArv3 maior){
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
	public Item3 [] CamCentral (){
		int []n= new int[1];
		n[0]=0;
		Item3 [] vet = new Item3[this.quantNos];
		return (FazCamCentral (this.raiz, vet, n));
	}
	private Item3 [] FazCamCentral (NoArv3 arv, Item3 [] vet, int []n){
		if (arv != null) {
			vet = FazCamCentral (arv.getEsq(),vet,n);
			vet[n[0]] = arv.getInfo();
			n[0]++;
			vet = FazCamCentral (arv.getDir(),vet,n);
		}
		return vet;
	}
	//caminhamento pré-fixado
	public Item3 [] CamPreFixado (){
		int []n= new int[1];
		n[0]=0;
		Item3 [] vet = new Item3[this.quantNos];
		return (FazCamPreFixado (this.raiz, vet, n));
	}
	private Item3 [] FazCamPreFixado (NoArv3 arv, Item3 [] vet, int []n){
		if (arv != null) {
			vet[n[0]] = arv.getInfo();
			n[0]++;
			vet = FazCamPreFixado (arv.getEsq(), vet,n);
			vet = FazCamPreFixado (arv.getDir(), vet,n);
		}
		return vet;
	}
	//caminhamento pós-fixado
	public Item3 [] CamPosFixado (){
		int []n= new int[1];
		n[0]=0;
		Item3 [] vet = new Item3[this.quantNos];
		return (FazCamPosFixado (this.raiz, vet, n));
	}
	private Item3 [] FazCamPosFixado (NoArv3 arv, Item3[] vet, int []n){
		if (arv != null) {
			vet = FazCamPosFixado (arv.getEsq(), vet,n);
			vet = FazCamPosFixado (arv.getDir(), vet,n);
			vet[n[0]] = arv.getInfo();
			n[0]++;
		}
		return vet;
	}

}

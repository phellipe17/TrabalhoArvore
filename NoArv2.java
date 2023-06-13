package arvore;

//import dados.Item;

public class NoArv2 {
	private Item2 info; // o tipo Item está declarado no capítulo 1
	private NoArv2 esq, dir;
	public NoArv2(Item2 elem){
		this.info = elem;
		this.esq = null;
		this.dir = null;
	}
	public NoArv2 getEsq(){
		return this.esq;
	}
	public NoArv2 getDir(){
		return this.dir;
	}
	public Item2 getInfo(){
		return this.info;
	}
	public void setEsq(NoArv2 no){
		this.esq = no;
	}
	public void setDir(NoArv2 no){
		this.dir = no;
	}
	public void setInfo(Item2 elem){
		this.info = elem;
	}
}

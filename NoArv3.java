package arvore;

public class NoArv3 {
	private Item3 info; // o tipo Item está declarado no capítulo 1
	private NoArv3 esq, dir;
	public NoArv3(Item3 elem){
		this.info = elem;
		this.esq = null;
		this.dir = null;
	}
	public NoArv3 getEsq(){
		return this.esq;
	}
	public NoArv3 getDir(){
		return this.dir;
	}
	public Item3 getInfo(){
		return this.info;
	}
	public void setEsq(NoArv3 no){
		this.esq = no;
	}
	public void setDir(NoArv3 no){
		this.dir = no;
	}
	public void setInfo(Item3 elem){
		this.info = elem;
	}
}

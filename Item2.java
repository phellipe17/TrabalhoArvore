package arvore;

public class Item2 {
	private int chave;
	private String time;
	// aqui podem ser declarados outros atributos conforme sua necessidade.
	//Construtor de objetos da classe Item
	public Item2(int ch, String tim) {
		this.chave = ch;
		this.time=tim;
	}
	//Modifica o valor do atributo chave
	public void setChave (int ch){
		this.chave = ch;
	}
	//Faz a leitura do valor do atributo chave
	public int getChave (){
		return this.chave;
	}
	
	public void setTime(String tim) {
		this.time=tim;
	}
	
	public String getTime() {
		return this.time;
	}
}

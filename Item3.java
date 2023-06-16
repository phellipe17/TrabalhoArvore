package arvore;

public class Item3 {
	private int chave;
	private String campeonato;
	private int ano;
	// aqui podem ser declarados outros atributos conforme sua necessidade.
	//Construtor de objetos da classe Item
	public Item3(int ch, String camp, int anu) {
		this.chave = ch;
		this.campeonato=camp;
		this.ano=anu;
	}
	//Modifica o valor do atributo chave
	public void setChave (char ch){
		this.chave = ch;
	}
	//Faz a leitura do valor do atributo chave
	public int getChave (){
		return this.chave;
	}
	
	public void setCampeonato(String camp) {
		this.campeonato=camp;
	}
	
	public String getCampeonato() {
		return this.campeonato;
	}
	
	public void setAno(int anu) {
		this.ano=anu;
	}
	
	public int getAno() {
		return this.ano;
	}
}

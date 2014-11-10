
public class Nodo {

	private Nodo pai, esquerda, direita;
	private Pessoa pessoa;
	private int valor;
	
	public Nodo(Pessoa pessoa){
		pai = esquerda = direita = null;
		this.pessoa = pessoa;
	}
	
	/*public Nodo(int valor){
		this.valor = valor;
	}*/
	
	public Nodo getPai() {
		return pai;
	}
	
	public Nodo getEsquerda() {
		return esquerda;
	}
	
	public Nodo getDireita() {
		return direita;
	}
	
	public void setPai(Nodo pai) {
		this.pai = pai;
	}

	public void setEsquerda(Nodo esquerda) {
		this.esquerda = esquerda;
	}

	public void setDireita(Nodo direita) {
		this.direita = direita;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}

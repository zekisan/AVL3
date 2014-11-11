
public class Nodo {

	private Nodo esquerda, direita;
	private Pessoa pessoa;
	private int valor;
	
	public Nodo(Pessoa pessoa){
		esquerda = direita = null;
		this.pessoa = pessoa;
	}

	public Nodo getEsquerda() {
		return esquerda;
	}
	
	public Nodo getDireita() {
		return direita;
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

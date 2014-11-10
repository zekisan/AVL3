
public class AVL2 {

	private Nodo raiz;
	private int contRotDireita, contRotEsquerda;
	
	public AVL2(){
		contRotDireita = contRotEsquerda = 0;
	}
	
	public void insere(int valor){
		Nodo novo = new Nodo(valor);
		if(raiz == null){
			raiz = novo;
		}else{
			raiz = insereAVL(raiz, novo);
		}
	}
	
	private Nodo insereAVL(Nodo atual, Nodo n){
		if(atual == null){
			atual = n;
			return atual;
		}else if(n.getValor() < atual.getValor()){
			atual.setEsquerda(insereAVL(atual.getEsquerda(),n));
			atual = balanceamento(atual);
		}else if(n.getValor() > atual.getValor()){
			atual.setDireita(insereAVL(atual.getDireita(), n));
			atual = balanceamento(atual);
		}
		return atual;
	}
	
	private Nodo balanceamento(Nodo atual){
		int fb = calculaFB(atual);
		if(fb > 1){
			if(calculaFB(atual.getEsquerda()) > 0){
				atual = rotacionaEE(atual);
			}else{
				atual = rotacionaED(atual);
			}
		}else if(fb < -1){
			if(calculaFB(atual.getDireita()) > 0){
				atual = rotacionaDE(atual);
			}else{
				atual = rotacionaDD(atual);
			}
		}
		return atual;
	}
	
	public int getAltura(Nodo atual){
		if(atual != null){
			return 1 + Math.max(getAltura(atual.getEsquerda()), getAltura(atual.getDireita()));
		}
		return 0; 
	}
	
	public int calculaFB(Nodo atual){
		return getAltura(atual.getEsquerda()) - getAltura(atual.getDireita());
	}
	
	private Nodo rotacionaDD(Nodo pai){
		Nodo temp = pai.getDireita();
		pai.setDireita(temp.getEsquerda());
		temp.setEsquerda(pai);
		contRotDireita++;
		return temp;
	}
	
	private Nodo rotacionaEE(Nodo pai){
		Nodo temp = pai.getEsquerda();
		pai.setEsquerda(temp.getDireita());
		temp.setDireita(pai);
		contRotEsquerda++;
		return temp;
	}
	
	private Nodo rotacionaED(Nodo pai){
		Nodo temp = pai.getEsquerda();
		pai.setEsquerda(rotacionaDD(temp));
		return rotacionaEE(pai);
	}
	
	private Nodo rotacionaDE(Nodo pai){
		Nodo temp = pai.getDireita();
		pai.setDireita(rotacionaEE(temp));
		return rotacionaDD(pai);
	}

	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
	
	public int totalRotacoes(){
		return contRotDireita + contRotEsquerda;
	}
}
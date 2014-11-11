
public class AVL {

	private Nodo raiz;
	private int contRotDireita, contRotEsquerda, contRotDupla, indiceAtributo, totalElementos;
	private boolean insercaoIndividual;
	
	public AVL(){
		contRotDireita = contRotEsquerda = contRotDupla = totalElementos = 0;
		insercaoIndividual = false;
	}
	
	public void insere(Pessoa pessoa){
		if(pessoa.atributoEscolhido(indiceAtributo) != null){
			Nodo novo = new Nodo(pessoa);
			if(raiz == null){
				raiz = novo;
			}else{
				raiz = insereAVL(raiz, novo);
			}
		}
	}
	
	private Nodo insereAVL(Nodo atual, Nodo n){
		if(atual == null){
			atual = n;
			return atual;
		}else if(n.getPessoa().atributoEscolhido(indiceAtributo).compareTo(atual.getPessoa().atributoEscolhido(indiceAtributo)) < 0){
			atual.setEsquerda(insereAVL(atual.getEsquerda(),n));
			atual = balanceamento(atual);
		}else if(n.getPessoa().atributoEscolhido(indiceAtributo).compareTo(atual.getPessoa().atributoEscolhido(indiceAtributo)) > 0){
			atual.setDireita(insereAVL(atual.getDireita(), n));
			atual = balanceamento(atual);
		}
		return atual;
	}
	
	private Nodo balanceamento(Nodo atual){
		int fb = calculaFB(atual);
		if(fb == 2){
			if(calculaFB(atual.getEsquerda()) == 1){
				atual = rotacionaEE(atual);
			}else{
				atual = rotacionaED(atual);
			}
		}else if(fb == -2){
			if(calculaFB(atual.getDireita()) == 1){
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
		contRotDupla++;
		return rotacionaEE(pai);
	}
	
	private Nodo rotacionaDE(Nodo pai){
		Nodo temp = pai.getDireita();
		pai.setDireita(rotacionaEE(temp));
		contRotDupla++;
		return rotacionaDD(pai);
	}
	
	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
	
	public int getContRotDireita() {
		return contRotDireita;
	}

	public int getContRotEsquerda() {
		return contRotEsquerda;
	}
	
	public void setContRotDireita(int contRotDireita) {
		this.contRotDireita = contRotDireita;
	}

	public void setContRotEsquerda(int contRotEsquerda) {
		this.contRotEsquerda = contRotEsquerda;
	}

	public int getContRotDupla() {
		return contRotDupla;
	}

	public void setContRotDupla(int contRotDupla) {
		this.contRotDupla = contRotDupla;
	}

	public boolean isInsercaoIndividual() {
		return insercaoIndividual;
	}

	public void setInsercaoIndividual(boolean insercaoIndividual) {
		this.insercaoIndividual = insercaoIndividual;
	}

	public int totalRotacoes(){
		return contRotDireita + contRotEsquerda + contRotDupla;
	}

	public int getIndiceAtributo() {
		return indiceAtributo;
	}

	public void setIndiceAtributo(int indiceAtributo) {
		this.indiceAtributo = indiceAtributo;
	}
	
	public void somaElemento(){
		totalElementos++;
	}
	
	public int getTotalElementos(){
		return totalElementos;
	}
}
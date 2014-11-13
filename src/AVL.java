
public class AVL {

	private Nodo raiz;
	private int contRotDireita, contRotEsquerda, contRotDupla, indiceAtributo, totalElementos;
	private boolean insercaoIndividual;
	
	public AVL(){
		contRotDireita = contRotEsquerda = contRotDupla = totalElementos = 0;
		insercaoIndividual = false;
	}
	
	public void insere(Pessoa pessoa){
		//se a chave escolhida nao tiver valor, nao insere
		if(pessoa.atributoEscolhido(indiceAtributo) != null){
			Nodo novo = new Nodo(pessoa);
			if(raiz == null){
				raiz = novo;
			}else{
				//a cada novo elemento, a raiz recebe o nodo retornado da insercao recursiva
				raiz = insereAVL(raiz, novo);
			}
		}
	}
	
	//insercao recursiva
	private Nodo insereAVL(Nodo atual, Nodo n){
		if(atual == null){
			//localizou a folha, insere o novo nodo
			atual = n;
			//ponto de parada da insercao recursiva
			return atual;
		}else{
			//comparacao de campos tipo String
			if(n.getPessoa().atributoEscolhido(indiceAtributo).getClass().equals(String.class)){
				if(((String)n.getPessoa().atributoEscolhido(indiceAtributo)).compareTo((String) atual.getPessoa().atributoEscolhido(indiceAtributo)) < 0){
					atual.setEsquerda(insereAVL(atual.getEsquerda(),n));
					atual = balanceamento(atual);
				}else if(((String)n.getPessoa().atributoEscolhido(indiceAtributo)).compareTo((String) atual.getPessoa().atributoEscolhido(indiceAtributo)) > 0){
					atual.setDireita(insereAVL(atual.getDireita(), n));
					atual = balanceamento(atual);
				}
			}else{
				//comparacao de campos tipos numericos (int ou long)
				if((Long)n.getPessoa().atributoEscolhido(indiceAtributo) < (Long)atual.getPessoa().atributoEscolhido(indiceAtributo)){
					atual.setEsquerda(insereAVL(atual.getEsquerda(),n));
					atual = balanceamento(atual);
				}else if((Long)n.getPessoa().atributoEscolhido(indiceAtributo) > (Long)atual.getPessoa().atributoEscolhido(indiceAtributo)){
					atual.setDireita(insereAVL(atual.getDireita(), n));
					atual = balanceamento(atual);
				}
			}
		}
		//nova raiz da arvore (resultado do balanceamento)
		return atual;
	}
	
	//verifica se o nodo atual quebrou a regra AVL
	private Nodo balanceamento(Nodo atual){
		int fb = calculaFB(atual);
		if(fb == 2){
			if(calculaFB(atual.getEsquerda()) == 1){
				//perna para a esquerda, o filho a esquerda tem FB 1, entao rotaciona o pai (atual) para a direita
				atual = rotacaoLadoEsquerdo(atual);
			}else{
				//joelho para a esquerda, rotaciona para o lado direito
				atual = rotacaoDuplaDireita(atual);
			}
		}else if(fb == -2){
			if(calculaFB(atual.getDireita()) == 1){
				//joelho para a direita, o filho a direita tem FB 1, entao rotaciona o pai (atual) duplamente para a esquerda
				atual = rotacaoDuplaEsquerda(atual);
			}else{
				//perna para a direita, rotaciona para o lado esquerdo
				atual = rotacaoLadoDireito(atual);
			}
		}
		return atual;
	}
	
	//calculo recursivo da altura
	public int getAltura(Nodo atual){
		if(atual != null){
			return 1 + Math.max(getAltura(atual.getEsquerda()), getAltura(atual.getDireita()));
		}
		//ponto de parada da recursao, retorna zero se for folha (nao tem filhos)
		return 0; 
	}
	
	public int calculaFB(Nodo atual){
		return getAltura(atual.getEsquerda()) - getAltura(atual.getDireita());
	}
	
	//efetua rotacao simples para a esquerda
	private Nodo rotacaoLadoDireito(Nodo pai){
		//o temporario recebe a direita do pai
		Nodo temp = pai.getDireita();
		//pai recebe nulo a direita, pois o pai sera rotacionado a esquerda do seu filho da direita 
		pai.setDireita(temp.getEsquerda());
		temp.setEsquerda(pai);
		contRotDireita++;
		return temp;
	}
	
	//efetua rotacao simples para a direita
	private Nodo rotacaoLadoEsquerdo(Nodo pai){
		//o temporario recebe a esquerda do pai
		Nodo temp = pai.getEsquerda();
		//pai recebe nulo a esquerda, pois o pai sera rotacionado a direita do seu filho da esquerda 
		pai.setEsquerda(temp.getDireita());
		temp.setDireita(pai);
		contRotEsquerda++;
		return temp;
	}
	
	//efetua uma rotacao para cada lado
	private Nodo rotacaoDuplaDireita(Nodo pai){
		//o temporario recebe o filho da esquerda do pai
		Nodo temp = pai.getEsquerda();
		//rotaciona o temporario para a esquerda e seta o resultado a esquerda do pai
		pai.setEsquerda(rotacaoLadoDireito(temp));
		contRotDupla++;
		//rotaciona o pai para a direita
		return rotacaoLadoEsquerdo(pai);
	}
	
	//efetua uma rotacao para cada lado
	private Nodo rotacaoDuplaEsquerda(Nodo pai){
		//o temporario recebe o filho da direita do pai
		Nodo temp = pai.getDireita();
		//rotaciona o temporario para a direita e seta o resultado a direita do pai
		pai.setDireita(rotacaoLadoEsquerdo(temp));
		contRotDupla++;
		//rotaciona o pai para a esquerda
		return rotacaoLadoDireito(pai);
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
	
	public boolean estaVazia(){
		return raiz == null;
	}
	
	public void esvaziaContadores(){
		contRotDireita = contRotEsquerda = contRotDupla = 0;
	}
}
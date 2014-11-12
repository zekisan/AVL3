import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		AVL avl = new AVL();
		int op = 0;
		while (op != 3) {
			menuPrincipal();
			try {
				Scanner ler = new Scanner(System.in);
				op = ler.nextInt();
				switch (op) {
				case 1:
					insereDadosArquivo(avl);
					qtdRotacoes(avl);
					break;
				case 2:
					insercaoIndividual(avl);
					qtdRotacoes(avl);
					break;
				case 3:
					System.exit(0);
				default:
					System.out.println("Opcao invalida!\n");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Opcao invalida!\n");
				
			}
		}
	}

	private static void qtdRotacoes(AVL avl) {
		System.out.println("Rotacoes a direita: "+avl.getContRotDireita());
		System.out.println("Rotacoes a esquerda: "+avl.getContRotEsquerda());
		System.out.println("Rotacoes duplas: "+avl.getContRotDupla());
		System.out.println("Total de rotacoes: "+avl.totalRotacoes());
		System.out.println("-----------------------------------------------\n");
	}

	private static void insereDadosArquivo(AVL avl) {
		ControladorArquivo.leArquivo(avl,escolheAtributo());
		System.out.println("Altura: "+avl.getAltura(avl.getRaiz()));
		System.out.println("Raiz: "+avl.getRaiz().getPessoa().atributoEscolhido(avl.getIndiceAtributo()));
	}

	private static void menuPrincipal() {
		System.out.println("Digite o numero da opcao desejada:");
		System.out.println("1 - Inserir dados na AVL");
		System.out.println("2 - Inserir novo registro");
		System.out.println("3 - Pesquisa pessoa");
		System.out.println("4 - Sair");
		System.out.println("-----------------------------------------------");
	}

	private static void insercaoIndividual(AVL avl) {
		Scanner ler2 = new Scanner(System.in);
		System.out.println("Digite os dados separados por ; (não digite o ID!!)");
		String linha = ler2.nextLine(); 
		String[] p = ("0;"+linha).split(";");
		avl.setInsercaoIndividual(true);
		avl.setContRotDireita(0);
		avl.setContRotEsquerda(0);
		avl.setIndiceAtributo(escolheAtributo());
		avl.insere(ControladorPessoa.cadastraPessoa(p,avl.isInsercaoIndividual(),avl.getTotalElementos()+1));
		avl.somaElemento();
	}

	private static int escolheAtributo(){
		System.out.println("Escolha o atributo chave:");
		System.out.println("0 - id");
		System.out.println("1 - nome");
		System.out.println("2 - cpf");
		System.out.println("3 - logradouro");
		System.out.println("4 - numero");
		System.out.println("5 - complemento");
		System.out.println("6 - telefone residencial");
		System.out.println("7 - telefone celular");
		
		Scanner ler = new Scanner(System.in);
		return ler.nextInt();
	}
}
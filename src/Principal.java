import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		AVL avl = new AVL();
		int op = 0;
		while (op != 3) {
			System.out.println("Digite o numero da opcao desejada:");
			System.out.println("1 - Inserir dados na AVL");
			System.out.println("2 - Inserir novo registro");
			System.out.println("3 - Sair");
			System.out.println("-----------------------------------------------");
			try {
				op = ler.nextInt();
				switch (op) {
				case 1:
					ControladorArquivo.leArquivo(avl);
					System.out.println("Rotacoes a direita: "+avl.getContRotDireita());
					System.out.println("Rotacoes a esquerda: "+avl.getContRotEsquerda());
					System.out.println("Total de rotacoes: "+avl.totalRotacoes());
					System.out.println("-----------------------------------------------");
					break;
				case 2:
					Scanner ler2 = new Scanner(System.in);
					System.out.println("Digite os dados separados por ;");
					String linha = ler2.nextLine(); 
					String[] p = linha.split(";");
					avl.setInsercaoIndividual(true);
					avl.insere(ControladorPessoa.cadastraPessoa(p));
					break;
				case 3:
					System.exit(0);
				default:
					System.out.println("Opcao invalida!");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Opcao invalida!");
				op = 0;
			}
		}

		// int[] valores = {1,2,3,4,5,6,7,9,8};
		// AVL avl = new AVL();
		// AVL2 avl = new AVL2();
		// for (int i = 0; i < valores.length; i++) {
		// avl.inserePessoa(valores[i]);
		// avl.insere(valores[i]);
		// }
		System.out.println(avl.getAltura(avl.getRaiz()));
	}

}

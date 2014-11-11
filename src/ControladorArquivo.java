import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ControladorArquivo {

	private static String arquivo = "src/dados.txt";
	private static BufferedReader br = null;
	private static String linha = "";
	private static String separador = ";";
	//private static AVL avl = new AVL();
	
	public static void leArquivo(AVL avl, int indice){
		try {
			br = new BufferedReader(new FileReader(arquivo));
			while ((linha = br.readLine()) != null) {
				String[] p = linha.split(separador);
				avl.setIndiceAtributo(indice);
				avl.insere(ControladorPessoa.cadastraPessoa(p,avl.isInsercaoIndividual(),0));
				avl.somaElemento();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

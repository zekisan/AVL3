
public class ControladorPessoa {

	public static Pessoa cadastraPessoa(String[] p, boolean insercaoIndividual, int novoId){
		Pessoa pessoa = new Pessoa();
		if(!p[0].equals("")){
			if(insercaoIndividual){
				pessoa.setID(String.valueOf(novoId));
			}else{
				pessoa.setID(p[0]);
			}
		}
		if(!p[1].equals("")) pessoa.setNome(p[1]);
		if(!p[2].equals("")) pessoa.setCpf(p[2]);
		if(!p[3].equals("")) pessoa.setLogradouro(p[3]);
		if(!p[4].equals("")) pessoa.setNumero(p[4]);
		if(!p[5].equals("")) pessoa.setComplemento(p[5]);
		if(!p[6].equals("")) pessoa.setTelResidencial(p[6]);
		if(!p[7].equals("")) pessoa.setTelCelular(p[7]);
		return pessoa;
	}
	
}

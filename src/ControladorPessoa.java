
public class ControladorPessoa {

	public static Pessoa cadastraPessoa(String[] p, boolean insercaoIndividual, int novoId){
		Pessoa pessoa = new Pessoa();
		if(!p[0].equals("")){
			if(insercaoIndividual){
				pessoa.setID(novoId);
			}else{
				pessoa.setID(Integer.valueOf(p[0]));
			}
		}
		if(!p[1].equals("")) pessoa.setNome(p[1]);
		if(!p[2].equals("")) pessoa.setCpf(Long.valueOf(p[2].replace("-", "").replace(".", "")).longValue());
		if(!p[3].equals("")) pessoa.setLogradouro(p[3]);
		if(!p[4].equals("")) pessoa.setNumero(Integer.valueOf(p[4]));
		if(!p[5].equals("")) pessoa.setComplemento(p[5]);
		if(!p[6].equals("")) pessoa.setTelResidencial(Long.valueOf(p[6].replace("-", "")).longValue());
		if(!p[7].equals("")) pessoa.setTelCelular(Long.valueOf(p[7].replace("-", "")).longValue());
		return pessoa;
	}
	
}

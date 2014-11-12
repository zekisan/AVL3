public class Pessoa {

	private long ID, numero, cpf, telResidencial, telCelular;
	private String nome; 
	private String logradouro;
	private String complemento;

	public long getID() {
		return ID;
	}

	public String getNome() {
		return nome;
	}

	public long getCpf() {
		return cpf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public long getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public long getTelResidencial() {
		return telResidencial;
	}

	public long getTelCelular() {
		return telCelular;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setTelResidencial(long telResidencial) {
		this.telResidencial = telResidencial;
	}

	public void setTelCelular(long telCelular) {
		this.telCelular = telCelular;
	}
	
	public Object atributoEscolhido(int indice){
		switch (indice) {
		case 0:
			return getID();
		case 1:
			return getNome();
		case 2:
			return getCpf();
		case 3:
			return getLogradouro();
		case 4:
			return getNumero();
		case 5:
			return getComplemento();
		case 6:
			return getTelResidencial();
		case 7:
			return getTelCelular();
		default:
			return null;
		}
	}
}

public class Pessoa {

	private int ID;
	private String nome;
	private long cpf;
	private String logradouro;
	private int numero;
	private String complemento, telResidencial, telCelular;

	public int getID() {
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

	public int getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getTelResidencial() {
		return telResidencial;
	}

	public String getTelCelular() {
		return telCelular;
	}

	public void setID(int iD) {
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

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setTelResidencial(String telResidencial) {
		this.telResidencial = telResidencial;
	}

	public void setTelCelular(String telCelular) {
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

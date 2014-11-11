public class Pessoa {

	private String ID, nome, cpf, logradouro, numero, complemento, telResidencial, telCelular;

	public String getID() {
		return ID;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getNumero() {
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

	public void setID(String iD) {
		ID = iD;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setNumero(String numero) {
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
	
	public String atributoEscolhido(int indice){
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

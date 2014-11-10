public class Pessoa {

	private int ID;
	private String nome;
	private long cpf;
	private String logradouro;
	private int numero;
	private String complemento;
	private long telResidencial;
	private long telCelular;

	public Pessoa() {
		//int id, String nome, int cpf, String logradouro, int numero,
		//int complemento, int telResidencial, int telCelular
		/*this.ID = id;
		this.nome = nome;
		this.cpf = cpf;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.telResidencial = telResidencial;
		this.telCelular = telCelular;*/
	}

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

	public long getTelResidencial() {
		return telResidencial;
	}

	public long getTelCelular() {
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

	public void setTelResidencial(long telResidencial) {
		this.telResidencial = telResidencial;
	}

	public void setTelCelular(long telCelular) {
		this.telCelular = telCelular;
	}
}

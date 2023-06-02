package entity;

public class Tipo {
	private int id;
	private String nome;
	private String modulo;
	
	public Tipo(String nome, String modulo) {
		super();
		this.nome = nome;
		this.modulo = modulo;
	}

	public Tipo() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id = id;
	}
}

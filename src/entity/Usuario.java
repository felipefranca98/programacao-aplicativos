package entity;



public class Usuario {
	private int id;
	private String login;
	private String senha;
	private int log = 0;
	
	public Usuario() {
		
	}
	
	public Usuario(String login, String senha) {		
		this.login = login;
		this.senha = senha;	
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	public int getLog() {
		// TODO Auto-generated method stub
		return log;
	}
	
	public void setLog(int log) {
		// TODO Auto-generated method stub
		this.log = log;
	}
}

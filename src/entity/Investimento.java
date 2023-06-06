package entity;

public class Investimento {

	private int user;
	private int id;
	private int mes;
	private int ano;
	private String investimento;
	private double mensal;
	private double ocasional;
	private double total;
	
	
	public Investimento() {
		
	}

	public Investimento(int mes, int ano, String investimento, double mensal, double ocasional, double total) {
		super();
		this.mes = mes;
		this.ano = ano;
		this.investimento = investimento;
		this.mensal = mensal;
		this.ocasional = ocasional;
		this.total = total;
	}


	public int getMes() {
		return mes;
	}


	public void setMes(int mes) {
		this.mes = mes;
	}


	public int getAno() {
		return ano;
	}


	public void setAno(int ano) {
		this.ano = ano;
	}


	public String getInvestimento() {
		return investimento;
	}


	public void setInvestimento(String investimento) {
		this.investimento = investimento;
	}


	public double getMensal() {
		return mensal;
	}


	public void setMensal(double mensal) {
		this.mensal = mensal;
	}


	public double getOcasional() {
		return ocasional;
	}


	public void setOcasional(double ocasional) {
		this.ocasional = ocasional;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}
	

	public int getUser() {
		return user;
	}


	public void setUser(int user) {
		this.user = user;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
}

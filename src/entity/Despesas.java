package entity;

public class Despesas {


	private int id;	
	private int user;
	private int mes;
	private int ano;
	private String categoria;
	private String despesa;
	private double mensal = 0.0;
	private double ocasional = 0.0;
	private double total = 0.0;
	
	public Despesas(int mes, int ano, String categoria, String despesa, double mensal, double ocasional, double total) {
		super();
		this.mes = mes;
		this.ano = ano;
		this.categoria = categoria;
		this.despesa = despesa;
		this.mensal = mensal;
		this.ocasional = ocasional;
		this.total = total;
	}

	public Despesas() {
		// TODO Auto-generated constructor stub
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDespesa() {
		return despesa;
	}

	public void setDespesa(String despesa) {
		this.despesa = despesa;
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
	
	
}

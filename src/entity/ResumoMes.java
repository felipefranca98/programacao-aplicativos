package entity;

public class ResumoMes {

	private int id;
	private int user;
	private int mes;
	private int ano;
	private double rendimento;
	private double investimento;
	private double despesa;
	private double valorDisponivelMes;
	private double valorDespesasMes;
	private double total;

	public ResumoMes() {
		
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

	public double getRendimento() {
		return rendimento;
	}

	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}

	public double getInvestimento() {
		return investimento;
	}

	public void setInvestimento(double investimento) {
		this.investimento = investimento;
	}

	public double getDespesa() {
		return despesa;
	}

	public void setDespesa(double despesa) {
		this.despesa = despesa;
	}

	public double getValorDisponivelMes() {
		return valorDisponivelMes;
	}

	public void setValorDisponivelMes(double valorDisponivelMes) {
		this.valorDisponivelMes = valorDisponivelMes;
	}

	public double getValorDespesasMes() {
		return valorDespesasMes;
	}

	public void setValorDespesasMes(double valorDespesasMes) {
		this.valorDespesasMes = valorDespesasMes;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}

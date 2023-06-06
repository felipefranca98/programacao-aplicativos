package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.ResumoAnoDAO;
import entity.Rendimento;
import entity.ResumoAno;

public class ResumoAnoService {

	
	private ResumoAnoDAO resumoAnoDAO;

	public ResumoAnoService() {
		this.resumoAnoDAO = new ResumoAnoDAO(null);
    }	

	
	public double buscarTotalDisponivelAnoResumoAno(ResumoAno resumo) {
		double retorno;
		retorno = resumo.getRendimentoTotal() - resumo.getInvestimentoTotal();
		return retorno;
			
	}

	
	public double buscarTotalRestanteResumoAno(ResumoAno resumo) {
		double retorno;
		retorno = resumo.getValorDisponivelAno() - resumo.getValorDespesasMes();
		retorno = retorno - resumo.getTotalDespesasOcasionais();
		return retorno;
	}
	
	public boolean cadastrarResumoAno(ResumoAno resumo) throws SQLException, IOException {
		
		System.out.println("\t Cadastrar Resumo Ano");

		Connection conn = BancoDados.conectar();
		


		List<ResumoAno> retorno = new ResumoAnoDAO(conn).buscarResumoAno(resumo);
		
		if(retorno.size() == 0)
		{	
		System.out.println("\t Vorto nulo Cadastrar Resumo Ano");

		
		List<ResumoAno> rendimento = new ResumoAnoDAO(conn).buscarRendimentoResumoAno(resumo);
		double rendimentosTotal = 0;
		double rendimentosMensal = 0;
		double rendimentosOcasional = 0;
		for (ResumoAno categoria1 : rendimento) {
				rendimentosTotal = rendimentosTotal + categoria1.getRendimentoTotal(); 
				rendimentosMensal = rendimentosMensal + categoria1.getRendimentoMensal(); 
				rendimentosOcasional = rendimentosOcasional + categoria1.getRendimentoOcasional(); 
		}
			resumo.setRendimentoTotal(rendimentosTotal);
			resumo.setRendimentoMensal(rendimentosMensal);
			resumo.setRendimentoOcasional(rendimentosOcasional);
		
			System.out.println("\t Inseriu os Rendimentos");
			
			List<ResumoAno> investimento = new ResumoAnoDAO(conn).buscarInvestimentoResumoAno(resumo);
			double investimentosTotal = 0;
			double investimentosMensal = 0;
			double investimentosOcasional = 0;
			for (ResumoAno categoria1 : investimento) {
				investimentosTotal = investimentosTotal + categoria1.getInvestimentoTotal(); 
				investimentosMensal = investimentosMensal + categoria1.getInvestimentoMensal(); 
				investimentosOcasional = investimentosOcasional + categoria1.getInvestimentoOcasional(); 
			}
			
				resumo.setInvestimentoTotal(investimentosTotal);
				resumo.setInvestimentoMensal(investimentosMensal);
				resumo.setInvestimentoOcasional(investimentosOcasional);
			
				System.out.println("\t Inseriu os Investimentos");
			
		List<ResumoAno> fundoDespesas = new ResumoAnoDAO(conn).buscarFundoDespesaResumoAno(resumo);
		double fundoDespesasTotal = 0;
		double fundoDespesasMensal = 0;
		double fundoDespesasOcasional = 0;
		for (ResumoAno categoria1 : fundoDespesas) {
			fundoDespesasTotal = fundoDespesasTotal + categoria1.getFundoDespesaTotal(); 
			fundoDespesasMensal = fundoDespesasMensal + categoria1.getFundoDespesaMensal(); 
			fundoDespesasOcasional = fundoDespesasOcasional + categoria1.getFundoDespesaOcasional(); 
		}
		
			resumo.setFundoDespesaTotal(fundoDespesasTotal);
			resumo.setFundoDespesaMensal(fundoDespesasMensal);
			resumo.setFundoDespesaOcasional(fundoDespesasOcasional);
			
			System.out.println("\t Inseriu Fundo de Despesas Ocasionais");
			
			double totalDisponivelAno = buscarTotalDisponivelAnoResumoAno(resumo);
			
				resumo.setValorDisponivelAno(totalDisponivelAno);
			
				List<Double> totalDespesasMes = new ResumoAnoDAO(conn).buscarTotalDespesasMesAnoResumoAno(resumo);
				double totalMes = 0;
				for (Double categoria1 : totalDespesasMes) {
						totalMes = totalMes + categoria1.doubleValue(); 
				}
				
					resumo.setValorDespesasMes(totalMes);
					System.out.println("\t Inseriu Disponivel Ano");
				
					List<Double> totalDespesasOcasionais = new ResumoAnoDAO(conn).buscarTotalDespesasOcasionaisResumoAno(resumo);
					double totalOcasionais = 0;
					for (Double categoria1 : totalDespesasOcasionais) {
							totalOcasionais = totalOcasionais + categoria1.doubleValue(); 
					}
					
						resumo.setTotalDespesasOcasionais(totalOcasionais);
						
						System.out.println("\t Inseriu Total de Despesas Ocasionais");
						
						double totalRestante = buscarTotalRestanteResumoAno(resumo);
						
							resumo.setTotalRestante(totalRestante);							
			
							System.out.println("\t Inseriu Total Restante");
							
			int retorno1 = new ResumoAnoDAO(conn).cadastrarResumoAno(resumo);
			if(retorno1 != 0)
			{
				System.out.println("\t Deu boa Casdastrar Resumo Ano ");

				int id = new ResumoAnoDAO(conn).buscarIdResumoAno(resumo);
				resumo.setId(id);
				System.out.println("Deu boa Cadastrar Resumo Ano" + resumo.getId());
				return true;
			}
				
		}
		else {
			for (ResumoAno categoria1 : retorno) {
				System.out.println("\t Vorto nao Nulo");

				
				if(categoria1.getAno() == resumo.getAno()) {
					System.out.println("\t Resumo ja existe");

					return false;
				}

			}

			int retorno1 = new ResumoAnoDAO(conn).cadastrarResumoAno(resumo);
			if(retorno1 != 0)
			{
				System.out.println("\t Deu boa cadastrar Resumo Ano");

				int id = new ResumoAnoDAO(conn).buscarIdResumoAno(resumo);
				resumo.setId(id);
				System.out.println("Deu boa Cadastrar Resumo ano" + resumo.getId());
				

				return true;
			}
		
		}
		return false;

	}
	
	/*	public boolean editarResumoAno(ResumoAno resumo) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();

		System.out.println("\t u");

		
List<ResumoAno> retorno = new ResumoAnoDAO(conn).buscarResumoAno(resumo);
		
		if(retorno == null )
		{	System.out.println("\t u");

		
		List<Double> rendimento = new ResumoAnoDAO(conn).buscarRendimentoResumoAno(resumo);
		double rendimentos = 0;
		for (Double categoria1 : rendimento) {
				rendimentos = rendimentos + categoria1.doubleValue(); 
		}
		
			resumo.setRendimento(rendimentos);
		
			List<Double> investimento = new ResumoAnoDAO(conn).buscarInvestimentoResumoAno(resumo);
			double investimentos = 0;
			for (Double categoria1 : investimento) {
					investimentos = investimentos + categoria1.doubleValue(); 
			}
			
				resumo.setInvestimento(investimentos);
		
			
			
		List<Double> despesa = new ResumoAnoDAO(conn).buscarFundoDespesaResumoAno(resumo);
		double fundoDespesas = 0;
		for (Double categoria1 : despesa) {
				fundoDespesas = fundoDespesas + categoria1.doubleValue(); 
		}
		
			resumo.setFundoDespesa(fundoDespesas);
		
			
			List<Double> totalDisponivelAno = new ResumoAnoDAO(conn).buscarTotalDisponivelAnoResumoAno(resumo);
			double totalAno = 0;
			for (Double categoria1 : totalDisponivelAno) {
					totalAno = totalAno + categoria1.doubleValue(); 
			}
			
				resumo.setValorDisponivelAno(totalAno);
			
				List<Double> totalDespesasMes = new ResumoAnoDAO(conn).buscarTotalDespesasMesAnoResumoAno(resumo);
				double totalMes = 0;
				for (Double categoria1 : totalDespesasMes) {
						totalMes = totalMes + categoria1.doubleValue(); 
				}
				
					resumo.setValorDespesasMes(totalMes);
				
				
					List<Double> totalDespesasOcasionais = new ResumoAnoDAO(conn).buscarTotalDespesasOcasionaisResumoAno(resumo);
					double totalOcasionais = 0;
					for (Double categoria1 : totalDespesasOcasionais) {
							totalOcasionais = totalOcasionais + categoria1.doubleValue(); 
					}
					
						resumo.setTotalDespesasOcasionais(totalOcasionais);
						
						List<Double> totalRestante = new ResumoAnoDAO(conn).buscarTotalRestanteResumoAno(resumo);
						double restante = 0;
						for (Double categoria1 : totalRestante) {
								restante = restante + categoria1.doubleValue(); 
						}
						
							resumo.setTotalRestante(restante);							

		
		int retorno1 = new ResumoAnoDAO(conn).editarResumoAno(resumo);
		if(retorno1 != 0)
		{
			return true;
		}
	}
		return false;
	
 }
	*/
	
	
}

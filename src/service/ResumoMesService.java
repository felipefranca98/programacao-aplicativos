package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.ResumoMesDAO;
import entity.Rendimento;
import entity.ResumoMes;

public class ResumoMesService {

	
	private ResumoMesDAO resumoMesDAO;

	public ResumoMesService() {
		this.resumoMesDAO = new ResumoMesDAO(null);
    }	

	
	public double buscarTotalDisponivelMesResumo(ResumoMes resumo) {
		double retorno;
		retorno = resumo.getRendimento();
		retorno = retorno- (resumo.getInvestimento() + resumo.getDespesa());
		return retorno;
			
	}

	
	public double buscarTotalRestanteResumoMes(ResumoMes resumo) {
		double retorno;
		retorno = resumo.getValorDisponivelMes() - resumo.getValorDespesasMes();
		return retorno;
	}
	
	public boolean cadastrarResumoMes(ResumoMes resumo) throws SQLException, IOException {
		
		System.out.println("\t Cadastrar Resumo Mes");

		Connection conn = BancoDados.conectar();
		


		List<ResumoMes> retorno = new ResumoMesDAO(conn).buscarResumoMes(resumo);
		
		if(retorno.size() == 0)
		{	
		System.out.println("\t Vorto nulo Cadastrar Resumo Mes");

		
		List<ResumoMes> rendimentoMes = new ResumoMesDAO(conn).buscarRendimentoMensalResumoMes(resumo);
		double rendimentosM = 0;
		for (ResumoMes categoria1 : rendimentoMes) {
				rendimentosM = rendimentosM + categoria1.getRendimento(); 
		}
			
		List<ResumoMes> rendimentoOcasional = new ResumoMesDAO(conn).buscarRendimentoOcasionalResumoMes(resumo);
		double rendimentosO = 0;
		for (ResumoMes categoria1 : rendimentoOcasional) {
				rendimentosO = rendimentosO + categoria1.getRendimento(); 
		}
			resumo.setRendimento(rendimentosM + rendimentosO);
		
			System.out.println("\t Inseriu os Rendimentos");
			
			List<ResumoMes> investimentoMes = new ResumoMesDAO(conn).buscarInvestimentoMensalResumoMes(resumo);
			double investimentoM = 0;
			for (ResumoMes categoria1 : investimentoMes) {
				investimentoM = investimentoM + categoria1.getInvestimento(); 
			}
				
			List<ResumoMes> investimentoOcasional = new ResumoMesDAO(conn).buscarInvestimentoOcasionalResumoMes(resumo);
			double investimentoO = 0;
			for (ResumoMes categoria1 : investimentoOcasional) {
				investimentoO = investimentoO + categoria1.getInvestimento(); 
			}
				resumo.setInvestimento(investimentoM + investimentoO);
				
				System.out.println("\t Inseriu os Investimentos");
			
		
		List<ResumoMes> fundoDespesasMes = new ResumoMesDAO(conn).buscarFundoDespesaMensalResumoMes(resumo);
		double fundoDespesasM = 0;
		for (ResumoMes categoria1 : fundoDespesasMes) {
			fundoDespesasM = fundoDespesasM + categoria1.getDespesa(); 
		}
			
		List<ResumoMes> fundoDespesasOcasional = new ResumoMesDAO(conn).buscarFundoDespesaOcasionalResumoMes(resumo);
		double fundoDespesasO = 0;
		for (ResumoMes categoria1 : fundoDespesasOcasional) {
			fundoDespesasO = fundoDespesasO + categoria1.getDespesa(); 
		}
			resumo.setDespesa(fundoDespesasM + fundoDespesasO);
			
			
			System.out.println("\t Inseriu Fundo de Despesas Ocasionais");
			
			double totalDisponivelMes = buscarTotalDisponivelMesResumo(resumo);
			
			resumo.setValorDisponivelMes(totalDisponivelMes);
			
			System.out.println("\t Inseriu Disponivel Mes");
			
			
				List<Double> totalDespesasM = new ResumoMesDAO(conn).buscarTotalDespesasMensalResumoMes(resumo);
				double totalM = 0;
				for (Double categoria1 : totalDespesasM) {
						totalM = totalM + categoria1.doubleValue(); 
				}
				
				List<Double> totalDespesasO = new ResumoMesDAO(conn).buscarTotalDespesasOcasionalResumoMes(resumo);
				double totalO = 0;
				for (Double categoria1 : totalDespesasO) {
						totalO = totalO + categoria1.doubleValue(); 
				}
				
				
					resumo.setValorDespesasMes(totalM + totalO);
					System.out.println("\t Inseriu Despesas Mes");
				
						
						double totalRestante = buscarTotalRestanteResumoMes(resumo);
						
							resumo.setTotal(totalRestante);							
			
							System.out.println("\t Inseriu Total Restante");
							
			int retorno1 = new ResumoMesDAO(conn).cadastrarResumoMes(resumo);
			if(retorno1 != 0)
			{
				System.out.println("\t Deu boa Casdastrar Resumo Mes ");

				int id = new ResumoMesDAO(conn).buscarIdResumoMes(resumo);
				resumo.setId(id);
				System.out.println("Deu boa Cadastrar Resumo Mes" + resumo.getId());
				return true;
			}
				
		}
		else {
			for (ResumoMes categoria1 : retorno) {
				System.out.println("\t Vorto nao Nulo");

				
				if(categoria1.getAno() == resumo.getAno()) {
					System.out.println("\t Resumo ja existe");

					return false;
				}

			}

			int retorno1 = new ResumoMesDAO(conn).cadastrarResumoMes(resumo);
			if(retorno1 != 0)
			{
				System.out.println("\t Deu boa cadastrar Resumo Mes");

				int id = new ResumoMesDAO(conn).buscarIdResumoMes(resumo);
				resumo.setId(id);
				System.out.println("Deu boa Cadastrar Resumo mes" + resumo.getId());
				

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

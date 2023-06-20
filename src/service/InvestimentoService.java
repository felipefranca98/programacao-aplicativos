package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.InvestimentoDAO;
import entity.Investimento;

public class InvestimentoService {

	
	private InvestimentoDAO investimentoDAO;

	public InvestimentoService() {
		this.investimentoDAO = new InvestimentoDAO(null);
    }	

	public boolean cadastrarInvestimento(Investimento investimento) throws SQLException, IOException {
		
		System.out.println("\t Cadastrar Investimento");

		Connection conn = BancoDados.conectar();
		
		if(investimento.getMensal() != 0.0)
		{
			investimento.setTotal(investimento.getMensal()*12);
		}
		if(investimento.getOcasional() != 0.0)
		{
			investimento.setTotal(investimento.getOcasional());
		}

		List<Investimento> retorno = new InvestimentoDAO(conn).buscarInvestimento(investimento.getUser());
		
		if(retorno == null )
		{	System.out.println("\t Vorto nulo Cadastrar Investimento");

			int retorno1 = new InvestimentoDAO(conn).cadastrarInvestimento(investimento);
			if(retorno1 != 0)
			{
				System.out.println("\t Deu Boa Cadastrar Rendiemnto");

				int id = new InvestimentoDAO(conn).buscarIdInvestimento(investimento);
				investimento.setId(id);
				System.out.println("Deu boa Cadastrar Rendimento" + investimento.getId());
				return true;
			}
				
		}
		else {
			for (Investimento categoria1 : retorno) {
				System.out.println("\t Vorto nao nulo");

				
				if(categoria1.getInvestimento().toLowerCase().equals(investimento.getInvestimento().toLowerCase())) {
					System.out.println("\t Investimento ja existe");

					return false;
				}

			}

			int retorno1 = new InvestimentoDAO(conn).cadastrarInvestimento(investimento);
			if(retorno1 != 0)
			{
				System.out.println("\t Deu boa cadastrar Investimento");

				int id = new InvestimentoDAO(conn).buscarIdInvestimento(investimento);
				investimento.setId(id);
				System.out.println("Deu boa Cadastrar Investimento" + investimento.getId());
				

				return true;
			}
		
		}
		return false;

	}

public List<Investimento> buscarInvestimento(int id) throws SQLException, IOException {
		


		Connection conn = BancoDados.conectar();
		System.out.println("\t Buscar Investimento");		

		List<Investimento> retorno = new InvestimentoDAO(conn).buscarInvestimento(id);
		
				return retorno;

	}

	
	public boolean editarInvestimento(Investimento investimento) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		
		if(investimento.getMensal() != 0.0)
		{
			investimento.setTotal(investimento.getMensal()*12);
		}
		if(investimento.getOcasional() != 0.0)
		{
			investimento.setTotal(investimento.getOcasional());
		}
		
		int retorno = new InvestimentoDAO(conn).editarInvestimento(investimento);
		if(retorno != 0)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean excluirInvestimento(Investimento investimento) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		
		int retorno = new InvestimentoDAO(conn).excluirInvestimento(investimento.getId());
		if(retorno != 0)
		{
			return true;
		}
		
		return false;
	}
	
}

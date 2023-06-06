package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.DespesasDAO;
import entity.Despesas;

public class DespesasService {

	
	private DespesasDAO despesasDAO;

	public DespesasService() {
		this.despesasDAO = new DespesasDAO(null);
    }	

	public boolean cadastrarDespesa(Despesas despesa) throws SQLException, IOException {
		
		System.out.println("\t Cadastrar Despesas");

		Connection conn = BancoDados.conectar();
		
		if(despesa.getMensal() != 0.0)
		{
			despesa.setTotal(despesa.getMensal()*12);
		}
		if(despesa.getOcasional() != 0.0)
		{
			despesa.setTotal(despesa.getOcasional());
		}

		List<Despesas> retorno = new DespesasDAO(conn).buscarDespesa(despesa);
		
		if(retorno == null )
		{	System.out.println("\t Vorto Nulo Cadastrar Despesas");

			int retorno1 = new DespesasDAO(conn).cadastrarDespesa(despesa);
			if(retorno1 != 0)
			{
				System.out.println("\t Deu boa Cadastrar Despesas");

				int id = new DespesasDAO(conn).buscarIdDespesa(despesa);
				despesa.setId(id);
				System.out.println("Deu boa Cadastrar Despesas" + despesa.getId());
				return true;
			}
				
		}
		else {
			for (Despesas categoria1 : retorno) {
				System.out.println("\t Vorto nao nulo");

				
				if(categoria1.getDespesa().toLowerCase().equals(despesa.getDespesa().toLowerCase())) {
					System.out.println("\t Despesa ja cadasatrada");

					return false;
				}

			}

			int retorno1 = new DespesasDAO(conn).cadastrarDespesa(despesa);
			if(retorno1 != 0)
			{
				System.out.println("\t Deu Boa Cadastrar Despesa");

				int id = new DespesasDAO(conn).buscarIdDespesa(despesa);
				despesa.setId(id);
				System.out.println("Deu boa Cadastrar Despesa" + despesa.getId());
				

				return true;
			}
		
		}
		return false;

	}
	
	public boolean editarDespesa(Despesas despesa) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		
		if(despesa.getMensal() != 0.0)
		{
			despesa.setTotal(despesa.getMensal()*12);
		}
		if(despesa.getOcasional() != 0.0)
		{
			despesa.setTotal(despesa.getOcasional());
		}
		
		int retorno = new DespesasDAO(conn).editarDespesa(despesa);
		if(retorno != 0)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean excluirDespesa(Despesas despesa) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		
		int retorno = new DespesasDAO(conn).excluirDespesa(despesa.getId());
		if(retorno != 0)
		{
			return true;
		}
		
		return false;
	}
	
}

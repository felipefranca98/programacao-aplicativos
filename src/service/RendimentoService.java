package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.RendimentoDAO;
import entity.Rendimento;

public class RendimentoService {

	
	private RendimentoDAO rendimentoDAO;

	public RendimentoService() {
		this.rendimentoDAO = new RendimentoDAO(null);
    }	

	public boolean cadastrarRendimento(Rendimento rendimento) throws SQLException, IOException {
		
		System.out.println("\t Cadastrar Rendimento");

		Connection conn = BancoDados.conectar();
		
		if(rendimento.getMensal() != 0.0)
		{
			rendimento.setTotal(rendimento.getMensal()*12);
		}
		if(rendimento.getOcasional() != 0.0)
		{
			rendimento.setTotal(rendimento.getOcasional());
		}


		List<Rendimento> retorno = new RendimentoDAO(conn).buscarRendimento(rendimento);
		
		if(retorno == null )
		{	System.out.println("\t Vorto nulo Cadastrar Rendimento");

			int retorno1 = new RendimentoDAO(conn).cadastrarRendimento(rendimento);
			if(retorno1 != 0)
			{
				System.out.println("\t Deu Boa Cadastrar Rendimento");

				int id = new RendimentoDAO(conn).buscarIdRendimento(rendimento);
				rendimento.setId(id);
				System.out.println("Deu boa Cadastrar Rendimento" + rendimento.getId());
				return true;
			}
				
		}
		else {
			for (Rendimento categoria1 : retorno) {
				System.out.println("\t Vorto nao nulo");

				
				if(categoria1.getRendimento().toLowerCase().equals(rendimento.getRendimento().toLowerCase())) {
					System.out.println("\t Rendimento ja existe");

					return false;
				}

			}

			int retorno1 = new RendimentoDAO(conn).cadastrarRendimento(rendimento);
			if(retorno1 != 0)
			{
				System.out.println("\t Deu Boa Cadastrar Rendimento");

				int id = new RendimentoDAO(conn).buscarIdRendimento(rendimento);
				rendimento.setId(id);
				System.out.println("Deu boa Cadastrar Rendimento" + rendimento.getId());
				

				return true;
			}
		
		}
		return false;

	}
	
	public boolean editarRendimento(Rendimento rendimento) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		
		if(rendimento.getMensal() != 0.0)
		{
			rendimento.setTotal(rendimento.getMensal()*12);
		}
		if(rendimento.getOcasional() != 0.0)
		{
			rendimento.setTotal(rendimento.getOcasional());
		}
		
		int retorno = new RendimentoDAO(conn).editarRendimento(rendimento);
		if(retorno != 0)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean excluirRendimento(Rendimento rendimento) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		
		int retorno = new RendimentoDAO(conn).excluirRendimento(rendimento.getId());
		if(retorno != 0)
		{
			return true;
		}
		
		return false;
	}
	
}

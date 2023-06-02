package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.DespesasOcasionaisDAO;
import entity.DespesasOcasionais;

public class DespesasOcasionaisService {	
	private DespesasOcasionaisDAO despesasOcasionaisDAO;

	public DespesasOcasionaisService() {
		this.despesasOcasionaisDAO = new DespesasOcasionaisDAO(null);
    }	

	public boolean cadastrarDespesa(DespesasOcasionais despesa) throws SQLException, IOException {		
		System.out.println("\t Cadastrar Despesa Ocasional");

		Connection conn = BancoDados.conectar();
		
		if(despesa.getMensal() != 0.0) {
			despesa.setTotal(despesa.getMensal()*12);
		}
		
		if(despesa.getOcasional() != 0.0) {
			despesa.setTotal(despesa.getOcasional());
		}

		List<DespesasOcasionais> retorno = new DespesasOcasionaisDAO(conn).buscarDespesaOcasionais(despesa);
		
		if(retorno == null ) {
			System.out.println("\t Vorto nulo Cadastrar Despesa Ocasional");

			int retorno1 = new DespesasOcasionaisDAO(conn).cadastrarDespesaOcasionais(despesa);
			
			if(retorno1 != 0) {
				System.out.println("\t Deu Boa Cadastrar Despesa Ocasional");

				int id = new DespesasOcasionaisDAO(conn).buscarIdDespesaOcasionais(despesa);
				despesa.setId(id);
				System.out.println("Deu boa Cadastrar Despesa Ocasional" + despesa.getId());
				return true;
			}
		} else {
			for (DespesasOcasionais categoria1 : retorno) {
				if(categoria1.getFundo().toLowerCase().equals(despesa.getFundo().toLowerCase())) {
					System.out.println("\t Despesa Ocasional ja cadastrada");

					return false;
				}
			}

			int retorno1 = new DespesasOcasionaisDAO(conn).cadastrarDespesaOcasionais(despesa);
			
			if(retorno1 != 0) {
				System.out.println("\t Deu boa Cadastrar Despesa Ocasional");

				int id = new DespesasOcasionaisDAO(conn).buscarIdDespesaOcasionais(despesa);
				despesa.setId(id);
				System.out.println("Deu boa Cadastrar Despesa Ocasional" + despesa.getId());
				

				return true;
			}
		}
		
		return false;
	}
	
	public boolean editarDespesaOcasionais(DespesasOcasionais despesa) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		
		if(despesa.getMensal() != 0.0) {
			despesa.setTotal(despesa.getMensal()*12);
		}
		
		if(despesa.getOcasional() != 0.0) {
			despesa.setTotal(despesa.getOcasional());
		}
		
		int retorno = new DespesasOcasionaisDAO(conn).editarDespesaOcasionais(despesa);
		
		if(retorno != 0) {
			return true;
		}
		
		return false;
	}
	
	public boolean excluirDespesaOcasionais(DespesasOcasionais despesa) throws SQLException, IOException {	
		Connection conn = BancoDados.conectar();
		
		int retorno = new DespesasOcasionaisDAO(conn).excluirDespesaOcasionais(despesa.getId());
		
		if(retorno != 0) {
			return true;
		}
		
		return false;
	}
}
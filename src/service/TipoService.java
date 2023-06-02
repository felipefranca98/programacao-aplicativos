package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.TipoDAO;
import entity.Tipo;

public class TipoService {
	private TipoDAO tipoDAO;

	public TipoService() {
		this.tipoDAO = new TipoDAO(null);
    }

	public boolean cadastrarCategoria(Tipo categoria) throws SQLException, IOException {	
		System.out.println("\t Cadastrar Categoria");

		Connection conn = BancoDados.conectar();
		
		List<Tipo> retorno = new TipoDAO(conn).buscarCategoria(categoria);
		
		if(retorno.size() == 0 ) {
			System.out.println("Vorto nulo Cadastrar Categoria");
			int retorno1 = new TipoDAO(conn).cadastrarCategoria(categoria);
			
			if(retorno1 != 0) {
				System.out.println("Deu boa Cadastrar Categoria");
				int id = new TipoDAO(conn).buscarIdCategoria(categoria);

				categoria.setId(id);
				System.out.println("Deu boa Cadastrar Categoria " + categoria.getId());
				
				return true;
			}		
		} else {
			System.out.println("Vorto nao nulo Cadastrar Categoria.");

			for (Tipo categoria1 : retorno) {
				if(categoria1.getNome().toLowerCase().equals(categoria.getNome().toLowerCase())) {
					System.out.println("Categoria ja cadastrada.");
					
					return false;
				}
			}
			
			int retorno1 = new TipoDAO(conn).cadastrarCategoria(categoria);
			
			if(retorno1 != 0) {
				System.out.println("Deu boa Cadastrar Categoria.");
				int id = new TipoDAO(conn).buscarIdCategoria(categoria);
				categoria.setId(id);
				System.out.println("Deu boa Cadastrar Categoria" + categoria.getId());
				
				return true;
			}
		}
		
		return false;
	}
	
	public boolean editarCategoria(Tipo categoria) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();		

		System.out.println("Editando");

		int retorno = new TipoDAO(conn).editarCategoria(categoria);
		
		if(retorno != 0) {
			return true;
		}
		
		return false;
	}
	
	public boolean excluirCategoria(Tipo categoria) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		
		int retorno = new TipoDAO(conn).excluirCategoria(categoria.getId());
		
		if(retorno != 0) {
			return true;
		}
		
		return false;
	}
}
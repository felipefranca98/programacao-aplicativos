package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.DespesasOcasionais;


public class DespesasOcasionaisDAO {

	private Connection conn;

	public DespesasOcasionaisDAO(Connection conn) {

		this.conn = conn;
	}
	
	
	public int cadastrarDespesaOcasionais(DespesasOcasionais despesa) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("insert into despesas_ocasionais (User, Mes, Ano, Fundo, Mensal, Ocasional, Total) values (?, ?, ?, ?, ?, ?, ?)");
			st.setInt(1, despesa.getUser());
			st.setInt(2, despesa.getMes());
			st.setInt(3, despesa.getAno());
			st.setString(4, despesa.getFundo());
			st.setDouble(5, despesa.getMensal());
			st.setDouble(6, despesa.getOcasional());
			st.setDouble(7, despesa.getTotal());


			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;

		} finally {

			BancoDados.finalizarStatement(st);
		}
		

	}
	
	public int editarDespesaOcasionais(DespesasOcasionais despesa) throws SQLException {

		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("update despesas_ocasionais set Mes = ? , Ano = ? , Fundo = ?, Mensal = ?, Ocasional = ? , Total = ? where Id = ?");


			st.setInt(1, despesa.getMes());
			st.setInt(2, despesa.getAno());
			st.setString(3, despesa.getFundo());
			st.setDouble(4, despesa.getMensal());
			st.setDouble(5, despesa.getOcasional());
			st.setDouble(6, despesa.getTotal());
			st.setInt(7, despesa.getId());

			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;

		} finally {

			BancoDados.finalizarStatement(st);
		}
	}

	
	public List<DespesasOcasionais> buscarDespesaOcasionais(DespesasOcasionais despesa) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from despesas_ocasionais where User = ? order by Id");
			st.setInt(1, despesa.getUser());
			rs = st.executeQuery();

			List<DespesasOcasionais> listaCursos = new ArrayList<>();

			while (rs.next()) {

				DespesasOcasionais categoriaResultado = new DespesasOcasionais();
				categoriaResultado.setUser(rs.getInt("User"));
				categoriaResultado.setMes(rs.getInt("Mes"));
				categoriaResultado.setAno(rs.getInt("Ano"));
				categoriaResultado.setFundo(rs.getNString("Fundo"));
				categoriaResultado.setMensal(rs.getDouble("Mensal"));
				categoriaResultado.setOcasional(rs.getDouble("Ocasional"));
				categoriaResultado.setTotal(rs.getDouble("Total"));
				
				listaCursos.add(categoriaResultado);
			}

			

			return listaCursos;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
		}
	}


	
	public int buscarIdDespesaOcasionais(DespesasOcasionais despesa) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;
		int id = 0;
		

		try {

			st = conn.prepareStatement("select Id from despesas_ocasionais where User = ? and Mes = ? and Ano = ? and Fundo = ? and Mensal = ? and Ocasional = ? and Total = ? order by Id");
			st.setInt(1, despesa.getUser());
			st.setInt(2, despesa.getMes());
			st.setInt(3, despesa.getAno());
			st.setString(4, despesa.getFundo());
			st.setDouble(5, despesa.getMensal());
			st.setDouble(6, despesa.getOcasional());			
			st.setDouble(7, despesa.getTotal());
			rs = st.executeQuery();
			if(rs.next()){
				 id = rs.getInt("Id");
				
				}
		

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
		}
		
		return id;
	}


	
	public int excluirDespesaOcasionais(int id) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("delete from despesas_ocasionais where Id = ?");

			st.setInt(1, id);

			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;

		} finally {

			BancoDados.finalizarStatement(st);
		}
	}
	



}
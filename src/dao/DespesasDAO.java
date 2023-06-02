package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Despesas;

public class DespesasDAO {
	private Connection conn;

	public DespesasDAO(Connection conn) {
		this.conn = conn;
	}
	
	public int cadastrarDespesa(Despesas despesa) throws SQLException {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("insert into despesas (User, Mes, Ano, Categoria, Despesa, Mensal, Ocasional, Total) values (?, ?, ?, ?, ?, ?, ?, ?)");
			st.setInt(1, despesa.getUser());
			st.setInt(2, despesa.getMes());
			st.setInt(3, despesa.getAno());
			st.setString(4, despesa.getCategoria());
			st.setString(5, despesa.getDespesa());
			st.setDouble(6, despesa.getMensal());
			st.setDouble(7, despesa.getOcasional());
			st.setDouble(8, despesa.getTotal());

			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;
		} finally {
			BancoDados.finalizarStatement(st);
		}
	}
	
	public int editarDespesa(Despesas despesa) throws SQLException {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("update despesas set Mes = ? , Ano = ? , Categoria = ?, Despesa = ? , Mensal = ?, Ocasional = ? , Total = ? where Id = ?");

			st.setInt(1, despesa.getMes());
			st.setInt(2, despesa.getAno());
			st.setString(3, despesa.getCategoria());
			st.setString(4, despesa.getDespesa());
			st.setDouble(5, despesa.getMensal());
			st.setDouble(6, despesa.getOcasional());
			st.setDouble(7, despesa.getTotal());
			st.setInt(8, despesa.getId());

			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;
		} finally {
			BancoDados.finalizarStatement(st);
		}
	}
	
	public List<Despesas> buscarDespesa(Despesas despesa) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select * from despesas where User = ? order by Id");
			//st = conn.prepareStatement("select * from despesas, usuario where despesas.User = ? order by Id");
			st.setInt(1, despesa.getUser());
			rs = st.executeQuery();

			List<Despesas> listaCursos = new ArrayList<>();

			while (rs.next()) {
				Despesas categoriaResultado = new Despesas();
				categoriaResultado.setUser(rs.getInt("User"));
				categoriaResultado.setMes(rs.getInt("Mes"));
				categoriaResultado.setAno(rs.getInt("Ano"));
				categoriaResultado.setCategoria(rs.getString("Categoria"));
				categoriaResultado.setDespesa(rs.getString("Despesa"));
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
	
	public int buscarIdDespesa(Despesas despesa) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		int id = 0;

		try {
			st = conn.prepareStatement("select Id from despesas where Mes = ? and Ano = ? and Categoria = ? and Despesa = ? and Mensal = ? and Ocasional = ? and Total = ? order by Id");
			st.setInt(1, despesa.getMes());
			st.setInt(2, despesa.getAno());
			st.setString(3, despesa.getCategoria());
			st.setString(4, despesa.getDespesa());
			st.setDouble(5, despesa.getMensal());
			st.setDouble(6, despesa.getOcasional());			
			st.setDouble(7, despesa.getTotal());
			rs = st.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt("Id");
			}
		} finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
		}
		
		return id;
	}

	public int excluirDespesa(int id) throws SQLException {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("delete from despesas where Id = ?");

			st.setInt(1, id);

			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;
		} finally {
			BancoDados.finalizarStatement(st);
		}
	}
}
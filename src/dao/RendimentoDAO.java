package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Rendimento;

public class RendimentoDAO {
	private Connection conn;

	public RendimentoDAO(Connection conn) {
		this.conn = conn;
	}
	
	public int cadastrarRendimento(Rendimento rendimento) throws SQLException {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("insert into rendimento (User, Mes, Ano, Categoria, Rendimento, Mensal, Ocasional, Total) values (?, ?, ?, ?, ?, ?, ?, ?)");
			st.setInt(1, rendimento.getUser());
			st.setInt(2, rendimento.getMes());
			st.setInt(3, rendimento.getAno());
			st.setString(4, rendimento.getCategoria());
			st.setString(5, rendimento.getRendimento());
			st.setDouble(6, rendimento.getMensal());
			st.setDouble(7, rendimento.getOcasional());
			st.setDouble(8, rendimento.getTotal());

			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;
		} finally {
			BancoDados.finalizarStatement(st);
		}
	}
	
	public int editarRendimento(Rendimento rendimento) throws SQLException {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("update rendimento set Mes = ? , Ano = ? , Categoria = ?, Rendimento = ?, Mensal = ?, Ocasional = ? , Total = ? where Id = ?");

			st.setInt(1, rendimento.getMes());
			st.setInt(2, rendimento.getAno());
			st.setString(3, rendimento.getCategoria());
			st.setString(4, rendimento.getRendimento());
			st.setDouble(5, rendimento.getMensal());
			st.setDouble(6, rendimento.getOcasional());
			st.setDouble(7, rendimento.getTotal());
			st.setInt(8, rendimento.getId());

			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;
		} finally {
			BancoDados.finalizarStatement(st);
		}
	}
	
	public List<Rendimento> buscarRendimento(Rendimento rendimento) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select * from rendimento where User = ? order by Id");
			//st = conn.prepareStatement("select * from despesas, usuario where despesas.User = ? order by Id");
			st.setInt(1, rendimento.getUser());
			rs = st.executeQuery();

			List<Rendimento> listaCursos = new ArrayList<>();

			while (rs.next()) {
				Rendimento categoriaResultado = new Rendimento();
				
				categoriaResultado.setUser(rs.getInt("User"));
				categoriaResultado.setMes(rs.getInt("Mes"));
				categoriaResultado.setAno(rs.getInt("Ano"));
				categoriaResultado.setCategoria(rs.getString("Categoria"));
				categoriaResultado.setRendimento(rs.getString("Rendimento"));
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
	
	public int buscarIdRendimento(Rendimento rendimento) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		int id = 0;
		
		try {
			st = conn.prepareStatement("select Id from rendimento where Mes = ? and Ano = ? and Categoria = ? and Rendimento = ? and Mensal = ? and Ocasional = ? and Total = ? order by Id");
		
			st.setInt(1, rendimento.getMes());
			st.setInt(2, rendimento.getAno());
			st.setString(3, rendimento.getCategoria());
			st.setString(4, rendimento.getRendimento());
			st.setDouble(5, rendimento.getMensal());
			st.setDouble(6, rendimento.getOcasional());
			st.setDouble(7, rendimento.getTotal());
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
	
	public int excluirRendimento(int id) throws SQLException {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("delete from rendimento where Id = ?");

			st.setInt(1, id);

			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;
		} finally {
			BancoDados.finalizarStatement(st);
		}
	}
}
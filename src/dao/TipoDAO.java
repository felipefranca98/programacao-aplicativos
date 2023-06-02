package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Tipo;

public class TipoDAO {
	private Connection conn;

	public TipoDAO(Connection conn) {
		this.conn = conn;
	}
	
	public int cadastrarCategoria(Tipo categoria) throws SQLException {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("insert into tipo (Nome, Modulo) values (?, ?)");

			st.setString(1, categoria.getNome());
			st.setString(2, categoria.getModulo());

			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;
		} finally {
			BancoDados.finalizarStatement(st);
		}
	}

	public int editarCategoria(Tipo categoria) throws SQLException {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("update tipo set Nome = ? where Id = ?");

			st.setString(1, categoria.getNome());
			st.setInt(2, categoria.getId());

			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;
		} finally {
			BancoDados.finalizarStatement(st);
		}
	}
	
	public List<Tipo> buscarCategoria(Tipo categoria) throws SQLException {
		System.out.println("Buscando");

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select * from tipo where Modulo = ? ");
			st.setString(1, categoria.getModulo());
			rs = st.executeQuery();

			List<Tipo> listaCursos = new ArrayList<>();

			while (rs.next()) {
				Tipo categoriaResultado = new Tipo();

				categoriaResultado.setNome(rs.getString("Nome"));
				
				listaCursos.add(categoriaResultado);
			}

			return listaCursos;
		} finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
		}
	}

	public int buscarIdCategoria(Tipo categoria) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		int id = 0;
		
		try {
			st = conn.prepareStatement("select Id from tipo where Nome = ? and Modulo = ? ");
			st.setString(1, categoria.getNome());
			st.setString(2, categoria.getModulo());
			rs = st.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt("Id");
			}
			
			//return id;
		} finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
		}
		
		return id;
	}

	public int excluirCategoria(int id) throws SQLException {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("delete from tipo where Id = ?");

			st.setInt(1, id);

			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;
		} finally {
			BancoDados.finalizarStatement(st);	
		}
	}
}

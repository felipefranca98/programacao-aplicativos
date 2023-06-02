package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Usuario;

public class UsuarioDAO {
	private Connection conn;

	public UsuarioDAO(Connection conn) {
		this.conn = conn;
	}
	
	public int cadastrarUsuario(Usuario usuario) throws SQLException {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("insert into usuario (Login, Senha, Log) values (?, ?, ?)");

			st.setString(1, usuario.getLogin());
			st.setString(2, usuario.getSenha());
			st.setInt(3, usuario.getLog());

			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;
		} finally {
			BancoDados.finalizarStatement(st);
		}
	}

	public int editarUsuario(Usuario usuario) throws SQLException {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("update usuario set Login = ?, Senha = ?  where Id = ?");

			st.setString(1, usuario.getLogin());
			st.setString(2, usuario.getSenha());
			st.setInt(3, usuario.getId());

			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;
		} finally {
			BancoDados.finalizarStatement(st);
		}
	}
	
	public List<Usuario> buscarUsuario(Usuario usuario) throws SQLException {
		System.out.println("Buscando");

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select * from usuario where Login = ? ");
			st.setString(1, usuario.getLogin());
			rs = st.executeQuery();

			List<Usuario> listaCursos = new ArrayList<>();

			while (rs.next()) {
				Usuario categoriaResultado = new Usuario();

				categoriaResultado.setLogin(rs.getString("Login"));		
				
				listaCursos.add(categoriaResultado);
			}

			return listaCursos;
		} finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
		}
	}

	public int buscarIdUsuario(Usuario usuario) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		int id = 0;
		
		try {
			st = conn.prepareStatement("select Id from usuario where Login = ? and Senha = ? ");
			st.setString(1, usuario.getLogin());
			st.setString(2, usuario.getSenha());
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

	public int excluirUsuario(int id) throws SQLException {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("delete from usuario where Id = ?");

			st.setInt(1, id);

			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;
		} finally {
			BancoDados.finalizarStatement(st);
		}
	}
}

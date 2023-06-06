package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Usuario;

public class UsuarioDAO {

	// Comunicação com a base para manipulações do Usuário

	private Connection conn;

	public UsuarioDAO(Connection conn) {

		this.conn = conn;
	}
	

	
	public int cadastrarUsuario(Usuario usuario) throws SQLException {
		// Realiza o cadastro do Usuário
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

		// Edita o Usuário
		
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
		// Lista os Usuários
		
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

		// Busca o ID do Usuário e retorna para incluir no objeto
		PreparedStatement st = null;
		ResultSet rs = null;
		int id = 0;
		try {

			st = conn.prepareStatement("select Id from usuario where Login = ? and Senha = ? ");
			st.setString(1, usuario.getLogin());
			st.setString(2, usuario.getSenha());
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


	public int excluirUsuario(int id) throws SQLException {
		// Exclui o Usuário
		
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

	public int loginUsuario(Usuario usuario) throws SQLException {

		// Faz o Login do Usuário
		
		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("update usuario set Log = ? where Id = ?");

			st.setInt(1, 1);
			st.setInt(2, usuario.getId());


			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;

		} finally {

			BancoDados.finalizarStatement(st);
		}
	}
	
	public int logoutUsuario(Usuario usuario) throws SQLException {

		// Faz o Logout do Usuário
		
		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("update usuario set Log = ? where Id = ?");

			st.setInt(1, 0);
			st.setInt(2, usuario.getId());


			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;

		} finally {

			BancoDados.finalizarStatement(st);
		}
	}
	

	
	
}

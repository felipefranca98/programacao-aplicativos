package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.UsuarioDAO;
import entity.Usuario;

public class UsuarioService {
	private UsuarioDAO usuarioDAO;

	public UsuarioService() {
		this.usuarioDAO = new UsuarioDAO(null);
    }

	public boolean cadastrarUsuario(Usuario usuario) throws SQLException, IOException {	
		System.out.println("\t Cadastrar Usuario Service");

		Connection conn = BancoDados.conectar();

		List<Usuario> retorno = new UsuarioDAO(conn).buscarUsuario(usuario);
		
		if(retorno.size() == 0 ) {
			System.out.println("Vorto nulo");
			int retorno1 = new UsuarioDAO(conn).cadastrarUsuario(usuario);
			
			if(retorno1 != 0) {
				System.out.println("Deu boa");
				int id = new UsuarioDAO(conn).buscarIdUsuario(usuario);

				usuario.setId(id);
				System.out.println("Deu boa" + usuario.getId());
				
				return true;
			}		
		} else {
			System.out.println("Vorto nao nulo Cadastrar Usuario.");

			for (Usuario categoria1 : retorno) {
				if(categoria1.getLogin().toLowerCase().equals(usuario.getLogin().toLowerCase())) {
					System.out.println("Demoin Usuario ja cadastrado.");
					
					return false;
				}
			}
			
			int retorno1 = new UsuarioDAO(conn).cadastrarUsuario(usuario);
			
			if(retorno1 != 0) {
				System.out.println("Deu Boa Cadastrar Usuario.");
				int id = new UsuarioDAO(conn).buscarIdUsuario(usuario);
				usuario.setId(id);
				System.out.println("Deu boa Cadastrar Usuario " + usuario.getId());
				
				return true;
			}
		}
		
		return false;
	}
	
	public boolean editarUsuario(Usuario usuario) throws SQLException, IOException {	
		Connection conn = BancoDados.conectar();	

		System.out.println("Editando");

		int retorno = new UsuarioDAO(conn).editarUsuario(usuario);
		
		if(retorno != 0) {
			return true;
		}
		
		return false;
	}
	
	public boolean excluirUsuario(Usuario usuario) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		
		int retorno = new UsuarioDAO(conn).excluirUsuario(usuario.getId());
		
		if(retorno != 0) {
			return true;
		}
		
		return false;
	}
}
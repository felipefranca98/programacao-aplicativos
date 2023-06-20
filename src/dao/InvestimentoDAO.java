package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Investimento;


public class InvestimentoDAO {

	private Connection conn;

	public InvestimentoDAO(Connection conn) {

		this.conn = conn;
	}
	
	
	public int cadastrarInvestimento(Investimento investimento) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("insert into investimento (User, Mes, Ano, Investimento, Mensal, Ocasional, Total) values (?, ?, ?, ?, ?, ?, ?)");
			st.setInt(1, investimento.getUser());
			st.setInt(2, investimento.getMes());
			st.setInt(3, investimento.getAno());
			st.setString(4, investimento.getInvestimento());
			st.setDouble(5, investimento.getMensal());
			st.setDouble(6, investimento.getOcasional());
			st.setDouble(7, investimento.getTotal());


			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;

		} finally {

			BancoDados.finalizarStatement(st);
		}
		

	}
	
	public int editarInvestimento(Investimento investimento) throws SQLException {

		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("update investimento set Mes = ? , Ano = ? , Investimento = ?, Mensal = ?, Ocasional = ? , Total = ? where Id = ?");


			st.setInt(1, investimento.getMes());
			st.setInt(2, investimento.getAno());
			st.setString(3, investimento.getInvestimento());
			st.setDouble(4, investimento.getMensal());
			st.setDouble(5, investimento.getOcasional());
			st.setDouble(6, investimento.getTotal());
			st.setInt(7, investimento.getId());

			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;

		} finally {

			BancoDados.finalizarStatement(st);
		}
	}

	
	public List<Investimento> buscarInvestimento(int i) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from investimento where User = ? order by Id");
			st.setInt(1, i);
			rs = st.executeQuery();

			List<Investimento> listaCursos = new ArrayList<>();

			while (rs.next()) {

				Investimento categoriaResultado = new Investimento();
				categoriaResultado.setUser(rs.getInt("User"));
				categoriaResultado.setMes(rs.getInt("Mes"));
				categoriaResultado.setAno(rs.getInt("Ano"));
				categoriaResultado.setInvestimento(rs.getString("Investimento"));
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


	
	public int buscarIdInvestimento(Investimento investimento) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;
		int id = 0;
		

		try {

			st = conn.prepareStatement("select Id from investimento where User = ? and Mes = ? and Ano = ? and Investimento = ? and Mensal = ? and Ocasional = ? and Total = ? order by Id");
			st.setInt(1, investimento.getUser());
			st.setInt(2, investimento.getMes());
			st.setInt(3, investimento.getAno());
			st.setString(4, investimento.getInvestimento());
			st.setDouble(5, investimento.getMensal());
			st.setDouble(6, investimento.getOcasional());			
			st.setDouble(7, investimento.getTotal());
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


	
	public int excluirInvestimento(int id) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("delete from investimento where Id = ?");

			st.setInt(1, id);

			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;

		} finally {

			BancoDados.finalizarStatement(st);
		}
	}
	



}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Despesas;
import entity.DespesasOcasionais;
import entity.Investimento;
import entity.Rendimento;

import entity.ResumoMes;


public class ResumoMesDAO {

	private Connection conn;

	public ResumoMesDAO(Connection conn) {

		this.conn = conn;
	}
	
	
	public int cadastrarResumoMes(ResumoMes resumo) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("insert into resumo_mes (User, Mes, Ano, Rendimento, Investimento, Despesas, Valor_Disponiveis_Mes, Valor_Despesas_Mes, Total) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			

			st.setInt(1, resumo.getUser());
			st.setInt(2, resumo.getMes());
			st.setInt(3, resumo.getAno());
			st.setDouble(4, resumo.getRendimento());
			st.setDouble(5, resumo.getInvestimento());
			st.setDouble(6, resumo.getDespesa());
			st.setDouble(7, resumo.getValorDisponivelMes());
			st.setDouble(8, resumo.getValorDespesasMes());
			st.setDouble(9, resumo.getTotal());

			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;

		} finally {

			BancoDados.finalizarStatement(st);
		}
		

	}
	
	public int editarResumoMes(ResumoMes resumo) throws SQLException {

		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("update resumo_mes set Mes = ?, Ano = ?, Rendimento = ?, Investimento = ?, Despesas = ?, Valor_Disponiveis_Mes = ?, Valor_Despesas_Mes = ?, Total = ? where Id = ?");

			st.setInt(1, resumo.getUser());
			st.setInt(2, resumo.getAno());
			st.setDouble(7, resumo.getValorDespesasMes());
			
			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;

		} finally {

			BancoDados.finalizarStatement(st);
		}
	}

	
	public List<ResumoMes> buscarResumoMes(ResumoMes resumo) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from resumo_mes where User = ? and Mes = ? and Ano = ? order by Id");
			st.setInt(1, resumo.getUser());
			st.setInt(2, resumo.getMes());
			st.setInt(3, resumo.getAno());
		

			rs = st.executeQuery();

			List<ResumoMes> listaCursos = new ArrayList<>();

			while (rs.next()) {

				ResumoMes categoriaResultado = new ResumoMes();

				categoriaResultado.setUser(rs.getInt("User"));
				categoriaResultado.setMes(rs.getInt("Mes"));
				categoriaResultado.setAno(rs.getInt("Ano"));
				categoriaResultado.setRendimento(rs.getDouble("Rendimento"));
				categoriaResultado.setInvestimento(rs.getDouble("Investimento"));
				categoriaResultado.setDespesa(rs.getDouble("Despesas"));
				categoriaResultado.setValorDisponivelMes(rs.getDouble("Valor_Disponiveis_Mes"));
				categoriaResultado.setValorDespesasMes(rs.getDouble("Valor_Despesas_Mes"));
				categoriaResultado.setTotal(rs.getDouble("Total"));

				listaCursos.add(categoriaResultado);
			}

			

			return listaCursos;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
		}
	}


	
	public int buscarIdResumoMes(ResumoMes resumo) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;
		int id = 0;
		

		try {

			st = conn.prepareStatement("select Id from resumo_mes where User = ? and Mes = ? and Ano = ? and Rendimento = ? and Investimento = ? and Despesas = ? and Valor_Disponiveis_Mes = ? and Valor_Despesas_Mes = ? and Total = ? order by Id");
			
			st.setInt(1, resumo.getUser());
			st.setInt(2, resumo.getMes());
			st.setInt(3, resumo.getAno());
			st.setDouble(4, resumo.getRendimento());
			st.setDouble(5, resumo.getInvestimento());
			st.setDouble(6, resumo.getDespesa());
			st.setDouble(7, resumo.getValorDisponivelMes());
			st.setDouble(8, resumo.getValorDespesasMes());
			st.setDouble(9, resumo.getTotal());
			
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

	
	public List<ResumoMes> buscarRendimentoMensalResumoMes(ResumoMes resumo) throws SQLException{
		PreparedStatement st = null;
		ResultSet rs = null;
		

		try {

			st = conn.prepareStatement("select * from rendimento where User = ? and Ano = ? and Mes = ? and Ocasional = ? order by Id");
			st.setInt(1, resumo.getUser());
			st.setInt(2, resumo.getAno());
			st.setInt(3, resumo.getMes());
			st.setDouble(4, 0.0);
			
			rs = st.executeQuery();
			
			
			List<ResumoMes> lista = new ArrayList<>();

			while (rs.next()) {

				ResumoMes categoriaResultado = new ResumoMes();
				categoriaResultado.setUser(rs.getInt("User"));
				categoriaResultado.setAno(rs.getInt("Ano"));
				categoriaResultado.setMes(rs.getInt("Mes"));
				categoriaResultado.setRendimento(rs.getDouble("Mensal"));

				
				lista.add(categoriaResultado);
			}

			

			return lista;


		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
		}
	}

	


	public List<ResumoMes> buscarRendimentoOcasionalResumoMes(ResumoMes resumo) throws SQLException{
		PreparedStatement st = null;
		ResultSet rs = null;
		

		try {

			st = conn.prepareStatement("select * from rendimento where User = ? and Ano = ? and Mes = ? and Mensal = ? order by Id");
			st.setInt(1, resumo.getUser());
			st.setInt(2, resumo.getAno());
			st.setInt(3, resumo.getMes());
			st.setDouble(4, 0.0);
			
			rs = st.executeQuery();
			
			
			List<ResumoMes> lista = new ArrayList<>();

			while (rs.next()) {

				ResumoMes categoriaResultado = new ResumoMes();
				categoriaResultado.setUser(rs.getInt("User"));
				categoriaResultado.setAno(rs.getInt("Ano"));
				categoriaResultado.setMes(rs.getInt("Mes"));
				categoriaResultado.setRendimento(rs.getDouble("Ocasional"));

				
				lista.add(categoriaResultado);
			}

			

			return lista;


		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
		}
	}



	public List<ResumoMes> buscarInvestimentoMensalResumoMes(ResumoMes resumo) throws SQLException{
		PreparedStatement st = null;
		ResultSet rs = null;
		

		try {

			st = conn.prepareStatement("select * from investimento where User = ? and Ano = ? and Mes = ? and Ocasional = ?  order by Id");
			st.setInt(1, resumo.getUser());
			st.setInt(2, resumo.getAno());
			st.setInt(3, resumo.getMes());
			st.setDouble(4, 0.0);
			
			rs = st.executeQuery();
			
			
			List<ResumoMes> lista = new ArrayList<>();

			while (rs.next()) {

				ResumoMes categoriaResultado = new ResumoMes();
				categoriaResultado.setUser(rs.getInt("User"));
				categoriaResultado.setAno(rs.getInt("Ano"));
				categoriaResultado.setMes(rs.getInt("Mes"));
				categoriaResultado.setInvestimento(rs.getDouble("Mensal"));

				
				lista.add(categoriaResultado);
			}

			

			return lista;


		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
		}
	}

	public List<ResumoMes> buscarInvestimentoOcasionalResumoMes(ResumoMes resumo) throws SQLException{
		PreparedStatement st = null;
		ResultSet rs = null;
		

		try {

			st = conn.prepareStatement("select * from investimento where User = ? and Ano = ? and Mes = ? and Mensal = ?  order by Id");
			st.setInt(1, resumo.getUser());
			st.setInt(2, resumo.getAno());
			st.setInt(3, resumo.getMes());
			st.setDouble(4, 0.0);
			
			rs = st.executeQuery();
			
			
			List<ResumoMes> lista = new ArrayList<>();

			while (rs.next()) {

				ResumoMes categoriaResultado = new ResumoMes();
				categoriaResultado.setUser(rs.getInt("User"));
				categoriaResultado.setAno(rs.getInt("Ano"));
				categoriaResultado.setMes(rs.getInt("Mes"));
				categoriaResultado.setInvestimento(rs.getDouble("Ocasional"));

				
				lista.add(categoriaResultado);
			}

			

			return lista;


		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
		}
	}
	
	
	public List<ResumoMes> buscarFundoDespesaMensalResumoMes(ResumoMes resumo) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;
		


		try {

			st = conn.prepareStatement("select * from despesas_ocasionais where User = ? and Ano = ? and Mes = ? and Ocasional = ? order by Id");
			st.setInt(1, resumo.getUser());
			st.setInt(2, resumo.getAno());
			st.setInt(3, resumo.getMes());
			st.setDouble(4, 0.0);
			
			rs = st.executeQuery();
			
			
			List<ResumoMes> lista = new ArrayList<>();

			while (rs.next()) {

				ResumoMes categoriaResultado = new ResumoMes();
				categoriaResultado.setUser(rs.getInt("User"));
				categoriaResultado.setAno(rs.getInt("Ano"));
				categoriaResultado.setMes(rs.getInt("Mes"));
				categoriaResultado.setDespesa(rs.getDouble("Mensal"));
				lista.add(categoriaResultado);
			}

			

			return lista;


		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
		}
		
	}

	
	public List<ResumoMes> buscarFundoDespesaOcasionalResumoMes(ResumoMes resumo) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;
		


		try {

			st = conn.prepareStatement("select * from despesas_ocasionais where User = ? and Ano = ? and Mes = ? and Mensal = ? order by Id");
			st.setInt(1, resumo.getUser());
			st.setInt(2, resumo.getAno());
			st.setInt(3, resumo.getMes());
			st.setDouble(4, 0.0);
			
			rs = st.executeQuery();
			
			
			List<ResumoMes> lista = new ArrayList<>();

			while (rs.next()) {

				ResumoMes categoriaResultado = new ResumoMes();
				categoriaResultado.setUser(rs.getInt("User"));
				categoriaResultado.setAno(rs.getInt("Ano"));
				categoriaResultado.setMes(rs.getInt("Mes"));
				categoriaResultado.setDespesa(rs.getDouble("Ocasional"));
				lista.add(categoriaResultado);
			}

			

			return lista;


		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
		}
		
	}



	
	public List<Double> buscarTotalDespesasMensalResumoMes(ResumoMes resumo) throws SQLException{

		PreparedStatement st = null;
		ResultSet rs = null;
		


		try {

			st = conn.prepareStatement("select * from despesas where User = ? and Ano = ? and Mes = ? and Ocasional = ? order by Id");
			st.setInt(1, resumo.getUser());
			st.setInt(2, resumo.getAno());
			st.setInt(3, resumo.getMes());
			st.setDouble(4, 0.0);

			
			rs = st.executeQuery();
			
			
			List<Double> lista = new ArrayList<>();

			while (rs.next()) {

				double categoriaResultado ;
				categoriaResultado = rs.getDouble("Mensal");
				
				lista.add(categoriaResultado);
			}

			

			return lista;


		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
		}

		
		
	}


	public List<Double> buscarTotalDespesasOcasionalResumoMes(ResumoMes resumo) throws SQLException{

		PreparedStatement st = null;
		ResultSet rs = null;
		


		try {

			st = conn.prepareStatement("select * from despesas where User = ? and Ano = ? and Mes = ? and Mensal = ? order by Id");
			st.setInt(1, resumo.getUser());
			st.setInt(2, resumo.getAno());
			st.setInt(3, resumo.getMes());
			st.setDouble(4, 0.0);

			
			rs = st.executeQuery();
			
			
			List<Double> lista = new ArrayList<>();

			while (rs.next()) {

				double categoriaResultado ;
				categoriaResultado = rs.getDouble("Ocasional");
				
				lista.add(categoriaResultado);
			}

			

			return lista;


		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
		}
	}
	
	



	




}

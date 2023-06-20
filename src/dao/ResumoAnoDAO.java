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

import entity.ResumoAno;


public class ResumoAnoDAO {

	private Connection conn;

	public ResumoAnoDAO(Connection conn) {

		this.conn = conn;
	}
	
	
	public int cadastrarResumoAno(ResumoAno resumo) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("insert into resumo_ano (User, Ano, RendimentoTotal, RendimentoMensal, RendimentoOcasional, InvestimentoTotal, InvestimentoMensal, InvestimentoOcasional, DespesasOcasionaisTotal, DespesasOcasionaisMensal, DespesasOcasionais, Total_Disponivel_Ano, Total_Despesas_Mes, Total_Despesas_Ocasionais, Total_Restante) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			st.setInt(1, resumo.getUser());
			st.setInt(2, resumo.getAno());
			st.setDouble(3, resumo.getRendimentoTotal());
			st.setDouble(4, resumo.getRendimentoMensal());
			st.setDouble(5, resumo.getRendimentoOcasional());
			st.setDouble(6, resumo.getInvestimentoTotal());
			st.setDouble(7, resumo.getInvestimentoMensal());
			st.setDouble(8, resumo.getInvestimentoOcasional());
			st.setDouble(9, resumo.getFundoDespesaTotal());
			st.setDouble(10, resumo.getFundoDespesaMensal());
			st.setDouble(11, resumo.getFundoDespesaOcasional());
			st.setDouble(12, resumo.getValorDisponivelAno());
			st.setDouble(13, resumo.getValorDespesasMes());
			st.setDouble(14, resumo.getTotalDespesasOcasionais());
			st.setDouble(15, resumo.getTotalRestante());
		

			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;

		} finally {

			BancoDados.finalizarStatement(st);
		}
		

	}
	
	public int editarResumoAno(ResumoAno resumo) throws SQLException {

		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("update resumo_ano set Mes = ? , Ano = ? , Investimento = ?, Mensal = ?, Ocasional = ? , Total = ? where Id = ?");

			st.setInt(1, resumo.getUser());
			st.setInt(2, resumo.getAno());
			st.setDouble(3, resumo.getRendimentoTotal());
			st.setDouble(4, resumo.getInvestimentoTotal());
			st.setDouble(5, resumo.getFundoDespesaTotal());
			st.setDouble(6, resumo.getValorDisponivelAno());
			st.setDouble(7, resumo.getValorDespesasMes());
			st.setDouble(8, resumo.getTotalDespesasOcasionais());
			st.setDouble(9, resumo.getTotalRestante());
		
			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;

		} finally {

			BancoDados.finalizarStatement(st);
		}
	}

	
	public List<ResumoAno> buscarResumoAno(ResumoAno resumo) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from resumo_ano where User = ? and Ano = ? order by Id");
			st.setInt(1, resumo.getUser());
			st.setInt(2, resumo.getAno());
			rs = st.executeQuery();

			List<ResumoAno> listaCursos = new ArrayList<>();

			while (rs.next()) {

				ResumoAno categoriaResultado = new ResumoAno();
				categoriaResultado.setUser(rs.getInt("User"));
				categoriaResultado.setAno(rs.getInt("Ano"));
				categoriaResultado.setRendimentoTotal(rs.getFloat("RendimentoTotal"));
				categoriaResultado.setInvestimentoTotal(rs.getFloat("InvestimentoTotal"));
				categoriaResultado.setFundoDespesaTotal(rs.getFloat("DespesasOcasionaisTotal"));
				categoriaResultado.setValorDisponivelAno(rs.getFloat("Total_Disponivel_Ano"));
				categoriaResultado.setValorDespesasMes(rs.getFloat("Total_Despesas_Mes"));
				categoriaResultado.setTotalDespesasOcasionais(rs.getFloat("Total_Despesas_Ocasionais"));
				categoriaResultado.setTotalRestante(rs.getFloat("Total_Restante"));
				
				listaCursos.add(categoriaResultado);
			}

			

			return listaCursos;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
		}
	}


	
	public int buscarIdResumoAno(ResumoAno resumo) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;
		int id = 0;
		

		try {

			st = conn.prepareStatement("select Id from resumo_ano where User = ? and Ano = ? and RendimentoTotal = ? and RendimentoMensal = ? and RendimentoOcasional = ? and InvestimentoTotal = ? and InvestimentoMensal = ? and InvestimentoOcasional = ? and DespesasOcasionaisTotal = ? and DespesasOcasionaisMensal = ? and DespesasOcasionais = ? and Total_Disponivel_Ano = ? and Total_Despesas_Mes = ? and Total_Despesas_Ocasionais = ? and Total_Restante = ? order by Id");
			st.setInt(1, resumo.getUser());
			st.setInt(2, resumo.getAno());
			st.setDouble(3, resumo.getRendimentoTotal());
			st.setDouble(4, resumo.getRendimentoMensal());
			st.setDouble(5, resumo.getRendimentoOcasional());
			st.setDouble(6, resumo.getInvestimentoTotal());
			st.setDouble(7, resumo.getInvestimentoMensal());
			st.setDouble(8, resumo.getInvestimentoOcasional());
			st.setDouble(9, resumo.getFundoDespesaTotal());
			st.setDouble(10, resumo.getFundoDespesaMensal());
			st.setDouble(11, resumo.getFundoDespesaOcasional());
			st.setDouble(12, resumo.getValorDisponivelAno());
			st.setDouble(13, resumo.getValorDespesasMes());
			st.setDouble(14, resumo.getTotalDespesasOcasionais());
			st.setDouble(15, resumo.getTotalRestante());
			
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

	

	


	public List<ResumoAno> buscarRendimentoResumoAno(ResumoAno resumo) throws SQLException{
		PreparedStatement st = null;
		ResultSet rs = null;
		

		try {

			st = conn.prepareStatement("select * from rendimento where User = ? and Ano = ?  order by Id");
			st.setInt(1, resumo.getUser());
			st.setInt(2, resumo.getAno());
			
			rs = st.executeQuery();
			
			
			List<ResumoAno> lista = new ArrayList<>();

			while (rs.next()) {

				ResumoAno categoriaResultado = new ResumoAno();
				categoriaResultado.setUser(rs.getInt("User"));
				categoriaResultado.setAno(rs.getInt("ano"));
				categoriaResultado.setRendimentoTotal(rs.getFloat("Total"));
				categoriaResultado.setRendimentoMensal(rs.getFloat("Mensal"));
				categoriaResultado.setRendimentoOcasional(rs.getFloat("Ocasional"));
				
				lista.add(categoriaResultado);
			}

			

			return lista;


		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
		}
	}



	public List<ResumoAno> buscarInvestimentoResumoAno(ResumoAno resumo) throws SQLException{
		PreparedStatement st = null;
		ResultSet rs = null;
		

		try {

			st = conn.prepareStatement("select * from investimento where User = ? and Ano = ?  order by Id");
			st.setInt(1, resumo.getUser());
			st.setInt(2, resumo.getAno());
			
			rs = st.executeQuery();
			
			
			List<ResumoAno> lista = new ArrayList<>();

			while (rs.next()) {

				ResumoAno categoriaResultado = new ResumoAno();
				categoriaResultado.setUser(rs.getInt("User"));
				categoriaResultado.setAno(rs.getInt("ano"));
				categoriaResultado.setInvestimentoTotal(rs.getFloat("Total"));
				categoriaResultado.setInvestimentoMensal(rs.getFloat("Mensal"));
				categoriaResultado.setInvestimentoOcasional(rs.getFloat("Ocasional"));
				
				lista.add(categoriaResultado);
			}

			

			return lista;


		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
		}
	}

	public List<ResumoAno> buscarFundoDespesaResumoAno(ResumoAno resumo) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;
		


		try {

			st = conn.prepareStatement("select * from despesas_ocasionais where User = ? and Ano = ?  order by Id");
			st.setInt(1, resumo.getUser());
			st.setInt(2, resumo.getAno());
			
			rs = st.executeQuery();
			
			
			List<ResumoAno> lista = new ArrayList<>();

			while (rs.next()) {

				ResumoAno categoriaResultado = new ResumoAno();
				categoriaResultado.setUser(rs.getInt("User"));
				categoriaResultado.setAno(rs.getInt("ano"));
				categoriaResultado.setFundoDespesaTotal(rs.getFloat("Total"));
				categoriaResultado.setFundoDespesaMensal(rs.getFloat("Mensal"));
				categoriaResultado.setFundoDespesaOcasional(rs.getFloat("Ocasional"));
				
				lista.add(categoriaResultado);
			}

			

			return lista;


		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
		}
		
	}



	
	public List<Double> buscarTotalDespesasMesAnoResumoAno(ResumoAno resumo) throws SQLException{

		PreparedStatement st = null;
		ResultSet rs = null;
		


		try {

			st = conn.prepareStatement("select Total from despesas where User = ? and Ano = ? and Ocasional = ?  order by Id");
			st.setInt(1, resumo.getUser());
			st.setInt(2, resumo.getAno());
			st.setDouble(3, 0.0);
			
			rs = st.executeQuery();
			
			
			List<Double> lista = new ArrayList<>();

			while (rs.next()) {

				double categoriaResultado ;;
				categoriaResultado = rs.getDouble("Total");
				
				lista.add(categoriaResultado);
			}

			

			return lista;


		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
		}

	}


	
	public List<Double> buscarTotalDespesasOcasionaisResumoAno(ResumoAno resumo)throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		


		try {

			st = conn.prepareStatement("select Total from despesas where User = ? and Ano = ? and Mensal = ?  order by Id");
			st.setInt(1, resumo.getUser());
			st.setInt(2, resumo.getAno());
			st.setDouble(3, 0.0);
			
			rs = st.executeQuery();
			
			
			List<Double> lista = new ArrayList<>();

			while (rs.next()) {

				double categoriaResultado ;;
				categoriaResultado = rs.getDouble("Total");
				
				lista.add(categoriaResultado);
			}

			

			return lista;


		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
		}

	}



	




}

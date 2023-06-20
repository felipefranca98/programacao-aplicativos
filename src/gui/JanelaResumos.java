package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.Investimento;
import entity.ResumoAno;
import entity.ResumoMes;
import entity.Usuario;
import service.DespesasOcasionaisService;
import service.InvestimentoService;
import service.ResumoAnoService;
import service.ResumoMesService;
import service.UsuarioService;

import java.awt.GridLayout;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class JanelaResumos {

	private JFrame frmResumos;

	private static  Usuario user = new Usuario();
	private DefaultTableModel modeloMes = new DefaultTableModel();
	private DefaultTableModel modeloAno = new DefaultTableModel();
	private JTable tabelaAnual = new JTable(modeloAno);
	private JTable tabela= new JTable(modeloMes);
	private static ResumoAnoService resumoAnoService;
	private static ResumoMesService resumoMesService;
	private static String mes;
	private static String ano;
	private static boolean anual;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private static UsuarioService usuarioService = new UsuarioService();
	/**
	 * Launch the application.
	 */
	public static void main(Usuario s) {
		user.setId(s.getId());
		user.setLogin(s.getLogin());
		user.setSenha(s.getSenha());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaResumos window = new JanelaResumos();
					window.frmResumos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaResumos() {
		criaJTableMes();
		criaJTableAno();
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmResumos = new JFrame();
		frmResumos.setTitle("Resumos");
		frmResumos.setBounds(100, 100, 800, 600);
		frmResumos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmResumos.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tabela", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 160, 594, 430);
		frmResumos.getContentPane().add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 574, 395);
		panel.add(scrollPane);
		
		scrollPane.setViewportView(tabela);
		LocalDate data = LocalDate.now();
		Locale local = new Locale("pt", "BR");
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMM", local);
		JComboBox cbMes = new JComboBox();
		cbMes.setModel(new DefaultComboBoxModel(new String[] {"JAN", "FEV", "MAR", "ABR", "MAI", "JUN", "JUL", "AGO", "SET", "OUT", "NOV", "DEZ"}));
		cbMes.setSelectedItem(fmt.format(data).toUpperCase());
		cbMes.setBounds(300, 120, 65, 22);
		frmResumos.getContentPane().add(cbMes);
		cbMes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    mes = (String)cbMes.getSelectedItem();
			        System.out.println("Mes   " + mes);
			}
		});
		
		JLabel lblBarra = new JLabel("/");
		lblBarra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBarra.setBounds(280, 120, 22, 14);
		frmResumos.getContentPane().add(lblBarra);
		
		fmt = DateTimeFormatter.ofPattern("YYYY", local);		
		
		JComboBox cbAno = new JComboBox();
		cbAno.setModel(new DefaultComboBoxModel(new String[] {"2023", "2022", "2021", "2020", "2019", "2018", "..."}));
		cbAno.setSelectedItem(fmt.format(data));
		cbAno.setBounds(200, 120, 65, 22);
		frmResumos.getContentPane().add(cbAno);
		cbAno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    ano = (String)cbAno.getSelectedItem();
			        System.out.println("Ano   " + ano);
			}
		});
		
		JPanel panelTipo = new JPanel();
		panelTipo.setLayout(null);
		panelTipo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tipo de Resumo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelTipo.setBounds(10, 115, 175, 44);
		frmResumos.getContentPane().add(panelTipo);
		
		JRadioButton rdbtnOcasional = new JRadioButton("Anual");
		buttonGroup.add(rdbtnOcasional);
		rdbtnOcasional.setSelected(true);
		rdbtnOcasional.setActionCommand("Anual");
		rdbtnOcasional.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnOcasional.setBounds(8, 19, 60, 15);
		panelTipo.add(rdbtnOcasional);
		rdbtnOcasional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anual = true;


		        System.out.println("Ocasional" + anual);
			}
		});
		
		JRadioButton rdbtnMensal = new JRadioButton("Mensal");
		rdbtnMensal.setActionCommand("Mensal");
		buttonGroup.add(rdbtnMensal);
		rdbtnMensal.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMensal.setBounds(66, 19, 90, 15);
		panelTipo.add(rdbtnMensal);
		
		rdbtnMensal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anual = false;

		        System.out.println("Mensal   " + anual);
			}
		});
		
		
		JButton btnGerar = new JButton("Gerar");
		btnGerar.setBounds(400, 120, 154, 22);
		frmResumos.getContentPane().add(btnGerar);
		btnGerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
		        System.out.println("Botao   ");
			
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 24, 574, 395);
				panel.add(scrollPane);

				if(anual == true) {
			        System.out.println("Anual   ");
					cadastrarAno(modeloAno);
					listarAno(modeloAno);
					scrollPane.setViewportView(tabelaAnual);
				}
				if(anual == false)
				{
			        System.out.println("Mensal   " );
					cadastrarMes(modeloMes);
					listarMes(modeloMes);
					scrollPane.setViewportView(tabela);
				}

				
			}
		});
		
		JPanel panelModulos = new JPanel();
		panelModulos.setBorder(new TitledBorder(null, "M\u00F3dulos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelModulos.setBounds(10, 11, 594, 85);
		frmResumos.getContentPane().add(panelModulos);
		panelModulos.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnRendimentos = new JButton("Rendimentos");
		btnRendimentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaRendimentos.main(user);
				frmResumos.dispose();
			}
		});
		panelModulos.add(btnRendimentos);
		
		JButton btnDespesas = new JButton("Despesas");
		btnDespesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaDespesas.main(user);
				frmResumos.dispose();
			}
		});
		panelModulos.add(btnDespesas);
		
		JButton btnInvestimentos = new JButton("Investimentos");
		btnInvestimentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaInvestimentos.main(user);
				frmResumos.dispose();
			}
		});
		panelModulos.add(btnInvestimentos);
		
		JButton btnFundos = new JButton("Fundos de Despesas");
		btnFundos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaFundoDespesas.main(user);
				frmResumos.dispose();
			}
		});
		panelModulos.add(btnFundos);
		
		JButton btnResumos = new JButton("Resumos");
		btnResumos.setEnabled(false);
		panelModulos.add(btnResumos);
		
		JButton btnNewButton_1 = new JButton("Relat\u00F3rios");
		panelModulos.add(btnNewButton_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 107, 594, 2);
		frmResumos.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(614, 11, 1, 539);
		frmResumos.getContentPane().add(separator_1);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 user.setLog(usuarioService.logoutUsuario(user));  
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					Component frame = null;
					JOptionPane.showMessageDialog(frame,"ERROR");
				} 
				gui.JanelaInicial.main(null);
				frmResumos.dispose();
			}
		});
		btnLogout.setBounds(625, 11, 149, 57);
		frmResumos.getContentPane().add(btnLogout);
	}
	
	private void criaJTableAno() {


		modeloAno.addColumn("Descricao");
		modeloAno.addColumn("Mensal (X12)");
		modeloAno.addColumn("Ocasional");
		modeloAno.addColumn("Total Anual");
		tabelaAnual.getColumnModel().getColumn(0)
		.setPreferredWidth(80);
		tabelaAnual.getColumnModel().getColumn(1)
		.setPreferredWidth(120);
		tabelaAnual.getColumnModel().getColumn(1)
		.setPreferredWidth(80);
		tabelaAnual.getColumnModel().getColumn(1)
		.setPreferredWidth(120);
		
	}

	public static void listarAno(DefaultTableModel modeloAno) {
		resumoAnoService = new ResumoAnoService();
		modeloAno.setNumRows(0);
		ResumoAno retorno = new ResumoAno();
		retorno.setUser(user.getId());
		retorno.setAno(Integer.parseInt(ano));
		List <ResumoAno> resumo= new ArrayList<>();
		try {
			System.out.println("\t Buscar Investimento");
			resumo = resumoAnoService.listarResumoAno(retorno);
		} catch (Exception e){
			Component frame = null;
			JOptionPane.showMessageDialog(frame,"ERROR");}
	
		for (ResumoAno resumo1 : resumo) {
			modeloAno.addRow(new Object[]{"Rendimento",resumo1.getRendimentoMensal(),resumo1.getRendimentoOcasional(),
					resumo1.getRendimentoTotal()});
		modeloAno.addRow(new Object[]{"Investimento a Longo Prazo",resumo1.getInvestimentoMensal(),resumo1.getInvestimentoOcasional(),
				resumo1.getInvestimentoTotal()});

		modeloAno.addRow(new Object[]{"Fundo para Despesas Ocasionais",resumo1.getFundoDespesaMensal(),resumo1.getFundoDespesaOcasional(),
				resumo1.getFundoDespesaTotal()});

		modeloAno.addRow(new Object[]{"Total Disponível para Despesas Durante o Ano", " ", " ",
				resumo1.getValorDisponivelAno()});
			
		modeloAno.addRow(new Object[]{"Total Despesas Mensais Orçadas (12 meses) "," "," ",
				resumo1.getValorDespesasMes()});
		modeloAno.addRow(new Object[]{"Total Despesas Ocasionais para o Ano"," ", " ",
				resumo1.getTotalDespesasOcasionais()});
		modeloAno.addRow(new Object[]{"Valor Total Restante ao Final do Ano", " ", " ",
				resumo1.getTotalRestante()});

		}
			}
	
	public static void cadastrarAno(DefaultTableModel modeloAno) {
		resumoAnoService = new ResumoAnoService();
		modeloAno.setNumRows(0);
		ResumoAno retorno = new ResumoAno();
		retorno.setUser(user.getId());
		retorno.setAno(Integer.parseInt(ano));
		try {
			System.out.println("\t Buscar Investimento");
			resumoAnoService.cadastrarResumoAno(retorno);
		} catch (Exception e){
			Component frame = null;
			JOptionPane.showMessageDialog(frame,"ERROR");}
			
	}
	
	public static void cadastrarMes(DefaultTableModel modeloMes) {
		resumoMesService = new ResumoMesService();
		modeloMes.setNumRows(0);
		ResumoMes retorno = new ResumoMes();
		retorno.setUser(user.getId());
		retorno.setAno(Integer.parseInt(ano));
		 if( mes.equals("JAN"))
			 retorno.setMes(1);
		  
		  if( mes.equals("FEV"))
			  retorno.setMes(2);
		  
		  if( mes.equals("MAR"))
			  retorno.setMes(3);
		  
		  if( mes.equals("ABR"))
			  retorno.setMes(4);
		  
		  if( mes.equals("MAI"))
			  retorno.setMes(5);
		  
		  if( mes.equals("JUN"))
			  retorno.setMes(6);
		  
		  if( mes.equals("JUL"))
			  retorno.setMes(7);
		  
		  if( mes.equals("AGO"))
			  retorno.setMes(8);
		  
		  if( mes.equals("SET"))
			  retorno.setMes(9);
		  
		  if( mes.equals("OUT"))
			  retorno.setMes(10);
		  
		  if( mes.equals("NOV"))
			  retorno.setMes(11);
		  
		  if( mes.equals("DEZ"))
			  retorno.setMes(12);
		System.out.println("Ano " + retorno.getAno());
		System.out.println("Mes aaaqweqwea " + retorno.getMes());

		try {
			System.out.println("\t Buscar Investimento");
			resumoMesService.cadastrarResumoMes(retorno);
		} catch (Exception e){
			Component frame = null;
			JOptionPane.showMessageDialog(frame,"ERROR");}
			
	}
	
	private void criaJTableMes() {
		
		modeloMes.addColumn("Descricao");
		modeloMes.addColumn("Total Mensal");
		tabela.getColumnModel().getColumn(0)
		.setPreferredWidth(80);
		tabela.getColumnModel().getColumn(1)
		.setPreferredWidth(120);
	}

	public static void listarMes(DefaultTableModel modeloMes) {
		resumoMesService = new ResumoMesService();
		modeloMes.setNumRows(0);
		ResumoMes retorno = new ResumoMes();
		retorno.setUser(user.getId());
		retorno.setAno(Integer.parseInt(ano));
		 if( mes.equals("JAN"))
			 retorno.setMes(1);
		  
		  if( mes.equals("FEV"))
			  retorno.setMes(2);
		  
		  if( mes.equals("MAR"))
			  retorno.setMes(3);
		  
		  if( mes.equals("ABR"))
			  retorno.setMes(4);
		  
		  if( mes.equals("MAI"))
			  retorno.setMes(5);
		  
		  if( mes.equals("JUN"))
			  retorno.setMes(6);
		  
		  if( mes.equals("JUL"))
			  retorno.setMes(7);
		  
		  if( mes.equals("AGO"))
			  retorno.setMes(8);
		  
		  if( mes.equals("SET"))
			  retorno.setMes(9);
		  
		  if( mes.equals("OUT"))
			  retorno.setMes(10);
		  
		  if( mes.equals("NOV"))
			  retorno.setMes(11);
		  
		  if( mes.equals("DEZ"))
			  retorno.setMes(12);
		
		System.out.println("Ano " + retorno.getAno());
		System.out.println("Mes aaaa " + retorno.getMes());
		List <ResumoMes> resumo= new ArrayList<>();
		try {
			resumo = resumoMesService.buscarResumoMes(retorno);
		
			System.out.println("\t Buscar Investimento");
		} catch (Exception e){
			Component frame = null;
			JOptionPane.showMessageDialog(frame,"ERROR");}

	
		for (ResumoMes resumo1 : resumo) {
			System.out.println("\t Buscar Investimento "+ resumo1.getRendimento());
			modeloMes.addRow(new Object[]{"Rendimento",resumo1.getRendimento()});
			
			modeloMes.addRow(new Object[]{"Investimento a Longo Prazo",resumo1.getInvestimento()});

			modeloMes.addRow(new Object[]{"Fundo para Despesas Ocasionais",resumo1.getDespesa()});

			modeloMes.addRow(new Object[]{"Valor Total Disponível por Mês para Despesas",
					resumo1.getValorDisponivelMes()});
			
			modeloMes.addRow(new Object[]{"Valor Total das Despesas Orçadas para o Mês",
					resumo1.getValorDespesasMes()});
			
			modeloMes.addRow(new Object[]{"Valor Total",
					resumo1.getTotal()});
		}
	}
}

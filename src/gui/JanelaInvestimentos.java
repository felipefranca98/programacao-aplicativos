

package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import entity.Investimento;
import entity.Usuario;
import service.InvestimentoService;
import service.UsuarioService;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;


public class JanelaInvestimentos {

	private static InvestimentoService investimentoService;
	private JFrame frmInvestimentos;
	private JTable tabela;
	private static  Usuario user = new Usuario();
	private DefaultTableModel modelo = new DefaultTableModel();
	private static UsuarioService usuarioService = new UsuarioService();

	public static void main(Usuario s) {
		user.setId(s.getId());
		user.setLogin(s.getLogin());
		user.setSenha(s.getSenha());
		System.out.println( "Investimento user id " + user.getId());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaInvestimentos window = new JanelaInvestimentos();
					window.frmInvestimentos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaInvestimentos() {
		criaJTable();
		initialize();
	}

	private void initialize() {
		frmInvestimentos = new JFrame();
		frmInvestimentos.setTitle("Investimentos");
		frmInvestimentos.setBounds(100, 100, 800, 600);
		frmInvestimentos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInvestimentos.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tabela", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 120, 594, 430);
		frmInvestimentos.getContentPane().add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 574, 395);
		panel.add(scrollPane);
		
		scrollPane.setViewportView(tabela);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(614, 11, 1, 539);
		frmInvestimentos.getContentPane().add(separator);
		
		JPanel panelInvestimentos = new JPanel();
		panelInvestimentos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Investimentos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelInvestimentos.setBounds(625, 79, 149, 230);
		frmInvestimentos.getContentPane().add(panelInvestimentos);
		panelInvestimentos.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnCadastrarInv = new JButton("<html><center>Cadastrar<br>Investimento</center>");
		btnCadastrarInv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaCadastrarInvestimentos.main(user);
				frmInvestimentos.dispose();
			}
		});
		panelInvestimentos.add(btnCadastrarInv);
		
		JButton btnEditarInv = new JButton("<html><center>Editar<br>Investimento</center>");
		btnEditarInv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panelInvestimentos.add(btnEditarInv);
		
		JButton btnExcluirInv = new JButton("<html><center>Excluir<br>Investimento</center>");
		btnExcluirInv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panelInvestimentos.add(btnExcluirInv);
		
		JPanel panelModulos = new JPanel();
		panelModulos.setBorder(new TitledBorder(null, "M\u00F3dulos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelModulos.setBounds(10, 11, 594, 85);
		frmInvestimentos.getContentPane().add(panelModulos);
		panelModulos.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnRendimentos = new JButton("Rendimentos");
		btnRendimentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaRendimentos.main(user);
				frmInvestimentos.dispose();
			}
		});
		panelModulos.add(btnRendimentos);
		
		JButton btnDespesas = new JButton("Despesas");
		btnDespesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaDespesas.main(user);
				frmInvestimentos.dispose();
			}
		});
		panelModulos.add(btnDespesas);
		
		JButton btnInvestimentos = new JButton("Investimentos");
		btnInvestimentos.setEnabled(false);
		panelModulos.add(btnInvestimentos);
		
		JButton btnFundos = new JButton("Fundos de Despesas Ocasionais");
		btnFundos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaFundoDespesas.main(user);
				frmInvestimentos.dispose();
			}
		});
		panelModulos.add(btnFundos);
		
		JButton btnResumos = new JButton("Resumos");
		btnResumos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaResumos.main(user);
				frmInvestimentos.dispose();
			}
		});
		panelModulos.add(btnResumos);
		
		JButton btnNewButton_1 = new JButton("Relat\u00F3rios");
		panelModulos.add(btnNewButton_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 107, 594, 2);
		frmInvestimentos.getContentPane().add(separator_1);
		
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
				frmInvestimentos.dispose();
			}
		});
		btnLogout.setBounds(625, 11, 149, 57);
		frmInvestimentos.getContentPane().add(btnLogout);
	}
	
	private void criaJTable() {
		tabela = new JTable(modelo);
		modelo.addColumn("Investimento");
		modelo.addColumn("Mensal");
		modelo.addColumn("Ocasional");
		modelo.addColumn("Total Anual");
		tabela.getColumnModel().getColumn(0)
		.setPreferredWidth(80);
		tabela.getColumnModel().getColumn(1)
		.setPreferredWidth(120);
		tabela.getColumnModel().getColumn(1)
		.setPreferredWidth(80);
		tabela.getColumnModel().getColumn(1)
		.setPreferredWidth(120);
		pesquisar(modelo);
	}

	public static void pesquisar(DefaultTableModel modelo) {
		investimentoService = new InvestimentoService();
		modelo.setNumRows(0);
		List <Investimento> investimento= new ArrayList<>();
		try {
			System.out.println("\t Buscar Investimento");
			investimento = investimentoService.buscarInvestimento(user.getId());
		} catch (Exception e){
			Component frame = null;
			JOptionPane.showMessageDialog(frame,"ERROR");}
			

		for (Investimento investimento1 : investimento) {
			modelo.addRow(new Object[]{investimento1.getInvestimento(), investimento1.getMensal(),
					investimento1.getOcasional(), investimento1.getTotal()});
		}
	}
}

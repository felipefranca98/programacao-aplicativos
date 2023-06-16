package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
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
import javax.swing.JToolBar;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class JanelaDespesas {

	private JFrame frmDespesas;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaDespesas window = new JanelaDespesas();
					window.frmDespesas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaDespesas() {
		initialize();
	}

	private void initialize() {
		frmDespesas = new JFrame();
		frmDespesas.setTitle("Despesas");
		frmDespesas.setBounds(100, 100, 800, 600);
		frmDespesas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDespesas.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tabela", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 120, 594, 430);
		frmDespesas.getContentPane().add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 574, 395);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Categoria", "Despesa", "Mensal", "Ocasional", "Total Anual"
			}
		));
		scrollPane.setViewportView(table);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(614, 11, 1, 539);
		frmDespesas.getContentPane().add(separator);
		
		JPanel panelCategorias = new JPanel();
		panelCategorias.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Categorias", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCategorias.setBounds(625, 11, 149, 260);
		frmDespesas.getContentPane().add(panelCategorias);
		panelCategorias.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnCadastrarCat = new JButton("<html><center>Cadastrar<br>Categoria</center>");
		btnCadastrarCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaCadastrarCategorias.main(null, 2);
				frmDespesas.dispose();
			}
		});
		panelCategorias.add(btnCadastrarCat);
		
		JButton btnEditarCat = new JButton("<html><center>Editar<br>Categoria</center>");
		btnEditarCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panelCategorias.add(btnEditarCat);
		
		JButton btnExcluirCat = new JButton("<html><center>Excluir<br>Categoria</center>");
		btnExcluirCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panelCategorias.add(btnExcluirCat);
		
		JPanel panelDespesas = new JPanel();
		panelDespesas.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Despesas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDespesas.setBounds(625, 290, 149, 260);
		frmDespesas.getContentPane().add(panelDespesas);
		panelDespesas.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnCadastrarDesp = new JButton("<html><center>Cadastrar<br>Despesa</center>");
		btnCadastrarDesp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaCadastrarDespesas.main(null);
				frmDespesas.dispose();
			}
		});
		panelDespesas.add(btnCadastrarDesp);
		
		JButton btnEditarDesp = new JButton("<html><center>Editar<br>Despesa</center>");
		btnEditarDesp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panelDespesas.add(btnEditarDesp);
		
		JButton btnExcluirDesp = new JButton("<html><center>Excluir<br>Despesa</center>");
		btnExcluirDesp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panelDespesas.add(btnExcluirDesp);
		
		JPanel panelModulos = new JPanel();
		panelModulos.setBorder(new TitledBorder(null, "M\u00F3dulos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelModulos.setBounds(10, 11, 594, 85);
		frmDespesas.getContentPane().add(panelModulos);
		
		JButton btnRendimentos = new JButton("Rendimentos");
		btnRendimentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaRendimentos.main(null);
				frmDespesas.dispose();
			}
		});
		
		JButton btnDespesas = new JButton("Despesas");
		btnDespesas.setEnabled(false);
		panelModulos.setLayout(new GridLayout(0, 2, 0, 0));
		panelModulos.add(btnRendimentos);
		panelModulos.add(btnDespesas);
		
		JButton btnInvestimentos = new JButton("Investimentos");
		btnInvestimentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaInvestimentos.main(null);
				frmDespesas.dispose();
			}
		});
		panelModulos.add(btnInvestimentos);
		
		JButton btnFundos = new JButton("Fundos de Despesas");
		btnFundos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaFundoDespesas.main(null);
				frmDespesas.dispose();
			}
		});
		panelModulos.add(btnFundos);
		
		JButton btnResumos = new JButton("Resumos");
		btnResumos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaResumos.main(null);
				frmDespesas.dispose();
			}
		});
		panelModulos.add(btnResumos);
		
		JButton btnNewButton_1 = new JButton("Relat\u00F3rios");
		panelModulos.add(btnNewButton_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 107, 594, 2);
		frmDespesas.getContentPane().add(separator_1);
	}
}

package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
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

public class JanelaFundoDespesas {

	private JFrame frmFundoDespesas;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaFundoDespesas window = new JanelaFundoDespesas();
					window.frmFundoDespesas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaFundoDespesas() {
		initialize();
	}

	private void initialize() {
		frmFundoDespesas = new JFrame();
		frmFundoDespesas.setTitle("Fundo de Despesas Ocasionais");
		frmFundoDespesas.setBounds(100, 100, 800, 600);
		frmFundoDespesas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFundoDespesas.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tabela", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 120, 594, 430);
		frmFundoDespesas.getContentPane().add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 574, 395);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Fundo Ocasional", "Mensal", "Ocasional", "Total Anual"
			}
		));
		scrollPane.setViewportView(table);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(613, 11, 2, 539);
		frmFundoDespesas.getContentPane().add(separator);
		
		JPanel panelInvestimentos = new JPanel();
		panelInvestimentos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Investimentos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelInvestimentos.setBounds(625, 79, 149, 230);
		frmFundoDespesas.getContentPane().add(panelInvestimentos);
		panelInvestimentos.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnCadastrarFundo = new JButton("<html><center>Cadastrar<br>Fundo</center>");
		btnCadastrarFundo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaCadastrarFundos.main(null);
				frmFundoDespesas.dispose();
			}
		});
		panelInvestimentos.add(btnCadastrarFundo);
		
		JButton btnEditarFundo = new JButton("<html><center>Editar<br>Fundo</center>");
		panelInvestimentos.add(btnEditarFundo);
		
		JButton btnExcluirFundo = new JButton("<html><center>Excluir<br>Fundo</center>");
		panelInvestimentos.add(btnExcluirFundo);
		
		JPanel panelModulos = new JPanel();
		panelModulos.setBorder(new TitledBorder(null, "M\u00F3dulos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelModulos.setBounds(10, 11, 594, 85);
		frmFundoDespesas.getContentPane().add(panelModulos);
		panelModulos.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnRendimentos = new JButton("Rendimentos");
		btnRendimentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaRendimentos.main(null);
				frmFundoDespesas.dispose();
			}
		});
		panelModulos.add(btnRendimentos);
		
		JButton btnDespesas = new JButton("Despesas");
		btnDespesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaDespesas.main(null);
				frmFundoDespesas.dispose();
			}
		});
		panelModulos.add(btnDespesas);
		
		JButton btnInvestimentos = new JButton("Investimentos");
		btnInvestimentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaInvestimentos.main(null);
				frmFundoDespesas.dispose();
			}
		});
		panelModulos.add(btnInvestimentos);
		
		JButton btnFundos = new JButton("Fundos de Despesas Ocasionais");
		btnFundos.setEnabled(false);
		panelModulos.add(btnFundos);
		
		JButton btnResumos = new JButton("Resumos");
		btnResumos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaResumos.main(null);
				frmFundoDespesas.dispose();
			}
		});
		panelModulos.add(btnResumos);
		
		JButton btnNewButton_1 = new JButton("Relat\u00F3rios");
		panelModulos.add(btnNewButton_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 107, 594, 2);
		frmFundoDespesas.getContentPane().add(separator_1);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaInicial.main(null);
				frmFundoDespesas.dispose();
			}
		});
		btnLogout.setBounds(625, 11, 149, 57);
		frmFundoDespesas.getContentPane().add(btnLogout);
	}

}

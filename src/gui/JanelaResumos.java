package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class JanelaResumos {

	private JFrame frmResumos;
	private JTable tableDez;
	private JTable tableNov;
	private JTable tableOut;
	private JTable tableSet;
	private JTable tableJul;
	private JTable tableAgo;
	private JTable tableJun;
	private JTable tableMai;
	private JTable tableAbr;
	private JTable tableMar;
	private JTable tableFev;
	private JTable tableJan;
	private JTable tableAnual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmResumos = new JFrame();
		frmResumos.setTitle("Resumos");
		frmResumos.setBounds(100, 100, 600, 600);
		frmResumos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmResumos.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new TitledBorder(null, "Resumo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane.setBounds(10, 153, 564, 397);
		frmResumos.getContentPane().add(tabbedPane);
		
		JTabbedPane tabbedPaneMensal = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.addTab("Mensal", null, tabbedPaneMensal, null);
		
		JScrollPane scrollPaneJan = new JScrollPane();
		tabbedPaneMensal.addTab("Janeiro", null, scrollPaneJan, null);
		
		tableJan = new JTable();
		tableJan.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Descrição", "Total Mensal"
			}
		));
		scrollPaneJan.setViewportView(tableJan);
		
		JScrollPane scrollPaneFev = new JScrollPane();
		tabbedPaneMensal.addTab("Fevereiro", null, scrollPaneFev, null);
		
		tableFev = new JTable();
		tableFev.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Descrição", "Total Mensal"
			}
		));
		scrollPaneFev.setViewportView(tableFev);
		
		JScrollPane scrollPaneMar = new JScrollPane();
		tabbedPaneMensal.addTab("Mar\u00E7o", null, scrollPaneMar, null);
		
		tableMar = new JTable();
		tableMar.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Descrição", "Total Mensal"
			}
		));
		scrollPaneMar.setViewportView(tableMar);
		
		JScrollPane scrollPaneAbr = new JScrollPane();
		tabbedPaneMensal.addTab("Abril", null, scrollPaneAbr, null);
		
		tableAbr = new JTable();
		tableAbr.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Descrição", "Total Mensal"
			}
		));
		scrollPaneAbr.setViewportView(tableAbr);
		
		JScrollPane scrollPaneMai = new JScrollPane();
		tabbedPaneMensal.addTab("Maio", null, scrollPaneMai, null);
		
		tableMai = new JTable();
		tableMai.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Descrição", "Total Mensal"
			}
		));
		scrollPaneMai.setViewportView(tableMai);
		
		JScrollPane scrollPaneJun = new JScrollPane();
		tabbedPaneMensal.addTab("Junho", null, scrollPaneJun, null);
		
		tableJun = new JTable();
		tableJun.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Descrição", "Total Mensal"
			}
		));
		scrollPaneJun.setViewportView(tableJun);
		
		JScrollPane scrollPaneJul = new JScrollPane();
		tabbedPaneMensal.addTab("Julho", null, scrollPaneJul, null);
		
		tableJul = new JTable();
		tableJul.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Descrição", "Total Mensal"
			}
		));
		scrollPaneJul.setViewportView(tableJul);
		
		JScrollPane scrollPaneAgo = new JScrollPane();
		tabbedPaneMensal.addTab("Agosto", null, scrollPaneAgo, null);
		
		tableAgo = new JTable();
		tableAgo.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Descrição", "Total Mensal"
			}
		));
		scrollPaneAgo.setViewportView(tableAgo);
		
		JScrollPane scrollPaneSet = new JScrollPane();
		tabbedPaneMensal.addTab("Setembro", null, scrollPaneSet, null);
		
		tableSet = new JTable();
		tableSet.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Descrição", "Total Mensal"
			}
		));
		scrollPaneSet.setViewportView(tableSet);
		
		JScrollPane scrollPaneOut = new JScrollPane();
		tabbedPaneMensal.addTab("Outubro", null, scrollPaneOut, null);
		
		tableOut = new JTable();
		tableOut.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Descrição", "Total Mensal"
			}
		));
		scrollPaneOut.setViewportView(tableOut);
		
		JScrollPane scrollPaneNov = new JScrollPane();
		tabbedPaneMensal.addTab("Novembro", null, scrollPaneNov, null);
		
		tableNov = new JTable();
		tableNov.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Descrição", "Total Mensal"
			}
		));
		scrollPaneNov.setViewportView(tableNov);
		
		JScrollPane scrollPaneDez = new JScrollPane();
		tabbedPaneMensal.addTab("Dezembro", null, scrollPaneDez, null);
		
		tableDez = new JTable();
		tableDez.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Descrição", "Total Mensal"
			}
		));
		scrollPaneDez.setViewportView(tableDez);
		
		LocalDate data = LocalDate.now();
		Locale local = new Locale("pt", "BR");
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("M", local);
		
		tabbedPaneMensal.setSelectedIndex(Integer.valueOf(fmt.format(data)) - 1);
		
		JScrollPane scrollPaneAnual = new JScrollPane();
		tabbedPane.addTab("Anual", null, scrollPaneAnual, null);
		
		tableAnual = new JTable();
		tableAnual.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Descrição", "Mensal (x12)", "Ocasional", "Total Anual"
			}
		));
		scrollPaneAnual.setViewportView(tableAnual);
		
		fmt = DateTimeFormatter.ofPattern("YYYY", local);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2023", "2022", "2021", "2020", "2019", "..."}));
		comboBox.setSelectedItem(fmt.format(data));
		comboBox.setBounds(270, 120, 90, 22);
		frmResumos.getContentPane().add(comboBox);
		
		JLabel lblAno = new JLabel("ANO");
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAno.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAno.setBounds(214, 120, 46, 22);
		frmResumos.getContentPane().add(lblAno);
		
		JPanel panelModulos = new JPanel();
		panelModulos.setBorder(new TitledBorder(null, "M\u00F3dulos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelModulos.setBounds(10, 11, 564, 85);
		frmResumos.getContentPane().add(panelModulos);
		panelModulos.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnRendimentos = new JButton("Rendimentos");
		btnRendimentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaRendimentos.main(null);
				frmResumos.dispose();
			}
		});
		panelModulos.add(btnRendimentos);
		
		JButton btnDespesas = new JButton("Despesas");
		btnDespesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaDespesas.main(null);
				frmResumos.dispose();
			}
		});
		panelModulos.add(btnDespesas);
		
		JButton btnInvestimentos = new JButton("Investimentos");
		btnInvestimentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaInvestimentos.main(null);
				frmResumos.dispose();
			}
		});
		panelModulos.add(btnInvestimentos);
		
		JButton btnFundos = new JButton("Fundos de Despesas");
		btnFundos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaFundoDespesas.main(null);
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
		separator.setBounds(10, 107, 564, 2);
		frmResumos.getContentPane().add(separator);
	}
}

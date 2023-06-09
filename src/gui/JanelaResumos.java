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

public class JanelaResumos {

	private JFrame frmResumos;

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
		frmResumos.setBounds(100, 100, 450, 500);
		frmResumos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmResumos.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new TitledBorder(null, "Resumo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane.setBounds(10, 42, 414, 408);
		frmResumos.getContentPane().add(tabbedPane);
		
		JTabbedPane tabbedPaneMensal = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.addTab("Mensal", null, tabbedPaneMensal, null);
		
		JPanel panelJan = new JPanel();
		tabbedPaneMensal.addTab("Janeiro", null, panelJan, null);
		
		JPanel panelFev = new JPanel();
		tabbedPaneMensal.addTab("Fevereiro", null, panelFev, null);
		
		JPanel panelMar = new JPanel();
		tabbedPaneMensal.addTab("Mar\u00E7o", null, panelMar, null);
		
		JPanel panelAbr = new JPanel();
		tabbedPaneMensal.addTab("Abril", null, panelAbr, null);
		
		JPanel panelMai = new JPanel();
		tabbedPaneMensal.addTab("Maio", null, panelMai, null);
		
		JPanel panelJun = new JPanel();
		tabbedPaneMensal.addTab("Junho", null, panelJun, null);
		
		JPanel panelJul = new JPanel();
		tabbedPaneMensal.addTab("Julho", null, panelJul, null);
		
		JPanel panelAgo = new JPanel();
		tabbedPaneMensal.addTab("Agosto", null, panelAgo, null);
		
		JPanel panelSet = new JPanel();
		tabbedPaneMensal.addTab("Setembro", null, panelSet, null);
		
		JPanel panelOut = new JPanel();
		tabbedPaneMensal.addTab("Outubro", null, panelOut, null);
		
		JPanel panelNov = new JPanel();
		tabbedPaneMensal.addTab("Novembro", null, panelNov, null);
		
		JPanel panelDez = new JPanel();
		tabbedPaneMensal.addTab("Dezembro", null, panelDez, null);
		
		JPanel panelAnual = new JPanel();
		tabbedPane.addTab("Anual", null, panelAnual, null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2023", "2022", "2021", "2020", "2019", "..."}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(200, 11, 90, 22);
		frmResumos.getContentPane().add(comboBox);
		
		JLabel lblAno = new JLabel("ANO");
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAno.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAno.setBounds(144, 11, 46, 22);
		frmResumos.getContentPane().add(lblAno);
	}
}

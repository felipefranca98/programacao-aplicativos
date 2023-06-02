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

public class JanelaInvestimentos {

	private JFrame frmInvestimentos;
	private JTable table;

	public static void main(String[] args) {
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
		initialize();
	}

	private void initialize() {
		frmInvestimentos = new JFrame();
		frmInvestimentos.setTitle("Investimentos");
		frmInvestimentos.setBounds(100, 100, 800, 320);
		frmInvestimentos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInvestimentos.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tabela", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 594, 260);
		frmInvestimentos.getContentPane().add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 574, 226);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Investimento", "Mensal", "Ocasional", "Total Anual"
			}
		));
		scrollPane.setViewportView(table);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(613, 11, 2, 260);
		frmInvestimentos.getContentPane().add(separator);
		
		JPanel panelInvestimentos = new JPanel();
		panelInvestimentos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Investimentos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelInvestimentos.setBounds(625, 11, 149, 260);
		frmInvestimentos.getContentPane().add(panelInvestimentos);
		panelInvestimentos.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnCadastrarInv = new JButton("<html><center>Cadastrar<br>Investimento</center>");
		btnCadastrarInv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
	}
}

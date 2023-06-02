package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaRendimentos {

	private JFrame frmRendimentos;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaRendimentos window = new JanelaRendimentos();
					window.frmRendimentos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public JanelaRendimentos() {
		initialize();
	}

	private void initialize() {
		frmRendimentos = new JFrame();
		frmRendimentos.setTitle("Rendimentos");
		frmRendimentos.setBounds(100, 100, 800, 600);
		frmRendimentos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRendimentos.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tabela", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 594, 539);
		frmRendimentos.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 574, 506);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Categoria", "Rendimento", "Mensal", "Ocasional", "Total Anual"
			}
		));
		scrollPane.setViewportView(table);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(614, 11, 1, 539);
		frmRendimentos.getContentPane().add(separator);
		
		JPanel panelCategorias = new JPanel();
		panelCategorias.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Categorias", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCategorias.setBounds(625, 11, 149, 260);
		frmRendimentos.getContentPane().add(panelCategorias);
		
		JButton btnCadastrarCat = new JButton("<html><center>Cadastrar<br>Categoria</center>");
		btnCadastrarCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panelCategorias.setLayout(new GridLayout(0, 1, 0, 0));
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
		
		JPanel panelRendimentos = new JPanel();
		panelRendimentos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Rendimentos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelRendimentos.setBounds(625, 290, 149, 260);
		frmRendimentos.getContentPane().add(panelRendimentos);
		panelRendimentos.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnCadastrarRend = new JButton("<html><center>Cadastrar<br>Rendimento</center>");
		btnCadastrarRend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panelRendimentos.add(btnCadastrarRend);
		
		JButton btnEditarRend = new JButton("<html><center>Editar<br>Rendimento</center>");
		btnEditarRend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panelRendimentos.add(btnEditarRend);
		
		JButton btnExcluirRend = new JButton("<html><center>Excluir<br>Rendimento</center>");
		btnExcluirRend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panelRendimentos.add(btnExcluirRend);
	}
}

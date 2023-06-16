package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaCadastrarDespesas {

	private JFrame frmCadastrarDespesas;
	private JTextField textDespesa;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textValor;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCadastrarDespesas window = new JanelaCadastrarDespesas();
					window.frmCadastrarDespesas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaCadastrarDespesas() {
		initialize();
	}

	private void initialize() {
		frmCadastrarDespesas = new JFrame();
		frmCadastrarDespesas.setTitle("Cadastrar Despesas");
		frmCadastrarDespesas.setBounds(100, 100, 400, 200);
		frmCadastrarDespesas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastrarDespesas.getContentPane().setLayout(null);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(10, 15, 80, 14);
		frmCadastrarDespesas.getContentPane().add(lblCategoria);
		
		JLabel lblDespesa = new JLabel("Despesa");
		lblDespesa.setBounds(10, 43, 80, 14);
		frmCadastrarDespesas.getContentPane().add(lblDespesa);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(214, 71, 50, 14);
		frmCadastrarDespesas.getContentPane().add(lblValor);
		
		JComboBox cbCategoria = new JComboBox();
		cbCategoria.setBounds(100, 11, 274, 22);
		frmCadastrarDespesas.getContentPane().add(cbCategoria);
		
		textDespesa = new JTextField();
		textDespesa.setBounds(100, 40, 274, 20);
		frmCadastrarDespesas.getContentPane().add(textDespesa);
		textDespesa.setColumns(10);
		
		textValor = new JTextField();
		textValor.setBounds(274, 68, 100, 20);
		frmCadastrarDespesas.getContentPane().add(textValor);
		textValor.setColumns(10);
		
		JPanel panelTipo = new JPanel();
		panelTipo.setBorder(new TitledBorder(null, "Tipo de Despesa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTipo.setBounds(10, 68, 175, 80);
		frmCadastrarDespesas.getContentPane().add(panelTipo);
		panelTipo.setLayout(null);
		
		JRadioButton rdbtnOcasional = new JRadioButton("Ocasional");
		rdbtnOcasional.setSelected(true);
		rdbtnOcasional.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(rdbtnOcasional);
		rdbtnOcasional.setBounds(6, 19, 163, 23);
		panelTipo.add(rdbtnOcasional);
		
		JRadioButton rdbtnMensal = new JRadioButton("Mensal");
		rdbtnMensal.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(rdbtnMensal);
		rdbtnMensal.setBounds(6, 45, 163, 23);
		panelTipo.add(rdbtnMensal);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setEnabled(false);
		btnCadastrar.setBounds(214, 96, 160, 23);
		frmCadastrarDespesas.getContentPane().add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaDespesas.main(null);
				frmCadastrarDespesas.dispose();
			}
		});
		btnCancelar.setBounds(214, 125, 160, 23);
		frmCadastrarDespesas.getContentPane().add(btnCancelar);
	}
}

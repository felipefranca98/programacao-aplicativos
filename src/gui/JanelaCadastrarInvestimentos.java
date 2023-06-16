package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaCadastrarInvestimentos {

	private JFrame frmCadastrarInvestimentos;
	private JTextField textInvestimento;
	private JTextField textValor;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCadastrarInvestimentos window = new JanelaCadastrarInvestimentos();
					window.frmCadastrarInvestimentos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaCadastrarInvestimentos() {
		initialize();
	}

	private void initialize() {
		frmCadastrarInvestimentos = new JFrame();
		frmCadastrarInvestimentos.setTitle("Cadastrar Investimentos");
		frmCadastrarInvestimentos.setBounds(100, 100, 400, 170);
		frmCadastrarInvestimentos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastrarInvestimentos.getContentPane().setLayout(null);
		
		JLabel lblInvestimento = new JLabel("Investimento");
		lblInvestimento.setBounds(10, 14, 80, 14);
		frmCadastrarInvestimentos.getContentPane().add(lblInvestimento);
		
		textInvestimento = new JTextField();
		textInvestimento.setColumns(10);
		textInvestimento.setBounds(100, 11, 274, 20);
		frmCadastrarInvestimentos.getContentPane().add(textInvestimento);
		
		JPanel panelTipo = new JPanel();
		panelTipo.setLayout(null);
		panelTipo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tipo de Investimento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelTipo.setBounds(10, 39, 175, 80);
		frmCadastrarInvestimentos.getContentPane().add(panelTipo);
		
		JRadioButton rdbtnOcasional = new JRadioButton("Ocasional");
		buttonGroup.add(rdbtnOcasional);
		rdbtnOcasional.setSelected(true);
		rdbtnOcasional.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnOcasional.setBounds(6, 19, 163, 23);
		panelTipo.add(rdbtnOcasional);
		
		JRadioButton rdbtnMensal = new JRadioButton("Mensal");
		buttonGroup.add(rdbtnMensal);
		rdbtnMensal.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMensal.setBounds(6, 45, 163, 23);
		panelTipo.add(rdbtnMensal);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(214, 42, 50, 14);
		frmCadastrarInvestimentos.getContentPane().add(lblValor);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(274, 39, 100, 20);
		frmCadastrarInvestimentos.getContentPane().add(textValor);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setEnabled(false);
		btnCadastrar.setBounds(214, 67, 160, 23);
		frmCadastrarInvestimentos.getContentPane().add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaInvestimentos.main(null);
				frmCadastrarInvestimentos.dispose();
			}
		});
		btnCancelar.setBounds(214, 96, 160, 23);
		frmCadastrarInvestimentos.getContentPane().add(btnCancelar);
	}

}

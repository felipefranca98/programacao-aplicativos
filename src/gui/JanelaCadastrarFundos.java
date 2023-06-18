package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class JanelaCadastrarFundos {

	private JFrame frmCadastrarFundos;
	private JTextField textFundoOcasional;
	private JTextField textValor;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCadastrarFundos window = new JanelaCadastrarFundos();
					window.frmCadastrarFundos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaCadastrarFundos() {
		initialize();
	}

	private void initialize() {
		frmCadastrarFundos = new JFrame();
		frmCadastrarFundos.setTitle("Cadastrar Fundos de Despesas Ocasionais");
		frmCadastrarFundos.setBounds(100, 100, 400, 170);
		frmCadastrarFundos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastrarFundos.getContentPane().setLayout(null);
		
		JLabel lblFundoOcasional = new JLabel("Fundo Ocasional");
		lblFundoOcasional.setBounds(10, 14, 104, 14);
		frmCadastrarFundos.getContentPane().add(lblFundoOcasional);
		
		textFundoOcasional = new JTextField();
		textFundoOcasional.setColumns(10);
		textFundoOcasional.setBounds(124, 11, 250, 20);
		frmCadastrarFundos.getContentPane().add(textFundoOcasional);
		
		JPanel panelTipo = new JPanel();
		panelTipo.setLayout(null);
		panelTipo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tipo de Fundo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelTipo.setBounds(10, 39, 175, 80);
		frmCadastrarFundos.getContentPane().add(panelTipo);
		
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
		frmCadastrarFundos.getContentPane().add(lblValor);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(274, 39, 100, 20);
		frmCadastrarFundos.getContentPane().add(textValor);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setEnabled(false);
		btnCadastrar.setBounds(214, 67, 160, 23);
		frmCadastrarFundos.getContentPane().add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaFundoDespesas.main(null);
				frmCadastrarFundos.dispose();
			}
		});
		btnCancelar.setBounds(214, 96, 160, 23);
		frmCadastrarFundos.getContentPane().add(btnCancelar);
	}

}

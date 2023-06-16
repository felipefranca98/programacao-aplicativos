package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaCadastrarRendimentos {

	private JFrame frmCadastrarRendimentos;
	private JTextField textRendimento;
	private JTextField textValor;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCadastrarRendimentos window = new JanelaCadastrarRendimentos();
					window.frmCadastrarRendimentos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaCadastrarRendimentos() {
		initialize();
	}

	private void initialize() {
		frmCadastrarRendimentos = new JFrame();
		frmCadastrarRendimentos.setTitle("Cadastrar Rendimentos");
		frmCadastrarRendimentos.setBounds(100, 100, 400, 200);
		frmCadastrarRendimentos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastrarRendimentos.getContentPane().setLayout(null);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(10, 15, 80, 14);
		frmCadastrarRendimentos.getContentPane().add(lblCategoria);
		
		JComboBox cbCategoria = new JComboBox();
		cbCategoria.setBounds(100, 11, 274, 22);
		frmCadastrarRendimentos.getContentPane().add(cbCategoria);
		
		JLabel lblRendimento = new JLabel("Rendimento");
		lblRendimento.setBounds(10, 43, 80, 14);
		frmCadastrarRendimentos.getContentPane().add(lblRendimento);
		
		textRendimento = new JTextField();
		textRendimento.setColumns(10);
		textRendimento.setBounds(100, 40, 274, 20);
		frmCadastrarRendimentos.getContentPane().add(textRendimento);
		
		JPanel panelTipo = new JPanel();
		panelTipo.setLayout(null);
		panelTipo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tipo de Rendimento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelTipo.setBounds(10, 68, 175, 80);
		frmCadastrarRendimentos.getContentPane().add(panelTipo);
		
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
		lblValor.setBounds(214, 71, 50, 14);
		frmCadastrarRendimentos.getContentPane().add(lblValor);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(274, 68, 100, 20);
		frmCadastrarRendimentos.getContentPane().add(textValor);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setEnabled(false);
		btnCadastrar.setBounds(214, 96, 160, 23);
		frmCadastrarRendimentos.getContentPane().add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaRendimentos.main(null);
				frmCadastrarRendimentos.dispose();
			}
		});
		btnCancelar.setBounds(214, 125, 160, 23);
		frmCadastrarRendimentos.getContentPane().add(btnCancelar);
	}

}

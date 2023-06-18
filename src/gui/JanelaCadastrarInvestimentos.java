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
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.Font;

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
		frmCadastrarInvestimentos.setBounds(100, 100, 400, 200);
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
		panelTipo.setBounds(10, 70, 175, 80);
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
		lblValor.setBounds(254, 42, 50, 14);
		frmCadastrarInvestimentos.getContentPane().add(lblValor);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(294, 39, 80, 20);
		frmCadastrarInvestimentos.getContentPane().add(textValor);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(214, 93, 160, 23);
		frmCadastrarInvestimentos.getContentPane().add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaInvestimentos.main(null);
				frmCadastrarInvestimentos.dispose();
			}
		});
		btnCancelar.setBounds(214, 127, 160, 23);
		frmCadastrarInvestimentos.getContentPane().add(btnCancelar);
		
		JLabel lblMesAno = new JLabel("Mês/Ano");
		lblMesAno.setBounds(10, 42, 65, 14);
		frmCadastrarInvestimentos.getContentPane().add(lblMesAno);
		
		LocalDate data = LocalDate.now();
		Locale local = new Locale("pt", "BR");
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMM", local);
		
		JComboBox cbMes = new JComboBox();
		cbMes.setModel(new DefaultComboBoxModel(new String[] {"JAN", "FEV", "MAR", "ABR", "MAI", "JUN", "JUL", "AGO", "SET", "OUT", "NOV", "DEZ"}));
		cbMes.setSelectedItem(fmt.format(data).toUpperCase());
		cbMes.setBounds(69, 39, 65, 22);
		frmCadastrarInvestimentos.getContentPane().add(cbMes);
		
		JLabel lblBarra = new JLabel("/");
		lblBarra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBarra.setBounds(141, 42, 22, 14);
		frmCadastrarInvestimentos.getContentPane().add(lblBarra);
		
		fmt = DateTimeFormatter.ofPattern("YYYY", local);
		
		JComboBox cbAno = new JComboBox();
		cbAno.setModel(new DefaultComboBoxModel(new String[] {"2023", "2022", "2021", "2020", "2019", "2018", "..."}));
		cbAno.setSelectedItem(fmt.format(data));
		cbAno.setBounds(154, 39, 65, 22);
		frmCadastrarInvestimentos.getContentPane().add(cbAno);
	}

}

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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;

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
		frmCadastrarFundos.setBounds(100, 100, 400, 200);
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
		panelTipo.setBounds(10, 67, 175, 80);
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
		lblValor.setBounds(254, 42, 50, 14);
		frmCadastrarFundos.getContentPane().add(lblValor);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(294, 39, 80, 20);
		frmCadastrarFundos.getContentPane().add(textValor);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setEnabled(false);
		btnCadastrar.setBounds(214, 90, 160, 23);
		frmCadastrarFundos.getContentPane().add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaFundoDespesas.main(null);
				frmCadastrarFundos.dispose();
			}
		});
		btnCancelar.setBounds(214, 124, 160, 23);
		frmCadastrarFundos.getContentPane().add(btnCancelar);
		
		JLabel lblMesAno = new JLabel("M�s/Ano");
		lblMesAno.setBounds(10, 42, 65, 14);
		frmCadastrarFundos.getContentPane().add(lblMesAno);
		
		LocalDate data = LocalDate.now();
		Locale local = new Locale("pt", "BR");
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMM", local);
		
		JComboBox cbMes = new JComboBox();
		cbMes.setModel(new DefaultComboBoxModel(new String[] {"JAN", "FEV", "MAR", "ABR", "MAI", "JUN", "JUL", "AGO", "SET", "OUT", "NOV", "DEZ"}));
		cbMes.setSelectedItem(fmt.format(data).toUpperCase());
		cbMes.setBounds(69, 39, 65, 22);
		frmCadastrarFundos.getContentPane().add(cbMes);
		
		JLabel lblBarra = new JLabel("/");
		lblBarra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBarra.setBounds(141, 42, 22, 14);
		frmCadastrarFundos.getContentPane().add(lblBarra);
		
		fmt = DateTimeFormatter.ofPattern("YYYY", local);		
		
		JComboBox cbAno = new JComboBox();
		cbAno.setModel(new DefaultComboBoxModel(new String[] {"2023", "2022", "2021", "2020", "2019", "2018", "..."}));
		cbAno.setSelectedItem(fmt.format(data));
		cbAno.setBounds(154, 39, 65, 22);
		frmCadastrarFundos.getContentPane().add(cbAno);
	}
}

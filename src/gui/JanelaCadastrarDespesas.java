package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.Font;

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
		frmCadastrarDespesas.setBounds(100, 100, 400, 230);
		frmCadastrarDespesas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastrarDespesas.getContentPane().setLayout(null);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(10, 15, 80, 14);
		frmCadastrarDespesas.getContentPane().add(lblCategoria);
		
		JLabel lblDespesa = new JLabel("Despesa");
		lblDespesa.setBounds(10, 43, 80, 14);
		frmCadastrarDespesas.getContentPane().add(lblDespesa);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(254, 71, 50, 14);
		frmCadastrarDespesas.getContentPane().add(lblValor);
		
		JComboBox cbCategoria = new JComboBox();
		cbCategoria.setBounds(100, 11, 274, 22);
		frmCadastrarDespesas.getContentPane().add(cbCategoria);
		
		textDespesa = new JTextField();
		textDespesa.setBounds(100, 40, 274, 20);
		frmCadastrarDespesas.getContentPane().add(textDespesa);
		textDespesa.setColumns(10);
		
		textValor = new JTextField();
		textValor.setBounds(294, 68, 80, 20);
		frmCadastrarDespesas.getContentPane().add(textValor);
		textValor.setColumns(10);
		
		JPanel panelTipo = new JPanel();
		panelTipo.setBorder(new TitledBorder(null, "Tipo de Despesa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTipo.setBounds(10, 100, 175, 80);
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
		btnCadastrar.setBounds(214, 123, 160, 23);
		frmCadastrarDespesas.getContentPane().add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaDespesas.main(null);
				frmCadastrarDespesas.dispose();
			}
		});
		btnCancelar.setBounds(214, 157, 160, 23);
		frmCadastrarDespesas.getContentPane().add(btnCancelar);
		
		JLabel lblMesAno = new JLabel("Mês/Ano");
		lblMesAno.setBounds(10, 71, 65, 14);
		frmCadastrarDespesas.getContentPane().add(lblMesAno);
		
		LocalDate data = LocalDate.now();
		Locale local = new Locale("pt", "BR");
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMM", local);
		
		JComboBox cbMes = new JComboBox();
		cbMes.setModel(new DefaultComboBoxModel(new String[] {"JAN", "FEV", "MAR", "ABR", "MAI", "JUN", "JUL", "AGO", "SET", "OUT", "NOV", "DEZ"}));
		cbMes.setSelectedItem(fmt.format(data).toUpperCase());
		cbMes.setBounds(69, 68, 65, 22);
		frmCadastrarDespesas.getContentPane().add(cbMes);
		
		JLabel lblBarra = new JLabel("/");
		lblBarra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBarra.setBounds(141, 71, 22, 14);
		frmCadastrarDespesas.getContentPane().add(lblBarra);
		
		fmt = DateTimeFormatter.ofPattern("YYYY", local);
		
		JComboBox cbAno = new JComboBox();
		cbAno.setModel(new DefaultComboBoxModel(new String[] {"2023", "2022", "2021", "2020", "2019", "2018", "..."}));
		cbAno.setSelectedItem(fmt.format(data));
		cbAno.setBounds(154, 68, 65, 22);
		frmCadastrarDespesas.getContentPane().add(cbAno);
	}
}

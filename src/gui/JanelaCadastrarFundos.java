/*package gui;

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
		
		JLabel lblMesAno = new JLabel("Mês/Ano");
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
*/

package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import entity.Despesas;
import entity.DespesasOcasionais;
import entity.Tipo;
import entity.Usuario;
import service.DespesasOcasionaisService;
import service.TipoService;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
	private String mes;
	private String ano;
	private boolean frequencia;
	private DespesasOcasionais despesa = new DespesasOcasionais();
	private static DespesasOcasionaisService despesaService;
	
	private static  Usuario user = new Usuario();


	public static void main(Usuario s) {
		user.setId(s.getId());
		user.setLogin(s.getLogin());
		user.setSenha(s.getSenha());
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
		panelTipo.setBounds(10, 70, 175, 80);
		frmCadastrarFundos.getContentPane().add(panelTipo);
		
		JRadioButton rdbtnOcasional = new JRadioButton("Ocasional");
		buttonGroup.add(rdbtnOcasional);
		rdbtnOcasional.setSelected(true);
		rdbtnOcasional.setActionCommand("Ocasional");
		rdbtnOcasional.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnOcasional.setBounds(6, 19, 163, 23);
		panelTipo.add(rdbtnOcasional);
		rdbtnOcasional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frequencia = false;


		        System.out.println("Ocasional" + frequencia);
			}
		});
		
		JRadioButton rdbtnMensal = new JRadioButton("Mensal");
		rdbtnMensal.setActionCommand("Mensal");
		buttonGroup.add(rdbtnMensal);
		rdbtnMensal.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMensal.setBounds(6, 45, 163, 23);
		panelTipo.add(rdbtnMensal);
		
		rdbtnMensal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frequencia = true;

		        System.out.println("Mensal   " + frequencia);
			}
		});
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(254, 42, 50, 14);
		frmCadastrarFundos.getContentPane().add(lblValor);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(294, 39, 80, 20);
		frmCadastrarFundos.getContentPane().add(textValor);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(214, 93, 160, 23);
		frmCadastrarFundos.getContentPane().add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				despesa = montaDespesa();  
				despesaService = new DespesasOcasionaisService();
				
				try {
					 despesaService.cadastrarDespesa(despesa);  
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					Component frame = null;
					JOptionPane.showMessageDialog(frame,"ERROR");
				} 
			
				                  JOptionPane.showMessageDialog(null, "Despesa cadastrado.");  
				                  limpaTela();  
			
				gui.JanelaFundoDespesas.main(user);
				frmCadastrarFundos.dispose();
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaFundoDespesas.main(user);
				frmCadastrarFundos.dispose();
			}
		});
		btnCancelar.setBounds(214, 127, 160, 23);
		frmCadastrarFundos.getContentPane().add(btnCancelar);
		
		JLabel lblMesAno = new JLabel("Mês/Ano");
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
		cbMes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    mes = (String)cbMes.getSelectedItem();
			        System.out.println("Mes   " + mes);
			}
		});
		
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
		cbAno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    ano = (String)cbAno.getSelectedItem();
			        System.out.println("Ano   " + ano);
			}
		});
	}
	
	  public void limpaTela() {  
		  this.textFundoOcasional.setText("");
          
          this.textValor.setText("");  
        }  
  
       
  
	public DespesasOcasionais montaDespesa() { // Pega dos dados digitados nos campos do  
          // formulário e atribui ao objeto  
    	 DespesasOcasionais lg = new DespesasOcasionais();  
          lg.setUser(user.getId());  
          lg.setAno(Integer.parseInt(ano));

          lg.setFundo(this.textFundoOcasional.getText());
          if(frequencia == true)
          {
        	  lg.setMensal(Double.parseDouble(this.textValor.getText()));
        	  lg.setOcasional(0.0);

          }
          if(frequencia == false)
          {
        	  lg.setOcasional(Double.parseDouble(this.textValor.getText()));
        	  lg.setMensal(0.0);
          }
          
          switch(mes) {
          case "JAN":
        	  lg.setMes(1);
          case "FEV":
        	  lg.setMes(2);
          case "MAR":
        	  lg.setMes(3);
          case "ABR":
        	  lg.setMes(4);
          case "MAI":
        	  lg.setMes(5);
          case "JUN":
        	  lg.setMes(6);
          case "JUL":
        	  lg.setMes(7);
          case "AGO":
        	  lg.setMes(8);
          case "SET":
        	  lg.setMes(9);
          case "OUT":
        	  lg.setMes(10);
          case "NOV":
        	  lg.setMes(11);
          case "DEZ":
        	  lg.setMes(12);
          }

          return lg;  
  
     }  
	

	
	
}

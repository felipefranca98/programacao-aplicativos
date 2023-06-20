/*package gui;

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
		btnCadastrar.setEnabled(false);
		btnCadastrar.setBounds(214, 96, 160, 23);
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
*/

package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import entity.DespesasOcasionais;
import entity.Investimento;
import entity.Usuario;
import service.DespesasOcasionaisService;
import service.InvestimentoService;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Component;

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
	private String mes;
	private String ano;
	private boolean frequencia;
	private Investimento investimento = new Investimento();
	private static InvestimentoService investimentoService;
	
	private static  Usuario user = new Usuario();
	public static void main(Usuario s) {
		user.setId(s.getId());
		user.setLogin(s.getLogin());
		user.setSenha(s.getSenha());
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
		rdbtnOcasional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frequencia = false;


		        System.out.println("Ocasional" + frequencia);
			}
		});
		
		JRadioButton rdbtnMensal = new JRadioButton("Mensal");
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
		frmCadastrarInvestimentos.getContentPane().add(lblValor);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(294, 39, 80, 20);
		frmCadastrarInvestimentos.getContentPane().add(textValor);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(214, 93, 160, 23);
		frmCadastrarInvestimentos.getContentPane().add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				investimento = montaInvestimento();  
				  if( mes.equals("JAN"))
					  investimento.setMes(1);
				  
				  if( mes.equals("FEV"))
					  investimento.setMes(2);
				  
				  if( mes.equals("MAR"))
					  investimento.setMes(3);
				  
				  if( mes.equals("ABR"))
					  investimento.setMes(4);
				  
				  if( mes.equals("MAI"))
					  investimento.setMes(5);
				  
				  if( mes.equals("JUN"))
					  investimento.setMes(6);
				  
				  if( mes.equals("JUL"))
					  investimento.setMes(7);
				  
				  if( mes.equals("AGO"))
					  investimento.setMes(8);
				  
				  if( mes.equals("SET"))
					  investimento.setMes(9);
				  
				  if( mes.equals("OUT"))
					  investimento.setMes(10);
				  
				  if( mes.equals("NOV"))
					  investimento.setMes(11);
				  
				  if( mes.equals("DEZ"))
					  investimento.setMes(12);
				  
				     System.out.println("Mes   " + investimento.getMes());
				investimentoService = new InvestimentoService();
				
				try {
					 investimentoService.cadastrarInvestimento(investimento);  
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					Component frame = null;
					JOptionPane.showMessageDialog(frame,"ERROR");
				} 
			
				                  JOptionPane.showMessageDialog(null, "Despesa cadastrado.");  
				                  limpaTela();  
			
				gui.JanelaInvestimentos.main(user);
				frmCadastrarInvestimentos.dispose();
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaInvestimentos.main(user);
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
		cbMes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    mes = (String)cbMes.getSelectedItem();
				
			        System.out.println("Mes   " + mes);
			}
		});
		
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
		cbAno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    ano = (String)cbAno.getSelectedItem();
			        System.out.println("Ano   " + ano);
			}
		});
	}
	
	 public void limpaTela() {  
		  this.textInvestimento.setText("");
         
         this.textValor.setText("");  
       }  
 
      
 
	public Investimento montaInvestimento() { // Pega dos dados digitados nos campos do  
         // formulário e atribui ao objeto  
   	 Investimento lg = new Investimento();  
         lg.setUser(user.getId());  
         lg.setAno(Integer.parseInt(ano));

         lg.setInvestimento(this.textInvestimento.getText());
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
         
       

         return lg;  
 
    }  
	

	

}

/*package gui;

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
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.Font;

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
		frmCadastrarRendimentos.setBounds(100, 100, 400, 230);
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
		panelTipo.setBounds(10, 100, 175, 80);
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
		lblValor.setBounds(254, 71, 50, 14);
		frmCadastrarRendimentos.getContentPane().add(lblValor);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(294, 68, 80, 20);
		frmCadastrarRendimentos.getContentPane().add(textValor);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setEnabled(false);
		btnCadastrar.setBounds(214, 123, 160, 23);
		frmCadastrarRendimentos.getContentPane().add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaRendimentos.main(null);
				frmCadastrarRendimentos.dispose();
			}
		});
		btnCancelar.setBounds(214, 157, 160, 23);
		frmCadastrarRendimentos.getContentPane().add(btnCancelar);
		
		JLabel lblMesAno = new JLabel("Mês/Ano");
		lblMesAno.setBounds(10, 71, 65, 14);
		frmCadastrarRendimentos.getContentPane().add(lblMesAno);
		
		LocalDate data = LocalDate.now();
		Locale local = new Locale("pt", "BR");
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMM", local);
		
		JComboBox cbMes = new JComboBox();
		cbMes.setModel(new DefaultComboBoxModel(new String[] {"JAN", "FEV", "MAR", "ABR", "MAI", "JUN", "JUL", "AGO", "SET", "OUT", "NOV", "DEZ"}));
		cbMes.setSelectedItem(fmt.format(data).toUpperCase());
		cbMes.setBounds(69, 68, 65, 22);
		frmCadastrarRendimentos.getContentPane().add(cbMes);
		
		JLabel lblBarra = new JLabel("/");
		lblBarra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBarra.setBounds(141, 71, 22, 14);
		frmCadastrarRendimentos.getContentPane().add(lblBarra);
		
		fmt = DateTimeFormatter.ofPattern("YYYY", local);
		
		JComboBox cbAno = new JComboBox();
		cbAno.setModel(new DefaultComboBoxModel(new String[] {"2023", "2022", "2021", "2020", "2019", "2018", "..."}));
		cbAno.setSelectedItem(fmt.format(data));
		cbAno.setBounds(154, 68, 65, 22);
		frmCadastrarRendimentos.getContentPane().add(cbAno);
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

import entity.Tipo;
import service.TipoService;
import entity.Rendimento;
import entity.Usuario;
import service.RendimentoService;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class JanelaCadastrarRendimentos {
	private static RendimentoService rendimentoService;
	private static TipoService tipoService;
	
	private static  Usuario user = new Usuario();
	private Rendimento rendimento = new Rendimento();
	private String categoria;
	private String mes;
	private String ano;
	private boolean frequencia;
	private static JComboBox cbCategoria = new JComboBox();
	
	private JFrame frmCadastrarRendimentos;
	private JTextField textRendimento;
	private JTextField textValor;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public static void main(Usuario s) {
		user.setId(s.getId());
		user.setLogin(s.getLogin());
		user.setSenha(s.getSenha());
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
		criaJComboBox();
		initialize();
	}

	private void initialize() {
		frmCadastrarRendimentos = new JFrame();
		frmCadastrarRendimentos.setTitle("Cadastrar Rendimentos");
		frmCadastrarRendimentos.setBounds(100, 100, 400, 230);
		frmCadastrarRendimentos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastrarRendimentos.getContentPane().setLayout(null);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(10, 15, 80, 14);
		frmCadastrarRendimentos.getContentPane().add(lblCategoria);
		
		cbCategoria.setBounds(100, 11, 274, 22);
		frmCadastrarRendimentos.getContentPane().add(cbCategoria);
		cbCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    categoria = (String)cbCategoria.getSelectedItem();
			        System.out.println("CATEGORIA   " + categoria);
			}
		});

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
		panelTipo.setBounds(10, 100, 175, 80);
		frmCadastrarRendimentos.getContentPane().add(panelTipo);
		
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
		buttonGroup.add(rdbtnMensal);
		rdbtnMensal.setActionCommand("Mensal");
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
		lblValor.setBounds(254, 71, 50, 14);
		frmCadastrarRendimentos.getContentPane().add(lblValor);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(294, 68, 80, 20);
		frmCadastrarRendimentos.getContentPane().add(textValor);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(214, 123, 160, 23);
		frmCadastrarRendimentos.getContentPane().add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rendimento = montaRendimento();  
				rendimentoService = new RendimentoService();
				System.out.println(rendimento);
				
				try {
					 rendimentoService.cadastrarRendimento(rendimento);  
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					Component frame = null;
					JOptionPane.showMessageDialog(frame,"ERROR");
				} 
			
				                  JOptionPane.showMessageDialog(null, "Despesa cadastrado.");  
				                  limpaTela();  
			
				              	gui.JanelaRendimentos.main(user);
								frmCadastrarRendimentos.dispose();
							
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.JanelaRendimentos.main(user);
				frmCadastrarRendimentos.dispose();
			}
		});
		btnCancelar.setBounds(214, 157, 160, 23);
		frmCadastrarRendimentos.getContentPane().add(btnCancelar);
		
		JLabel lblMesAno = new JLabel("Mês/Ano");
		lblMesAno.setBounds(10, 71, 65, 14);
		frmCadastrarRendimentos.getContentPane().add(lblMesAno);
		
		LocalDate data = LocalDate.now();
		Locale local = new Locale("pt", "BR");
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMM", local);
		
		JComboBox cbMes = new JComboBox();
		cbMes.setModel(new DefaultComboBoxModel(new String[] {"JAN", "FEV", "MAR", "ABR", "MAI", "JUN", "JUL", "AGO", "SET", "OUT", "NOV", "DEZ"}));
		cbMes.setSelectedItem(fmt.format(data).toUpperCase());
		cbMes.setBounds(69, 68, 65, 22);
		frmCadastrarRendimentos.getContentPane().add(cbMes);
		cbMes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    mes = (String)cbMes.getSelectedItem();
			        System.out.println("Mes   " + mes);
			}
		});
		
		JLabel lblBarra = new JLabel("/");
		lblBarra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBarra.setBounds(141, 71, 22, 14);
		frmCadastrarRendimentos.getContentPane().add(lblBarra);
		
		fmt = DateTimeFormatter.ofPattern("YYYY", local);
		
		JComboBox cbAno = new JComboBox();
		cbAno.setModel(new DefaultComboBoxModel(new String[] {"2023", "2022", "2021", "2020", "2019", "2018", "..."}));
		cbAno.setSelectedItem(fmt.format(data));
		cbAno.setBounds(154, 68, 65, 22);
		frmCadastrarRendimentos.getContentPane().add(cbAno);
		cbAno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    ano = (String)cbAno.getSelectedItem();
			        System.out.println("Ano   " + ano);
			}
		});
	}
	
	
	public void limpaTela() {  
        this.textRendimento.setText("");  
        this.textValor.setText("");  
      }  

	
	public Rendimento montaRendimento() { // Pega dos dados digitados nos campos do  
        // formulário e atribui ao objeto  
  	 Rendimento lg = new Rendimento();  
        lg.setUser(user.getId());  
        lg.setAno(Integer.parseInt(ano));
        lg.setCategoria(categoria);
        lg.setRendimento(this.textRendimento.getText());
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
	
	private void criaJComboBox() {
		cbCategoria.removeAllItems();
		System.out.println("\t Busasdsacar Investimento");
		pesquisar();
		
	}

	public static void pesquisar() {
		tipoService = new TipoService();
		System.out.println("\t Buscar tipo");		
		List <Tipo> categoria= new ArrayList<>();
		try {
			System.out.println("\t Buscar Investimento");
			categoria = tipoService.buscarTipo("Rendimento");
		} catch (Exception e){
			Component frame = null;
			JOptionPane.showMessageDialog(frame,"ERROR");}
			

		for (Tipo tipo1 : categoria) {
			  cbCategoria.addItem(tipo1.getNome());
			   
		}
	}

}

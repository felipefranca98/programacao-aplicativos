/*package gui;

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
*/

package gui;

import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import entity.Despesas;
import entity.Usuario;
import entity.Tipo;
import service.DespesasService;
import service.TipoService;
import service.UsuarioService;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class JanelaCadastrarDespesas {
	private static DespesasService despesaService;
	private static TipoService tipoService;
	private JFrame frmCadastrarDespesas;
	private JTextField textDespesa;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textValor;
	private static JComboBox cbCategoria = new JComboBox();
	private static  Usuario user = new Usuario();
	private Despesas despesa = new Despesas();
	private String categoria;
	private String mes;
	private String ano;
	private boolean frequencia;
	
	public static void main(Usuario s) {
		user.setId(s.getId());
		user.setLogin(s.getLogin());
		user.setSenha(s.getSenha());
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
		criaJComboBox();
		System.out.println("\t Buscar Investimensadasdasdsadto");
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
		
		
		cbCategoria.setBounds(100, 11, 274, 22);
		frmCadastrarDespesas.getContentPane().add(cbCategoria);
		cbCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    categoria = (String)cbCategoria.getSelectedItem();
			        System.out.println("CATEGORIA   " + categoria);
			}
		});
		
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
		rdbtnOcasional.setActionCommand("Ocasional");
		rdbtnOcasional.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(rdbtnOcasional);
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
		rdbtnMensal.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(rdbtnMensal);
		rdbtnMensal.setBounds(6, 45, 163, 23);
		panelTipo.add(rdbtnMensal);
		
		rdbtnMensal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frequencia = true;

		        System.out.println("Mensal   " + frequencia);
			}
		});

		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(214, 123, 160, 23);
		frmCadastrarDespesas.getContentPane().add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        
				despesa = montaDespesa();  
				  if( mes.equals("JAN"))
		        	  despesa.setMes(1);
				  
				  if( mes.equals("FEV"))
		        	  despesa.setMes(2);
				  
				  if( mes.equals("MAR"))
		        	  despesa.setMes(3);
				  
				  if( mes.equals("ABR"))
		        	  despesa.setMes(4);
				  
				  if( mes.equals("MAI"))
		        	  despesa.setMes(5);
				  
				  if( mes.equals("JUN"))
		        	  despesa.setMes(6);
				  
				  if( mes.equals("JUL"))
		        	  despesa.setMes(7);
				  
				  if( mes.equals("AGO"))
		        	  despesa.setMes(8);
				  
				  if( mes.equals("SET"))
		        	  despesa.setMes(9);
				  
				  if( mes.equals("OUT"))
		        	  despesa.setMes(10);
				  
				  if( mes.equals("NOV"))
		        	  despesa.setMes(11);
				  
				  if( mes.equals("DEZ"))
		        	  despesa.setMes(12);
				  
				     System.out.println("Mes   " + despesa.getMes());
				despesaService = new DespesasService();
				
				try {
					 despesaService.cadastrarDespesa(despesa);  
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					Component frame = null;
					JOptionPane.showMessageDialog(frame,"ERROR");
				} 
			
				                  JOptionPane.showMessageDialog(null, "Despesa cadastrado.");  
				                  limpaTela();  
			
				gui.JanelaDespesas.main(user);
				frmCadastrarDespesas.dispose();
			}
		});
	
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				gui.JanelaDespesas.main(user);
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
		cbMes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    mes = (String)cbMes.getSelectedItem();
				   
			        System.out.println("Mes   " + mes);
			}
		});
		
		
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
		cbAno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    ano = (String)cbAno.getSelectedItem();
			        System.out.println("Ano   " + ano);
			}
		});
		
	}
	
	  public void limpaTela() {  
          this.textDespesa.setText("");  
          this.textValor.setText("");  
        }  
  
       
  
	public Despesas montaDespesa() { // Pega dos dados digitados nos campos do  
          // formulário e atribui ao objeto  
    	 Despesas lg = new Despesas();  
          lg.setUser(user.getId());  
          lg.setAno(Integer.parseInt(ano));
          lg.setCategoria(categoria);
          lg.setDespesa(this.textDespesa.getText());
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
			categoria = tipoService.buscarTipo("Despesa", user.getId());
		} catch (Exception e){
			Component frame = null;
			JOptionPane.showMessageDialog(frame,"ERROR");}
			

		for (Tipo tipo1 : categoria) {
			  cbCategoria.addItem(tipo1.getNome());
			   
		}
	}
}

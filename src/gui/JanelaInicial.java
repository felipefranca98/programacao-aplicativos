package gui;

import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import service.DespesasOcasionaisService;
import service.UsuarioService;
import entity.Usuario;

public class JanelaInicial {

	private static UsuarioService usuarioService;
	private JFrame frmInicio;
	private JTextField textUsuario;
	private JPasswordField textSenha;
	private Usuario s;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaInicial window = new JanelaInicial();
					window.frmInicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		
	}


		public JanelaInicial() {
		initialize();
	}

	private void initialize() {
		frmInicio = new JFrame();
		frmInicio.setTitle("Início");
		frmInicio.setBounds(100, 100, 250, 210);
		frmInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInicio.getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuário");
		lblUsuario.setBounds(30, 30, 46, 14);
		frmInicio.getContentPane().add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(30, 60, 46, 14);
		frmInicio.getContentPane().add(lblSenha);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(86, 27, 120, 20);
		frmInicio.getContentPane().add(textUsuario);
		textUsuario.setColumns(10);
		
		textSenha = new JPasswordField();
		textSenha.setBounds(86, 57, 120, 20);
		frmInicio.getContentPane().add(textSenha);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario s = montaUsuario();  
				usuarioService = new UsuarioService();
				
				try {
					 s.setLog(usuarioService.loginUsuario(s));  
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					Component frame = null;
					JOptionPane.showMessageDialog(frame,"ERROR");
				} 
			
				                  JOptionPane.showMessageDialog(null, "Usuario cadastrado.");  
				                  limpaTela();  
				/* Validação de login */

				          		System.out.println("AAAasaA " + s.getId());
				        		frmInicio.dispose();
				          		gui.JanelaRendimentos.main(s);
		
			}
		});
		btnLogin.setBounds(60, 90, 120, 23);
		frmInicio.getContentPane().add(btnLogin);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 s = montaUsuario();  
				usuarioService = new UsuarioService();
				
				try {
					 s.setId(usuarioService.cadastrarUsuario(s));  
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					Component frame = null;
					JOptionPane.showMessageDialog(frame,"ERROR");
				} 
			
				                  JOptionPane.showMessageDialog(null, "Usuario cadastrado.");  
				                  limpaTela();  
		
				/* Verifica se usuario existe e cadastra */
			}
		});
		btnCadastrar.setBounds(60, 120, 120, 23);
		frmInicio.getContentPane().add(btnCadastrar);}
		
		
		  public void limpaTela() {  
              this.textUsuario.setText("");  
              this.textSenha.setText("");  
            }  
      
           
      
         @SuppressWarnings("deprecation")
		public Usuario montaUsuario() { // Pega dos dados digitados nos campos do  
              // formulário e atribui ao objeto  
        	 Usuario lg = new Usuario();  
              lg.setLogin(this.textUsuario.getText());  
                
              lg.setSenha(this.textSenha.getText());  
      
              return lg;  
      
         }  
      
     
}

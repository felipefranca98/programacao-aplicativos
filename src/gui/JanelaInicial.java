package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaInicial {

	private JFrame frmInicio;
	private JTextField textUsuario;
	private JPasswordField textSenha;

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
				/* Validação de login */
				gui.JanelaRendimentos.main(null);
				frmInicio.dispose();
			}
		});
		btnLogin.setBounds(60, 90, 120, 23);
		frmInicio.getContentPane().add(btnLogin);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* Verifica se usuario existe e cadastra */
				gui.JanelaRendimentos.main(null);
				frmInicio.dispose();
			}
		});
		btnCadastrar.setBounds(60, 120, 120, 23);
		frmInicio.getContentPane().add(btnCadastrar);
	}
}

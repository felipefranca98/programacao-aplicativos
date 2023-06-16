package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaCadastrarCategorias {

	private JFrame frmCadastrarCategorias;
	private JTextField textCategoria;
	
	private static int origem = 0;

	public static void main(String[] args, int flag) {
		origem = flag;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCadastrarCategorias window = new JanelaCadastrarCategorias();
					window.frmCadastrarCategorias.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaCadastrarCategorias() {
		initialize();
	}

	private void initialize() {
		frmCadastrarCategorias = new JFrame();
		frmCadastrarCategorias.setTitle("Cadastrar Categorias");
		frmCadastrarCategorias.setBounds(100, 100, 300, 110);
		frmCadastrarCategorias.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastrarCategorias.getContentPane().setLayout(null);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(10, 11, 75, 14);
		frmCadastrarCategorias.getContentPane().add(lblCategoria);
		
		textCategoria = new JTextField();
		textCategoria.setBounds(74, 8, 200, 20);
		frmCadastrarCategorias.getContentPane().add(textCategoria);
		textCategoria.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(origem) {
				case 1:
					gui.JanelaRendimentos.main(null);
					frmCadastrarCategorias.dispose();
					break;
				case 2:
					gui.JanelaDespesas.main(null);
					frmCadastrarCategorias.dispose();
					break;
				}
			}
		});
		btnCancelar.setBounds(40, 36, 100, 23);
		frmCadastrarCategorias.getContentPane().add(btnCancelar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setEnabled(false);
		btnCadastrar.setBounds(150, 36, 100, 23);
		frmCadastrarCategorias.getContentPane().add(btnCadastrar);
	}

}


package gui;

import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entity.Tipo;
import entity.Usuario;
import service.TipoService;
import service.UsuarioService;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class JanelaCadastrarCategorias {
	private static TipoService tipoService;
	private JFrame frmCadastrarCategorias;
	private JTextField textCategoria;
	private static  Usuario user = new Usuario();

	private static int origem;

	public static void main(String[] args, int flag, Usuario s) {
		user.setId(s.getId());
		user.setLogin(s.getLogin());
		user.setSenha(s.getSenha());
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
					gui.JanelaRendimentos.main(user);
					frmCadastrarCategorias.dispose();
					break;
				case 2:
					gui.JanelaDespesas.main(user);
					frmCadastrarCategorias.dispose();
					break;
				default:
					frmCadastrarCategorias.dispose();
					break;
				}
			}
		});
		btnCancelar.setBounds(40, 36, 100, 23);
		frmCadastrarCategorias.getContentPane().add(btnCancelar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoService = new TipoService();
				Tipo categoria = new Tipo();
				switch(origem) {
				case 1:
					categoria = montaTipo("Rendimento");
					
					try {
						 tipoService.cadastrarCategoria(categoria);  
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						Component frame = null;
						JOptionPane.showMessageDialog(frame,"ERROR");
					} 
				
					                  JOptionPane.showMessageDialog(null, "Usuario cadastrado.");  
					                  limpaTela();  
			
					gui.JanelaRendimentos.main(user);
					frmCadastrarCategorias.dispose();
					break;
				case 2:
					categoria = montaTipo("Despesa");
					try {
						 tipoService.cadastrarCategoria(categoria);  
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						Component frame = null;
						JOptionPane.showMessageDialog(frame,"ERROR");
					} 
				
					                  JOptionPane.showMessageDialog(null, "Usuario cadastrado.");  
					                  limpaTela();  

					gui.JanelaDespesas.main(user);
					frmCadastrarCategorias.dispose();
					break;
				default:
					frmCadastrarCategorias.dispose();
					break;
				}
			}
		});
		
		btnCadastrar.setBounds(150, 36, 100, 23);
		frmCadastrarCategorias.getContentPane().add(btnCadastrar);
	}
	
	public void limpaTela() {  
        this.textCategoria.setText("");  
      }  

     

	public Tipo montaTipo(String modulo) { // Pega dos dados digitados nos campos do  
        // formulário e atribui ao objeto  
  	 Tipo lg = new Tipo();  
        lg.setNome(this.textCategoria.getText());  
          
        lg.setModulo(modulo);  

        return lg;  

   }  

}

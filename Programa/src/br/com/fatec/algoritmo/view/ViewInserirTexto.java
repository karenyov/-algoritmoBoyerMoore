package br.com.fatec.algoritmo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.fatec.algoritmo.app.Arquivo;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ViewInserirTexto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewInserirTexto frame = new ViewInserirTexto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewInserirTexto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 54, 414, 126);
		contentPane.add(textPane);

		JLabel lblDigiteOTexto = new JLabel("Digite o Texto: ");
		lblDigiteOTexto.setBounds(10, 29, 83, 14);
		contentPane.add(lblDigiteOTexto);

		JLabel lblMensagem = new JLabel("");
		lblMensagem.setBounds(103, 24, 294, 25);
		contentPane.add(lblMensagem);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Arquivo a = new Arquivo();
				if (a.escreverArquivo(textPane.getText())) {
					// sucesso
					lblMensagem.setText("Texto inserido com sucesso!");
					lblMensagem.setForeground(new Color(0, 128, 0));

				}
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalvar.setBounds(10, 202, 110, 36);
		contentPane.add(btnSalvar);

	}
}

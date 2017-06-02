package br.com.fatec.algoritmo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class ViewPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPrincipal frame = new ViewPrincipal();
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
	public ViewPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInserirTexto = new JButton("Inserir Texto");
		btnInserirTexto.setForeground(new Color(245, 245, 245));
		btnInserirTexto.setBackground(new Color(112, 128, 144));
		btnInserirTexto.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInserirTexto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewInserirTexto t = new ViewInserirTexto(); 
				t.setVisible(true);
			}
		});
		btnInserirTexto.setBounds(142, 51, 140, 47);
		contentPane.add(btnInserirTexto);
		
		JButton btnBuscarOcorrncia = new JButton("Buscar Ocorr\u00EAncia");
		btnBuscarOcorrncia.setForeground(new Color(245, 245, 245));
		btnBuscarOcorrncia.setBackground(new Color(112, 128, 144));
		btnBuscarOcorrncia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewBuscarPalavra p = new ViewBuscarPalavra(); 
				p.setVisible(true);
			}
		});
		btnBuscarOcorrncia.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscarOcorrncia.setBounds(142, 127, 140, 47);
		contentPane.add(btnBuscarOcorrncia);
	}
}

package br.com.fatec.algoritmo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.fatec.algoritmo.app.Arquivo;
import br.com.fatec.algoritmo.app.BoyerMoore;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ViewBuscarPalavra extends JFrame {

	private JPanel contentPane;
	private JTextField textPalavra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBuscarPalavra frame = new ViewBuscarPalavra();
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
	public ViewBuscarPalavra() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textPalavra = new JTextField();
		textPalavra.setBounds(10, 71, 414, 25);
		contentPane.add(textPalavra);
		textPalavra.setColumns(10);

		JLabel lblDigiteAPalavra = new JLabel("Digite a palavra:");
		lblDigiteAPalavra.setBounds(10, 48, 116, 14);
		contentPane.add(lblDigiteAPalavra);

		JLabel lblBuscarOcorrncia = new JLabel("Buscar Ocorr\u00EAncia");
		lblBuscarOcorrncia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBuscarOcorrncia.setBounds(124, 11, 181, 20);
		contentPane.add(lblBuscarOcorrncia);

		JLabel labelQuant = new JLabel("");
		labelQuant.setBounds(259, 158, 46, 14);
		contentPane.add(labelQuant);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(new Color(245, 245, 245));
		btnBuscar.setBackground(new Color(112, 128, 144));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Arquivo a = new Arquivo();
				String pat = textPalavra.getText();
				String txt = a.lerArquivoComBufferedReader();

				BoyerMoore boyermoore1 = new BoyerMoore(pat);

				ArrayList<Integer> offset = boyermoore1.search(txt);

				int resultado = offset.size();
				labelQuant.setText(Integer.toString(resultado));
			}
		});
		btnBuscar.setBounds(10, 102, 89, 32);
		contentPane.add(btnBuscar);

		JLabel lblNewLabel = new JLabel("Quantidade de ocorr\u00EAncias da palavra: ");
		lblNewLabel.setBounds(10, 158, 226, 20);
		contentPane.add(lblNewLabel);

	}
}

package br.com.fatec.algoritmo.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {

	@SuppressWarnings("finally")
	public Boolean escreverArquivo(String texto) {
		File arquivo = new File("texto.txt");
		if (!arquivo.exists()) {
			try {
				arquivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(arquivo);
			bw = new BufferedWriter(fw);
			bw.write(texto);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return true;
		}
	}

	@SuppressWarnings("finally")
	public String lerArquivoComBufferedReader() {
		File arquivo = new File("texto.txt");
		BufferedReader bf = null;
		String texto = "";
		try {
			bf = new BufferedReader(new FileReader(arquivo));
			String linha = "";
			System.out.println(" *** Lendo com BufferedReader ***");
			while ((linha = bf.readLine()) != null) {
				texto += ' ' + linha;
			}
			System.out.println(" *** *** ");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bf != null) {
				try {
					bf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return texto;
		}
	}

}

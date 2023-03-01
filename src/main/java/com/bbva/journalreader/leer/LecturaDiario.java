package com.bbva.journalreader.leer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JTextArea;

import org.springframework.web.multipart.MultipartFile;

public class LecturaDiario {

	public static ArrayList<String> resInicializacion = new ArrayList<>();

	public static void init() {
		resInicializacion.clear();
	}

	public static int tipoOperacion(MultipartFile[] archivos) {
		int Estado = 0;
		String cadena;
		try {
			for (MultipartFile archivo : archivos) {
				BufferedReader br = new BufferedReader(new InputStreamReader(archivo.getInputStream()));
				while ((cadena = br.readLine()) != null) {
					if (cadena.contains("RETIRO:")) {
						return Estado = 1;
					}
					if (cadena.contains("IMPORTE DEPOSITO:")) {
						return Estado = 2;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return Estado = 3;
		}
		return Estado;
	}

	public static ArrayList<String> leerDiarios(MultipartFile[] archivos) {
		ArrayList<String> res = new ArrayList<>();
		String cadena;
		try {
			for (MultipartFile archivo : archivos) {
				BufferedReader br = new BufferedReader(new InputStreamReader(archivo.getInputStream()));
				while ((cadena = br.readLine()) != null) {
					res.add(cadena);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static void leerDiariosTextArea(JTextArea text, String ruta) {

		File directorio = new File(ruta);
		String[] ficheros = directorio.list();
		String cadena;
		try {
			for (int i = 0; i < ficheros.length; i++) {
				BufferedReader br = new BufferedReader(new FileReader(ruta + ficheros[i]));
				while ((cadena = br.readLine()) != null) {
					text.append(cadena + "\n");
				}
				br.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static int idx_Abastec(String archivo, String Text) {
		int aux = 0;
		File directorio = new File(archivo);
		String[] ficheros = directorio.list();
		String cadena;
		int contador = 0;
		try {
			for (int i = 0; i < ficheros.length; i++) {
				BufferedReader br = new BufferedReader(new FileReader(archivo + ficheros[i]));
				while ((cadena = br.readLine()) != null) {
					contador++;
					if (cadena.contains(Text)) {
						aux = contador;
					}
				}
				br.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aux;
	}

	public static ArrayList<Integer> idx_Abastecimientos(ArrayList<String> idx_Abastecimientos) {
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 0; i < idx_Abastecimientos.size(); i++) {
			if (idx_Abastecimientos.get(i).contains("INICIALIZACION DE EFECTIVO CORRECTA")) {
				res.add(i);
			}
		}
		return res;
	}

	public static ArrayList<Integer> idx_AbastecimientosDeposito(ArrayList<String> idx_Abastecimientos) {
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 0; i < idx_Abastecimientos.size(); i++) {
			if (idx_Abastecimientos.get(i).contains("INICIALIZACION DE INGRESADOR CORRECTA")) {
				res.add(i);
			}
		}
		return res;
	}

	public static ArrayList<String> getFecha_Abastecimientos(ArrayList<String> idx_Abastecimientos) {
		ArrayList<String> res = new ArrayList<>();
		for (int i = 0; i < idx_Abastecimientos.size(); i++) {
			if (idx_Abastecimientos.get(i).contains("INICIALIZACION DE EFECTIVO CORRECTA")) {
				res.add(idx_Abastecimientos.get(i));
			}
		}
		return res;
	}

	public static ArrayList<String> getFecha_AbastecimientosDeposito(ArrayList<String> idx_Abastecimientos) {
		ArrayList<String> res = new ArrayList<>();
		for (int i = 0; i < idx_Abastecimientos.size(); i++) {
			if (idx_Abastecimientos.get(i).contains("INICIALIZACION DE INGRESADOR CORRECTA")) {
				res.add(idx_Abastecimientos.get(i));
			}
		}
		return res;
	}

	public static String NumeroCajero(ArrayList<String> idx_Abastecimientos) {
		String numero = "";
		for (int i = 0; i < idx_Abastecimientos.size(); i++) {
			if (idx_Abastecimientos.get(i).contains("=") && idx_Abastecimientos.get(i).contains("CAJERO")) {
				numero = idx_Abastecimientos.get(i).replace("=", "").substring(0, 28);
				break;
			}
		}
		return numero;
	}

	public static void OperacionesLimpias(ArrayList<String> idx_Abastecimientos, int idx_i, int idx_o) {
		for (int i = idx_i; i < idx_o; i++) {
			resInicializacion.add(idx_Abastecimientos.get(i));
		}

	}

}

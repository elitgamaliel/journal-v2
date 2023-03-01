package com.bbva.journalreader.buscar;

import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Deposito extends Operacion {

    public void getImporteDeposito(String cadena) {
        if (cadena.contains("IMPORTE DEPOSITO:")) {
            Moneda = (cadena.substring(36, 39));
            TmpImporte = (cadena.substring(39, 54));
        }
        if (cadena.contains("IMPORTE DEPOSITADO")) {
            Moneda = (cadena.substring(38, 41));
            TmpImporte = (cadena.substring(41, 56));
        }
        if (cadena.contains("IMPORTE INGRESADO")) {
            Moneda = (cadena.substring(37, 40));
            TmpImporte = (cadena.substring(40, 56));
        }

    }

    public void ImporteDeposito(String cadena, int indice) {

        if (cadena.contains("IMPORTE DEPOSITO:")) {
            Moneda = (cadena.substring(36, 38));
            TmpImporte = (cadena.substring(39, 54));
        }
        if (cadena.contains("IMPORTE DEPOSITADO")) {
            Moneda = (cadena.substring(38, 40));
            TmpImporte = (cadena.substring(41, 56));
        }
        if (cadena.contains("FIN CAPTURA: RETRAIDOS")) {
            Incorrectas.add(indice);
            resError.add(cadena + Moneda + " " + TmpImporte);
        }
        if (cadena.contains("DEPOSITO NO REALIZADO")) {
            Incorrectas.add(indice);
            resError.add(cadena + Moneda + " " + TmpImporte);
        }

    }

    public void getOperacionesCorrectasDesposito(ArrayList<String> Journal, ArrayList<Integer> idx_abaste,
            DefaultTableModel modelo, JTextField jtext1, JTextField jtext2) {
        int solesRetirados = 0;
        int dolaresRetirados = 0;

        for (int k = idx_abaste.get(idx_in); k < idx_abaste.get(idx_fin); k++) {
            getTipoTarjeta(Journal.get(k));
            getImporteDeposito(Journal.get(k));

            if (Journal.get(k).contains("BILLETES DEPOSITADOS") && !Journal.get(k).contains("***")
                    && !Journal.get(k).contains("INGRESADOS") && !Journal.get(k).contains("CONSULTA")) {
                if (Moneda.contains("S/")) {
                    solesRetirados = Integer.parseInt(TmpImporte.replace(".", "").replace(",", "").replace(" ", ""));
                    TotalSoles = TotalSoles + solesRetirados;

                }
                if (Moneda.contains("US")) {
                    dolaresRetirados = Integer.parseInt(TmpImporte.replace(".", "").replace(",", "").replace(" ", ""));
                    TotalDolares = TotalDolares + dolaresRetirados;

                }
                fecha = Journal.get(k).substring(0, 8);
                hora = Journal.get(k).substring(9, 17);
                importe = Moneda + " " + TmpImporte;

                modelo.addRow(new Object[] { fecha, hora, NumeroTarjeta, importe });
            }
        }

        jtext1.setText(String.valueOf(TotalSoles));
        jtext2.setText(String.valueOf(TotalDolares));

        idx_in++;
        idx_fin++;
    }

    public void getOperacionesConErroresDeposito(ArrayList<String> Journal, ArrayList<Integer> idx_Journal) {
        for (int k = idx_Journal.get(idx_in); k < idx_Journal.get(idx_fin); k++) {
            ImporteDeposito(Journal.get(k), k);

        }
        idx_in++;
        idx_fin++;
    }
}

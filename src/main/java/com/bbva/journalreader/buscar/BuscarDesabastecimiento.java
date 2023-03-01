package com.bbva.journalreader.buscar;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class BuscarDesabastecimiento {

    public static int BilleteColocado[] = new int[6];
    public static int c1 = 0;
    public static int c2 = 0;
    public static int c3 = 0;
    public static int c4 = 0;
    public static int c5 = 0;
    public static int c6 = 0;

    public BuscarDesabastecimiento() {

    }

    public static void mostrarDesabastecimiento(ArrayList<String> idx_Abastecimientos, int idx_i,
            DefaultTableModel modelo) {

        for (int i = idx_i - 150; i < idx_i; i++) {
            modelo.addRow(new Object[] { idx_Abastecimientos.get(i) });
        }
    }

    /*
     * public void getBilletesColocados(String Mezcla) {
     * 
     * int cj1 = Mezcla.indexOf("100:");
     * int cj2 = Mezcla.indexOf("100:", cj1 + 1);
     * int cj3 = Mezcla.indexOf("20:");
     * int cj4 = Mezcla.indexOf("20:", cj3 + 1);
     * int cj5 = Mezcla.indexOf("50:");
     * 
     * if (cj1 != -1) { //100
     * c1 = Integer.parseInt(Mezcla.substring(cj1 + 5, cj1 + 10).replace(",",
     * "").replace(" ", ""));
     * System.out.println("100:" + c1);
     * BilleteColocado[0]=c1;
     * 
     * 
     * }
     * if (cj2 != -1) { //100
     * c2 = Integer.parseInt(Mezcla.substring(cj2 + 5, cj2 + 10).replace(",",
     * "").replace(" ", ""));
     * System.out.println("100:" + c2);
     * BilleteColocado[1]=c2;
     * 
     * }
     * if (cj3 != -1) { //20
     * c3 = Integer.parseInt(Mezcla.substring(cj3 + 4, cj3 + 9).replace(",",
     * "").replace(" ", ""));
     * System.out.println("20:" + c3);
     * BilleteColocado[2]=c3;
     * 
     * }
     * if (cj4 != -1) { //20
     * c4 = Integer.parseInt(Mezcla.substring(cj4 + 4, cj4 + 9).replace(",",
     * "").replace(" ", ""));
     * System.out.println("20:" + c4);
     * BilleteColocado[3]=c4;
     * 
     * }
     * if (cj5 != -1) { //50
     * c5 = Integer.parseInt(Mezcla.substring(cj5 + 4, cj5 + 9).replace(",",
     * "").replace(" ", ""));
     * System.out.println("50:" + c5);
     * BilleteColocado[6]=c5;
     * }
     * 
     * }
     */
    public void getBilletesColocados(String line) {

        if (line.contains("C1:") && line.contains("100")) {
            c1 = Integer.parseInt(line.substring(9, 14).replace(",", "").replace(" ", ""));

            System.out.println("100" + c1);
        }
        if (line.contains("C2:") && line.contains("100")) {
            c2 = Integer.parseInt(line.substring(9, 14).replace(",", "").replace(" ", ""));

            System.out.println("100.2" + c2);
        }
        if (line.contains("C3:") && line.contains("20")) {
            c3 = Integer.parseInt(line.substring(9, 14).replace(",", "").replace(" ", ""));

            System.out.println("20.1" + c3);
        }
        if (line.contains("C4:") && line.contains("20")) {
            c4 = Integer.parseInt(line.substring(9, 14).replace(",", "").replace(" ", ""));

            System.out.println("20.2" + c4);
        }
        if (line.contains("50:")) {
            c6 = Integer.parseInt(line.substring(9, 14).replace(",", "").replace(" ", ""));
            System.out.println("50" + c6);

        }
        if (line.contains("C5:") && line.contains("20")) { // dolares
            c5 = Integer.parseInt(line.substring(9, 14).replace(",", "").replace(" ", ""));
            System.out.println("20$$" + c5);
        }

    }

    public static void BilletesColocados(ArrayList<String> idx_Abastecimientos, int idx_i, DefaultTableModel modelo) {

        for (int i = idx_i - 150; i < idx_i; i++) {
            modelo.addRow(new Object[] { idx_Abastecimientos.get(i) });
        }
    }
}

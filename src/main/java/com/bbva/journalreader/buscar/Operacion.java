package com.bbva.journalreader.buscar;

import java.util.ArrayList;

public class Operacion {

    public static ArrayList<Integer> idx_montoRetirado = new ArrayList<>();
    public static ArrayList<Integer> idx_Lineas = new ArrayList<>();
    public static ArrayList<Integer> Indice_Array_Errores = new ArrayList<>();
    public static ArrayList<Integer> Incorrectas = new ArrayList<>();
    public static ArrayList<String> resError = new ArrayList<>();
    public int idx_in = 0;
    public int idx_fin = 1;
    public int TotalMezcla;
    public int TotalSoles;
    public int TotalDolares;
    public int SubTotal;
    public int billetesMezcla;
    public String NumeroTarjeta;
    public String fecha;
    public String hora;
    public String importe;
    public String Moneda;
    public String TmpImporte;

    public int getTotalMezcla() {
        return TotalMezcla;
    }

    public void setTotalMezcla(int TotalMezcla) {
        this.TotalMezcla = TotalMezcla;
    }

    public Operacion() {
    }

    public void setIdx_in(int idx_in) {
        this.idx_in = idx_in;
    }

    public void setIdx_fin(int idx_fin) {
        this.idx_fin = idx_fin;
    }

    public static void intitRes() {
        idx_montoRetirado.clear();
        idx_Lineas.clear();
        Indice_Array_Errores.clear();
        Incorrectas.clear();
        resError.clear();
    }

    public void getMezclaBilletes(String Mezcla) {

        int c1 = Mezcla.indexOf("(100)");
        int c2 = Mezcla.indexOf("(100)", c1 + 1);
        int c3 = Mezcla.indexOf("(20)");
        int c4 = Mezcla.indexOf("(20)", c3 + 1);
        int c5 = Mezcla.indexOf("(50)");

        int Dcj1 = 0;
        int Dcj2 = 0;
        int Dcj3 = 0;
        int Dcj4 = 0;
        int Dcj5 = 0;

        int subtotal1 = 0;
        int subtotal2 = 0;
        int subtotal3 = 0;
        int subtotal4 = 0;
        int subtotal5 = 0;

        if (c1 != -1) { // 100
            Dcj1 = Integer.parseInt(Mezcla.substring(c1 - 2, c1));
            subtotal1 = Dcj1 * 100;

        }
        if (c2 != -1) { // 100
            Dcj2 = Integer.parseInt(Mezcla.substring(c2 - 2, c2));
            subtotal2 = Dcj2 * 100;
        }

        if (c3 != -1) { // 20
            Dcj3 = Integer.parseInt(Mezcla.substring(c3 - 2, c3));
            subtotal3 = Dcj3 * 20;

        }
        if (c4 != -1) { // 20
            Dcj4 = Integer.parseInt(Mezcla.substring(c4 - 2, c4));
            subtotal4 = Dcj4 * 20;
        }
        if (c5 != -1) { // 50
            Dcj5 = Integer.parseInt(Mezcla.substring(c5 - 2, c5));
            subtotal5 = Dcj5 * 50;
        }
        billetesMezcla = Dcj1 + Dcj2 + Dcj3 + Dcj4 + Dcj5;

        TotalMezcla = subtotal1 + subtotal2 + subtotal3 + subtotal4 + subtotal5;

    }

    public void getIndiceOperCorrectas(ArrayList<String> idx_Abastecimientos) {
        String line = "";
        for (int i = 0; i < 69; i++) {
            line += "-";
        }
        for (int i = 0; i < idx_Abastecimientos.size(); i++) {
            if (idx_Abastecimientos.get(i).contains(line)) {
                idx_Lineas.add(i);
            }
        }
    }

    public static void idx_OperacionesConError(ArrayList<String> idx_Abastecimientos) {
        String line = "";
        for (int i = 0; i < 69; i++) {
            line += "-";
        }
        for (int i = 0; i < idx_Abastecimientos.size(); i++) {
            if (idx_Abastecimientos.get(i).contains(line)) {
                Indice_Array_Errores.add(i);
            }
        }
    }

    public void getTipoTarjeta(String cadena) {
        if (cadena.contains("TARJETA PROPIA")) {
            NumeroTarjeta = (cadena.substring(46, 62).replace("*", "-"));
        } else if (cadena.contains("TARJETA AJENA")) {
            NumeroTarjeta = (cadena.substring(34, 50));
        } else if (cadena.contains("OPERATIVA SIN TARJETA")) {
            NumeroTarjeta = "SIN TARJETA";
        }

    }

}

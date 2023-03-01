package com.bbva.journalreader.buscar;

import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Retiro extends Operacion {

    public boolean Anulacion = false;
    public String CajetinFisico;
    public String mezcla;
    public JTextField txt100soles;
    public JTextField txt100soles2;

    public int billetes;
    public int cajetin1;
    public int cajetin2;
    public int cajetin3;
    public int cajetin4;
    public int cajetin5;
    public int cajetin6;

    public int cs1;
    public int cs2;
    public int cs3;
    public int cs4;
    public int cs5;
    public int cs6;

    public Retiro() {
    }

    public Retiro(int cs1, int cs2, int cs3, int cs4, int cs5, int cs6) {
        this.cs1 = cs1;
        this.cs2 = cs2;
        this.cs3 = cs3;
        this.cs4 = cs4;
        this.cs5 = cs5;
        this.cs6 = cs6;

    }

    public JTextField getTxt100soles() {
        return txt100soles;
    }

    public void setTxt100soles(JTextField txt100soles) {
        this.txt100soles = txt100soles;
    }

    public JTextField getTxt100soles2() {
        return txt100soles2;
    }

    public void setTxt100soles2(JTextField txt100soles2) {
        this.txt100soles2 = txt100soles2;
    }

    public int getCajetin6() {
        return cajetin6;
    }

    public void setCajetin6(int cajetin6) {
        this.cajetin6 = cajetin6;
    }

    public String getCajetinFisico() {
        return CajetinFisico;
    }

    public void setCajetinFisico(String CajetinFisico) {
        this.CajetinFisico = CajetinFisico;
    }

    public int getCajetin1() {
        return cajetin1;
    }

    public void setCajetin1(int cajetin1) {
        this.cajetin1 = cajetin1;
    }

    public int getCajetin2() {
        return cajetin2;
    }

    public void setCajetin2(int cajetin2) {
        this.cajetin2 = cajetin2;
    }

    public int getCajetin3() {
        return cajetin3;
    }

    public void setCajetin3(int cajetin3) {
        this.cajetin3 = cajetin3;
    }

    public int getCajetin4() {
        return cajetin4;
    }

    public void setCajetin4(int cajetin4) {
        this.cajetin4 = cajetin4;
    }

    public int getCajetin5() {
        return cajetin5;
    }

    public void setCajetin5(int cajetin5) {
        this.cajetin5 = cajetin5;
    }

    public boolean isAnulacion() {
        return Anulacion;
    }

    public void CajetinFisico(String CajetinFisico) {

        int billetes1 = 0;
        int billetes2 = 0;
        int billetes3 = 0;
        int billetes4 = 0;
        int billetes5 = 0;
        int billetes6 = 0;

        int c1 = CajetinFisico.indexOf("-100-");
        int c2 = CajetinFisico.indexOf("-100-", c1 + 1);
        int c3 = CajetinFisico.indexOf("-020-");
        int c4 = CajetinFisico.indexOf("-020-", c3 + 1);
        int c6 = CajetinFisico.indexOf("-020-", c4 + 1);
        int c5 = CajetinFisico.indexOf("-50-");

        if (c1 != -1 && !CajetinFisico.contains("CONT.")) { // 100
            int Dcj = Integer.parseInt(CajetinFisico.substring(c1 + 5, c1 + 9));
            billetes1 = cs1 - Dcj;

            cs1 = Dcj;

        }
        if (c2 != -1 && !CajetinFisico.contains("CONT.")) { // 100

            int Dcj = Integer.parseInt(CajetinFisico.substring(c2 + 5, c2 + 9));
            // System.out.println("cs2 inical:" + cs2);
            billetes2 = cs2 - Dcj;

            cs2 = Dcj;

        }

        if (c3 != -1 && !CajetinFisico.contains("CONT.")) { // 20
            int Dcj = Integer.parseInt(CajetinFisico.substring(c3 + 5, c3 + 9));

            billetes3 = cs3 - Dcj;
            cs3 = Dcj;

        }
        if (c4 != -1 && !CajetinFisico.contains("CONT.")) { // 20
            int Dcj = Integer.parseInt(CajetinFisico.substring(c4 + 5, c4 + 9));

            billetes4 = cs4 - Dcj;
            cs4 = Dcj;

        }

        if (c5 != -1 && !CajetinFisico.contains("CONT.")) { // 50
            int Dcj = Integer.parseInt(CajetinFisico.substring(c5 + 5, c5 + 9));
            billetes5 = cs5 - Dcj;
            cs5 = Dcj;

        }
        if (c6 != -1 && !CajetinFisico.contains("CONT.")) { // 20
            int Dcj = Integer.parseInt(CajetinFisico.substring(c6 + 5, c6 + 9));

            billetes6 = cs6 - Dcj;
            cs6 = Dcj;
        }

        billetes = billetes1 + billetes2 + billetes3 + billetes4 + billetes5 + billetes6;
        System.out.println(
                "billetes1:" + billetes1 + "--billetes2:" + billetes2 + "--billetes3:" + billetes3 + "--billetes4:"
                        + billetes4 + "--billetes5:" + billetes5 + "--billetes6:" + billetes6 + "--TOTAL: " + billetes);

    }

    public void getImporteRetiro(String cadena) {

        if (cadena.contains("MONTO RETIRO")) {
            Moneda = (cadena.substring(32, 35));
            TmpImporte = (cadena.substring(35, 50));
        }
        if (cadena.contains("IMPORTE RECIBIDO")) {
            Moneda = (cadena.substring(36, 38));
            TmpImporte = (cadena.substring(39, 50));
        }
        if (cadena.contains("AFILIACION:") && cadena.contains("IMPORTE:")) {
            Moneda = (cadena.substring(46, 48));
            TmpImporte = (cadena.substring(49, 60));
        }
        if (cadena.contains("IMPORTE:") && !cadena.contains("AFILIACION:")) {
            Moneda = (cadena.substring(27, 29));
            TmpImporte = (cadena.substring(30, 42));
        }
        if (cadena.contains("MEZCLA BILLETES")) {
            mezcla = (cadena.substring(35, 84));

            getMezclaBilletes(mezcla);

        }

    }

    public String getMezclaCorrecta() {
        String Chek = "";

        if (billetesMezcla == billetes) {
            Chek = "OK";
        } else {
            Chek = "ERROR";
        }
        return Chek;
    }

    public void getOperacionesCorrectas(ArrayList<String> journal, ArrayList<Integer> idx_journal,
            DefaultTableModel modelo, JTextField jtext1, JTextField jtext2) {

        int solesRetirados = 0;
        int dolaresRetirados = 0;

        for (int k = idx_journal.get(idx_in); k < idx_journal.get(idx_fin); k++) {
            getTipoTarjeta(journal.get(k));
            getImporteRetiro(journal.get(k));

            if (journal.get(k).contains("BILLETES RETIRADOS")) {
                if (Moneda.contains("S/")) {
                    solesRetirados = Integer.parseInt(TmpImporte.replace(".", "").replace(",", "").replace(" ", ""));
                    TotalSoles = TotalSoles + solesRetirados;

                }
                if (Moneda.contains("US")) {
                    dolaresRetirados = Integer.parseInt(TmpImporte.replace(".", "").replace(",", "").replace(" ", ""));
                    TotalDolares = TotalDolares + dolaresRetirados;

                }
                SubTotal = Integer.parseInt(TmpImporte.replace(" ", "").replace(".00", "").replace(",", ""));
                fecha = journal.get(k).substring(0, 8);
                hora = journal.get(k).substring(9, 17);
                importe = Moneda + " " + TmpImporte;
                idx_montoRetirado.add(k);

            }
            if (journal.get(k).contains(";")) {
                CajetinFisico = (journal.get(k).substring(0, 84));

                CajetinFisico(CajetinFisico);
                modelo.addRow(new Object[] { fecha, hora, NumeroTarjeta, mezcla, Moneda, getTotalMezcla(),
                        CajetinFisico, billetesMezcla, billetes, getMezclaCorrecta() });
            }

        }

        jtext1.setText(String.valueOf(TotalSoles));
        jtext2.setText(String.valueOf(TotalDolares));
        idx_in++;
        idx_fin++;
    }

    public void getOperacionesConErrores(ArrayList<String> cadena, ArrayList<Integer> i_Abastecimientos) {
        String mezcla = "";
        int re = 0;

        for (int indice = i_Abastecimientos.get(idx_in); indice < i_Abastecimientos.get(idx_fin); indice++) {

            getImporteRetiro(cadena.get(indice));
            if (cadena.get(indice).contains("ERROR DISPENSADO BILLETES")) {
                Incorrectas.add(indice);
                resError.add(cadena.get(indice) + Moneda + " " + TmpImporte);
                Anulacion = true;
            }
            if (cadena.get(indice).contains("ERROR PRESENTAR")) {
                Incorrectas.add(indice);
                resError.add(cadena.get(indice) + Moneda + " " + TmpImporte);
            }
            if (cadena.get(indice).contains("MEZCLA BILLETES:")) {
                re = indice + 2;
                mezcla = cadena.get(indice);

            }
            if (cadena.get(indice).contains("BILLETES EXPUESTOS")) {
                re = indice + 1;
                mezcla = cadena.get(indice);
            }
            if (re == indice && cadena.get(indice)
                    .contains("********************************************************************************")) {
                Incorrectas.add(indice);
                resError.add(mezcla + Moneda + " " + TmpImporte);

            }

        }
        idx_in++;
        idx_fin++;
    }
}

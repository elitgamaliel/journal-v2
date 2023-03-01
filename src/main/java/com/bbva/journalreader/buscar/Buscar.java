package com.bbva.journalreader.buscar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.bbva.journalreader.leer.LecturaDiario;

public class Buscar {

  public DefaultTableModel modelo = new DefaultTableModel();
  public static final String DEPOSITO = "DEPÓSITO";
  public static final String RETIRO = "RETIRO";
  public int tipoOperacion;
  public String atm;
  public String ruta;
  public JLabel tipoOper;
  public JLabel infoAtm;

  public Buscar(String ruta) {
    this.ruta = ruta;
  }

  public Buscar() {

  }

  public Buscar(DefaultTableModel modelo, String ruta, JLabel tipoOper, JLabel infoAtm) {
    this.tipoOper = tipoOper;
    this.modelo = modelo;
    this.ruta = ruta;
    this.infoAtm = infoAtm;

  }

  public String getAtm() {
    String atm = null;
    atm = LecturaDiario.NumeroCajero(LecturaDiario.leerDiarios(ruta));
    return atm;
  }

  public int getTipoOperacion() {
    int t = 0;
    t = LecturaDiario.tipoOperacion(ruta);
    return t;
  }

  public int getSizeRemesa() {
    int t = 0;
    int tipo = getTipoOperacion();

    if (tipo == 1) {
      t = LecturaDiario.idx_Abastecimientos(LecturaDiario.leerDiarios(ruta)).size();
    } else if (tipo == 2) {
      t = LecturaDiario.idx_AbastecimientosDeposito(LecturaDiario.leerDiarios(ruta)).size();
    }

    return t;
  }

  public String getFechaAbastecimiento(int i) {
    String res = null;
    int tipo = getTipoOperacion();

    if (tipo == 1) {
      res = LecturaDiario.getFecha_Abastecimientos(LecturaDiario.leerDiarios(ruta)).get(i).substring(0, 17);
    } else if (tipo == 2) {
      res = LecturaDiario.getFecha_AbastecimientosDeposito(LecturaDiario.leerDiarios(ruta)).get(i).substring(0, 17);
    }
    return res;
  }

  public void infoCajero() {
    System.out.println("method: infoCajero");
    int tipo = getTipoOperacion();// RETIRO:1, DEPOSITOS:2, DEFAULT: 3
    System.out.println("tipo: " + tipo);
    int remesa = getSizeRemesa();
    System.out.println("remesa: " + remesa);
    if (tipo == 1) {
      if (remesa > 0) {
        for (int k = 0; k < getSizeRemesa(); k++) {
          modelo.addRow(new Object[] { getFechaAbastecimiento(k) });
        }
        infoAtm.setText(getAtm());
      } else {
        JOptionPane.showMessageDialog(null, "No existen abastecimientos, verifica diarios", "Alerta",
            JOptionPane.WARNING_MESSAGE);
      }
      tipoOper.setText(RETIRO);
    } else if (tipo == 2) {
      if (remesa > 0) {
        for (int k = 0; k < getSizeRemesa(); k++) {
          // pendiente
          // tabla4.addRow(new Object[] { getFechaAbastecimiento(k) });
        }
        infoAtm.setText(getAtm());
      } else {
        JOptionPane.showMessageDialog(null, "No existen abastecimientos, verifica diarios", "Alerta",
            JOptionPane.WARNING_MESSAGE);
      }
      tipoOper.setText(DEPOSITO);
    } else if (tipo == 3) {
      JOptionPane.showMessageDialog(null, "No se pudo leer contenido del directorio", "Alerta",
          JOptionPane.WARNING_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, "Pf verifica el contenido de tu directorio", "Alerta",
          JOptionPane.WARNING_MESSAGE);
    }
  }
}

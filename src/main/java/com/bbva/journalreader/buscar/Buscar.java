package com.bbva.journalreader.buscar;

import org.springframework.web.multipart.MultipartFile;

import com.bbva.journalreader.leer.LecturaDiario;

public class Buscar {

  public static final String DEPOSITO = "DEPÓSITO";
  public static final String RETIRO = "RETIRO";

  public Buscar() {}

  public String getAtm(MultipartFile[] archivos) {
    String atm = null;
    atm = LecturaDiario.NumeroCajero(LecturaDiario.leerDiarios(archivos));
    return atm;
  }

  public int getTipoOperacion(MultipartFile[] archivos) {
    int t = 0;
    t = LecturaDiario.tipoOperacion(archivos);
    return t;
  }

  public int getSizeRemesa(MultipartFile[] archivos) {
    int t = 0;
    int tipo = getTipoOperacion(archivos);

    if (tipo == 1) {
      t = LecturaDiario.idx_Abastecimientos(LecturaDiario.leerDiarios(archivos)).size();
    } else if (tipo == 2) {
      t = LecturaDiario.idx_AbastecimientosDeposito(LecturaDiario.leerDiarios(archivos)).size();
    }

    return t;
  }

  public String getFechaAbastecimiento(MultipartFile[] archivos,int i) {
    String res = null;
    int tipo = getTipoOperacion(archivos);

    if (tipo == 1) {
      res = LecturaDiario.getFecha_Abastecimientos(LecturaDiario.leerDiarios(archivos)).get(i).substring(0, 17);
    } else if (tipo == 2) {
      res = LecturaDiario.getFecha_AbastecimientosDeposito(LecturaDiario.leerDiarios(archivos)).get(i).substring(0, 17);
    }
    return res;
  }

}

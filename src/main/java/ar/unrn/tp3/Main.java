package ar.unrn.tp3;

import ar.unrn.tp3.biblioteca.MandarEmail;
import ar.unrn.tp3.modelo.VerificadorDeFechas;
import ar.unrn.tp3.persistencia.RepositorioArchivosDeEmpleados;

public class Main {

    public static void main(String[] args) {

        new VerificadorDeFechas(
                new RepositorioArchivosDeEmpleados("ArchivoEmpleados.txt"),
                new MandarEmail()).verificarEmpleadosConFechaHoy();
    }
}

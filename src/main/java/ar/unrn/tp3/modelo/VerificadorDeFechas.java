package ar.unrn.tp3.modelo;

import java.util.List;

public class VerificadorDeFechas {

    private final EmpleadoRepositorio empleadoRepositorio;
    private final MandarEmailInterface mandarCorreo;

    public VerificadorDeFechas(EmpleadoRepositorio empleadoRepositorioPasado,
                               MandarEmailInterface mandarCorreoPasado) {

        empleadoRepositorio = empleadoRepositorioPasado;
        mandarCorreo = mandarCorreoPasado;

    }

    public void verificarEmpleadosConFechaHoy() {
        List<Empleado> listaEmpleados;

        listaEmpleados = empleadoRepositorio.recuperarListaDeEmpleados();
        for (Empleado empleado : listaEmpleados) {
            if (empleado.esCumpleanios()) {
                mandarCorreo.enviarEmailACumpleañeros(empleado.email(),
                        "Feliz Cumplea\\u00f1os!",
                        "Que pases un lindo d\\u00eda!");
            }
        }
    }


}

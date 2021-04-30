package ar.unrn.tp3.persistencia;

import ar.unrn.tp3.modelo.Empleado;
import ar.unrn.tp3.modelo.EmpleadoRepositorio;

import java.util.List;

public class RepositorioParaTestearEmpleados implements EmpleadoRepositorio {

    private final List<Empleado> empleados;

    public RepositorioParaTestearEmpleados(List<Empleado> empleados) {

        this.empleados = empleados;
    }

    @Override
    public List<Empleado> recuperarListaDeEmpleados() {
        return this.empleados;
    }
}

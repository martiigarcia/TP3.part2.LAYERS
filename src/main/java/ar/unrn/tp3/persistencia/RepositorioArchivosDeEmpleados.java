package ar.unrn.tp3.persistencia;

import ar.unrn.tp3.modelo.Empleado;
import ar.unrn.tp3.modelo.EmpleadoRepositorio;
import ar.unrn.tp3.modelo.Fecha;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioArchivosDeEmpleados implements EmpleadoRepositorio {

    private final File file;

    public RepositorioArchivosDeEmpleados(String file) {
        this.file = new File(file);
    }


    @Override
    public List<Empleado> recuperarListaDeEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            for (String empleado : reader.lines().collect(Collectors.toList())) {
                String[] partesEmpleados = empleado.split(", ");
                Empleado e = new Empleado(
                        partesEmpleados[0], partesEmpleados[1],
                        new Fecha(partesEmpleados[2]), partesEmpleados[3]);
                empleados.add(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error.", e);
        }
        return empleados;
    }
}

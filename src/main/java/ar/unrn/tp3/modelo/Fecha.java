package ar.unrn.tp3.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Fecha {

    private final LocalDate fecha;

    public Fecha(String fecha) {

        if (verificarDatoNulo(fecha))
            throw new RuntimeException("Debe ingresar una fecha valida.");


        this.fecha = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("yyyy/MM/dd"));

    }

    private boolean verificarDatoNulo(Object dato) {
        return dato == null;
    }

    public boolean verificarMismaFecha(LocalDate fechaAValidar) {
        return this.fecha.equals(fechaAValidar);
    }

    public boolean verificarFechaHoy() {
        LocalDateTime fechaHoy = LocalDateTime.now();
        return fechaHoy.getMonth().equals(fecha.getMonth())
                &&
                fechaHoy.getDayOfMonth() == fecha.getDayOfMonth();

    }


}

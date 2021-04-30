package ar.unrn.tp3.modelo;

public class Empleado {

    private final String nombre;
    private final String apellido;
    private final String email;
    private final Fecha fechaNacimiento;

    public Empleado(String apellido, String nombre, Fecha fechaNacimiento, String email) {

        if (verificarDatoNulo(nombre) || verificarDatoVacio(nombre))
            throw new RuntimeException("Debe ingresar un nombre valido.");
        if (verificarDatoNulo(apellido) || verificarDatoVacio(apellido))
            throw new RuntimeException("Debe ingresar un apellido valido.");
        if (verificarDatoNulo(email) || verificarDatoVacio(email))
            throw new RuntimeException("Debe ingresar un email valido.");

        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;

    }

    private boolean verificarDatoVacio(String dato) {
        return dato.isEmpty();
    }

    private boolean verificarDatoNulo(Object dato) {
        return dato == null;
    }

   
    public String email() {
        return email;
    }

    public boolean esCumpleanios() {
        return fechaNacimiento.verificarFechaHoy();
    }
}

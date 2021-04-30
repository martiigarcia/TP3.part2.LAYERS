package ar.unrn.tp3.persistencia;

import ar.unrn.tp3.modelo.Empleado;
import ar.unrn.tp3.modelo.MandarEmailInterface;

public class MandarEmailParaTestear implements MandarEmailInterface {


    private String email;


    public MandarEmailParaTestear() {

    }


    @Override
    public void enviarEmailACumpleañeros(String email, String tituloCorreo, String cuerpoCorreo) {
        this.email = email + " -> " + tituloCorreo + " - " + cuerpoCorreo;

    }

    public boolean verificarEmailEnviado(String email) {
        return email.equals(email);
    }
}

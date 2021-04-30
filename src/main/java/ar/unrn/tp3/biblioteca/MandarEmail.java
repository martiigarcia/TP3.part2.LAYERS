package ar.unrn.tp3.biblioteca;

import ar.unrn.tp3.modelo.Empleado;
import ar.unrn.tp3.modelo.MandarEmailInterface;

public class MandarEmail implements MandarEmailInterface {


    @Override
    public void enviarEmailACumpleañeros(
            String email, String tituloCorreo, String cuerpoCorreo) {
        try {
            new Email(email, tituloCorreo, cuerpoCorreo).enviar();
        } catch (SmtpException e) {
            throw new RuntimeException("No se pudo enviar el mensaje.", e);
        }
    }
}

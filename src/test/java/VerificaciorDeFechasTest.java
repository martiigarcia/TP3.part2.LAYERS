import ar.unrn.tp3.modelo.*;
import ar.unrn.tp3.persistencia.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class VerificaciorDeFechasTest {


    private RepositorioParaTestearEmpleados repositorio;
    private MandarEmailParaTestear email;


    @BeforeEach
    void hacerSetUp() {

        List<Empleado> lista = new ArrayList<>();

        lista.add(new Empleado("Perez", "Juan",
                new Fecha(this.PonerFechaConFormatoCorrecto(LocalDate.now())),
                "j@example.com"));

        lista.add(new Empleado("Lopez", "Maria",
                new Fecha(this.PonerFechaConFormatoCorrecto(LocalDate.of(1992, 3, 3))),
                "m@example.com"));


        repositorio = new RepositorioParaTestearEmpleados(lista);
        email = new MandarEmailParaTestear();


    }


    @Test
    public void mandarEmail() {

        VerificadorDeFechas verificadorDeFechas =
                new VerificadorDeFechas(repositorio, email);

        verificadorDeFechas.verificarEmpleadosConFechaHoy();

        assertTrue(
                email.verificarEmailEnviado(
                        "j@example.com" + " -> " + "Feliz Cumplea\\u00f1os!" + " - " + "Que pases un lindo d\\u00eda!"));


    }

    public String PonerFechaConFormatoCorrecto(LocalDate fecha) {
        return fecha.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }


}

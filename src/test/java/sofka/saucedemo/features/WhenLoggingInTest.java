package sofka.saucedemo.features;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.questions.Text;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import sofka.saucedemo.tasks.Login;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenLoggingInTest {

    @CastMember(name = "Cliente de SauceDemo")
    Actor cliente;

    @Test
    @DisplayName("El usuario standard_user inicia sesion correctamente")
    void loginExitoso() {

        // Ejecutar la tarea de autenticacion
        cliente.attemptsTo(
                Login.as("standard_user", "secret_sauce")
        );

        // Consultar el titulo de la pagina
        String titulo = cliente.asksFor(
                Text.of(".title")
        );

        // Verificar que ingresamos al inventario
        assertThat(titulo).isEqualTo("Products");
    }
}

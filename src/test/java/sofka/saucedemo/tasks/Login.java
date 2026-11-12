package sofka.saucedemo.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

public class Login {

    public static Performable as(String username, String password) {
        return Task.where("{0} inicia sesion en SauceDemo",
                Open.url("https://www.saucedemo.com/"),

                Enter.theValue(username)
                        .into("#user-name"),

                Enter.theValue(password)
                        .into("#password"),

                Click.on("#login-button")
        );
    }
}


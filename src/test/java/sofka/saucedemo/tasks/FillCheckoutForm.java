package sofka.saucedemo.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import sofka.saucedemo.pages.CheckoutPage;

public class FillCheckoutForm {

    public static Performable withData(
            String firstName,
            String lastName,
            String postalCode
    ) {

        return Task.where(
                "{0} completa el formulario de compra",

                Click.on(CheckoutPage.CHECKOUT_BUTTON),

                Enter.theValue(firstName)
                        .into(CheckoutPage.FIRST_NAME),

                Enter.theValue(lastName)
                        .into(CheckoutPage.LAST_NAME),

                Enter.theValue(postalCode)
                        .into(CheckoutPage.POSTAL_CODE),

                Click.on(CheckoutPage.CONTINUE_BUTTON)
        );
    }
}

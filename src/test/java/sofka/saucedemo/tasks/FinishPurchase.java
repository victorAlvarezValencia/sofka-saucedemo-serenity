package sofka.saucedemo.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import sofka.saucedemo.pages.CheckoutPage;

public class FinishPurchase {

    public static Performable now() {

        return Task.where(
                "{0} confirma y finaliza la compra",

                Click.on(CheckoutPage.FINISH_BUTTON)
        );
    }
}

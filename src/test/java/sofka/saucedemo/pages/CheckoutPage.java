package sofka.saucedemo.pages;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage {

    public static final Target CHECKOUT_BUTTON =
            Target.the("Boton para iniciar checkout")
                    .locatedBy("#checkout");

    public static final Target FIRST_NAME =
            Target.the("Campo nombre")
                    .locatedBy("#first-name");

    public static final Target LAST_NAME =
            Target.the("Campo apellido")
                    .locatedBy("#last-name");

    public static final Target POSTAL_CODE =
            Target.the("Campo codigo postal")
                    .locatedBy("#postal-code");

    public static final Target CONTINUE_BUTTON =
            Target.the("Boton continuar")
                    .locatedBy("#continue");

    public static final Target OVERVIEW_TITLE =
            Target.the("Titulo resumen de compra")
                    .locatedBy(".title");

    public static final Target FINISH_BUTTON =
            Target.the("Boton finalizar compra")
                    .locatedBy("#finish");

    public static final Target CONFIRMATION_MESSAGE =
            Target.the("Mensaje de compra exitosa")
                    .locatedBy(".complete-header");
}

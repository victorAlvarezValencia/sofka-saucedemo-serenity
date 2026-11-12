package sofka.saucedemo.pages;

import net.serenitybdd.screenplay.targets.Target;

public class InventoryPage {

    public static final Target BACKPACK_BUTTON =
            Target.the("Boton agregar mochila al carrito")
                    .locatedBy("#add-to-cart-sauce-labs-backpack");

    public static final Target BIKE_LIGHT_BUTTON =
            Target.the("Boton agregar luz de bicicleta al carrito")
                    .locatedBy("#add-to-cart-sauce-labs-bike-light");

    public static final Target CART_ICON =
            Target.the("Icono del carrito")
                    .locatedBy(".shopping_cart_link");
}

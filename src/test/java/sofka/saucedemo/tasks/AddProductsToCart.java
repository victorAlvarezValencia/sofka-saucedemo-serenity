package sofka.saucedemo.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import sofka.saucedemo.pages.InventoryPage;

public class AddProductsToCart {

    public static Performable twoProducts() {

        return Task.where(
                "{0} agrega dos productos al carrito",

                Click.on(InventoryPage.BACKPACK_BUTTON),

                Click.on(InventoryPage.BIKE_LIGHT_BUTTON)
        );
    }
}


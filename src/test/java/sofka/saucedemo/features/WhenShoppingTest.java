package sofka.saucedemo.features;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import sofka.saucedemo.tasks.Login;
import sofka.saucedemo.tasks.AddProductsToCart;
import sofka.saucedemo.tasks.FillCheckoutForm;
import sofka.saucedemo.tasks.FinishPurchase;

import sofka.saucedemo.pages.InventoryPage;
import sofka.saucedemo.pages.CheckoutPage;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenShoppingTest {

    @CastMember(name = "Cliente de SauceDemo")
    Actor cliente;

    @Test
    @DisplayName("Compra E2E exitosa de dos productos")
    void compraExitosa() {

        // 1. Autenticacion
        cliente.attemptsTo(
                Login.as("standard_user", "secret_sauce")
        );

        // 2. Agregar dos productos
        cliente.attemptsTo(
                AddProductsToCart.twoProducts()
        );

        // 3. Validar cantidad del carrito
        String cantidad = cliente.asksFor(
                Text.of(".shopping_cart_badge")
        );

        assertThat(cantidad).isEqualTo("2");

        // 4. Visualizar carrito
        cliente.attemptsTo(
                Click.on(InventoryPage.CART_ICON)
        );

        // 5. Verificar productos
        String mochila = cliente.asksFor(
                Text.of("#item_4_title_link")
        );

        String luzBicicleta = cliente.asksFor(
                Text.of("#item_0_title_link")
        );

        assertThat(mochila)
                .isEqualTo("Sauce Labs Backpack");

        assertThat(luzBicicleta)
                .isEqualTo("Sauce Labs Bike Light");

        // 6. Completar checkout
        cliente.attemptsTo(
                FillCheckoutForm.withData(
                        "Victor",
                        "Alvarez",
                        "760001"
                )
        );

        // 7. Validar que llegamos al resumen
        String resumen = cliente.asksFor(
                Text.of(CheckoutPage.OVERVIEW_TITLE)
        );

        assertThat(resumen)
                .isEqualTo("Checkout: Overview");

        // 8. Confirmar compra
        cliente.attemptsTo(
                FinishPurchase.now()
        );

        // 9. Validar confirmacion final
        String confirmacion = cliente.asksFor(
                Text.of(CheckoutPage.CONFIRMATION_MESSAGE)
        );

        assertThat(confirmacion)
                .containsIgnoringCase("THANK YOU FOR YOUR ORDER");
    }
}


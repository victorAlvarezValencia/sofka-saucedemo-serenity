# QA Automation E2E — SauceDemo | Sofka

Prueba funcional automatizada de un flujo de compra de dos productos en [SauceDemo](https://www.saucedemo.com/), utilizando **Serenity BDD 5.3.8**, **Java 21**, **JUnit 5** y el patrón **Screenplay**.

## Cobertura

- Inicio de sesión con usuario de demostración `standard_user`.
- Agregar **Sauce Labs Backpack** y **Sauce Labs Bike Light**.
- Abrir el carrito y verificar productos y cantidad.
- Completar formulario de compra y revisar el checkout.
- Finalizar y validar `THANK YOU FOR YOUR ORDER`.

## Estructura

- `src/test/java/sofka/saucedemo/features/`: escenarios `WhenLoggingInTest` y `WhenShoppingTest`.
- `src/test/java/sofka/saucedemo/tasks/`: tareas Screenplay reutilizables.
- `src/test/java/sofka/saucedemo/pages/`: elementos y selectores `Target`.
- `src/test/resources/serenity.conf`: configuración del navegador.
- `evidencias/reporte-serenity.zip`: reporte interactivo exportado.
- `readme.txt`: instrucciones completas de instalación y ejecución exigidas por la prueba.
- `conclusiones.txt`: hallazgos, resultados y limitaciones exigidos por la prueba.

## Ejecución

Requiere **JDK 21**, **Maven 3.x** y **Chrome**.

```powershell
mvn clean verify
```

Para ejecutar solo la compra E2E con navegador visible en Windows PowerShell:

```powershell
mvn clean verify "-Dit.test=WhenShoppingTest" "-Dheadless.mode=false"
```

Después de ejecutar las pruebas, abrir `target/site/serenity/index.html`. Para revisar el reporte publicado sin compilar, descomprimir `evidencias/reporte-serenity.zip` y abrir su `index.html`.

## Resultados verificados

- Suite: **2/2 pruebas aprobadas**, 0 fallos, 0 errores.
- Compra E2E individual: **1/1 prueba aprobada**, duración aproximada de **6,58 s** en la ejecución observada.

Estos resultados corresponden al flujo positivo especificado y no implican una certificación integral de la aplicación.

## Referencia

Proyecto iniciado desde la plantilla oficial [serenity-junit-screenplay-starter](https://github.com/serenity-bdd/serenity-junit-screenplay-starter). Se mantiene el reconocimiento correspondiente a su licencia y autores.

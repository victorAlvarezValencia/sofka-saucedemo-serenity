PRUEBA TECNICA SOFKA - EJERCICIO 1
Automatizacion funcional E2E de compra en SauceDemo
==================================================

1. OBJETIVO
-----------
Automatizar y verificar el flujo de compra de dos productos en
https://www.saucedemo.com/ usando Serenity BDD, el patron Screenplay,
Java, Selenium WebDriver y JUnit 5.

El flujo cubierto es:
1) Iniciar sesion con el usuario de demostracion standard_user.
2) Agregar Sauce Labs Backpack y Sauce Labs Bike Light al carrito.
3) Visualizar el carrito y comprobar los dos productos.
4) Completar el formulario del checkout con datos de prueba.
5) Revisar el resumen de compra, finalizar y verificar el mensaje:
   THANK YOU FOR YOUR ORDER.

2. TECNOLOGIAS Y VERSIONES DE LA EJECUCION
------------------------------------------
- Java: Eclipse Temurin OpenJDK 21.0.12.1
- Apache Maven: 3.10.0
- Serenity BDD: 5.3.8
- Framework de pruebas: JUnit 5
- Patron de automatizacion: Screenplay
- Automatizacion de navegador: Selenium WebDriver / Chrome
- Sistema operativo de desarrollo: Windows 10 (64 bits)

Las versiones exactas de las dependencias gestionadas por Maven se encuentran
en pom.xml. Se necesita Google Chrome compatible instalado.

3. REQUISITOS PREVIOS
--------------------
- JDK 21 instalado y disponible en PATH (java y javac).
- Apache Maven instalado y disponible en PATH (mvn).
- Git para clonar el repositorio.
- Google Chrome instalado.
- Conexion a Internet para acceder a SauceDemo y descargar dependencias
  Maven en la primera ejecucion.

Verificar en una terminal:
  java -version
  javac -version
  mvn -version
  git --version

4. DESCARGAR Y ABRIR EL PROYECTO
--------------------------------
Clonar desde la URL publica de este repositorio:
  git clone <URL_DEL_REPOSITORIO_PUBLICO>

Ingresar al directorio generado (o abrirlo desde IntelliJ IDEA):
  cd sofka-saucedemo-serenity

NOTA: Sustituir <URL_DEL_REPOSITORIO_PUBLICO> por la URL real antes de publicar
la entrega. No es necesario instalar Serenity BDD por separado: Maven recupera
las dependencias declaradas en pom.xml.

5. EJECUCION DE PRUEBAS
-----------------------
Desde la raiz del proyecto, donde se encuentra pom.xml:

Ejecutar ambas pruebas:
  mvn clean verify

Ejecutar solamente el flujo de compra E2E en Windows PowerShell:
  mvn clean verify "-Dit.test=WhenShoppingTest" "-Dheadless.mode=false"

Ejecutar solamente el login en Windows PowerShell:
  mvn clean verify "-Dit.test=WhenLoggingInTest" "-Dheadless.mode=false"

Para ejecutar el navegador de forma visible usar headless.mode=false.
El navegador se cierra automaticamente cuando termina la ejecucion.

6. ESTRUCTURA PRINCIPAL
-----------------------
  pom.xml
  serenity.properties
  src/test/resources/serenity.conf
  src/test/java/sofka/saucedemo/
    features/
      WhenLoggingInTest.java
      WhenShoppingTest.java
    pages/
      InventoryPage.java
      CheckoutPage.java
    tasks/
      Login.java
      AddProductsToCart.java
      FillCheckoutForm.java
      FinishPurchase.java
  evidencias/
    reporte-serenity.zip
  readme.txt
  conclusiones.txt

- features: casos de prueba ejecutables.
- tasks: actividades reutilizables realizadas por el actor de Screenplay.
- pages: definicion de objetivos/elementos (Target) de la interfaz.

7. REPORTES Y EVIDENCIAS
-----------------------
Tras ejecutar mvn clean verify, Serenity genera el reporte interactivo en:
  target/site/serenity/index.html

Abrir index.html en un navegador para revisar escenarios, pasos y resultados.
El archivo evidencias/reporte-serenity.zip contiene una copia exportada del
reporte de la ultima ejecucion validada, para facilitar su revision sin volver
a ejecutar Maven. Descomprimirlo y abrir index.html.

La carpeta target/ contiene archivos generados y no se almacena completa en Git.

8. CRITERIOS DE EXITO
---------------------
- Inicio de sesion correcto.
- Dos productos agregados al carrito y contador igual a 2.
- Nombres de ambos productos verificados en la vista del carrito.
- Formulario completado y acceso al resumen de compra.
- Pantalla de confirmacion con el texto THANK YOU FOR YOUR ORDER.
- Resultado del test E2E: PASSED.

9. NOTAS DE REPRODUCIBILIDAD
---------------------------
- Se utiliza el usuario de demostracion publicado por SauceDemo.
- No se usan credenciales reales, tokens privados ni archivos .env.
- Las pruebas requieren que la pagina externa SauceDemo este disponible.
- Las diferencias de versiones de Chrome/Selenium pueden producir advertencias
  CDP no bloqueantes. Verificar los resultados funcionales y el reporte.
- Si cambia la estructura HTML de SauceDemo, los selectores de las clases
  pages y tasks podrian requerir mantenimiento.

10. CONCLUSIONES
---------------
Consultar conclusiones.txt para resultados, alcance, hallazgos y limitaciones.

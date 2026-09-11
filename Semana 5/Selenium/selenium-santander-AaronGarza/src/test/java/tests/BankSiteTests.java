package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BankHomePage;

public class BankSiteTests extends BaseTest {

    @DataProvider(name = "menuItems")
    public Object[][] menuItems() {
        return new Object[][] {
//Primero se divien las secciones del sitio santander.com.mx y despues se accede a cada uno
//individualmente usando la mismo metodo "verifySiteLinkSantander()"

            // Personas: Credito y financiamiento
            {"Personas", "tarjetas-de-credito/", "tarjetas-de-credito"},
            {"Personas", "creditos-personales/", "creditos-personales"},
            {"Personas", "creditos-hipotecarios/", "creditos-hipotecarios"},
            {"Personas", "simulador-hipotecario/", "simulador-hipotecario"},
            {"Personas", "credito-automotriz/", "credito-automotriz"},
            {"Personas", "buro-de-credito/", "buro-de-credito"},

            // Personas: Canales digitales
            {"Personas", "santander-digital/", "santander-digital"},
            {"Personas", "app-santander/", "app-santander"},
            {"Personas", "santander-web/", "santander-web"},
            {"Personas", "limite-por-transaccion/", "limite-por-transaccion"},

            // Personas: Tipo de cuenta
            {"Personas", "personas/cuentas/", "personas/cuentas"},
            {"Personas", "cuentas/basica/", "cuentas/basica"},
            {"Personas", "basica-nomina/", "basica-nomina"},
            {"Personas", "cheque-saldo-promedio/", "cheque-saldo-promedio"},
            {"Personas", "portabilidad-de-nomina/", "portabilidad-de-nomina"},

            // Personas: Ahorro e inversion
            {"Personas", "#fondos-de-inversion", "fondos-de-inversion"},
            {"Personas", "#inversiones-a-plazo", "inversiones-a-plazo"},
            {"Personas", "#notas-estructuradas", "notas-estructuradas"},

            // Personas: Seguros
            {"Personas", "seguros.html#auto", "seguros.html#auto"},
            {"Personas", "seguros.html#vida", "seguros.html#vida"},
            {"Personas", "seguros.html#hogar", "seguros.html#hogar"},
            {"Personas", "seguros.html#ahorro", "seguros.html#ahorro"},
            {"Personas", "seguros.html#gastos-medicos", "gastos-medicos"},
            {"Personas", "seguros.html#pertenencias", "pertenencias"},

            // Personas: Informacion y ayuda
            {"Personas", "superlinea.html", "superlinea"},
            {"Personas", "sucursales.html", "sucursales"},
            {"Personas", "cajeros-automaticos.html", "cajeros-automaticos"},
            {"Personas", "operaciones-canales-alternos/index.html", "canales-alternos"},
            {"Personas", "centro-de-ayuda.html", "centro-de-ayuda"},
            {"Personas", "centro-de-seguridad/", "centro-de-seguridad"},
            {"Personas", "tutoriales.html", "tutoriales"},
            {"Personas", "terminos-y-condiciones.html", "tyc"},
            {"Personas", "tramite-por-defuncion.html", "tramite-por-defuncion"},

            // Personas: Beneficios
            {"Personas", "select.html", "select.html"},
            {"Personas", "promociones/", "promociones"},
            {"Personas", "uniquerewards.santander.com.mx/web/home", "uniquerewards"},
            {"Personas", "mundohogar.com.mx  ", "mundohogar"},
            {"Personas", "colectivos.html", "colectivos"},
            {"Personas", "cashback.html", "cashback"},

            // Empresas
            {"Empresas", "bei/home.html", "bei/home"},
            {"Empresas", "multinacionales.html", "multinacionales"},

            // PyMes
            {"PyMes", "pyme/cuentas.html", "pyme/cuentas"},
            {"PyMes", "pyme/creditos.html", "pyme/creditos"},
            {"PyMes", "pyme/seguros.html", "pyme/seguros"},
            {"PyMes", "coberturas-y-cambios.html", "coberturas-y-cambios"},
            {"PyMes", "negocio-internacional.html", "negocio-internacional"},
            {"PyMes", "paquetes-pymes.html", "paquetes-pymes"},
            {"PyMes", "alianzas.html", "alianzas"},
            {"PyMes", "negocio-transaccional.html", "negocio-transaccional"},
            {"PyMes", "ecosistemas-pyme.html", "ecosistemas-pyme"},
            {"PyMes", "pyme/inversiones.html", "pyme/inversiones"},

            // Acerca del Banco
            {"Acerca del Banco", "fundacion-santander.html", "fundacion-santander"},
            {"Acerca del Banco", "personas/blog.html", "blog"},
            {"Acerca del Banco", "responsabilidad-social.html", "responsabilidad-social"},
            {"Acerca del Banco", "educacion-financiera/", "educacion-financiera"},
            {"Acerca del Banco", "ir/home/", "ir/home"},
            {"Acerca del Banco", "sala_prensa_2026.html", "sala_prensa_2026"},
            {"Acerca del Banco", "personas/bolsa-de-trabajo.html", "bolsa-de-trabajo"},
        };
    }

    @Test(dataProvider = "menuItems")
    public void verifySiteLinkSantander(String topMenu, String hrefEndsWith,
                                        String expectedUrlFragment) {
        BankHomePage home = new BankHomePage(driver);

        home.goToMenuItem(topMenu, hrefEndsWith, expectedUrlFragment);

        Assert.assertTrue(home.currentUrl().contains(expectedUrlFragment),
                "No se navego correctamente a " + topMenu + " -> " + hrefEndsWith
                        + ". URL actual: " + home.currentUrl());
    }

    //La página "Banca privada", en lugar de tener una ventana de opciones, lleva a otro sitio
    //al hacer click, por lo que realizamos un assert true si nos lleva a la página requerida
    //en donde el url es https://www.santander.com.mx/bp/home/
    @Test
    public void verifyBancaPrivada() {
        BankHomePage home = new BankHomePage(driver);

        home.goToDirectMenuLink("bp/home/", "bp/home");

        Assert.assertTrue(home.currentUrl().contains("bp/home"),
                "No se navego a Banca Privada. URL actual: " + home.currentUrl());
    }

    @Test
    public void verifyHazteCliente() {
        BankHomePage home = new BankHomePage(driver);

        home.goToDirectMenuLink("personas/hazte-cliente.html", "personas/hazte-cliente.html");

        Assert.assertTrue(home.currentUrl().contains("personas/hazte-cliente.html"),
                "No se navego a la página Hazte Cliente. URL actual: " + home.currentUrl());
    }
}

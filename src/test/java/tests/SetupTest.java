package tests;


import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import utils.Browser;
import utils.Utils;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

@Feature("Testes site de ecommerce")
public class SetupTest extends BaseTests {

    @Test
    @Story("Abrir o site")
    public void testOpeningBrowserAndLoadingPage() {
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl()));
        System.out.println("Abrimos o navegador e carregamos a url!");
    }

    @Test
    @Story("Realizar login")
    public void testLogin() {

        // Iniciar as páginas
        HomePage home = new HomePage();
        LoginPage login = new LoginPage();

        // Iniciar Eventos
        home.clickBtnLogin();
        System.out.println("Click login");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
                .contains(Utils.getBaseUrl()
                        .concat("index.php?controller=authentication&back=my-account")));
        login.fillEmail();
        System.out.println("Preencheu o email");
        login.fillPassword();
        System.out.println("Preencheu a senha");
        login.clickBtnSubmitLogin();
        System.out.println("Clicou em Sign In");
        assertTrue(Browser.getCurrentDriver()
                .getCurrentUrl().contains("index.php?controller=my-account"));
        System.out.println("validou que foi para home de um cadastro.");
        assertTrue(Browser.getCurrentDriver()
                .findElement(By.className("page-heading"))
                .getText().contains("MY ACCOUNT"));
        System.out.println("Validou Minha conta no site");

    }

    @Test
    @Story("Acessando Categoria camisetas")
    public void testAccessCategoryTShirts() {
        //Iniciar as Páginas
        HomePage home = new HomePage();
        CategoryPage category = new CategoryPage();

        //Clicar na categoria T_SHIRTS
        home.clickCategoryTShirts();
        //Browser.getCurrentDriver().findElement(By.linkText("T-SHIRTS")).click();

        //Validar se ao clicar na categoria T_SHIRTS ocorre o direcionamento correto
        assertTrue(category.isPageTshirts());
    }

    @Test
    @Story("Adicionando produto na página de produto")
    public void testAddProductToProductPage() {
        //Acessar a categoria T-Shirts
        testAccessCategoryTShirts();

        //Iniciar as páginas
        CategoryPage category = new CategoryPage();
        ProductPage pdp = new ProductPage();

        //Salva nome produto na Página
        String nameProductCategory = category.getProductNameCategory();

        //Clicar em More e direcionar para a página do produto
        category.clickProductAddToProductPage();

        // validar se produto está na página de detalhes do produto corretamente
        assertTrue(pdp.getProductNamePDP().equals(nameProductCategory));
    }

    @Test
    @Story("Adicionando produto ao carrinho de compras")
    public void testAddProductToCartPage() {
        //Acessa a página de produtos
        testAddProductToProductPage();

        //Iniciar páginas
        ProductPage pdp = new ProductPage();
        CartPage cart = new CartPage();

        //Salvar o nome do produto na página de PDP
        String nameProductPDP = pdp.getProductNamePDP();

        //Clicar no botão de adicionar ao carrinho
        pdp.clickButtonAddCart();

        //Clicar no botão Proceed to Checkout da modal
        pdp.clickButtonModalProceedToCheckout();

        //validação do nome do produto
        assertTrue(cart.getNameProductcart().equals(nameProductPDP));
    }


    @Test
    @Story("Procurando por vestido")
    public void testSearch() {

        String quest = "DRESS";
        String questResult = "7 results have been found";
        //Iniciar Páginas
        HomePage home = new HomePage();
        SearchPage search = new SearchPage();

        System.out.println("Fazendo Pesquisa");
        home.doSearch(quest);

        System.out.println("Validando a pesquisa");
        assertTrue(search.isSearchPage());
        assertEquals(search.getTextLighter().replace("\"", ""), quest);
        assertThat(search.getTextHeading_counter()
                , CoreMatchers.containsString(questResult));

    }

    @Test
    @Story("Cadastrando Usuário site")
    public void testRegisterUserInEcommerce() throws InterruptedException {
        //String de Validação
        String nameCreateAnAccount = "Authentication";
        String nameTestMyAccount = "My account";
        String userTestName = "Michael Silveira";

        //Iniciando as Páginas
        HomePage home = new HomePage();
        MyAccountPage myAccount = new MyAccountPage();
        RegisterPage register = new RegisterPage();

        System.out.println("Clicando em Sign in");
        home.clickBtnLogin();

        System.out.println("valindando se esta em autenticação");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
                .contains(Utils.getBaseUrl()
                        .concat("index.php?controller=authentication&back=my-account")));

        System.out.println("Preencheu email");
        myAccount.fillEmailCreate();

        System.out.println("Clicando em Create an account");
        myAccount.clickCreateAnAccount();

        System.out.println("Validando que foi para Create an account");
        WebDriverWait wait = new WebDriverWait(Browser.getCurrentDriver(), 3);
        wait.until(ExpectedConditions.urlContains("#account-creation"));
        Assert.assertEquals(Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account#account-creation"),
                Browser.getCurrentDriver().getCurrentUrl());

        String authenticationCration = myAccount.getNameAuthentication();
        assertEquals(nameCreateAnAccount, authenticationCration);


        System.out.println("preenchendo os dados do formulário");
        register.clickLabelMrs();
        register.fillFirstName();
        register.fillLastName();
        register.fillPassword();
        register.clickDayBirth();
        register.clickMonthBirth();
        register.clickYearBirth();
        register.fillNameAddress();
        register.fillLastNameAddress();
        register.fillStreetAddress();
        register.fillCity();
        register.ClickState();
        register.fillPostalCode();
        register.fillHomePhone();
        register.fillMobilePhone();
        register.fillAddressAlias();
        System.out.println("Clicando para confirmar cadastro");
        register.clickRegister();

        String nameMyAccount = myAccount.getNameAuthentication();
        String userName = myAccount.getNameMyAccount();

        System.out.println("validando nome my account após cadastro concluído");
        assertEquals(nameTestMyAccount, nameMyAccount);

        System.out.println("validando nome Michael Silveira após cadastro concluído");
        assertEquals(userTestName, userName);

        System.out.println("valindando se está na pagina de cadastro do usuário.");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
                .contains(Utils.getBaseUrl()
                        .concat("index.php?controller=my-account")));
    }

    @Test
    @Story("Comprando no site")
    public void testPurchaseCompletedInEcommerce() {
        String myCart = "Your shopping cart";
        String valueCart = "1 Product";
        String nameAccount = "Michael Silveira";
        String nameShipping = "Shipping";
        String yourPaymentMethod = "PLEASE CHOOSE YOUR PAYMENT METHOD";
        String namePayment = "Bank-wire payment.";
        String nameOrdemConfirmation = "Your order on My Store is complete.";

        //Acessa My Account
        testLogin();
        //Adiciona Produto no carrinho compras
        testAddProductToCartPage();

        //Adicionando Páginas
        OrderPage order = new OrderPage();
        ShippingPage shipping = new ShippingPage();
        PaymentPage payment = new PaymentPage();

        String your_shopping_cart = order.getNameYourShoppingCart();
        String valueCartOne = order.getValueInCart();


        System.out.println("Verificando se está no carrinho de compras");
        Assert.assertEquals(myCart, your_shopping_cart);
        Assert.assertEquals(valueCart, valueCartOne);

        System.out.println("Clicando e indo para endereço");
        order.clickProccedToCheckoutCart();


        String nameAccountAddress = order.getNameAccount();
        System.out.println("Verificando em endereço se o nome do usuário está correto");
        Assert.assertEquals(nameAccount, nameAccountAddress);

        System.out.println("valindando se está na página de endereço.");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
                .contains(Utils.getBaseUrl()
                        .concat("index.php?controller=order&step=1")));



        System.out.println("clicando e indo para envio");
        order.clickProccedToCheckoutAddress();

        System.out.println("Validando nome Shipping na página");
        String shippingName = shipping.getNameShippingPage();
        Assert.assertEquals(nameShipping, shippingName);

        System.out.println("validando se está na pagina shipping");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
                .contains(Utils.getBaseUrl()
                        .concat("index.php?controller=order")));


        System.out.println("clicando no label de aceitação de termos e serviços ");
        shipping.clickIAgree();

        System.out.println("Clicando e indo para página de Payment");
        shipping.clickProceedToCheckoutShipping();

        System.out.println("validando se está na pagina Payment");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
                .contains(Utils.getBaseUrl()
                        .concat("index.php?controller=order&multi-shipping=")));

        System.out.println("Validando se está em your payment method");
        String textNameInPayment = payment.getNameYourPaymentMethod();
        Assert.assertEquals(yourPaymentMethod, textNameInPayment);



        System.out.println("Clicando em Pay by bank wire");
        payment.clickInPayByBankWire();

        System.out.println("validando se está na pagina Payment");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
                .contains(Utils.getBaseUrl()
                        .concat("index.php?fc=module&module=bankwire&controller=payment")));
        
        System.out.println("validando página payment");
        String paymentBank = payment.getNameBank_wirePayment();
        Assert.assertEquals(namePayment, paymentBank);

        System.out.println("Clicando para confirmar pedido");
        payment.clickInConfirmMyOrder();

        System.out.println("validando página pedido confirmado");
        String orderConfirmation = payment.getNameOrdemConfirmation();
        Assert.assertEquals(nameOrdemConfirmation, orderConfirmation);


    }

}

package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage (WebDriver driver){ 
        super(driver);
    }

    By homePageTitleBy = By.xpath("//*[@id='header_container']/div[2]/span");

    By numberOfItemsBy = By.className("inventory_item");
    
    By addToCartButton_1By = By.id("add-to-cart-sauce-labs-backpack");
    By addToCartButton_2By = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By shoppingCartBadgeBy = By.className("shopping_cart_badge");

    By shoppingCartLinkBy = By.xpath("//*[@id='shopping_cart_container']/a");
    By numberOfItemsAddedToCartBy = By.className("cart_item_label");

    By checkOutButtonBy = By.id("checkout");
    
    By logoutSidebarLinkBy = By.id("logout_sidebar_link");
    By BurgerMenuButtonBy = By.id("react-burger-menu-btn");

    By fistNameBy = By.id("first-name");
    By lastNameBy = By.id("last-name");
    By postalCodeBy = By.id("postal-code");
    By continueButtonBy = By.id("continue");
    
    By price_1By = By.xpath("//*[@id='checkout_summary_container']/div/div[1]/div[3]/div[2]/div[2]/div");
    By price_2By = By.xpath("//*[@id='checkout_summary_container']/div/div[1]/div[4]/div[2]/div[2]/div");
    By priceSubtotalBy = By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[5]");

    By taxAddedBy = By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[6]");
    By priceTotalBy = By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[7]");

    By finishButtonBy = By.id("finish");
    By SucessfulOrderMessageBy = By.xpath("//*[@id='checkout_complete_container']/h2");

    
    public HomePage verifySuccesfulLogIn(String expectedText){
        String actualText = readText(homePageTitleBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public HomePage verifyNumberOfProductsOnHomePage(int expectedNumber){
        int actualNumber = countItems(numberOfItemsBy);
        assertIntEquals(expectedNumber, actualNumber);
        return this;
    }

    public HomePage verifyProductsAddedToCart(){
        click(addToCartButton_1By);
        click(addToCartButton_2By);
        waitVisability(shoppingCartBadgeBy);
        return this;
    }

    public HomePage verifyNumberOfProductsAddedToCart(int expectedNumber){
        click(shoppingCartLinkBy);
        int actualNumber = countItems(numberOfItemsAddedToCartBy);
        assertIntEquals(expectedNumber, actualNumber);
        return this;
    }

    public HomePage goToCheckout(){
        click(checkOutButtonBy);
        return this; 
    }
    
    public HomePage fillInformationForm(String firstName, String lastName, String postalCode){
        writeText(fistNameBy, firstName);
        writeText(lastNameBy, lastName);
        writeText(postalCodeBy, postalCode);
        click(continueButtonBy);
        return this;
    }
    
    public HomePage verifyCorrectSubtotal(){
        double price_1 = Double.parseDouble(readText(price_1By).substring(1));
        double price_2 = Double.parseDouble(readText(price_2By).substring(1));
        double sumOfPrices = price_1 + price_2;
        double priceSubtotal = Double.parseDouble(readText(priceSubtotalBy).substring(13));
        assertDoubleEquals(sumOfPrices, priceSubtotal);
        return this;
    }

    public HomePage verifyCorrectTotal(){
        double priceSubtotal = Double.parseDouble(readText(priceSubtotalBy).substring(13));
        double taxAdded =  Double.parseDouble(readText(taxAddedBy).substring(6));
        double priceTotal = Double.parseDouble(readText(priceTotalBy).substring(8));
        double subtotalPlusTax = priceSubtotal + taxAdded;
        assertDoubleEquals(subtotalPlusTax, priceTotal);
        return this;
    }

    public HomePage verifySuccesfulOrder(String expectedText){
        click(finishButtonBy);
        String actualText = readText(SucessfulOrderMessageBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public HomePage logout(){
        click(BurgerMenuButtonBy);
        click(logoutSidebarLinkBy);
        return this;
    }


    
}

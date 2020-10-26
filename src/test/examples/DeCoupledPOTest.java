package test.examples;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import test.data.Product;
import test.pages.CartPage;
import test.pages.InventoryPage;
import test.pages.ProductPage;

import static org.junit.Assert.assertTrue;

public class DeCoupledPOTest {
    WebDriver driver;

    @Test
    public void explicitInitialization() {
        Product product = Product.valid();

        InventoryPage inventoryPage = InventoryPage.visit(driver);
        inventoryPage.selectProduct(product);

        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();
        productPage.checkout();

        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.hasProduct(product));
    }

}

package test.examples;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import test.data.Product;
import test.pages.InventoryPage;

import static org.junit.Assert.assertTrue;

public class CoupledPOTest {
    WebDriver driver;

    @Test
    public void fluentPageObjects() {
        Product product = Product.valid();

        assertTrue(InventoryPage.visit(driver)
                .selectProduct(product)
                .addToCart()
                .checkout()
                .hasProduct(product));

    }

}

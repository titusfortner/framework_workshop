package test.examples;

import org.junit.Test;
import test.BaseTest;
import test.data.User;
import test.pages.HomePage;
import test.pages.InventoryPage;

public class AmbivalentPOTest extends BaseTest {

    @Test
    public void ambivalentMethod()  {
        HomePage homePage = HomePage.visit(driver);
        User user = new User();

        homePage.signIn(user);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.selectFirstProduct();
    }

    @Test
    public void opinionatedMethod() throws Exception {
        HomePage homePage = HomePage.visit(driver);
        User user = new User();

        homePage.signInSuccessfully(user);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.selectFirstProduct();
    }
}

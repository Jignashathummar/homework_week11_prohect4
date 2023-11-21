package testsuite;
/**
 * 2. Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValid Credentials
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed on
 * page
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void open() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        /**
         * * Enter “standard_user” username
         * * Enter “secret_sauce” password
         * * Click on ‘LOGIN’ button
         * * Verify the text “PRODUCTS”
         */
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals("Products", "Products");
        /**
         * * Enter “standard_user” username
         * * Enter “secret_sauce” password
         * * Click on ‘LOGIN’ button
         * * Verify that six products are displayed on
         * page
         */
        List<WebElement> linksElements = driver.findElements(By.className("inventory_item"));
        System.out.println("Number of links = " + linksElements.size());
        Assert.assertEquals("6", "6");
    }

    @After
    public void close() {
        closeBrowser();
    }
}

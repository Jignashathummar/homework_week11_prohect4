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

    /**
     * * Enter “standard_user” username
     * * Enter “secret_sauce” password
     * * Click on ‘LOGIN’ button
     * * Verify the text “PRODUCTS”
     */
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals("User should successfully loged in with valid credentials","Products", driver.findElement(By.className("title")).getText());
    }

    /**
     * * Enter “standard_user” username
     * * Enter “secret_sauce” password
     * * Click on ‘LOGIN’ button
     * * Verify that six products are displayed on
     * page
     */
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        List<WebElement> linksElements = driver.findElements(By.className("inventory_item"));
        Assert.assertEquals("Verify that six products are displayed on page ",6, linksElements.size());
    }

    @After
    public void close() {
        closeBrowser();
    }
}
